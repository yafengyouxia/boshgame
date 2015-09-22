package com.zsyj.fee.dao;

import java.util.List;

import com.zsyj.fee.entity.SdkStrategy;
import com.zsyj.fee.entity.SdkStrategyCondition;

public interface SdkStrategyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SdkStrategy record);

    int insertSelective(SdkStrategy record);

    List<SdkStrategy> selectByExample(SdkStrategyCondition example);

    SdkStrategy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SdkStrategy record);

    int updateByPrimaryKey(SdkStrategy record);
}