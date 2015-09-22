package com.zsyj.fee.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil {

	
	public static String getContentFromFile( String path )
	{
		String content = "";
		try {
			FileInputStream fileReader = new FileInputStream( new File( path ) );
			int fileSize = fileReader.available();
			byte[] fileBytes = new byte[fileSize];
			
			fileReader.read(fileBytes, 0, fileSize);
			
			content = new String( fileBytes );
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}
