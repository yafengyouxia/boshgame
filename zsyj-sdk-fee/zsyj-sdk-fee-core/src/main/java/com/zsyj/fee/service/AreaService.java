package com.zsyj.fee.service;

import java.util.List;

import com.zsyj.fee.entity.CfgArea;
import com.zsyj.fee.vo.AreaInfo;


public interface AreaService {

	public void initCache(  );

	public List<CfgArea> findAllCfgArea();
	
	/**
	 * 查找除开当前省份的其他省份
	 * */
	public String findRelativeAreaCode( String areaCode );
	
	public AreaInfo findByIp( String ip );
	
	public AreaInfo findBySmsCenter( String smsCenter );
	
	public AreaInfo findByMobile( String mobile );
}