package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.IpInfos;
import com.zsyj.fee.entity.IpInfosCondition;

public interface IpInfosMapper {
    int countByExample(IpInfosCondition example);

    int deleteByExample(IpInfosCondition example);

    int deleteByPrimaryKey(Integer id);

    int insert(IpInfos record);

    int insertSelective(IpInfos record);

    List<IpInfos> selectByExample(IpInfosCondition example);

    IpInfos selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IpInfos record, @Param("example") IpInfosCondition example);

    int updateByExample(@Param("record") IpInfos record, @Param("example") IpInfosCondition example);

    int updateByPrimaryKeySelective(IpInfos record);

    int updateByPrimaryKey(IpInfos record);
}