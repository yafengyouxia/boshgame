package com.zsyj.fee.common;

import java.text.SimpleDateFormat;

public class Constant {
	
	public static SimpleDateFormat sdf_yyyyMM = new SimpleDateFormat("yyyyMM");
	public static SimpleDateFormat sdf_yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdf_yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sdf_HHmmss = new SimpleDateFormat("HH:mm:ss");
	
	public static String FEETYPE_SMS = "sms";
	
	public static String FEETYPE_WAP = "wap";
	
	public static String FEETYPE_IVR = "ivr";
	
	public static final Byte TRONETYPE_STR_CMCC = 0;	//CMCC
	
	public static final Byte TRONETYPE_STR_CU = 1;
	
	public static final Byte TRONETYPE_STR_CT = 2;
	
	/** 日志分隔符号 */
	public static String LOG_SEPARATE = "@^@";
	
	/** 全网省份编码 */
	public static String AREACODE_ALLPROVINCE = "0000";
	
	/** mid格式 */
	public static String midRegex = "^[0-9]*_[0-9]*$";
	
	/** mid imsi合法格式 */
	public static String midImsiRegex = "^.*_[0-9]*$";
	
	public static int TRONETYPE_CMCC = 1;
	public static int TRONETYPE_CU = 2;
	public static int TRONETYPE_CT = 3;
	
	public static String TRONETYPE_CMCC_STARTWITH = ",134,135,136,137,138,139,150," +
			"151,152,157,158,159,182,183,187,188,147,";
	
	public static String TRONETYPE_CU_STARTWITH = ",130,131,132,155,156,185,186,145,";
	
	public static String TRONETYPE_CT_STARTWITH = ",133,153,180,189,1349,";
	
	//15920096809@126.com  15920096809@139.com
	public static String[] smsCatMailList = { "15914072160@139.com",
		"maomaolove168@sina.com", "18316445274@139.com" };
	
	//18316445274 蒋波波    4158950@qq.com 蒋波波 （小吴）	15920096809史轩伊	18320750373唐金波    15914072160 李雪银
	public static String[] troneAlarmMailList = { "18316445274@139.com", "15920096809@139.com", "maomaolove168@sina.com",
		"15914072160@139.com" };
	
	public static String[] systemAlarmMailList = { "15899756538@139.com" };
	
	
	public static final Integer MOID_STATE_SUC = 1;
	
	public static final String SDK_MEISI = "meisi";
	public static final String SDK_LISHIZI = "lishizi";
	public static final String SDK_FengWang = "fengwang";
	public static final String SDK_YY = "yy";
}
