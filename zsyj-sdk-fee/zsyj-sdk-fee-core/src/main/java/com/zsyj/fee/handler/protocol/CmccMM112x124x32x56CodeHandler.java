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
public class CmccMM112x124x32x56CodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(CmccMM112x124x32x56CodeHandler.class.getName());
	
	private String orderId = "";
	
	@Override
	public void handler( FeeRequest feeRequest,  SdkUser user,  TroneConfigInfo troneConfig ) 
	{
		try 
		{
			String content = this.getProtocol( feeRequest, user, troneConfig );
			
			if( StringUtils.isNotBlank( content ) && content.indexOf( "content" ) > -1 && content.indexOf( "smstype" ) > -1 )
			{
				JSONObject jsonObj = new JSONObject(  content );
				
				String smstype = jsonObj.getString( "smstype" );
				String msgContent = jsonObj.getString( "content" );
				String trone = jsonObj.getString( "dest" );
				
				TroneCode payCode = new TroneCode();
				
				payCode.setOrderId( orderId );
				payCode.setTrone( trone==null?"10658422":trone );
				
				if( "text".equals(smstype) )
				{
					payCode.setCommand( msgContent );
				}
				else if( "data".equals(smstype) )
				{
					payCode.setEncode( "base64" );
					payCode.setCommand( msgContent );
				}
					
				payCode.setCommand( URLEncoder.encode( payCode.getCommand(), "utf8" ) );
				
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
			
			String url = "http://112.124.32.56:8088/request_sms?channel=urlpay"
					+ "&setting={set}&type=api&userdata=xxac_{ExData}&paycode={paycode}&imsi={imsi}&imei={imei}&app={app}&ip={ip}";
			
			orderId = this.getOrderId( );
			
			url = url.replace( "{imsi}", user.getImsi() )
					.replace("{ExData}", orderId )
					.replace( "{paycode}", jsonObj.getString( "paycode" ) )
					.replace( "{imei}", user.getImei()==null?"":user.getImei() )
					.replace("{set}", jsonObj.getString( "set" ) )
					.replace("{app}", jsonObj.getString( "appid" ) )
					.replace("{ip}", feeRequest.getRequestIp() );
			
			logger.info( "url:" + url );
			
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