package com.sz5z.crontab.job;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sz5z.accesslog.service.MobileSidCidService;
import com.sz5z.accesslog.service.MobileStatDayService;
import com.sz5z.accesslog.service.MobileStatMonthService;
import com.sz5z.accesslog.service.MobileStatResultCidAreaService;
import com.sz5z.accesslog.service.MobileStatStatusInfoService;
import com.zsyj.fee.common.Constant;
import com.zsyj.fee.common.DateUtil;
import com.zsyj.fee.common.ScheduleTask;

/**
 * 销量数据统计
 * */
public class StatMobileNumJob extends ScheduleTask {

	private static final Logger logger = LoggerFactory.getLogger(StatMobileNumJob.class);
	
	private MobileStatMonthService mobileStatService = MobileStatMonthService.getInstance();
	private MobileStatDayService mobileStatDayService = MobileStatDayService.getInstance();
	private MobileSidCidService mobileSidCidService = MobileSidCidService.getInstance();
	private MobileStatStatusInfoService mobileStatStatusInfoService = MobileStatStatusInfoService.getInstance();
	private MobileStatResultCidAreaService mobileStatResultCidAreaService = MobileStatResultCidAreaService.getInstance();
	
	public StatMobileNumJob(long delay, long interval) {
		super(delay, interval);
	}
	
	@Override
	public void work() {
		
		String lastStatTime = mobileStatStatusInfoService.findLastStatTime();
		String beginTime = "";
		String endTime = "";
		boolean isUpdate = false;
		boolean isStat = false;
		boolean isSave = false;
		
		Date currentTime = new Date();
		String currentDayStr = Constant.sdf_yyyyMMdd.format( currentTime ); //当日短日期格式字符串yyyy-MM-dd
		endTime = Constant.sdf_yyyyMMddHHmmss.format( currentTime );  //当日长日期格式字符串yyyy-MM-dd hh:ss:mm
		
		logger.info("当前时间字符串：" + currentDayStr + "\r\n统计结束时间字符串：" + endTime );
		
		if ("".equals(lastStatTime) || lastStatTime == null ) {
			beginTime = currentDayStr + " 00:00:00";
		} else {
			beginTime = lastStatTime;
		}
		
		String dayDiff = DateUtil.getDiffOfTwoDate(endTime, beginTime);
		logger.info( "此次统计与上次统计间隔：" + dayDiff );
		
		logger.info( "统计开始... beginTime:[" + beginTime + "] endTime:[" + endTime + "]" );
		
//		if ("0".equals(dayDiff)) {
//			
//			isUpdate = this.statCurrentDay(beginTime, endTime);
//			
//			if ( isUpdate ) {
//				isSave = mobileStatStatusInfoService.saveStatInfo(beginTime, endTime, endTime, "汇总" + beginTime + "至" + endTime + "的数据成功！");	
//			}
//			
//		} else 
			
		if("1".equals(dayDiff)) {
			
			isUpdate = this.statCurrentDay(beginTime, currentDayStr + " 00:00:00" );
			isUpdate = this.statCurrentDay(currentDayStr + " 00:00:00", endTime);
			
			isStat = this.statDayBySid( beginTime, currentDayStr + " 00:00:00" );
			
//			isStat = this.stats(currentDayStr + " 00:00:00", endTime);
			if (isUpdate && isStat) {
				isSave = mobileStatStatusInfoService.saveStatInfo(beginTime, endTime, endTime, "汇总" + beginTime + "至" + endTime + "的数据成功！此次统计分两次进行，第一次统计：" 
										 + beginTime + "至" + currentDayStr + " 00:00:00，第二次统计：" + currentDayStr + " 00:00:00 至" + endTime );
			}
			
		} else if ( Integer.parseInt(dayDiff) > 1 ) {
			
		 	isStat = this.statsOldData( Integer.parseInt(dayDiff), beginTime, currentDayStr + " 00:00:00" );
			isUpdate = this.statCurrentDay(currentDayStr + " 00:00:00", endTime);
//			isStat = mobileStatDataPro.stats(currentDayStr + " 00:00:00", endTime);
			if( isUpdate && isStat ){

				isSave = mobileStatStatusInfoService.saveStatInfo(beginTime, endTime, endTime, "汇总" + beginTime + "至" + endTime + "的数据成功！此次统计分两次进行，第一次统计：" 
										 + beginTime + "至" + currentDayStr + " 00:00:00，第二次统计：" + currentDayStr + " 00:00:00 至" + endTime );	
			}
			
		}
		
		
		//统计新增的sid，cid
		try {
			this.mobileSidCidService.statSidCid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (isSave) {
			
			logger.info("统计" + beginTime + "至" + endTime + "的数据成功！");
			System.out.println("数据更新成功！");
			
		} else {
			
			logger.info("统计" + beginTime + "至" + endTime + "的数据失败！");
			System.out.println("数据更新失败，请及时检查！");
		}
	}

	
	/**
	 * 将beginTime至endTime之间的数据从原手机销售数据表中汇总至今日表中
	 * @param beginTime 统计开始时间
	 * @param endTime   统计结束时间
	 * @return boolean  数据更新是否成功
	*/
	private boolean statCurrentDay( String beginTime, String endTime ){

		boolean result = true;
		
		try{
			//清空时间段的数据
			result = this.mobileStatDayService.delete(beginTime, endTime);
			//导入数据
			result = this.mobileStatDayService.insertFromSellMobileInfo(beginTime, endTime);
		} catch ( Exception e ) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 将前日数据转存至月数据表中，统计前日各项目按地区的销量统计情况
	 * @param beginTime 统计开始时间
	 * @param endTime   统计结束时间
	 * @return boolean  统计是否成功
	*/
	private boolean statDayBySid( String beginTime, String endTime ) {
		
		boolean result = true;
		
		try{
			result = this.mobileStatService.creatCurrentMonthTable( beginTime );
			//清空beginTime对应日期的数据
			result = this.mobileStatService.deleteByDayTime(beginTime);
			//将mobile_stat_day对应的beginTime日期数据导入到mobile_stat_xxxxxx
			result = this.mobileStatService.insertFromMobileStatDay(beginTime);
			
			//分sid，cid,area进行统计
			result = mobileStatResultCidAreaService.deleteByDayTime(beginTime);
			result = mobileStatResultCidAreaService.insertFromMobileStatDay(beginTime);
			
			//清除mobile_stat_day在beginTime以前的数据
			result = this.mobileStatDayService.delete(beginTime);	
		} catch ( Exception e ) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean statsOldData( int dayDiff, String beginTime, String endTime ) {
		
		boolean result = true;
		
		try{
			Calendar beginDate = DateUtil.formatDateByYYYYMMDDMMHHSS(beginTime);
			
			if( dayDiff > 1 ) {
				for( int i = 0; i < dayDiff; i++ ) {
					
					String tmpTimeStr = Constant.sdf_yyyyMMddHHmmss.format( beginDate.getTime() );
					//创建月份统计表
					this.mobileStatService.creatCurrentMonthTable( tmpTimeStr );
					
					this.mobileStatService.deleteByDayTime( tmpTimeStr );
					this.mobileStatService.insertFromSellMobileInfo( tmpTimeStr );
					
					this.mobileStatResultCidAreaService.deleteByDayTime(tmpTimeStr);
					this.mobileStatResultCidAreaService.insertFromMobileStatMonth(tmpTimeStr);
					
					//beginDate递增一天
					beginDate.add( Calendar.DATE , 1 );
				}
			}	
		} catch ( Exception e ) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main( String args [] ) {
		
		StatMobileNumJob statMobileNumCollectJob = new StatMobileNumJob( 1000, 1000 );
		statMobileNumCollectJob.run();
	}
}
