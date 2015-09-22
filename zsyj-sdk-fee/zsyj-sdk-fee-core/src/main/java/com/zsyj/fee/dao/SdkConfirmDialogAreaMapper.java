package com.zsyj.fee.dao;

import com.zsyj.fee.entity.SdkConfirmDialogArea;
import com.zsyj.fee.entity.SdkConfirmDialogAreaCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdkConfirmDialogAreaMapper {
    int countByExample(SdkConfirmDialogAreaCondition example);

    int deleteByExample(SdkConfirmDialogAreaCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(SdkConfirmDialogArea record);

    int insertSelective(SdkConfirmDialogArea record);

    List<SdkConfirmDialogArea> selectByExample(SdkConfirmDialogAreaCondition example);

    SdkConfirmDialogArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SdkConfirmDialogArea record, @Param("example") SdkConfirmDialogAreaCondition example);

    int updateByExample(@Param("record") SdkConfirmDialogArea record, @Param("example") SdkConfirmDialogAreaCondition example);

    int updateByPrimaryKeySelective(SdkConfirmDialogArea record);

    int updateByPrimaryKey(SdkConfirmDialogArea record);
}