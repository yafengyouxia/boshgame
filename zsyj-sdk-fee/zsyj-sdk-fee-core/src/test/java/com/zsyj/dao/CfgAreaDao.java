package com.zsyj.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zsyj.fee.common.BatisSessionFactoryUtil;
import com.zsyj.fee.dao.CfgAreaMapper;
import com.zsyj.fee.entity.CfgArea;
import com.zsyj.fee.entity.CfgAreaCondition;

public class CfgAreaDao {

	@Test
	public void findAll()
	{
        SqlSession sqlSession = null;  
        try {  
            sqlSession = BatisSessionFactoryUtil.getSqlSessionIntance();  
            	
            CfgAreaMapper cfgAreaMapper = sqlSession.getMapper( CfgAreaMapper.class );
            List<CfgArea> areaList = cfgAreaMapper.selectByExample( new CfgAreaCondition() );
            
            System.out.println( areaList );
            
            if( areaList != null && areaList.size() > 0 )
            {
            	for( CfgArea area : areaList )
            	{
            		System.out.println( area.toString() );
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
