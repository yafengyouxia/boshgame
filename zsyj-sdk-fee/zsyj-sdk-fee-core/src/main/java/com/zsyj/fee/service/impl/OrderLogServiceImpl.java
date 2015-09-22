package com.zsyj.fee.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.Constant;
import com.zsyj.fee.dao.SdkOrderLogMapper;
import com.zsyj.fee.entity.SdkOrderLog;
import com.zsyj.fee.entity.SdkOrderLogCondition;
import com.zsyj.fee.service.CommonService;
import com.zsyj.fee.service.OrderLogService;
import com.zsyj.fee.vo.OrderLog;
import com.zsyj.fee.vo.SpData;
import com.zsyj.fee.vo.UserCash;

public class OrderLogServiceImpl implements OrderLogService {

	private static final Logger logger = LoggerFactory.getLogger(OrderLogServiceImpl.class);
	
	private volatile static OrderLogService instance = null;
	
	//用户memcached缓存默认保存10天
	//private static int expireSecond = 1000*3600*6;
	
	private String tableNamePrefix = "sdk_order_log";
	
	private CommonService commonService = CommonServiceImpl.getInstance();
	
	private void checkTableExist( String tableName )
	{
		SqlSession sqlSession = null;
		
		if( !commonService.findTableByName(tableName) )
		{
			logger.info( "table["+ tableName +"] not exist" );
			
			try 
	        {  
				sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
				
				SdkOrderLogMapper orderLogMapper = sqlSession.getMapper( SdkOrderLogMapper.class );
	            
				orderLogMapper.createNewTable(tableName);
	        }
			catch (Exception e)
			{  
	            e.printStackTrace();  
	            logger.error( e.getMessage() );
	        }
			finally {  
	            if(sqlSession != null)
	            {  
	                sqlSession.close();  
	            }  
	        }
		}
	}
	
	@Override
	public boolean insertOrderLog( SdkOrderLog orderLog ) {
		
		SqlSession sqlSession = null;
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( Calendar.getInstance().getTime() );
		
		checkTableExist( tableName );
		
		try
        {
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SdkOrderLogMapper orderLogMapper = sqlSession.getMapper( SdkOrderLogMapper.class );
			
			orderLogMapper.insert( orderLog );
			
			sqlSession.commit();
        }
		catch ( Exception e )
		{  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        }
		finally
		{  
            if(sqlSession != null)
            {  
                sqlSession.close();
            }  
        }
		
		return false;
	}
	
	@Override
	public OrderLog findByOrderId(String orderId) {
		
		OrderLog orderLog = null;
		SqlSession sqlSession = null;
		
		if( StringUtils.isBlank( orderId ) )
		{
			return orderLog;
		}
		
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( Calendar.getInstance().getTime() );
		
		checkTableExist( tableName );
		
		try
        {  
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SdkOrderLogMapper orderLogMapper = sqlSession.getMapper( SdkOrderLogMapper.class );
			
			SdkOrderLogCondition condition = new SdkOrderLogCondition();
			condition.setTableName( tableName );
			condition.createCriteria().andOrderIdEqualTo( orderId );
			
			List<SdkOrderLog> cfgOrderList = orderLogMapper.selectByExample(condition);
			if( cfgOrderList != null && cfgOrderList.size() > 0 )
			{
				orderLog = OrderLog.getInstance( cfgOrderList.get(0) );
			}
        }
		catch ( Exception e )
		{  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        }
		finally
		{  
            if(sqlSession != null)
            {  
                sqlSession.close();
            }  
        }
		
		return orderLog;
	}

	@Override
	public void update(OrderLog orderLog) {
		
		SqlSession sqlSession = null;
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( Calendar.getInstance().getTime() );
		
		try
        {
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SdkOrderLogMapper orderLogMapper = sqlSession.getMapper( SdkOrderLogMapper.class );
			
			orderLog.setTableName( tableName );
			
			orderLogMapper.updateByPrimaryKeySelective( orderLog, tableName );
			
			sqlSession.commit();
        }
		catch ( Exception e )
		{  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        }
		finally
		{  
            if(sqlSession != null)
            {  
                sqlSession.close();
            }  
        }
	}
	
	@Override
	public List<SpData> findSpData( Date startTime ) {
		
		SqlSession sqlSession = null;
		List<SpData> resultList = null;
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( startTime );
		
		try
        {
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SdkOrderLogMapper orderLogMapper = sqlSession.getMapper( SdkOrderLogMapper.class );
			
			SdkOrderLogCondition condition = new SdkOrderLogCondition();
			condition.setTableName( tableName );
			condition.createCriteria().andLogtimeGreaterThan(startTime);
			
			resultList = orderLogMapper.selectSpData( condition );
        }
		catch ( Exception e )
		{  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        }
		finally
		{  
            if(sqlSession != null)
            {  
                sqlSession.close();
            }  
        }
		
		return resultList;
	}
	
	@Override
	public List<OrderLog> findMonthLogListByImsi(String imsi) {
		
		List<OrderLog> orderList = null;
		SqlSession sqlSession = null;
		
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( Calendar.getInstance().getTime() );
		
		checkTableExist( tableName );
		
		try
        {  
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SdkOrderLogMapper orderLogMapper = sqlSession.getMapper( SdkOrderLogMapper.class );
			
			SdkOrderLogCondition condition = new SdkOrderLogCondition();
			condition.setTableName( tableName );
			condition.createCriteria().andImsiEqualTo(imsi);
			
			List<SdkOrderLog> cfgOrderList = orderLogMapper.selectByExample(condition);
			if( cfgOrderList != null && cfgOrderList.size() > 0 )
			{
				orderList = new ArrayList<OrderLog>();
				
				for( SdkOrderLog sdkOrder : cfgOrderList )
				{
					orderList.add( OrderLog.getInstance( sdkOrder ) );
				}
			}
        }
		catch ( Exception e )
		{  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        }
		finally
		{  
            if(sqlSession != null)
            {  
                sqlSession.close();
            }  
        }
		
		return orderList;
	}
	
	@Override
	public void updateStatusByOrderId(String orderId, int status) {
		
		SqlSession sqlSession = null;
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( Calendar.getInstance().getTime() );
		
		try
        {
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SdkOrderLogMapper orderLogMapper = sqlSession.getMapper( SdkOrderLogMapper.class );
			
			SdkOrderLogCondition condition = new SdkOrderLogCondition();
			condition.setTableName( tableName );
			condition.createCriteria().andOrderIdEqualTo(orderId);
			
			SdkOrderLog sdkOrderLog = new SdkOrderLog();
			sdkOrderLog.setStatus(status);
			
			orderLogMapper.updateByExampleSelective(sdkOrderLog, condition, tableName);
			
			sqlSession.commit();
        }
		catch ( Exception e )
		{  
            e.printStackTrace();  
            logger.error( e.getMessage() );
        }
		finally
		{  
            if(sqlSession != null)
            {  
                sqlSession.close();
            }  
        }
	}
	
	@Override
	public UserCash staticsUserCash( String imsi )
	{
		UserCash userCash = new UserCash();
		List<OrderLog> orderList = this.findMonthLogListByImsi( imsi );
		 
		if( orderList != null && orderList.size() > 0 )
		{
			for( OrderLog orderLog : orderList ) 
			{
				if( orderLog.getStatus() <= 0 )
				{
					//发送结果未知或者失败不纳入分配统计中
					continue;
				}
				
				//记录最后一次订购的时间
				if( userCash.getLastPayTime() == null || orderLog.getLogtime().compareTo( userCash.getLastPayTime() ) > 0 )
				{
					userCash.setLastPayTime( orderLog.getLogtime() );
				}
				
				if( userCash.getCurrentMonthMoidmapLog().get( orderLog.getServicecode() ) == null )
				{
					userCash.getCurrentMonthMoidmapLog().put( orderLog.getServicecode() , 0 );
				}
				
				if( userCash.getCurrentTodayMoidmapLog().get( orderLog.getServicecode() ) == null )
				{
					userCash.getCurrentTodayMoidmapLog().put( orderLog.getServicecode() , 0 );
				}
				
				double moidFeeCount =  orderLog.getFeeTimes( )*orderLog.getPrice( );
				
				userCash.setSumMoidMonthFee( userCash.getSumMoidMonthFee() + moidFeeCount );
				
				userCash.getCurrentMonthMoidmapLog().put( orderLog.getServicecode(), 
						userCash.getCurrentMonthMoidmapLog().get( orderLog.getServicecode() ) + 1 );	
				
				Calendar orderLogTime = Calendar.getInstance();
				orderLogTime.setTime( orderLog.getLogtime() );
				
				if( orderLogTime.get(Calendar.DAY_OF_YEAR) == Calendar.getInstance().get(Calendar.DAY_OF_YEAR) )
				{
					userCash.setSumMoidTodayFee( userCash.getSumMoidTodayFee() + moidFeeCount );
					
					userCash.getCurrentTodayMoidmapLog().put( orderLog.getServicecode(),
							userCash.getCurrentTodayMoidmapLog().get( orderLog.getServicecode() ) + 1 );
				}
			}
			
			logger.debug( "userCash:" + userCash.toString() );
		}
		
		return userCash;
	}
	
	public static OrderLogService getInstance()
	{
		if (instance == null) {
			synchronized (OrderLogServiceImpl.class) {
                if (instance == null) {
                    instance = new OrderLogServiceImpl ();
                }
            }
		}
		return instance;
	}
}
