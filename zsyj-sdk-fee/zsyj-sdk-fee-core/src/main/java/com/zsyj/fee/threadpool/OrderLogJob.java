package com.zsyj.fee.threadpool;

import java.util.Calendar;
import java.util.Date;

import com.zsyj.fee.common.Constant;
import com.zsyj.fee.entity.SdkOrderLog;
import com.zsyj.fee.entity.SolarAgent;
import com.zsyj.fee.service.SolarMonitorService;
import com.zsyj.fee.service.impl.OrderLogServiceImpl;
import com.zsyj.fee.service.impl.SolarMonitorServiceImpl;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneConfigInfo;

public class OrderLogJob implements Runnable{

	private SdkOrderLog orderLog = null;
	
	private SolarMonitorService monitorService = SolarMonitorServiceImpl.getInstance();
	
	/**
	 * @param user
	 * @param feeRequest
	 * @param trone
	 * @param orderType 0--登录订单   1--支付订单  2--pv订单
	 */
	public OrderLogJob( SdkUser user, FeeRequest feeRequest, TroneConfigInfo trone, Byte orderType )
	{
		orderLog = new SdkOrderLog();
		orderLog.setTableName( "sdk_order_log"+Constant.sdf_yyyyMM.format( Calendar.getInstance().getTime() ) );
		orderLog.setServicecode( trone.getServiceCode() );
		orderLog.setContent( trone.getCommand() );
		orderLog.setOrderId( trone.getOrderId() );
		orderLog.setImsi( user.getImsi() );
		orderLog.setUuid( user.getUuid() );
		orderLog.setMobile( user.getMobile() );
		orderLog.setAppid( user.getAppid() );
		orderLog.setCpId( Integer.valueOf( user.getCpid()==null?"0":user.getCpid() ) );
		orderLog.setSid( user.getSid() );
		orderLog.setCid( user.getCid() );
		orderLog.setFeeTimes( trone.getFeeTimes() );
		orderLog.setOperatorType( trone.getTroneType() );
		orderLog.setAreaCode( user.getAreaCode() );
		orderLog.setTelCode( user.getTelCode() );
		orderLog.setPrice( trone.getFee() );
		orderLog.setSpid( Integer.valueOf( trone.getSpId() ) );
		orderLog.setStatus( 0 );
		orderLog.setOrderType( orderType );
		orderLog.setLogtime( new Date(  ) );
		
		SolarAgent agent = monitorService.findSid( user.getSid() );
		if( agent != null )
		{
			orderLog.setSaleId( agent.getSaleUserId() );			
		}
	}
	
	@Override
	public void run() 
	{
		if( this.orderLog != null )
		{
			OrderLogServiceImpl.getInstance().insertOrderLog( this.orderLog );
			
			orderLog = null;
		}
	}

}