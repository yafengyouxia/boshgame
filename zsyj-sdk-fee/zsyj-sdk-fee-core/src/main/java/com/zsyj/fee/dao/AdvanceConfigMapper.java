package com.zsyj.fee.dao;

import com.zsyj.fee.entity.AdvanceConfig;
import com.zsyj.fee.entity.AdvanceConfigCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvanceConfigMapper {
    int countByExample(AdvanceConfigCondition example);

    int deleteByExample(AdvanceConfigCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdvanceConfig record);

    int insertSelective(AdvanceConfig record);

    List<AdvanceConfig> selectByExample(AdvanceConfigCondition example);

    AdvanceConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdvanceConfig record, @Param("example") AdvanceConfigCondition example);

    int updateByExample(@Param("record") AdvanceConfig record, @Param("example") AdvanceConfigCondition example);

    int updateByPrimaryKeySelective(AdvanceConfig record);

    int updateByPrimaryKey(AdvanceConfig record);
}