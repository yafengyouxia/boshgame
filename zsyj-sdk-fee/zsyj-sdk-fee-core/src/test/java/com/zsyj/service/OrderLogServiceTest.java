package com.zsyj.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.DateUtil;
import com.zsyj.fee.dao.SolarChargeMapper;
import com.zsyj.fee.entity.SolarCharge;
import com.zsyj.fee.entity.SolarChargeCondition;
import com.zsyj.fee.syn.SmsChargeJob;

public class OrderLogServiceTest {

	@Test
	public void test()
	{
		List<SolarCharge> solarChargeList = this.findSolarCharge();
		
		System.out.println( solarChargeList.size() );
		
		insertSdkSynurlLog( solarChargeList );
		
		try {
			Thread.sleep( 10000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private boolean insertSdkSynurlLog( List<SolarCharge> solarChargeList )
	{
		if( solarChargeList != null )
		{
			for( SolarCharge solarCharge : solarChargeList )
			{
				solarCharge.setUserSid( "2002" );
				solarCharge.setUserCid( "101605" );
				solarCharge.setImsi( "460001228030708" );
				solarCharge.setCpId( 1 );
				solarCharge.setAppId( "10001" );
				
				
				new SmsChargeJob( solarCharge ).addSynUrlLog(solarCharge);
			}
		}
		
		return false;
	}
	
	private List<SolarCharge> findSolarCharge()
	{
		SqlSession sqlSession = null;
		List<SolarCharge> solarChargeList = null;
		
		try
        {  
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SolarChargeMapper solarChargeMapper = sqlSession.getMapper( SolarChargeMapper.class );
			
			SolarChargeCondition condition = new SolarChargeCondition();
			condition.setTableName( "solar_charge201509" );
			condition.createCriteria().andUserSidEqualTo( "5492244" ).andDisconnectTimeGreaterThan( DateUtil.formatDateByYYYYMMDDMMHHSS( "2015-09-21 11:00:00" ).getTime() );
			
			solarChargeList = solarChargeMapper.selectByExample(condition);
        }
		catch ( Exception e )
		{  
            e.printStackTrace();  
        }
		finally
		{  
            if(sqlSession != null)
            {  
                sqlSession.close();
            }  
        }
		
		return solarChargeList;
	}
}
