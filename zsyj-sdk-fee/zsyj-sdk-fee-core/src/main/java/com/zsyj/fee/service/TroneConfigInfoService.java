package com.zsyj.fee.service;

import java.util.List;

import com.zsyj.fee.vo.TroneConfigInfo;

/** 短信通道配置smsconfigifo
 * 
 * @author hujian
 */
public interface TroneConfigInfoService {

	/**
	 * 根据价格和权重逆序排
	 * @param status -1--全部   0--激活   1--关闭
	 * */
	public List<TroneConfigInfo> getTroneList( int status );

	/**
	 * 查询开启pv刷新的代码，资费均低于1元
	 * @return
	 */
	public List<TroneConfigInfo> getFreshPvFreshList();
	
	/**
	 * 根据通道号码查询通道信息
	 * */
	public TroneConfigInfo findBySpNum( String spNum );
	
	/**
	 * 根据通道号和短信内容查询符合条件的通道
	 * */
	public TroneConfigInfo findBySpNumAndMsgText( String spNum, String msgText, String serviceCode, Double price );
	
	//public List<SmsConfigInfo> getAllSmsConfigInfo();
	
	//public SmsConfigInfo findSmsConfigById( int id );
	
	//public SmsConfigInfo findSmsConfigByServiceCode( String serviceCode );
}
