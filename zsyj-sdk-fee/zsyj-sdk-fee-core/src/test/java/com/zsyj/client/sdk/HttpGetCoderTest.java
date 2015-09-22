package com.zsyj.client.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.HttpConnectionManager;

public final class HttpGetCoderTest {

	protected static final Logger logger = LoggerFactory.getLogger(HttpGetCoderTest.class);
	
	public static void main( String args[] )
	{	
		HttpGetCoderTest forwardTest = new HttpGetCoderTest();
		
		HttpPost post = new HttpPost();
		
		try
		{
			String url = "http://112.74.83.72:8880/sdkpay/codeService.jsp?" +
					"imsi=460004014262556" +
					"&sid=de68ad65a7dcf01d76926374aa95ac2c&paycode=30000899562611" +
					"&app_id=300008995626&channel_id=625001" +
					"&operation=102" +
					"&imei=865308021063756" +
					"&ip=10.10.10.1&gps_lng=36.6392380000&gps_lat=91.9407440000&province=5rKz5Y2X&city=6YOR5bee&bsc_lac=37143&bsc_cid=40021";
			
			forwardTest.send( post, url );
		}
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
	}
	
	private void send( HttpPost post, String url ) throws URISyntaxException
	{
		HttpClient client = HttpConnectionManager.getHttpClient();
		try
		{
			post.setURI(new URI( url ));
			
	        HttpResponse response = client.execute(post);
	        this.printContent( response );	
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
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
