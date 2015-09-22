package com.zsyj.fee.schedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.entity.CfgSdkTrone;
import com.zsyj.fee.service.CfgSdkTroneService;
import com.zsyj.fee.service.impl.CfgSdkTroneServiceImpl;

/**
 * 凌晨重新启动日限量已满的代码
 * @author ROOT
 */
public class StartLimitDayCodeTask extends AbstractScheduleTask{
	
	private static final Logger logger = LoggerFactory.getLogger(StartLimitDayCodeTask.class);
	
	private CfgSdkTroneService sdkTroneService = CfgSdkTroneServiceImpl.getInstance();
	
	public StartLimitDayCodeTask(long delay, long interval) {
		super(delay, interval);
	}
	
	@Override
	public void work() {
		
		try
		{
			logger.info( "=============== start open limitDayCode!" );
			
			this.restartCode( );
		}
		catch( Exception e )
		{
			e.printStackTrace();
			logger.error( "error:" + e.getMessage() );
		}
	}
	
	private void restartCode()
	{
		List<CfgSdkTrone> sdkTroneList =  sdkTroneService.findByStatus((byte)2);
		
		if( sdkTroneList != null && sdkTroneList.size() > 0 )
		{
			for( CfgSdkTrone sdkTrone : sdkTroneList )
			{
				logger.info( "start to open the trone code!" + sdkTrone.toString() );
				
				sdkTrone.setStatus( (byte)0 );	//0--激活    1--禁用     2--日限满关闭
				this.sdkTroneService.update(sdkTrone);
			}
		}
	}
}