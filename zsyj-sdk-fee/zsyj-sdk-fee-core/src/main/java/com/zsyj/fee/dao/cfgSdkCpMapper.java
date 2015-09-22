package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.cfgSdkCp;
import com.zsyj.fee.entity.cfgSdkCpCondition;

public interface cfgSdkCpMapper {
    int countByExample(cfgSdkCpCondition example);

    int deleteByExample(cfgSdkCpCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(cfgSdkCp record);

    int insertSelective(cfgSdkCp record);

    List<cfgSdkCp> selectByExample(cfgSdkCpCondition example);

    cfgSdkCp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") cfgSdkCp record, @Param("example") cfgSdkCpCondition example);

    int updateByExample(@Param("record") cfgSdkCp record, @Param("example") cfgSdkCpCondition example);

    int updateByPrimaryKeySelective(cfgSdkCp record);

    int updateByPrimaryKey(cfgSdkCp record);
}