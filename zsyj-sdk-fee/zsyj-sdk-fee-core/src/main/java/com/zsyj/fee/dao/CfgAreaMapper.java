package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgArea;
import com.zsyj.fee.entity.CfgAreaCondition;

public interface CfgAreaMapper {
    int countByExample(CfgAreaCondition example);

    int deleteByExample(CfgAreaCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgArea record);

    int insertSelective(CfgArea record);

    List<CfgArea> selectByExample(CfgAreaCondition example);

    CfgArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgArea record, @Param("example") CfgAreaCondition example);

    int updateByExample(@Param("record") CfgArea record, @Param("example") CfgAreaCondition example);

    int updateByPrimaryKeySelective(CfgArea record);

    int updateByPrimaryKey(CfgArea record);
}