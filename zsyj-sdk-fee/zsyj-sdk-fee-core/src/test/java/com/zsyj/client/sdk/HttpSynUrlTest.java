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
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.HttpConnectionManager;

public class HttpSynUrlTest {

	protected static final Logger logger = LoggerFactory.getLogger(HttpSynUrlTest.class);
	
	public static void main( String args[] )
	{
		HttpSynUrlTest forwardTest = new HttpSynUrlTest();
		
		HttpPost post = new HttpPost();
		
		try
		{
			StringEntity reqEntity = new StringEntity( "<?xml version=\"1.0\" encoding=\"UTF-8\"?><SyncAppOrderReq xmlns=\"http://www.monternet.com/dsmp/schemas/\"><TransactionID>CSSP19273354</TransactionID><MsgType>SyncAppOrderReq</MsgType><Version>1.0.0</Version><Send_Address><DeviceType>200</DeviceType><DeviceID>CSSP</DeviceID></Send_Address><Dest_Address><DeviceType>1002</DeviceType><DeviceID>f0_0</DeviceID></Dest_Address><OrderID>00000000000000000000</OrderID><CheckID>0</CheckID><ActionTime>20150716225619</ActionTime><ActionID>1</ActionID><MSISDN></MSISDN><FeeMSISDN>0841D03B6FC5F087</FeeMSISDN><AppID>300008993672</AppID><PayCode>30000899367201</PayCode><TradeID>5069BE41D4</TradeID><Price>0</Price><TotalPrice>1000</TotalPrice><SubsNumb>1</SubsNumb><SubsSeq>1</SubsSeq><ChannelID>2200160625</ChannelID><ExData>LY03385461013\"5461013</ExData><OrderType>1</OrderType><MD5Sign></MD5Sign><OrderPayment>1</OrderPayment></SyncAppOrderReq>" );
			post.setEntity( reqEntity );
			
			String url = "http://182.254.155.254:8080/recharge/reCharge/mm18cb";
			
			forwardTest.send( post, url );
		}
		catch ( Exception e ) 
		{
			e.printStackTrace();
			logger.error( e.getMessage() );
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
