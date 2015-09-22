package com.zsyj.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.dao.SdkOrderLogMapper;
import com.zsyj.fee.entity.SdkOrderLog;
import com.zsyj.fee.entity.SdkOrderLogCondition;

public class CfgOrderLogDao {

	private  SqlSession sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
	
	@Test
	public void createTable()
	{
		try {  
            SdkOrderLogMapper orderLogMapper = sqlSession.getMapper( SdkOrderLogMapper.class );

            String tableName = "sdk_order_log201503";

            orderLogMapper.createNewTable(tableName);
            
		} catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        } 
	}
	
	@Test
	public void update()
	{
		 try {  
	            SdkOrderLogMapper orderLogMapper = sqlSession.getMapper( SdkOrderLogMapper.class );

	            String orderId = "asdjflfl2341324";
	            
	            String tableName = "sdk_order_log201504";
	            
	            SdkOrderLogCondition condition = new SdkOrderLogCondition();
	            condition.setTableName(tableName);
	            condition.createCriteria().andOrderIdEqualTo( orderId );
	            
	            List<SdkOrderLog> orderList = orderLogMapper.selectByExample( condition );
	            
	            if( orderList.size( ) > 0 )
	            {
	            	SdkOrderLog sdkOrder = orderList.get(0);
	            	System.out.println( "status:" + sdkOrder.getStatus() );
	            	
	            	sdkOrder.setStatus( 2 );
	            	sdkOrder.setTableName(tableName);
	            	orderLogMapper.updateByPrimaryKeySelective(sdkOrder, tableName);
	            }
	            
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            if(sqlSession != null) {  
	                sqlSession.close();  
	            }  
	        } 
	}
	
	@Test
	public void insert()
	{
        try {  
            SdkOrderLogMapper orderLogMapper = sqlSession.getMapper( SdkOrderLogMapper.class );

            String tableName = "sdk_order_log201504";
            SdkOrderLog sdkOrderLog = new SdkOrderLog();
            sdkOrderLog.setAppid( "10001" );
            sdkOrderLog.setAreaCode( "0000" );
            sdkOrderLog.setCid( "101" );
            sdkOrderLog.setContent( "content" );
            sdkOrderLog.setCpId( 1001 );
            sdkOrderLog.setFeeTimes( 1 );
            sdkOrderLog.setImsi( "460123218978" );
            sdkOrderLog.setLogtime( new Date() );
            sdkOrderLog.setMobile( "15899786666" );
            sdkOrderLog.setOperatorType( (byte)0 );
            sdkOrderLog.setOrderId( "asdjflfl2341324" );
            sdkOrderLog.setPrice( 2.0 );
            sdkOrderLog.setSaleId( 1023 );
            sdkOrderLog.setServicecode( "servicecode" );
            sdkOrderLog.setSid( "201" );
            sdkOrderLog.setSpid( 1001 );
            sdkOrderLog.setStatus( 0 );
            sdkOrderLog.setTableName( tableName );
            sdkOrderLog.setUuid( "asdjflfl2341324" );
            int result = orderLogMapper.insert( sdkOrderLog );
            
            System.out.println( "result:" + result );
            
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        } 
	}
	
	@Test
	public void find()
	{
        try {  
            SdkOrderLogMapper orderLogMapper = sqlSession.getMapper( SdkOrderLogMapper.class );

            String tableName = "sdk_order_log201504";
            SdkOrderLogCondition sdkOrderLogCondition = new SdkOrderLogCondition();
            sdkOrderLogCondition.setTableName(tableName);
            
            List<SdkOrderLog> orderList = orderLogMapper.selectByExample( sdkOrderLogCondition );
            
            if( orderList != null && orderList.size() > 0 )
            {
            	for( SdkOrderLog order : orderList )
            	{
            		System.out.println( order.toString() );
            	}
            }
            
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if(sqlSession != null) {  
                sqlSession.close();  
            }  
        } 
	}
}
