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
public class CmccGame121x42x220x79CodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(CmccGame121x42x220x79CodeHandler.class.getName());

	private String orderId = "";
	private String smsKey = "####";
	
	@Override
	public void handler( FeeRequest feeRequest, SdkUser user, TroneConfigInfo troneConfig ) {
		
		try {
			
			orderId = this.getOrderId( );
			
			String content = this.getProtocol(user, troneConfig);
			
			if( StringUtils.isNotBlank( content ) && content.indexOf( smsKey ) > -1 )
			{
				String[] contentList = content.split( smsKey );
				
				if( contentList != null && contentList.length >= 4 )
				{
					TroneCode loginCode = new TroneCode();
					TroneCode payCode = new TroneCode();
					
					loginCode.setOrderId( orderId );
					loginCode.setTrone( contentList[0] );
					loginCode.setCommand( URLEncoder.encode( contentList[1], "utf8" ) );
					loginCode.setSleepTime( 35 );
					
					payCode.setTrone( contentList[2] );
					payCode.setCommand( URLEncoder.encode( contentList[3], "utf8" ) );
					
					troneConfig.getCodeList().add( loginCode );
					troneConfig.getCodeList().add( payCode );
					troneConfig.setOrderId( orderId );
				}
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
			
			String url = "http://121.42.220.79:8080/s/cmgame/getSms/{chargeId}?"
					+ "imsi={imsi}&imei={imei}";
			
			url = url.replace( "{chargeId}", jsonObj.getString("chargeId") )
					.replace( "{imsi}", user.getImsi()).replace("{imei}", user.getImei() );
			
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