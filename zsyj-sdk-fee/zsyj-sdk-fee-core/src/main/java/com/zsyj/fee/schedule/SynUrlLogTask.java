package com.zsyj.fee.schedule;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Date;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.HttpConnectionManager;
import com.zsyj.fee.entity.SdkSynurlLog;
import com.zsyj.fee.service.SdkSynUrlLogService;
import com.zsyj.fee.service.impl.SdkSynUrlLogServiceImpl;

/**
 * 向通道同步订单结果日志
 * @author ROOT
 */
public class SynUrlLogTask extends AbstractScheduleTask{

	private static final Logger logger = LoggerFactory.getLogger(SynUrlLogTask.class);
	
	private SdkSynUrlLogService sdkSynUrlLogService = SdkSynUrlLogServiceImpl.getInstance();
	
	public SynUrlLogTask(long delay, long interval) {
		super(delay, interval);
	}

	@Override
	public void work() {
		
		try
		{
			List<SdkSynurlLog> logList = sdkSynUrlLogService.find( (byte)0, 300 );
			
			handlerLogList( logList );
			
			logList = sdkSynUrlLogService.find( (byte)1, 300 );
			
			handlerLogList( logList );
		}
		catch( Exception e )
		{
			e.printStackTrace();
			logger.error( "SynUrlLogTaskError:" + e.getMessage() );
		}
	}
	
	private void handlerLogList( List<SdkSynurlLog> logList )
	{
		if( logList != null && logList.size() > 0 )
		{
			logger.info( " ============ start synchronize the log url ... ... " );
			
			for( SdkSynurlLog log : logList )
			{
				this.handlerLog( log );
			}
			
			logger.info( "end synchronize the log data ... ... " );
		}
	}
	
	/** 统计渠道当天的数据 */
	private void handlerLog( SdkSynurlLog log )
	{
		HttpResponse response = null;
		
		logger.info( "syn url id :" + log.getId() );
		
		try
		{
			HttpPost post = new HttpPost();
			StringEntity reqEntity = new StringEntity( log.getPostBody() );
			post.setEntity( reqEntity );
			
			HttpClient client = HttpConnectionManager.getHttpClient();
			post.setURI( new URI( log.getSynUrl() ) );
			
	        response = client.execute(post);
	        StatusLine statusLine = response.getStatusLine();
	        if( "OK".equals( statusLine.getReasonPhrase() ) || 200 == statusLine.getStatusCode() )
	        {
	        	log.setStatus( (byte)1 );
	        }
	        else
	        {
	        	logger.error( "synchronize url is error : " + statusLine.getStatusCode() );
	        	
	        	printContent( response );
	        	
	        	log.setStatus( (byte)2 );
	        }
		}
		catch( Exception e )
		{
			log.setStatus( (byte)2 );
			e.printStackTrace();
			logger.error( e.getMessage() );
		}
		finally {  
            try {  
                if (response != null) {  
                    response.getEntity().getContent().close();
                }  
            } catch ( Exception e ) {  
                logger.error( e.getMessage() );  
            }
		}
		
		log.setCompleteTime( new Date() );
		this.sdkSynUrlLogService.update(log);
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
