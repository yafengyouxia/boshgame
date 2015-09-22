package com.zsyj.fee.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaxXmlDocument {

	private static final Logger logger = LoggerFactory.getLogger(SaxXmlDocument.class);
	
	public Document parseXml( InputStream inputstream )
	{
		Document doc = null;
	
		try {
		
			String inputString = "";
			BufferedReader br = new BufferedReader(new InputStreamReader( inputstream ));
			String line = null;
			while((line=br.readLine())!=null){
			  inputString += line;
			}
			br.close();
			
			logger.info( inputString );
			
			doc = DocumentHelper.parseText(inputString);
			
		} catch (DocumentException e) {
			logger.error( e.getMessage() );
			e.printStackTrace();
		} catch (IOException e) {
			logger.error( e.getMessage() );
			e.printStackTrace();
		}
		
		return doc;
	}
	
	public List<String> findNodeValues( Document doc, String path )
	{
		List<String> textList = new ArrayList<String>();
		if( doc != null )
		{
			List<Node> nodeList = doc.selectNodes(path);
			if( nodeList != null && nodeList.size() > 0 )
			{
				for( Node node : nodeList ) {
					textList.add( node.getText() );	
				}
			}	
		}
		return textList;
	}
	
	public String findNodeValue( Document doc, String path )
	{
		String text = "";
		if( doc != null )
		{
			Node processStatus = doc.selectSingleNode(path);
			if( processStatus != null )
			{
				text = processStatus.getText();
			}	
		}
		return text;
	}
	
	public static void main( String args [] )
	{
		Document doc = null;
		
		try {
		
			SAXReader reader = new SAXReader();
			doc = reader.read( new File( "d://test.sql" ) );
			
			SaxXmlDocument saxXmlDocument = new SaxXmlDocument();
			
			List<String> textList = saxXmlDocument.findNodeValues(doc, "/pwd_message_list/data/message/linkid");
			for( String str : textList ){
				System.out.println( str );
			}
		} catch (DocumentException e) {
			logger.error( e.getMessage() );
			e.printStackTrace();
		}
		
	}
}
