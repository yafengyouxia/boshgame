package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgSub;
import com.zsyj.fee.entity.CfgSubCondition;

public interface CfgSubMapper {
    int countByExample(CfgSubCondition example);

    int deleteByExample(CfgSubCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgSub record);

    int insertSelective(CfgSub record);

    List<CfgSub> selectByExample(CfgSubCondition example);

    CfgSub selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgSub record, @Param("example") CfgSubCondition example);

    int updateByExample(@Param("record") CfgSub record, @Param("example") CfgSubCondition example);

    int updateByPrimaryKeySelective(CfgSub record);

    int updateByPrimaryKey(CfgSub record);
}