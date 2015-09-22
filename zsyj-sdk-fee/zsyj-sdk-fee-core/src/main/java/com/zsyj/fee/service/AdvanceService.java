package com.zsyj.fee.service;

import com.zsyj.fee.entity.AdvanceCompany;
import com.zsyj.fee.entity.AdvanceConfig;

public interface AdvanceService {
	
	public AdvanceConfig findBySmsId( int smsConfigId, String channelId );
	
	public AdvanceCompany findCpCompany( int cpId );
}
