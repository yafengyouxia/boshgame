package com.zsyj.fee.service;

import com.zsyj.fee.entity.SolarAgent;
import com.zsyj.fee.entity.SolarMonitor;

public interface SolarMonitorService {

	public SolarMonitor findCid( String sid, String cid );
	
	public SolarAgent findSid( String sid );
}
