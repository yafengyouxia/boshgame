package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.SdkUnknowArea;
import com.zsyj.fee.entity.SdkUnknowAreaCondition;

public interface SdkUnknowAreaMapper {
    int countByExample(SdkUnknowAreaCondition example);

    int deleteByExample(SdkUnknowAreaCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(SdkUnknowArea record);

    int insertSelective(SdkUnknowArea record);

    List<SdkUnknowArea> selectByExample(SdkUnknowAreaCondition example);

    SdkUnknowArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SdkUnknowArea record, @Param("example") SdkUnknowAreaCondition example);

    int updateByExample(@Param("record") SdkUnknowArea record, @Param("example") SdkUnknowAreaCondition example);

    int updateByPrimaryKeySelective(SdkUnknowArea record);

    int updateByPrimaryKey(SdkUnknowArea record);
}