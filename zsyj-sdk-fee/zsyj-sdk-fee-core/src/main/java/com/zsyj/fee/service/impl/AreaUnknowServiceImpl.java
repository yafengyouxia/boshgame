package com.zsyj.fee.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.dao.SdkUnknowAreaMapper;
import com.zsyj.fee.entity.SdkUnknowArea;
import com.zsyj.fee.entity.SdkUnknowAreaCondition;
import com.zsyj.fee.service.AreaUnkonwService;

public class AreaUnknowServiceImpl implements AreaUnkonwService {

	private static final Logger logger = LoggerFactory.getLogger(AreaUnknowServiceImpl.class);
	private static AreaUnkonwService instance = new AreaUnknowServiceImpl();
	
	@Override
	public SdkUnknowArea find( String value ) 
	{
		SqlSession sqlSession = null;
		SdkUnknowArea unknowArea = null;
		
		try
		{  
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			SdkUnknowAreaMapper areaUnknowMapper = sqlSession.getMapper( SdkUnknowAreaMapper.class );
            
			SdkUnknowAreaCondition condition = new SdkUnknowAreaCondition(  );
			condition.createCriteria().andValueEqualTo( value );
			
	        List<SdkUnknowArea> unknowAreaList = areaUnknowMapper.selectByExample(condition);
	        
	        if( unknowAreaList != null && unknowAreaList.size() > 0 )
	        {
	        	unknowArea = unknowAreaList.get(0);
	        }
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return unknowArea;
	}
	
	@Override
	public boolean insert(SdkUnknowArea unkonwArea) {
		
		boolean result = true;
		SqlSession sqlSession = null;
		
		try
		{  
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			SdkUnknowAreaMapper areaUnknowMapper = sqlSession.getMapper( SdkUnknowAreaMapper.class );
            
	        areaUnknowMapper.insert( unkonwArea );

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
	
	public static AreaUnkonwService getInstance()
	{
		return instance;
	}
}
