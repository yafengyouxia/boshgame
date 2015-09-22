package com.zsyj.fee.vo;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.zsyj.fee.entity.User;

/**
 * 
 * @author hujian 2011-11-21
 * */
public class SdkUser extends User implements Serializable  {

	private static final long serialVersionUID = -5582617967859244396L;
	
	private String provinceName;
	
	/** 注册页面 */
	private String registerPage;

	/** 是否是新用户 */
	private boolean isNewUser = false;
	/** 用户信息是否需要更新，默认不需要 */
	private boolean isUpdate = false;
	
	private boolean isFull = false;

	private String headInfo = "";
	/** 是否在手机黑名单中 */
	private boolean isBlack = false;
	
	/** 是否需要注册用户 */
	private boolean isRegister = false;
	
	public static SdkUser getInstance( User user )
	{
		SdkUser sdkUser = new SdkUser( );
		sdkUser.setMid( user.getMid() );
		sdkUser.setSid( user.getSid() );
		sdkUser.setCid( user.getCid() );
		sdkUser.setAppid( user.getAppid() );
		sdkUser.setCpid( user.getCpid() );
		sdkUser.setImsi( user.getImsi() );
		sdkUser.setImei( user.getImei() );
		sdkUser.setMobile( user.getMobile() );
		sdkUser.setAreaCode( user.getAreaCode() );
		sdkUser.setTelCode( user.getTelCode() );
		sdkUser.setFirstVisitTime( user.getFirstVisitTime() );
		sdkUser.setModel( user.getModel() );
		sdkUser.setUuid( user.getUuid() );
		sdkUser.setUpdateTime( user.getUpdateTime() );
		sdkUser.setType( user.getType() );
		sdkUser.setTroneType( user.getTroneType() );
		sdkUser.setSoftVersion( user.getSoftVersion() );
		sdkUser.setSmscenter( user.getSmscenter() );
		sdkUser.setAndroidVersion( user.getAndroidVersion() );
		
		return sdkUser;
	}
	
	public static SdkUser getInstance( FeeRequest feeRequest )
	{
		SdkUser user = new SdkUser( );

		//从mid中获取短信中心号
		user.setSmscenter( feeRequest.getSmsCenter() );
		user.setImsi( feeRequest.getImsi() );
		if( StringUtils.isNotBlank( feeRequest.getImei() ) )
		{
			user.setImei( feeRequest.getImei() );				
		}
		
		user.setUuid( feeRequest.getUuid() );
		user.setAppid( feeRequest.getAppid() );
		user.setMid( feeRequest.getMid() );
		user.setSid( feeRequest.getSid() );
		user.setCid( feeRequest.getCid() );
		user.setCpid( feeRequest.getCpId() );
		user.setAndroidVersion( feeRequest.getAndroidVer() );
		user.setModel( feeRequest.getMobiModel() );
		user.setSoftVersion( feeRequest.getSoftversion() );
		user.setHeadInfo( feeRequest.getHeaderInfo() );
		user.setIp( feeRequest.getRequestIp() );
		if( StringUtils.isNotBlank( feeRequest.getMobileNumber() ) )
		{
			user.setMobile( feeRequest.getMobileNumber() );
		}
		
		if( user.getModel() != null && user.getModel().length() >= 25 )
		{  
			user.setModel( user.getModel().substring(0, 25) );
		}
		
		if( user.getAndroidVersion() != null && user.getAndroidVersion().length() > 10 )
		{
			user.setAndroidVersion( user.getAndroidVersion().substring( 0, 10 ) );
		}
		
		return user;
	}
	
	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public boolean isNewUser() {
		return isNewUser;
	}

	public void setNewUser(boolean isNewUser) {
		this.isNewUser = isNewUser;
	}

	public String getHeadInfo() {
		return headInfo;
	}

	public void setHeadInfo(String headInfo) {
		this.headInfo = headInfo;
	}

	public String getRegisterPage() {
		return registerPage;
	}

	public void setRegisterPage(String registerPage) {
		this.registerPage = registerPage;
	}

	public boolean isBlack() {
		return isBlack;
	}

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}

	public boolean isUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	public boolean isRegister() {
		return isRegister;
	}

	public void setRegister(boolean isRegister) {
		this.isRegister = isRegister;
	}

	public String toString()
	{
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
