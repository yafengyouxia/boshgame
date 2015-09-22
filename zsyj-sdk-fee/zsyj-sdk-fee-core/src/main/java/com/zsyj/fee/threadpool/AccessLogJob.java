package com.zsyj.fee.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.service.AccessLogService;
import com.zsyj.fee.service.impl.AccessLogServiceImpl;
import com.zsyj.fee.vo.Accesslog;

public class AccessLogJob implements Runnable{

	private Accesslog accessLog;
	private AccessLogService accessLogService = AccessLogServiceImpl.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(AccessLogJob.class);
	
	public AccessLogJob( Accesslog accessLog )
	{
		this.accessLog = accessLog; 
	}
	
	@Override
	public void run() {
		accessLogService.insert( accessLog );
		accessLog = null;
	}
}
