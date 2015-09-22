  package com.zsyj.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SmsDtFileWirter {
	
	private String filePath = "d://work//smsdt";
	private String fileWriterPath = "d://work//smsdt2//";
	
	private Map<String, String> question = new HashMap<String, String>();
	
	public void readFile(  ){
		
		try {
			File root = new File( filePath );
			File[] fileList = root.listFiles();
			
			for( File file : fileList ) {
				
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
				BufferedReader bfReader = new BufferedReader( isr );
				
				File fileWriter = new File( fileWriterPath + file.getName()  );
				if( !fileWriter.exists() ) {
					fileWriter.createNewFile();
				}
				
				BufferedWriter  bfWriter = new BufferedWriter( new FileWriter( fileWriter ) );
				
		        String lineStr = null;
				
				while( ( lineStr = bfReader.readLine() ) != null ) {
					
					/**
					if( lineStr.indexOf( "回复任意内容" ) > -1 ){
						continue;
					}
					*/
					
					if( lineStr.indexOf("回复") > -1 ) {
						
						if( lineStr.indexOf( "确认点播：" ) > -1 ) {
							lineStr = lineStr.substring( lineStr.indexOf( "确认点播：" ) + 5 );
						}
						
						if( lineStr.indexOf( "中国移动&&" ) > -1 ) {
							lineStr = lineStr.substring( 0, lineStr.indexOf( "中国移动&&" ) + 6 );
							lineStr = lineStr.replace( "中国移动&&", "&&" );
						} else if( lineStr.indexOf( "&&" ) > -1 ) {
							lineStr = lineStr.substring( 0, lineStr.indexOf( "&&" ) + 2 );
						}
						
						if( lineStr.indexOf( "？中国移动" ) > -1 ) {
							lineStr = lineStr.substring( 0, lineStr.indexOf( "？中国移动" ) + 5 );
							lineStr = lineStr.replace( "？中国移动" , "&&");
						}
						
						if( question.get( lineStr ) == null ){
							bfWriter.write( lineStr + "\r\n");
							question.put(lineStr, "");	
						}
					}
				}
				
				bfReader.close();
				bfWriter.close();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main( String args[] ){
	
		SmsDtFileWirter fileTest = new SmsDtFileWirter();
		fileTest.readFile();
	}
}
