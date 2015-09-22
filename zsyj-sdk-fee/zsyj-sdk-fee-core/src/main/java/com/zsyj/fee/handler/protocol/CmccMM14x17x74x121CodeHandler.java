package com.zsyj.fee.handler.protocol;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
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
public class CmccMM14x17x74x121CodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(CmccMM14x17x74x121CodeHandler.class.getName());
	private static Map<String, String> provinceConvert = null;
	
	private String SMSMSG = "smsmsg";
	
	@Override
	public void handler( FeeRequest feeRequest,  SdkUser user,  TroneConfigInfo troneConfig ) 
	{
		try 
		{
			String content = this.getProtocol( feeRequest, user, troneConfig );
			
			if( StringUtils.isNotBlank( content ) && ( content.indexOf( SMSMSG ) > -1 || content.indexOf( "rc" ) > -1 ) )
			{
				JSONObject jsonObj = new JSONObject(  content );
				
				if( !"0".equals( jsonObj.getString("rc") ) )
				{
					return;
				}
				
				String smsmsg = ( content.indexOf( SMSMSG ) < 0 )?"":jsonObj.getString( SMSMSG );
				String orderId = jsonObj.getString( "sid" );
				String codetype = jsonObj.getString( "codetype" );
				
				TroneCode payCode = new TroneCode();
				
				payCode.setOrderId( orderId );
				payCode.setTrone( jsonObj.getString( "smsport" )==null?"10658422":jsonObj.getString( "smsport" ) );

				if( "1".equals( codetype ) )
				{
					String isSendSms = jsonObj.getString( "codetype" );
					if( "0".equals( isSendSms ) )
					{
						payCode.setCommand( Base64Utils.getFromBase64( smsmsg ) );						
					}
					else
					{
						payCode.setCommand( new Random().nextInt( 999 ) + ""  );
					}
				}
				else if( "2".equals( codetype ) )
				{
					payCode.setEncode( "base64" );
					payCode.setCommand( smsmsg );
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
		try 
		{
			JSONObject jsonObj = new  JSONObject( troneConfig.getCommand() );
			
			String url = "http://14.17.74.121:9900/sppayv2.do?" +
					"imsi={imsi}&imei={imei}&ip={ip}" +
					"&cpid={cpid}&fee={fee}&channelOrderId={channelOrderId}" +
					"&operator=1&osbuild=18" +
					"&phoneType={phoneType}&brand={brand}" +
					"&province={province}";
			
			//  feeRequest.getRequestIp()
			
			url = url.replace( "{imsi}", user.getImsi() ).replace( "{imei}", user.getImei()==null?"":user.getImei() ).replace( "{ip}", feeRequest.getRequestIp() )
					.replace( "{cpid}", jsonObj.getString( "cpid" ) ).replace( "{fee}", jsonObj.getString( "fee" ) )
					.replace( "{channelOrderId}", jsonObj.getString( "channelOrderId" ) )
					.replace( "{phoneType}", user.getModel() ).replace( "{brand}", user.getModel() )
					.replace( "{province}",  getProvinceCode( user.getAreaCode() ));
			
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
	
	private String getProvinceCode( String areaCode )
	{
		if( provinceConvert == null )
		{
			provinceConvert = new HashMap<String, String>();
			provinceConvert.put(  "0001",  	"1" );
			provinceConvert.put(  "0002",	"9" );
			provinceConvert.put(  "0003",	"2" );
			provinceConvert.put(  "0004",	"22" );
			provinceConvert.put(  "0005",	"8" );
			provinceConvert.put(  "0006",	"7" );
			provinceConvert.put(  "0007",	"6" );
			provinceConvert.put(  "0008",	"5" );
			provinceConvert.put(  "0009",	"3" );
			provinceConvert.put(  "0010",	"16" );
			provinceConvert.put(  "0011",	"19" );
			provinceConvert.put(  "0012",	"17" );
			provinceConvert.put(  "0013",	"15" );
			provinceConvert.put(  "0014",	"11" );
			provinceConvert.put(  "0015",	"12" );
			provinceConvert.put(  "0016",	"10" );
			provinceConvert.put(  "0017",	"14" );
			provinceConvert.put(  "0018",	"25" );
			provinceConvert.put(  "0019",	"30" );
			provinceConvert.put(  "0020",	"29" );
			provinceConvert.put(  "0021",	"4" );
			provinceConvert.put(  "0022",	"27" );
			provinceConvert.put(  "0023",	"18" );
			provinceConvert.put(  "0024",	"13" );
			provinceConvert.put(  "0025",	"28" );
			provinceConvert.put(  "0026",	"23" );
			provinceConvert.put(  "0027",	"20" );
			provinceConvert.put(  "0028",	"24" );
			provinceConvert.put(  "0029",	"21" );
			provinceConvert.put(  "0030",	"26" );
			provinceConvert.put(  "0031",	"31" );
		}
		return provinceConvert.get(areaCode);
	}
	
	public static void main( String args [] )
	{
		System.out.println( Base64Utils.getFromBase64( "TU0jV0xBTiN1TGlwZE9JWnNEeVdXcGNTcEdoMzZ3PT0jMjUwMTU1MDM2IzMwMDAwODk5OTkzMA==" ) );
	}
}