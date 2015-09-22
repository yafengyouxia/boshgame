package com.zsyj.fee.schedule;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.mail.MailConstans;
import com.zsyj.fee.common.mail.MailSenderInfo;
import com.zsyj.fee.common.mail.SimpleMailSender;
import com.zsyj.fee.entity.CfgSdkTrone;
import com.zsyj.fee.entity.CfgSpCompany;
import com.zsyj.fee.service.CfgSdkTroneService;
import com.zsyj.fee.service.SolarChargeService;
import com.zsyj.fee.service.SpCompanyService;
import com.zsyj.fee.service.impl.CfgSdkTroneServiceImpl;
import com.zsyj.fee.service.impl.SolarChargeServiceImpl;
import com.zsyj.fee.service.impl.SpCompanyServiceImpl;
import com.zsyj.fee.vo.SpData;

/**
 * 实时监控sp的日限，超出日限即刻报警并关停
 * @author ROOT
 */
public class CodeLimitDayAlarmTask extends AbstractScheduleTask{
	
	private static final Logger logger = LoggerFactory.getLogger(CodeLimitDayAlarmTask.class);
	
	private SpCompanyService spCompanyService = SpCompanyServiceImpl.getInstance();
	private SolarChargeService solarChargeService = SolarChargeServiceImpl.getInstance();
	private CfgSdkTroneService sdkTroneService = CfgSdkTroneServiceImpl.getInstance();
	
	private static Calendar lastTime = Calendar.getInstance();
	
	/*
	 * 垫付sp
	 * */
	private static Map<Integer, Integer> DFSpLimitCodeMap = new HashMap<Integer, Integer>();
	
	public CodeLimitDayAlarmTask(long delay, long interval) {
		super(delay, interval);
	}
	
	@Override
	public void work() {
		
		try
		{
			logger.info( "=============== start check code limit day" );
			
			Calendar curTime = this.initTime();
			
			this.checkSpLimitDay( curTime );
		}
		catch( Exception e )
		{
			e.printStackTrace();
			logger.error( "error:" + e.getMessage() );
		}
	}
	
	private Calendar initTime()
	{
		Calendar curTime = Calendar.getInstance();
		curTime.set(Calendar.HOUR_OF_DAY, 0);
		curTime.set(Calendar.MINUTE, 0);
		curTime.set(Calendar.SECOND, 0);
		
		if( curTime.get(Calendar.DAY_OF_YEAR) != lastTime.get(Calendar.DAY_OF_YEAR) )
		{
			DFSpLimitCodeMap.clear();
			lastTime = curTime;
		}
		
		return curTime;
	}
	
	private void checkSpLimitDay( Calendar curTime )
	{
		Map<Integer, CfgSpCompany> spCompanyMap = spCompanyService.findAll();
		
		List<SpData> spDataList = solarChargeService.findSpData( curTime.getTime() );
		
		if( spDataList != null && spDataList.size() > 0 )
		{
			for( SpData spData : spDataList )
			{
				CfgSpCompany spCompany = spCompanyMap.get( spData.getSpId() );
				
				logger.info( "spData:" + spData.toString() );
				
				if( spCompany != null && spCompany.getLimitDay() > 0 
						&& (spCompany.getLimitDay()*0.96) <= spData.getSuccessMoney() )
				{
					closeCodeBySp( spCompany );
				}
			}
		}
	}
	
	private void closeCodeBySp( CfgSpCompany spCompany )
	{
		List<CfgSdkTrone> sdkTroneList = sdkTroneService.findBySpid( spCompany.getSpSid() );
		
		if( sdkTroneList != null && sdkTroneList.size() > 0 )
		{
			boolean result = false;
			for( CfgSdkTrone sdkTrone: sdkTroneList )
			{
				if( sdkTrone.getStatus().compareTo( (byte)2 ) != 0 )  //非开启状态
				{
					logger.info( "start to close the trone code!" + sdkTrone.toString() );
					
					sdkTrone.setStatus( (byte)2 );	//0--激活    1--禁用     2--日限满关闭
					result = this.sdkTroneService.update(sdkTrone);
				}
			}
			
			String content = spCompany.getTitle() + "已达日限" + spCompany.getLimitDay()
					+ "元,关停" + (result?"成功":"失败");
			
			this.sendAlarmMail( result, spCompany, content );
		}
		else
		{
			if( DFSpLimitCodeMap.get( spCompany.getSpSid() ) == null )
			{
				logger.info( "垫付已达日限:" + spCompany.getSpSid() + spCompany.getTitle() );
				
				DFSpLimitCodeMap.put( spCompany.getSpSid(), spCompany.getSpSid() );
				
				String content = spCompany.getTitle() + "垫付已达日限" + spCompany.getLimitDay()
						+ "元,请即刻通知渠道关停";
				
				this.sendAlarmMail( true, spCompany, content );	
			}
		}
	}
	
	private void sendAlarmMail( boolean result, CfgSpCompany spCompany, String content  )
	{
		if( !result )
		{
			return;
		}
		
		String subject = "WARN";
		
		SimpleMailSender sms = new SimpleMailSender();
		MailSenderInfo mailInfo = MailSenderInfo.getInstance();
		
		//13922820502@139.com  李十子
		//13922820373@139.com  谭颖骞
		for( String mail : MailConstans.businessMailList )
		{
			mailInfo.setToAddress( mail );
			mailInfo.setSubject( subject );
			mailInfo.setContent( content );
			
			sms.sendTextMail(mailInfo);// 发送文体格式
		}
	}
}