package com.zsyj.fee.entity;

import java.io.Serializable;
import java.util.Date;

public class CfgSpCompany implements Serializable {
	
	private static final long serialVersionUID = 4079062304592106615L;

	private Integer spSid;

    private String title;

    private Date logtime;

    private String fullname;

    private Integer limitDay = 0;

    private String address;

    private String tel;

    private String technology;

    private String businessman;

    private String techContact;

    private String masterId;

    public Integer getSpSid() {
        return spSid;
    }

    public void setSpSid(Integer spSid) {
        this.spSid = spSid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getLimitDay() {
        return limitDay;
    }

    public void setLimitDay(Integer limitDay) {
        this.limitDay = limitDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getBusinessman() {
        return businessman;
    }

    public void setBusinessman(String businessman) {
        this.businessman = businessman;
    }

    public String getTechContact() {
        return techContact;
    }

    public void setTechContact(String techContact) {
        this.techContact = techContact;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
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
        CfgSpCompany other = (CfgSpCompany) that;
        return (this.getSpSid() == null ? other.getSpSid() == null : this.getSpSid().equals(other.getSpSid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getLogtime() == null ? other.getLogtime() == null : this.getLogtime().equals(other.getLogtime()))
            && (this.getFullname() == null ? other.getFullname() == null : this.getFullname().equals(other.getFullname()))
            && (this.getLimitDay() == null ? other.getLimitDay() == null : this.getLimitDay().equals(other.getLimitDay()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getTechnology() == null ? other.getTechnology() == null : this.getTechnology().equals(other.getTechnology()))
            && (this.getBusinessman() == null ? other.getBusinessman() == null : this.getBusinessman().equals(other.getBusinessman()))
            && (this.getTechContact() == null ? other.getTechContact() == null : this.getTechContact().equals(other.getTechContact()))
            && (this.getMasterId() == null ? other.getMasterId() == null : this.getMasterId().equals(other.getMasterId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpSid() == null) ? 0 : getSpSid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getLogtime() == null) ? 0 : getLogtime().hashCode());
        result = prime * result + ((getFullname() == null) ? 0 : getFullname().hashCode());
        result = prime * result + ((getLimitDay() == null) ? 0 : getLimitDay().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getTechnology() == null) ? 0 : getTechnology().hashCode());
        result = prime * result + ((getBusinessman() == null) ? 0 : getBusinessman().hashCode());
        result = prime * result + ((getTechContact() == null) ? 0 : getTechContact().hashCode());
        result = prime * result + ((getMasterId() == null) ? 0 : getMasterId().hashCode());
        return result;
    }
}