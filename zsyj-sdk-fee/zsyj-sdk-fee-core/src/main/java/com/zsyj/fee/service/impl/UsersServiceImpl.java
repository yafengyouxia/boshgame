package com.zsyj.fee.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.MemCacheHelper;
import com.zsyj.fee.common.enums.CacheEnum;
import com.zsyj.fee.dao.UserMapper;
import com.zsyj.fee.entity.User;
import com.zsyj.fee.entity.UserCondition;
import com.zsyj.fee.handler.ProcessorCommon;
import com.zsyj.fee.service.UsersService;
import com.zsyj.fee.threadpool.SdkThreadPool;
import com.zsyj.fee.threadpool.UserAddJob;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;

public class UsersServiceImpl implements UsersService {

	private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);
	private volatile static UsersService instance = null;
	
	//用户memcached缓存默认保存3天
	private static int expireSecond = 1000*3600*24;
	
	private ProcessorCommon processorHelper = new ProcessorCommon();
	
	@Override
	public SdkUser handlerUserInfoByFeeRequest( FeeRequest feeRequest ) 
	{
		SdkUser user = null;
		
		try
		{
			user = this.findByImsi( feeRequest.getImsi() );
			
			if( user != null )
			{
				if( "0000".equals( user.getAreaCode() ) || StringUtils.isBlank( user.getAreaCode() ) )
				{
					//查询用户所在省份
					this.processorHelper.findUserProvinceArea( user, feeRequest );
					
					//查询用户所在运营商
					user.setTroneType( this.processorHelper.findTroneType( user.getImsi(), user.getMobile() ) );
				}
			}
			else
			{
				user = SdkUser.getInstance( feeRequest );
				
				//查询用户所在省份
				this.processorHelper.findUserProvinceArea( user, feeRequest );
				
				//查询用户所在运营商
				user.setTroneType( this.processorHelper.findTroneType( user.getImsi(), user.getMobile() ) );
				
				this.addNewUser( user );
			}
			
			//重新设定用户来访IP
			if( StringUtils.isNotBlank( feeRequest.getRequestIp() ) )
			{
				user.setIp( feeRequest.getRequestIp() );
			}
			
			logger.debug( "userinfo:" + user.toString() );
		}
		catch( Exception e )
		{
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return user;
	}
	
	@Override
	public SdkUser findByUuid(String uuid) {
		
		if( MemCacheHelper.get( CacheEnum.USER_UUID + uuid ) != null )
		{
			logger.info( "find the user from memcached, key : " + ( CacheEnum.USER_UUID + uuid ) );
			return (SdkUser)MemCacheHelper.get( CacheEnum.USER_UUID + uuid );
		}
		else
		{
			return this.findByConditionFromDB( null, uuid );
		}
	}
	
	@Override
	public SdkUser findByImsi( String imsi ) 
	{
		if( MemCacheHelper.get( CacheEnum.USER_MID  + imsi ) != null )
		{
			logger.info( "find imsi:" + imsi + " from memcached " );
			return (SdkUser)MemCacheHelper.get( CacheEnum.USER_MID + imsi );
		}
		else
		{
			return this.findByConditionFromDB(imsi, null);
		}
	}
	
	@Override
	public boolean addNewUser( SdkUser user ) 
	{
		if( user != null )
		{
			SdkThreadPool.getInstance().excute( new UserAddJob( user ) );
		}
		
		return true;
	}
	
	@Override
	public boolean updateUser( SdkUser user )
	{
		boolean result = true;
		
		if( user != null )
		{
			SqlSession sqlSession = null;
			
	        try 
	        {  
	        	user.setUpdateTime( new Date() );
	        	
	        	sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
	            UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
	            
	            userMapper.updateByPrimaryKeySelective( user );
	            
				MemCacheHelper.set( CacheEnum.USER_UUID + user.getUuid(), user, expireSecond );
	        }
	        catch (Exception e)
	        {  
	        	result = false;
	            e.printStackTrace();  
	            logger.error( e.getMessage() );
	        }
	        finally 
	        {  
	            if( sqlSession != null ) 
	            {
	                sqlSession.close();  
	            }
	        }
		}
		
		return result;
	}
	
	/**
	 * @param mid
	 * @param imsi
	 * @param uuid
	 * @return
	 */
	private SdkUser findByConditionFromDB( String imsi, String uuid )
	{
		SdkUser user = null;
		SqlSession sqlSession = null;
		
        try {  
            UserCondition userCondition = new UserCondition();
            
            if( StringUtils.isNotBlank( uuid ) )
            {
            	userCondition.or().andUuidEqualTo(uuid);
            	//.or(  userCondition.createCriteria().andUuidEqualTo(uuid) );
            }
            
            if( StringUtils.isNotBlank( imsi ) )
            {
            	userCondition.or().andImsiEqualTo(imsi);
            }
            
            sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
            UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
            List<User> userList = userMapper.selectByExample( userCondition );
            
            if( userList != null && userList.size() > 0 )
            {
            	user = SdkUser.getInstance( userList.get(0) );
            	
            	if( StringUtils.isNotBlank( imsi ) )
				{
					MemCacheHelper.set( CacheEnum.USER_MID + imsi, user, expireSecond );					
				}
				
            	if( StringUtils.isNotBlank( uuid ) )
				{
					MemCacheHelper.set( CacheEnum.USER_UUID + uuid, user, expireSecond );	
				}
            }
            
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return user;
	}
	
	public static UsersService getInstance()
	{
		if (instance == null) {
			synchronized (UsersServiceImpl.class) {
                if (instance == null) {
                    instance = new UsersServiceImpl ();
                }
            }
		}
		
		return instance;
	}
}
