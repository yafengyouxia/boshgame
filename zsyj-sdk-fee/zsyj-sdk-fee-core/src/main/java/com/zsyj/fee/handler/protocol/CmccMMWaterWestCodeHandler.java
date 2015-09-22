package com.zsyj.fee.handler.protocol;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import com.waterwest.xpayagent.WaterWest;
import com.waterwest.xpayagent.model.Charge;
import com.zsyj.fee.common.Base64Utils;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneCode;
import com.zsyj.fee.vo.TroneConfigInfo;

/**
 * 移动MM计费代码解析模板
 * */
public class CmccMMWaterWestCodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog( CmccMMWaterWestCodeHandler.class.getName( ) );
	
	private String orderId = "";
	
	@Override
	public void handler( FeeRequest feeRequest,  SdkUser user,  TroneConfigInfo troneConfig ) 
	{
		try 
		{
			Map<String, Object> resultMap = this.getProtocol( feeRequest, user, troneConfig );
			
			if( resultMap != null && ( resultMap.get( "mm_strong" ) != null ||  resultMap.get( "mm_weak" ) != null ) )
			{
				Map<String,Object> smsMap = null;
				if( resultMap.get( "mm_strong" ) != null )
				{
					smsMap = (Map<String, Object>) resultMap.get( "mm_strong" );
				}
				else if( resultMap.get( "mm_weak" ) != null )
				{
					smsMap = (Map<String, Object>) resultMap.get( "mm_weak" );
				}
				
				String sendType = smsMap.get("send_type")==null?"":String.valueOf( smsMap.get("send_type") );
				String smsmsg = smsMap.get("sms")==null?"":String.valueOf( smsMap.get("sms") );
				String trone = smsMap.get("sms_number")==null?"10658424":String.valueOf( smsMap.get("sms_number") );
				
				TroneCode payCode = new TroneCode();
				
				payCode.setOrderId( orderId );
				payCode.setTrone( trone );
				
				if( "0".equals( sendType ) )
				{
					payCode.setCommand( Base64Utils.getFromBase64( smsmsg ) );
				}
				else if( "1".equals( sendType ) )
				{
					payCode.setEncode( "base64" );
					payCode.setCommand( smsmsg );
				}
				else if( "-1".equals( sendType ) )
				{
					payCode.setCommand( new Random().nextInt( 999 ) + ""  );
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
	
	private Map<String, Object> getProtocol( FeeRequest feeRequest, SdkUser user, TroneConfigInfo troneConfig )
	{
		try {
			
			JSONObject jsonObj = new  JSONObject( troneConfig.getCommand() );
			orderId = this.getOrderId();
			
		    WaterWest.apiKey = jsonObj.getString("apiKey"); //必需参数 apiKey和app_id由xpay支付服务器分配, 并且一一对应, 合作方每提交一个需要计费的app, xpay支付服务器端产生一个唯一对应的apiKey和app_id         
		    
		    Map<String, Object> chargeMap = new HashMap<String, Object>();
		    chargeMap.put("amount", jsonObj.getString("amount"));  //amout 必需参数 最小单位为分, 如1元对应amount为100, 暂时只支持app_id参数对应的app的计费点
		    chargeMap.put("channel", jsonObj.getString("channel") ); //channel, 必需参数, 暂时只支持mm弱联网计费(mm_weak), mm强联网计费(mm_strong)
		    chargeMap.put("order_no", orderId ); //orderNumber, 必需参数, 为接入商系统产生的唯一订单号, 当使用mm_weak或mm_strong通道时, 该参数可以从移动mm服务器透传
		                                            //使用mm_weak通道时, order_no长度不超过16, 使用mm_strong通道时, order_no长度不超过64 			
		    chargeMap.put("app_id", jsonObj.getString("app_id")); //app_id, 必需参数
				
		    Map<String, String> extraMap = new HashMap<String, String>();
		    
		    extraMap.put( "imei", StringUtils.isNotBlank( user.getImei() )?user.getImei():"8661250228" + ( new Random().nextInt( 89999 ) + 10000 )  ); //imei, 必需参数, 一定要传正确值
		    
		    extraMap.put( "imsi", user.getImsi() ); //imsi, 必需参数, 一定要传正确值
		    extraMap.put( "timestamp", System.currentTimeMillis() + "" ); //timestamp, 必需参数, 一定要传正确值
		    chargeMap.put("extra", extraMap);
		    
		    extraMap.put("os_info", user.getModel() ); //手机型号, channel取值为mm_strong时需要, 请传正确值
		    extraMap.put("os_model", user.getModel() ); //系统版本, channel取值为mm_strong时需要, 请传正确值
		    extraMap.put("net_info", "WIFI" ); //网络类型,  channel取值为mm_strong时需要, 请传正确值
		    extraMap.put("client_ip", feeRequest.getRequestIp() ); //手机终端外网ip地址, 请传正确值

		    Charge charge = Charge.create(chargeMap); //调用接口, 获取计费数据对象
			
			//  feeRequest.getRequestIp()
			
			if( charge != null && charge.getCredential() != null )
			{
				return 	charge.getCredential();
			}
		}
		catch ( Exception e ) 
		{
			logger.error( e.getMessage() );
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main( String args [] )
	{
		try {
			
		    WaterWest.apiKey = "sk_YoD7pbvtAbV6"; //必需参数 apiKey和app_id由xpay支付服务器分配, 并且一一对应, 合作方每提交一个需要计费的app, xpay支付服务器端产生一个唯一对应的apiKey和app_id         
		    
		    Map<String, Object> chargeMap = new HashMap<String, Object>();
		    chargeMap.put("amount", "1000");  //amout 必需参数 最小单位为分, 如1元对应amount为100, 暂时只支持app_id参数对应的app的计费点
		    chargeMap.put("channel", "mm_strong" ); //channel, 必需参数, 暂时只支持mm弱联网计费(mm_weak), mm强联网计费(mm_strong)
		    chargeMap.put("order_no", "654123" ); //orderNumber, 必需参数, 为接入商系统产生的唯一订单号, 当使用mm_weak或mm_strong通道时, 该参数可以从移动mm服务器透传
		                                            //使用mm_weak通道时, order_no长度不超过16, 使用mm_strong通道时, order_no长度不超过64 			
		    chargeMap.put("app_id","app_PQpFUN1p0dYY"); //app_id, 必需参数
			
		    Map<String, String> extraMap = new HashMap<String, String>();
		    extraMap.put( "imei", "866125022851594" ); //imei, 必需参数, 一定要传正确值
		    extraMap.put( "imsi", "460008701398423" ); //imsi, 必需参数, 一定要传正确值
		    extraMap.put( "timestamp", System.currentTimeMillis() + "" ); //timestamp, 必需参数, 一定要传正确值
		    chargeMap.put("extra", extraMap);
		    
		    extraMap.put("os_info", "Lenovo A320t" ); //手机型号, channel取值为mm_strong时需要, 请传正确值
		    extraMap.put("os_model", "Lenovo A320t" ); //系统版本, channel取值为mm_strong时需要, 请传正确值
		    extraMap.put("net_info", "WIFI" ); //网络类型,  channel取值为mm_strong时需要, 请传正确值
		    extraMap.put("client_ip", "116.55.16.48" ); //手机终端外网ip地址, 请传正确值
		    
		    Charge charge = Charge.create(chargeMap); //调用接口, 获取计费数据对象
			
			//  feeRequest.getRequestIp()
			
		    System.out.println( "content:" + charge.toString() );			
		} 
		catch ( Exception e ) 
		{
			System.out.println( e.getMessage() );
			e.printStackTrace();
		}
	}
}