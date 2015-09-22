package com.zsyj.fee.handler.protocol;

import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import com.zsyj.fee.common.Base64Utils;
import com.zsyj.fee.common.HTTPForwarder;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneCode;
import com.zsyj.fee.vo.TroneConfigInfo;

/**
 * 移动MM计费代码解析模板
 * */
public class CmccMMThorassistCodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(CmccMMThorassistCodeHandler.class.getName());
	
	private String orderId;
	
	@Override
	public void handler( FeeRequest feeRequest,  SdkUser user,  TroneConfigInfo troneConfig ) 
	{
		try 
		{
			String content = this.getProtocol( feeRequest, user, troneConfig );
			
			if( StringUtils.isNotBlank( content ) && content.indexOf( "sms" ) > -1 )
			{
				JSONObject jsonObj = new JSONObject(  content );
				
				String hRet = jsonObj.getString( "hRet" );
				
				if( "0".equals( hRet ) )
				{
					JSONObject feeObj = jsonObj.getJSONObject( "Fee" );
					String msg = feeObj.getString( "sms" );
					
					TroneCode payCode = new TroneCode();
					
					payCode.setOrderId( orderId );
					payCode.setTrone( feeObj.getString( "num" )==null?"10658422":feeObj.getString( "num" ) );
					
					if( StringUtils.isNotBlank( msg ) )
					{
						payCode.setCommand( Base64Utils.getFromBase64( msg ) );
						//payCode.setCommand( msg );
					}
					
					payCode.setCommand( URLEncoder.encode( payCode.getCommand(), "utf8" ) );
					
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
	
	private String getProtocol( FeeRequest feeRequest, SdkUser user, TroneConfigInfo troneConfig )
	{
		String content = null;
		try {
			
			JSONObject jsonObj = new  JSONObject( troneConfig.getCommand() );
			
			String url = "http://i.thorassist.com/init.php?type=606" +
					"&siteid={siteid}&codeid={codeid}&imsi={imsi}&imei={imei}&serial={orderId}&ip={ip}&ib=1&bs={bs}";
			
			orderId = "zh" + this.getOrderId( );
			
			url = url.replace( "{imsi}", user.getImsi() ).replace("{orderId}", orderId )
					.replace( "{codeid}", jsonObj.getString( "codeid" ) ).replace( "{siteid}", jsonObj.getString( "siteid" ) )
					.replace( "{imei}", user.getImei()==null?"":user.getImei() )
					.replace( "{ip}", feeRequest.getRequestIp() ).replace( "{bs}", feeRequest.getBscLac() );
			
			byte[] contentBytes = HTTPForwarder.forward( url );
			
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