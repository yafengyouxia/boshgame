package com.zsyj.fee.service.impl;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.Constant;
import com.zsyj.fee.dao.StatStatusInfoMapper;
import com.zsyj.fee.entity.StatStatusInfoCondition;
import com.zsyj.fee.service.StatStatusInfoService;

/**
 * 短信通道配置smsconfigifo
 * 
 * @author hujian
 */
public class StatStatusInfoServiceImpl implements StatStatusInfoService {

	private static final Logger logger = LoggerFactory
			.getLogger(StatStatusInfoServiceImpl.class);
	private static StatStatusInfoService instance = new StatStatusInfoServiceImpl();

	@Override
	public String findLastStatTimeByType( String type ) {
		
		SqlSession sqlSession = null;
		String result = null;
		
        try {  
            sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();  
            
            StatStatusInfoMapper mapper = sqlSession.getMapper( StatStatusInfoMapper.class );
            StatStatusInfoCondition condtion = new StatStatusInfoCondition();
            condtion.createCriteria().andTypeEqualTo(type);
            
            Date collectTime = mapper.selectMaxTimeByExample( condtion );
            
            if( collectTime != null )
            {
            	result = Constant.sdf_yyyyMMddHHmmss.format( collectTime );
            }
            
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return result;
	}
	
	public static StatStatusInfoService getInstance() {
		return instance;
	}
}
