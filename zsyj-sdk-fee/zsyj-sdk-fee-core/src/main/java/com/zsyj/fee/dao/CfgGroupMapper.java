package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgGroup;
import com.zsyj.fee.entity.CfgGroupCondition;

public interface CfgGroupMapper {
    int countByExample(CfgGroupCondition example);

    int deleteByExample(CfgGroupCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgGroup record);

    int insertSelective(CfgGroup record);

    List<CfgGroup> selectByExample(CfgGroupCondition example);

    CfgGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgGroup record, @Param("example") CfgGroupCondition example);

    int updateByExample(@Param("record") CfgGroup record, @Param("example") CfgGroupCondition example);

    int updateByPrimaryKeySelective(CfgGroup record);

    int updateByPrimaryKey(CfgGroup record);
}