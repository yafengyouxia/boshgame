package com.zsyj.fee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsyj.fee.entity.SolarCharge;
import com.zsyj.fee.entity.SolarChargeCondition;
import com.zsyj.fee.vo.SpData;

public interface SolarChargeMapper {
	
	public List<SpData> selectServiceCodeData( SolarChargeCondition condition ); 
	
	public List<SpData> selectSpData( SolarChargeCondition condition );
	
    int countByExample( SolarChargeCondition example );
    
    int deleteByPrimaryKey(Integer id);

    int insert( SolarCharge record  );

    int insertSelective( SolarCharge record );

    List<SolarCharge> selectByExample( SolarChargeCondition example );

    SolarCharge selectByPrimaryKey(Integer id, @Param("tableName") String tableName );

    int updateByExampleSelective(@Param("record") SolarCharge record, 
    		@Param("example") SolarChargeCondition example, @Param("tableName") String tableName );

    int updateByExample(@Param("record") SolarCharge record, @Param("example") SolarChargeCondition example , @Param("tableName") String tableName  );

    int updateByPrimaryKeySelective(SolarCharge record  );

    int updateByPrimaryKey(SolarCharge record  );
    
    int createNewTable( @Param("tableName") String tableName );
}