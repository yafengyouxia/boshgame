package com.zsyj.fee.entity;

import java.io.Serializable;
import java.util.Date;

public class SolarCharge implements Serializable  {
	
	private static final long serialVersionUID = 8174303684893588337L;

	private String tableName;
	
    private Integer id;

    private String userSid;

    private String userCid;

    private Integer saleId;

    private String imsi;

    private Integer cpId;

    private String appId;

    private String orderId;

    private Byte troneType;

    private Double usedCash;

    private String mobile;

    private String linkId;

    private String status;

    private String serviceCode;

    private String trone;

    private String mo;

    private String area;

    private String city;

    private Integer spid;

    private Byte operator;

    private Date disconnectTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserSid() {
        return userSid;
    }

    public void setUserSid(String userSid) {
        this.userSid = userSid;
    }

    public String getUserCid() {
        return userCid;
    }

    public void setUserCid(String userCid) {
        this.userCid = userCid;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Byte getTroneType() {
        return troneType;
    }

    public void setTroneType(Byte troneType) {
        this.troneType = troneType;
    }

    public Double getUsedCash() {
        return usedCash;
    }

    public void setUsedCash(Double usedCash) {
        this.usedCash = usedCash;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getTrone() {
        return trone;
    }

    public void setTrone(String trone) {
        this.trone = trone;
    }

    public String getMo() {
        return mo;
    }

    public void setMo(String mo) {
        this.mo = mo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public Byte getOperator() {
        return operator;
    }

    public void setOperator(Byte operator) {
        this.operator = operator;
    }

    public Date getDisconnectTime() {
        return disconnectTime;
    }

    public void setDisconnectTime(Date disconnectTime) {
        this.disconnectTime = disconnectTime;
    }
    
    public String getTableName() {
		return tableName;
	}
    
	public void setTableName(String tableName) {
		this.tableName = tableName;
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
        SolarCharge other = (SolarCharge) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserSid() == null ? other.getUserSid() == null : this.getUserSid().equals(other.getUserSid()))
            && (this.getUserCid() == null ? other.getUserCid() == null : this.getUserCid().equals(other.getUserCid()))
            && (this.getSaleId() == null ? other.getSaleId() == null : this.getSaleId().equals(other.getSaleId()))
            && (this.getImsi() == null ? other.getImsi() == null : this.getImsi().equals(other.getImsi()))
            && (this.getCpId() == null ? other.getCpId() == null : this.getCpId().equals(other.getCpId()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getTroneType() == null ? other.getTroneType() == null : this.getTroneType().equals(other.getTroneType()))
            && (this.getUsedCash() == null ? other.getUsedCash() == null : this.getUsedCash().equals(other.getUsedCash()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getLinkId() == null ? other.getLinkId() == null : this.getLinkId().equals(other.getLinkId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getServiceCode() == null ? other.getServiceCode() == null : this.getServiceCode().equals(other.getServiceCode()))
            && (this.getTrone() == null ? other.getTrone() == null : this.getTrone().equals(other.getTrone()))
            && (this.getMo() == null ? other.getMo() == null : this.getMo().equals(other.getMo()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getSpid() == null ? other.getSpid() == null : this.getSpid().equals(other.getSpid()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getDisconnectTime() == null ? other.getDisconnectTime() == null : this.getDisconnectTime().equals(other.getDisconnectTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserSid() == null) ? 0 : getUserSid().hashCode());
        result = prime * result + ((getUserCid() == null) ? 0 : getUserCid().hashCode());
        result = prime * result + ((getSaleId() == null) ? 0 : getSaleId().hashCode());
        result = prime * result + ((getImsi() == null) ? 0 : getImsi().hashCode());
        result = prime * result + ((getCpId() == null) ? 0 : getCpId().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getTroneType() == null) ? 0 : getTroneType().hashCode());
        result = prime * result + ((getUsedCash() == null) ? 0 : getUsedCash().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getLinkId() == null) ? 0 : getLinkId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getServiceCode() == null) ? 0 : getServiceCode().hashCode());
        result = prime * result + ((getTrone() == null) ? 0 : getTrone().hashCode());
        result = prime * result + ((getMo() == null) ? 0 : getMo().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getSpid() == null) ? 0 : getSpid().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getDisconnectTime() == null) ? 0 : getDisconnectTime().hashCode());
        return result;
    }
}