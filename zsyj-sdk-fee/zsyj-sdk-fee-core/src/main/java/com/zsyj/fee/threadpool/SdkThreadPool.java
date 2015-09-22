package com.zsyj.fee.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SdkThreadPool {

	private static SdkThreadPool instance = new SdkThreadPool ();
	
	private static ThreadPoolExecutor threadPool = null;
	
	static
	{
		// 构造一个线程池  
		if( threadPool == null )
		{
			int cpuTimes = Runtime.getRuntime().availableProcessors();
			threadPool = new ThreadPoolExecutor( cpuTimes*2, cpuTimes*10, 60, TimeUnit.SECONDS,  
					new ArrayBlockingQueue<Runnable>( 10000 ), new ThreadPoolExecutor.AbortPolicy( ) );			
		}
	}
	
	public void excute( Runnable job )
	{
		threadPool.execute( job );
	}
	
	public static SdkThreadPool getInstance()
	{
		return instance;
	}
}
