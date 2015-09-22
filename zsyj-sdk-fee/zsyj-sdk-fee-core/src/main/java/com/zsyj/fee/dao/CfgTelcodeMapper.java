package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgTelcode;
import com.zsyj.fee.entity.CfgTelcodeCondition;

public interface CfgTelcodeMapper {
    int countByExample(CfgTelcodeCondition example);

    int deleteByExample(CfgTelcodeCondition example);

    int deleteByPrimaryKey(String telcode);

    int insert(CfgTelcode record);

    int insertSelective(CfgTelcode record);

    List<CfgTelcode> selectByExample(CfgTelcodeCondition example);

    CfgTelcode selectByPrimaryKey(String telcode);

    int updateByExampleSelective(@Param("record") CfgTelcode record, @Param("example") CfgTelcodeCondition example);

    int updateByExample(@Param("record") CfgTelcode record, @Param("example") CfgTelcodeCondition example);

    int updateByPrimaryKeySelective(CfgTelcode record);

    int updateByPrimaryKey(CfgTelcode record);
}