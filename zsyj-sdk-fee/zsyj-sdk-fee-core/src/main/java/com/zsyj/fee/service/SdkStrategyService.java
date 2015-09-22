package com.zsyj.fee.service;

import com.zsyj.fee.entity.SdkStrategy;
import com.zsyj.fee.vo.SdkUser;

public interface SdkStrategyService {

	public SdkStrategy findStrategy( SdkUser user );
}
