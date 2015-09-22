  package com.zsyj.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWirter {

	private String filePath = "d://log";
	private String fileWriterPath = "d://log2//";
	
	public void readFile(  ){
		
		try{ 
			File root = new File( filePath );
		
			File[] fileList = root.listFiles();
			
			for( File file : fileList ) {
			
				BufferedReader bfReader = new BufferedReader( new FileReader( file ) );
				
				File fileWriter = new File( fileWriterPath + file.getName()  );
				if( !fileWriter.exists() ) {
					fileWriter.createNewFile();
				}
					
				BufferedWriter  bfWriter = new BufferedWriter( new FileWriter( fileWriter ) );
				
		        String lineStr = null;
				
				while( ( lineStr = bfReader.readLine() ) != null ) {
					
					if( lineStr.indexOf( "test_a" ) > -1 ){
						bfWriter.write(lineStr+"\r\n");
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
	
		FileWirter fileTest = new FileWirter();
		fileTest.readFile();
	}
}
