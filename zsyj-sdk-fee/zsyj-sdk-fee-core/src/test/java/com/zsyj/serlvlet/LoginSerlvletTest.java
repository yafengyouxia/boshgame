package com.zsyj.serlvlet;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

import com.zsyj.fee.entity.SdkStrategy;
import com.zsyj.fee.service.impl.SdkStrategyServiceImpl;
import com.zsyj.fee.service.impl.UsersServiceImpl;
import com.zsyj.fee.threadpool.AccessLogJob;
import com.zsyj.fee.threadpool.SdkThreadPool;
import com.zsyj.fee.vo.Accesslog;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;

public class LoginSerlvletTest {

	private FeeRequest feeRequest = null;	//用户请求封装类
	private Accesslog accessLog = null;
	
	@Test
	public void login()
	{
		createFeeRequest();
		
		this.accessLog = Accesslog.getLoginInstance( feeRequest );
		
		//查询用户信息，不存在则新增
		SdkUser user = UsersServiceImpl.getInstance().handlerUserInfoByFeeRequest(feeRequest);
		
		SdkStrategy strategy = SdkStrategyServiceImpl.getInstance().findStrategy(user);
		
		//获取一毛钱的计费脚本
		String feeInfos = "";
		
		//线程池--插入用户来访记录
		SdkThreadPool.getInstance().excute( new AccessLogJob( this.accessLog ) );
		
		try {
			Thread.sleep( 10000 );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createFeeRequest()
	{
		feeRequest = new FeeRequest( );
		feeRequest.setMobileNumber( "" );
		feeRequest.setCardType( "" );
		feeRequest.setSid( "2001" );
		feeRequest.setCid( "1001" );
		feeRequest.setMid( "460027632804376" );
		feeRequest.setUuid( "A86B68B6ED094C969DD5EE758E7F5FAF" );
		feeRequest.setAppid( "10001" );
		feeRequest.setCpId( "1001" );
		feeRequest.setImei( "357834052027661" );
		feeRequest.setRequestIp( "127.0.0.1" );
		feeRequest.setRequsetPage( "/login" );
		feeRequest.setSoftversion( "V1.0" );
		feeRequest.setUserAgent( "Mobile Agent" );
		feeRequest.setAndroidVer( "4.2.2" );
		feeRequest.setMobiModel( "Nexus 5" );
		feeRequest.setPackageName( "com.stricHero" );
		feeRequest.setItemPrice( 6.0 );
		feeRequest.setItemCode( "600789" );
		feeRequest.setImsi( "460027632804376" );
	}
}
