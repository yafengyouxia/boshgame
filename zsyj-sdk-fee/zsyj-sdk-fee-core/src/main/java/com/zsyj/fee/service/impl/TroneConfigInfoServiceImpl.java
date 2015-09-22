package com.zsyj.fee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.MemCacheHelper;
import com.zsyj.fee.common.enums.CacheEnum;
import com.zsyj.fee.dao.CfgSdkTroneMapper;
import com.zsyj.fee.entity.CfgSdkTrone;
import com.zsyj.fee.entity.CfgSdkTroneCondition;
import com.zsyj.fee.service.TroneConfigInfoService;
import com.zsyj.fee.vo.TroneConfigInfo;

/**
 * 短信通道配置smsconfigifo
 * 
 * @author hujian
 */
public class TroneConfigInfoServiceImpl implements TroneConfigInfoService {

	private static final Logger logger = LoggerFactory
			.getLogger(TroneConfigInfoServiceImpl.class);
	private static TroneConfigInfoService instance = new TroneConfigInfoServiceImpl();

	/** 默认3分钟 */
	private static int expireSecond = 180*1000;
	
	@Override
	public List<TroneConfigInfo> getFreshPvFreshList() {
		
		String key = CacheEnum.TRONE_FRESHPV.getCode() + "_1";
		
		if( MemCacheHelper.get( key ) != null )
		{
			return (List<TroneConfigInfo>)MemCacheHelper.get( key );
		}
		else
		{
			return this.getTroneList( null, 1, key );
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TroneConfigInfo> getTroneList( int status ) {
		
		String key = CacheEnum.TRONE_CONFIGINFO.getCode() + "_" + status;
		
		if( MemCacheHelper.get( key ) != null )
		{
			return (List<TroneConfigInfo>)MemCacheHelper.get( key );
		}
		else
		{
			return this.getTroneList( status, null, key );
		}
	}
	
	private List<TroneConfigInfo> getTroneList( Integer status, Integer freshPvStatus, String memkey ) {

		SqlSession sqlSession = null;
		List<TroneConfigInfo> troneList = null;
		
        try {  
            sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();  
            
            CfgSdkTroneMapper sdkTroneMapper = sqlSession.getMapper( CfgSdkTroneMapper.class );
            CfgSdkTroneCondition sdkTroneCondition = new CfgSdkTroneCondition();
            
            if( status != null && status >= 0 )
            {
            	sdkTroneCondition.createCriteria().andStatusEqualTo( status.byteValue() );            	
            }
            
            if( freshPvStatus != null && freshPvStatus == 1 )
            {
            	sdkTroneCondition.createCriteria().andIsFreshPvEqualTo( (byte)1 ).andFeeLessThan( 1D );
            }
            
            sdkTroneCondition.setOrderByClause( " fee desc, weight desc " );	//根据价格和权重排序
            
            List<CfgSdkTrone> cfgSdkTroneList = sdkTroneMapper.selectByExample( sdkTroneCondition );
            
            if( cfgSdkTroneList != null && cfgSdkTroneList.size() > 0 )
            {
            	troneList = new ArrayList<TroneConfigInfo>( );
            	
            	for( CfgSdkTrone trone : cfgSdkTroneList )
            	{
            		troneList.add( TroneConfigInfo.getInstance( trone )  );
            	}
            	
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
	public TroneConfigInfo findBySpNum( String spNum ) {
		
		List<TroneConfigInfo> allTroneConfig = this.getTroneList( -1 );
		if( allTroneConfig != null && allTroneConfig.size() > 0 )
		{
			for( TroneConfigInfo troneConfigInfo : allTroneConfig )
			{
				if( troneConfigInfo != null && spNum.equals( troneConfigInfo.getTrone() ) )
				{
					return troneConfigInfo;
				}
			}
		}
		
		return null;
	}
	
	@Override
	public TroneConfigInfo findBySpNumAndMsgText(String spNum, String msgText, String serviceCode, Double price ) {
		
		TroneConfigInfo result = null;
		List<TroneConfigInfo> allTroneConfig = this.getTroneList( -1 );
		if( allTroneConfig != null && allTroneConfig.size() > 0 )
		{
			//匹配合适的msgtext
			for( TroneConfigInfo troneConfigInfo : allTroneConfig )
			{
				if( troneConfigInfo == null )
				{
					continue;
				}
				
				if( price != null && price > 0 && price.compareTo( troneConfigInfo.getFee() ) != 0 )
				{
					continue;
				}
				
				if( ( troneConfigInfo.getTrone().equals( spNum ) && troneConfigInfo.getCommand().indexOf( msgText ) > -1 )
						|| ( troneConfigInfo.getCommand().indexOf( spNum ) > -1 && troneConfigInfo.getCommand().indexOf( msgText ) > -1 )
				)
				{
					if( result == null
							|| result.getCommand().length() < troneConfigInfo.getCommand().length() )		//最大匹配 )	//地区匹配
					{
						result = troneConfigInfo;
					}
				}
				
				if( troneConfigInfo.getServiceCode().equals( serviceCode ) )
				{
					result = troneConfigInfo;
				}
			}
		}
		
		return result;
	}
	
	public static TroneConfigInfoService getInstance() {
		return instance;
	}
}
