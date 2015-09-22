package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgRole;
import com.zsyj.fee.entity.CfgRoleCondition;

public interface CfgRoleMapper {
    int countByExample(CfgRoleCondition example);

    int deleteByExample(CfgRoleCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgRole record);

    int insertSelective(CfgRole record);

    List<CfgRole> selectByExample(CfgRoleCondition example);

    CfgRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgRole record, @Param("example") CfgRoleCondition example);

    int updateByExample(@Param("record") CfgRole record, @Param("example") CfgRoleCondition example);

    int updateByPrimaryKeySelective(CfgRole record);

    int updateByPrimaryKey(CfgRole record);
}