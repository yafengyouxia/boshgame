package com.zsyj.service;

import org.junit.Test;

import com.zsyj.fee.service.UsersService;
import com.zsyj.fee.service.impl.UsersServiceImpl;
import com.zsyj.fee.syn.ChargeSynchronize;
import com.zsyj.fee.vo.SdkSolarCharge;

public class SolarChargeServiceTest {

	@Test
	public void test()
	{
		SdkSolarCharge solarCharge = new SdkSolarCharge();
		UsersService userService = UsersServiceImpl.getInstance();
		
		solarCharge.setLinkId( "0060498120071429854278432" );
		solarCharge.setStatus( "1" );
		solarCharge.setOrderId( "xZmYUryJJmexVOnV" );
		solarCharge.setMo( "006049812007" );
		solarCharge.setTrone( "10658422" );
		
		ChargeSynchronize chargeSynchronize = new ChargeSynchronize();
		chargeSynchronize.processCharge( solarCharge );
		
		try {
			Thread.sleep( 10000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
