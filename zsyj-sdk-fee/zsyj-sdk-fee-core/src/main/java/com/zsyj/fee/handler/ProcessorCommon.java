package com.zsyj.fee.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zsyj.fee.common.Constant;
import com.zsyj.fee.common.ImsiUtil;
import com.zsyj.fee.entity.SolarCharge;
import com.zsyj.fee.service.AreaService;
import com.zsyj.fee.service.CommonService;
import com.zsyj.fee.service.SolarChargeService;
import com.zsyj.fee.service.impl.AreaServiceImpl;
import com.zsyj.fee.service.impl.CommonServiceImpl;
import com.zsyj.fee.service.impl.SolarChargeServiceImpl;
import com.zsyj.fee.vo.AreaInfo;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneCode;
import com.zsyj.fee.vo.TroneConfigInfo;

public class ProcessorCommon {
	
	private static Log logger = LogFactory.getLog(ProcessorCommon.class.getName());
	
	private AreaService areaService = AreaServiceImpl.getInstance();
	private CommonService commonService = CommonServiceImpl.getInstance();
	private SolarChargeService solarChargeService = SolarChargeServiceImpl.getInstance();
	
	//分配系数
	public static final double WapMoidRatio = 1.0;
	public static final double SmsMoidRatio = 1.5;
	
	//随机二次确认恢复指令    随便回复任意内容即可预订信息
	public static String[] confirmCommandArray = { "0", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "11", "12", "23", "a", "d", "g", "j", "m", "p", "t", "w",
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
			"aa", "ab", "abc", "xx", "mm", "jw", "dd" };
	
	public static String DEFAULT_MOBILETRONE_CU = "CU";
	
	/**
	 * @return true--mid有效   falise--mid无效  
	 * */
	public static boolean validMid( String mid )
	{
		mid = mid.replace( "#" , "_" );
		boolean valid = true;
		if( mid.equals("0000") || "".equals( mid ) || mid == null
				|| !mid.matches( Constant.midRegex ) )
		{
			valid = false;
		}
		
		return valid;
	}
	
	/** 
	 * 统计用户当月的计费状态
	 * @param feeRequest
	 * @param user
	 * @param processedLinkIDTable
	 * @return 本月已计费金额
	 */
	public int findCurrentMonthChargeByUser( FeeRequest feeRequest, SdkUser user,
			Map<String, Double> troneFeeTable )
	{
		int totalFeeCount = 0;
		String serviceId = null;
		String chargeTableName = "solar_charge" + Constant.sdf_yyyyMM.format( new Date() );
		boolean exists = commonService.findTableByName( chargeTableName );
		
		if( exists && StringUtils.isNotBlank( user.getMobile() ) )
		{
			//统计短信当月计费金额
			List<SolarCharge> chargeList = this.solarChargeService.findCurrentCharge( feeRequest.getImsi() );
			if( chargeList != null && chargeList.size() > 0 )
			{
				double troneFeeMoney = 0;
				for( SolarCharge solarCharge : chargeList )
				{
					serviceId = solarCharge.getServiceCode(); 
					troneFeeMoney = troneFeeTable.get( serviceId )==null?0:troneFeeTable.get( serviceId );
					
					troneFeeTable.put( serviceId, troneFeeMoney + Double.valueOf( solarCharge.getUsedCash() ) );
					
					//统计用户当月已计费金额
					totalFeeCount += Double.valueOf( solarCharge.getUsedCash() );
				}
			}	
			
			if( totalFeeCount > 0 )
			{
				logger.info( "mid:[" + feeRequest.getMid() + "] mobile[" + user.getMobile()
						+ "] totalFeeCount:[" + totalFeeCount + "]");	
			}
		}
		
		return totalFeeCount;
	}
	
	/** 查询用户所在省份 */
	public void findUserProvinceArea( SdkUser user, FeeRequest feeRequest )
	{
		AreaInfo areaInfo = this.findUserProvinceArea( user.getMobile(), user.getMid(), user.getImsi(), user.getSmscenter(), feeRequest==null?"":feeRequest.getRequestIp() );
		
		if( areaInfo != null )
		{
			if( !areaInfo.getProvinceCode().equals( user.getAreaCode() )
					|| !areaInfo.getTelCode().equals( user.getTelCode() ) ) {
				
				user.setAreaCode( areaInfo.getProvinceCode() );
				user.setTelCode( areaInfo.getTelCode() );
				user.setTroneType( areaInfo.getTroneType() );
				
				logger.debug( "update user areaInfo : " + areaInfo );
				user.setUpdate( true );
			}
		}
	}
	
	
	public Byte findTroneType( String imsi, String mobileNumber )
	{
		Byte troneType = -1;
		
		if( mobileNumber != null && mobileNumber.length() > 5 ) 
		{
			if( Constant.TRONETYPE_CMCC_STARTWITH.indexOf( mobileNumber.substring(0, 3) ) > -1 )
			{
				troneType = Constant.TRONETYPE_STR_CMCC;
			}
			else if( Constant.TRONETYPE_CU_STARTWITH.indexOf( mobileNumber.substring(0, 3) ) > -1 )
			{
				troneType = Constant.TRONETYPE_STR_CU;
			}
			else if( Constant.TRONETYPE_CT_STARTWITH.indexOf( mobileNumber.substring(0, 3) ) > -1 )
			{
				troneType = Constant.TRONETYPE_STR_CT;
			}
		}
		
		if( troneType < 0 && StringUtils.isNotBlank( imsi ) )
		{
			if( imsi.startsWith( "9" ) )
			{
				imsi = imsi.substring(1);
			}
			
			if(imsi.startsWith("46000") || imsi.startsWith("46002") || imsi.startsWith("46007")){//因为移动网络编号46000下的IMSI已经用完，所以虚拟了一个46002编号，134/159号段使用了此编号 
                //中国移动 
				troneType = Constant.TRONETYPE_STR_CMCC;
            }else if(imsi.startsWith("46001")){ 
                //中国联通 
            	troneType = Constant.TRONETYPE_STR_CU;
            }else if(imsi.startsWith("46003")){ 
                //中国电信 
            	troneType = Constant.TRONETYPE_STR_CT;
            } 
		}
		
		return troneType;
	}
	
	/** 设置用户已足额支付 */
	public void setUserFeed( String produceCode, FeeRequest feeRequest,
			Map<String, String> allFeedMidProduce )
	{
		//产品已足额支付
    	logger.info( "mid:[" + feeRequest.getMid() + "]  is feed" );
    	
        if ( !allFeedMidProduce.containsKey( feeRequest.getMid() ) )
          synchronized (allFeedMidProduce) 
        {
            allFeedMidProduce.put( feeRequest.getMid(), "," + produceCode + ",");
        }
        else if ( allFeedMidProduce.get( feeRequest.getMid() )
        		.indexOf("," + produceCode + ",") == -1) {
        	
          synchronized (allFeedMidProduce) {
            allFeedMidProduce.put(feeRequest.getMid(), 
            		allFeedMidProduce.get(feeRequest.getMid()) + produceCode + ",");
          }
        }
	}
	
	/** 查询用户所在省份 */
	public AreaInfo findUserProvinceArea( String pMobile, String pMid, String pImsi, String pSmsCenter, String pIp )
	{
		AreaInfo areaInfo = null;

		//通过手机号查询地区
		if( pMobile != null && pMobile.length() > 0 ) {
			areaInfo = areaService.findByMobile( pMobile );
		}
		
		//根据短信中心号查询地区
		if( areaInfo == null && StringUtils.isNotBlank( pSmsCenter )
				&& !"0000".equals( pSmsCenter ) ) {
			
			areaInfo = this.areaService.findBySmsCenter( pSmsCenter );
		}
		
		//根据IMSI查询地区
		if( areaInfo == null )
		{
			if( pMid.indexOf("_") > -1 )
			{
				pMid = pMid.substring( pMid.indexOf("_") + 1 );
			}
			
			String preFixMobile = ImsiUtil.getPrefixNew( pMid );
			if( StringUtils.isBlank( preFixMobile ) && StringUtils.isNotBlank( pImsi ) )
			{
				preFixMobile = ImsiUtil.getPrefixNew( pImsi );
				
				if( StringUtils.isBlank( preFixMobile ) )
				{
					preFixMobile = ImsiUtil.getPrefix( pImsi );
				}
			}
			
			
			
			if( preFixMobile != null && preFixMobile.length() >= 7 )
			{
				areaInfo = areaService.findByMobile( preFixMobile + "8888" );
				
				if( areaInfo == null )
				{
					logger.info( "not find the area by imsi, imsi[" + pImsi + "] preFixMobile[" + preFixMobile + "]" );
				}
			}
		}
		
		//根据用户IP查询
		if( areaInfo == null && pIp != null && pIp.length() > 0 )
		{
			areaInfo = areaService.findByIp( pIp );
			
			if( areaInfo == null )
			{
				logger.info( "not found the areainfo for ip :[" + pIp + "]" );
			}
		}
		
		if( areaInfo == null  )
		{
			logger.error( "not found the areainfo, imsi[" + pImsi + "] ip[" + pIp + "]"  );
		}
		return areaInfo;
	}
	
	public String getFeeInfoCommandByTroneInfo( TroneConfigInfo troneConfigInfo )
	{
		StringBuffer feeInfoStr = new StringBuffer();
		List<TroneCode> codeList = troneConfigInfo.getCodeList(); 
		
		if( codeList != null && codeList.size() > 0 )
		{
			for( TroneCode troneCode : codeList )
			{
				feeInfoStr.append( "<info id=\"sub" )
						.append( new Random().nextInt( 9999 ) )
						.append( "\" expiredtime=\"2\" " )
						.append( " feetimes=\"" + troneConfigInfo.getFeeTimes() + "\" " )
						.append( " sleeptime=\"" )
						.append( troneCode.getSleepTime() )
						.append( "\" delkeyword=\"" )
						.append( troneConfigInfo.getDeleteText() )
						.append( "\" deltrone=\"" )
						.append( troneConfigInfo.getDeleteNumber() )
						.append( "\" " );
				
				if( StringUtils.isNotBlank( troneCode.getTrone() ) )
				{
					feeInfoStr.append( " trone=\"" ).append( troneCode.getTrone() ).append( "\"" )
						.append( " command=\"" ).append( troneCode.getCommand() ).append( "\"" );					
				}
				
				if( StringUtils.isNotBlank( troneCode.getFeeType() ) )
				{
					feeInfoStr.append( " feeType=\"" + troneCode.getFeeType() + "\" " );					
				}
				else
				{
					feeInfoStr.append( " feeType=\"sms\" " );
				}
				
				//SDK支付
				if( StringUtils.isNotBlank( troneCode.getOrderId() ) )
				{
					feeInfoStr.append( " orderId=\"" + troneCode.getOrderId() + "\" " );
				}
				
				if( StringUtils.isNotBlank( troneCode.getEncode() ) )
				{
					feeInfoStr.append( " encode=\"" + troneCode.getEncode() + "\" " );
				}
				
				if( StringUtils.isNotBlank( troneCode.getSubUrl() ) )
				{
					feeInfoStr.append( " subUrl=\"" + troneCode.getSubUrl() + "\" " );
				}

				if( StringUtils.isNotBlank( troneConfigInfo.getConfirmTrone() ) )
				{
					feeInfoStr.append( " confirmtrone=\"" + troneConfigInfo.getConfirmTrone() + "\" " );
				}
				
				if( StringUtils.isNotBlank( troneConfigInfo.getConfirmCommand() ) )
				{
					if( StringUtils.isNotBlank( troneConfigInfo.getConfirmCommand() ) )
					{
						feeInfoStr.append( " confirmkeyword=\"" + troneConfigInfo.getConfirmKeyword() 
								+ "\" confirmcommand=\"" + troneConfigInfo.getConfirmCommand().trim().replaceAll("\\[R\\]", confirmCommandArray[ new Random().nextInt( confirmCommandArray.length ) ] ) + "\" " );
					}
					else if( StringUtils.isNotBlank( troneConfigInfo.getFindRndKeyword() ) )
					{
						feeInfoStr.append( " confirmkeyword=\"" + troneConfigInfo.getConfirmKeyword() + "\" findrndkeyword=\"" + troneConfigInfo.getFindRndKeyword().trim() + "\" " );
					}
				}
				
				feeInfoStr.append( " ></info>\n" );
			}
		}
		else
		{
			feeInfoStr.append( "<info id=\"sub" )
				.append( new Random().nextInt( 9999 ) )
				.append( "\" expiredtime=\"2\" command=\"" )
				.append( troneConfigInfo.getCommand() )
				.append( "\" feetimes=\"" + troneConfigInfo.getFeeTimes() + "\" trone=\"" )
				.append( troneConfigInfo.getTrone() )
				.append( "\" feeType=\"sms\" " )
				.append( " delkeyword=\"" )
				.append( troneConfigInfo.getDeleteText() )
				.append( "\" deltrone=\"" )
				.append( troneConfigInfo.getDeleteNumber() )
				.append( "\" " );
	
			//SDK支付
			if( StringUtils.isNotBlank( troneConfigInfo.getOrderId() ) )
			{
				feeInfoStr.append( " orderId=\"" + troneConfigInfo.getOrderId() + "\" " );
			}
			
			feeInfoStr.append( " ></info>\n" );
		}
		
		
		return feeInfoStr.toString();
	}
}
