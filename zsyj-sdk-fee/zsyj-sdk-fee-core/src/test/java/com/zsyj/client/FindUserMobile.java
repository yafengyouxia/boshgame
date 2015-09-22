package com.zsyj.client;

import java.util.HashMap;
import java.util.Map;

public class FindUserMobile {
	
	public static Map<String, String> areaMap = new HashMap<String, String>();
	
	public void findMobile() {
		
		areaMap.put("北京", "0001");
		areaMap.put("上海", "0002");
		areaMap.put("天津", "0003");
		areaMap.put("重庆", "0004");
		areaMap.put("黑龙江","0005");
		areaMap.put("吉林", "0006");
		areaMap.put("辽宁", "0007");
		areaMap.put("内蒙古","0008");
		areaMap.put("河北", "0009");
		areaMap.put("河南", "0010");
		areaMap.put("广东", "0011");
		areaMap.put("湖北", "0012");
		areaMap.put("山东", "0013");
		areaMap.put("浙江", "0014");
		areaMap.put("安徽", "0015");
		areaMap.put("江苏", "0016");
		areaMap.put("江西", "0017");
		areaMap.put("云南", "0018");
		areaMap.put("宁夏", "0019");
		areaMap.put("青海", "0020");
		areaMap.put("山西", "0021");
		areaMap.put("陕西", "0022");
		areaMap.put("湖南", "0023");
		areaMap.put("福建", "0024");
		areaMap.put("甘肃", "0025");
		areaMap.put("四川", "0026");
		areaMap.put("广西", "0027");
		areaMap.put("贵州", "0028");
		areaMap.put("海南", "0029");
		areaMap.put("西藏", "0030");
		areaMap.put("新疆", "0031");
		
		String[] areas = {
				"江苏",
				"江苏",
				"江苏",
				"江苏",
				"江苏",
				"江苏",
				"江苏",
				"四川",
				"四川",
				"江苏"
		};
		
		String[]  queryArray = {
				"137****321",
				"139****528",
				"137****321",
				"183****579",
				"182****475",
				"138****129",
				"159****562",
				"139****562",
				"139****562",
				"152****270"
		}; 
		
		for( int i = 0; i < queryArray.length; i++  ) {
			String query = queryArray[i];
			String str = " select mobilenumber, telId, sid, firstVisitTime from users where mobilenumber like '" + query.replace("****", "%") + "' "
				+ " and areaid = '" + areaMap.get( areas[i] ) + "' group by mobilenumber ";
			
			System.out.println( str );
		}
	}
	
	public static void main( String args [] ) {
		
		FindUserMobile findUser  = new FindUserMobile();
		
		findUser.findMobile();
	}
}
