package com.zsyj.fee.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.dao.SdkSynurlLogMapper;
import com.zsyj.fee.entity.SdkSynurlLog;
import com.zsyj.fee.entity.SdkSynurlLogCondition;
import com.zsyj.fee.service.SdkSynUrlLogService;

public class SdkSynUrlLogServiceImpl implements SdkSynUrlLogService {

	private static final Logger logger = LoggerFactory.getLogger( SdkSynUrlLogServiceImpl.class );
	private static SdkSynUrlLogService instance = new SdkSynUrlLogServiceImpl( );
	
	@Override
	public boolean insert(SdkSynurlLog log) {
		
		boolean result = true;
		SqlSession sqlSession = null;
		
		try
		{  
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			SdkSynurlLogMapper mapper = sqlSession.getMapper( SdkSynurlLogMapper.class );
            
			mapper.insert( log );

        } catch (Exception e) {  
        	result = false;
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return result;
	}
	
	@Override
	public boolean update(SdkSynurlLog log) {
		
		boolean result = true;
		SqlSession sqlSession = null;
		
		try
		{  
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			SdkSynurlLogMapper mapper = sqlSession.getMapper( SdkSynurlLogMapper.class );
            
			mapper.updateByPrimaryKey( log );

        } catch (Exception e) {  
        	result = false;
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return result;
	}
	
	@Override
	public List<SdkSynurlLog> find(byte type, int size) {
		
		SqlSession sqlSession = null;
		List<SdkSynurlLog> logList = null;

		try
		{  
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SdkSynurlLogMapper mapper = sqlSession.getMapper( SdkSynurlLogMapper.class );
			
			SdkSynurlLogCondition condition = new SdkSynurlLogCondition();
			
			condition.createCriteria().andTypeEqualTo( type ).andStatusEqualTo( (byte)0 );
			condition.setOrderByClause( " add_time desc limit " + size );
			
			logList = mapper.selectByExample(condition);
			
        } catch (Exception e) {
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return logList;	
	}
	
	public static SdkSynUrlLogService getInstance()
	{
		return instance;
	}
}
