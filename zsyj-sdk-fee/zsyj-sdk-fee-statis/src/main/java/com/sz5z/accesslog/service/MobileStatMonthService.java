package com.sz5z.accesslog.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.database.StatConnectionFactory;
import com.zsyj.fee.common.DateUtil;
import com.zsyj.fee.service.impl.CommonServiceImpl;

public class MobileStatMonthService {

	private static final Logger logger = LoggerFactory
			.getLogger(MobileStatMonthService.class);
	private static MobileStatMonthService instance = new MobileStatMonthService();
	public boolean creatCurrentMonthTable( String beginTime ) {
		
		String tableName = "mobile_stat_" + DateUtil.getDateByYYYYMM(beginTime);
		
		if( CommonServiceImpl.getInstance().findTableByName( tableName ) ) {
			return true;
		}
		
		String createTableSql = "CREATE TABLE if not exists " + tableName
            + "( `n_ID` int(11) unsigned NOT NULL auto_increment,"
            + "`c_SID` varchar(10) NOT NULL,"
            + "`c_CID` varchar(10) NOT NULL,"
            + "`c_MID` varchar(50) NOT NULL,"
            + "`c_softVersion` varchar(30) default '',"
            + "`c_screen` varchar(30) default '',"
            + "`c_load_version` varchar(30) default '',"
            + "`c_lac` varchar(30) default '',"
			+ "`c_imei` varchar(30) DEFAULT '',"
            + "`c_bt` varchar(30) DEFAULT '',"
            + "`c_mobile` varchar(12) NOT NULL default '',"
            + "`t_date` datetime NOT NULL,"
            + "`c_province` varchar(50) default NULL,"
            + "`c_areaCode` varchar(5) default NULL,"
            + "`c_troneType` varchar(5) default NULL,"
            + "`c_cardType` varchar(20) default NULL,"
            + " PRIMARY KEY  (`n_ID`),"
            + " UNIQUE KEY `index` (`c_MID`)"
            + ") ENGINE=MyISAM DEFAULT CHARSET=utf8;";
		
		Statement aStatement = null;
        ResultSet aResultSet = null;
        Connection aConnection = null;
		
        try {
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();

			aStatement.executeUpdate( createTableSql );
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error( e.getMessage() );
		} finally {
			StatConnectionFactory.free(aConnection, aResultSet, aStatement);
		}
		
		return true;
	}
	
	public boolean insertFromMobileStatDay( String beginTime ){
		
		String S1 = "c_MID, c_SID,c_CID,c_softVersion,c_screen,c_load_version,c_lac,c_imei,c_bt,c_mobile,t_date,c_province,c_areaCode,c_troneType,c_cardType";
		String S2 = "distinct(c_MID), c_SID,c_CID,c_softVersion,c_screen,c_load_version,c_lac,c_imei,c_bt,c_mobile,t_date,c_province,c_areaCode,c_troneType,c_cardType";
		
		boolean result = true;
		Statement aStatement = null;
		Connection aConnection = null;
		
		String tableName = "mobile_stat_" + DateUtil.getDateByYYYYMM(beginTime);
		String sql = " insert into " + tableName + " (" + S1 + ") "
				+ " select " + S2 + " from mobile_stat_day "
				+ " where date_format(t_date,'%Y-%m-%d')='" + DateUtil.getDateByYYYYMMDD(beginTime)
				+ "' order by t_date";
		
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
	
	/**
	 * 删除beginTime对应日期天数
	 * */
	public boolean deleteByDayTime( String beginTime ) {
		
		boolean result = true;
		Statement aStatement = null;
		Connection aConnection = null;
		
		String tableName = "mobile_stat_" + DateUtil.getDateByYYYYMM(beginTime);
		String sql = "delete from " + tableName 
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
	
	/**
	 * 统计beginTime当天的数据到mobile_stat_xxxxxx中
	 * */
	public boolean insertFromSellMobileInfo( String beginTime ) {
		
		boolean result = true;
		Statement aStatement = null;
		Connection aConnection = null;
		
		String tableName = "mobile_stat_" + DateUtil.getDateByYYYYMM(beginTime);
		String S1 = "c_MID,c_SID,c_CID,c_softVersion,c_screen,c_load_version,c_lac,c_imei,c_bt,c_mobile,t_date,c_province,c_areaCode,c_troneType,c_cardType";
		String S2 = "distinct(c_MID),c_SID,c_CID,c_softVersion,c_screen,c_load_version,c_lac,c_imei,c_bt,c_mobile,logtime,c_province,c_areaCode,c_troneType,c_cardType";
		
		String sql = "insert into " + tableName + " ( "+ S1 +" )" 
				+ " select " + S2 + " from  sell_mobile_info where date_format(t_date,'%Y-%m-%d')='" + DateUtil.getDateByYYYYMMDD( beginTime ) + "' "
				+ " and comlimit = 0 and status = 0 and c_mid not in ( select c_mid from " + tableName + " ) order by t_date ";

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
		
		String S1 = "c_SID, c_CID, distinct(c_MID), c_softVersion,c_screen,c_load_version,c_lac,c_imei,c_bt,c_mobile,t_date,c_province,c_areaCode,c_troneType,c_cardType";
		
		String tableName = "mobile_stat_" + DateUtil.getDateByYYYYMM(beginTime);
		
		String sql = "insert into " + tableName + " ( "+ S1 +" )" 
				+ " select " + S1 + " from  sell_mobile_info where logtime>='" + beginTime + "' and  logtime< '" + endTime + "'"
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

	public static MobileStatMonthService getInstance() {
		return instance;
	}
}
