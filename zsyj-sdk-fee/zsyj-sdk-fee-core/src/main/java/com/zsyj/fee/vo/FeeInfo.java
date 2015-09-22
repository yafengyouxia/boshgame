package com.zsyj.fee.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class FeeInfo implements Serializable {
	
	private static final long serialVersionUID = 5353123201231545231L;
	
	private String feeId = "";
	private String feeInfo = "";
	
	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}

	public void setFeeInfo(String feeInfo) {
		this.feeInfo = feeInfo;
	}

	public String getFeeId() {
		return this.feeId;
	}

	public String getFeeInfo() {
		return this.feeInfo;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}