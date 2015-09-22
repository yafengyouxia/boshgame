package com.zsyj.fee.service;

import java.util.List;

import com.zsyj.fee.entity.SdkSynurlLog;

public interface SdkSynUrlLogService {
	
	/**
	 * @param type	0--df   1--sdk
	 * @param size
	 * @return
	 */
	public List<SdkSynurlLog> find( byte type, int size );
	
	public boolean update( SdkSynurlLog log );
	
	public boolean insert( SdkSynurlLog log );
}