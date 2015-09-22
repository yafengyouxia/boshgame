package com.zsyj.fee.common;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
	
	public String readStream( InputStream inputStream )
	{
		byte[] bytes = new byte[1024 * 1024];  

        int nRead = 1;  
        int nTotalRead = 0;  
        String str = null;
        try 
        {
	        while (nRead > 0) 
	        {
				nRead = inputStream.read(bytes, nTotalRead, bytes.length - nTotalRead);
	            
				if (nRead > 0)
				{
					nTotalRead = nTotalRead + nRead;					
				}
	        }
	        
	        str = new String( bytes, 0, nTotalRead );
        }
        catch ( Exception e) 
        {
			e.printStackTrace();
		}
        
        return str;
	}
	
	/**
	 * 判断str中是否包含str2
	 * 例如str="abc123d345efg"  str2="abcdefg"
	 * containStr( String str, String str2 )=true
	 * @param str
	 * @param str2
	 * @return
	 */
	public static boolean containStr( String str, String str2 ){
		
		boolean result = true;
		
		if( StringUtils.isNotBlank(str) && StringUtils.isNotBlank(str2) ){
			
			int i = 0;
			int j = 0;
			int index = 0;
			char[] charList = str.toCharArray();
			char[] charList2 = str2.toCharArray();
			
			for( i = 0; i < charList2.length; i++ ){
				
				for( j = index; j < charList.length; j++ ){
					
					if( charList[j] == charList2[i] ){
						index = j+1;
						break;
					}
				}
				
				//某个字符没有匹配到则宣告失败
				if( j >= charList.length ){
					result = false;
				}
			}
		} else {
			result = false;
		}
		
		return result;
	}
	
	public static Map<String, String> parseRequestQueryString( String queryString ) {
		
		Map<String, String> map = new HashMap<String, String>( );
		if( queryString != null && queryString.length() > 0 ) {
			
			queryString = queryString.replace("&amp;", "&");
			String[] params = queryString.split("&");
			for( String param : params ) {
				
				String key = param.substring(0, param.indexOf("="));
				String value = "";
				
				if( ( param.indexOf("=") + 1 ) <= param.length() ){
					value = param.substring( param.indexOf("=") + 1, param.length() );	
				}
				
				map.put(key, value);
			}
		}
		
		return map;
	}
	
	/**
	 * 从mid的前半部分获取短信中心号
	 * */
	public static String getSmsCenterFromMid(String mid) {
		String result = "";
		String[] arrMid = mid.split("_");
		if (arrMid.length > 1) {
			result = arrMid[0];
			if (result.length() == 8)
				result = result + "500";
			if (result.length() == 9)
				result = result + "00";
			if (result.length() == 10)
				result = result + "0";
			if (result.length() > 11)
				result = result.substring(0, 11);
		}
		return result;
	}
	
	//用于打印系统部分访问记录到一个文件中,path是文件存储的地址，str是需要打印的内容，内容会以新行的形式添加在文件尾部
	public static void info( String str ){
		
		BufferedWriter bw = null;
		String path = "/home/yuqinghong-79/log.info";
		try {
			// new FileWriter(name,true)设置文件为在尾部添加模式,参数为false和没有参数都代表覆写方式
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true), "UTF-8"));
			bw.write(str+"\r\n");
		} catch (Exception e) {
			System.out.println("JspUtil.log path:" +path+"  str:"+str);
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	//用于打印系统部分访问记录到一个文件中,path是文件存储的地址，str是需要打印的内容，内容会以新行的形式添加在文件尾部
	public static void error( String str ){
		
		BufferedWriter bw = null;
		String path = "/home/yuqinghong-79/logerro.info";
		try {
			// new FileWriter(name,true)设置文件为在尾部添加模式,参数为false和没有参数都代表覆写方式
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true), "UTF-8"));
			bw.write(str+"\r\n");
		} catch (Exception e) {
			System.out.println("JspUtil.log path:" +path+"  str:"+str);
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/** 将字符串解析为Date */
	public static Date parseToDate( String time )
	{
		Date logTime = null;
		try {
			if( time != null )
			{
				logTime = Constant.sdf_yyyyMMddHHmmss.parse( time );	
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return logTime;
	}
	
	public static String getNewMidByTime()
	{
		return "13000130000_" + (System.currentTimeMillis() 
						+ (new java.util.Random().nextInt(999999)) )+"";
	}
	
	public static void main( String args [] ) {
		
		StringUtil stringUtil = new StringUtil( );
		System.out.println( stringUtil.containStr( "(严)和(友)，哪个汉字笔划较多", "(严)和(友)" ) );
	}
}
