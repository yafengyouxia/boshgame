package com.zsyj.fee.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.MemCacheHelper;
import com.zsyj.fee.common.enums.CacheEnum;
import com.zsyj.fee.dao.SdkChannelStrategyMapper;
import com.zsyj.fee.dao.SdkStrategyMapper;
import com.zsyj.fee.entity.SdkChannelStrategy;
import com.zsyj.fee.entity.SdkChannelStrategyCondition;
import com.zsyj.fee.entity.SdkStrategy;
import com.zsyj.fee.entity.SdkStrategyCondition;
import com.zsyj.fee.service.SdkStrategyService;
import com.zsyj.fee.vo.PayStrategy;
import com.zsyj.fee.vo.SdkUser;

public class SdkStrategyServiceImpl implements SdkStrategyService
{
	private static final Logger logger = LoggerFactory.getLogger(SdkStrategyServiceImpl.class);
	private static SdkStrategyService instance = null;
	
	//用户memcached缓存默认保存10天
	private static int expireSecond = 1000*600;
	
	@Override
	public SdkStrategy findStrategy(SdkUser user) {
		
		SdkStrategy strategy = null;
		Map<Integer, SdkStrategy> startegyMap = this.findStrategyAll();
		
		try
		{
			SdkChannelStrategy channelStrategy = this.findChannelStrategyAll(  ).get( user.getSid() + "-" + user.getCid() );
			
			if( channelStrategy == null )
			{
				channelStrategy = this.findChannelStrategyAll(  ).get( user.getSid() );
			}
			
			if( channelStrategy != null )
			{
				strategy = startegyMap.get( channelStrategy.getStrategyId() );
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		//没有配置渠道计费策略的使用默认策略
		if( strategy == null )
		{
			strategy = startegyMap.get( 1 )==null?PayStrategy.getDefaultInstance():startegyMap.get( 1 );
		}

		return strategy;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, SdkChannelStrategy> findChannelStrategyAll() {
		
		String key = CacheEnum.Channel_Strategy.getCode();
		
		if( MemCacheHelper.get( key ) != null )
		{
			return (Map<String, SdkChannelStrategy>)MemCacheHelper.get( key );
		}
		else
		{
			return this.findChannelStrategyAllFromDB( key );
		}
	}

	@SuppressWarnings("unchecked")
	private Map<Integer, SdkStrategy> findStrategyAll() {
		
		String key = CacheEnum.Strategy_Info.getCode();
		
		if( MemCacheHelper.get( key ) != null )
		{
			return (Map<Integer, SdkStrategy>)MemCacheHelper.get( key );
		}
		else
		{
			return this.findStrategyAllFromDB( key );
		}
	}

	/**
	 * @param mid
	 * @param imsi
	 * @param uuid
	 * @return
	 */
	private Map<Integer, SdkStrategy> findStrategyAllFromDB( String key )
	{
		SqlSession sqlSession = null;
		Map<Integer, SdkStrategy> strategyMap =  new HashMap<Integer, SdkStrategy>();
		
        try {  

        	sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
        	SdkStrategyMapper strategyMapper = sqlSession.getMapper( SdkStrategyMapper.class );
            List<SdkStrategy> strategyList = strategyMapper.selectByExample( new SdkStrategyCondition() );
            
            if( strategyList != null && strategyList.size() > 0 )
            {
            	for( SdkStrategy strategy : strategyList )
            	{
            		strategyMap.put( strategy.getId(), strategy );
            	}
            	
				MemCacheHelper.set( key, strategyMap, expireSecond*5 );					
            }
            
        } catch (Exception e) {
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return strategyMap;
	}
	
	/**
	 * @param mid
	 * @param imsi
	 * @param uuid
	 * @return
	 */
	private Map<String, SdkChannelStrategy> findChannelStrategyAllFromDB( String key )
	{
		SqlSession sqlSession = null;
		Map<String, SdkChannelStrategy> channelStrategyMap =  new HashMap<String, SdkChannelStrategy>();
		
        try {  

        	sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
        	SdkChannelStrategyMapper channelStrategyMapper = sqlSession.getMapper( SdkChannelStrategyMapper.class );
            List<SdkChannelStrategy> channelStrategyList = channelStrategyMapper.selectByExample( new SdkChannelStrategyCondition() );
            
            if( channelStrategyList != null && channelStrategyList.size() > 0 )
            {
            	for( SdkChannelStrategy tmpSdkChannelStrategy : channelStrategyList )
            	{
            		channelStrategyMap.put( this.convertKey( tmpSdkChannelStrategy ), tmpSdkChannelStrategy );
            	}
            	
				MemCacheHelper.set( key, channelStrategyMap, expireSecond );					
            }
            
        } catch (Exception e) {
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return channelStrategyMap;
	}
	
	private String convertKey( SdkChannelStrategy tmpSdkChannelStrategy )
	{
		String key = tmpSdkChannelStrategy.getSid();
		if( StringUtils.isNotBlank( tmpSdkChannelStrategy.getCid() ) )
		{
			key = tmpSdkChannelStrategy.getSid() + "-" + tmpSdkChannelStrategy.getCid();
		}
		return key;
	}
	
	public static SdkStrategyService getInstance()
	{
		if (instance == null) {
			synchronized (SdkStrategyServiceImpl.class) {
                if (instance == null) {
                    instance = new SdkStrategyServiceImpl ();
                }
            }
		}
		
		return instance;
	}
}
