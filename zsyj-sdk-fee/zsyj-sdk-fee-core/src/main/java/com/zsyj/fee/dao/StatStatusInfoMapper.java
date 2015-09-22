package com.zsyj.fee.dao;

import com.zsyj.fee.entity.StatStatusInfo;
import com.zsyj.fee.entity.StatStatusInfoCondition;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatStatusInfoMapper {
    int countByExample(StatStatusInfoCondition example);

    int deleteByExample(StatStatusInfoCondition example);

    int deleteByPrimaryKey(Integer nId);

    int insert(StatStatusInfo record);

    int insertSelective(StatStatusInfo record);

    List<StatStatusInfo> selectByExampleWithBLOBs(StatStatusInfoCondition example);

    List<StatStatusInfo> selectByExample(StatStatusInfoCondition example);

    StatStatusInfo selectByPrimaryKey(Integer nId);

    int updateByExampleSelective(@Param("record") StatStatusInfo record, @Param("example") StatStatusInfoCondition example);

    int updateByExampleWithBLOBs(@Param("record") StatStatusInfo record, @Param("example") StatStatusInfoCondition example);

    int updateByExample(@Param("record") StatStatusInfo record, @Param("example") StatStatusInfoCondition example);

    int updateByPrimaryKeySelective(StatStatusInfo record);

    int updateByPrimaryKeyWithBLOBs(StatStatusInfo record);

    int updateByPrimaryKey(StatStatusInfo record);
    
    Date selectMaxTimeByExample( StatStatusInfoCondition example );
}