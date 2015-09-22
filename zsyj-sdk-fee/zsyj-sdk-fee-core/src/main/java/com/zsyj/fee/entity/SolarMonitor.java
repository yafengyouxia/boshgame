package com.zsyj.fee.entity;

import java.io.Serializable;
import java.util.Date;

public class SolarMonitor implements Serializable  {
	private static final long serialVersionUID = 8203801639058813353L;
	
	private Integer monnitorId;

    private Integer userId;

    private Integer agentCode;

    private String monitorCode;

    private String monitorName;

    private Integer saleUserId;

    private Integer appid;

    private Byte type;

    private Double cpaCpsPrice;

    private Double userRate;

    private Double moneyRate;

    private Byte status;

    private Date addTime;

    private Date updateTime;

    public Integer getMonnitorId() {
        return monnitorId;
    }

    public void setMonnitorId(Integer monnitorId) {
        this.monnitorId = monnitorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(Integer agentCode) {
        this.agentCode = agentCode;
    }

    public String getMonitorCode() {
        return monitorCode;
    }

    public void setMonitorCode(String monitorCode) {
        this.monitorCode = monitorCode;
    }

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public Integer getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(Integer saleUserId) {
        this.saleUserId = saleUserId;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Double getCpaCpsPrice() {
        return cpaCpsPrice;
    }

    public void setCpaCpsPrice(Double cpaCpsPrice) {
        this.cpaCpsPrice = cpaCpsPrice;
    }

    public Double getUserRate() {
        return userRate;
    }

    public void setUserRate(Double userRate) {
        this.userRate = userRate;
    }

    public Double getMoneyRate() {
        return moneyRate;
    }

    public void setMoneyRate(Double moneyRate) {
        this.moneyRate = moneyRate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        SolarMonitor other = (SolarMonitor) that;
        return (this.getMonnitorId() == null ? other.getMonnitorId() == null : this.getMonnitorId().equals(other.getMonnitorId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAgentCode() == null ? other.getAgentCode() == null : this.getAgentCode().equals(other.getAgentCode()))
            && (this.getMonitorCode() == null ? other.getMonitorCode() == null : this.getMonitorCode().equals(other.getMonitorCode()))
            && (this.getMonitorName() == null ? other.getMonitorName() == null : this.getMonitorName().equals(other.getMonitorName()))
            && (this.getSaleUserId() == null ? other.getSaleUserId() == null : this.getSaleUserId().equals(other.getSaleUserId()))
            && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCpaCpsPrice() == null ? other.getCpaCpsPrice() == null : this.getCpaCpsPrice().equals(other.getCpaCpsPrice()))
            && (this.getUserRate() == null ? other.getUserRate() == null : this.getUserRate().equals(other.getUserRate()))
            && (this.getMoneyRate() == null ? other.getMoneyRate() == null : this.getMoneyRate().equals(other.getMoneyRate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMonnitorId() == null) ? 0 : getMonnitorId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAgentCode() == null) ? 0 : getAgentCode().hashCode());
        result = prime * result + ((getMonitorCode() == null) ? 0 : getMonitorCode().hashCode());
        result = prime * result + ((getMonitorName() == null) ? 0 : getMonitorName().hashCode());
        result = prime * result + ((getSaleUserId() == null) ? 0 : getSaleUserId().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCpaCpsPrice() == null) ? 0 : getCpaCpsPrice().hashCode());
        result = prime * result + ((getUserRate() == null) ? 0 : getUserRate().hashCode());
        result = prime * result + ((getMoneyRate() == null) ? 0 : getMoneyRate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}