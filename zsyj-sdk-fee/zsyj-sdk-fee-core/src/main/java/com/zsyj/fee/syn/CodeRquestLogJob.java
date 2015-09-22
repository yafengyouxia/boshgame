package com.zsyj.fee.syn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.handler.ProcessorCommon;

public class CodeRquestLogJob implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(CodeRquestLogJob.class);
	
	private ProcessorCommon processorCommon = new  ProcessorCommon();
	
	private long costTime = 0;
	private String requestQuery = null;
	
	public CodeRquestLogJob( String requestQuery, long costTime ) {
		this.requestQuery = requestQuery;
		this.costTime = costTime;
	}
	
	@Override
	public void run( ) 
	{
		try
		{
			this.processCodeRequestLog( );
		}
		catch( Exception e ) 
		{
			e.printStackTrace();
			logger.error( e.getMessage() );
		}
	}
	
	public boolean processCodeRequestLog( )
	{
		boolean result = true;
		try
		{
			logger.info( "costTime:" + this.costTime );
			logger.info( "requestQuery:" + this.requestQuery );
		}
		catch( Exception e )
		{
			result = false;
			e.printStackTrace();
			logger.error( e.getMessage() );
		}
		
		return result;
	}
}
