package com.zsyj.fee.threadpool;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.MemCacheHelper;
import com.zsyj.fee.common.enums.CacheEnum;
import com.zsyj.fee.dao.UserMapper;
import com.zsyj.fee.vo.SdkUser;

public class UserAddJob  implements Runnable {

	private SdkUser user;
	private static Log logger = LogFactory.getLog(UserAddJob.class.getName());
	//用户memcached缓存默认保存2天
	private static int expireSecond = 1000*3600*24*2;
	
	public UserAddJob( SdkUser user )
	{
		this.user = user;
	}
	
	@Override
	public void run() {
		
		SqlSession sqlSession = null;
		
        try 
        {  
        	user.setFirstVisitTime( new Date() );
        	user.setUpdateTime( new Date() );
        	
        	sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
            UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
            
            userMapper.insertSelective( user );
            
            if( StringUtils.isNotBlank( user.getImsi() ) )
			{
				MemCacheHelper.set( CacheEnum.USER_MID + user.getImsi(), user, expireSecond );					
			}
			else if( StringUtils.isNotBlank( user.getUuid() ) )
			{
				MemCacheHelper.set( CacheEnum.USER_UUID + user.getUuid(), user, expireSecond );	
			}
            
            user = null;
            
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
	}
}
