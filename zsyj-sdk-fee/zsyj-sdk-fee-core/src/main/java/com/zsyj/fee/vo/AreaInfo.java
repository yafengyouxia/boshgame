package com.zsyj.fee.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.zsyj.fee.common.Constant;
import com.zsyj.fee.entity.CfgSmscenter;
import com.zsyj.fee.entity.IpInfos;
import com.zsyj.fee.entity.Mobilearea;

public class AreaInfo implements Serializable {
	private static final long serialVersionUID = 7730122967885986244L;
	String detail = "";
	/** 所属城市 */
	String telCode = "00";
	String provinceCode = "0000";
	/** 所属运营商 */
	String troneType = "CMCC";
	String provinceName = "";
	String cityName = "";
	
	public AreaInfo() {
	}

	public AreaInfo( Mobilearea mobileArea ) {
		this.provinceCode = mobileArea.getProvincecode();
		this.telCode = mobileArea.getAreacode();
		this.provinceName = mobileArea.getProvince();
		this.cityName = mobileArea.getCity();
		this.troneType = mobileArea.getTronetype();
	}
	
	public AreaInfo( IpInfos ipInfo ) {
		this.provinceCode = ipInfo.getAreacode();
		this.telCode = ipInfo.getTelcode();
		this.provinceName = ipInfo.getProvince();
		this.cityName = ipInfo.getCity();
		this.troneType = ipInfo.getTronetype();
	}
	
	public AreaInfo( CfgSmscenter smscenter ) {
		this.provinceCode = smscenter.getAreaCode();
		this.telCode = smscenter.getTelId();
		this.provinceName = smscenter.getProvince();
		this.cityName = smscenter.getCity();
	}
	
	public AreaInfo(String detail, String telCode, String provinceCode,
			String troneType) {
		this.detail = detail;
		this.telCode = telCode;
		this.provinceCode = provinceCode;
		this.troneType = troneType;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTelCode() {
		return this.telCode;
	}

	public void setTelCode(String telCode) {
		if (telCode != null)
			this.telCode = telCode;
	}

	public String getProvinceCode() {
		return this.provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Byte getTroneType() {
		
		if( "CMCC".equals( this.troneType ) )
		{
			return  Constant.TRONETYPE_STR_CMCC;
		}
		else if( "CU".equals( this.troneType ) )
		{
			return  Constant.TRONETYPE_STR_CU;
		}
		else if( "CT".equals( this.troneType ) )
		{
			return  Constant.TRONETYPE_STR_CT;
		}
		
		return -1;
	}

	public void setTroneType(String troneType) {
		this.troneType = troneType;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}