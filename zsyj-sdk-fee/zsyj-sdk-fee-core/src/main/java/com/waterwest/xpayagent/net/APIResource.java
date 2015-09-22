package com.waterwest.xpayagent.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.waterwest.xpayagent.WaterWest;
import com.waterwest.xpayagent.exception.APIConnectionException;
import com.waterwest.xpayagent.exception.APIException;
import com.waterwest.xpayagent.exception.AuthenticationException;
import com.waterwest.xpayagent.exception.InvalidRequestException;
import com.waterwest.xpayagent.model.Charge;
import com.waterwest.xpayagent.model.ChargeDeserializer;
import com.waterwest.xpayagent.model.WaterWestObject;
import com.waterwest.xpayagent.model.WaterWestRawJsonObject;
import com.waterwest.xpayagent.model.WaterWestRawJsonObjectDeserializer;


public abstract class APIResource extends WaterWestObject {

	public static final Gson GSON = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.registerTypeAdapter(Charge.class, new ChargeDeserializer())
			.registerTypeAdapter(WaterWestRawJsonObject.class, new WaterWestRawJsonObjectDeserializer())
			.create();
	
	private static String className(Class<?> clazz) {
		String className = clazz.getSimpleName().toLowerCase().replace("$", " ");

		if (className.equals("redenvelope")) {
			return "red_envelope";
		} else {
			return className;
		}
	}

	protected static String singleClassURL(Class<?> clazz) {
		return String.format("%s/v1/%s", WaterWest.getApiBase(), className(clazz));
	}

	protected static String classURL(Class<?> clazz) {
		return String.format("%ss", singleClassURL(clazz));
	}

	protected static String instanceURL(Class<?> clazz, String id) throws InvalidRequestException {
		try {
			return String.format("%s/%s", classURL(clazz), urlEncode(id));
		} catch (UnsupportedEncodingException e) {
			throw new InvalidRequestException("Unable to encode parameters to " + CHARSET, null, e);
		}
	}

	public static final String CHARSET = "UTF-8";

	protected enum RequestMethod {
		GET, POST, DELETE
	}

	private static String urlEncode(String str) throws UnsupportedEncodingException {
		// Preserve original behavior that passing null for an object id will lead
		// to us actually making a request to /v1/foo/null
		if (str == null) {
			return null;
		}
		else {
			return URLEncoder.encode(str, CHARSET);
		}
	}

	private static String urlEncodePair(String k, String v)
			throws UnsupportedEncodingException {
		return String.format("%s=%s", urlEncode(k), urlEncode(v));
	}

	static Map<String, String> getHeaders(String apiKey) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept-Charset", CHARSET);
		headers.put("User-Agent", String.format("WaterWest/v1"));

		if (apiKey == null) {
			apiKey = WaterWest.apiKey;
		}

		//headers.put("Authorization", String.format("Beer %s", apiKey));

		headers.put("Authorization", String.format("Wind %s", apiKey));
		return headers;
	}

	private static java.net.HttpURLConnection createPingppConnection(
			String url, String apiKey) throws IOException {
		URL pingppURL = new URL(url);
		java.net.HttpURLConnection conn = (java.net.HttpURLConnection) pingppURL.openConnection();
		conn.setConnectTimeout(15 * 1000);
		conn.setReadTimeout(60 * 1000);
		conn.setUseCaches(false);
		for (Map.Entry<String, String> header : getHeaders(apiKey).entrySet()) {
			conn.setRequestProperty(header.getKey(), header.getValue());
		}

		return conn;
	}

	private static String formatURL(String url, String query) {
		if (query == null || query.isEmpty()) {
			return url;
		} else {
			// In some cases, URL can already contain a question mark (eg, upcoming invoice lines)
			String separator = url.contains("?") ? "&" : "?";
			return String.format("%s%s%s", url, separator, query);
		}
	}

	private static java.net.HttpURLConnection createGetConnection(
			String url, String query, String apiKey) throws IOException, APIConnectionException {
		String getURL = formatURL(url, query);
		java.net.HttpURLConnection conn = createPingppConnection(getURL,
				apiKey);
		conn.setRequestMethod("GET");

		return conn;
	}

	private static java.net.HttpURLConnection createPostConnection(
			String url, String query, String apiKey) throws IOException, APIConnectionException {
		java.net.HttpURLConnection conn = createPingppConnection(url,
				apiKey);

		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", String.format(
				"application/x-www-form-urlencoded;charset=%s", CHARSET));

		OutputStream output = null;
		try {
			output = conn.getOutputStream();
			output.write(query.getBytes(CHARSET));
		} finally {
			if (output != null) {
				output.close();
			}
		}
		return conn;
	}

	private static String createQuery(Map<String, Object> params)
	    throws UnsupportedEncodingException, InvalidRequestException {
		Map<String, String> flatParams = flattenParams(params);
		StringBuilder queryStringBuffer = new StringBuilder();
		for (Map.Entry<String, String> entry : flatParams.entrySet()) {
			if (queryStringBuffer.length() > 0) {
				queryStringBuffer.append("&");
			}
			queryStringBuffer.append(urlEncodePair(entry.getKey(),
					entry.getValue()));
		}
		return queryStringBuffer.toString();
	}

	private static Map<String, String> flattenParams(Map<String, Object> params)
			throws InvalidRequestException {
		if (params == null) {
			return new HashMap<String, String>();
		}
		Map<String, String> flatParams = new HashMap<String, String>();
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof Map<?, ?>) {
				Map<String, Object> flatNestedMap = new HashMap<String, Object>();
				Map<?, ?> nestedMap = (Map<?, ?>) value;
				for (Map.Entry<?, ?> nestedEntry : nestedMap.entrySet()) {
					flatNestedMap.put(
							String.format("%s[%s]", key, nestedEntry.getKey()),
							nestedEntry.getValue());
				}
				flatParams.putAll(flattenParams(flatNestedMap));
			} else if (value instanceof ArrayList<?>) {
				ArrayList<?> ar = (ArrayList<?>) value;
				Map<String, Object> flatNestedMap = new HashMap<String, Object>();
				int size = ar.size();
				for (int i = 0; i < size; i++) {
					flatNestedMap.put(String.format("%s[%d]", key, i), ar.get(i));
				}
				flatParams.putAll(flattenParams(flatNestedMap));
			} else if ("".equals(value)) {
			    throw new InvalidRequestException("You cannot set '"+key+"' to an empty string. "+
							      "We interpret empty strings as null in requests. "+
							      "You may set '"+key+"' to null to delete the property.",
							      key, null);
			} else if (value == null) {
				flatParams.put(key, "");
			} else {
				flatParams.put(key, value.toString());
			}
		}
		return flatParams;
	}

	// represents Errors returned as JSON
	private static class ErrorContainer {
		private APIResource.Error error;
	}

	private static class Error {
		@SuppressWarnings("unused")
		String type;

		String message;

		String code;

		String param;
	}

	private static String getResponseBody(InputStream responseStream)
			throws IOException {
                //\A is the beginning of
                // the stream boundary
		String rBody = new Scanner(responseStream, CHARSET)
                        .useDelimiter("\\A")
			.next(); //

		responseStream.close();
		return rBody;
	}

	private static WaterWestResponse makeURLConnectionRequest(
			APIResource.RequestMethod method, String url, String query,
			String apiKey) throws APIConnectionException {
		java.net.HttpURLConnection conn = null;
		try {
			switch (method) {
			case GET:
				conn = createGetConnection(url, query, apiKey);
				break;
			case POST:
				conn = createPostConnection(url, query, apiKey);
				break;
			default:
				throw new APIConnectionException(
						String.format("Unrecognized HTTP method %s. ", method));
			}
                        // trigger the request
			int rCode = conn.getResponseCode();
			String rBody = null;
			Map<String, List<String>> headers;

			if (rCode >= 200 && rCode < 300) {
				rBody = getResponseBody(conn.getInputStream());
			} else {
				rBody = getResponseBody(conn.getErrorStream());
			}
			headers = conn.getHeaderFields();
			return new WaterWestResponse(rCode, rBody, headers);

		} catch (IOException e) {
			throw new APIConnectionException(
					String.format(
							"IOException during API request to Pingpp (%s): %s "
									+ "Please check your internet connection and try again. If this problem persists,"
									,WaterWest.getApiBase(), e.getMessage()), e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	protected static <T> T request(APIResource.RequestMethod method,
			String url, Map<String, Object> params, Class<T> clazz,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {

		return _request(method, url, params, clazz, apiKey);
	}

	protected static <T> T _request(APIResource.RequestMethod method,
			String url, Map<String, Object> params, Class<T> clazz,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		if ((WaterWest.apiKey == null || WaterWest.apiKey.length() == 0)
				&& (apiKey == null || apiKey.length() == 0)) {
			throw new AuthenticationException("No API key provided. set your fucking key");
		}

		if (apiKey == null) {
			apiKey = WaterWest.apiKey;
		}

		String query;

		try {
			query = createQuery(params);
		} catch (UnsupportedEncodingException e) {
			throw new InvalidRequestException("Unable to encode parameters to " + CHARSET, null, e);
		}

		WaterWestResponse response;
		try {
			response = makeURLConnectionRequest(method, url, query, apiKey);
		} catch (ClassCastException ce) {
			throw ce;
		}
		int rCode = response.responseCode;
		String rBody = response.responseBody;
		if (rCode < 200 || rCode >= 300) {
			handleAPIError(rBody, rCode);
		}
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(rBody, clazz);
		//return GSON.fromJson(rBody, clazz);
	}

	private static void handleAPIError(String rBody, int rCode)
			throws InvalidRequestException, AuthenticationException,
			APIException {
		//APIResource.Error error = GSON.fromJson(rBody,
		//		APIResource.ErrorContainer.class).error;
		APIResource.Error error = new APIResource.Error();
		switch (rCode) {
		case 400:
			throw new InvalidRequestException(error.message, error.param, null);
		case 404:
			throw new InvalidRequestException(error.message, error.param, null);
		case 401:
			throw new AuthenticationException(error.message);
		default:
			throw new APIException(error.message, null);
		}
	}

}
