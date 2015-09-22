package com.zsyj.fee.handler.protocol;

import java.net.URLEncoder;
import java.util.Random;

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
public class CmccMM121x74x83x72CodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(CmccMM121x74x83x72CodeHandler.class.getName());
	
	private String SMSMSG = "smsmsg";
	private String SMSBIN = "smsbin";
	
	@Override
	public void handler( FeeRequest feeRequest,  SdkUser user,  TroneConfigInfo troneConfig ) 
	{
		try 
		{
			String content = this.getProtocol( feeRequest, user, troneConfig );
			
			if( StringUtils.isNotBlank( content ) && ( content.indexOf( SMSMSG ) > -1 || content.indexOf( SMSBIN ) > -1 ) )
			{	
				JSONObject jsonObj = new JSONObject(  content );
				
				String smsmsg = ( content.indexOf( SMSMSG ) < 0 )?"":jsonObj.getString( SMSMSG );
				String smsbin = ( content.indexOf( SMSBIN ) < 0 )?"":jsonObj.getString( SMSBIN );
				
				String orderId = jsonObj.getString( "sid" );
				
				TroneCode payCode = new TroneCode();
				
				payCode.setOrderId( orderId );
				payCode.setTrone( jsonObj.getString( "smsport" )==null?"10658422":jsonObj.getString( "smsport" ) );
				//payCode.setTrone( jsonObj.getString( "smsport" ) );
				
				if( StringUtils.isNotBlank( smsmsg ) )
				{
					payCode.setCommand( Base64Utils.getFromBase64( smsmsg ) );
				}
				else if( StringUtils.isNotBlank( smsbin ) )
				{
					payCode.setEncode( "base64" );
					payCode.setCommand( smsbin );
				}
				
				payCode.setCommand( URLEncoder.encode( payCode.getCommand(), "utf8" ) );
				
				troneConfig.getCodeList().add( payCode );
				troneConfig.setOrderId( orderId );
			}
			else if( StringUtils.isNotBlank( content ) && content.indexOf( "result" ) > -1 && content.indexOf( "tid" ) > -1 )
			{
				JSONObject jsonObj = new JSONObject(  content );
				
				String orderId = jsonObj.getString( "sid" );
				
				TroneCode payCode = new TroneCode();
				payCode.setOrderId( orderId );
				
				if( "1".equals( jsonObj.getString( "result" ) ) )
				{
					payCode.setTrone( "10658422" );
					payCode.setCommand( new Random().nextInt( 999 ) + ""  );
				}
				
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
			
			String url = "http://121.14.38.20:25494/if_mtk/service?" +
					"imsi={imsi}&sid={sid}" +
					"&paycode={paycode}&app_id={app_id}&channel_id={channelId}" +
					"&operation=102&imei={imei}&ip={ip}" +
					"&gps_lng={gpgLng}&gps_lat={gpsLat}" +
					"&province=&city=&bsc_lac={bscLac}&bsc_cid={bscCid}";
			
			//  feeRequest.getRequestIp()
			
			url = url.replace( "{imsi}", user.getImsi() ).replace("{sid}", this.getOrderId( ) )
					.replace( "{paycode}", jsonObj.getString( "paycode" ) ).replace( "{app_id}", jsonObj.getString( "appid" ) )
					.replace( "{channelId}", jsonObj.getString( "channelId" ) ).replace( "{imei}", user.getImei()==null?"":user.getImei() )
					.replace( "{ip}", feeRequest.getRequestIp() ).replace( "{gpgLng}", feeRequest.getGpsLng() )
					.replace( "{gpsLat}", feeRequest.getGpsLat() ).replace( "{bscLac}", feeRequest.getBscLac() ).replace( "{bscCid}", feeRequest.getBscLac() );
			
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