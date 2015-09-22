package com.zsyj.fee.schedule;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractScheduleTask extends TimerTask {

	private static final Logger logger = LoggerFactory.getLogger(AbstractScheduleTask.class);
	
	public long delay = 0;
	public long interval = 0;
	
	public AbstractScheduleTask( long delay, long interval ) {
		this.delay = delay;
		this.interval = interval;
	}
	
	public abstract void work();
	
	public void run() {
		
		try {
			Thread.sleep( delay );
		} catch ( Exception e ) {
			e.printStackTrace();
			logger.error( e.getMessage() );
		}
		
		while( true ) {
			
			try{
				work();	
			}catch( Exception e ) {
				e.printStackTrace();
				logger.error( e.getMessage() );
			}
			
			try {
				Thread.sleep( interval );
			} catch ( Exception e ) {
				e.printStackTrace();
				logger.error( e.getMessage() );
			}
			
		}
	}
}
