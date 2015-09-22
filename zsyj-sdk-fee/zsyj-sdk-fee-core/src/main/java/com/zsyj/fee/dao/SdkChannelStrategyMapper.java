package com.zsyj.fee.dao;

import java.util.List;

import com.zsyj.fee.entity.SdkChannelStrategy;
import com.zsyj.fee.entity.SdkChannelStrategyCondition;

public interface SdkChannelStrategyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SdkChannelStrategy record);

    int insertSelective(SdkChannelStrategy record);

    List<SdkChannelStrategy> selectByExample(SdkChannelStrategyCondition example);

    SdkChannelStrategy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SdkChannelStrategy record);

    int updateByPrimaryKey(SdkChannelStrategy record);
}