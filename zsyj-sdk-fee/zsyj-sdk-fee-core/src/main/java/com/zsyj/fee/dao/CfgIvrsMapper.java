package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgIvrs;
import com.zsyj.fee.entity.CfgIvrsCondition;

public interface CfgIvrsMapper {
    int countByExample(CfgIvrsCondition example);

    int deleteByExample(CfgIvrsCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgIvrs record);

    int insertSelective(CfgIvrs record);

    List<CfgIvrs> selectByExample(CfgIvrsCondition example);

    CfgIvrs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgIvrs record, @Param("example") CfgIvrsCondition example);

    int updateByExample(@Param("record") CfgIvrs record, @Param("example") CfgIvrsCondition example);

    int updateByPrimaryKeySelective(CfgIvrs record);

    int updateByPrimaryKey(CfgIvrs record);
}