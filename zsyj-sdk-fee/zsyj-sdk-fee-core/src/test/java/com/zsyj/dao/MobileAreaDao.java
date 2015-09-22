package com.zsyj.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.dao.MobileareaMapper;
import com.zsyj.fee.entity.Mobilearea;
import com.zsyj.fee.entity.MobileareaCondition;
import com.zsyj.fee.service.impl.AreaServiceImpl;

public class MobileAreaDao {

	private static final Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);
	
	private SqlSession sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance(); 
	
	@Test
	public void findAll()
	{
		MobileareaMapper mobileareaMapper = sqlSession.getMapper( MobileareaMapper.class );
        List<Mobilearea> mobileList = mobileareaMapper.selectByExample( new MobileareaCondition() );
        
        System.out.println( "mobilearea total size:" + mobileList.size() );
	}
}
