package com.zsyj.fee.syn;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.entity.AdvanceCompany;
import com.zsyj.fee.entity.AdvanceConfig;
import com.zsyj.fee.entity.SdkSynurlLog;
import com.zsyj.fee.entity.SmsconfigInfo;
import com.zsyj.fee.entity.SolarCharge;
import com.zsyj.fee.handler.ProcessorCommon;
import com.zsyj.fee.service.AdvanceService;
import com.zsyj.fee.service.SdkSynUrlLogService;
import com.zsyj.fee.service.SmsConfigInfoService;
import com.zsyj.fee.service.SolarChargeService;
import com.zsyj.fee.service.impl.AdvanceServiceImpl;
import com.zsyj.fee.service.impl.SdkSynUrlLogServiceImpl;
import com.zsyj.fee.service.impl.SmsConfigInfoServiceImpl;
import com.zsyj.fee.service.impl.SolarChargeServiceImpl;
import com.zsyj.fee.vo.AreaInfo;

public class DFSmsChargeJob implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(DFSmsChargeJob.class);
	
	private ProcessorCommon processorCommon = new  ProcessorCommon();
	
	private SolarCharge solarCharge;
	private String synContent = null;
	private SolarChargeService solarChargeService = SolarChargeServiceImpl.getInstance();
	private SmsConfigInfoService troneConfigInfoService = SmsConfigInfoServiceImpl.getInstance();
	private AdvanceService advanceService = AdvanceServiceImpl.getInstance();
	private SdkSynUrlLogService sdkSynUrlLogService = SdkSynUrlLogServiceImpl.getInstance();
	
	public DFSmsChargeJob( SolarCharge solarCharge, String synContent ) {
		
		this.synContent = synContent;
		this.solarCharge = solarCharge;
		
		this.solarCharge.setDisconnectTime( new Date() );
		
		if( StringUtils.isNotBlank( solarCharge.getMobile() ) && solarCharge.getMobile().startsWith( "86" ) ){
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
	
	public void processCharge( SolarCharge solarCharge )
	{
		try
		{
			// 检查solarcharge表中是否有重复记录
			if ( solarChargeService.findByLinkId( solarCharge.getLinkId() ) != null ) 
			{
				logger.error("have the repeat log, charge:" + solarCharge);
				return;
			}
			
			//根据imsi查询用户信息，补全运营商、渠道号、地区等信息
			this.findAreaInfo( solarCharge );
			
			// 根据通道号码+通道指令+用户省份查询通道配置
			SmsconfigInfo smsconfigInfo =this.findTroneByCharge(solarCharge);
			
			if( smsconfigInfo != null )
			{
				this.handleChargeOperator( solarCharge, smsconfigInfo );				
			}
			else //非垫付代码,自由代码
			{
				new SmsChargeJob( solarCharge ).run();
				return;
			}
			
			logger.info( " start process charge[" + solarCharge.toString() + "]" );
			
			// 添加消费记录
			this.solarChargeService.inseartSolarCharge(solarCharge);
		}
		catch( Exception e )
		{
			e.printStackTrace();
			logger.error( e.getMessage() );
		}
	}
	
	private SolarCharge findAreaInfo( SolarCharge solarCharge )
	{
		if( StringUtils.isBlank( solarCharge.getMobile() ) && StringUtils.isBlank( solarCharge.getImsi() ) )
		{
			return solarCharge;
		}
		
		if( solarCharge.getTroneType() < 0 )
		{
			solarCharge.setTroneType( processorCommon.findTroneType( solarCharge.getImsi(), solarCharge.getMobile() ) );				
		}
		
		if( StringUtils.isBlank( solarCharge.getArea() ) )
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
	private SmsconfigInfo findTroneByCharge( SolarCharge solarCharge )
	{
		// 根据通道号码+通道指令+用户省份查询通道配置
		SmsconfigInfo troneConfig = this.troneConfigInfoService.findBySpNumAndMsgText( solarCharge.getTrone(),
				solarCharge.getMo() );
		
		if (troneConfig != null) {
			
			if( solarCharge.getUsedCash() == null || solarCharge.getUsedCash() <= 0 ){
				solarCharge.setUsedCash( Double.valueOf( troneConfig.getFee() ) );	
			}
			
			solarCharge.setServiceCode( troneConfig.getServicecode() );
			
			solarCharge.setTroneType( troneConfig.getTronetype() );
			
			if( solarCharge.getSpid() == null || solarCharge.getSpid() <= 0 ) {
				solarCharge.setSpid( Integer.valueOf( troneConfig.getBelong() ) );	
			}
		}
		else
		{
			logger.error( " not found the smsconfiginfo, the trone is not found " );
		}
		
		return troneConfig;
	}
	
	/**
	 * 根据配置参数设置charge的operator字段： 
	 * 0. 老后台的用户或者未注册的用户   
	 * 1. 已注册用户--正常 
	 * 2. 已注册用户--厂商扣量  
	 * 3. 垫付--同步给垫付的正常计费   4. 垫付--扣量
	 * */
	private void handleChargeOperator( SolarCharge solarCharge, SmsconfigInfo smsconfigInfo ) {
		
		logger.info( " smsConfigId: " +  smsconfigInfo.toString() + " usersid: " + solarCharge.getUserSid() );
		
		AdvanceConfig advanceConfig = this.advanceService.findBySmsId( smsconfigInfo.getSysid(), solarCharge.getUserSid() );
		
		if ( advanceConfig == null )
		// 没有垫付配置或者找不到通道则默认扣掉
		{
			solarCharge.setOperator( (byte)4 );
		}
		else
		{
			solarCharge.setUserCid( advanceConfig.getCid() );
			solarCharge.setCpId( Integer.valueOf( advanceConfig.getCid() ) );
			
			//DF同步配置未开启,默认扣除
			if( advanceConfig.getStatus() != 0 )
			{
				solarCharge.setOperator( (byte)4 );
			}
			else
			{
				int randomInt = new Random().nextInt(100);
				
				logger.info( "linkid[" + solarCharge.getLinkId() + "]command[" + solarCharge.getMo() + "]randomInt[" + randomInt 
						+ "] advanceConfig percent[" + advanceConfig.getPercent() + "]" 
						+ " serviceId:" + solarCharge.getServiceCode() + " userSid:" + solarCharge.getUserSid() + " feeDayCount: waitfocomplete " );
				
				if( randomInt < advanceConfig.getPercent() )
				{
					solarCharge.setOperator( (byte)4 );
				}
				else
				{
					solarCharge.setOperator( (byte)3 );
				}
				
				addSynUrlLog( solarCharge, smsconfigInfo, advanceConfig );
			}
		}
		
		
	}   
	
	private void addSynUrlLog( SolarCharge solarCharge, SmsconfigInfo smsconfigInfo, AdvanceConfig advanceConfig )
	{
		AdvanceCompany advanceCompany = this.advanceService.findCpCompany( Integer.valueOf( advanceConfig.getCid() ) );
		
		if( advanceCompany != null )
		{
			SdkSynurlLog sdkSynurlLog = new SdkSynurlLog();
			sdkSynurlLog.setCpid( solarCharge.getCpId() );
			sdkSynurlLog.setSmsConfigId( smsconfigInfo.getSysid() );
			sdkSynurlLog.setSynUrl( advanceCompany.getSychronizeUrl() );
			sdkSynurlLog.setPostBody( this.synContent );
			sdkSynurlLog.setHttpMethod( (byte)1 );  //0--get   1--post
			sdkSynurlLog.setType( (byte)0 ); //0-df
			sdkSynurlLog.setLinkId( solarCharge.getLinkId() );
			sdkSynurlLog.setAddTime( new Date() );
			
			if( solarCharge.getOperator().compareTo( (byte)3 )  == 0 )
			{
				sdkSynurlLog.setStatus( (byte)0 );	//0--待同步  1--成功 2--失败
			}
			else
			{
				sdkSynurlLog.setStatus( (byte)-1 );	// -1C掉不同步 0--待同步  1--成功 2--失败
			}
			
			this.sdkSynUrlLogService.insert( sdkSynurlLog );	
		}
		else
		{
			logger.error( "not found the cid : " + advanceConfig.getCid() );
		}
	}
}
