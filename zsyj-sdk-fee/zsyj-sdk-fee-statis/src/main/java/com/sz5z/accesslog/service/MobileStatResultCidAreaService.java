package com.sz5z.accesslog.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.database.StatConnectionFactory;
import com.zsyj.fee.common.DateUtil;

public class MobileStatResultCidAreaService {

	private static final Logger logger = LoggerFactory
			.getLogger(MobileStatResultCidAreaService.class);
	private static MobileStatResultCidAreaService instance = new MobileStatResultCidAreaService();
	
	/**
	 * 删除beginTime对应日期天数
	 * */
	public boolean deleteByDayTime( String beginTime ) {
		
		boolean result = true;
		Statement aStatement = null;
		Connection aConnection = null;
		
		String sql = "delete from mobile_stat_result_cid_area "
			+ " where date_format(t_date,'%Y-%m-%d')='" + DateUtil.getDateByYYYYMMDD(beginTime) + "'";

		try {
			
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			aStatement.executeUpdate(sql);
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			StatConnectionFactory.free(aConnection, null, aStatement);
		}
		return result;
	}
	
	public boolean insertFromMobileStatMonth( String beginTime ) {
		
		boolean result = true;
		Statement aStatement = null;
		Connection aConnection = null;
		
		String mobileStatMonthName = "mobile_stat_" + DateUtil.getDateByYYYYMM(beginTime);
		
		String sql = " insert into mobile_stat_result_cid_area (c_CID,c_SID,t_date,c_province,n_total) "
				+ " select c_CID,c_SID,date_format(t_date,'%Y-%m-%d'),c_province,count(*) from  "
				+ mobileStatMonthName
				+ " where date_format(t_date,'%Y-%m-%d') = '" + DateUtil.getDateByYYYYMMDD( beginTime )
				+ "' group by c_SID,c_CID,c_province ";
		
		try {
			
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			aStatement.executeUpdate(sql);
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			StatConnectionFactory.free(aConnection, null, aStatement);
		}
		return result;
	}
	
	public boolean insertFromMobileStatDay( String beginTime ) {
		
		boolean result = true;
		Statement aStatement = null;
		Connection aConnection = null;
		
		String sql = " insert into mobile_stat_result_cid_area (c_CID,c_SID,t_date,c_province,n_total) "
				+ " select c_CID,c_SID,date_format(t_date,'%Y-%m-%d'),c_province,count(*) "
				+ " from mobile_stat_day where date_format(t_date,'%Y-%m-%d')='" +  DateUtil.getDateByYYYYMMDD(beginTime) + "' "
				+ " group by c_SID,c_CID,c_province ";
		
		try {
			
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			aStatement.executeUpdate(sql);
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			StatConnectionFactory.free(aConnection, null, aStatement);
		}
		return result;
	}

	public static MobileStatResultCidAreaService getInstance() {
		return instance;
	}
}
