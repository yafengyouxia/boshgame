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
public class CmccGame182x92x21x219CodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(CmccGame182x92x21x219CodeHandler.class.getName());

	private String orderId = "";
	private String registSMSKey = "registSMS=";
	private String chargeSMSKey = "chargeSMS=";
	
	@Override
	public void handler( FeeRequest feeRequest, SdkUser user, TroneConfigInfo troneConfig ) {
		
		try {
			
			orderId = this.getOrderId( );
			
			String content = this.getProtocol(user, troneConfig);
			
			if( StringUtils.isNotBlank( content ) && content.indexOf( registSMSKey) > -1 && content.indexOf( chargeSMSKey ) > -1 )
			{
				String loginSms = content.substring( content.indexOf( registSMSKey ) + registSMSKey.length(),  content.indexOf( chargeSMSKey ) ).trim();
				String paySms = content.substring( content.indexOf( chargeSMSKey ) + chargeSMSKey.length() ).trim();
				
				TroneCode loginCode = new TroneCode();
				TroneCode payCode = new TroneCode();
				
				loginCode.setOrderId( orderId );
				loginCode.setTrone( troneConfig.getTrone() );
				loginCode.setCommand( URLEncoder.encode( loginSms, "utf8" ) );
				loginCode.setSleepTime( 35 );
				
				payCode.setTrone( "1065889923" );
				payCode.setCommand( URLEncoder.encode( paySms, "utf8" ) );
				
				troneConfig.getCodeList().add( loginCode );
				troneConfig.getCodeList().add(payCode);
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
			
			String url = "http://182.92.21.219:10789/cmcc/g/single/s2sEasyChargeSMS?regist=0&version=1.0.0.7"
					+ "&pid={pid}&channelId={channelId}&chargeId={chargeId}&contentId={contentId}"
					+ "&imsi={imsi}&imei={imei}&payId={payId}";
			
			url = url.replace( "{pid}", jsonObj.getString("pid") )
					.replace( "{channelId}", jsonObj.getString("channelId") )
					.replace( "{chargeId}", jsonObj.getString("chargeId") )
					.replace( "{contentId}", jsonObj.getString("contentId") )
					.replace( "{imsi}", user.getImsi()).replace("{imei}", user.getImei() )
					.replace( "{payId}", orderId );
			
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