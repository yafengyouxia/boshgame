package com.zsyj.fee.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CfgRole  implements Serializable  {
	private static final long serialVersionUID = 4544496536703172919L;

	private Integer id;

    private String name;

    private String code;

    private String recommend;

    private Integer feelimitmonth;

    private Integer feelimitday;

    private BigDecimal subpertimes;

    private Date addtime;

    private String isActivate;

    private String detail;

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

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Integer getFeelimitmonth() {
        return feelimitmonth;
    }

    public void setFeelimitmonth(Integer feelimitmonth) {
        this.feelimitmonth = feelimitmonth;
    }

    public Integer getFeelimitday() {
        return feelimitday;
    }

    public void setFeelimitday(Integer feelimitday) {
        this.feelimitday = feelimitday;
    }

    public BigDecimal getSubpertimes() {
        return subpertimes;
    }

    public void setSubpertimes(BigDecimal subpertimes) {
        this.subpertimes = subpertimes;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getIsActivate() {
        return isActivate;
    }

    public void setIsActivate(String isActivate) {
        this.isActivate = isActivate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
        CfgRole other = (CfgRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getRecommend() == null ? other.getRecommend() == null : this.getRecommend().equals(other.getRecommend()))
            && (this.getFeelimitmonth() == null ? other.getFeelimitmonth() == null : this.getFeelimitmonth().equals(other.getFeelimitmonth()))
            && (this.getFeelimitday() == null ? other.getFeelimitday() == null : this.getFeelimitday().equals(other.getFeelimitday()))
            && (this.getSubpertimes() == null ? other.getSubpertimes() == null : this.getSubpertimes().equals(other.getSubpertimes()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getIsActivate() == null ? other.getIsActivate() == null : this.getIsActivate().equals(other.getIsActivate()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getRecommend() == null) ? 0 : getRecommend().hashCode());
        result = prime * result + ((getFeelimitmonth() == null) ? 0 : getFeelimitmonth().hashCode());
        result = prime * result + ((getFeelimitday() == null) ? 0 : getFeelimitday().hashCode());
        result = prime * result + ((getSubpertimes() == null) ? 0 : getSubpertimes().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getIsActivate() == null) ? 0 : getIsActivate().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        return result;
    }
    
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}