package com.zsyj.fee.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FeeRequest implements Serializable {

	private static final long serialVersionUID = -4654381908843706875L;
	private String sid = "";
	private String cid = "";
	private String cpId = "";
	private String appid = "";
	private String mid = "";
	private String userAgent = "";
	private String softversion = "";
	private String requsetPage = "";
	private String cardType = "";
	private String androidVer = "";
	private String mobiModel = "";	//手机型号制式
	private String packageName = ""; //包名
	private double itemPrice = 0;
	private String itemCode = "";
	
	private String bscLac = "";
	private String bscCid = "";
	private String gpsLng = "";
	private String gpsLat = "";
	
	private String requestIp;
	private String headerInfo;
	private String imei;
	private String imsi;
	private String smsCenter;
	private String mobileNumber = "";
	private String uuid = "";
	private String orderId = "";
	
	public FeeRequest()
	{
		
	}
	
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getSoftversion() {
		return softversion;
	}

	public void setSoftversion(String softversion) {
		this.softversion = softversion;
	}

	public String price() {
		return requsetPage;
	}

	public String getRequsetPage() {
		return requsetPage;
	}

	public void setRequsetPage(String requsetPage) {
		this.requsetPage = requsetPage;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getHeaderInfo() {
		return headerInfo;
	}

	public void setHeaderInfo(String headerInfo) {
		this.headerInfo = headerInfo;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getSmsCenter() {
		return smsCenter;
	}

	public void setSmsCenter(String smsCenter) {
		this.smsCenter = smsCenter;
	}
	
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCpId() {
		return cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public String getAndroidVer() {
		return androidVer;
	}

	public void setAndroidVer(String androidVer) {
		this.androidVer = androidVer;
	}

	public String getMobiModel() {
		return mobiModel;
	}

	public void setMobiModel(String mobiModel) {
		this.mobiModel = mobiModel;
	}
	
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBscLac() {
		return bscLac;
	}

	public void setBscLac(String bscLac) {
		this.bscLac = bscLac;
	}

	public String getBscCid() {
		return bscCid;
	}

	public void setBscCid(String bscCid) {
		this.bscCid = bscCid;
	}

	public String getGpsLng() {
		return gpsLng;
	}

	public void setGpsLng(String gpsLng) {
		this.gpsLng = gpsLng;
	}

	public String getGpsLat() {
		return gpsLat;
	}

	public void setGpsLat(String gpsLat) {
		this.gpsLat = gpsLat;
	}

	public String toString()
	{
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
