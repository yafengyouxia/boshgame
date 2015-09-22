package com.zsyj.fee.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HTTPForwarder {

	protected static final Logger logger = LoggerFactory
			.getLogger(HTTPForwarder.class);
	
	public static String replaceStr(String str) {
		if (!StringUtils.isEmpty(str)) {
			str = str.replaceAll("%", "");
			str = str.replaceAll("'", "");
			str = str.replaceAll("&", "");
			str = str.replaceAll("_", "");
			str = str.replaceAll("~", "");
			str = str.replaceAll("@", "");
			str = str.replaceAll("#", "");
			str = str.replaceAll("$", "");
			str = str.replaceAll("^", "");
			str = str.replaceAll("\\*", "");
			str = str.replaceAll("\\(", "");
			str = str.replaceAll("\\)", "");
			str = str.replaceAll("\\?", "");
			str = str.replaceAll(",", "");
			str = str.replaceAll("\\.", "");
			str = str.replaceAll("/", "");
			str = str.replaceAll("\\\\", "");
			str = str.replaceAll("|", "");
			str = str.replaceAll("\\[", "");
			str = str.replaceAll("\\]", "");
			str = str.replaceAll("\\{", "");
			str = str.replaceAll("\\}", "");
			str = str.replaceAll("[^\u4E00-\u9FA5|0-9|a-z|A-Z]","");
		}
		return str;
	}
	
	/**
	 * 将url参数中包含的值解析为key--value映射关系
	 * @param url
	 * */
	public static Map<String, String> getParamValue( String url )
	{
		Map<String, String> paramMap = new HashMap<String ,String>();
		
		int index = 0;
		
		if( ( index = url.indexOf ( "?" ) ) > 0 )
		{
			url = url.substring ( index + 1 );
			
			String[] entryList = null;
			
			if( url.indexOf ( "&amp;" ) > -1 )
			{
				entryList = url.split ("&amp;");
			}
			else
			{
				entryList = url.split ("&");
			}
			
			if( entryList != null )
			{
				String key = null;
				String value = null;
				String[] tmp = null;
				for( String entry : entryList )
				{
					tmp = entry.split ("=");
					if( tmp != null && tmp.length == 2 )
					{
						key = tmp[0];
						value = tmp[1];	
						paramMap.put (key, value);
					}
				}
			}
		}
		
		return paramMap;
	}
	
	/**
	 * 根据url地址进行转发
	 * 
	 * @param url
	 * @param httGet
	 *            转发的头信息参数
	 * */
	public static byte[] forward( String url, HttpGet get )
	{
		byte[] returnBytes = null;
		InputStream is = null;
		ByteArrayOutputStream bos = null;
		HttpClient client = HttpConnectionManager.getHttpClient ();
		
		if( get != null )
		{
			try 
			{
				url = url.replace (" ", "").replace ("&amp;", "&");	//将空格截断
				
				get.setURI( new URI( url ) );
				
				HttpResponse response = client.execute (get);
				
				if ( response.getStatusLine ().getStatusCode () != 200 )
				{
					get.abort ();
					logger.error( "the response is error, statusCode : " + response.getStatusLine ().getStatusCode () );
					return null;
				}
				
				HttpEntity entity = response.getEntity ();
				if (entity != null)
				{
					is = entity.getContent ();
					bos = new ByteArrayOutputStream ();
					byte[] data = new byte[1];
					while (is.read (data) > 0)
					{
						bos.write (data);
					}
					returnBytes = bos.toByteArray ();
				}
			}
			catch ( Exception e ) 
			{
				get.abort ();
				logger.error ( "url error[" + url + "]  error message:" + e.getMessage (), e);
				e.printStackTrace ();
			}
			finally
			{
				feeStream (is, bos);
			}
		}
			
		return returnBytes;
	}
	
	/**
	 * 根据url地址进行转发
	 * 
	 * @param url
	 * @param headParams
	 *            转发的头信息参数
	 * */
	public static byte[] forward( String url ) {
		
		HttpGet get = new HttpGet ();
		return forward( url, get );
	}
	
	private static void feeStream( InputStream is, ByteArrayOutputStream bos )
	{
		if (is != null)
		{
			try
			{
				is.close ();
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}
		if (bos != null)
		{
			try
			{
				bos.close ();
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}
	}
	
	public static void main( String args [] )
	{	
		HttpClient client = HttpConnectionManager.getHttpClient();
		HttpPost post = new HttpPost();
		
		post.setHeader( "user-agent", "NokiaN70/3.0544.5.2 Series60/2.8 Profile/MIDP-2.0 Configuration/CLDC-1.1" );
		post.setHeader( "x-up-bear-type", "GPRS/EDGE" );
		post.setHeader( "via", "ZXWAP GateWay,ZTE Technologies" );
		post.setHeader( "Accept", "application/vnd.wap.wmlscriptc, text/vnd.wap.wml, application/vnd.wap.xhtml+xml, application/xhtml+xml, text/html, multipart/mixed, */*, text/x-vcard, text/x-vcalendar, image/gif, image/vnd.wap.wbmp" );
		post.setHeader( "Accept-Language", "zh-CN" );
		post.setHeader( "Accept-Charset", "ISO-8859-1, US-ASCII, UTF-8; Q=0.8, ISO-10646-UCS-2; Q=0.6" );
		post.setHeader( "Content-Type", "application/x-www-form-urlencoded" );
		
		try {
			
			String url = "http://127.0.0.1:8080/sz5z-fee/ahbohaiMo.jsp";
			
			url += "?mobile=15899756538&linkid=865413&momsg=CM&spnum=1000798324";
			
//			post.setURI(new URI("http://211.136.165.53/cont/500/492/833.jsp"));
			post.setURI(new URI( url ));
//			post.setURI(new URI("http://127.0.0.1:8080/test/zhongxinzebookwapServer.jsp"));
			
			
			//建立HttpPost对象   
	        //List<NameValuePair> params=new ArrayList<NameValuePair>();  
	        //建立一个NameValuePair数组，用于存储欲传送的参数   
	        // params.add(new BasicNameValuePair("2+4=?","2+4=?"));  
	       
			//添加参数 
			/**
	        String testStr = "HTTP/1.1 302 Moved temporarily"
				+ "Content-length: 0"
				+ "Content-Type: text/vnd.wap.wml;charset=UTF-8"
				+ "Date: Wed, 07 Dec 2011 08:44:57 GMT"
				+ "Server: Apache-Coyote/1.1"
				+ "Location: http://211.136.165.53/cont/500/492/833.jsp"
				+ "Set-Cookie: JSESSIONID=693C0378804C4DF6AA31C2E60491576B; Path=/jump";
	        
	        post.setEntity( new ByteArrayEntity ( testStr.getBytes() ) );  
			*/
			
	        HttpResponse response = client.execute(post);
			
	        printContent( response );
	        
//			FileOutputStream fos = new FileOutputStream( new File( "d:/test.txt" ) );
//			FileWriter fos = new FileWriter( new File( "d:/test.txt" ) );
//			fos.write( returnBytes );
//			fos.close();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void printContent(  HttpResponse response ) throws IllegalStateException, IOException
	{
		byte[] returnBytes = null;
		InputStream is = null;
		ByteArrayOutputStream bos = null;
        StatusLine statusLine = response.getStatusLine();
	       
        System.out.println( "@@@reasonPhrase(): " +statusLine.getReasonPhrase() );
        System.out.println( "@@@statusCode(): " + statusLine.getStatusCode() );
        System.out.println( "@@@protocolVersion(): " + statusLine.getProtocolVersion() );
        
        Header[] headers = response.getAllHeaders();
        for( Header header : headers )
        {
        	System.out.println( "header key:[" + header.getName() + "] value:[" + header.getValue() + "]" );
        }
        
		HttpEntity entity = response.getEntity();
		
		if (entity != null) {
			is = entity.getContent();
			bos = new ByteArrayOutputStream();
			byte[] data = new byte[1];
			while (is.read(data) > 0) {
				bos.write(data);
			}
			returnBytes = bos.toByteArray();
		}
		
		System.out.println( "============== content ===============" );
		System.out.println( new String( returnBytes ) );
	}
}
