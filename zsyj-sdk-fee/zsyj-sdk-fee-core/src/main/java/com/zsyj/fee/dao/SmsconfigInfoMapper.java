package com.zsyj.fee.dao;

import com.zsyj.fee.entity.SmsconfigInfo;
import com.zsyj.fee.entity.SmsconfigInfoCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsconfigInfoMapper {
    int countByExample(SmsconfigInfoCondition example);

    int deleteByExample(SmsconfigInfoCondition example);

    int deleteByPrimaryKey(Integer sysid);

    int insert(SmsconfigInfo record);

    int insertSelective(SmsconfigInfo record);

    List<SmsconfigInfo> selectByExample(SmsconfigInfoCondition example);

    SmsconfigInfo selectByPrimaryKey(Integer sysid);

    int updateByExampleSelective(@Param("record") SmsconfigInfo record, @Param("example") SmsconfigInfoCondition example);

    int updateByExample(@Param("record") SmsconfigInfo record, @Param("example") SmsconfigInfoCondition example);

    int updateByPrimaryKeySelective(SmsconfigInfo record);

    int updateByPrimaryKey(SmsconfigInfo record);
}