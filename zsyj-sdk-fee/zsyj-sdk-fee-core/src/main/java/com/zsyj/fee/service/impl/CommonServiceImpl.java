package com.zsyj.fee.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.database.SlaveConnectionFactory;
import com.zsyj.database.StatConnectionFactory;
import com.zsyj.fee.service.CommonService;

public class CommonServiceImpl implements CommonService {

	private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);
	private static CommonService instance = new CommonServiceImpl();
	
	/** 已存在的表名 */
	private static Map<String,String> exsitsTable = new HashMap<String, String>();
	
	@Override
	public boolean findTableByNameFromStat(String tableName) {
		
		boolean flag = false;
		
		if( exsitsTable.get( tableName ) == null )
		{
			Statement aStatement = null;
	        ResultSet aResultSet = null;
	        Connection aConnection = null;
			
	        String sql = "SHOW TABLES LIKE '"+ tableName + "';";
	        
	        try {
				aConnection = StatConnectionFactory.getConnection();
				aStatement = aConnection.createStatement();
				aResultSet =  aStatement.executeQuery( sql );
				if( aResultSet != null && aResultSet.next() )
				{
					exsitsTable.put( tableName , "" );
					flag = true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			} finally {
				StatConnectionFactory.free(aConnection, aResultSet, aStatement);
			}	
		}
		else
		{
			flag = true;
		}
		
		return flag;
	}
	
	@Override
	public boolean findTableByName(String tableName) {
		
		boolean flag = false;
		
		if( exsitsTable.get( tableName ) == null )
		{
			logger.info( "check table[" + tableName + "] is exist" );
			
			Statement aStatement = null;
	        ResultSet aResultSet = null;
	        Connection aConnection = null;
			
	        String sql = "SHOW TABLES LIKE '"+ tableName + "';";
	        
	        try {
				aConnection = SlaveConnectionFactory.getConnection();
				aStatement = aConnection.createStatement();
				aResultSet =  aStatement.executeQuery( sql );
				if( aResultSet != null && aResultSet.next() )
				{
					exsitsTable.put( tableName , "" );
					flag = true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			} finally {
				SlaveConnectionFactory.free(aConnection, aResultSet, aStatement);
			}	
		}
		else
		{
			flag = true;
		}
		
		return flag;
	}

	@Override
	public String findProvinceName(String provinceCode) {
		
		String provinceName = "nofound";
		Statement aStatement = null;
		ResultSet aResultSet = null;
		Connection aConnection = null;

		String sql = "select name from cfg_area where code = '" + provinceCode + "'";
		
		try {
			aConnection = SlaveConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			aResultSet = aStatement.executeQuery(sql);

			// fetch data from resultSet, set into DataList
			if (aResultSet != null && aResultSet.next()) {
				
				provinceName = aResultSet.getString("name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			SlaveConnectionFactory.free(aConnection, aResultSet, aStatement);
		}
		
		return provinceName;
	}
	
	public static CommonService getInstance()
	{
		return instance;
	}
}
