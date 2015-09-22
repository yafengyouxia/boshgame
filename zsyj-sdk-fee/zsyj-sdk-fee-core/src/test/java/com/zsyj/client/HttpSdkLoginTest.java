package com.zsyj.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.HttpConnectionManager;

public final class HttpSdkLoginTest {

	protected static final Logger logger = LoggerFactory.getLogger(HttpSdkLoginTest.class);
	
	public static void main( String args[] )
	{	
		HttpSdkLoginTest forwardTest = new HttpSdkLoginTest();
		HttpGet get = forwardTest.createCommomHeader();
		try
		{
			//String url = "http://127.0.0.1/login";
			
			get.setHeader( "itemCode", "1" );
			String url = "http://sdk001.yxsgapk.com:8899/pay?pay=200&ShopId=1";
			
			forwardTest.send(get, url);
		}
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
	}
	
	private void send( HttpGet get, String url ) throws URISyntaxException
	{
		HttpClient client = HttpConnectionManager.getHttpClient();
		try
		{
			get.setURI(new URI( url ));
			
	        HttpResponse response = client.execute(get);
	        this.printContent( response );	
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	private HttpGet createCommomHeader()
	{
		HttpGet get = new HttpGet();
		get.setHeader( "sid", "101" );
		get.setHeader( "cid", "999" );
		get.setHeader( "appid", "10001" );
		get.setHeader( "cpid", "1001" );
		get.setHeader( "imsi", "460028893478511" );
		get.setHeader( "imei", "866172020344776" );
		get.setHeader( "sdkver", "1.0" );
		get.setHeader( "phonemodel", "MI 2S" );
		get.setHeader( "android_version", "4.1.1" );
		get.setHeader( "uuid", "83a4e80e-7bb0-4dc6-b711-54da1925796b" );
		get.setHeader( "phonemodel", "MI 2S" );
		return get;
	}
	
	private void printContent(  HttpResponse response ) throws IllegalStateException, IOException
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
