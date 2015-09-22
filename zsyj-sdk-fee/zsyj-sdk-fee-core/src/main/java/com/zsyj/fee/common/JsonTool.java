package com.zsyj.fee.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTool
{
	public class ComparatorByProp implements Comparator
	{
		 public int compare(Object arg0, Object arg1)
		 {
			 List<String> user0=(List<String>)arg0;
			 List<String> user1=(List<String>)arg1;
			 
			 //根据Y轴排序
			 int flag= Double.valueOf( user1.get(2) ).compareTo( Double.valueOf( user0.get(2) ) );
			 return flag;
		 }
	}
	
	public class ComparatorByPath implements Comparator
	{
		 public int compare(Object arg0, Object arg1)
		 {
			 List<String> user0=(List<String>)arg0;
			 List<String> user1=(List<String>)arg1;
			 
			 //顺序排序
			 int flag= String.valueOf( user0.get(3) ).compareTo( String.valueOf( user1.get(3) ) );
			 
			 return flag;
		 }
	}
	
	private JSONObject convertJson( String filePath ) throws IOException, ParseException, JSONException
	{
		String content = "";
		FileReader fr=new FileReader( filePath );

		//可以换成工程目录下的其他文本文件
		String tmpStr = "";
        BufferedReader br=new BufferedReader(fr);
        while( ( tmpStr = br.readLine() )!=null)
        {
        	content += tmpStr;
        }
        br.close();
		
        JSONObject jsonObj = new JSONObject(content);
		return jsonObj;
	}
	
	private List<List<String>> parseJsonObj( JSONObject obj, List<String> parseParamList, String keyWord ) throws JSONException
	{
		boolean chooseFlag = false;
		List<String> paramValues = null;
		List<List<String>> result = new ArrayList<List<String>>();
		
		JSONArray jsonArray = obj.getJSONArray( "gameobjects" );
		
		for( int i = 0; i < jsonArray.length(); i++ )
		{
			//init
			chooseFlag = false;
			paramValues = new ArrayList<String>();
			
			JSONObject gameObj = (JSONObject) jsonArray.get(i);
			
			for( String param : parseParamList )
			{
				if( param.equals( "name" ) && ( "path".equals( keyWord ) || "prop".equals( keyWord ) ) )
				{
					JSONObject componentsObj = (JSONObject) gameObj.getJSONArray( "components" ).get(0);
					paramValues.add( componentsObj.optString("name") );
				}
				else if( param.equals("path") )
				{
					JSONObject componentsObj = (JSONObject) gameObj.getJSONArray( "components" ).get(0);
					JSONObject fileDataObj = componentsObj.getJSONObject( "fileData" );
					String path = fileDataObj.optString("path");
					
					//prop_10001_1.png是无用的图片  不做处理
					if( path.indexOf( "prop_10000_1.png" ) > -1 )
					{
						chooseFlag = false;
						break;
					}
					
					//PATH不是索引的东西
					if( path.indexOf( keyWord ) > -1 )
					{
						chooseFlag = true;
						//System.out.println( "gameObj:" +gameObj );
					}
					else
					{
						paramValues = null;
						break;
					}
					
					paramValues.add( path );
				}
				else
				{
					paramValues.add( gameObj.optString( param ).trim() );	
				}
			}
			
			if( paramValues != null && chooseFlag )
			{
				result.add( paramValues );	
			}
		}
		
		return result;
	}
	
	private String packageCode( JSONObject obj ) throws JSONException 
	{
		String pathWay = "";
		
		Map<String,String> pathWayMap = new HashMap<String, String>( );		//路径列表
		
		StringBuffer sb = new StringBuffer();
		
		//读取路径坐标
		String pathContent = "pWayPointArray_[0]->addControlPoint( ccpDesignToScreen( [1], [2] ) );";
		
		List<List<String>> pathValuesList = this.parseJsonObj(obj, 
				new ArrayList<String>( Arrays.asList( new String[]{ "path","x","y", "name" } ) ),
				"path" );
		
		ComparatorByPath pathComparator=new ComparatorByPath();
		Collections.sort( pathValuesList, pathComparator );	
		
		for( List<String> paramValues : pathValuesList )
		{
			String newPath = null;
			if( StringUtils.isBlank( pathWay ) ||  paramValues.get(0).indexOf( pathWay ) < 0 )
			{
				if( StringUtils.isNotBlank( pathWay ) )
				{
					sb.append( "pWayPointArray_" + pathWay + "->addControlPoint(CCPOINT_HERO_POSITION);" )
						.append( "\n" )
						.append( "this->getDataWayPointArray()->addObject(pWayPointArray_" + pathWay + ");" )
						.append( "\n\n" );
				}
				
				newPath = paramValues.get(0);
				newPath = newPath.substring( newPath.indexOf( "path" ) + 4 );
				newPath = newPath.replace( ".png", "" ).trim();
				
				pathWay = newPath;
			}
			
			if( newPath != null  )
			{
				sb.append( "CCPointArray* pWayPointArray_" + pathWay + " = CCPointArray::create(20);" )
					.append( "\n" );
			}
		
			sb.append( pathContent.replace("[0]", pathWay )
					.replace( "[1]", Double.valueOf( paramValues.get(1) ).intValue() + "" )
					.replace( "[2]", Double.valueOf( paramValues.get(2) ).intValue() + "" )  )
					.append( "\n" );
			
			System.out.println( "pathWay:" + pathWay + " getPathWay:" + pathWayMap.get( pathWay ) );
			if( pathWayMap.get( pathWay ) == null )
			{
				pathWayMap.put(pathWay, pathWay);
			}
		}
		sb.append( "pWayPointArray_" + pathWay + "->addControlPoint(CCPOINT_HERO_POSITION);" )
			.append( "\n" )
			.append( "this->getDataWayPointArray()->addObject(pWayPointArray_" + pathWay + ");" )
			.append( "\n\n" );
		
		sb.append( "\n" );
		
		//读取道具坐标
		String itemFrontStr = "";
		String itemBackStr = "";
		String itemFrontContent = "this->getDataItemArrayFront()->addObject( CDataItem::create(0.0f, [0], 10000, 0, 0, 0, NULL, ccpDesignToScreen( [1],  [2] )) ); ";
		String itemBackContent  = "this->getDataItemArrayFront()->addObject( CDataItem::create(0.0f, [0], 10000, 0, 0, 0, NULL, ccpDesignToScreen( [1],  [2] )) ); ";
		
		List<List<String>> itemValuesList = this.parseJsonObj(obj, 
				new ArrayList<String>( Arrays.asList( new String[]{ "path","x","y" } ) ),
				"item" );
		
		String path = null;
		
		for( List<String> paramValues : itemValuesList )
		{
			path = paramValues.get(0).substring( paramValues.get(0).indexOf( "_" ) + 1 );
			path = path.replace( ".png", "" ).trim();
			
			if( path.startsWith( "10" ) )
			{
				itemFrontStr = itemFrontStr + itemFrontContent.replace("[0]", path )
						.replace( "[1]", Double.valueOf( paramValues.get(1) ).intValue() + "" )
						.replace( "[2]", Double.valueOf( paramValues.get(2) ).intValue() + "" )
							 + "\n";	
			}
			else
			{
				itemBackStr = itemBackStr + itemBackContent.replace("[0]", path )
						.replace( "[1]", Double.valueOf( paramValues.get(1) ).intValue() + "" )
						.replace( "[2]", Double.valueOf( paramValues.get(2) ).intValue() + "" )
							 + "\n";
			}
		}
		
		sb.append( "// 道具 *时间 *类型*帧数*血量*速度*金币*钻石*路径\n" )
			.append( itemFrontStr ).append( "\n" ).append( itemBackStr ).append( "\n" );
		
		//读取前置装饰坐标
		String propFrontStr = "";
		String propBackStr = "";
		
		String propFrontContent = "this->getDataPropsArrayFront()->addObject( CDataProps::create( [0], ccpDesignToScreen( [1],  [2] ), [3]f, false, false, 0 ) );";
		
		String propBackContent  = "this->getDataPropsArrayBack()->addObject( CDataProps::create( [0], ccpDesignToScreen( [1],  [2] ), [3]f, false, false, [4] ) );";
		
		List<List<String>> propValuesList = this.parseJsonObj(obj, 
				new ArrayList<String>( Arrays.asList( new String[]{ "path","x","y", "rotation", "name", "zorder" } ) ),
				"prop" );
		
		ComparatorByProp propComparator=new ComparatorByProp();
		Collections.sort( propValuesList, propComparator );	
		
		for( List<String> paramValues : propValuesList )
		{
			path = paramValues.get(0).substring( paramValues.get(0).indexOf( "_" ) + 1 );
			path = path.replace( ".png", "" ).trim();
			
			String rotation = paramValues.get(3);
			if( rotation.indexOf( "." ) < 0 )
			{
				rotation = rotation + ".0";
			}
			
			if( paramValues.get(4).endsWith( "_f" ) )
			{
				propFrontStr = propFrontStr + propFrontContent.replace("[0]", path )
						.replace( "[1]", Double.valueOf( paramValues.get(1) ).intValue() + "" )
						.replace( "[2]", Double.valueOf( paramValues.get(2) ).intValue() + "" )
						.replace( "[3]", rotation )
						 + "\n";
			}
			else
			{
				propBackStr = propBackStr + propBackContent.replace("[0]", path )
						.replace( "[1]", Double.valueOf( paramValues.get(1) ).intValue() + "" )
						.replace( "[2]", Double.valueOf( paramValues.get(2) ).intValue() + "" )
						.replace( "[3]", rotation )
						 + "\n";
				
				if( pathWay.startsWith( "1" ) && path.startsWith( "2" ) )	//文件名以2开头类似20033
				{
					propBackStr = propBackStr.replace( "[4]", "100" );
				}
				else
				{
					propBackStr = propBackStr.replace( "[4]", paramValues.get(5) ); 
				}
			}
		}
		
		sb.append( "// 背景\n" )
			.append( "this->getDataPropsArrayBack()->addObject( CDataProps::create(" + pathWay.substring(0,1) + "0000, CCPointCenter+ccp(1,-1), 0.0f, true, false, 10));\n" )
			.append( "this->getDataPropsArrayBack()->addObject( CDataProps::create(" + pathWay.substring(0,1) + "0000, CCPointCenter+ccp(-1,-1), 0.0f, false, false, 10));\n" )
			.append( "this->getDataPropsArrayBack()->addObject( CDataProps::create(" + pathWay.substring(0,1) + "0000, CCPointCenter+ccp(1,1), 0.0f, true, true, 10));\n" )
			.append( "this->getDataPropsArrayBack()->addObject( CDataProps::create(" + pathWay.substring(0,1) + "0000, CCPointCenter+ccp(-1,1), 0.0f, false, true, 10));\n\n" );
		
		sb.append( propFrontStr ).append( "\n" ).append( propBackStr );
		
		//最后添加怪物波数
		sb.append( "{\n" ).append( "CCArray* pDataMonsterArray = CCArray::create();\n" )
			.append( "for(int i=0 ; i<20; i++){    //怪物 *类型 *时间 *路径 *血量 *速度 *金币 *钻石" ).append( "\n\n" );
		
		System.out.println( "pathWayMap size:" + pathWayMap.size() );
		Iterator<String> iterator = pathWayMap.keySet().iterator();
		while( iterator.hasNext() )
		{
			sb.append( "pDataMonsterArray->addObject( CDataMonster::getDataMonster(CRandom::get(1, 14))->clone()->reborn(i*1.5f+CRandom::get(0.0f, 0.4f), pWayPointArray_" + iterator.next() + ", 1400, 40, 20, 0) ); " )
				.append( "\n" );
		}
		
		sb.append( "\n}" ).append("this->getDataMonsterArray()->addObject(pDataMonsterArray);\n}\n");
		return sb.toString();
	}
	
	private void savaFile( String content, String path, String fileName )
	{
		try {
			FileWriter fr=new FileWriter( path + fileName + ".txt" );
			fr.append(content);
			fr.flush();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main( String args [] )
	{
		JsonTool jsonTool = new JsonTool();
		
		for( int i = 0; i <= 12; i++ )
		{
			String prefixPath = "C:\\Users\\ROOT\\Desktop\\jsonAuto\\3lv" + i + "\\Resources\\";
			try
			{
				JSONObject jsonObj = jsonTool.convertJson( prefixPath + "3lv" + i + ".json" );
				String result = jsonTool.packageCode(jsonObj);
				//System.out.println( result );
				
				jsonTool.savaFile( result, "C:\\Users\\ROOT\\Desktop\\jsonAuto\\text\\", "3lv" + i );
			}
			catch ( Exception e )
			{
				e.printStackTrace();
			} 
		}
	}
}