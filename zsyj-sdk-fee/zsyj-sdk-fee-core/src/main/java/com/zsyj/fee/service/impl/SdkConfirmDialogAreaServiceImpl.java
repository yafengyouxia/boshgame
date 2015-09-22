package com.zsyj.fee.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.common.MemCacheHelper;
import com.zsyj.fee.common.enums.CacheEnum;
import com.zsyj.fee.dao.SdkConfirmDialogAreaMapper;
import com.zsyj.fee.entity.SdkConfirmDialogArea;
import com.zsyj.fee.entity.SdkConfirmDialogAreaCondition;
import com.zsyj.fee.service.SdkConfirmDialogAreaService;
import com.zsyj.fee.vo.SdkUser;

public class SdkConfirmDialogAreaServiceImpl implements SdkConfirmDialogAreaService
{
	private static final Logger		logger		= LoggerFactory.getLogger(SdkConfirmDialogAreaService.class);
	private static SdkConfirmDialogAreaService	instance	= null;

	/** 默认10分钟 */
	private static int expireSecond = 600*1000;
	
	private SdkConfirmDialogAreaServiceImpl()
	{
	}

	public static SdkConfirmDialogAreaService getInstance()
	{
		if (instance == null)
		{
			instance = new SdkConfirmDialogAreaServiceImpl();
		}
		return instance;
	}

	@Override
	public SdkConfirmDialogArea findByUser( SdkUser user ) {
		
		if( user != null )
		{
			List<SdkConfirmDialogArea> dialogAreaList = this.findAll();
			
			if( dialogAreaList != null )
			{
				for( SdkConfirmDialogArea tmpVO : dialogAreaList )
				{
					if( tmpVO.getType().compareTo( user.getTroneType() ) == 0 
							&& 
							( tmpVO.getProvinceCode().indexOf( user.getAreaCode() ) > -1 || tmpVO.getCityCode().indexOf( user.getTelCode() ) > -1  )
					)
					{
						return tmpVO;
					}
				}
			}			
		}
		
		return null;
	}
	
	@Override
	public SdkConfirmDialogArea findById(int id) {
		
		SqlSession	sqlSession	= null;
		SdkConfirmDialogArea sdkConfirmDialogArea = null;
		
		try
		{
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SdkConfirmDialogAreaMapper mapper = sqlSession.getMapper(SdkConfirmDialogAreaMapper.class);
			
			sdkConfirmDialogArea = mapper.selectByPrimaryKey(id);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			if (sqlSession != null)
			{
				sqlSession.close();
			}
		}
		return sdkConfirmDialogArea;
	}

	@Override
	public List<SdkConfirmDialogArea> findAll() {
		
		String key = CacheEnum.ConfirmDialogArea.getCode();
		
		if( MemCacheHelper.get( key ) != null )
		{
			return (List<SdkConfirmDialogArea>)MemCacheHelper.get( key );
		}
		else
		{
			return this.findAllFromDB( key );
		}
		
	}

	private List<SdkConfirmDialogArea> findAllFromDB( String memKey )
	{
		SqlSession	sqlSession	= null;
		List<SdkConfirmDialogArea> resultList = null;
		
		try
		{
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SdkConfirmDialogAreaMapper mapper = sqlSession.getMapper(SdkConfirmDialogAreaMapper.class);
			
			resultList= mapper.selectByExample( new SdkConfirmDialogAreaCondition() );
			
			if( resultList != null && resultList.size() > 0 )
			{
				MemCacheHelper.set( memKey, resultList, expireSecond );
			}
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			if (sqlSession != null)
			{
				sqlSession.close();
			}
		}
		return resultList;
	}
	
	@Override
	public boolean update(SdkConfirmDialogArea sdkConfirmDialogArea) {
		
		boolean result = true;
		SqlSession	sqlSession	= null;
		
		try
		{
			sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();
			
			SdkConfirmDialogAreaMapper mapper = sqlSession.getMapper(SdkConfirmDialogAreaMapper.class);
			
			mapper.updateByPrimaryKeySelective(sdkConfirmDialogArea);
		}
		catch (Exception e)
		{
			result = false;
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			if (sqlSession != null)
			{
				sqlSession.close();
			}
		}
		return result;
	}
}
