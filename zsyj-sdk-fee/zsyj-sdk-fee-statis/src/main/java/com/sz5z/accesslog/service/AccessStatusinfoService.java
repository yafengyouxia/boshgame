package com.sz5z.accesslog.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.database.StatConnectionFactory;


public class AccessStatusinfoService {

	private static final Logger logger = LoggerFactory
			.getLogger(AccessStatusinfoService.class);
	private static AccessStatusinfoService instance = new AccessStatusinfoService();

	public boolean addStatusInfo( String beginTime, String endTime, String remark ) {

		boolean result = true;

		PreparedStatement aStatement = null;
		Connection aConnection = null;

		String sql = "insert into access_stat_status_info "
				+ "( t_beginTime, t_endTime, t_collectTime, c_log ) "
				+ " values ( ?, ?, ?, ? )";

		try {

			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.prepareStatement(sql);

			aStatement.setString(1, beginTime );
			aStatement.setString(2, endTime );
			aStatement.setString(3, endTime );
			aStatement.setString(4, remark );

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

	/**
	 * 获取最后一次统计的时间
	 * */
	public String getLastStatusTime( ) {

		Statement aStatement = null;
		Connection aConnection = null;
		ResultSet aResultSet = null;
		
		String sql = "select max( date_format(t_collectTime,'%Y-%m-%d %H:%i:%s' ) ) date from access_stat_status_info";
		
		try {

			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();;
			aResultSet = aStatement.executeQuery(sql);
			
			if( aResultSet != null && aResultSet.next() )
			{
				return aResultSet.getString( "date" );
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			StatConnectionFactory.free(aConnection, null, aStatement);
		}

		return null;
	}

	public static AccessStatusinfoService getInstance() {
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
