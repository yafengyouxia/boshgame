  package com.zsyj.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zsyj.database.MainConnectionFactory;

public class ImportLinkid {

	
	private String filePath = "d://linkid.txt";
	
	public void readFile(  ){
		
		Statement aStatement = null;
        ResultSet aResultSet = null;
        Connection aConnection = null;
		
		try {
			BufferedReader bfReader = new BufferedReader( new FileReader( new File( filePath ) ) );
			
	        String lineStr = null;
			String sql = "";
			
			aConnection = MainConnectionFactory.getConnection();
			aStatement = aConnection.createStatement();
			
			while( ( lineStr = bfReader.readLine() ) != null ) {
				
				sql = "insert into tmplinkid value( '" + lineStr + "' )";
				aStatement.executeUpdate( sql );
			}
			
			bfReader.close();
			
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
	
		ImportLinkid fileTest = new ImportLinkid();
		fileTest.readFile();
	}
}
