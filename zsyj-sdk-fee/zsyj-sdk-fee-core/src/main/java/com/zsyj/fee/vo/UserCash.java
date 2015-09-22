package com.zsyj.fee.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户金额统计
 * */
public class UserCash implements Serializable {

	private static final long serialVersionUID = -1207579331741240671L;

	/** 当月总计费 */
	private double totalFeeCount = 0.0D;
	
	/** 当天用户计费金额 */
	private int sumTodayFee = 0;
	/** 当月用户计费金额 */
	private int sumMonthFee = 0;
	/** 当天下发指令金额 */
	private double sumMoidTodayFee = 0;
	/** 当月下发指令金额 */
	private double sumMoidMonthFee = 0;
	
	private Date lastPayTime = null;
	
	/** 当月用户在该产品已下行的指令  key--serviceCode value--次数 */
	private Map<String, Integer> currentMonthMoidmapLog = new HashMap<String, Integer>();
	/** 当天用户在该产品已下行的指令  key--serviceCode value--次数 */
	private Map<String, Integer> currentTodayMoidmapLog = new HashMap<String, Integer>();
	
	public void addSuccWapLog( Map<String, Double> smsWapCurrentDayLogs )
	{
		if( smsWapCurrentDayLogs != null && smsWapCurrentDayLogs.size() > 0 )
		{
			Iterator<String> iterator = smsWapCurrentDayLogs.keySet().iterator();
			while( iterator.hasNext() )
			{
				Double wapPrice = smsWapCurrentDayLogs.get( iterator.next() );
				this.sumMonthFee += wapPrice;
			}
		}
	}
	
	public double getTotalFeeCount() {
		return totalFeeCount;
	}
	public void setTotalFeeCount(double totalFeeCount) {
		this.totalFeeCount = totalFeeCount;
	}
	
	public int getSumTodayFee() {
		return sumTodayFee;
	}
	public void setSumTodayFee(int sumTodayFee) {
		this.sumTodayFee = sumTodayFee;
	}
	public int getSumMonthFee() {
		return sumMonthFee;
	}
	public void setSumMonthFee(int sumMonthFee) {
		this.sumMonthFee = sumMonthFee;
	}
	public double getSumMoidTodayFee() {
		return sumMoidTodayFee;
	}
	public void setSumMoidTodayFee(double sumMoidTodayFee) {
		this.sumMoidTodayFee = sumMoidTodayFee;
	}
	public double getSumMoidMonthFee() {
		return sumMoidMonthFee;
	}
	public void setSumMoidMonthFee(double sumMoidMonthFee) {
		this.sumMoidMonthFee = sumMoidMonthFee;
	}

	public Map<String, Integer> getCurrentMonthMoidmapLog() {
		return currentMonthMoidmapLog;
	}

	public void setCurrentMonthMoidmapLog(
			Map<String, Integer> currentMonthMoidmapLog) {
		this.currentMonthMoidmapLog = currentMonthMoidmapLog;
	}

	public Map<String, Integer> getCurrentTodayMoidmapLog() {
		return currentTodayMoidmapLog;
	}

	public void setCurrentTodayMoidmapLog(
			Map<String, Integer> currentTodayMoidmapLog) {
		this.currentTodayMoidmapLog = currentTodayMoidmapLog;
	}
	
	public Date getLastPayTime() {
		return lastPayTime;
	}

	public void setLastPayTime(Date lastPayTime) {
		this.lastPayTime = lastPayTime;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
