package com.zsyj.fee.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SolarUser  implements Serializable  {
	private static final long serialVersionUID = -2363112701558282293L;

	private Integer userId;

    private String userName;

    private String password;

    private String roleCode;

    private String infoDesc;

    private String status;

    private Date createDate;

    private String ip;

    private String synchAddress;

    private String smsType;

    private String feecaseid;

    private String feedmmenuid;

    private Integer isLogin;

    private Integer isDivide;

    private Integer nAreaId;

    private Integer isMobileSale;

    private String isBizsysEnabled;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getInfoDesc() {
        return infoDesc;
    }

    public void setInfoDesc(String infoDesc) {
        this.infoDesc = infoDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSynchAddress() {
        return synchAddress;
    }

    public void setSynchAddress(String synchAddress) {
        this.synchAddress = synchAddress;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getFeecaseid() {
        return feecaseid;
    }

    public void setFeecaseid(String feecaseid) {
        this.feecaseid = feecaseid;
    }

    public String getFeedmmenuid() {
        return feedmmenuid;
    }

    public void setFeedmmenuid(String feedmmenuid) {
        this.feedmmenuid = feedmmenuid;
    }

    public Integer getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

    public Integer getIsDivide() {
        return isDivide;
    }

    public void setIsDivide(Integer isDivide) {
        this.isDivide = isDivide;
    }

    public Integer getnAreaId() {
        return nAreaId;
    }

    public void setnAreaId(Integer nAreaId) {
        this.nAreaId = nAreaId;
    }

    public Integer getIsMobileSale() {
        return isMobileSale;
    }

    public void setIsMobileSale(Integer isMobileSale) {
        this.isMobileSale = isMobileSale;
    }

    public String getIsBizsysEnabled() {
        return isBizsysEnabled;
    }

    public void setIsBizsysEnabled(String isBizsysEnabled) {
        this.isBizsysEnabled = isBizsysEnabled;
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
        SolarUser other = (SolarUser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRoleCode() == null ? other.getRoleCode() == null : this.getRoleCode().equals(other.getRoleCode()))
            && (this.getInfoDesc() == null ? other.getInfoDesc() == null : this.getInfoDesc().equals(other.getInfoDesc()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getSynchAddress() == null ? other.getSynchAddress() == null : this.getSynchAddress().equals(other.getSynchAddress()))
            && (this.getSmsType() == null ? other.getSmsType() == null : this.getSmsType().equals(other.getSmsType()))
            && (this.getFeecaseid() == null ? other.getFeecaseid() == null : this.getFeecaseid().equals(other.getFeecaseid()))
            && (this.getFeedmmenuid() == null ? other.getFeedmmenuid() == null : this.getFeedmmenuid().equals(other.getFeedmmenuid()))
            && (this.getIsLogin() == null ? other.getIsLogin() == null : this.getIsLogin().equals(other.getIsLogin()))
            && (this.getIsDivide() == null ? other.getIsDivide() == null : this.getIsDivide().equals(other.getIsDivide()))
            && (this.getnAreaId() == null ? other.getnAreaId() == null : this.getnAreaId().equals(other.getnAreaId()))
            && (this.getIsMobileSale() == null ? other.getIsMobileSale() == null : this.getIsMobileSale().equals(other.getIsMobileSale()))
            && (this.getIsBizsysEnabled() == null ? other.getIsBizsysEnabled() == null : this.getIsBizsysEnabled().equals(other.getIsBizsysEnabled()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRoleCode() == null) ? 0 : getRoleCode().hashCode());
        result = prime * result + ((getInfoDesc() == null) ? 0 : getInfoDesc().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getSynchAddress() == null) ? 0 : getSynchAddress().hashCode());
        result = prime * result + ((getSmsType() == null) ? 0 : getSmsType().hashCode());
        result = prime * result + ((getFeecaseid() == null) ? 0 : getFeecaseid().hashCode());
        result = prime * result + ((getFeedmmenuid() == null) ? 0 : getFeedmmenuid().hashCode());
        result = prime * result + ((getIsLogin() == null) ? 0 : getIsLogin().hashCode());
        result = prime * result + ((getIsDivide() == null) ? 0 : getIsDivide().hashCode());
        result = prime * result + ((getnAreaId() == null) ? 0 : getnAreaId().hashCode());
        result = prime * result + ((getIsMobileSale() == null) ? 0 : getIsMobileSale().hashCode());
        result = prime * result + ((getIsBizsysEnabled() == null) ? 0 : getIsBizsysEnabled().hashCode());
        return result;
    }
    
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}