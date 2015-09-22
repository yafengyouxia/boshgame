package com.zsyj.fee.service;

import java.util.List;

import com.zsyj.fee.entity.SmsconfigInfo;

/** 短信通道配置smsconfigifo
 * 
 * @author hujian
 */
public interface SmsConfigInfoService {

	/**
	 * 根据通道号和短信内容查询符合条件的通道
	 * */
	public SmsconfigInfo findBySpNumAndMsgText( String spNum, String msgText );
	
	public List<SmsconfigInfo> getAllSmsConfigInfo();
}