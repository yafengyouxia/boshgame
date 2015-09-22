package com.zsyj.fee.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.zsyj.fee.entity.SolarCharge;

public class SdkSolarCharge extends SolarCharge implements Serializable 
{
	private static final long serialVersionUID = -4381147543476559095L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}