package com.zsyj.fee.servlet;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zsyj.fee.common.Constant;
import com.zsyj.fee.common.enums.SdkResultEnum;
import com.zsyj.fee.entity.SdkStrategy;
import com.zsyj.fee.entity.SolarMonitor;
import com.zsyj.fee.handler.FeeRequestFactory;
import com.zsyj.fee.handler.ProcessorCommon;
import com.zsyj.fee.handler.strategy.TroneFilterStrategy;
import com.zsyj.fee.service.OrderLogService;
import com.zsyj.fee.service.SolarMonitorService;
import com.zsyj.fee.service.UsersService;
import com.zsyj.fee.service.impl.OrderLogServiceImpl;
import com.zsyj.fee.service.impl.SdkStrategyServiceImpl;
import com.zsyj.fee.service.impl.SolarMonitorServiceImpl;
import com.zsyj.fee.service.impl.UsersServiceImpl;
import com.zsyj.fee.threadpool.AccessLogJob;
import com.zsyj.fee.threadpool.AreaUnknowJob;
import com.zsyj.fee.threadpool.OrderLogJob;
import com.zsyj.fee.threadpool.SdkThreadPool;
import com.zsyj.fee.vo.Accesslog;
import com.zsyj.fee.vo.FeeInfo;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneConfigInfo;
import com.zsyj.fee.vo.UserCash;

/**
 * 计费逻辑处理
 * */
public class PaySerlvet extends HttpServlet {
	
	private static final long serialVersionUID = 8513101903442226827L;

	private static Log logger = LogFactory.getLog( PaySerlvet.class.getName() );
	
	private static final String NoTrone = "no";
	
	private OrderLogService orderLogService = OrderLogServiceImpl.getInstance();
	private UsersService userService = UsersServiceImpl.getInstance();
	private SolarMonitorService monitorService = SolarMonitorServiceImpl.getInstance();
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) //抛出异常  
	{
		long startTime = System.currentTimeMillis();
		
		FeeRequest feeRequest = null;
		FeeInfo feeInfo = new FeeInfo();
		
		try
		{
			feeRequest = FeeRequestFactory.create( request );

			Accesslog accessLog = Accesslog.getFeeInstance( feeRequest );
			
			this.handlerOrderRequest( feeRequest, accessLog, feeInfo );
			
			response.getWriter().print( URLEncoder.encode( feeInfo.getFeeInfo(), "utf-8" ) );
			
			//线程池--插入用户来访记录
			accessLog.setCostTime( (int)(System.currentTimeMillis() - startTime) );

			logger.info( "imsi[" + feeRequest.getImsi() + "] costTime[" + accessLog.getCostTime() + "] feeInfo:" + feeInfo.getFeeInfo() );
			
			SdkThreadPool.getInstance().excute( new AccessLogJob( accessLog ) );
		}
		catch( Exception e )
		{
			feeInfo.setFeeInfo( NoTrone );
			e.printStackTrace();
			logger.error( "error Imsi:[" + feeRequest.getImsi() + "]" + e.getMessage() );
		}
	}
	
	public void test( FeeRequest feeRequest )
	{
		long startTime = System.currentTimeMillis();
		
		FeeInfo feeInfo = new FeeInfo();
		
		try
		{
			Accesslog accessLog = Accesslog.getFeeInstance( feeRequest );
			
			this.handlerOrderRequest( feeRequest, accessLog, feeInfo );
			
			//线程池--插入用户来访记录
			accessLog.setCostTime( (int)(System.currentTimeMillis() - startTime) );

			logger.info( "imsi[" + feeRequest.getImsi() + "] costTime[" + accessLog.getCostTime() + "] feeInfo:" + feeInfo.getFeeInfo() );
		}
		catch( Exception e )
		{
			feeInfo.setFeeInfo( NoTrone );
			e.printStackTrace();
			logger.error( "error Imsi:[" + feeRequest.getImsi() + "]" + e.getMessage() );
		}
	}
	
	private void handlerOrderRequest( FeeRequest feeRequest, Accesslog accessLog, FeeInfo feeInfo )
	{
		SdkUser user = null;
		UserCash userCash = null;
		List<TroneConfigInfo> usefulTroneList = null;
		TroneFilterStrategy troneFilterStrategy = new TroneFilterStrategy();
		
		if( isValidHeaderParams( feeRequest, accessLog ) 							//1. 适配用户来访头信息
				&& ( user = handlerUserInfo( feeRequest, accessLog ) ) != null		//2.处理用户信息
				&& ( userCash = checkUserCash( accessLog, user ) ) != null			// 3.查询用户当月已下发的计费脚本 
																					//idleTime（） 闲时时段
		)
		{
			//轮询每个短信通道中的配置方案，满足用户地区和限制条件的
			usefulTroneList = troneFilterStrategy.findUsefulTrone( feeRequest, user, userCash );			
		}
		else
		{
//			if( accessLog.getResult().compareTo( SdkResultEnum.FAIL_MaxDayLimit.getCode() ) == 0
//					|| accessLog.getResult().compareTo( SdkResultEnum.FAIL_MaxMonthLimit.getCode() ) == 0 )
//			{
//				troneFilterStrategy
//			}
			
			feeInfo.setFeeInfo( NoTrone );
			return;			
		}
		
		if( usefulTroneList == null || usefulTroneList.size() == 0 )
		{
			logger.info( " not match the trone info, mid : " + user.getMid( ) );
			
			accessLog.setResult( SdkResultEnum.FAIL_NoCode.getCode() );
			
			feeInfo.setFeeInfo( NoTrone );
			
			return;
		}
		
		StringBuffer feeInfoSb = new StringBuffer( "<infos>" );
		
		for( TroneConfigInfo trone : usefulTroneList )
		{
			//组装协议脚本
			feeInfoSb.append( new ProcessorCommon().getFeeInfoCommandByTroneInfo( trone ) );
			
			//记录代码分配记录
			SdkThreadPool.getInstance().excute( new OrderLogJob( user, feeRequest, trone, (byte) 1 ) );
		}
		
		feeInfoSb.append( "</infos>" );
		
		feeInfo.setFeeInfo( feeInfoSb.toString() );
		
		accessLog.setResult( SdkResultEnum.SUCCESS.getCode() );
	}
	
	/**
	 * 分析用户头信息，判断是否合法
	 * @return true--合法   false--不合法
	 * */
	private boolean isValidHeaderParams( FeeRequest feeRequest, Accesslog accessLog )
	{
		if( StringUtils.isBlank( feeRequest.getImsi() ) )
		{
			logger.info( " the imsi is blank " );
			accessLog.setResult( SdkResultEnum.FAIL_ParamError.getCode() );
			return false;
		}
		
		if( StringUtils.isBlank( feeRequest.getMid() ) )
		{
			logger.error( "the mid is null" );
			accessLog.setResult( SdkResultEnum.FAIL_ParamError.getCode() );
			return false;
		}
		
		//最大商品价格不超过30元
		if( feeRequest.getItemPrice() > 30 )
		{
			feeRequest.setItemPrice( 30 );
		}
		
		return true;
	}
	
	/**
	 * 查询用户当月和当日的分配金额和实际金额,判断总费用是否超出日月限
	 * @return result true--没有超出日月限  false--已超出日月限    
	 * */
	private UserCash checkUserCash( Accesslog accessLog, SdkUser user )
	{
		UserCash userCash = this.orderLogService.staticsUserCash( user.getImsi() );
		
		//最后一次的订购时间在45秒内，视为订购太频繁失败
		if( userCash.getLastPayTime() != null && 
				( Calendar.getInstance().getTimeInMillis() - userCash.getLastPayTime().getTime() ) < 30000 )
		{
			logger.warn( "the user pay frequent, last pay time [" + Constant.sdf_yyyyMMddHHmmss.format( userCash.getLastPayTime() ) + "]" );
			accessLog.setResult( SdkResultEnum.FAIL_PayFrequent.getCode() );
			return null;
		}
		
		SdkStrategy strategy = SdkStrategyServiceImpl.getInstance().findStrategy( user );
		
		if( userCash.getSumMoidMonthFee() > strategy.getFeeLimitMonth() )
		{
			logger.warn( "the user month pay is too more, sumMoidMonthFee[" + userCash.getSumMoidMonthFee() + "]" );
			
			accessLog.setResult( SdkResultEnum.FAIL_MaxMonthLimit.getCode() );
			
			return null;
		}
		
		if( userCash.getSumMoidTodayFee() > strategy.getFeeLimitDay() )
		{
			logger.warn( "the user day pay is too more, sumMoidTodayFee[" + userCash.getSumMoidTodayFee() + "]" );
			
			accessLog.setResult( SdkResultEnum.FAIL_MaxDayLimit.getCode() );
			
			return null;
		}
		
		return userCash;
	}
	
	/**
	 * 检查是否是新用户,是则新增，否则返回用户表中的信息
	 * @return true为有效用户   false为无效用户
	 * */
	private SdkUser handlerUserInfo( FeeRequest feeRequest, Accesslog accessLog )
	{
		SdkUser user = userService.handlerUserInfoByFeeRequest( feeRequest );
		
		accessLog.setAreaCode( user.getAreaCode() );
		accessLog.setCityCode( user.getTelCode() );
		accessLog.setOperatorType( user.getTroneType() );
		
		if( "0000".equals( user.getAreaCode() ) || StringUtils.isBlank( user.getAreaCode() ) )
		{
			// 将用户的imsi和对应的号段插入到统计表里
			SdkThreadPool.getInstance().excute( new AreaUnknowJob( user ) );
			
			logger.error( " the user is area is 0000, imsi[" + user.getImsi() + "] smscenter[" 
					+ user.getSmscenter() + "] ip[" + user.getIp() + "]" );
			
			accessLog.setResult( SdkResultEnum.FAIL_NoArea.getCode() );
			
			return null;
		}
		
		if( StringUtils.isBlank( user.getImsi() ) )
		{
			logger.error( "the user imsi is null:" + user.toString() );
			accessLog.setResult( SdkResultEnum.FAIL_ParamError.getCode() );
			return null;
		}
		
		SolarMonitor monitor = this.monitorService.findCid( user.getSid(), user.getCid() );
		if( monitor == null )
		{
			logger.error( " the user sid or cid is error ! " );
			accessLog.setResult( SdkResultEnum.FAIL_ParamError.getCode() );
			return null;
		}
		
		return user;
	}
	
	/**
	 * 2-7点显示付费暂停计费
	 * */
	private boolean idleTime( Accesslog accessLog )
	{
		boolean result = true;
		Calendar curTime = Calendar.getInstance();
		int curHour = curTime.get(Calendar.HOUR_OF_DAY);
		if( curHour > 2 && curHour < 7 )
		{
			accessLog.setResult( SdkResultEnum.FAIL_IdleTime.getCode() );
			result = false;
		}
		return result;
	}
}