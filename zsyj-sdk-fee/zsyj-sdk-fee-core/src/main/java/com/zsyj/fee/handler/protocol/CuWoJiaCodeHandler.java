package com.zsyj.fee.handler.protocol;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import com.zsyj.fee.common.HTTPForwarder;
import com.zsyj.fee.common.Sign;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneConfigInfo;

public class CuWoJiaCodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(CmccGame121x42x220x79CodeHandler.class.getName());
	
	private static String appkey = "vision";
	private static String version = "1.0";
	private static String securitykey = "7dc43b95086a2873ff2f83d1e5ef1079";
	private static String method = "biz.acceptance";
	private static String agentID = "9900000253";
	private static String bizType = "bill";
	private static String appName = "%E5%BC%80%E5%BF%83%E6%B6%88%E6%B6%88";
	private static String productName = "%E5%A4%8D%E6%B4%BB1%E5%85%83";
	private static String totalFee = "1";
	private static String bizOpenMode = "2";
	
	private String orderId = "";
	
	@Override
	public void handler( FeeRequest feeRequest, SdkUser user, TroneConfigInfo troneConfig) {
		// TODO Auto-generated method stub
		
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
	
	private String getSign(  )
	{
		Map<String, String> params = new HashMap<String, String>();
		// timestamp参数
		//params.put( "ts", Constant.sdf_yyyyMMddHHmmss.format(new Date()));
		params.put( "ts", "20150513135556" );
		params.put( "appkey" , appkey  );
		params.put( "version" , version  );
		params.put( "securitykey", securitykey  );
		params.put( "method", method  );
		params.put( "agentID", agentID  );
		params.put( "bizType", bizType  );
		params.put( "appName" , appName  );
		params.put( "productName" , productName  );
		params.put( "totalFee" , totalFee  );
		params.put( "bizOpenMode" , bizOpenMode  );
		
		String sign = Sign.getSigString(params);
		
		return sign;
	}
	
	public static void main( String args [] )
	{
//		try {
//			
//			String appName = URLEncoder.encode("开心消消", "utf-8");
//			String productName = URLEncoder.encode("复活1元", "utf-8");
//			
//			System.out.println( appName );
//			System.out.println( productName );
//		
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		
		CuWoJiaCodeHandler handler = new CuWoJiaCodeHandler();
		System.out.println( handler.getSign() );
	}
}
