  package com.zsyj.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zsyj.database.MainConnectionFactory;

public class FileCheckFromDB {

	private String filePath = "d://linkid.txt";
	private String foundFilePath = "d://found2.txt";
	private String notFoundFilePath = "d://notfound2.txt";
	
	public void readFile(  ){
		
		Statement aStatement = null;
        ResultSet aResultSet = null;
        Connection aConnection = null;
		
		try {
			BufferedWriter  bfFoundWriter = new BufferedWriter( new FileWriter( new File( foundFilePath ) ) );
			BufferedWriter  bfNotFoundWriter = new BufferedWriter( new FileWriter( new File( notFoundFilePath ) ) );
			
			BufferedReader bfReader = new BufferedReader( new FileReader( new File( filePath ) ) );
			
	        int count = 0;
	        String lineStr = null;
			String sql = "";
			
			aConnection = MainConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			
			while( ( lineStr = bfReader.readLine() ) != null ) {
				
				sql = "select count(1) as num from solar_charge201205 where call_type = 'CU' and status = 1 and link_id = '" + lineStr + "'";
				aResultSet = aStatement.executeQuery( sql );
				
				count = 0;
				if( aResultSet != null && aResultSet.next() ){
					count = aResultSet.getInt( "num" );
				} 
				
				if( count > 0 ){
					bfFoundWriter.write( lineStr + "\t\n" );
				} else {
					bfNotFoundWriter.write( lineStr + "\t\n" );
				}
			}
			
			bfReader.close();
			bfFoundWriter.close();
			bfNotFoundWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MainConnectionFactory.free(aConnection, aResultSet, aStatement);
		}
	}
	
	
	public static void main( String args[] ){
	
		FileCheckFromDB fileTest = new FileCheckFromDB();
		fileTest.readFile();
	}
}
