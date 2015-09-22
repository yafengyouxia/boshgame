package com.zsyj.fee.dao;

import com.zsyj.fee.entity.SolarAgent;
import com.zsyj.fee.entity.SolarAgentCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SolarAgentMapper {
    int countByExample(SolarAgentCondition example);

    int deleteByExample(SolarAgentCondition example);

    int deleteByPrimaryKey(Integer agentId);

    int insert(SolarAgent record);

    int insertSelective(SolarAgent record);

    List<SolarAgent> selectByExample(SolarAgentCondition example);

    SolarAgent selectByPrimaryKey(Integer agentId);

    int updateByExampleSelective(@Param("record") SolarAgent record, @Param("example") SolarAgentCondition example);

    int updateByExample(@Param("record") SolarAgent record, @Param("example") SolarAgentCondition example);

    int updateByPrimaryKeySelective(SolarAgent record);

    int updateByPrimaryKey(SolarAgent record);
}