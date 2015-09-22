package com.zsyj.service;

import java.util.List;

import org.junit.Test;

import com.zsyj.fee.service.impl.TroneConfigInfoServiceImpl;
import com.zsyj.fee.vo.TroneConfigInfo;

public class TroneConfigInfoServiceImplTest {

	@Test
	public void test()
	{
		List<TroneConfigInfo> troneList = TroneConfigInfoServiceImpl.getInstance().getFreshPvFreshList();
		
		System.out.println( troneList );
	}
}
