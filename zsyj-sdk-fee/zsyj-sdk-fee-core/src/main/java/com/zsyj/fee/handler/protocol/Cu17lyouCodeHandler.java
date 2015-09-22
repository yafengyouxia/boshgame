package com.zsyj.fee.handler.protocol;

import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import com.zsyj.fee.common.HTTPForwarder;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneCode;
import com.zsyj.fee.vo.TroneConfigInfo;

/**
 * 移动MM计费代码解析模板
 * */
public class Cu17lyouCodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(Cu17lyouCodeHandler.class.getName());
	
	@Override
	public void handler( FeeRequest feeRequest,  SdkUser user,  TroneConfigInfo troneConfig ) 
	{
		try {
			
			String content = this.getProtocol( feeRequest, user, troneConfig );
			
			if( StringUtils.isNotBlank( content ) )
			{
				String orderId = this.getOrderId( );
				
				TroneCode payCode = new TroneCode();
				
				payCode.setOrderId( orderId );
				payCode.setCommand( URLEncoder.encode( content, "utf8" ) );
				payCode.setTrone( "10655198000" );
				
				troneConfig.getCodeList().add( payCode );
				troneConfig.setOrderId( orderId );
			}
		} 
		catch ( Exception e ) 
		{
			logger.error( e.getMessage() );
			e.printStackTrace();
		}
	}
	
	private String getProtocol( FeeRequest feeRequest, SdkUser user, TroneConfigInfo troneConfig )
	{
		String content = null;
		try {
			
			JSONObject jsonObj = new  JSONObject( troneConfig.getCommand() );
			
			StringBuffer sb = new StringBuffer( "http://www.17lyou.com/ unicome/get?cmd=3&imsi=" );
			sb.append( user.getImsi() ).append( "&imei=" ).append( user.getImei() )
				.append( "&price=" ).append( jsonObj.getString( "price" ) )
			.append( "&g=" ).append( jsonObj.getString( "g" ) ).append( "&f=" ).append( jsonObj.getString( "f" ) );
			
			byte[] contentBytes = HTTPForwarder.forward( sb.toString() );
			
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