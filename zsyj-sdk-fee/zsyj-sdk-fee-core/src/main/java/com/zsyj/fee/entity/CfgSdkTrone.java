package com.zsyj.fee.entity;

import java.io.Serializable;
import java.util.Date;

public class CfgSdkTrone implements Serializable {
	
	private static final long serialVersionUID = -94529986932799234L;

	private Integer id;

    private String name;

    private Integer troneStrategyId;

    private String serviceCode;

    private String area;

    private String trone;

    private String command;

    private Double fee;

    private String confirmKeyword;

    private String confirmCommand;

    private String confirmTrone;

    private String findRndKeyword;

    private String deleteText;

    private String deleteNumber;

    private Byte troneType;

    private String sidCidOnly;

    private String helpline;

    private String spId;

    private String companyName;

    private String serviceName;

    private Double divideRatio;

    private Byte isFreshPv;

    private Byte weight;

    private Byte status;

    private Date createTime;

    private Date updateTime;

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

    public Integer getTroneStrategyId() {
        return troneStrategyId;
    }

    public void setTroneStrategyId(Integer troneStrategyId) {
        this.troneStrategyId = troneStrategyId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getConfirmKeyword() {
        return confirmKeyword;
    }

    public void setConfirmKeyword(String confirmKeyword) {
        this.confirmKeyword = confirmKeyword;
    }

    public String getConfirmCommand() {
        return confirmCommand;
    }

    public void setConfirmCommand(String confirmCommand) {
        this.confirmCommand = confirmCommand;
    }

    public String getConfirmTrone() {
        return confirmTrone;
    }

    public void setConfirmTrone(String confirmTrone) {
        this.confirmTrone = confirmTrone;
    }

    public String getFindRndKeyword() {
        return findRndKeyword;
    }

    public void setFindRndKeyword(String findRndKeyword) {
        this.findRndKeyword = findRndKeyword;
    }

    public String getDeleteText() {
        return deleteText;
    }

    public void setDeleteText(String deleteText) {
        this.deleteText = deleteText;
    }

    public String getDeleteNumber() {
        return deleteNumber;
    }

    public void setDeleteNumber(String deleteNumber) {
        this.deleteNumber = deleteNumber;
    }

    public Byte getTroneType() {
        return troneType;
    }

    public void setTroneType(Byte troneType) {
        this.troneType = troneType;
    }

    public String getSidCidOnly() {
        return sidCidOnly;
    }

    public void setSidCidOnly(String sidCidOnly) {
        this.sidCidOnly = sidCidOnly;
    }

    public String getHelpline() {
        return helpline;
    }

    public void setHelpline(String helpline) {
        this.helpline = helpline;
    }

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getDivideRatio() {
        return divideRatio;
    }

    public void setDivideRatio(Double divideRatio) {
        this.divideRatio = divideRatio;
    }

    public Byte getIsFreshPv() {
        return isFreshPv;
    }

    public void setIsFreshPv(Byte isFreshPv) {
        this.isFreshPv = isFreshPv;
    }

    public Byte getWeight() {
        return weight;
    }

    public void setWeight(Byte weight) {
        this.weight = weight;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        CfgSdkTrone other = (CfgSdkTrone) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTroneStrategyId() == null ? other.getTroneStrategyId() == null : this.getTroneStrategyId().equals(other.getTroneStrategyId()))
            && (this.getServiceCode() == null ? other.getServiceCode() == null : this.getServiceCode().equals(other.getServiceCode()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getTrone() == null ? other.getTrone() == null : this.getTrone().equals(other.getTrone()))
            && (this.getCommand() == null ? other.getCommand() == null : this.getCommand().equals(other.getCommand()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
            && (this.getConfirmKeyword() == null ? other.getConfirmKeyword() == null : this.getConfirmKeyword().equals(other.getConfirmKeyword()))
            && (this.getConfirmCommand() == null ? other.getConfirmCommand() == null : this.getConfirmCommand().equals(other.getConfirmCommand()))
            && (this.getConfirmTrone() == null ? other.getConfirmTrone() == null : this.getConfirmTrone().equals(other.getConfirmTrone()))
            && (this.getFindRndKeyword() == null ? other.getFindRndKeyword() == null : this.getFindRndKeyword().equals(other.getFindRndKeyword()))
            && (this.getDeleteText() == null ? other.getDeleteText() == null : this.getDeleteText().equals(other.getDeleteText()))
            && (this.getDeleteNumber() == null ? other.getDeleteNumber() == null : this.getDeleteNumber().equals(other.getDeleteNumber()))
            && (this.getTroneType() == null ? other.getTroneType() == null : this.getTroneType().equals(other.getTroneType()))
            && (this.getSidCidOnly() == null ? other.getSidCidOnly() == null : this.getSidCidOnly().equals(other.getSidCidOnly()))
            && (this.getHelpline() == null ? other.getHelpline() == null : this.getHelpline().equals(other.getHelpline()))
            && (this.getSpId() == null ? other.getSpId() == null : this.getSpId().equals(other.getSpId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getDivideRatio() == null ? other.getDivideRatio() == null : this.getDivideRatio().equals(other.getDivideRatio()))
            && (this.getIsFreshPv() == null ? other.getIsFreshPv() == null : this.getIsFreshPv().equals(other.getIsFreshPv()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTroneStrategyId() == null) ? 0 : getTroneStrategyId().hashCode());
        result = prime * result + ((getServiceCode() == null) ? 0 : getServiceCode().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getTrone() == null) ? 0 : getTrone().hashCode());
        result = prime * result + ((getCommand() == null) ? 0 : getCommand().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getConfirmKeyword() == null) ? 0 : getConfirmKeyword().hashCode());
        result = prime * result + ((getConfirmCommand() == null) ? 0 : getConfirmCommand().hashCode());
        result = prime * result + ((getConfirmTrone() == null) ? 0 : getConfirmTrone().hashCode());
        result = prime * result + ((getFindRndKeyword() == null) ? 0 : getFindRndKeyword().hashCode());
        result = prime * result + ((getDeleteText() == null) ? 0 : getDeleteText().hashCode());
        result = prime * result + ((getDeleteNumber() == null) ? 0 : getDeleteNumber().hashCode());
        result = prime * result + ((getTroneType() == null) ? 0 : getTroneType().hashCode());
        result = prime * result + ((getSidCidOnly() == null) ? 0 : getSidCidOnly().hashCode());
        result = prime * result + ((getHelpline() == null) ? 0 : getHelpline().hashCode());
        result = prime * result + ((getSpId() == null) ? 0 : getSpId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getDivideRatio() == null) ? 0 : getDivideRatio().hashCode());
        result = prime * result + ((getIsFreshPv() == null) ? 0 : getIsFreshPv().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}