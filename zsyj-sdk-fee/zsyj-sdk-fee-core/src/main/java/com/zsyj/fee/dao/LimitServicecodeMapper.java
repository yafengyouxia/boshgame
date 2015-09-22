package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.LimitServicecode;
import com.zsyj.fee.entity.LimitServicecodeCondition;

public interface LimitServicecodeMapper {
    int countByExample(LimitServicecodeCondition example);

    int deleteByExample(LimitServicecodeCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(LimitServicecode record);

    int insertSelective(LimitServicecode record);

    List<LimitServicecode> selectByExample(LimitServicecodeCondition example);

    LimitServicecode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LimitServicecode record, @Param("example") LimitServicecodeCondition example);

    int updateByExample(@Param("record") LimitServicecode record, @Param("example") LimitServicecodeCondition example);

    int updateByPrimaryKeySelective(LimitServicecode record);

    int updateByPrimaryKey(LimitServicecode record);
}