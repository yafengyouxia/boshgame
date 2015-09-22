package com.zsyj.fee.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.zsyj.fee.entity.SdkOrderLog;

public class OrderLog extends SdkOrderLog implements Serializable  {
	
	private static final long serialVersionUID = 6334148282255825124L;

	public static OrderLog getInstance( SdkOrderLog sdkOrder )
	{
		OrderLog orderLog = new OrderLog();
		orderLog.setServicecode( sdkOrder.getServicecode() );
		orderLog.setContent( sdkOrder.getContent() );
		orderLog.setOrderId( sdkOrder.getOrderId() );
		orderLog.setImsi( sdkOrder.getImsi() );
		orderLog.setUuid( sdkOrder.getUuid() );
		orderLog.setMobile( sdkOrder.getMobile() );
		orderLog.setAppid( sdkOrder.getAppid() );
		orderLog.setSaleId( sdkOrder.getSaleId() );
		orderLog.setCpId( sdkOrder.getCpId() );
		orderLog.setSid( sdkOrder.getSid() );
		orderLog.setCid( sdkOrder.getCid() );
		orderLog.setCpId( sdkOrder.getCpId() );
		orderLog.setFeeTimes( sdkOrder.getFeeTimes() );
		orderLog.setOperatorType( sdkOrder.getOperatorType() );
		orderLog.setAreaCode( sdkOrder.getAreaCode() );
		orderLog.setTelCode( sdkOrder.getTelCode() );
		orderLog.setPrice( sdkOrder.getPrice() );
		orderLog.setSpid( sdkOrder.getSpid() );
		orderLog.setStatus( sdkOrder.getStatus() );
		orderLog.setLogtime( sdkOrder.getLogtime() );
		return orderLog;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
