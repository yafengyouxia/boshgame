package com.zsyj.fee.service;

import com.zsyj.fee.vo.Accesslog;

public interface AccessLogService {
	
	/**
	 * 添加消费记录
	 * */
	public boolean insert( Accesslog accesslog );
}
