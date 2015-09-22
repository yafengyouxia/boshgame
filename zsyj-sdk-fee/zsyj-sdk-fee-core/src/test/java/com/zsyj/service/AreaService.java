package com.zsyj.service;

import org.junit.Test;

import com.zsyj.fee.service.impl.AreaServiceImpl;

public class AreaService {

	@Test
	public void findAll()
	{
		AreaServiceImpl.getInstance().initCache();
	}
}
