package com.zsyj.client;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.HttpConnectionManager;

public final class HttpPayTest {

	protected static final Logger logger = LoggerFactory.getLogger(HttpPayTest.class);
	
	public static void main( String args[] )
	{	
		long startTime = System.currentTimeMillis();
		
		HttpPayTest forwardTest = new HttpPayTest();
		HttpGet get = forwardTest.createCommomHeader();
		
		try
		{
			//sdk.boshgame.com
			String url = "http://sdk.boshgame.com:8880/sdkpay/pay?pay=1000";
			
			forwardTest.send(get, url);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		
		
		System.out.println( "cost time :" + ( System.currentTimeMillis() - startTime ) );
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
		get.setHeader( "sid", "2003" );
		get.setHeader( "cid", "101" );
		get.setHeader( "appid", "10002" );
		get.setHeader( "cpid", "5006" );
		get.setHeader( "imsi", "460003006702964" );
		get.setHeader( "imei", "864819029366950" );
		get.setHeader( "sdkver", "1.0" );
		get.setHeader( "phonemodel", "MI 2S" );
		get.setHeader( "android_version", "4.1.1" );
		get.setHeader( "uuid", "eb1ba210-6d18-4369-a875-09605fc2fae6" );
		get.setHeader( "phonemodel", "Coolpad 8720L" );
		get.setHeader( "itemPrice", "10.0" );
		get.setHeader( "itemCode", "fgfh" );
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
		String content = "";
		
		if (entity != null) {
			is = entity.getContent();
			bos = new ByteArrayOutputStream( );
			byte[] data = new byte[1];
			while (is.read(data) > 0) {
				bos.write(data);
			}
			content = bos.toString();
		}
		
		System.out.println( "============== content ===============" );
		System.out.println( content );
		System.out.println( new String( content.getBytes( ), "utf-8") );
		
		appendMethodB( "d:/test.txt", new String( content.getBytes( ), "utf-8") );
	}
	
	/** 
     * B方法追加文件：使用FileWriter 
     */  
    public static void appendMethodB(String fileName, String content) {  
        try {  
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
            FileWriter writer = new FileWriter(fileName, true);  
            writer.write(content);  
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
    }  
}
