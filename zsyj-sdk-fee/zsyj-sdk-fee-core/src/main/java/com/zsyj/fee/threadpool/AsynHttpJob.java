
package com.zsyj.fee.threadpool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.HttpConnectionManager;
import com.zsyj.fee.handler.HttpResponseHandler;

public class AsynHttpJob implements Runnable{

	protected static final Logger logger = LoggerFactory.getLogger(AsynHttpJob.class);
	
	private String mUrl = "";
	private HttpPost mPost = null;
	private HttpGet mGet = null;
	private HttpResponseHandler mResponseHanlder;
	
	private AsynHttpJob( ) { }
	
	public AsynHttpJob( String url, HttpPost post, HttpResponseHandler responseHanlder )
	{
		this.mUrl = url;
		this.mPost = post;
		this.mResponseHanlder = responseHanlder;
	}
	
	public AsynHttpJob( String url, HttpGet get, HttpResponseHandler responseHanlder )
	{
		this.mUrl = url;
		this.mGet = get;
		this.mResponseHanlder = responseHanlder;
	}
	
	@Override
	public void run(  ) {
		
		HttpResponse response = null;
		HttpClient client = HttpConnectionManager.getHttpClient();
		
		try
		{
			if( this.mPost != null )
			{
				mPost.setURI(new URI( mUrl ));
		        response = client.execute(mPost);
			}
			else if( this.mGet != null )
			{
				mGet.setURI(new URI( mUrl ));
		        response = client.execute(mGet);
			}
			
			this.printContent( response );
			this.mResponseHanlder.handler(response);
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
	    
        StringBuffer sb = new StringBuffer();
        
        sb.append( "@@@reasonPhrase(): " +statusLine.getReasonPhrase() ) 
        		.append( "\r\n @@@statusCode(): " + statusLine.getStatusCode() ) 
        		.append( "\r\n @@@protocolVersion(): " + statusLine.getProtocolVersion() );
        
        Header[] headers = response.getAllHeaders();
        for( Header header : headers )
        {
        	sb.append( "header key:[" + header.getName() + "] value:[" + header.getValue() + "] \r\n" );
        }
        
        logger.info( sb.toString() );
        
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
		
		logger.info( "============== content ===============\r\n" + new String( returnBytes ) );
	}
}
