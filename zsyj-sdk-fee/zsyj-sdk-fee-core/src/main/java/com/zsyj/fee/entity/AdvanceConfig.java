package com.zsyj.fee.entity;

import java.util.Date;

public class AdvanceConfig {
    private Integer id;

    private String spid;

    private String cid;

    private String provinceCode;

    private Byte percent;

    private Date updatetime;

    private Byte useMyselft;

    private String closeHour;

    private Byte status;

    private Integer maxcount;

    private String remark;

    private Integer startCount;

    private Byte startPercent;

    private Integer endCount;

    private Byte endPercent;

    private Integer accountType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Byte getPercent() {
        return percent;
    }

    public void setPercent(Byte percent) {
        this.percent = percent;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Byte getUseMyselft() {
        return useMyselft;
    }

    public void setUseMyselft(Byte useMyselft) {
        this.useMyselft = useMyselft;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getMaxcount() {
        return maxcount;
    }

    public void setMaxcount(Integer maxcount) {
        this.maxcount = maxcount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStartCount() {
        return startCount;
    }

    public void setStartCount(Integer startCount) {
        this.startCount = startCount;
    }

    public Byte getStartPercent() {
        return startPercent;
    }

    public void setStartPercent(Byte startPercent) {
        this.startPercent = startPercent;
    }

    public Integer getEndCount() {
        return endCount;
    }

    public void setEndCount(Integer endCount) {
        this.endCount = endCount;
    }

    public Byte getEndPercent() {
        return endPercent;
    }

    public void setEndPercent(Byte endPercent) {
        this.endPercent = endPercent;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
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
        AdvanceConfig other = (AdvanceConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpid() == null ? other.getSpid() == null : this.getSpid().equals(other.getSpid()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getProvinceCode() == null ? other.getProvinceCode() == null : this.getProvinceCode().equals(other.getProvinceCode()))
            && (this.getPercent() == null ? other.getPercent() == null : this.getPercent().equals(other.getPercent()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getUseMyselft() == null ? other.getUseMyselft() == null : this.getUseMyselft().equals(other.getUseMyselft()))
            && (this.getCloseHour() == null ? other.getCloseHour() == null : this.getCloseHour().equals(other.getCloseHour()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMaxcount() == null ? other.getMaxcount() == null : this.getMaxcount().equals(other.getMaxcount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStartCount() == null ? other.getStartCount() == null : this.getStartCount().equals(other.getStartCount()))
            && (this.getStartPercent() == null ? other.getStartPercent() == null : this.getStartPercent().equals(other.getStartPercent()))
            && (this.getEndCount() == null ? other.getEndCount() == null : this.getEndCount().equals(other.getEndCount()))
            && (this.getEndPercent() == null ? other.getEndPercent() == null : this.getEndPercent().equals(other.getEndPercent()))
            && (this.getAccountType() == null ? other.getAccountType() == null : this.getAccountType().equals(other.getAccountType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpid() == null) ? 0 : getSpid().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getProvinceCode() == null) ? 0 : getProvinceCode().hashCode());
        result = prime * result + ((getPercent() == null) ? 0 : getPercent().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getUseMyselft() == null) ? 0 : getUseMyselft().hashCode());
        result = prime * result + ((getCloseHour() == null) ? 0 : getCloseHour().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMaxcount() == null) ? 0 : getMaxcount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStartCount() == null) ? 0 : getStartCount().hashCode());
        result = prime * result + ((getStartPercent() == null) ? 0 : getStartPercent().hashCode());
        result = prime * result + ((getEndCount() == null) ? 0 : getEndCount().hashCode());
        result = prime * result + ((getEndPercent() == null) ? 0 : getEndPercent().hashCode());
        result = prime * result + ((getAccountType() == null) ? 0 : getAccountType().hashCode());
        return result;
    }
}