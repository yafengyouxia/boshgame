/**
 * 
 */
package com.zsyj.fee.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class DateUtil {
	
    /**
     * 将字符串"yyyy-mm-dd hh:mm:ss"转化为"yyyyMM"
     * @param timeByYYYYMMDDHHMMSS
     * */
    public static String getDateByYYYYMM( String time )
    {
    	return time.substring( 0, 7 ).replace( "-", "");
    }
    
    /**
     * 将字符串"yyyy-mm-dd hh:mm:ss"转化为"yyyy-MM-dd"
     * @param timeByYYYYMMDDHHMMSS
     * */
    public static String getDateByYYYYMMDD( String time )
    {
    	return time.substring( 0, 10 );
    }
    
	/**
	 * 获取现在时间
	 * 
	 * @return 返回字符串格式 yyyy-MM-dd HH:mm:ss
	*/
	public static String getDateStr() {
	    Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String dateString = formatter.format(currentTime);
	    return dateString;
	}
	
	/**
	 * 获取现在时间
	 * 
	 * @return String 短时间字符串格式yyyy-MM-dd
	*/
	public static String getShortDateStr() {
	    Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String dateString = formatter.format(currentTime);
	    return dateString;
	}

	/**
	    * 获取时间 小时:分;秒 HH:mm:ss
	    * 
	    * @return String
	    */
	public static String getTimeStr() {
	    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	    Date currentTime = new Date();
	    String dateString = formatter.format(currentTime);
	    return dateString;
	}


	/**
	 * 得到现在小时
	 * @return String
	*/
	public static String getHour() {
	    Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String dateString = formatter.format(currentTime);
	    String hour;
	    hour = dateString.substring(11, 13);
	    return hour;
	}

	/**
	 * 得到现在分钟
	 * 
	 * @return String 
	*/
	public static String getTime() {
	    Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String dateString = formatter.format(currentTime);
	    String min;
	    min = dateString.substring(14, 16);
	    return min;
	}

	/**
	 * 将字符串yyyy-MM-dd HH:mm:ss转化为日期
	 * */
	public static Calendar formatDateByYYYYMMDDMMHHSS( String dateStr ) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar date = Calendar.getInstance();
		try {
			date.setTime( myFormatter.parse(dateStr) );
		} catch (ParseException e) {
			date = null;
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 得到二个日期间的间隔天数
	 * @param dateStr1
	 * @param dateStr2
	 * @return String 
	 */
	public static String getDiffOfTwoDate(String dateStr1, String dateStr2) {
	    SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	    long day = 0;
	    try {
		    java.util.Date date = myFormatter.parse(dateStr1);
		    java.util.Date mydate = myFormatter.parse(dateStr2);
		    day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
	    } catch (Exception e) {
	    	return "0";
	    }
	    
	    return ("" + day);
	}


	/**
	    * 两个时间之间的天数
	    * 
	    * @param date1
	    * @param date2
	    * @return long 
	    */
	public static long getDays(String date1, String date2) {
	    if (date1 == null || date1.equals(""))
	     return 0;
	    if (date2 == null || date2.equals(""))
	     return 0;
	    // 转换为标准时间
	    SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date date = null;
	    java.util.Date mydate = null;
	    try {
	     date = myFormatter.parse(date1);
	     mydate = myFormatter.parse(date2);
	    } catch (Exception e) {
	    }
	    long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
	    return day;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dayDiffTest = DateUtil.getDiffOfTwoDate("2010-01-30 00:00:00","2010-01-05 15:28:01");
		String currentDateStr = DateUtil.getShortDateStr();
		String currentDate = DateUtil.getDateStr();
		System.out.println("当前时间：" + currentDate);
		System.out.println("当前日期：" + currentDateStr);
		System.out.println("间隔日期：" + dayDiffTest);
		
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("123", 321D);
		double mapDouble = map.get("321");
		System.out.println( mapDouble );
	}

}
