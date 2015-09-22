package com.zsyj.fee.entity;

import java.io.Serializable;
import java.util.Date;

public class SdkSynurlLog implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 255310243997103958L;

	private Integer id;

    private Integer cpid;

    private Integer smsConfigId;

    private String synUrl;

    private String postBody;

    private Byte httpMethod;

    private Byte type;

    private String linkId;

    private Byte status;

    private Date addTime;

    private Date completeTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public Integer getSmsConfigId() {
        return smsConfigId;
    }

    public void setSmsConfigId(Integer smsConfigId) {
        this.smsConfigId = smsConfigId;
    }

    public String getSynUrl() {
        return synUrl;
    }

    public void setSynUrl(String synUrl) {
        this.synUrl = synUrl;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Byte getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(Byte httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
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

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
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
        SdkSynurlLog other = (SdkSynurlLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCpid() == null ? other.getCpid() == null : this.getCpid().equals(other.getCpid()))
            && (this.getSmsConfigId() == null ? other.getSmsConfigId() == null : this.getSmsConfigId().equals(other.getSmsConfigId()))
            && (this.getSynUrl() == null ? other.getSynUrl() == null : this.getSynUrl().equals(other.getSynUrl()))
            && (this.getPostBody() == null ? other.getPostBody() == null : this.getPostBody().equals(other.getPostBody()))
            && (this.getHttpMethod() == null ? other.getHttpMethod() == null : this.getHttpMethod().equals(other.getHttpMethod()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getLinkId() == null ? other.getLinkId() == null : this.getLinkId().equals(other.getLinkId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getCompleteTime() == null ? other.getCompleteTime() == null : this.getCompleteTime().equals(other.getCompleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCpid() == null) ? 0 : getCpid().hashCode());
        result = prime * result + ((getSmsConfigId() == null) ? 0 : getSmsConfigId().hashCode());
        result = prime * result + ((getSynUrl() == null) ? 0 : getSynUrl().hashCode());
        result = prime * result + ((getPostBody() == null) ? 0 : getPostBody().hashCode());
        result = prime * result + ((getHttpMethod() == null) ? 0 : getHttpMethod().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getLinkId() == null) ? 0 : getLinkId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getCompleteTime() == null) ? 0 : getCompleteTime().hashCode());
        return result;
    }
}