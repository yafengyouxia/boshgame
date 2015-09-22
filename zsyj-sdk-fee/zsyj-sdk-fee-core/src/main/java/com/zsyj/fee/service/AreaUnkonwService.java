package com.zsyj.fee.service;

import com.zsyj.fee.entity.SdkUnknowArea;

public interface AreaUnkonwService {

	public SdkUnknowArea find( String value );
	
	public boolean insert( SdkUnknowArea unkonwArea );
}
