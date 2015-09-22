package com.sz5z.smscat.service;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sz5z.smscat.vo.Receives;
import com.zsyj.database.StatConnectionFactory;
import com.zsyj.fee.common.Constant;

public class RemoteReceivesService {

	private static final Logger logger = LoggerFactory
			.getLogger(RemoteReceivesService.class);
	private static RemoteReceivesService instance = new RemoteReceivesService();

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

	public boolean creatMonthTable()
	{
		Statement aStatement = null;
		boolean createTableResult = true;
		Connection aConnection = null;

		String tableName = "receives" + sdf.format(new Date());

		ResourceBundle rb = ResourceBundle.getBundle("config");
		String createReceiveTable = rb.getString( "createRemoteReceiveTable" );

		String creatTablesql = createReceiveTable.replace("$tableName$",
				tableName);

		try {

			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			createTableResult = aStatement.execute(creatTablesql);

		} catch (SQLException e) {

			createTableResult = false;
			e.printStackTrace();
			logger.error("failed to create table : " + tableName);
		} finally {
			StatConnectionFactory.free(aConnection, null, aStatement);
		}

		return createTableResult;
	}
	
	/**
	 * 将记录插入到当月记录中去
	 * */
	public boolean insertMonthBakReceive(List<Receives> msgList) {
		boolean flag = true;

		if (msgList != null && msgList.size() > 0) {
			PreparedStatement aStatement = null;
			Connection aConnection = null;

			String tableName = "receives" + sdf.format(new Date());

			String sql = "insert into "
					+ tableName
					+ "( smsindex,mobileno,msgtext,chartype,comlimit,username,dateandtime ) values ( ?,?,?,?,?,?,? )";

			try {

				aConnection = StatConnectionFactory.getConnection();
				aStatement = aConnection.prepareStatement(sql);

				for (Receives receive : msgList) {
					aStatement.setString(1, receive.getSmsindex());
					aStatement.setString(2, receive.getMobileno());
					aStatement.setString(3, receive.getMsgtext());
					aStatement.setString(4, receive.getCharType());
					aStatement.setString(5, receive.getComlimit());
					aStatement.setString(6, receive.getUsername());
					aStatement.setString(7, receive.getDateandtime());

					aStatement.executeUpdate();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				flag = false;
			} finally {
				StatConnectionFactory.free(aConnection, null, aStatement);
			}
		}

		return flag;
	}

	public boolean updateReceiveListProcessed( List<Receives> msgList )
	{
		boolean flag = true;
		String updateSql = "update " + " receives" + sdf.format( new Date() )
			+ " set isprocess = 1 where sysid = ?";
		
		System.out.println( "========== updatesql : " + updateSql );
		
		if( msgList != null && msgList.size() > 0 )
		{
			PreparedStatement aStatement = null;
			Connection aConnection = null;
			
			try {
				aConnection = StatConnectionFactory.getConnection();
				aStatement = aConnection.prepareStatement(updateSql);
				
				for( Receives receive : msgList )
				{
					aStatement.setLong( 1, receive.getId() );
					int result = aStatement.executeUpdate();
					
					System.out.println( "id :[" + receive.getId() + "] result :" + result  );
				}
				
			} catch (SQLException e) {
				flag = false;
				e.printStackTrace();
				logger.error( e.getMessage() );
			} finally {
				StatConnectionFactory.free(aConnection, null, aStatement);
			}
		}
		
		return flag;
	}
	
	public Map<String,Integer> getLastMinutes( int minutes )
	{
		Date date = new Date( new Date().getTime() - minutes*60*1000 );
		
		String sql = "select count(1) as num, comlimit from receives" + sdf.format( new Date() )
						+ " where dateandtime > '" + Constant.sdf_yyyyMMddHHmmss.format( date ) + "' group by comlimit";
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		Statement aStatement = null;
		ResultSet aResultSet = null;
		Connection aConnection = null;
		
		try {
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			aResultSet = aStatement.executeQuery(sql);

			// fetch data from resultSet, set into DataList
			if (aResultSet != null) {
				while (aResultSet.next()) {
					map.put( aResultSet.getString( "comlimit" ) , aResultSet.getInt( "num" ) );
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			StatConnectionFactory.free(aConnection, aResultSet, aStatement);
		}

		return map;
	}
	
	/**
	 * 检测当前短信猫是否有许多重复接收的数据
	 * @return String 端口号
	 * */
	public String findManyRepeartLogs()
	{
		String result = null;
		
		Date curTime = new Date();
		curTime = new Date( curTime.getTime() - 2*3600*1000 );
		
		String sql = "select count(1) as num, dateandtime from receives" + sdf.format( new Date() )
				+ " where dateandtime > '" + Constant.sdf_yyyyMMddHHmmss.format(curTime) + "' group by dateandtime having num > 5 limit 1 ";
		
		Statement aStatement = null;
		ResultSet aResultSet = null;
		Connection aConnection = null;
		
		try {
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			aResultSet = aStatement.executeQuery(sql);

			// fetch data from resultSet, set into DataList
			if (aResultSet != null && aResultSet.next()) {
				
				logger.info( "have many repart logs : " + sql );
				result = "there is : " + aResultSet.getString( "num" ) + " logs is repeart when the time is : " + aResultSet.getString( "dateandtime" );
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			StatConnectionFactory.free(aConnection, aResultSet, aStatement);
		}
		
		return result;
	}
	
	/**
	 * 获取当月未处理的信息
	 **/
	public List<Receives> getNoProcessReceiveSmsListByMonth( int size ) {
		
		List<Receives> msgList = new ArrayList<Receives>();
		String sql = "select sysid, smsindex, mobileno, msgtext, chartype, comlimit, username, dateandtime from " 
			+ " receives" + sdf.format( new Date() )
			+ " where isprocess != 1 ";

		if( size > 0 ) {
			sql = sql + " limit " + size;
		}
		
		Statement aStatement = null;
		ResultSet aResultSet = null;
		Connection aConnection = null;

		try {
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			aResultSet = aStatement.executeQuery(sql);

			// fetch data from resultSet, set into DataList
			if (aResultSet != null) {
				Receives receive = null;

				while (aResultSet.next()) {
					receive = new Receives();

					receive.setId( aResultSet.getInt("sysid") );
					receive.setCharType(aResultSet.getString("chartype"));
					receive.setComlimit(aResultSet.getString("comlimit"));
					receive.setDateandtime(aResultSet.getString("dateandtime"));
					receive.setMobileno(aResultSet.getString("mobileno"));
					receive.setMsgtext(aResultSet.getString("msgtext"));
					receive.setSmsindex(aResultSet.getString("smsindex"));
					receive.setUsername(aResultSet.getString("username"));

					msgList.add(receive);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			StatConnectionFactory.free(aConnection, aResultSet, aStatement);
		}

		return msgList;
	}
	
	/**
	 * 获取当月未处理的信息
	 **/
	public Receives getByTest() {
		
		String sql = "select sysid, smsindex, mobileno, msgtext, chartype, comlimit, username, dateandtime from " 
			+ " receives" + sdf.format( new Date() )
			+ " where msgtext like '%9460023851266174%' ";

		Receives receive = null;
		Statement aStatement = null;
		ResultSet aResultSet = null;
		Connection aConnection = null;

		try {
			aConnection = StatConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			aResultSet = aStatement.executeQuery(sql);

			// fetch data from resultSet, set into DataList
			if (aResultSet != null) {

				if (aResultSet.next()) {
					receive = new Receives();

					receive.setId( aResultSet.getInt("sysid") );
					receive.setCharType(aResultSet.getString("chartype"));
					receive.setComlimit(aResultSet.getString("comlimit"));
					receive.setDateandtime(aResultSet.getString("dateandtime"));
					receive.setMobileno(aResultSet.getString("mobileno"));
					receive.setMsgtext(aResultSet.getString("msgtext"));
					receive.setSmsindex(aResultSet.getString("smsindex"));
					receive.setUsername(aResultSet.getString("username"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			StatConnectionFactory.free(aConnection, aResultSet, aStatement);
		}

		return receive;
	}
	
	public static void main( String args [] ) {
		
		RemoteReceivesService remoteReceivesService = new RemoteReceivesService();
		Receives receives = remoteReceivesService.getByTest();
		String msgText = receives.getMsgtext();
		if( msgText.indexOf( "%23" ) > -1 ) {
			System.out.println( msgText = URLDecoder.decode( msgText ) );	
			msgText = msgText.substring( 0, msgText.lastIndexOf( "#" ) + 5 );
			System.out.println( msgText );
		}
	}
	
	
	public static RemoteReceivesService getInstance() {
		return instance;
	}
}
