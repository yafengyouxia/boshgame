package com.zsyj.fee.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.zsyj.fee.entity.SdkAccesslog;


public class Accesslog extends SdkAccesslog {
	
	private static final long serialVersionUID = 6256597505286528967L;
	private static final byte REQUEST_TYPE_LOGIN = 0;
	private static final byte REQUEST_TYPE_FEE = 1;
	
	public static Accesslog getFeeInstance( FeeRequest feeRequest )
	{
		Accesslog sdkAccessLog = new Accesslog();
		sdkAccessLog.setAppid( feeRequest.getAppid() );
		sdkAccessLog.setSid( feeRequest.getSid() );
		sdkAccessLog.setCid( feeRequest.getCid() );
		sdkAccessLog.setImsi( feeRequest.getImsi() );
		sdkAccessLog.setUuid( feeRequest.getUuid() );
		
		sdkAccessLog.setRequestType( Accesslog.REQUEST_TYPE_FEE );
		
		if( StringUtils.isNotBlank( feeRequest.getItemCode() ) )
		{
			try {
				sdkAccessLog.setRequestParam( URLEncoder.encode( feeRequest.getItemCode(), "gb2312" ) );
				
				if( sdkAccessLog.getRequestParam().length() > 10 )
				{
					sdkAccessLog.setRequestParam( sdkAccessLog.getRequestParam().substring(0, 10) );
				}
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		
		sdkAccessLog.setRequestValue( feeRequest.getItemPrice() + "" );
		sdkAccessLog.setLogTime( new Date() );
		
		return sdkAccessLog;
	}
	
	public static Accesslog getLoginInstance( FeeRequest feeRequest )
	{
		Accesslog sdkAccessLog = new Accesslog();
		sdkAccessLog.setAppid( feeRequest.getAppid() );
		sdkAccessLog.setSid( feeRequest.getSid() );
		sdkAccessLog.setCid( feeRequest.getCid() );
		sdkAccessLog.setImsi( feeRequest.getImsi() );
		sdkAccessLog.setUuid( feeRequest.getUuid() );
		sdkAccessLog.setLogTime( new Date() );
		
		sdkAccessLog.setRequestType( Accesslog.REQUEST_TYPE_LOGIN );
		
		return sdkAccessLog;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
