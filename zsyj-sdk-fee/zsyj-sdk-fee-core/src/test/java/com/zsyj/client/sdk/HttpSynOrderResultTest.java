package com.zsyj.client.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

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

public final class HttpSynOrderResultTest {

	protected static final Logger logger = LoggerFactory.getLogger(HttpSynOrderResultTest.class);
	
	public static void main( String args[] )
	{	
		HttpSynOrderResultTest forwardTest = new HttpSynOrderResultTest();
		
		HttpPost post = new HttpPost();
		
		try
		{
			String appid = "300009109602";
			String payCode = "30000910960203";
			String channelId = "5498899";
			String orderId = "53917393";
			
			StringEntity reqEntity = new StringEntity( 
					"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" 
					+ "<SyncAppOrderReq xmlns=\" http://www.monternet.com/dsmp/schemas/\">"
					+ "<TransactionID>CSSP12648366</TransactionID>"
					+ "<MsgType>SyncAppOrderReq</MsgType>"
					+ "<Version>1.0.0</Version>"
					+ "<Send_Address>"
					+ "<DeviceType>200</DeviceType>"
					+ "<DeviceID>CSSP</DeviceID>"
					+ "</Send_Address>"
					+ "<Dest_Address>"
					+ "<DeviceType>400</DeviceType>"
					+ "<DeviceID>SPSYN</DeviceID>"
					+ "</Dest_Address>"
					//+ "<OrderID>00000000000000000000</OrderID>"
					+ "<OrderID>11150907152507501511</OrderID>"
					//+ "<OrderID>11150709" + Calendar.getInstance().getTimeInMillis() + "</OrderID>"
					+ "<CheckID>0</CheckID>"
					+ "<ActionTime>20150907152507</ActionTime>"
					+ "<ActionID>1</ActionID>"
					+ "<MSISDN></MSISDN>"
					+ "<FeeMSISDN>2263FC84CB9ED041</FeeMSISDN>"
					+ "<AppID>" + appid + "</AppID>"
					+ "<PayCode>" + payCode + "</PayCode>"
					+ "<TradeID>382BE31C22</TradeID>"
					+ "<Price>100</Price>"
					+ "<TotalPrice>100</TotalPrice>"
					+ "<SubsNumb>1</SubsNumb>"
					+ "<SubsSeq>1</SubsSeq>"
					+ "<ChannelID>2200160625</ChannelID>"
					+ "<ExData>1537_aaoxieil _532180830\"5498898</ExData>"
					+ "<OrderType>1</OrderType>"
					+ "<MD5Sign>53F07D15733204742D6CF782D4548430</MD5Sign>"
					+ "</SyncAppOrderReq>"
			);
			
			post.setEntity( reqEntity );
			
			String url = "http://112.74.83.72:8880/sdkpay/syn/callback.jsp";
			
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
