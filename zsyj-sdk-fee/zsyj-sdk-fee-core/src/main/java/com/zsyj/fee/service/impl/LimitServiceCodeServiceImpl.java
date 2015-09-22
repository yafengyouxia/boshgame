package com.zsyj.fee.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.MemCacheHelper;
import com.zsyj.fee.common.enums.CacheEnum;
import com.zsyj.fee.dao.LimitServicecodeMapper;
import com.zsyj.fee.entity.LimitServicecode;
import com.zsyj.fee.entity.LimitServicecodeCondition;
import com.zsyj.fee.service.LimitServiceCodeService;

public class LimitServiceCodeServiceImpl implements LimitServiceCodeService
{
	private static final Logger logger = LoggerFactory.getLogger(LimitServiceCodeServiceImpl.class);
	private volatile static LimitServiceCodeService instance = null;
	
	//用户memcached缓存默认保存10天
	private static int expireSecond = 1000*300;
	
	@Override
	public LimitServicecode findByServiceCode(String serviceCode) {

		LimitServicecode servicecodeLimit = null;
		Map<String, LimitServicecode> serviceCodeMap = this.findAll();
		
		if( serviceCodeMap != null )
		{
			servicecodeLimit = serviceCodeMap.get(serviceCode);
		}
		
		return servicecodeLimit;
	}
	
	@Override
	public Map<String, LimitServicecode> findAll() {
		
		String key = CacheEnum.LIMIT_SERVICECODE_LIST.getCode();
		
		if( MemCacheHelper.get( key ) != null )
		{
			return (Map<String, LimitServicecode>)MemCacheHelper.get( key );
		}
		else
		{
			return this.findAll( key );
		}
	}
	
	/**
	 * @param mid
	 * @param imsi
	 * @param uuid
	 * @return
	 */
	private Map<String, LimitServicecode> findAll( String key )
	{
		SqlSession sqlSession = null;
		Map<String, LimitServicecode> limitServiceCodeMap =  null;
		
        try {  

        	sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
        	LimitServicecodeMapper limitServicecodeMapper = sqlSession.getMapper( LimitServicecodeMapper.class );
            List<LimitServicecode> limitServicecodeList = limitServicecodeMapper.selectByExample( new LimitServicecodeCondition() );
            
            if( limitServicecodeList != null && limitServicecodeList.size() > 0 )
            {
            	limitServiceCodeMap = new HashMap<String, LimitServicecode>();
            	
            	for( LimitServicecode servicecodeLimit : limitServicecodeList )
            	{
            		limitServiceCodeMap.put( servicecodeLimit.getServiceCode(), servicecodeLimit );
            	}
            	
				MemCacheHelper.set( key, limitServiceCodeMap, expireSecond );					
            }
            
        } catch (Exception e) {
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return limitServiceCodeMap;
	}
	
	public static LimitServiceCodeService getInstance()
	{
		if (instance == null) {
			synchronized (LimitServiceCodeServiceImpl.class) {
                if (instance == null) {
                    instance = new LimitServiceCodeServiceImpl ();
                }
            }
		}
		
		return instance;
	}
}