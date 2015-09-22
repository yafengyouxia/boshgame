package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.CfgSmscenter;
import com.zsyj.fee.entity.CfgSmscenterCondition;

public interface CfgSmscenterMapper {
    int countByExample(CfgSmscenterCondition example);

    int deleteByExample(CfgSmscenterCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgSmscenter record);

    int insertSelective(CfgSmscenter record);

    List<CfgSmscenter> selectByExample(CfgSmscenterCondition example);

    CfgSmscenter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgSmscenter record, @Param("example") CfgSmscenterCondition example);

    int updateByExample(@Param("record") CfgSmscenter record, @Param("example") CfgSmscenterCondition example);

    int updateByPrimaryKeySelective(CfgSmscenter record);

    int updateByPrimaryKey(CfgSmscenter record);
}