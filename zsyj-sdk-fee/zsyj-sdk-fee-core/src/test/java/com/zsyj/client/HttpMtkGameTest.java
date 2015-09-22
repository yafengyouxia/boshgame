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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.client.sdk.HttpSynOrderResultTest;
import com.zsyj.fee.common.HttpConnectionManager;
import com.zsyj.fee.handler.HttpResponseHandler;
import com.zsyj.fee.threadpool.AsynHttpJob;
import com.zsyj.fee.threadpool.OrderLogJob;
import com.zsyj.fee.threadpool.SdkThreadPool;

public final class HttpMtkGameTest {

	protected static final Logger logger = LoggerFactory.getLogger(HttpSynOrderResultTest.class);
	
	public static void main( String args[] )
	{	
		HttpMtkGameTest forwardTest = new HttpMtkGameTest();
		HttpPost post = new HttpPost();
		
		try
		{
			StringEntity reqEntity = new StringEntity( 
					 "<request>"
					 + "<userId>1106142458</userId>"
					 + "<contentId>604516023605</contentId>"
					 + "<consumeCode>006055585012</consumeCode>"
					 + "<cpid>701597</cpid>"
					 + "<hRet>0</hRet>"
					 + "<status>1800</status>"
					 + "<versionId>21007</versionId>"
					 + "<cpparam>0000011084507155</cpparam>"
					 + "<packageID />"
					 + "</request>"
			);
			
			post.setEntity( reqEntity );
			
			String url = "http://sdk001.yxsgapk.com:8899/income/syn1010_zhixuankeji.jsp";

			forwardTest.send(post, url);
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
	
	private void sendMrRequest( HttpPost post ) throws URISyntaxException, UnsupportedEncodingException
	{
		String url = "http://121.197.10.107/sdk/syn/syn10002ms_xml.jsp";
		
		String bodyContent = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<request><cid>5002</cid><price>200</price><imei>864046005686835</imei><imsi>460000280910577</imsi>"
				+ "<feetype>2</feetype><province>山东</province><resulttime>2014-05-26 14:21:33</resulttime>"
				+ "<returncode>0</returncode><returnmsg>成功</returnmsg><transid>10000000005722</transid>"
				+ "<uniqueid>C26C60FDCC1324D2A90E7C387FC154B19</uniqueid><cpserverparam>26C60FDCC1324D2A90E7C387FC154B29</cpserverparam>"
				+ "<appid>00002</appid><pupchannelid>00103</pupchannelid>" + "</request>";
		
		post.setEntity(new StringEntity(bodyContent));
		
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
