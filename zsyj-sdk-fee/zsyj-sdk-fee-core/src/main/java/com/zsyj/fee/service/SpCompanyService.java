package com.zsyj.fee.service;

import java.util.Map;

import com.zsyj.fee.entity.CfgSpCompany;

/** 短信通道配置smsconfigifo
 * 
 * @author hujian
 */
public interface SpCompanyService {

	/**
	 * 根据价格和权重逆序排
	 * */
	public Map<Integer, CfgSpCompany> findAll( );
	
	/**
	 * 根据通道号码查询通道信息
	 * */
	public CfgSpCompany findBySpid( int spId );
}
