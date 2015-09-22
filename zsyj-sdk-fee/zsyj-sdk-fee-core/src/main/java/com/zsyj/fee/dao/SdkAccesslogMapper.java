package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.SdkAccesslog;
import com.zsyj.fee.entity.SdkAccesslogCondition;

public interface SdkAccesslogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SdkAccesslog record);

    int insertSelective(SdkAccesslog record);

    List<SdkAccesslog> selectByExample(SdkAccesslogCondition example);

    SdkAccesslog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SdkAccesslog record);

    int updateByPrimaryKey(SdkAccesslog record);
    
    int createNewTable( @Param("tableName") String tableName );
}