package com.zsyj.fee.entity;

import java.io.Serializable;
import java.util.Date;

public class LimitServicecode implements Serializable  {

	private static final long serialVersionUID = -8032097968339334807L;

	private Integer id;

    private Integer codeId;

    private String serviceCode;

    private Date logtime;

    private String provinceCode;

    private String telCode;

    private Integer limitUserFeeMonth;

    private Integer limitUserFeeDay;

    private Integer limitTotalAmountDay;

    private Integer limitTotalAmountMonth;

    private String closeHour;

    private Integer subType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getTelCode() {
        return telCode;
    }

    public void setTelCode(String telCode) {
        this.telCode = telCode;
    }

    public Integer getLimitUserFeeMonth() {
        return limitUserFeeMonth;
    }

    public void setLimitUserFeeMonth(Integer limitUserFeeMonth) {
        this.limitUserFeeMonth = limitUserFeeMonth;
    }

    public Integer getLimitUserFeeDay() {
        return limitUserFeeDay;
    }

    public void setLimitUserFeeDay(Integer limitUserFeeDay) {
        this.limitUserFeeDay = limitUserFeeDay;
    }

    public Integer getLimitTotalAmountDay() {
        return limitTotalAmountDay;
    }

    public void setLimitTotalAmountDay(Integer limitTotalAmountDay) {
        this.limitTotalAmountDay = limitTotalAmountDay;
    }

    public Integer getLimitTotalAmountMonth() {
        return limitTotalAmountMonth;
    }

    public void setLimitTotalAmountMonth(Integer limitTotalAmountMonth) {
        this.limitTotalAmountMonth = limitTotalAmountMonth;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
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
        LimitServicecode other = (LimitServicecode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCodeId() == null ? other.getCodeId() == null : this.getCodeId().equals(other.getCodeId()))
            && (this.getServiceCode() == null ? other.getServiceCode() == null : this.getServiceCode().equals(other.getServiceCode()))
            && (this.getLogtime() == null ? other.getLogtime() == null : this.getLogtime().equals(other.getLogtime()))
            && (this.getProvinceCode() == null ? other.getProvinceCode() == null : this.getProvinceCode().equals(other.getProvinceCode()))
            && (this.getTelCode() == null ? other.getTelCode() == null : this.getTelCode().equals(other.getTelCode()))
            && (this.getLimitUserFeeMonth() == null ? other.getLimitUserFeeMonth() == null : this.getLimitUserFeeMonth().equals(other.getLimitUserFeeMonth()))
            && (this.getLimitUserFeeDay() == null ? other.getLimitUserFeeDay() == null : this.getLimitUserFeeDay().equals(other.getLimitUserFeeDay()))
            && (this.getLimitTotalAmountDay() == null ? other.getLimitTotalAmountDay() == null : this.getLimitTotalAmountDay().equals(other.getLimitTotalAmountDay()))
            && (this.getLimitTotalAmountMonth() == null ? other.getLimitTotalAmountMonth() == null : this.getLimitTotalAmountMonth().equals(other.getLimitTotalAmountMonth()))
            && (this.getCloseHour() == null ? other.getCloseHour() == null : this.getCloseHour().equals(other.getCloseHour()))
            && (this.getSubType() == null ? other.getSubType() == null : this.getSubType().equals(other.getSubType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCodeId() == null) ? 0 : getCodeId().hashCode());
        result = prime * result + ((getServiceCode() == null) ? 0 : getServiceCode().hashCode());
        result = prime * result + ((getLogtime() == null) ? 0 : getLogtime().hashCode());
        result = prime * result + ((getProvinceCode() == null) ? 0 : getProvinceCode().hashCode());
        result = prime * result + ((getTelCode() == null) ? 0 : getTelCode().hashCode());
        result = prime * result + ((getLimitUserFeeMonth() == null) ? 0 : getLimitUserFeeMonth().hashCode());
        result = prime * result + ((getLimitUserFeeDay() == null) ? 0 : getLimitUserFeeDay().hashCode());
        result = prime * result + ((getLimitTotalAmountDay() == null) ? 0 : getLimitTotalAmountDay().hashCode());
        result = prime * result + ((getLimitTotalAmountMonth() == null) ? 0 : getLimitTotalAmountMonth().hashCode());
        result = prime * result + ((getCloseHour() == null) ? 0 : getCloseHour().hashCode());
        result = prime * result + ((getSubType() == null) ? 0 : getSubType().hashCode());
        return result;
    }
}