package com.sz5z.accesslog.process;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sz5z.accesslog.service.AccessLogService;
import com.sz5z.accesslog.vo.AccessLog;
import com.sz5z.smscat.service.SellMobileinfoService;
import com.zsyj.fee.common.Constant;
import com.zsyj.fee.common.ImsiUtil;
import com.zsyj.fee.common.StringUtil;
import com.zsyj.fee.handler.ProcessorCommon;
import com.zsyj.fee.service.AreaService;
import com.zsyj.fee.service.UsersService;
import com.zsyj.fee.service.impl.AreaServiceImpl;
import com.zsyj.fee.service.impl.UsersServiceImpl;
import com.zsyj.fee.vo.AreaInfo;
import com.zsyj.fee.vo.SdkUser;

public class ParseAccessFile 
{
	private static final Logger logger = LoggerFactory.getLogger(ParseAccessFile.class);
	private AccessLogService accessLogService = new AccessLogService();
	private SellMobileinfoService sellMobileinfoService = new SellMobileinfoService();
	private UsersService userService = UsersServiceImpl.getInstance();
	private AreaService areaService = AreaServiceImpl.getInstance();
	
	private static String separate = "\\|\\|";
	
	/**
	 * 
	 * @param logFile
	 * @return true 处理成功  false处理失败或者未处理
	 */
	public boolean processLogFile( File logFile )
	{
		boolean result = false;
		try {
			
			logger.info( "start:" + logFile.getName() );
			
			List<AccessLog> accessLogList = new ArrayList<AccessLog>();
			RandomAccessFile  accessFile = new RandomAccessFile( logFile, "r" );
			
			String lineStr = null;
			AccessLog accessLog = null;
			while( ( lineStr = accessFile.readLine() ) != null )
			{
				accessLog = this.convertToVo( lineStr );
				if( accessLog != null )
				{
					accessLogList.add( accessLog );
					
					//每满5000条就向表中插入记录然后清空
					if( accessLogList.size() >= 500 )
					{
						logger.info( "add 500 items : " + logFile.getName() );
						
						this.accessLogService.addAccesLog(accessLogList);
						this.sellMobileinfoService.addSellMobileinfo(accessLogList);
						
						accessLogList.clear();
					}
				}
			}
			
			if( accessLogList != null && accessLogList.size() > 0 )
			{
				this.accessLogService.addAccesLog(accessLogList);
				this.sellMobileinfoService.addSellMobileinfo(accessLogList);
				accessLogList.clear();
			}
			
			result = true;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error( e.getMessage() );
		} catch (IOException e) {
			e.printStackTrace();
			logger.error( e.getMessage() );
		} catch (Exception e) {
			e.printStackTrace();
			logger.error( e.getMessage() );
		} 
		
		logger.info( "end : " + logFile.getName() );
		
		return result;
	}
	
	/**
	 * tomcat 日志配置 
	 * %h||%t||'%r'||%s||%b||%{sid}i||%{cid}i||%{mid}i||%{softversion}i||%D
	 * 211.137.181.40||[04/Jan/2012:17:44:16 +0800]||'POST /feeinfo.jsp HTTP/1.1'||200||10||6031||6001||13800535500#9460020065694171||mf20111111||14
	 * */
	public AccessLog convertToVo( String line )
	{
		AccessLog accessLog = null;
		
		if( line != null )
		{
			String[] contents = null;
			if( line.indexOf( "test_a.jsp?" ) > -1 ) {
				contents = line.split( separate );
				
				//test_a.jsp?v=s1.0t=2&p=1594&c=12047345&i=9460010942019764&s= HTTP/1.0
				line  = line.substring( line.indexOf("test_a.jsp?") + 11, line.indexOf("HTTP/") ).trim();
				Map<String, String> paramMap = StringUtil.parseRequestQueryString(line);
				
				contents[5] = "6823";
				contents[6] = paramMap.get( "p" );
				contents[7] = "_" + paramMap.get( "i" );
				contents[8] = paramMap.get( "v" );
				
			} else {
				contents = line.split( separate );
			}
			
			if( contents.length >= 8 )
			{
				accessLog = new AccessLog();
				accessLog.setRemoteIp( contents[0] );
				accessLog.setLogtime( this.convertDateFormat( contents[1] ) );
				accessLog.setRequestPage( this.convertRequestPage( contents[2] ) );
				accessLog.setResponseCode( contents[3] );
				
				accessLog.setSid( contents[5] );	
				accessLog.setCid( contents[6] );	
				
				//如果sid为空，则非用户访问记录
				if( contents[5] == null || contents[5].length() == 0 )
				{
					accessLog = null;
					return accessLog;
				}
				
				String mid = contents[7].replace( "#" , "_");
				accessLog.setMid( mid );
				accessLog.setSoftversion( contents[8] );
				accessLog.setCostTime( Integer.valueOf( contents[9] ) );
				
				if( ProcessorCommon.validMid( accessLog.getMid() ) ){
					AreaInfo areaInfo = null;
					SdkUser user = userService.findByImsi( accessLog.getMid() );
					if( user != null )
					{
						accessLog.setMobileno( user.getMobile() );
						areaInfo = areaService.findByMobile( user.getMobile() );
					}
					
					if( areaInfo == null )
					{
						String mobile = ImsiUtil.getPrefixNew( mid.substring( mid.indexOf("_") + 1 ) );
						if( mobile != null && mobile.length() >= 7 )
						{
							areaInfo = areaService.findByMobile( mobile + "8888" );
						}
					}
					
					if( areaInfo == null )
					{
						String smsCenter = mid.substring(0 , mid.indexOf("_"));
						if( smsCenter.length() >= 11 )
						{
							areaInfo = areaService.findBySmsCenter( smsCenter );
						}
					}
					
					if( areaInfo == null )
					{
						areaInfo = areaService.findByIp( accessLog.getRemoteIp() );
					}
					
					if( areaInfo != null )
					{
						accessLog.setProvince( areaInfo.getProvinceName()  );
						accessLog.setCity( areaInfo.getCityName() );	
					}
				}
			}
		}
		
		return accessLog;
	}
	
	public String convertRequestPage( String requestPage )
	{
		if( requestPage.indexOf( "'POST" ) > -1 )
		{
			requestPage = requestPage.substring( requestPage.indexOf( "'POST" ) + 5 );
		}
		
		if( requestPage.indexOf( "HTTP/1.1'" ) > -1 )
		{
			requestPage = requestPage.substring( 0, requestPage.indexOf( "HTTP/1.1'" ) );
		}
		
		if( requestPage.length() >= 80 )
		{
			requestPage = requestPage.substring( 0, 75 );
		}
		
		return requestPage.trim();
	}
	
	public String convertDateFormat( String dateStr )
	{
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MMM/yyyy:hh:mm:ss zzz", Locale.US );
		dateStr = dateStr.substring( 1, dateStr.length() - 1 );
		
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if( date != null )
		{
			return Constant.sdf_yyyyMMddHHmmss.format(date);
		}
		else
		{
			return null;
		}
	}
	
	public static void main( String args [] )
	{
		String mid = "13010112500_9460016994916967";
		System.out.println( mid.substring(0 , mid.indexOf("_")) );
		
//		ParseAccessFile parseAccessFile = new ParseAccessFile();
//		
//		
//		System.out.println( parseAccessFile.convertDateFormat( "[04/Jan/2012:17:44:16 +0800]" ) );
//		System.out.println( parseAccessFile.convertRequestPage( "'POST /feeinfo.jsp HTTP/1.1'" ) );
	}
}
