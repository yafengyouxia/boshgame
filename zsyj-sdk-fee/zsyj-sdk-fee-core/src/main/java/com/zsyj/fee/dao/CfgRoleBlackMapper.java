package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgRoleBlack;
import com.zsyj.fee.entity.CfgRoleBlackCondition;

public interface CfgRoleBlackMapper {
    int countByExample(CfgRoleBlackCondition example);

    int deleteByExample(CfgRoleBlackCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgRoleBlack record);

    int insertSelective(CfgRoleBlack record);

    List<CfgRoleBlack> selectByExample(CfgRoleBlackCondition example);

    CfgRoleBlack selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgRoleBlack record, @Param("example") CfgRoleBlackCondition example);

    int updateByExample(@Param("record") CfgRoleBlack record, @Param("example") CfgRoleBlackCondition example);

    int updateByPrimaryKeySelective(CfgRoleBlack record);

    int updateByPrimaryKey(CfgRoleBlack record);
}