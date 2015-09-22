package com.zsyj.fee.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SdkStrategy implements Serializable  {

	private static final long serialVersionUID = 877860863315042765L;

	private Integer id;

    private String name;

    private String code;

    private Integer feeLimitMonth;

    private Integer feeLimitDay;

    private Byte confirmDialogType;

    private Byte resultDialogType;

    private Boolean itemForFailresult;

    private Byte isFreshOne;

    private String feeDetail;

    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getFeeLimitMonth() {
        return feeLimitMonth;
    }

    public void setFeeLimitMonth(Integer feeLimitMonth) {
        this.feeLimitMonth = feeLimitMonth;
    }

    public Integer getFeeLimitDay() {
        return feeLimitDay;
    }

    public void setFeeLimitDay(Integer feeLimitDay) {
        this.feeLimitDay = feeLimitDay;
    }

    public Byte getConfirmDialogType() {
        return confirmDialogType;
    }

    public void setConfirmDialogType(Byte confirmDialogType) {
        this.confirmDialogType = confirmDialogType;
    }

    public Byte getResultDialogType() {
        return resultDialogType;
    }

    public void setResultDialogType(Byte resultDialogType) {
        this.resultDialogType = resultDialogType;
    }

    public Boolean getItemForFailresult() {
        return itemForFailresult;
    }

    public void setItemForFailresult(Boolean itemForFailresult) {
        this.itemForFailresult = itemForFailresult;
    }

    public Byte getIsFreshOne() {
        return isFreshOne;
    }

    public void setIsFreshOne(Byte isFreshOne) {
        this.isFreshOne = isFreshOne;
    }

    public String getFeeDetail() {
        return feeDetail;
    }

    public void setFeeDetail(String feeDetail) {
        this.feeDetail = feeDetail;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SdkStrategy other = (SdkStrategy) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getFeeLimitMonth() == null ? other.getFeeLimitMonth() == null : this.getFeeLimitMonth().equals(other.getFeeLimitMonth()))
            && (this.getFeeLimitDay() == null ? other.getFeeLimitDay() == null : this.getFeeLimitDay().equals(other.getFeeLimitDay()))
            && (this.getConfirmDialogType() == null ? other.getConfirmDialogType() == null : this.getConfirmDialogType().equals(other.getConfirmDialogType()))
            && (this.getResultDialogType() == null ? other.getResultDialogType() == null : this.getResultDialogType().equals(other.getResultDialogType()))
            && (this.getItemForFailresult() == null ? other.getItemForFailresult() == null : this.getItemForFailresult().equals(other.getItemForFailresult()))
            && (this.getIsFreshOne() == null ? other.getIsFreshOne() == null : this.getIsFreshOne().equals(other.getIsFreshOne()))
            && (this.getFeeDetail() == null ? other.getFeeDetail() == null : this.getFeeDetail().equals(other.getFeeDetail()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getFeeLimitMonth() == null) ? 0 : getFeeLimitMonth().hashCode());
        result = prime * result + ((getFeeLimitDay() == null) ? 0 : getFeeLimitDay().hashCode());
        result = prime * result + ((getConfirmDialogType() == null) ? 0 : getConfirmDialogType().hashCode());
        result = prime * result + ((getResultDialogType() == null) ? 0 : getResultDialogType().hashCode());
        result = prime * result + ((getItemForFailresult() == null) ? 0 : getItemForFailresult().hashCode());
        result = prime * result + ((getIsFreshOne() == null) ? 0 : getIsFreshOne().hashCode());
        result = prime * result + ((getFeeDetail() == null) ? 0 : getFeeDetail().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        return result;
    }
    
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}