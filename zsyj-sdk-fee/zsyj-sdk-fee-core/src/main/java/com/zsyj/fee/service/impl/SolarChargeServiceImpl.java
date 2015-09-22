package com.zsyj.fee.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.Constant;
import com.zsyj.fee.dao.SolarChargeMapper;
import com.zsyj.fee.entity.SolarCharge;
import com.zsyj.fee.entity.SolarChargeCondition;
import com.zsyj.fee.service.CommonService;
import com.zsyj.fee.service.SolarChargeService;
import com.zsyj.fee.vo.SpData;

public class SolarChargeServiceImpl implements SolarChargeService {

	private static final Logger logger = LoggerFactory.getLogger(SolarChargeServiceImpl.class);
	private static SolarChargeService instance = new SolarChargeServiceImpl();
	
	//private static int expireSecond = 1000*3600*12;
	
	private String tableNamePrefix = "solar_charge";
	
	private CommonService commonService = CommonServiceImpl.getInstance();
	
	@Override
	public boolean updateStatusByLinkId( String linkId, String status ) {
		
		boolean result = true;
		SqlSession sqlSession = null;
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( new Date() );
		
		try
        {
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			SolarChargeMapper solarChargeMapper = sqlSession.getMapper( SolarChargeMapper.class );
			
			SolarChargeCondition condition = new SolarChargeCondition();
			condition.setTableName( tableName );
			condition.createCriteria().andLinkIdEqualTo(linkId);
			
			SolarCharge solarCharge = new SolarCharge();
			solarCharge.setStatus(status);
			solarCharge.setTableName(tableName);
			
			solarChargeMapper.updateByExampleSelective( solarCharge, condition, tableName);
        }
		catch ( Exception e )
		{  
			result = false;
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
		
		return result;
	}
	
	@Override
	public List<SolarCharge> findCurrentCharge( String imsi ) {
		
		List<SolarCharge> chargeList = null;
		SqlSession sqlSession = null;
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( new Date() );
		
		checkTableExist( tableName );
		
		try
        {
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			SolarChargeMapper solarChargeMapper = sqlSession.getMapper( SolarChargeMapper.class );
			
			SolarChargeCondition condition = new SolarChargeCondition();
			condition.setTableName( tableName );
			condition.createCriteria().andImsiEqualTo(imsi);				
			
			chargeList = solarChargeMapper.selectByExample( condition );
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
		
		return chargeList;
	}
	
	@Override
	public SolarCharge findByLinkId( String linkId ) {
		
		SolarCharge charge = null;
		SqlSession sqlSession = null;
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( new Date() );
		
		checkTableExist( tableName );
		
		try
        {
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			SolarChargeMapper solarChargeMapper = sqlSession.getMapper( SolarChargeMapper.class );
			
			SolarChargeCondition condition = new SolarChargeCondition();
			condition.setTableName( tableName );
			condition.createCriteria().andLinkIdEqualTo(linkId);				
			
			List<SolarCharge> chargeList = solarChargeMapper.selectByExample( condition );
			
			if( chargeList != null && chargeList.size() > 0 )
			{
				charge = chargeList.get(0);
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
		
		return charge;
	}

	@Override
	public boolean inseartSolarCharge(SolarCharge solarCharge) {

		boolean result = true;
		
		if( solarCharge == null )
		{
			throw new IllegalArgumentException( "the solarCharge is null!" );
		}
		
		SqlSession sqlSession = null;
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( new Date() );
		
		checkTableExist( tableName );
		
		try
        {
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			SolarChargeMapper solarChargeMapper = sqlSession.getMapper( SolarChargeMapper.class );
			
			solarCharge.setTableName( tableName );
			
			solarChargeMapper.insert(solarCharge );
        }
		catch ( Exception e )
		{  
			result = false;
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
		
		return result;
	}
	
	@Override
	public List<SpData> findSpData( Date startTime ) {

		List<SpData> spDataList = null;
		SqlSession sqlSession = null;
		String tableName = tableNamePrefix + Constant.sdf_yyyyMM.format( startTime );
		
		checkTableExist( tableName );
		
		try
        {
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			SolarChargeMapper solarChargeMapper = sqlSession.getMapper( SolarChargeMapper.class );
			
			SolarChargeCondition condition = new SolarChargeCondition();
			condition.setTableName( tableName );
			condition.createCriteria().andDisconnectTimeGreaterThanOrEqualTo( startTime ).andStatusEqualTo("1");				
			
			spDataList = solarChargeMapper.selectSpData(condition);
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
		
		return spDataList;
	}
	
	public static SolarChargeService getInstance()
	{
		if (instance == null) {
			synchronized (SolarChargeServiceImpl.class) {
                if (instance == null) {
                    instance = new SolarChargeServiceImpl ();
                }
            }
		}
		return instance;
	}
	
	private void checkTableExist( String tableName )
	{
		if( !commonService.findTableByName(tableName) )
		{
			logger.info( "table["+ tableName +"] not exist" );
	
			SqlSession sqlSession = null;
			
			try 
	        {  
				sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
				SolarChargeMapper solarChargeMapper = sqlSession.getMapper( SolarChargeMapper.class );
	            
				solarChargeMapper.createNewTable(tableName);
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
}
