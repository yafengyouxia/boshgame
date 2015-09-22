package com.zsyj.fee.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.dao.CfgSdkTroneMapper;
import com.zsyj.fee.entity.CfgSdkTrone;
import com.zsyj.fee.entity.CfgSdkTroneCondition;
import com.zsyj.fee.service.CfgSdkTroneService;

public class CfgSdkTroneServiceImpl implements CfgSdkTroneService
{
	private static final Logger logger = LoggerFactory.getLogger(CfgSdkTroneServiceImpl.class);
	private volatile static CfgSdkTroneService instance = null;
	
	@Override
	public List<CfgSdkTrone> findBySpid(int spId) {
		
		SqlSession sqlSession = null;
		List<CfgSdkTrone> troneList =  null;
		
        try 
        {
        	sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
        	CfgSdkTroneMapper sdkTroneMapper = sqlSession.getMapper( CfgSdkTroneMapper.class );
        	
        	CfgSdkTroneCondition condition = new CfgSdkTroneCondition();
        	condition.createCriteria().andSpIdEqualTo( spId + "" );
        	
        	troneList = sdkTroneMapper.selectByExample(condition);
            
        } catch (Exception e) {
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return troneList;
	}

	@Override
	public boolean update(CfgSdkTrone sdkTrone) {
		
		boolean result = true;
		SqlSession sqlSession = null;
		
        try
        {  
        	sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
        	
        	CfgSdkTroneMapper sdkTroneMapper = sqlSession.getMapper( CfgSdkTroneMapper.class );
        	
        	sdkTroneMapper.updateByPrimaryKey(sdkTrone);
        } 
        catch (Exception e)
        {
        	result = false;
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } 
        finally 
        {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return result;
	}
	
	@Override
	public List<CfgSdkTrone> findByStatus( byte status ) {
		
		SqlSession sqlSession = null;
		List<CfgSdkTrone> troneList =  null;
		
        try
        {
        	sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
        	CfgSdkTroneMapper sdkTroneMapper = sqlSession.getMapper( CfgSdkTroneMapper.class );
        	
        	CfgSdkTroneCondition condition = new CfgSdkTroneCondition();
        	condition.createCriteria().andStatusEqualTo( status );
        	
        	troneList = sdkTroneMapper.selectByExample(condition);
            
        } catch (Exception e) {
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return troneList;
	}
	
	public static CfgSdkTroneService getInstance()
	{
		if (instance == null) {
			synchronized (CfgSdkTroneServiceImpl.class) {
                if (instance == null) {
                    instance = new CfgSdkTroneServiceImpl ();
                }
            }
		}
		
		return instance;
	}
}
