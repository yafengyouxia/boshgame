package com.zsyj.fee.syn;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.threadpool.SdkThreadPool;
import com.zsyj.fee.vo.SdkSolarCharge;

public class DFChargeSynchronize {
	
	private static final Logger logger = LoggerFactory.getLogger(DFChargeSynchronize.class);
	
	public boolean processCharge( SdkSolarCharge solarCharge, String synContent )
	{
		String linkId = solarCharge.getLinkId();
		
		if (linkId == null || linkId.length() == 0) {
			logger.error(solarCharge + " linkId为空，处理直接返回!!");
			return false;
		}
		
		SdkThreadPool.getInstance().excute( new DFSmsChargeJob( solarCharge, synContent ) );
		
		return true;
	}
	
	/**
	 * 
	 * @param linkId
	 * @return true存在  false不存在
	 */
	public boolean isExistLinkId( String linkId, List<SdkSolarCharge> chargeList ){
		
		boolean flag = false;
		try {
			List<SdkSolarCharge> tmpList = new ArrayList<SdkSolarCharge>( chargeList );
			for( SdkSolarCharge tmp : tmpList ) {
				if( tmp.getLinkId().equals( linkId ) ) {
					flag = true;
					break;
				}
			}
		} catch( Exception e ) {
			e.printStackTrace();
		}
		return flag;
	}
}
