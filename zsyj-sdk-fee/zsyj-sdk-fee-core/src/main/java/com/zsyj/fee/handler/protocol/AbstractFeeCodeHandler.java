package com.zsyj.fee.handler.protocol;

import java.util.Random;

import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneConfigInfo;

/**
 * 代码处理的抽象类
 * */
public abstract class AbstractFeeCodeHandler {

	/**
	 * 处理特殊代码，如代码处理失败则返回空列表
	 * */
	public abstract void handler( FeeRequest feeRequest, SdkUser user, TroneConfigInfo troneConfig );
	
	protected String getOrderId( )
	{
		return "Od" + System.currentTimeMillis() + "@" + new Random().nextInt( 9999 );
	}
}