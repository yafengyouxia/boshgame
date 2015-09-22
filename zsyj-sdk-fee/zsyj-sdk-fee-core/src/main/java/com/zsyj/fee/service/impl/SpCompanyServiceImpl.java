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
import com.zsyj.fee.dao.CfgSpCompanyMapper;
import com.zsyj.fee.entity.CfgSpCompany;
import com.zsyj.fee.entity.CfgSpCompanyCondition;
import com.zsyj.fee.service.SpCompanyService;

/**
 * 短信通道配置smsconfigifo
 * 
 * @author hujian
 */
public class SpCompanyServiceImpl implements SpCompanyService {
	private static final Logger logger = LoggerFactory
			.getLogger(SpCompanyServiceImpl.class);
	private static SpCompanyService instance = new SpCompanyServiceImpl();

	/** 默认10分钟 */
	private static int expireSecond = 600*1000;
	
	@Override
	public Map<Integer, CfgSpCompany> findAll(  ) {
		
		String key = CacheEnum.TRONE_SPCOMPANY.getCode();
		
		if( MemCacheHelper.get( key ) != null )
		{
			return (Map<Integer, CfgSpCompany>)MemCacheHelper.get( key );
		}
		else
		{
			return this.getAllSp( key );
		}
	}

	@Override
	public CfgSpCompany findBySpid(int spId) {
		return this.findAll( ).get(spId);
	}
	
	private Map<Integer, CfgSpCompany> getAllSp( String memkey ) {

		SqlSession sqlSession = null;
		Map<Integer, CfgSpCompany> spMap = new HashMap<Integer, CfgSpCompany>();
		
        try {  
            sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();  
            
            CfgSpCompanyMapper spCompanyMapper = sqlSession.getMapper( CfgSpCompanyMapper.class );
            
            List<CfgSpCompany> spList = spCompanyMapper.selectByExample( new CfgSpCompanyCondition() );
            
            if( spList != null && spList.size() > 0 )
            {
            	for( CfgSpCompany spCompany : spList )
            	{
            		spMap.put(spCompany.getSpSid(), spCompany);
            	}
            	
				MemCacheHelper.set( memkey, spMap, expireSecond );					
            }
            
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return spMap;
	}
	
	public static SpCompanyService getInstance() {
		return instance;
	}
}
