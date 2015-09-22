package com.zsyj.fee.handler.protocol;

import java.net.URLEncoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneCode;
import com.zsyj.fee.vo.TroneConfigInfo;

/**
 * 移动MM计费代码解析模板
 * */
public class CommanFeeCodeHandler extends AbstractFeeCodeHandler {

	private static Log logger = LogFactory.getLog(CommanFeeCodeHandler.class.getName());
	
	private String orderId = "";
	
	@Override
	public void handler( FeeRequest feeRequest, SdkUser user, TroneConfigInfo troneConfig ) {
		
		try {
			
			orderId = this.getOrderId( );
			
			TroneCode feeCode = new TroneCode();
			
			feeCode.setTrone( troneConfig.getTrone() );
			feeCode.setCommand( URLEncoder.encode( troneConfig.getCommand(), "utf8" ) );
			feeCode.setOrderId( orderId );
			feeCode.setSleepTime( 5 );
			
			troneConfig.getCodeList().add( feeCode );
			troneConfig.setOrderId( orderId );
		} 
		catch ( Exception e ) 
		{
			logger.error( e.getMessage() );
			e.printStackTrace();
		}
	}
}