package com.zsyj.fee.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.dao.AdvanceCompanyMapper;
import com.zsyj.fee.dao.AdvanceConfigMapper;
import com.zsyj.fee.entity.AdvanceCompany;
import com.zsyj.fee.entity.AdvanceCompanyCondition;
import com.zsyj.fee.entity.AdvanceConfig;
import com.zsyj.fee.entity.AdvanceConfigCondition;
import com.zsyj.fee.service.AdvanceService;

public class AdvanceServiceImpl implements AdvanceService
{
	private static final Logger logger = LoggerFactory.getLogger(AdvanceServiceImpl.class);
	private static AdvanceService instance = new AdvanceServiceImpl();
	
	//private static int expireSecond = 1000*3600*12;
	
	@Override
	public AdvanceConfig findBySmsId( int smsConfigId, String channelId ) 
	{
		AdvanceConfig advanceConfig = null;
		
		SqlSession sqlSession = null;
		
		try
		{
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			AdvanceConfigMapper mapper = sqlSession.getMapper( AdvanceConfigMapper.class );
            
			AdvanceConfigCondition condition = new AdvanceConfigCondition(  );
			condition.createCriteria().andSpidEqualTo( smsConfigId + "" );
			
	        List<AdvanceConfig> advanceConfigList = mapper.selectByExample(condition);
	        
	        if( advanceConfigList != null && advanceConfigList.size() > 0 )
	        {
	        	for( AdvanceConfig tmpAdvanceConfig : advanceConfigList )
	        	{
	        		if( tmpAdvanceConfig.getCid().equals( channelId ) || channelId.indexOf( tmpAdvanceConfig.getCid() ) > -1 )
	        		{
	        			advanceConfig = tmpAdvanceConfig;
	        			break;
	        		}
	        	}
	        }
        }
		catch ( Exception e )
		{  
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
		
		return advanceConfig;
	}
	
	@Override
	public AdvanceCompany findCpCompany(int cpId) {
		
		AdvanceCompany advanceCompany = null;
		
		SqlSession sqlSession = null;
		
		try
		{  
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			AdvanceCompanyMapper mapper = sqlSession.getMapper( AdvanceCompanyMapper.class );
            
			AdvanceCompanyCondition condition = new AdvanceCompanyCondition(  );
			condition.createCriteria().andCidEqualTo( String.valueOf( cpId ) );
			
	        List<AdvanceCompany> advanceCompanyList = mapper.selectByExample(condition);
	        
	        if( advanceCompanyList != null && advanceCompanyList.size() > 0 )
	        {
	        	advanceCompany = advanceCompanyList.get(0);
	        }
	        
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return advanceCompany;
	}
	
	public static AdvanceService getInstance()
	{
		if (instance == null) {
			synchronized (AdvanceServiceImpl.class) {
                if (instance == null) {
                    instance = new AdvanceServiceImpl ();
                }
            }
		}
		return instance;
	}
}
