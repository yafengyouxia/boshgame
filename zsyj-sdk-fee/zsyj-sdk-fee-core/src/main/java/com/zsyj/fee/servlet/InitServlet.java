package com.zsyj.fee.servlet;

import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.zsyj.fee.schedule.CodeConversionAlarmTask;
import com.zsyj.fee.schedule.CodeLimitDayAlarmTask;
import com.zsyj.fee.schedule.StartLimitDayCodeTask;
import com.zsyj.fee.schedule.SynUrlLogTask;

public class InitServlet  extends HttpServlet {

	private static final long serialVersionUID = 5149742286783610208L;

	private static boolean initFlag = false;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		if( !initFlag )
		{
			initFlag = true;
			/**
			new Thread( 
				new  Runnable(){

					@Override
					public void run() {
						
						System.out.println( "================ start init the cache, initFlag:" + initFlag );
						
						//初始化地区缓存
						AreaServiceImpl.getInstance().initCache();
						
						System.out.println( "================ end init the cache" );
					}
					
			} ).start();
			*/
			
			new Thread( new SynUrlLogTask( 30000, 90*1000 ) ).start();
			
			//产品日限监控
			new Thread( new CodeLimitDayAlarmTask( 30000, 600*1000 ) ).start();
			
			//重新打开日限关闭的代码
			new Thread( new StartLimitDayCodeTask( getClock24Delay(), 24*3600*1000 ) ).start();
			
			new Thread( new CodeConversionAlarmTask( 60000, 1800*1000 ) ).start();
		}
	}
	
	//获取凌晨12点的间隔时间
	private long getClock24Delay()
	{
		Calendar clock24Time = Calendar.getInstance();
		
		clock24Time.add(Calendar.DAY_OF_YEAR, 1);
		clock24Time.set(Calendar.HOUR_OF_DAY, 0);
		clock24Time.set(Calendar.MINUTE, 0);
		clock24Time.set(Calendar.SECOND, 0);
		
		return clock24Time.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
	}
}