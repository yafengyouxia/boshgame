package com.zsyj.fee.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zsyj.fee.vo.FeeRequest;

public class FeeRequestFactory {

	private static Log logger = LogFactory.getLog( FeeRequestFactory.class.getName(  ) );
	
	public static FeeRequest create( HttpServletRequest request )
	{
		/**
		Enumeration<String> headNames = request.getHeaderNames();
		StringBuffer sb = new StringBuffer( );
		while( headNames.hasMoreElements() )
		{
			String name = (String)headNames.nextElement();
			sb.append( "["+name+"] value:["+request.getHeader( name ) + "]\r\n" );
		}
		
		logger.info( "queryUrl:" + request.getQueryString() 
				+ "\r\n header key\r\n" + sb.toString());
		*/
		logger.info( "queryUrl:" + request.getQueryString() );
		
		String mid= request.getHeader("IMSI")==null?"":request.getHeader("IMSI");
		String sid= request.getHeader("SID")==null?"":request.getHeader("SID");
		String cid= request.getHeader("CID")==null?"":request.getHeader("CID");
		String cpId= request.getHeader("CPID")==null?"":request.getHeader("CPID");
		String imei= request.getHeader("IMEI")==null?"":request.getHeader("IMEI");
		String uuid= request.getHeader("UUID")==null?"":request.getHeader("UUID");
		String appid= request.getHeader("APPID")==null?"":request.getHeader("APPID");
		String cardType= request.getHeader("CARDTYPE")==null?"":request.getHeader("CARDTYPE");
		String model = request.getHeader("PHONEMODEL")!=null?request.getHeader("PHONEMODEL"):"";	//手机型号
		String androidVer = request.getHeader("android_version")!=null?request.getHeader("android_version"):"";	//手机型号
		String packageName = request.getHeader("packageName")!=null?request.getHeader("packageName"):"";	//包名
		String bsc_lac = request.getHeader("bsc_lac")!=null?request.getHeader("bsc_lac"):"";
		String bsc_cid = request.getHeader("bsc_cid")!=null?request.getHeader("bsc_cid"):"";
		String gps_lng = request.getHeader("gps_lng")!=null?request.getHeader("gps_lng"):"";
		String gps_lat = request.getHeader("gps_lat")!=null?request.getHeader("gps_lat"):"";
 		
		String ip = (String)request.getRemoteAddr();
		String userAgent = (String)request.getHeader("user-agent");
		String requestURI = (String)request.getRequestURI();
		String headerInfo = "";
		String sdkVer = request.getParameter("sdkVer")!=null?request.getParameter("sdkVer"):"";
		String itemPrice = request.getParameter("pay")!=null?request.getParameter("pay"):"0";	//支付请求金额
		String itemCode = request.getParameter("ShopId")!=null?request.getParameter("ShopId"):"0";	//支付请求金额
		String selfParam = request.getParameter("seltParam")!=null?request.getParameter("seltParam"):"";	//购买第三方自定义参数  （预留）
		String orderId = request.getParameter("orderId")!=null?request.getParameter("orderId"):"";
		
		if( requestURI.lastIndexOf( "/" ) > -1 )
		{
			requestURI = requestURI.substring( requestURI.lastIndexOf( "/" ) + 1, requestURI.length() );
		}
		
		if( StringUtils.isNotBlank( request.getHeader("X-Real-IP") ) )
		{
			ip = request.getHeader("X-Real-IP");
		}
		
		FeeRequest feeRequest = new FeeRequest( );
		feeRequest.setBscLac( bsc_lac );
		feeRequest.setBscCid( bsc_cid );
		feeRequest.setGpsLng( gps_lng );
		feeRequest.setGpsLat( gps_lat );
		feeRequest.setMobileNumber( getMobileNumberFromHeader( request ) );
		feeRequest.setCardType( cardType );
		feeRequest.setSid( sid );
		feeRequest.setCid( cid );
		feeRequest.setMid( mid );
		feeRequest.setUuid( uuid );
		feeRequest.setAppid( appid );
		feeRequest.setCpId( cpId );
		feeRequest.setImei( imei );
		feeRequest.setHeaderInfo( headerInfo );
		feeRequest.setRequestIp( ip );
		feeRequest.setRequsetPage( requestURI );
		feeRequest.setSoftversion( sdkVer );
		feeRequest.setUserAgent( userAgent );
		feeRequest.setAndroidVer(androidVer);
		feeRequest.setMobiModel( model );
		feeRequest.setPackageName(packageName);
		feeRequest.setItemPrice( Double.valueOf( itemPrice )/100 );
		feeRequest.setItemCode( itemCode );
		feeRequest.setOrderId(orderId);
		
		if( feeRequest.getMid().indexOf("#") > -1 )
		{
			feeRequest.setSmsCenter( feeRequest.getMid().substring( 0,feeRequest.getMid().indexOf("#") ) );
			feeRequest.setImsi( feeRequest.getMid().substring( feeRequest.getMid().indexOf("#"), feeRequest.getMid().length()) ) ;
		}
		else
		{
			feeRequest.setImsi( mid );
		}
		
		logger.info( feeRequest.toString() );
		
		return feeRequest;
	}
	
	//根据头信息字段获取手机号码
	private static String getMobileNumberFromHeader( HttpServletRequest request )
	{
		String mobile = "";
		if( request.getHeader("x-up-calling-line-id") !=null )
		{
			mobile = request.getHeader("x-up-calling-line-id");
		}
		else if( StringUtils.isNotBlank( request.getHeader( "mobile" ) ) )
		{
			mobile = request.getHeader("mobile");
		}
		
		if( StringUtils.isNotBlank( mobile ) )
		{
			if( mobile.startsWith( "861" ) || mobile.startsWith( "+86" ) )
			{
				mobile = mobile.replace("+86", "").replace("861", "1");
			}
			else if( mobile.startsWith( "86" ) )
			{
				mobile = mobile.replace("86", "");
			}
			
			if( mobile.length() > 11 )
			{
				mobile = mobile.substring( 0, 11 );
			}
		}
		
		return mobile;
	}
}