package com.zsyj.service;

import org.junit.Test;

import com.zsyj.fee.entity.SdkTroneStrategy;
import com.zsyj.fee.service.impl.TroneStrategyServiceImpl;

public class TroneStrategyServiceTest {

	@Test
	public void test()
	{
		SdkTroneStrategy troneStrategy = TroneStrategyServiceImpl.getInstance().findAll().get( 48 );
		
		System.out.println( troneStrategy.toString() );
	}
}
