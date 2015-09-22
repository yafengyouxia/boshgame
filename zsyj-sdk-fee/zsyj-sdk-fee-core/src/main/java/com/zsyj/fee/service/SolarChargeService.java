package com.zsyj.fee.service;

import java.util.Date;
import java.util.List;

import com.zsyj.fee.entity.SolarCharge;
import com.zsyj.fee.vo.SpData;

public interface SolarChargeService {

	public List<SpData> findSpData( Date startTime );
	
	public SolarCharge findByLinkId( String linkId );
	
	/**
	 * 获取本月的计费记录
	 * @param imsi
	 * @param uuid
	 * */
	public List<SolarCharge> findCurrentCharge( String imsi );
	
	/**
	 * 更新linkID对应的status字段
	 * @param linkId
	 * @param status
	 * */
	public boolean updateStatusByLinkId( String linkId, String status );
	
	/**
	 * 添加消费记录
	 * */
	public boolean inseartSolarCharge( SolarCharge solarCharge );
}
