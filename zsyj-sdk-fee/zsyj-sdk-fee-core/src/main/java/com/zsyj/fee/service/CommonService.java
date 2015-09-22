package com.zsyj.fee.service;


/**
 * 公共集合
 * @author hujian
 * */
public interface CommonService {

	/**
	 * 在统计库中判断表是否存在
	 * @param tableName
	 * @return true:存在	false:不存在
	 */
	public boolean findTableByNameFromStat( String tableName );
	
	/**
	 * 在information_schema库中判断表是否存在
	 * @param tableName
	 * @return true:存在	false:不存在
	 */
	public boolean findTableByName( String tableName );
	
	public String findProvinceName( String provinceCode );
}
