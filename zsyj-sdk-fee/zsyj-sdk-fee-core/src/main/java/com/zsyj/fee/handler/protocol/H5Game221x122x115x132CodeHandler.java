package com.zsyj.fee.handler.protocol;

import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import com.zsyj.fee.common.HTTPForwarder;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneCode;
import com.zsyj.fee.vo.TroneConfigInfo;

/**
 * 和游戏单机计费代码解析模板
 * */
public class H5Game221x122x115x132CodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(H5Game221x122x115x132CodeHandler.class.getName());

	private String orderId = "";
	
	@Override
	public void handler( FeeRequest feeRequest, SdkUser user, TroneConfigInfo troneConfig ) {
		
		try {
			
			orderId = this.getOrderId( );
			
			String content = this.getProtocol(user, troneConfig);
			
			if( StringUtils.isNotBlank( content ) )
			{
				TroneCode loginCode = new TroneCode();
				
				loginCode.setOrderId( orderId );
				loginCode.setTrone( "106584221" );
				loginCode.setCommand( URLEncoder.encode( content + orderId, "utf8" ) );
				loginCode.setSleepTime( 30 );
				
				troneConfig.getCodeList().add( loginCode );
				troneConfig.setOrderId( orderId );
			}
		}
		catch ( Exception e ) 
		{
			logger.error( e.getMessage() );
			e.printStackTrace();
		}
	}
	
	private String getProtocol( SdkUser user, TroneConfigInfo troneConfig )
	{
		String content = null;
		
		try 
		{
			JSONObject jsonObj = new  JSONObject( troneConfig.getCommand() );
			
			String url = "http://221.122.115.132:7777/sync{sync}/getsms.do?otid={otid}&pseudocode={pseudocode}";
			
			url = url.replace( "{sync}", jsonObj.getString("chargeId") )
					.replace( "{otid}", jsonObj.getString("otid") )
					.replace( "{pseudocode}", jsonObj.getString("pseudocode") );
			
			logger.info( "url:" + url );
			
			byte[] contentBytes = HTTPForwarder.forward( url );
			if( contentBytes != null && contentBytes.length > 0 )
			{
				content =  new String( contentBytes );
				logger.info( "content:" + content );
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return content;
	}
	
}