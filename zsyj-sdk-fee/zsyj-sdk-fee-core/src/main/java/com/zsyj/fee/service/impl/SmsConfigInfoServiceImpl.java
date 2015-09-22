package com.zsyj.fee.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.MemCacheHelper;
import com.zsyj.fee.common.enums.CacheEnum;
import com.zsyj.fee.dao.SmsconfigInfoMapper;
import com.zsyj.fee.entity.SmsconfigInfo;
import com.zsyj.fee.entity.SmsconfigInfoCondition;
import com.zsyj.fee.service.SmsConfigInfoService;

/**
 * 短信通道配置smsconfigifo
 * 
 * @author hujian
 */
public class SmsConfigInfoServiceImpl implements SmsConfigInfoService {

	private static final Logger logger = LoggerFactory
			.getLogger(SmsConfigInfoServiceImpl.class);
	private static SmsConfigInfoService instance = new SmsConfigInfoServiceImpl();

	/** 默认10分钟 */
	private static int expireSecond = 600*1000;
	
	@Override
	public List<SmsconfigInfo> getAllSmsConfigInfo() {
		String key = CacheEnum.SMS_CONFIGINFO.getCode();
		
		if( MemCacheHelper.get( key ) != null )
		{
			return (List<SmsconfigInfo>)MemCacheHelper.get( key );
		}
		else
		{
			return this.getTroneList( key );
		}
	}
	
	private List<SmsconfigInfo> getTroneList( String memkey ) {

		SqlSession sqlSession = null;
		List<SmsconfigInfo> troneList = null;
		
        try {  
            sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();  
            
            SmsconfigInfoMapper sdkTroneMapper = sqlSession.getMapper( SmsconfigInfoMapper.class );
            SmsconfigInfoCondition condtion = new SmsconfigInfoCondition();
            
            troneList = sdkTroneMapper.selectByExample( condtion );
            
            if( troneList != null && troneList.size() > 0 )
            {
				MemCacheHelper.set( memkey, troneList, expireSecond );					
            }
            
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
	public SmsconfigInfo findBySpNumAndMsgText(String spNum, String msgText ) {
		
		SmsconfigInfo result = null;
		List<SmsconfigInfo> allTroneConfig = this.getAllSmsConfigInfo( );
		if( allTroneConfig != null && allTroneConfig.size() > 0 )
		{
			//匹配合适的msgtext
			for( SmsconfigInfo troneConfigInfo : allTroneConfig )
			{
				if( troneConfigInfo != null  && troneConfigInfo.getTrone().equals( spNum )
						&& msgText.indexOf( troneConfigInfo.getCommand() ) > -1 )
				{
					if( result == null
							|| result.getCommand().length() < troneConfigInfo.getCommand().length() )		//最大匹配 )	//地区匹配
					{
						result = troneConfigInfo;	
					}
				}
			}
		}
		
		return result;
	}
	
	public static SmsConfigInfoService getInstance() {
		return instance;
	}
}
