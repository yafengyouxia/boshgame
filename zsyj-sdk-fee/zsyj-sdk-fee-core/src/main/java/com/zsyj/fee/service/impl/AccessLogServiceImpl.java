package com.zsyj.fee.service.impl;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.Constant;
import com.zsyj.fee.dao.SdkAccesslogMapper;
import com.zsyj.fee.service.AccessLogService;
import com.zsyj.fee.service.CommonService;
import com.zsyj.fee.vo.Accesslog;

public class AccessLogServiceImpl implements AccessLogService {

	private static final Logger logger = LoggerFactory.getLogger(AccessLogServiceImpl.class);
	private static AccessLogService instance = new AccessLogServiceImpl();
	
	//private static int expireSecond = 1000*3600*12;
	
	private String tableNamePrefix = "cfg_sdk_accesslog";
	
	private CommonService commonService = CommonServiceImpl.getInstance();
	
	@Override
	public boolean insert( Accesslog accesslog ) {

		boolean result = true;
		
		if( accesslog == null )
		{
			throw new IllegalArgumentException( "the accesslog is null!" );
		}
		
		SqlSession sqlSession = null;
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( new Date() ); 
		
		checkTableExist( tableName );
		
		try
        {
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SdkAccesslogMapper accesslogMapper = sqlSession.getMapper( SdkAccesslogMapper.class );
			
			accesslog.setTableName(tableName);
			
			accesslogMapper.insert( accesslog );
        }
		catch ( Exception e )
		{  
			result = false;
            e.printStackTrace();  
            logger.error( e.getMessage() );
        }
		finally
		{  
            if(sqlSession != null)
            {  
                sqlSession.close();
            }  
        }
		
		return result;
	}
	
	public static AccessLogService getInstance()
	{
		if (instance == null) {
			synchronized (AccessLogServiceImpl.class) {
                if (instance == null) {
                    instance = new AccessLogServiceImpl ();
                }
            }
		}
		return instance;
	}
	
	private void checkTableExist( String tableName )
	{
		SqlSession sqlSession = null;
		
		if( !commonService.findTableByName(tableName) )
		{
			logger.info( "table["+ tableName +"] not exist" );
			
			try
	        {  
				sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
				
				SdkAccesslogMapper accesslogMapper = sqlSession.getMapper( SdkAccesslogMapper.class );
	            
				accesslogMapper.createNewTable(tableName);
	        }
			catch (Exception e)
			{  
	            e.printStackTrace();  
	            logger.error( e.getMessage() );
	        }
			finally {  
	            if(sqlSession != null)
	            {  
	                sqlSession.close();  
	            }  
	        }
		}
	}
}
