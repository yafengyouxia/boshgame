package com.sz5z.crontab.job;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sz5z.accesslog.process.ParseAccessFile;
import com.sz5z.accesslog.service.AccessLogService;
import com.sz5z.accesslog.service.AccessStatusinfoService;
import com.zsyj.fee.common.Constant;
import com.zsyj.fee.common.ScheduleTask;
import com.zsyj.fee.common.mail.SimpleMailSender;

public class AccessProcesslogJob extends ScheduleTask {

	private static final Logger logger = LoggerFactory.getLogger(AccessProcesslogJob.class);
	
	public static String ACCESSLOGFILE = "localhost_access_log.";
	
	private ParseAccessFile parseAccessFile = new ParseAccessFile();
	private AccessStatusinfoService accessStatusinfoService = new AccessStatusinfoService();
	private AccessLogService accessLogService = new AccessLogService();
	
	public static void main( String args [] ) throws UnsupportedEncodingException {
		
		AccessProcesslogJob accessProcess = new AccessProcesslogJob( 1000, 1000 );
		accessProcess.run();
	}

	public AccessProcesslogJob(long delay, long interval) {
		super(delay, interval);
	}
	
	public void work()
	{
		logger.info( "start check access log!" );
		
		Calendar currentDayStr = Calendar.getInstance(); //当前时间
		File accessLogDirectorFile = this.getAccessLogPath();
		
		if( accessLogDirectorFile != null )
		{
			boolean result = false;
			Date beginTime = null;
			Date endTime = null;
			
			try
			{
				File[] accessLogFiles = accessLogDirectorFile.listFiles();
				if( accessLogFiles != null && accessLogFiles.length > 0 )
				{
					Date lastStausTime = null;
					String lastStausTimeStr = accessStatusinfoService.getLastStatusTime( );
					if ( lastStausTimeStr != null ) {
						lastStausTime = Constant.sdf_yyyyMMddHHmmss.parse( lastStausTimeStr );
						
						//短信报警
						//checkServerStatus( lastStausTime );
					}
					
					for( File file : accessLogFiles )
					{
						if( file.getName().indexOf( ACCESSLOGFILE ) > -1 )
						{
							//获取当前日志文件的时间
							Date fileTime = this.getFileDate(file);

							logger.info( "last check time:[" + lastStausTimeStr + "] fileName:[" + file.getName() + "]" );
							
							//记录一小时前的文档
							if( currentDayStr.get( Calendar.DAY_OF_MONTH ) == fileTime.getDate()
									&& ( currentDayStr.get( Calendar.HOUR_OF_DAY ) - fileTime.getHours() )  <  1 )
							{
								logger.info( "don,t handle the current hour file, fileName : " + file.getName() );
								continue;
							}
							
							if( lastStausTime == null || lastStausTime.compareTo( fileTime ) < 0 )
							{
								this.deleteHistoryData(fileTime);
								
								result = parseAccessFile.processLogFile(file);
								
								if( result )
								{
									if( beginTime == null 
											|| fileTime.compareTo(beginTime) < 0 )
									{
										beginTime = fileTime;
									}
									
									if( endTime == null 
											|| fileTime.compareTo(endTime) > 0 )
									{
										endTime = fileTime; 
									}
								}
							}
							//删除不是今天的日志
							else if( currentDayStr.get( Calendar.DAY_OF_MONTH ) != fileTime.getDate() )
							{
								file.delete();
							}
						}
					}
					
					
					if( beginTime != null && endTime != null )
					{
						this.accessStatusinfoService.addStatusInfo( Constant.sdf_yyyyMMddHHmmss.format( beginTime ), Constant.sdf_yyyyMMddHHmmss.format( endTime ),
								"从" + Constant.sdf_yyyyMMddHHmmss.format( beginTime ) + "统计到：" + Constant.sdf_yyyyMMddHHmmss.format( endTime ) + "成功!" );	
					}
				}	
			}
			catch( Exception e )
			{
				//e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
	}
	
	private void checkServerStatus( Date lastStausTime )
	{
		Date currentTime = new Date();
		
		if( lastStausTime != null && 
				( currentTime.getTime() - lastStausTime.getTime() ) > 240*60*1000 )
		{
			SimpleMailSender simpleMailSender = new SimpleMailSender();
			String content = "截止到" + lastStausTime + ", 没有访问日志，请检查服务器运行是否正常！";
			
			logger.error( "服务器访问日志异常:" + content );
			for( String toAddress : Constant.smsCatMailList )
			{
				simpleMailSender.sendMail( toAddress, "服务器访问日志异常", content, 120 );				
			}
		}
	}
	
	private void deleteHistoryData( Date fileTime )
	{
		logger.info( "deleteHistoryData:" + fileTime.getHours() + ":" + fileTime.getMinutes() );
		
		Date beginTime = new Date( fileTime.getTime() );
		Date endTime = new Date( fileTime.getTime() );
		
		endTime.setHours( fileTime.getHours() + 1 );
		
		try {
			this.accessLogService.deleteAccessLog( Constant.sdf_yyyyMMddHHmmss.format( beginTime ), 
					Constant.sdf_yyyyMMddHHmmss.format( endTime ) );
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public File getAccessLogPath()
	{
		ResourceBundle rb = ResourceBundle.getBundle ("config");
		String accessLogPath = rb.getString ("accessLogPath");

		File accessLogFile = new File( accessLogPath );
		if( accessLogFile.exists() && accessLogFile.isDirectory() )
		{
			return accessLogFile;
		}
		else
		{
			logger.error( "the acceslog file path is not exsitsts : " + accessLogPath );
			return null;
		}
	}
	
	private Date getFileDate( File file )
	{
		String fileName = file.getName().substring( AccessProcesslogJob.ACCESSLOGFILE.length(), file.getName().length() - 4 );
		String dateTime = fileName.substring( 0, fileName.indexOf( "." ) );
		String hourTime = fileName.substring( fileName.indexOf( "." ) + 1, fileName.length()  );
		
		Date fileDate = null;
		try {
			fileDate = Constant.sdf_yyyyMMdd.parse( dateTime );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fileDate.setHours( Integer.valueOf( hourTime ) );
		fileDate.setMinutes( 0 );
		fileDate.setSeconds( 0 );
		
		return fileDate;
	}
}
