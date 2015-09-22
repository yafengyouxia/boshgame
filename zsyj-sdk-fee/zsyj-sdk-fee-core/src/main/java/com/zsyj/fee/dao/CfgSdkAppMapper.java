package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgSdkApp;
import com.zsyj.fee.entity.CfgSdkAppCondition;

public interface CfgSdkAppMapper {
    int countByExample(CfgSdkAppCondition example);

    int deleteByExample(CfgSdkAppCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgSdkApp record);

    int insertSelective(CfgSdkApp record);

    List<CfgSdkApp> selectByExample(CfgSdkAppCondition example);

    CfgSdkApp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgSdkApp record, @Param("example") CfgSdkAppCondition example);

    int updateByExample(@Param("record") CfgSdkApp record, @Param("example") CfgSdkAppCondition example);

    int updateByPrimaryKeySelective(CfgSdkApp record);

    int updateByPrimaryKey(CfgSdkApp record);
}