package com.zsyj.fee.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.MemCacheHelper;
import com.zsyj.fee.common.enums.CacheEnum;
import com.zsyj.fee.dao.CfgAreaMapper;
import com.zsyj.fee.dao.CfgSmscenterMapper;
import com.zsyj.fee.dao.IpInfosMapper;
import com.zsyj.fee.dao.MobileareaMapper;
import com.zsyj.fee.entity.CfgArea;
import com.zsyj.fee.entity.CfgAreaCondition;
import com.zsyj.fee.entity.CfgSmscenter;
import com.zsyj.fee.entity.CfgSmscenterCondition;
import com.zsyj.fee.entity.IpInfos;
import com.zsyj.fee.entity.IpInfosCondition;
import com.zsyj.fee.entity.Mobilearea;
import com.zsyj.fee.entity.MobileareaCondition;
import com.zsyj.fee.service.AreaService;
import com.zsyj.fee.vo.AreaInfo;

public class AreaServiceImpl implements AreaService {

	private static final Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);
	private static AreaService instance = new AreaServiceImpl();
	
	/** 默认一年 */
	private static int expireSecond = 1000*3600*24*360;
	
	private static List<CfgArea> CfgAreaList = null;
	
	@Override
	public AreaInfo findByIp(String ip) {

		String subIp = this.getSubIp(ip);
		
		if( subIp == null || "".equals( subIp ) )
		{
			logger.warn( "inValid ip:" + ip );
		}
		
		String key = CacheEnum.CFG_AREA_IPINFO + "_" + subIp;
		
		if( MemCacheHelper.get( key ) != null )
		{
			logger.info( "find ip " + ip + " from memcached" );
			return (AreaInfo)MemCacheHelper.get(key);
		}
		else
		{
			return findByIpFromDB( subIp, key );
		}
	}

	@Override
	public String findRelativeAreaCode(String areaCode) {
		
		String relativeCodeListStr = "";
		
		List<CfgArea> areaList = this.findAllCfgArea();
		
		for( CfgArea area : areaList )
		{
			if( areaCode.indexOf( area.getCode() ) < 0 )
			{
				relativeCodeListStr += area.getCode() + ",";
			}
		}
		
		return relativeCodeListStr;
	}
	
	@Override
	public List<CfgArea> findAllCfgArea() {
		
		if( CfgAreaList == null )
		{
			SqlSession sqlSession = null;
			
			try
			{
				sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
				CfgAreaMapper areaMapper = sqlSession.getMapper( CfgAreaMapper.class );
				CfgAreaCondition areaCondition = new CfgAreaCondition();;
				areaCondition.setOrderByClause( " pinyin " );
				
				CfgAreaList = areaMapper.selectByExample( areaCondition );

	        } catch (Exception e) {  
	            e.printStackTrace();  
	            logger.error( e.getMessage() );
	        } finally {  
	            if(sqlSession != null) {  
	                sqlSession.close();  
	            }  
	        }
		}
		
		return CfgAreaList;
	}
	
	@Override
	public AreaInfo findByMobile(String mobile) {
		
		if( mobile == null || mobile.length() <= 7 ) 
		{
			logger.error( "invalid mobile : " + mobile );
			return null;
		}
		
		String subMobile = mobile.substring(0, 7);
		
		String key = CacheEnum.CFG_AREA_SUBMOBILE + "_" + subMobile;
		
		if( MemCacheHelper.get( key ) != null )
		{
			logger.info( "find mobile " + mobile + " from memcached" );
			return (AreaInfo)MemCacheHelper.get(key);
		}
		else
		{
			return findBySumMobileFromDB( subMobile, key );
		}
	}
	
	@Override
	public AreaInfo findBySmsCenter(String smsCenter) {

		String key = CacheEnum.CFG_SMSCENTER + "_" + smsCenter;
		
		if( MemCacheHelper.get( key ) != null )
		{
			logger.info( "find smsCenter " + smsCenter + " from memcached" );
			return (AreaInfo)MemCacheHelper.get(key);
		}
		else
		{
			return findSmscenter( smsCenter, key );
		}
	}

	private AreaInfo findBySumMobileFromDB( String subMobile, String memKey )
	{
		AreaInfo areaInfo = null;
		SqlSession sqlSession = null;
		
		try {  
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
            MobileareaMapper mobileareaMapper = sqlSession.getMapper( MobileareaMapper.class );
            MobileareaCondition mobileareaCondition = new MobileareaCondition();
            mobileareaCondition.createCriteria().andSubmobilenumberEqualTo( Integer.valueOf( subMobile ) );
            
            List<Mobilearea> mobileList = mobileareaMapper.selectByExample( mobileareaCondition );

            if( mobileList != null && mobileList.size() > 0 )
            {
            	areaInfo = new AreaInfo();
            	Mobilearea mobilearea = mobileList.get(0);
            	
            	areaInfo.setProvinceCode( mobilearea.getProvincecode() );
            	areaInfo.setTelCode( mobilearea.getAreacode() );
            	areaInfo.setTroneType( mobilearea.getTronetype() );
            	
            	MemCacheHelper.set( memKey, areaInfo, expireSecond );
            }
            
            mobileList = null;
            
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		
		return areaInfo;
	}
	
	private AreaInfo findByIpFromDB(String subIp, String memKey) {
		
		AreaInfo areaInfo = null;
		SqlSession sqlSession = null;
		
		try
		{  
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			IpInfosMapper ipInfosMapper = sqlSession.getMapper( IpInfosMapper.class );
			IpInfosCondition ipInfosCondition = new IpInfosCondition();
			ipInfosCondition.createCriteria().andIpEqualTo(subIp);
            
	        List<IpInfos> ipInfoList = ipInfosMapper.selectByExample( ipInfosCondition );

            if( ipInfoList != null && ipInfoList.size() > 0 )
            {
            	areaInfo = new AreaInfo();
            	IpInfos ipInfo = ipInfoList.get(0);
            	
            	areaInfo.setProvinceCode( ipInfo.getAreacode() );
            	areaInfo.setTelCode( ipInfo.getTelcode() );
            	areaInfo.setTroneType( ipInfo.getTronetype() );
            	
            	MemCacheHelper.set( memKey, areaInfo, expireSecond );
            }
            
            ipInfoList = null;
            
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
		return areaInfo;		
	}
	
	private AreaInfo findSmscenter( String smscenterStr, String memKey )
	{
		AreaInfo areaInfo = null;
		SqlSession sqlSession = null;
		
		try
		{
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			CfgSmscenterMapper smscenterMapper = sqlSession.getMapper( CfgSmscenterMapper.class );
			
			CfgSmscenterCondition smscenterCondition = new CfgSmscenterCondition( );
			smscenterCondition.createCriteria().andSmsCodeEqualTo(smscenterStr);
			
	        List<CfgSmscenter> smscenterList = smscenterMapper.selectByExample( new CfgSmscenterCondition() );
	        
	        if( smscenterList != null && smscenterList.size() > 0 )
	        {
	        	areaInfo = new AreaInfo();
	        	CfgSmscenter smscenter = smscenterList.get(0);
	        	
	        	areaInfo.setProvinceCode( smscenter.getAreaCode() );
            	areaInfo.setTelCode( smscenter.getTelId() );
            	areaInfo.setTroneType( smscenter.getType() );
            	
	        	MemCacheHelper.set( memKey, areaInfo, expireSecond );
	        }
	        
	        smscenterList = null;
	        
		} catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
        
        return areaInfo;
	}
	
	private String getSubIp(String fullIp) {
		String result = "";
		String[] arrayIp = fullIp.split("\\.");
		if (arrayIp.length == 4) {
			result = arrayIp[0] + "." + arrayIp[1] + "." + arrayIp[2];
		}
		logger.debug(fullIp + " " + arrayIp.length + " " + result);
		return result;
	}
	
	public static AreaService getInstance()
	{
		return instance;
	}

	@Override
	public void initCache() {
		
		SqlSession sqlSession = null;
		
        try {
        	
        	sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
        	
        	initMobileCache( sqlSession );
        	
        	initIpCache( sqlSession );
        	
        	initSmscenterCache( sqlSession );
        	
        } catch (Exception e) {  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        }
	}
	
	private void initMobileCache( SqlSession sqlSession )
	{
        MobileareaMapper mobileareaMapper = sqlSession.getMapper( MobileareaMapper.class );
        List<Mobilearea> mobileList = mobileareaMapper.selectByExample( new MobileareaCondition() );
        
        logger.info( "mobilearea total size:" + mobileList.size() );
        
        for( Mobilearea mobileArea : mobileList )
        {
        	MemCacheHelper.set( CacheEnum.CFG_AREA_SUBMOBILE + "_" + mobileArea.getSubmobilenumber(),
        			new AreaInfo( mobileArea ), expireSecond );
        }
        
        mobileList = null;
	}
	
	private void initIpCache( SqlSession sqlSession )
	{
		IpInfosMapper ipInfosMapper = sqlSession.getMapper( IpInfosMapper.class );
        List<IpInfos> ipInfoList = ipInfosMapper.selectByExample( new IpInfosCondition() );
        
        logger.info( "ipInfoList:" + ipInfoList.size() );
        
        for( IpInfos ipInfo : ipInfoList )
        {
        	String key = CacheEnum.CFG_AREA_IPINFO + "_" + ipInfo.getIp();
        	MemCacheHelper.set( key, new AreaInfo( ipInfo ), expireSecond );
        }
        
        ipInfoList = null;
	}
	
	private void initSmscenterCache( SqlSession sqlSession )
	{
		CfgSmscenterMapper smscenterMapper = sqlSession.getMapper( CfgSmscenterMapper.class );
        List<CfgSmscenter> smscenterList = smscenterMapper.selectByExample( new CfgSmscenterCondition() );
        
        logger.info( "smscenterList:" + smscenterList.size() );
        
        for( CfgSmscenter smscenter : smscenterList )
        {
        	String key = CacheEnum.CFG_SMSCENTER + "_" + smscenter.getSmsCode();
        	MemCacheHelper.set( key, new AreaInfo( smscenter ), expireSecond );
        }
        
        smscenterList = null;
	}
}
