package com.sz5z.accesslog.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sz5z.accesslog.vo.AccessLog;
import com.zsyj.database.StatConnectionFactory;
import com.zsyj.fee.common.Constant;
import com.zsyj.fee.service.CommonService;
import com.zsyj.fee.service.impl.CommonServiceImpl;

public class AccessLogService {

	private static final Logger logger = LoggerFactory
			.getLogger(AccessLogService.class);
	private static AccessLogService instance = new AccessLogService();
	private static CommonService commonService = CommonServiceImpl.getInstance();
	
	public boolean creatCurrentMonthTable( String tableName ) {
		
		String createTableSql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
							  + "`id` int(11) NOT NULL AUTO_INCREMENT,"
							  + "`mobileno` varchar(20) DEFAULT NULL,"
							  + "`sid` varchar(10) DEFAULT NULL,"
							  + "`cid` varchar(10) DEFAULT NULL,"
							  + "`mid` varchar(80) DEFAULT NULL,"
							  + "`softversion` varchar(20) DEFAULT NULL,"
							  + "`province` varchar(20) DEFAULT NULL,"
							  + "`city` varchar(30) DEFAULT NULL,"
							  + "`remoteip` varchar(30) DEFAULT NULL,"
							  + "`logtime` datetime DEFAULT NULL,"
							  + "`cost_time` int(11) DEFAULT NULL,"
							  + "`requestpage` varchar(80) DEFAULT NULL,"
							  + "`responsecode` varchar(10) DEFAULT NULL,"
							  + "PRIMARY KEY (`id`),"
							  + "KEY `index1` (`mobileno`),"
							  + "KEY `index2` (`mid`),"
							  + "KEY `index3` (`logtime`)"
							  + ") ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8";
		
		Statement aStatement = null;
        ResultSet aResultSet = null;
        Connection aConnection = null;
		
        try {
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();

			if( aStatement != null )
			{			
				aStatement.executeUpdate( createTableSql );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error( e.getMessage() );
		} finally {
			StatConnectionFactory.free(aConnection, aResultSet, aStatement);
		}
		
		
		return true;
	}
	
	public boolean addAccesLog( List<AccessLog> accessLogList ) {

		boolean result = true;

		String tableName = "access_log" + Constant.sdf_yyyyMM.format( new Date() );
		boolean tableExists = commonService.findTableByName(tableName);
		if( !tableExists )
		{
			this.creatCurrentMonthTable(tableName);
		}
		
		if (accessLogList != null && accessLogList.size() > 0) {
			PreparedStatement aStatement = null;
			Connection aConnection = null;

			String sql = "insert into " + tableName
					+ "( mobileno,sid,cid,mid,softversion,  province,city,remoteip,logtime, cost_time, requestpage, responsecode ) "
					+ " values ( ?,?,?,?,?,  ?,?,?,?,?, ?,? )";

			try {

				aConnection = StatConnectionFactory.getConnection();
				aStatement = aConnection.prepareStatement(sql);

				for( AccessLog accessLog : accessLogList )
				{
					aStatement.setString(1, accessLog.getMobileno());
					aStatement.setString(2, accessLog.getSid());
					aStatement.setString(3, accessLog.getCid());
					if( accessLog.getMid().length() < 80 ){
						aStatement.setString(4, accessLog.getMid());
					}else{
						aStatement.setString(4, accessLog.getMid().substring(0, 78));
					}
					
					aStatement.setString(5, accessLog.getSoftversion());
					aStatement.setString(6, accessLog.getProvince());
					aStatement.setString(7, accessLog.getCity());
					aStatement.setString(8, accessLog.getRemoteIp());
					aStatement.setString(9, accessLog.getLogtime());
					aStatement.setInt(10, accessLog.getCostTime());
					aStatement.setString( 11, accessLog.getRequestPage() );
					aStatement.setString( 12, accessLog.getResponseCode() );
					
					aStatement.executeUpdate();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				result = false;
			} finally {
				StatConnectionFactory.free(aConnection, null, aStatement);
			}
		}

		return result;
	}

	public boolean deleteAccessLog(String beginTime, String endTime) throws ParseException {
		boolean result = true;

		PreparedStatement aStatement = null;
		Connection aConnection = null;

		Date beginDate = Constant.sdf_yyyyMMddHHmmss.parse( beginTime );
		String tableName = "access_log" + Constant.sdf_yyyyMM.format( beginDate );
		
		String sql = "delete from " + tableName + " where logtime >= '" + beginTime + "' and logtime < '" + endTime + "'";

		try {

			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.prepareStatement(sql);
			
			aStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result = false;
		} finally {
			StatConnectionFactory.free(aConnection, null, aStatement);
		}

		return result;
	}

	public static AccessLogService getInstance() {
		return instance;
	}

	public static void main(String args[]) {
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.set(Calendar.DAY_OF_MONTH, 1);
		startCalendar.set(Calendar.HOUR_OF_DAY, 0);
		startCalendar.set(Calendar.MINUTE, 0);
		startCalendar.set(Calendar.SECOND, 0);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(startCalendar.getTime());

		endCalendar.add(Calendar.MONTH, 1);
		endCalendar.add(Calendar.SECOND, -1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		System.out.println(sdf.format(startCalendar.getTime()));
		System.out.println(sdf.format(endCalendar.getTime()));

	}
}
