package com.zsyj.fee.entity;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CfgIvrs {
    private Integer id;

    private String trone;

    private String command;

    private String area;

    private BigDecimal price;

    private String serviceName;

    private String spid;

    private String deleteInfo;

    private String deleteNo;

    private String troneType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrone() {
        return trone;
    }

    public void setTrone(String trone) {
        this.trone = trone;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getDeleteInfo() {
        return deleteInfo;
    }

    public void setDeleteInfo(String deleteInfo) {
        this.deleteInfo = deleteInfo;
    }

    public String getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(String deleteNo) {
        this.deleteNo = deleteNo;
    }

    public String getTroneType() {
        return troneType;
    }

    public void setTroneType(String troneType) {
        this.troneType = troneType;
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
        CfgIvrs other = (CfgIvrs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTrone() == null ? other.getTrone() == null : this.getTrone().equals(other.getTrone()))
            && (this.getCommand() == null ? other.getCommand() == null : this.getCommand().equals(other.getCommand()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getSpid() == null ? other.getSpid() == null : this.getSpid().equals(other.getSpid()))
            && (this.getDeleteInfo() == null ? other.getDeleteInfo() == null : this.getDeleteInfo().equals(other.getDeleteInfo()))
            && (this.getDeleteNo() == null ? other.getDeleteNo() == null : this.getDeleteNo().equals(other.getDeleteNo()))
            && (this.getTroneType() == null ? other.getTroneType() == null : this.getTroneType().equals(other.getTroneType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTrone() == null) ? 0 : getTrone().hashCode());
        result = prime * result + ((getCommand() == null) ? 0 : getCommand().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getSpid() == null) ? 0 : getSpid().hashCode());
        result = prime * result + ((getDeleteInfo() == null) ? 0 : getDeleteInfo().hashCode());
        result = prime * result + ((getDeleteNo() == null) ? 0 : getDeleteNo().hashCode());
        result = prime * result + ((getTroneType() == null) ? 0 : getTroneType().hashCode());
        return result;
    }
    
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}