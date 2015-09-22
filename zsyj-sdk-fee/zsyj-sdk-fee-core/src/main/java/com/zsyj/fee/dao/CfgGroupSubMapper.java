package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgGroupSub;
import com.zsyj.fee.entity.CfgGroupSubCondition;

public interface CfgGroupSubMapper {
    int countByExample(CfgGroupSubCondition example);

    int deleteByExample(CfgGroupSubCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgGroupSub record);

    int insertSelective(CfgGroupSub record);

    List<CfgGroupSub> selectByExample(CfgGroupSubCondition example);

    CfgGroupSub selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgGroupSub record, @Param("example") CfgGroupSubCondition example);

    int updateByExample(@Param("record") CfgGroupSub record, @Param("example") CfgGroupSubCondition example);

    int updateByPrimaryKeySelective(CfgGroupSub record);

    int updateByPrimaryKey(CfgGroupSub record);
}