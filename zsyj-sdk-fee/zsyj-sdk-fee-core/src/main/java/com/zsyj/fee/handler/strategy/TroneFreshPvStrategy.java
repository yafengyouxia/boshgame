package com.zsyj.fee.handler.strategy;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.zsyj.fee.entity.CfgSpCompany;
import com.zsyj.fee.service.impl.TroneConfigInfoServiceImpl;
import com.zsyj.fee.vo.TroneConfigInfo;

public class TroneFreshPvStrategy {

	public TroneConfigInfo findFreshPvTrone( Map<Integer, CfgSpCompany> spMap, List<String> usedMasterSpList )
	{
		TroneConfigInfo freshTrone = null;
		List<TroneConfigInfo> troneFreshList = TroneConfigInfoServiceImpl.getInstance().getFreshPvFreshList();
	
		if( troneFreshList != null && troneFreshList.size() > 0 )
		{
			for( TroneConfigInfo trone : troneFreshList )
			{
				CfgSpCompany spCompany = spMap.get(trone.getSpId());
				
				if( spCompany != null 
						&& StringUtils.isNotBlank( spCompany.getMasterId() ) 
						&& !usedMasterSpList.contains( spCompany.getMasterId() ) )
				{
					freshTrone =  trone;
					break;
				}
			}
		}
		
		return freshTrone;
	}
	
}
