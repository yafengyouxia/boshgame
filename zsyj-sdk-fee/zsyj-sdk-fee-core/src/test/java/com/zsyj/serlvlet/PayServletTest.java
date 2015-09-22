package com.zsyj.serlvlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.zsyj.fee.servlet.PaySerlvet;
import com.zsyj.fee.vo.FeeRequest;

public class PayServletTest {

	private static Log logger = LogFactory.getLog(PaySerlvet.class.getName());
	
	private FeeRequest feeRequest = null;	//用户请求封装类
	
	@Test
	public void pay()
	{
		PaySerlvet paySerlvet = new PaySerlvet();
		createFeeRequest();
		
		paySerlvet.test( feeRequest );
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	private void createFeeRequest()
	{
		feeRequest = new FeeRequest( );
		feeRequest.setMobileNumber( "" );
		feeRequest.setCardType( "" );
		feeRequest.setSid( "2001" );
		feeRequest.setCid( "101" );
		feeRequest.setMid( "460021430387344" );
		feeRequest.setImsi( "460021430387344" );
		feeRequest.setUuid( "f9334ea8-20b5-45fb-89b8-91469ddbee46" );
		feeRequest.setAppid( "10003" );
		feeRequest.setCpId( "5007" );
		feeRequest.setImei( "A000004F2A55C1" );
		feeRequest.setRequestIp( "117.136.41.124" );
		feeRequest.setRequsetPage( "pay" );
		feeRequest.setSoftversion( "V1.0" );
		feeRequest.setUserAgent( "Mobile Agent" );
		feeRequest.setAndroidVer( "4.2.2" );
		feeRequest.setMobiModel( "Nexus 5" );
		feeRequest.setPackageName( "com.stricHero" );
		feeRequest.setItemPrice( 4.0 );
		feeRequest.setItemCode( "2" );
	}
}
