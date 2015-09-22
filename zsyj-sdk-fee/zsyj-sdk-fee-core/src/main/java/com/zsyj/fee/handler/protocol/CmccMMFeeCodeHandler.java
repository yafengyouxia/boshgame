package com.zsyj.fee.handler.protocol;

import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zsyj.fee.common.HTTPForwarder;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneCode;
import com.zsyj.fee.vo.TroneConfigInfo;

/**
 * 移动MM计费代码解析模板
 * */
public class CmccMMFeeCodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(CmccMMFeeCodeHandler.class.getName());
	
	private String registSMSKey = "loginSms=";
	private String chargeSMSKey = "paySms=";
	
	@Override
	public void handler( FeeRequest feeRequest, SdkUser user, TroneConfigInfo troneConfig ) {
		
		try {
			
			String content = this.getProtocol( user, troneConfig );
			
			if( StringUtils.isNotBlank( content ) && content.indexOf( registSMSKey ) > -1 && content.indexOf( chargeSMSKey ) > -1 )
			{
				String loginSms = content.substring( content.indexOf( registSMSKey ) + registSMSKey.length(),  content.indexOf( chargeSMSKey ) ).trim();
				String paySms = content.substring( content.indexOf( chargeSMSKey ) + chargeSMSKey.length() ).trim();
				
				String orderId = this.getOrderId( );
				
				TroneCode loginCode = new TroneCode();
				TroneCode payCode = new TroneCode();
				
				loginCode.setTrone( troneConfig.getTrone() );
				loginCode.setCommand( URLEncoder.encode( loginSms, "utf8" ) );
				loginCode.setSleepTime( 68 );
				
				payCode.setOrderId( orderId );
				payCode.setTrone( troneConfig.getTrone( ) );
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
		try {
			byte[] contentBytes = HTTPForwarder.forward( "http://42.121.107.174:8384/?c=741049&s=760000012339&b=40085227726.001" );
			
			if( contentBytes != null && contentBytes.length > 0 )
			{
				content = new String( contentBytes );
				
				logger.info( "content:" + content );				
			}
		} 
		catch ( Exception e ) 
		{
			logger.error( e.getMessage() );
			e.printStackTrace();
		}
		return content;
	}
}