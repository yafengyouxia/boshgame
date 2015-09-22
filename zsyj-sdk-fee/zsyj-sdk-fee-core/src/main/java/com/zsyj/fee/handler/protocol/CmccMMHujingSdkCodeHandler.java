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
public class CmccMMHujingSdkCodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(CmccMMHujingSdkCodeHandler.class.getName());
	
	@Override
	public void handler( FeeRequest feeRequest,  SdkUser user,  TroneConfigInfo troneConfig ) 
	{
		try 
		{
			JSONObject jsonObj = new JSONObject(  troneConfig.getCommand() );
			
			String orderId = this.getOrderId();
			String subUrl = jsonObj.getString( "subUrl" );
			String feeCode = jsonObj.getString( "feeCode" );
			
			TroneCode payCode = new TroneCode();
			
			payCode.setOrderId( orderId );
			payCode.setSubUrl( URLEncoder.encode( subUrl, "utf8" ) );
			
			payCode.setFeeType( "hujingSDK" );
			
			troneConfig.setConfirmCommand( feeCode );
			
			troneConfig.getCodeList().add( payCode );
			troneConfig.setOrderId( orderId );
		}
		catch ( Exception e ) 
		{
			logger.error( e.getMessage() );
			e.printStackTrace();
		}
	}
}