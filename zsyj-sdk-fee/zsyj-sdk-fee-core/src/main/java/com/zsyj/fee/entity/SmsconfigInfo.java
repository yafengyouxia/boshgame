package com.zsyj.fee.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SmsconfigInfo implements Serializable {

	private static final long serialVersionUID = 7602057726211662792L;

	private Integer sysid;

    private Integer configid;

    private String area;

    private String command;

    private String trone;

    private String confirmcommand;

    private String confirmtrone;

    private String fee;

    private String servicecode;

    private String configname;

    private String deleteinfo;

    private String deleteno;

    private Byte tronetype;

    private String belong;

    private String confirmKeyword;

    private String findRndKeyword;

    private String companyName;

    private String serviceName;

    private String firstMtKeyword;

    private Integer spCid;

    public Integer getSysid() {
        return sysid;
    }

    public void setSysid(Integer sysid) {
        this.sysid = sysid;
    }

    public Integer getConfigid() {
        return configid;
    }

    public void setConfigid(Integer configid) {
        this.configid = configid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getTrone() {
        return trone;
    }

    public void setTrone(String trone) {
        this.trone = trone;
    }

    public String getConfirmcommand() {
        return confirmcommand;
    }

    public void setConfirmcommand(String confirmcommand) {
        this.confirmcommand = confirmcommand;
    }

    public String getConfirmtrone() {
        return confirmtrone;
    }

    public void setConfirmtrone(String confirmtrone) {
        this.confirmtrone = confirmtrone;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getServicecode() {
        return servicecode;
    }

    public void setServicecode(String servicecode) {
        this.servicecode = servicecode;
    }

    public String getConfigname() {
        return configname;
    }

    public void setConfigname(String configname) {
        this.configname = configname;
    }

    public String getDeleteinfo() {
        return deleteinfo;
    }

    public void setDeleteinfo(String deleteinfo) {
        this.deleteinfo = deleteinfo;
    }

    public String getDeleteno() {
        return deleteno;
    }

    public void setDeleteno(String deleteno) {
        this.deleteno = deleteno;
    }

    public Byte getTronetype() {
        return tronetype;
    }

    public void setTronetype(Byte tronetype) {
        this.tronetype = tronetype;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getConfirmKeyword() {
        return confirmKeyword;
    }

    public void setConfirmKeyword(String confirmKeyword) {
        this.confirmKeyword = confirmKeyword;
    }

    public String getFindRndKeyword() {
        return findRndKeyword;
    }

    public void setFindRndKeyword(String findRndKeyword) {
        this.findRndKeyword = findRndKeyword;
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

    public String getFirstMtKeyword() {
        return firstMtKeyword;
    }

    public void setFirstMtKeyword(String firstMtKeyword) {
        this.firstMtKeyword = firstMtKeyword;
    }

    public Integer getSpCid() {
        return spCid;
    }

    public void setSpCid(Integer spCid) {
        this.spCid = spCid;
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
        SmsconfigInfo other = (SmsconfigInfo) that;
        return (this.getSysid() == null ? other.getSysid() == null : this.getSysid().equals(other.getSysid()))
            && (this.getConfigid() == null ? other.getConfigid() == null : this.getConfigid().equals(other.getConfigid()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getCommand() == null ? other.getCommand() == null : this.getCommand().equals(other.getCommand()))
            && (this.getTrone() == null ? other.getTrone() == null : this.getTrone().equals(other.getTrone()))
            && (this.getConfirmcommand() == null ? other.getConfirmcommand() == null : this.getConfirmcommand().equals(other.getConfirmcommand()))
            && (this.getConfirmtrone() == null ? other.getConfirmtrone() == null : this.getConfirmtrone().equals(other.getConfirmtrone()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
            && (this.getServicecode() == null ? other.getServicecode() == null : this.getServicecode().equals(other.getServicecode()))
            && (this.getConfigname() == null ? other.getConfigname() == null : this.getConfigname().equals(other.getConfigname()))
            && (this.getDeleteinfo() == null ? other.getDeleteinfo() == null : this.getDeleteinfo().equals(other.getDeleteinfo()))
            && (this.getDeleteno() == null ? other.getDeleteno() == null : this.getDeleteno().equals(other.getDeleteno()))
            && (this.getTronetype() == null ? other.getTronetype() == null : this.getTronetype().equals(other.getTronetype()))
            && (this.getBelong() == null ? other.getBelong() == null : this.getBelong().equals(other.getBelong()))
            && (this.getConfirmKeyword() == null ? other.getConfirmKeyword() == null : this.getConfirmKeyword().equals(other.getConfirmKeyword()))
            && (this.getFindRndKeyword() == null ? other.getFindRndKeyword() == null : this.getFindRndKeyword().equals(other.getFindRndKeyword()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getFirstMtKeyword() == null ? other.getFirstMtKeyword() == null : this.getFirstMtKeyword().equals(other.getFirstMtKeyword()))
            && (this.getSpCid() == null ? other.getSpCid() == null : this.getSpCid().equals(other.getSpCid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSysid() == null) ? 0 : getSysid().hashCode());
        result = prime * result + ((getConfigid() == null) ? 0 : getConfigid().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getCommand() == null) ? 0 : getCommand().hashCode());
        result = prime * result + ((getTrone() == null) ? 0 : getTrone().hashCode());
        result = prime * result + ((getConfirmcommand() == null) ? 0 : getConfirmcommand().hashCode());
        result = prime * result + ((getConfirmtrone() == null) ? 0 : getConfirmtrone().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getServicecode() == null) ? 0 : getServicecode().hashCode());
        result = prime * result + ((getConfigname() == null) ? 0 : getConfigname().hashCode());
        result = prime * result + ((getDeleteinfo() == null) ? 0 : getDeleteinfo().hashCode());
        result = prime * result + ((getDeleteno() == null) ? 0 : getDeleteno().hashCode());
        result = prime * result + ((getTronetype() == null) ? 0 : getTronetype().hashCode());
        result = prime * result + ((getBelong() == null) ? 0 : getBelong().hashCode());
        result = prime * result + ((getConfirmKeyword() == null) ? 0 : getConfirmKeyword().hashCode());
        result = prime * result + ((getFindRndKeyword() == null) ? 0 : getFindRndKeyword().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getFirstMtKeyword() == null) ? 0 : getFirstMtKeyword().hashCode());
        result = prime * result + ((getSpCid() == null) ? 0 : getSpCid().hashCode());
        return result;
    }
    
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}