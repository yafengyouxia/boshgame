package com.sz5z.smscat.vo;

/**
 * 短信接受成功
 * */
public class Receives 
{
	private String smsindex = "123456789";
	private String mobileno = "";
	
	private long id;
	
	/** smsp#imsi#cid#sid */
	private String msgtext = "";
	private String charType = "E";	//短信内容的编码格式
	private String comlimit = "0";	//短信猫com口
	private String username = "admin";
	private String dateandtime = "0";
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSmsindex() {
		return smsindex;
	}
	public void setSmsindex(String smsindex) {
		this.smsindex = smsindex;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	/** smsp#imsi#cid#sid */
	public String getMsgtext() {
		return msgtext;
	}
	/** smsp#imsi#cid#sid */
	public void setMsgtext(String msgtext) {
		this.msgtext = msgtext;
	}
	public String getCharType() {
		return charType;
	}
	public void setCharType(String charType) {
		this.charType = charType;
	}
	public String getComlimit() {
		return comlimit;
	}
	public void setComlimit(String comlimit) {
		this.comlimit = comlimit;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDateandtime() {
		return dateandtime;
	}
	public void setDateandtime(String dateandtime) {
		this.dateandtime = dateandtime;
	}
}
