package com.zsyj.fee.dao;

import com.zsyj.fee.entity.CfgSpCompany;
import com.zsyj.fee.entity.CfgSpCompanyCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgSpCompanyMapper {
    int countByExample(CfgSpCompanyCondition example);

    int deleteByExample(CfgSpCompanyCondition example);

    int deleteByPrimaryKey(Integer spSid);

    int insert(CfgSpCompany record);

    int insertSelective(CfgSpCompany record);

    List<CfgSpCompany> selectByExample(CfgSpCompanyCondition example);

    CfgSpCompany selectByPrimaryKey(Integer spSid);

    int updateByExampleSelective(@Param("record") CfgSpCompany record, @Param("example") CfgSpCompanyCondition example);

    int updateByExample(@Param("record") CfgSpCompany record, @Param("example") CfgSpCompanyCondition example);

    int updateByPrimaryKeySelective(CfgSpCompany record);

    int updateByPrimaryKey(CfgSpCompany record);
}