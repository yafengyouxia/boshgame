package com.zsyj.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 读数据库
 * */
public class StatConnectionFactory {

	public static DataSource instance = setupDataSource();

	public static synchronized Connection getConnection() throws SQLException {
		return instance.getConnection();
	}

	public static DataSource getDataSource() throws SQLException {
		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println("Setting up data source.");
		System.out.println("Done.");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			System.out.println("Creating connection.");
			conn = getConnection();
			printDataSourceStats(getDataSource());
			System.out.println("Creating statement.");
			stmt = conn.createStatement();
			System.out.println("Executing statement.");
			rset = stmt.executeQuery("select * from userInfo");
			System.out.println("Results:");
			int numcols = rset.getMetaData().getColumnCount();
			while (rset.next()) {
				for (int i = 1; i <= numcols; i++) {
					System.out.print("\t" + rset.getString(i));
				}

				System.out.println("");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				rset.close();
			} catch (Exception e) {
			}
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
			try {
				printDataSourceStats(getDataSource());
			} catch (SQLException ex) {
			}
		}
	}

	public static DataSource setupDataSource() {
		BasicDataSource ds = new BasicDataSource();

		ResourceBundle rb 	= ResourceBundle.getBundle ("config");
		String dbSlave01Url = rb.getString ("dbStatUrl");
		String dbSlave01UserName = rb.getString ("dbStatUserName");
		String dbSlave01Password = rb.getString ("dbStatPassword");
		
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl( dbSlave01Url );
		ds.setUsername( dbSlave01UserName );
		ds.setPassword( dbSlave01Password );
		
		ds.setInitialSize(8);
		ds.setMaxActive(320);
		ds.setMaxIdle(200);
		ds.setMinIdle(100);
		ds.setMaxWait(64L);

		return ds;
	}

	public static void printDataSourceStats(DataSource ds) throws SQLException {
		BasicDataSource bds = (BasicDataSource) ds;
		System.out.println("NumActive: " + bds.getNumActive());
		System.out.println("NumIdle: " + bds.getNumIdle());
	}

	public static void shutdownDataSource(DataSource ds) throws SQLException {
		BasicDataSource bds = (BasicDataSource) ds;
		bds.close();
	}
	
	/**
	 * 关闭连接资源
	 * 
	 * @param conn
	 */
	public static void free(Connection conn, ResultSet resultSet,
			Statement statement) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
