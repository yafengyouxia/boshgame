package com.zsyj.fee.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.MemCacheHelper;
import com.zsyj.fee.common.enums.CacheEnum;
import com.zsyj.fee.dao.SolarAgentMapper;
import com.zsyj.fee.dao.SolarMonitorMapper;
import com.zsyj.fee.entity.SolarAgent;
import com.zsyj.fee.entity.SolarAgentCondition;
import com.zsyj.fee.entity.SolarMonitor;
import com.zsyj.fee.entity.SolarMonitorCondition;
import com.zsyj.fee.service.SolarMonitorService;

public class SolarMonitorServiceImpl implements SolarMonitorService
{
	private static final Logger logger = LoggerFactory.getLogger(SolarMonitorServiceImpl.class);
	private volatile static SolarMonitorService instance = null;
	
	//用户memcached缓存默认保存10天
	private static int expireSecond = 1000*300;
	
	@Override
	public SolarAgent findSid(String sid) {
		SolarAgent agent = null;
		
		String key = CacheEnum.AGENT_ALL.getCode();
		Map<String, SolarAgent> agentMap = null;
		
		if( MemCacheHelper.get( key ) != null )
		{
			agentMap = (Map<String, SolarAgent>)MemCacheHelper.get( key );
		}
		else
		{
			agentMap = this.findAllAgentFromDB( key );
		}
		
		if( agentMap != null )
		{
			agent = agentMap.get( sid );
		}
		
		return agent;
	}
	
	@Override
	public SolarMonitor findCid( String sid, String cid ) {
		
		SolarMonitor monitor = null;
		String key = CacheEnum.MONITOR_ALL.getCode();
		Map<String, SolarMonitor> monitorMap = null;
		
		if( StringUtils.isBlank(sid) )
		{
			return monitor;
		}
		
		if( MemCacheHelper.get( key ) != null )
		{
			monitorMap = (Map<String, SolarMonitor>)MemCacheHelper.get( key );
		}
		else
		{
			monitorMap = this.findAllMonitorFromDB( key );
		}
		
		if( monitorMap != null )
		{
			Iterator<String> iterator = monitorMap.keySet().iterator();
			while( iterator.hasNext() )
			{
				SolarMonitor mapValue = monitorMap.get( iterator.next() );
				if( sid.equals( mapValue.getAgentCode() + "" ) )
				{
					//精确匹配，立即停止
					if( cid.equals( mapValue.getMonitorCode() ) )
					{
						monitor = mapValue;
						break;						
					}
					//模糊匹配，全局查找
					else if( cid.indexOf( mapValue.getMonitorCode() ) > -1 )
					{
						monitor = mapValue;						
					}
				}
			}
		}
		
		return monitor;
	}
	
	private Map<String, SolarAgent> findAllAgentFromDB( String key )
	{
		SqlSession sqlSession = null;
		Map<String, SolarAgent> agentMap =  null;
		
        try {  
        	
        	sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
        	SolarAgentMapper aolarAgentMapper = sqlSession.getMapper( SolarAgentMapper.class );
            List<SolarAgent> agentList = aolarAgentMapper.selectByExample( new SolarAgentCondition() );
            
            if( agentList != null && agentList.size() > 0 )
            {
            	agentMap = new HashMap<String, SolarAgent>();
            	
            	for( SolarAgent agent : agentList )
            	{
            		agentMap.put(agent.getAgentCode(), agent);
            	}
				MemCacheHelper.set( key, agentMap, expireSecond );					
            }
            
        } catch (Exception e) {
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return agentMap;
	}
	
	/**
	 * @param mid
	 * @param imsi
	 * @param uuid
	 * @return
	 */
	private Map<String, SolarMonitor> findAllMonitorFromDB( String key )
	{
		SqlSession sqlSession = null;
		Map<String, SolarMonitor> monitorMap =  null;
		
        try {  
        	
        	sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
            SolarMonitorMapper solarMonitorMapper = sqlSession.getMapper( SolarMonitorMapper.class );
            List<SolarMonitor> monitorList = solarMonitorMapper.selectByExample( new SolarMonitorCondition() );
            
            if( monitorList != null && monitorList.size() > 0 )
            {
            	monitorMap = new HashMap<String, SolarMonitor>();
            	
            	for( SolarMonitor monitor : monitorList )
            	{
            		monitorMap.put(monitor.getAgentCode() + monitor.getMonitorCode(), monitor);
            	}
				MemCacheHelper.set( CacheEnum.MONITOR_ALL.getCode(), monitorMap, expireSecond );					
            }
            
        } catch (Exception e) {
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return monitorMap;
	}
	
	public static SolarMonitorService getInstance()
	{
		if (instance == null) {
			synchronized (SolarMonitorServiceImpl.class) {
                if (instance == null) {
                    instance = new SolarMonitorServiceImpl ();
                }
            }
		}
		
		return instance;
	}
}
