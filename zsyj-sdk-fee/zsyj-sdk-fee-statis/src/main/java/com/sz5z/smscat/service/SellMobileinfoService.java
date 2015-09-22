package com.sz5z.smscat.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sz5z.accesslog.vo.AccessLog;
import com.sz5z.smscat.vo.Receives;
import com.zsyj.database.StatConnectionFactory;
import com.zsyj.fee.entity.User;

public class SellMobileinfoService {

	private static final Logger logger = LoggerFactory
			.getLogger(SellMobileinfoService.class);
	private static SellMobileinfoService instance = new SellMobileinfoService();

	/**
	 * 将记录插入到当月记录中去
	 * @param comlimit
	 * @param mobile
	 * @param status 0为正常显示  1为扣量
	 * */
	public boolean updateSellMobileinfo( int comlimit, String mobile ) {
		
		boolean flag = true;
		
		PreparedStatement aStatement = null;
		Connection aConnection = null;

		String sql = "update sell_mobile_info"
				+ " set comlimit = ? " 
				+ " where c_mobile = ? ";

		try {

			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.prepareStatement(sql);
			
			aStatement.setInt( 1, comlimit );
			aStatement.setString( 2, mobile );
			
			aStatement.executeUpdate();
			
		} catch ( SQLException e ) {
			e.printStackTrace();
			logger.error(e.getMessage());
			flag = false;
		} finally {
			StatConnectionFactory.free(aConnection, null, aStatement);
		}

		return flag;
	}
	
	/**
	 * 将记录插入到当月记录中去
	 * @param user
	 * @param receive
	 * @param status 0为正常显示  1为扣量
	 * */
	public boolean addSellMobileinfo( List<AccessLog> accessLogList ) {
		boolean flag = true;

		PreparedStatement aStatement = null;
		Connection aConnection = null;

		String sql = "insert ignore into sell_mobile_info"
				+ "( c_cid, c_sid, c_mid, t_date, c_mobile, c_province, c_areaCode, " +
						" c_tronetype, logtime, status, comlimit ) " 
				+ "values ( ?,?,?,now(),?, ?,?,?, now(), ?, ? )";

		try {

			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.prepareStatement(sql);
			
			for( AccessLog accessLog : accessLogList )
			{
				aStatement.setString( 1, accessLog.getCid() );
				aStatement.setString( 2, accessLog.getSid() );
				aStatement.setString( 3, accessLog.getMid() );
				aStatement.setString( 4, accessLog.getMobileno() );
				aStatement.setString( 5, "" );
				aStatement.setString( 6, "" );
				aStatement.setString( 7, "" );
				aStatement.setInt( 8, 0 );
				
				aStatement.setInt( 9, 0 );	
				
				aStatement.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			flag = false;
		} finally {
			StatConnectionFactory.free(aConnection, null, aStatement);
		}

		return flag;
	}
	
	/**
	 * 将记录插入到当月记录中去
	 * @param user
	 * @param receive
	 * @param status 0为正常显示  1为扣量
	 * */
	public boolean addSellMobileinfo( User user, Receives receive, int status ) {
		boolean flag = true;

		PreparedStatement aStatement = null;
		Connection aConnection = null;

		String sql = "insert into sell_mobile_info"
				+ "( c_cid, c_sid, c_mid, t_date, c_mobile, c_province, c_areaCode, " +
						" c_tronetype, logtime, status, comlimit ) " 
				+ "values ( ?,?,?,now(),?, ?,?,?, now(), ?, ? )";

		try {

			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.prepareStatement(sql);
			
			aStatement.setString(1, user.getCid() );
			aStatement.setString(2, user.getSid() );
			aStatement.setString(3, user.getMid() );
			aStatement.setString(4, receive.getMobileno() );
			aStatement.setString(5, user.getAreaCode() );
			aStatement.setString(6, user.getTelCode() );
			aStatement.setInt(7, user.getTroneType() );
			aStatement.setInt(8, status );
			
			//A组
//			if( ",4,5,6,10,b3,b4,b5,b9,".indexOf( "," + receive.getComlimit() + "," ) > -1 ) {
//				aStatement.setInt( 9, 0 );	
//			} else {	//B组
//				aStatement.setInt( 9, 1 );
//			}
			
			aStatement.setInt( 9, 0 );	
			
			aStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			flag = false;
		} finally {
			StatConnectionFactory.free(aConnection, null, aStatement);
		}

		return flag;
	}
	
	public String findComlimitByMobile( String mobile ) {

		String sql = " select comlimit from sell_mobile_info where c_mobile = ? ";
		
		PreparedStatement aStatement = null;
		ResultSet aResultSet = null;
		Connection aConnection = null;

		try {
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.prepareStatement(sql);
			aStatement.setString(1, mobile);
			
			aResultSet = aStatement.executeQuery();

			// fetch data from resultSet, set into DataList
			if ( aResultSet != null && aResultSet.next() ) {
				return aResultSet.getString( "comlimit" );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			StatConnectionFactory.free(aConnection, aResultSet, aStatement);
		}

		return "0";
	}
	
	public boolean findByMid( String mid ) {

		String sql = "select c_mid from sell_mobile_info where c_mid = ? ";

		PreparedStatement aStatement = null;
		ResultSet aResultSet = null;
		Connection aConnection = null;

		try {
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.prepareStatement(sql);
			aStatement.setString(1, mid);
			
			aResultSet = aStatement.executeQuery();

			// fetch data from resultSet, set into DataList
			if ( aResultSet != null && aResultSet.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			StatConnectionFactory.free(aConnection, aResultSet, aStatement);
		}

		return false;
	}

	public static SellMobileinfoService getInstance() {
		return instance;
	}
}
