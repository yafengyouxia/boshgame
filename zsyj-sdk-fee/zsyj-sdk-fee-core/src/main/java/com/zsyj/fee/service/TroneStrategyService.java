package com.zsyj.fee.service;

import java.util.Map;

import com.zsyj.fee.entity.SdkTroneStrategy;

/** 
 * 短信通道配置smsconfigifo
 * 
 * @author hujian
 */
public interface TroneStrategyService 
{
	public Map<Integer, SdkTroneStrategy> findAll( );
	
	/**
	 * 查询代码策略
	 * @param id
	 * */
	public SdkTroneStrategy find( int id );
}
