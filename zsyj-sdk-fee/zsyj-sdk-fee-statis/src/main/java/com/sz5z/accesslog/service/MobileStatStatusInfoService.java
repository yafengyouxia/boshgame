package com.sz5z.accesslog.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.database.StatConnectionFactory;

public class MobileStatStatusInfoService {

	private static final Logger logger = LoggerFactory
			.getLogger(MobileStatStatusInfoService.class);
	private static MobileStatStatusInfoService instance = new MobileStatStatusInfoService();
	
	/**
	 * 获得最近一次统计的时间记录
	 * @return String 上次统计时间
	*/
	public String findLastStatTime() {
		
		Statement aStatement = null;
		Connection aConnection = null;
		ResultSet aResultSet = null;
		
		String sql = "select max( date_format(t_collectTime,'%Y-%m-%d %H:%i:%s' ) ) date from mobile_stat_status_info";
		
		try {

			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			aResultSet = aStatement.executeQuery(sql);
			
			if( aResultSet != null && aResultSet.next() ) {
				return aResultSet.getString( "date" );
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			StatConnectionFactory.free(aConnection, aResultSet, aStatement);
		}

		return null;
	}

	/**
	 * 保存统计的时间记录
	 * @param beginTime 统计开始时间
	 * @param endTime   统计结束时间
	 * @param collectTime 进行统计的时刻
	 * @param logInfo    统计过程相关信息
	 * @return boolean   统计信息保存是否成功
	*/
	public boolean saveStatInfo(String startTime,String endTime,String collectTime,String logInfo) {
		boolean isSave = true;
		
		PreparedStatement aStatement = null;
		Connection aConnection = null;
	  	
		try {			
			
			String sql = "insert into mobile_stat_status_info(t_beginTime,t_endTime,t_collectTime,c_log) values(?,?,?,?)";
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.prepareStatement(sql);
			
			aStatement.setString(1, startTime);	
			aStatement.setString(2, endTime);
			aStatement.setString(3, collectTime);
			aStatement.setString(4, logInfo);
			aStatement.executeUpdate();

		} catch(Exception e) {
    		isSave = false;
    		logger.error("统计时间更新失败！" + e);
	  		e.printStackTrace();
	  	} finally {
	  		StatConnectionFactory.free(aConnection, null, aStatement);
	  	}
	  	
	  	return isSave;
	}
	
	public static MobileStatStatusInfoService getInstance() {
		return instance;
	}
}
