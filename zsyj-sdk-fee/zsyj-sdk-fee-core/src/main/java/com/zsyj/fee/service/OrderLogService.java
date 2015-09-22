package com.zsyj.fee.service;

import java.util.Date;
import java.util.List;

import com.zsyj.fee.entity.SdkOrderLog;
import com.zsyj.fee.vo.OrderLog;
import com.zsyj.fee.vo.SpData;
import com.zsyj.fee.vo.UserCash;

public interface OrderLogService 
{
	public boolean insertOrderLog( SdkOrderLog orderLog );
	
	//查询用户当月订购记录
	public List<OrderLog> findMonthLogListByImsi( String uuid );

	public OrderLog findByOrderId( String orderId );
	
	public void update( OrderLog orderLog );
	
	public void updateStatusByOrderId( String orderId, int status );
	
	//统计用户当月的订购情况
	public UserCash staticsUserCash( String imsi );
	
	public List<SpData> findSpData( Date startTime );
}
