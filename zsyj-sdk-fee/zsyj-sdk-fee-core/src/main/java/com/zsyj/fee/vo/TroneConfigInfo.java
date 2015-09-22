package com.zsyj.fee.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.zsyj.fee.entity.CfgSdkTrone;

public class TroneConfigInfo extends CfgSdkTrone implements Serializable  {
	
	private static final long serialVersionUID = 5134682440999617500L;

	private Map<String, String> areaTable = new HashMap<String, String>();
	
	private int feeTimes = 1;
	
	private String orderId;
	
	private List<TroneCode> codeList = new ArrayList<TroneCode>();
	
	public static TroneConfigInfo getInstance( CfgSdkTrone sdkTrone )
	{
		TroneConfigInfo trone = new TroneConfigInfo();
		
		trone.setId( sdkTrone.getId() );
		trone.setName( sdkTrone.getName() );
		trone.setServiceCode( sdkTrone.getServiceCode() );
		trone.setTrone( sdkTrone.getTrone() );
		trone.setFee( sdkTrone.getFee() );
		trone.setDeleteText( sdkTrone.getDeleteText() );
		trone.setDeleteNumber( sdkTrone.getDeleteNumber() );
		trone.setCommand( sdkTrone.getCommand() );
		trone.setTroneType( sdkTrone.getTroneType() );
		trone.setSidCidOnly( sdkTrone.getSidCidOnly() );
		trone.setHelpline( sdkTrone.getHelpline() );
		trone.setConfirmKeyword( sdkTrone.getConfirmKeyword() );
		trone.setConfirmCommand( sdkTrone.getConfirmCommand() );
		trone.setConfirmTrone( sdkTrone.getConfirmTrone() );
		trone.setFindRndKeyword( sdkTrone.getFindRndKeyword() );
		trone.setCompanyName( sdkTrone.getCompanyName() );
		trone.setServiceName( sdkTrone.getServiceName() );
		trone.setDivideRatio( sdkTrone.getDivideRatio() );
		trone.setIsFreshPv( sdkTrone.getIsFreshPv() );
		trone.setWeight( sdkTrone.getWeight() );
		trone.setStatus( sdkTrone.getStatus() );
		trone.setSpId( sdkTrone.getSpId() );
		trone.setArea( sdkTrone.getArea() );
		trone.setTroneStrategyId(sdkTrone.getTroneStrategyId());
		trone.setSidCidOnly( sdkTrone.getSidCidOnly() );
		
		String[] areaArray = sdkTrone.getArea().split(",");
		for (int i = 0; i < areaArray.length; i++) {
			trone.getAreaTable().put(areaArray[i], "true");
		}
		
		return trone;
	}
	
	public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public List<TroneCode> getCodeList() {
		return codeList;
	}



	public void setCodeList(List<TroneCode> codeList) {
		this.codeList = codeList;
	}



	public void setAreaTable(Map<String, String> areaTable) {
		this.areaTable = areaTable;
	}
	
	public Map<String, String> getAreaTable() {
		return areaTable;
	}

	public int getFeeTimes() {
		return feeTimes;
	}

	public void setFeeTimes(int feeTimes) {
		this.feeTimes = feeTimes;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}