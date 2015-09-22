package com.sz5z.accesslog.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.database.StatConnectionFactory;

public class MobileSidCidService {

	private static final Logger logger = LoggerFactory.getLogger(MobileSidCidService.class);
	private static MobileSidCidService instance = new MobileSidCidService();
	
	/**
	 * 统计新增的sid，cid
	 * */
	public boolean statSidCid(  ) {
		
		boolean result = true;
		Statement aStatement = null;
		Connection aConnection = null;
		
		String sql = "insert into mobile_sid_cid  (c_sid,c_cid) select distinct c_SID, c_CID " +
		" from mobile_stat_result_cid_area " +
		" where concat( c_sid, c_cid ) not in ( select concat( c_sid, c_cid ) from mobile_sid_cid ) ";

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

	public static MobileSidCidService getInstance() {
		return instance;
	}
}
