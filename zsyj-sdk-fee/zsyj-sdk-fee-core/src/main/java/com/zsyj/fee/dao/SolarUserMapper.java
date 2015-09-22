package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.SolarUser;
import com.zsyj.fee.entity.SolarUserCondition;

public interface SolarUserMapper {
    int countByExample(SolarUserCondition example);

    int deleteByExample(SolarUserCondition example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SolarUser record);

    int insertSelective(SolarUser record);

    List<SolarUser> selectByExample(SolarUserCondition example);

    SolarUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SolarUser record, @Param("example") SolarUserCondition example);

    int updateByExample(@Param("record") SolarUser record, @Param("example") SolarUserCondition example);

    int updateByPrimaryKeySelective(SolarUser record);

    int updateByPrimaryKey(SolarUser record);
}