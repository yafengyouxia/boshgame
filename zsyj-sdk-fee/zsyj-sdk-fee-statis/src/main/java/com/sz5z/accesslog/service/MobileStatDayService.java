package com.sz5z.accesslog.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.database.StatConnectionFactory;
import com.zsyj.fee.common.DateUtil;

public class MobileStatDayService {

	private static final Logger logger = LoggerFactory
			.getLogger(MobileStatDayService.class);
	private static MobileStatDayService instance = new MobileStatDayService();
	
	/**
	 * 清空endTime以前的数据
	 * */
	public boolean delete( String endTime ) {
		
		boolean result = true;
		Statement aStatement = null;
		Connection aConnection = null;
		
		String sql = "delete from mobile_stat_day "
			+ " where date_format(t_date,'%Y-%m-%d')<='" + DateUtil.getDateByYYYYMMDD(endTime) + "' ";

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
	
	public boolean delete( String beginTime, String endTime ) {
		
		boolean result = true;
		Statement aStatement = null;
		Connection aConnection = null;
		
		String sql = "delete from mobile_stat_day where t_date>='" + beginTime 
												+ "' and  t_date< '" + endTime + "'";

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
	
	public boolean insertFromSellMobileInfo( String beginTime, String endTime ) {
		
		boolean result = true;
		Statement aStatement = null;
		Connection aConnection = null;
		
		String S1 = "c_MID,c_SID,c_CID,c_softVersion,c_screen,c_load_version,c_lac,c_imei,c_bt,c_mobile,t_date,c_province,c_areaCode,c_troneType,c_cardType";
		String S2 = "distinct(c_MID),c_SID,c_CID,c_softVersion,c_screen,c_load_version,c_lac,c_imei,c_bt,c_mobile,logtime,c_province,c_areaCode,c_troneType,c_cardType";
		
		String sql = "insert into mobile_stat_day ( "+ S1 +" )" 
				+ " select " + S2 + " from  sell_mobile_info "
				+ " where logtime>='" + beginTime + "' and  logtime< '" + endTime + "'"
				+ " and comlimit = 0 and status = 0 and c_MID not in ( select c_MID from mobile_stat_day )";

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

	public static MobileStatDayService getInstance() {
		return instance;
	}
}
