package com.zsyj.fee.syn;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.Constant;
import com.zsyj.fee.entity.SdkSynurlLog;
import com.zsyj.fee.entity.SolarAgent;
import com.zsyj.fee.entity.SolarCharge;
import com.zsyj.fee.entity.SolarMonitor;
import com.zsyj.fee.handler.ProcessorCommon;
import com.zsyj.fee.service.OrderLogService;
import com.zsyj.fee.service.SdkSynUrlLogService;
import com.zsyj.fee.service.SolarChargeService;
import com.zsyj.fee.service.SolarMonitorService;
import com.zsyj.fee.service.TroneConfigInfoService;
import com.zsyj.fee.service.impl.OrderLogServiceImpl;
import com.zsyj.fee.service.impl.SdkSynUrlLogServiceImpl;
import com.zsyj.fee.service.impl.SolarChargeServiceImpl;
import com.zsyj.fee.service.impl.SolarMonitorServiceImpl;
import com.zsyj.fee.service.impl.TroneConfigInfoServiceImpl;
import com.zsyj.fee.service.impl.UsersServiceImpl;
import com.zsyj.fee.vo.AreaInfo;
import com.zsyj.fee.vo.OrderLog;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneConfigInfo;

public class SmsChargeJob implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(SmsChargeJob.class);
	
	private ProcessorCommon processorCommon = new  ProcessorCommon();
	
	private SolarCharge solarCharge;
	private SolarChargeService solarChargeService = SolarChargeServiceImpl.getInstance();
	private TroneConfigInfoService troneConfigInfoService = TroneConfigInfoServiceImpl.getInstance();
	private OrderLogService orderLogService = OrderLogServiceImpl.getInstance();
	private SdkSynUrlLogService sdkSynUrlLogService = SdkSynUrlLogServiceImpl.getInstance();
	private SolarMonitorService solarMonitorService = SolarMonitorServiceImpl.getInstance();
	
	public SmsChargeJob( SolarCharge solarCharge )
	{
		this.solarCharge = solarCharge;
		
		this.solarCharge.setDisconnectTime( new Date() );
		
		if( StringUtils.isNotBlank( solarCharge.getMobile() ) && solarCharge.getMobile().startsWith( "86" ) )
		{
			solarCharge.setMobile( solarCharge.getMobile().substring(2) );
		}
	}
	
	@Override
	public void run( ) 
	{
		try
		{
			this.processCharge( solarCharge );
		}
		catch( Exception e ) 
		{
			e.printStackTrace();
			logger.error( e.getMessage() );
		}
	}
	
	public boolean processCharge( SolarCharge solarCharge )
	{
		boolean result = true;
		TroneConfigInfo troneInfo = null;
		
		try
		{
			// 检查solarcharge表中是否有重复记录
			if ( solarChargeService.findByLinkId( solarCharge.getLinkId() ) != null ) 
			{
				logger.error("have the repeat log, charge:" + solarCharge);
				return result;
			}
			
			OrderLog orderLog = this.orderLogService.findByOrderId( solarCharge.getOrderId() );
			
			if( orderLog != null )
			{
				logger.info( "find the orderLog:" + orderLog.toString() );
				
				this.solarCharge.setUserSid( orderLog.getSid() );
				this.solarCharge.setUserCid( orderLog.getCid() );
				this.solarCharge.setImsi( orderLog.getImsi() );
				this.solarCharge.setSaleId( orderLog.getSaleId() );
				this.solarCharge.setCpId( orderLog.getCpId() );
				this.solarCharge.setAppId( orderLog.getAppid() );
				this.solarCharge.setArea( orderLog.getAreaCode() );
				this.solarCharge.setCity( orderLog.getTelCode() );
				this.solarCharge.setSpid( orderLog.getSpid() );
				this.solarCharge.setTroneType( orderLog.getOperatorType() );
				this.solarCharge.setUsedCash( orderLog.getPrice() );
				this.solarCharge.setServiceCode( orderLog.getServicecode() );
				
				//更新分配表状态
				this.synMoidStaus( solarCharge, orderLog );
			}
			else
			{
				//根据imsi查询用户信息，补全运营商、渠道号、地区等信息
				solarCharge = this.findUser( solarCharge );
				
				// 根据通道号码+通道指令+用户省份查询通道配置
				troneInfo = this.findTroneByCharge(solarCharge);
				
				//solarCharge.setStatus( "-1NoOrder" );
			}
			
			//扣量比例
			handlerOperator( solarCharge, troneInfo );
			
			//添加同步URL
			if( StringUtils.isNotBlank( solarCharge.getUserSid() ) )
			{
				this.addSynUrlLog( solarCharge );				
			}
			
			logger.info( " start process charge[" + solarCharge.toString() + "]" );
			
			// 添加消费记录
			this.solarChargeService.inseartSolarCharge(solarCharge);
		}
		catch( Exception e )
		{
			result = false;
			e.printStackTrace();
			logger.error( e.getMessage() );
		}
		
		return result;
	}
	
	private void handlerOperator( SolarCharge solarCharge, TroneConfigInfo troneInfo )
	{
		//pv刷量的订单不用同步给渠道，默认C掉
		if( troneInfo != null && troneInfo.getIsFreshPv() == 1 )
		{
			solarCharge.setOperator( (byte)2 );
			return;
		}
		
		SolarMonitor monitor = solarMonitorService.findCid(solarCharge.getUserSid(), solarCharge.getUserCid());
		if( monitor != null )
		{
			int randomKey = new Random().nextInt( 100 ) + 1;
			if( randomKey > monitor.getMoneyRate()*100 )
			{
				solarCharge.setOperator( (byte)2 );
			}
			else
			{
				solarCharge.setOperator( (byte)1 );
			}
		}
		else
		{
			//找不到渠道就默认算扣掉
			solarCharge.setOperator( (byte)2 );	
		}
	}
	
	/**
	 * 将成功状态同步一份到分配记录
	 * */
	private void synMoidStaus( SolarCharge solarCharge, OrderLog orderLog )
	{
		if( StringUtils.isNotBlank( solarCharge.getOrderId() ) && "1".equals( solarCharge.getStatus() ) )
		{
			orderLog.setStatus( 2 );
			
			logger.info( orderLog.toString() );
			
			this.orderLogService.update( orderLog );
		}
	}
	
	private SolarCharge findUser( SolarCharge solarCharge )
	{
		SdkUser user = null;
		
		if( StringUtils.isBlank( solarCharge.getMobile() ) || StringUtils.isBlank( solarCharge.getImsi() ) )
		{
			return solarCharge;
		}
		
		if( StringUtils.isNotBlank( solarCharge.getImsi( ) ) )
		{
			user = UsersServiceImpl.getInstance().findByImsi( solarCharge.getImsi( ) );
			
			if( user != null )
			{
				solarCharge.setUserSid( user.getSid() );
				solarCharge.setUserCid( user.getCid() );
				solarCharge.setAppId( user.getAppid() + "" );
				solarCharge.setCpId( Integer.valueOf( user.getCpid() ) );
				
				if( user.getTroneType() > -1 )
				{
					solarCharge.setTroneType( user.getTroneType() );
				}
				
				if( user.getAreaCode() != null 
						&& !"0000".equals( user.getAreaCode() ) )
				{
					solarCharge.setArea( user.getAreaCode() );
					solarCharge.setCity( user.getTelCode() );
				}
			}
		}
		
		
		if( user == null || solarCharge.getTroneType() < 0 )
		{
			solarCharge.setTroneType( processorCommon.findTroneType( solarCharge.getImsi(), solarCharge.getMobile() ) );				
		}
		
		if( user == null || StringUtils.isBlank( solarCharge.getArea() ) )
		{
			AreaInfo areaInfo = processorCommon.findUserProvinceArea( solarCharge.getMobile(), "", 
					solarCharge.getImsi(), null, null );
			
			if( areaInfo != null )
			{
				solarCharge.setArea( areaInfo.getProvinceCode() );
				solarCharge.setCity( areaInfo.getTelCode() );
				solarCharge.setTroneType( areaInfo.getTroneType() );
			}
		}
		
		return solarCharge;
	}
	
	/**
	 * 根据通道号码+通道指令+用户省份查询通道配置
	 * @return true 查找到对应的通道信息，  false没有查找到对应的通道信息
	 **/
	private TroneConfigInfo findTroneByCharge( SolarCharge solarCharge )
	{
		// 根据通道号码+通道指令+用户省份查询通道配置
		TroneConfigInfo troneConfig = this.troneConfigInfoService.findBySpNumAndMsgText( solarCharge.getTrone(),
				solarCharge.getMo(),  solarCharge.getServiceCode(), solarCharge.getUsedCash() );
		
		if (troneConfig != null) 
		{
			if( solarCharge.getUsedCash() == null || solarCharge.getUsedCash() <= 0 )
			{
				solarCharge.setUsedCash( troneConfig.getFee() );	
			}
			
			solarCharge.setServiceCode( troneConfig.getServiceCode() );
			
			solarCharge.setTroneType( troneConfig.getTroneType() );
			
			if( solarCharge.getSpid() == null || solarCharge.getSpid() <= 0 ) 
			{
				solarCharge.setSpid( Integer.valueOf( troneConfig.getSpId() ) );	
			}
		}
		else
		{
			logger.error( "the trone is not found " );
		}
		
		return troneConfig;
	}
	
	public void addSynUrlLog( SolarCharge solarCharge )
	{
		SolarAgent solarAgent = solarMonitorService.findSid(solarCharge.getUserSid());
		
		if( solarAgent != null && StringUtils.isNotBlank( solarAgent.getSynUrl() ) )
		{
			String synBodyContent = packageSynBody( solarCharge );
			
			SdkSynurlLog sdkSynurlLog = new SdkSynurlLog();
			sdkSynurlLog.setCpid( Integer.valueOf( solarCharge.getUserSid() ) );
			sdkSynurlLog.setSmsConfigId( solarCharge.getSpid() );
			sdkSynurlLog.setSynUrl( solarAgent.getSynUrl() );
			sdkSynurlLog.setPostBody( synBodyContent );
			sdkSynurlLog.setHttpMethod( (byte)1 );  //0--get   1--post
			sdkSynurlLog.setType( (byte)1 ); //0-df  1--sdk
			sdkSynurlLog.setLinkId( solarCharge.getOrderId() );
			sdkSynurlLog.setAddTime( new Date() );
			
			if( solarCharge.getOperator().compareTo( (byte)2 ) == 0 )
			{
				sdkSynurlLog.setStatus( (byte)-2 );	//-2 sdkC掉    -1DFC掉不同步   0--待同步  1--成功 2--失败				
			}
			else
			{
				sdkSynurlLog.setStatus( (byte)0 );	//-1C掉不同步   0--待同步  1--成功 2--失败
			}
			
			this.sdkSynUrlLogService.insert( sdkSynurlLog );
		}
		else
		{
			logger.error( " not found the sid or the synUrl is not exsit : " + solarCharge.toString() );
		}
	}
	
	private String packageSynBody( SolarCharge solarCharge )
	{
		StringBuffer synContent = new StringBuffer();
		
		synContent.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
		synContent.append( "<request>" )
			.append( "<sid>" + solarCharge.getUserSid() + "</sid>" )
			.append( "<cid>" + solarCharge.getUserCid() + "</cid>" )
			.append( "<price>" + solarCharge.getUsedCash() + "</price>" ).append( "<imsi>" + solarCharge.getImsi() + "</imsi>" )
			.append( "<feetype>0</feetype>" )
			.append( "<paycode>" + solarCharge.getMo() + "</paycode>" ).append( "<hRet>" + solarCharge.getStatus() + "</hRet>" )
			.append( "<resulttime>" + Constant.sdf_yyyyMMddHHmmss.format( solarCharge.getDisconnectTime() ) + "</resulttime>" )
			.append( "<uniqueid>" + solarCharge.getLinkId() + "</uniqueid>" )
			.append( "<cpparam>" + solarCharge.getOrderId() + "</cpparam>" )
			.append( "</request>" );
		
		return synContent.toString();
	}
}
