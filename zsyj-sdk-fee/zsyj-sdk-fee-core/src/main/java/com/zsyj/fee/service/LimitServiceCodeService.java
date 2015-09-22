package com.zsyj.fee.service;

import java.util.Map;

import com.zsyj.fee.entity.LimitServicecode;

public interface LimitServiceCodeService {

	public Map<String, LimitServicecode> findAll( );
	
	public LimitServicecode findByServiceCode( String serviceCode );
}
