package com.zsyj.fee.dao;

import com.zsyj.fee.entity.SdkSynurlLog;
import com.zsyj.fee.entity.SdkSynurlLogCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdkSynurlLogMapper {
    int countByExample(SdkSynurlLogCondition example);

    int deleteByExample(SdkSynurlLogCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(SdkSynurlLog record);

    int insertSelective(SdkSynurlLog record);

    List<SdkSynurlLog> selectByExample(SdkSynurlLogCondition example);

    SdkSynurlLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SdkSynurlLog record, @Param("example") SdkSynurlLogCondition example);

    int updateByExample(@Param("record") SdkSynurlLog record, @Param("example") SdkSynurlLogCondition example);

    int updateByPrimaryKeySelective(SdkSynurlLog record);

    int updateByPrimaryKey(SdkSynurlLog record);
}