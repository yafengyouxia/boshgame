package com.zsyj.fee.dao;

import com.zsyj.fee.entity.SdkTroneStrategy;
import com.zsyj.fee.entity.SdkTroneStrategyCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdkTroneStrategyMapper {
    int countByExample(SdkTroneStrategyCondition example);

    int deleteByExample(SdkTroneStrategyCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(SdkTroneStrategy record);

    int insertSelective(SdkTroneStrategy record);

    List<SdkTroneStrategy> selectByExample(SdkTroneStrategyCondition example);

    SdkTroneStrategy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SdkTroneStrategy record, @Param("example") SdkTroneStrategyCondition example);

    int updateByExample(@Param("record") SdkTroneStrategy record, @Param("example") SdkTroneStrategyCondition example);

    int updateByPrimaryKeySelective(SdkTroneStrategy record);

    int updateByPrimaryKey(SdkTroneStrategy record);
}