package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgSdkTrone;
import com.zsyj.fee.entity.CfgSdkTroneCondition;

public interface CfgSdkTroneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CfgSdkTrone record);

    int insertSelective(CfgSdkTrone record);

    List<CfgSdkTrone> selectByExample(CfgSdkTroneCondition example);

    CfgSdkTrone selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgSdkTrone record, @Param("example") CfgSdkTroneCondition example);

    int updateByExample(@Param("record") CfgSdkTrone record, @Param("example") CfgSdkTroneCondition example);

    int updateByPrimaryKeySelective(CfgSdkTrone record);

    int updateByPrimaryKey(CfgSdkTrone record);
}