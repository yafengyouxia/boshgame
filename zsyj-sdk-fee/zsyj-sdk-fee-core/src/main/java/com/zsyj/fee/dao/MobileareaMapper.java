package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.Mobilearea;
import com.zsyj.fee.entity.MobileareaCondition;

public interface MobileareaMapper {
    int countByExample(MobileareaCondition example);

    int deleteByExample(MobileareaCondition example);

    int deleteByPrimaryKey(Integer submobilenumber);

    int insert(Mobilearea record);

    int insertSelective(Mobilearea record);

    List<Mobilearea> selectByExample(MobileareaCondition example);

    Mobilearea selectByPrimaryKey(Integer submobilenumber);

    int updateByExampleSelective(@Param("record") Mobilearea record, @Param("example") MobileareaCondition example);

    int updateByExample(@Param("record") Mobilearea record, @Param("example") MobileareaCondition example);

    int updateByPrimaryKeySelective(Mobilearea record);

    int updateByPrimaryKey(Mobilearea record);
}