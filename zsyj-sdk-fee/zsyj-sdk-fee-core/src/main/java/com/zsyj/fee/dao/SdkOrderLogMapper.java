package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.SdkOrderLog;
import com.zsyj.fee.entity.SdkOrderLogCondition;
import com.zsyj.fee.vo.SpData;

public interface SdkOrderLogMapper {
	
	int createNewTable( @Param("tableName")String tableName );
	
    int countByExample(SdkOrderLogCondition example);
    
    int deleteByPrimaryKey(Integer id);

    int insert( SdkOrderLog record );

    int insertSelective( SdkOrderLog record );

    List<SdkOrderLog> selectByExample( SdkOrderLogCondition example );

    public List<SpData> selectSpData( SdkOrderLogCondition condition );
    
    SdkOrderLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SdkOrderLog record, @Param("example") SdkOrderLogCondition example, @Param("tableName")String tableName);

    int updateByExample(@Param("record") SdkOrderLog record, @Param("example") SdkOrderLogCondition example, @Param("tableName")String tableName);

    int updateByPrimaryKeySelective( @Param("record")SdkOrderLog record, @Param("tableName")String tableName );

    int updateByPrimaryKey(@Param("record")SdkOrderLog record, @Param("tableName")String tableName);
}