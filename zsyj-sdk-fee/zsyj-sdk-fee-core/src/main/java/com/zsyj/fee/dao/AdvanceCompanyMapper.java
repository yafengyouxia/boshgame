package com.zsyj.fee.dao;

import com.zsyj.fee.entity.AdvanceCompany;
import com.zsyj.fee.entity.AdvanceCompanyCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvanceCompanyMapper {
    int countByExample(AdvanceCompanyCondition example);

    int deleteByExample(AdvanceCompanyCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdvanceCompany record);

    int insertSelective(AdvanceCompany record);

    List<AdvanceCompany> selectByExample(AdvanceCompanyCondition example);

    AdvanceCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdvanceCompany record, @Param("example") AdvanceCompanyCondition example);

    int updateByExample(@Param("record") AdvanceCompany record, @Param("example") AdvanceCompanyCondition example);

    int updateByPrimaryKeySelective(AdvanceCompany record);

    int updateByPrimaryKey(AdvanceCompany record);
}