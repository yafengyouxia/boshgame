package com.zsyj.fee.handler.strategy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zsyj.fee.entity.SdkTroneStrategy;
import com.zsyj.fee.entity.CfgSpCompany;
import com.zsyj.fee.entity.LimitServicecode;
import com.zsyj.fee.handler.protocol.TroneCodeFactory;
import com.zsyj.fee.service.TroneConfigInfoService;
import com.zsyj.fee.service.TroneStrategyService;
import com.zsyj.fee.service.impl.LimitServiceCodeServiceImpl;
import com.zsyj.fee.service.impl.SpCompanyServiceImpl;
import com.zsyj.fee.service.impl.TroneConfigInfoServiceImpl;
import com.zsyj.fee.service.impl.TroneStrategyServiceImpl;
import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneConfigInfo;
import com.zsyj.fee.vo.UserCash;

/**
 * 通道筛选策略
 * @author hujian
 */
public class TroneFilterStrategy {

	private static Log logger = LogFactory.getLog(TroneFilterStrategy.class.getName());
	
	private TroneConfigInfoService troneConfigInfoService = TroneConfigInfoServiceImpl.getInstance();
	
	private SdkUser user;
	private double balance = 0;   	//剩余金额
	private UserCash userCash; 
	private FeeRequest feeRequest;
	private Map<Integer, SdkTroneStrategy> sdkTroneStrategyMap;
	
	private List<String> usedMasterSpList = new ArrayList<String>();    //已经被选择的通道所属materSp
	private Map<Integer, CfgSpCompany> spMap = null;
	
	public TroneFilterStrategy()
	{
		this.spMap = SpCompanyServiceImpl.getInstance().findAll();
		this.sdkTroneStrategyMap = TroneStrategyServiceImpl.getInstance().findAll();
	}
	
	/**
	 * 轮询每个配置方案组中的配置方案，满足用户地区和限制条件的
	 * @param groupSubList
	 * @param feeInfo
	 * @return
	 */
	public List<TroneConfigInfo> findUsefulTrone( double balance, SdkUser user,
			UserCash userCash )
	{
		this.user = user;
		this.userCash = userCash;
		this.balance = balance;
		
		//从开启通道中查找符合条件的通道进行道具计费
		return this.getUsefulTroneList( );
	}
	
	/**
	 * 轮询每个配置方案组中的配置方案，满足用户地区和限制条件的
	 * @param groupSubList
	 * @param feeInfo
	 * @return
	 */
	public List<TroneConfigInfo> findUsefulTrone( FeeRequest feeRequest, SdkUser user, UserCash userCash )
	{
		this.user = user;
		this.userCash = userCash;
		this.balance = feeRequest.getItemPrice();
		this.feeRequest = feeRequest;
		
		//根据限制条件和屏蔽地区判断渠道是否可用
		List<TroneConfigInfo> availableTroneList = this.getUsefulTroneList();
		
		//根据权重来挑选合适的通道
		availableTroneList = this.chooseByStrategy( availableTroneList );
		
		//添加刷一毛钱的代码
		if( this.user.getTroneType() == 0 )
		{
			TroneConfigInfo freshPVTrone = this.findFreshPvTrone( );
			
			if( freshPVTrone != null )
			{
				logger.info( "find the fresh pv trone:" + freshPVTrone.toString() );
				availableTroneList.add(freshPVTrone);
			}
		}
		
		return availableTroneList;
	}
	
	/** 检查配置方案是否符合日月限，同时计算订购次数 */
	private List<TroneConfigInfo> getUsefulTroneList( )
	{
		//开启的通道
		List<TroneConfigInfo> openTroneList = this.troneConfigInfoService.getTroneList( 0 );
		List<TroneConfigInfo> availableTroneList = new ArrayList<TroneConfigInfo>(  );
		
		if( openTroneList != null && openTroneList.size() > 0 )
		{
			Map<String, LimitServicecode> serviceCodeLimitMap = LimitServiceCodeServiceImpl.getInstance().findAll();
			
			for( TroneConfigInfo troneInfo : openTroneList )
			{
				//判断代码是否在指定渠道投放
				if( StringUtils.isNotBlank( troneInfo.getSidCidOnly() ) && troneInfo.getSidCidOnly().trim().length() > 2 )
				{
					if( troneInfo.getSidCidOnly().indexOf( this.user.getSid() + this.user.getCid() ) < 0 
							&& troneInfo.getSidCidOnly().indexOf( this.user.getSid() + "," ) < 0 )
					{
						continue;
					}
				}
				
				if( !isContainsArea( troneInfo, sdkTroneStrategyMap ) )
				{
					//logger.debug( "don't contain the area:" + troneInfo.getCommand() + "  TroneStrategyId:" + troneInfo.getTroneStrategyId() );
					continue;
				}
				
				if( balance > 0 && balance >=  troneInfo.getFee( )
						&& user.getTroneType( ).compareTo( troneInfo.getTroneType( ) ) == 0 )
				{
					//当订购金额大于1时不选用小于1元的代码
					if( troneInfo.getFee() < 1 && balance >= 1 )
					{
						continue;
					}
					
					//根据各种限制条件判断该通道是否可用
					if( ( troneInfo = this.limitByTroneConfig( troneInfo, serviceCodeLimitMap ) ) == null )
					{
						continue;
					}
					
					//logger.info( "balance[" + balance + "] imsi[" + this.feeRequest.getImsi() + "] start choose the troneInfo : " + troneInfo.toString() );
					
					availableTroneList.add( troneInfo );
				}
			}
		}
		
		return availableTroneList;
	}
	
	/**
	 * @param troneInfo
	 * @return  true 包含用户省份   false 不包含用户省份
	 */
	private boolean isContainsArea( TroneConfigInfo troneInfo, Map<Integer, SdkTroneStrategy> sdkTroneStrategyMap )
	{
		boolean result = false;
		
		//如果通道策略组不为空，则使用通道策略组
		if( troneInfo.getTroneStrategyId() != null && troneInfo.getTroneStrategyId() > 0 )
		{
			SdkTroneStrategy sdkTroneStrategy = sdkTroneStrategyMap.get( troneInfo.getTroneStrategyId() );
			
			if( sdkTroneStrategy != null 
					&& StringUtils.isNotBlank( sdkTroneStrategy.getAreaCode() )
						&&  sdkTroneStrategy.getAreaCode().indexOf( user.getAreaCode() ) > -1 )
			{
				logger.debug( " imsi[" + this.feeRequest.getImsi() + "] the user province is invalid:" + sdkTroneStrategy.toString() );
				
				result = true;
			}
		}
		else
		{
			result = troneInfo.getAreaTable().containsKey( user.getAreaCode() );
		}
		
		return result;
	}
	
	//分类通道各个价格的通道和权重总和
	private void classifiedTroneList( List<TroneConfigInfo> availableTroneList, 
			List<Double> priceList, Map<Double, Integer> totalRateMap, Map<Double, List<TroneConfigInfo> > usefulTroneMap  )
	{
		for( TroneConfigInfo troneInfo : availableTroneList )
		{
			if( !priceList.contains( troneInfo.getFee() ) )
			{
				priceList.add( troneInfo.getFee() );			
			}
			
			if( usefulTroneMap.get( troneInfo.getFee() ) == null )
			{
				usefulTroneMap.put( troneInfo.getFee(), new ArrayList<TroneConfigInfo>() );
			}
			
			if( totalRateMap.get( troneInfo.getFee() ) == null )
			{
				totalRateMap.put( troneInfo.getFee(), 0 );
			}
			
			usefulTroneMap.get( troneInfo.getFee() ).add( troneInfo );
			totalRateMap.put( troneInfo.getFee(),  totalRateMap.get( troneInfo.getFee() ) + troneInfo.getWeight() );			
		}
	}
	
	/**
	 * 根据各种策略选择通道
	 * 然后根据当前策略判断是否可以加入0.01元刷量代码
	 * */
	private List<TroneConfigInfo> chooseByStrategy( List<TroneConfigInfo> availableTroneList )
	{
		if( availableTroneList == null || availableTroneList.size() == 0  )
		{
			return availableTroneList;
		}

		List<Double> priceList = new ArrayList<Double>(  );
		Map<Double, Integer> totalRateMap = new HashMap<Double, Integer>();
		Map<Double, List<TroneConfigInfo> > usefulTroneMap = new HashMap<Double, List<TroneConfigInfo>>( );
		
		this.classifiedTroneList( availableTroneList, priceList, totalRateMap, usefulTroneMap );
		
		List<TroneConfigInfo> useTroneList = new ArrayList<TroneConfigInfo>();
		
		if( priceList.size() > 0 )
		{
			List<TroneConfigInfo> tmpTroneList = null;
			List<Integer> usedSpList = new ArrayList<Integer>();    	//已经被选择的通道所属sp
			
			for( Double tronePrice : priceList )
			{
				if( balance <= 0 )
				{
					break;
				}
				
				if( tronePrice > this.balance )
				{
					continue;
				}
				
				tmpTroneList = usefulTroneMap.get( tronePrice );
				
				int begRate = 0;
				int keyRate = new Random().nextInt( totalRateMap.get(tronePrice) );
				
				for( TroneConfigInfo tmpTrone : tmpTroneList )
				{
					if( this.balance <= 0 )
					{
						break;
					}

					begRate += tmpTrone.getWeight();
					
					if( tmpTrone.getFee() > this.balance )
					{
						logger.debug( "tmpTrone fee[" + tmpTrone.getFee() + "]  imsi[" + this.feeRequest.getImsi() + "]  more than balance:" + this.balance );
						continue;
					}
					
					//logger.info( " begRate[" + begRate + "] keyRate[" + keyRate + "]" );
					
					//按照权重比例去分配,随机的权重keyRate超出begRate范围
					if( tronePrice*tmpTroneList.size() >= this.balance*2 && begRate < keyRate )
					{
						logger.debug( " imsi[" + this.feeRequest.getImsi() + "] trone[" + tmpTrone.getServiceCode() + "] not choose by rate" );
						continue;
					}

					CfgSpCompany spCompany = spMap.get( Integer.valueOf( tmpTrone.getSpId() ) );
					
					//相同sp的代码尽量不分配在一起
					if( spCompany != null 
							&& StringUtils.isNotBlank( spCompany.getMasterId() )
							&& usedSpList.contains( Integer.valueOf( tmpTrone.getSpId() ) ) )
					{
						logger.debug( " imsi[" + this.feeRequest.getImsi() + "] the spid have used, spId[" + tmpTrone.getSpId() + "]" );
						continue;
					}
					else
					{
						usedSpList.add( Integer.valueOf( tmpTrone.getSpId() ) );						
					}
					
					if( this.user.getTroneType() == 0 
							&& spCompany != null 
							&& StringUtils.isNotBlank( spCompany.getMasterId() ) )
					{
						if( usedMasterSpList.contains( spCompany.getMasterId() ) )
						{
							logger.debug( "  imsi[" + this.feeRequest.getImsi() + "]  the masterSpid have used, masterSpid[" + spCompany.getMasterId() + "]" );
							continue;							
						}
						else
						{
							usedMasterSpList.add( spCompany.getMasterId() );
						}
					}
					
					TroneCodeFactory.handlerCode( this.feeRequest, user, tmpTrone );
					
					if( tmpTrone.getCodeList().size() <= 0 )
					{
						logger.error( "  imsi[" + this.feeRequest.getImsi() + "]  the trone {" + tmpTrone.toString() + "} get code failed " );
						continue;
					}
					
					useTroneList.add( tmpTrone );
					
					balance = balance - tmpTrone.getFee();	
					
					logger.info( "  imsi[" + this.feeRequest.getImsi() + "]  current balance[" + balance + "], choose the trone:" + tmpTrone.getName() + " command:" + tmpTrone.getCommand() );
				}
				
				if( useTroneList.size() >= 2 )
				{
					logger.debug( "the selected trone is too more than 2 " );
					break;
				}
			}
		}
		
		return useTroneList;
	}
	
	/**
	 * 检查计费指令是否符合限制条件
	 * @param feeCaseInfo
	 * @param troneConfigInfo
	 * @param user
	 * @param currentMonthMoidmapLog key:feecaseid value:moidmoney
	 * @return
	 */
	private TroneConfigInfo limitByTroneConfig( TroneConfigInfo troneConfigInfo, Map<String, LimitServicecode> serviceCodeLimitMap )
	{
		//配置方案单价高于余额
		if( troneConfigInfo.getFee().compareTo( balance ) > 0 || serviceCodeLimitMap == null ) 
		{
			return null;
		}
		
		LimitServicecode serviceCodeLimit = serviceCodeLimitMap.get( troneConfigInfo.getServiceCode() );
		
		if( serviceCodeLimit != null )
		{
			//屏蔽地市
			if( ( serviceCodeLimit.getTelCode() != null ) 
            		&& ( serviceCodeLimit.getTelCode().indexOf( "," + user.getTelCode() + "," ) > -1) )
            {
				logger.info( "the trone[" + troneConfigInfo.getServiceCode() + "] telcode["+user.getTelCode()+"] is limit " );
				troneConfigInfo = null;
            }
			
			//屏蔽时段则不下发对应计费信息
			if( troneConfigInfo != null && StringUtils.isNotBlank( serviceCodeLimit.getCloseHour() )
					&& serviceCodeLimit.getCloseHour().indexOf( "," + Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + "," ) > -1 )
			{
				logger.info( "the trone[" + troneConfigInfo.getServiceCode() + "] hour["+Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+"] is limit " );
				troneConfigInfo = null;
			}
			
			if( troneConfigInfo != null )
			{
				int dayMoidSucCount = this.userCash.getCurrentTodayMoidmapLog().get( troneConfigInfo.getServiceCode() )==null?0:userCash.getCurrentTodayMoidmapLog().get( troneConfigInfo.getServiceCode() );
				
				int monthMoidSucCount = this.userCash.getCurrentMonthMoidmapLog().get( troneConfigInfo.getServiceCode() )==null?0:userCash.getCurrentMonthMoidmapLog().get( troneConfigInfo.getServiceCode() );
				
				//根据日限和余额计算订购次数
				if( troneConfigInfo != null && serviceCodeLimit.getLimitUserFeeDay() > 0
						&&serviceCodeLimit.getLimitUserFeeDay( ) <= dayMoidSucCount )
				{
					logger.info( "the trone[" + troneConfigInfo.getServiceCode() + "] dayMoidSucCount["+dayMoidSucCount+"] is limit " );
					troneConfigInfo = null;
				}
				
				//根据月限和余额计算订购次数
				if( troneConfigInfo != null && serviceCodeLimit.getLimitUserFeeMonth() > 0
						&& serviceCodeLimit.getLimitUserFeeMonth( ) <= monthMoidSucCount )
				{
					logger.info( "the trone[" + troneConfigInfo.getServiceCode() + "] monthMoidSucCount[" + monthMoidSucCount + "] is limit " );
					troneConfigInfo = null;
				}				
			}
		}
		else
		{
			logger.error( "not found the serviceCode:" + troneConfigInfo.getServiceCode() );
		}
		
		return troneConfigInfo;
	}
	
	//查询刷pv的通道
	public TroneConfigInfo findFreshPvTrone( )
	{
		TroneConfigInfo freshTrone = null;
		List<TroneConfigInfo> troneFreshList = TroneConfigInfoServiceImpl.getInstance().getFreshPvFreshList();
		
		Collections.shuffle(troneFreshList);
		
		if( troneFreshList != null && troneFreshList.size() > 0 )
		{
			for( TroneConfigInfo trone : troneFreshList )
			{
				//卡通文化：骑行小子	动网：剑刃风暴    惠州全信通：糖果梦境（夏日版）
				//除开以上三个SP，其他暂不全面开放
				if( this.balance <= 0 &&  "1070,1041,1055".indexOf( trone.getSpId() ) < 0 )
				{
					continue;
				}
				
				//本月已刷过的用户不在重复刷
				if( this.userCash.getCurrentMonthMoidmapLog().get( trone.getServiceCode() ) != null )
				{
					continue;
				}
				
				//判断代码是否在指定渠道投放
				if( StringUtils.isNotBlank( trone.getSidCidOnly() ) && trone.getSidCidOnly().trim().length() > 2 )
				{
					if( trone.getSidCidOnly().indexOf( this.user.getSid() + this.user.getCid() ) < 0 
							&& trone.getSidCidOnly().indexOf( this.user.getSid() + "," ) < 0 )
					{
						continue;
					}
				}
				
				if( !isContainsArea( trone, sdkTroneStrategyMap ) )
				{
					continue;
				}
				
				CfgSpCompany spCompany = spMap.get( Integer.valueOf( trone.getSpId( ) ) );
				
				if( spCompany != null 
						&& StringUtils.isNotBlank( spCompany.getMasterId() )
						&& !usedMasterSpList.contains( spCompany.getMasterId() ) )
				{
					logger.info( " start to get findFreshPvTrone " );
					
					TroneCodeFactory.handlerCode( this.feeRequest, user, trone );
					
					if( trone.getCodeList().size() > 0 )
					{
						freshTrone =  trone;
						break;
					}
				}
			}
		}
		
		return freshTrone;
	}
}