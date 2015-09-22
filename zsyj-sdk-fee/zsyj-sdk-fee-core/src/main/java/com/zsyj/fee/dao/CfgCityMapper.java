package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgCity;
import com.zsyj.fee.entity.CfgCityCondition;

public interface CfgCityMapper {
    int countByExample(CfgCityCondition example);

    int deleteByExample(CfgCityCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgCity record);

    int insertSelective(CfgCity record);

    List<CfgCity> selectByExample(CfgCityCondition example);

    CfgCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgCity record, @Param("example") CfgCityCondition example);

    int updateByExample(@Param("record") CfgCity record, @Param("example") CfgCityCondition example);

    int updateByPrimaryKeySelective(CfgCity record);

    int updateByPrimaryKey(CfgCity record);
}