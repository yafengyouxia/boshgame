package com.zsyj.fee.schedule;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.mail.MailConstans;
import com.zsyj.fee.common.mail.MailSenderInfo;
import com.zsyj.fee.common.mail.SimpleMailSender;
import com.zsyj.fee.entity.CfgSpCompany;
import com.zsyj.fee.service.OrderLogService;
import com.zsyj.fee.service.SolarChargeService;
import com.zsyj.fee.service.SpCompanyService;
import com.zsyj.fee.service.impl.OrderLogServiceImpl;
import com.zsyj.fee.service.impl.SolarChargeServiceImpl;
import com.zsyj.fee.service.impl.SpCompanyServiceImpl;
import com.zsyj.fee.vo.SpData;

/**
 * 实时监控代码的转化率
 * 
 * 1.每间隔半小时统计各个产品最近一小时的订单转化是否低于5%，如果是则报警（是否关停？）
 * 2. 每间隔半小时统计各个产品最近一小时的订单转化，相较之前的转化，是否降低超过65%，如果是则报警（是否关停）
 * @author ROOT
 */
public class CodeConversionAlarmTask extends AbstractScheduleTask{
	
	private static final Logger logger = LoggerFactory.getLogger(CodeConversionAlarmTask.class);
	
	private SpCompanyService spCompanyService = SpCompanyServiceImpl.getInstance();
	private SolarChargeService solarChargeService = SolarChargeServiceImpl.getInstance();
	private OrderLogService orderLogService = OrderLogServiceImpl.getInstance();
	
	private static Calendar lastTime = Calendar.getInstance();
	private static Map<Integer, Double> lastHourConversionMap = new HashMap<Integer, Double>();
	
	public CodeConversionAlarmTask(long delay, long interval) {
		super(delay, interval);
	}
	
	@Override
	public void work() {
		
		try
		{
			logger.info( "=============== start check spcode conversion day" );
			
			Calendar lastHourTime = initTime();
			
			this.checkSpConversion( lastHourTime );
			
			lastTime = lastHourTime;
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
		
		//跨越更新环比数据
		if( lastTime.get(Calendar.MONTH) != curTime.get(Calendar.MONTH) )
		{
			lastHourConversionMap.clear();
		}
		
		curTime.add(Calendar.HOUR_OF_DAY, -1);
		
		return curTime;
	}
	
	private void checkSpConversion( Calendar lastHourTime )
	{
		String content = "";
		Map<Integer, CfgSpCompany> spCompanyMap = spCompanyService.findAll();
		
		Map<Integer, SpData> chargeSpDataMap = convertListToMap( solarChargeService.findSpData( lastHourTime.getTime() ) );
		Map<Integer, SpData> orderSpDataMap =  convertListToMap( orderLogService.findSpData(lastHourTime.getTime()) );
		
		Iterator<Integer> orderIterator = orderSpDataMap.keySet().iterator();
		
		while( orderIterator.hasNext() )
		{
			SpData orderSpData = orderSpDataMap.get( orderIterator.next() );
			
			SpData chargeSpData = chargeSpDataMap.get( orderSpData.getSpId() );
			
			CfgSpCompany spCompany = spCompanyMap.get( orderSpData.getSpId() );
			
			//排除开胡静的电信代码1026
			if( spCompany != null && spCompany.getSpSid() != 1026 )
			{
				double orderSucMoney = orderSpData.getSuccessMoney();
				double chargeSucMoney = chargeSpData==null?0D:chargeSpData.getSuccessMoney();
				
				double conversion = orderSucMoney==0D?0D:chargeSucMoney/orderSucMoney;
				
				Double lastHourConversion = lastHourConversionMap.get( orderSpData.getSpId() );
				
				//转化率低于5%或者环比下降35%
				if( lastHourConversion == null || ( lastHourConversion >= 0.05 && conversion < 0.05 ) )
				{
					content = spCompany.getTitle() + "转化率" + conversion + ",低于5%，请检查";
					
					logger.info( "orderSpData:" + orderSpData + content );
					
					this.sendAlarmMail( "转化率低", spCompany, content );
				}
				else if( lastHourConversion != null && lastHourConversion > 0 && conversion/lastHourConversion < 0.35 
						&& conversion < 0.15 )
				{
					content = spCompany.getTitle() + "转化率位" + conversion/lastHourConversion + ",环比下降35%以上，请检查";
					
					logger.info( "orderSpData:" + orderSpData + content );
					
					this.sendAlarmMail( "转化率下降", spCompany, content );
				}
				
				lastHourConversionMap.put( orderSpData.getSpId(), conversion );
			}
		}
	}
	
	private Map<Integer, SpData> convertListToMap( List<SpData> spDataList )
	{
		Map<Integer, SpData> map = new HashMap<Integer, SpData>();
		
		if( spDataList != null )
		{
			for( SpData spData : spDataList )
			{
				map.put(spData.getSpId(), spData);
			}
		}
		return map;
	}
	
	private void sendAlarmMail( String subject, CfgSpCompany spCompany, String content  )
	{
		SimpleMailSender sms = new SimpleMailSender();
		MailSenderInfo mailInfo = MailSenderInfo.getInstance();
		
		for( String mail : MailConstans.codeConversionMailList )
		{
			mailInfo.setToAddress( mail );
			mailInfo.setSubject( subject );
			mailInfo.setContent( content );
			
			sms.sendTextMail(mailInfo);// 发送文体格式
		}
	}
}