package com.zsyj.fee.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.MemCacheHelper;
import com.zsyj.fee.common.enums.CacheEnum;
import com.zsyj.fee.dao.SdkTroneStrategyMapper;
import com.zsyj.fee.entity.SdkTroneStrategy;
import com.zsyj.fee.entity.SdkTroneStrategyCondition;
import com.zsyj.fee.service.TroneStrategyService;

/**
 * 短信通道配置smsconfigifo
 * 
 * @author hujian
 */
public class TroneStrategyServiceImpl implements TroneStrategyService {

	private static final Logger logger = LoggerFactory
			.getLogger(TroneStrategyServiceImpl.class);
	private static TroneStrategyService instance = new TroneStrategyServiceImpl();
	
	/** 默认5分钟 */
	private static int expireSecond = 300*1000;
	
	@Override
	public SdkTroneStrategy find(int id) {
		
		String key = CacheEnum.TRONE_STRATEGY.getCode() + "_" + id;
		
		if( MemCacheHelper.get( key ) != null )
		{
			return (SdkTroneStrategy)MemCacheHelper.get( key );
		}
		else
		{
			return this.findByid( id, key );
		}
	}
	
	private SdkTroneStrategy findByid( int id, String memkey ) {

		SqlSession sqlSession = null;
		SdkTroneStrategy  sdkTroneStrategy = null;
		
        try {  
            sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();  
            
            SdkTroneStrategyMapper sdkTroneStrategyMapper = sqlSession.getMapper( SdkTroneStrategyMapper.class );
            
            sdkTroneStrategy = sdkTroneStrategyMapper.selectByPrimaryKey(id);
            
            if( sdkTroneStrategy != null )
            {
				MemCacheHelper.set( memkey, sdkTroneStrategy, expireSecond );			
            }
            
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return sdkTroneStrategy;
	}
	
	public static TroneStrategyService getInstance() {
		return instance;
	}

	@Override
	public Map<Integer, SdkTroneStrategy> findAll() {
		
		String key = CacheEnum.TRONE_STRATEGY.getCode();
		
		if( MemCacheHelper.get( key ) != null )
		{
			return (Map<Integer, SdkTroneStrategy>)MemCacheHelper.get( key );
		}
		else
		{
			return this.findAll( key );
		}
	}
	
	private Map<Integer, SdkTroneStrategy> findAll( String memkey ) {

		SqlSession sqlSession = null;
		
		SdkTroneStrategy defaultStrategy = null;
		
		//key--masterId
		Map<Integer, SdkTroneStrategy>  sdkTroneStrategyMap = new HashMap<Integer, SdkTroneStrategy>();
		
		Map<Integer, SdkTroneStrategy>  masterSpStrategyMap = new HashMap<Integer, SdkTroneStrategy>();
		
        try
        {  
            sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();  
            
            SdkTroneStrategyMapper sdkTroneStrategyMapper = sqlSession.getMapper( SdkTroneStrategyMapper.class );
            
            List<SdkTroneStrategy> sdkTroneStrategyList = sdkTroneStrategyMapper.selectByExample( new SdkTroneStrategyCondition() );
            
            if( sdkTroneStrategyList != null )
            {
            	for( SdkTroneStrategy sdkTroneStrategy : sdkTroneStrategyList )
            	{
            		if( sdkTroneStrategy.getType() == null )
            		{
            			continue;
            		}
            		
            		if( sdkTroneStrategy.getType() == 0 )
            		{
            			defaultStrategy = sdkTroneStrategy;
            		}
            		else if(  sdkTroneStrategy.getType() == 1 )
            		{
            			masterSpStrategyMap.put( sdkTroneStrategy.getMasterId(), sdkTroneStrategy );
            		}
            	}

            	for( SdkTroneStrategy sdkTroneStrategy : sdkTroneStrategyList )
            	{
            		if( sdkTroneStrategy.getType() != null
            				&& sdkTroneStrategy.getType() == 2 
            				&& sdkTroneStrategy.getMasterId() != null
            					&& sdkTroneStrategy.getMasterId() > 0 )
            		{
            			if( defaultStrategy != null && sdkTroneStrategy.getMasterId() != 25 )	//masterid=25 为胡静的sdk，不参与全局管控  by 胡剑 2015-09-17
            			{
            				sdkTroneStrategy.setAreaCode( interSect( sdkTroneStrategy.getAreaCode().split(","), defaultStrategy.getAreaCode().split(",") ) );
            			}
            			
            			if( masterSpStrategyMap.get( sdkTroneStrategy.getMasterId() ) != null )
            			{
            				sdkTroneStrategy.setAreaCode( interSect( sdkTroneStrategy.getAreaCode().split(","), masterSpStrategyMap.get( sdkTroneStrategy.getMasterId() ).getAreaCode().split( "," ) ) );
            			}
            		}
            	
            		if( sdkTroneStrategy.getType() != null
            				&& sdkTroneStrategy.getType() == 1
            				&& sdkTroneStrategy.getMasterId() != 25 )
            		{
            			if( defaultStrategy != null )
            			{
            				sdkTroneStrategy.setAreaCode( interSect( sdkTroneStrategy.getAreaCode().split(","), defaultStrategy.getAreaCode().split(",") ) );
            			}
            		}
            		
            		sdkTroneStrategyMap.put(sdkTroneStrategy.getId(), sdkTroneStrategy);
            	}

            	
				MemCacheHelper.set( memkey, sdkTroneStrategyMap, expireSecond );			
            }
            
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return sdkTroneStrategyMap;
	}
	
	// 求两个数组的交集  
    private  String interSect(String[] arr1, String[] arr2)  
    {  
        Map<String, Boolean> map = new HashMap<String, Boolean>();  
        
        String result = ",";
        
        for (String str : arr1)  
        {  
            if (!map.containsKey(str))  
            {  
                map.put(str, Boolean.FALSE);  
            }  
        }  
        for (String str : arr2)  
        {  
            if (map.containsKey(str))  
            {  
                map.put(str, Boolean.TRUE);  
            }  
        }  
   
        for (Iterator<Entry<String, Boolean>> it = map.entrySet().iterator();it.hasNext();)  
        {  
            Entry<String,Boolean> e = (Entry<String,Boolean>)it.next();  
            if (e.getValue().equals(Boolean.TRUE))  
            {  
            	result += e.getKey() + ",";
            }  
        }  
        
        return result;  
    }  
}
