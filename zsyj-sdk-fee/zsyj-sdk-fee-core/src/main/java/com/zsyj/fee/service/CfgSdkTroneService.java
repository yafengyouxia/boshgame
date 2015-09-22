package com.zsyj.fee.service;

import java.util.List;

import com.zsyj.fee.entity.CfgSdkTrone;

public interface CfgSdkTroneService {

	public List<CfgSdkTrone> findBySpid( int spId );
	
	public List<CfgSdkTrone> findByStatus( byte status );
	
	public boolean update( CfgSdkTrone sdkTrone );
}
