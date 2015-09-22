package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.SolarMonitor;
import com.zsyj.fee.entity.SolarMonitorCondition;

public interface SolarMonitorMapper {
    int countByExample(SolarMonitorCondition example);

    int deleteByExample(SolarMonitorCondition example);

    int deleteByPrimaryKey(Integer monnitorId);

    int insert(SolarMonitor record);

    int insertSelective(SolarMonitor record);

    List<SolarMonitor> selectByExample(SolarMonitorCondition example);

    SolarMonitor selectByPrimaryKey(Integer monnitorId);

    int updateByExampleSelective(@Param("record") SolarMonitor record, @Param("example") SolarMonitorCondition example);

    int updateByExample(@Param("record") SolarMonitor record, @Param("example") SolarMonitorCondition example);

    int updateByPrimaryKeySelective(SolarMonitor record);

    int updateByPrimaryKey(SolarMonitor record);
}