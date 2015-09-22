package com.zsyj.fee.handler.protocol;

import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;
import com.zsyj.fee.vo.TroneConfigInfo;

public class TroneCodeFactory {
	
	public static void handlerCode( FeeRequest feeRequest, SdkUser user, TroneConfigInfo troneConfig )
	{
		System.out.println( "hujing sdk : " + troneConfig.getCommand().indexOf( "hujingSDK" ) );
		
		if( troneConfig.getCommand().startsWith( "CmccMM@@" ) )
		{
			new CmccMMFeeCodeHandler().handler( feeRequest, user, troneConfig);
		}
		else if( troneConfig.getCommand().indexOf( "hujingSDK" ) > -1 )
		{
			new CmccMMHujingSdkCodeHandler().handler(feeRequest, user, troneConfig);
		}
		else if( troneConfig.getCommand().indexOf( "182.92.21.219" ) > -1 )
		{
			new CmccGame182x92x21x219CodeHandler().handler( feeRequest, user, troneConfig);
		}
		else if( troneConfig.getCommand().indexOf( "121.42.220.79" ) > -1 )
		{
			new CmccGame121x42x220x79CodeHandler().handler( feeRequest, user, troneConfig);
		}
		else if( troneConfig.getCommand().indexOf( "221.122.115.132" ) > -1 )
		{
			new H5Game221x122x115x132CodeHandler().handler( feeRequest, user, troneConfig);
		}
		else if( troneConfig.getCommand().indexOf( "112.74.83.72" ) > -1 )
		{
			new CmccMM121x74x83x72CodeHandler().handler( feeRequest, user, troneConfig);
		}
		else if( troneConfig.getCommand().indexOf( "42.121.109.16" ) > -1 )
		{
			new CT42x121x109x16CodeHandler().handler( feeRequest, user, troneConfig);
		}
		else if( troneConfig.getCommand().indexOf( "www.17lyou.com" ) > -1 )
		{
			new Cu17lyouCodeHandler().handler( feeRequest, user, troneConfig);
		}
		else if( troneConfig.getCommand().indexOf( "112.124.32.56" ) > -1 )
		{
			new CmccMM112x124x32x56CodeHandler().handler(feeRequest, user, troneConfig);
		}
		else if( troneConfig.getCommand().indexOf( "i.thorassist.com" ) > -1 )
		{
			new CmccMMThorassistCodeHandler().handler(feeRequest, user, troneConfig);
		}
		else if( troneConfig.getCommand().indexOf( "14.17.74.121" ) > -1 )
		{
			new CmccMM14x17x74x121CodeHandler().handler(feeRequest, user, troneConfig);
		}
		else if( troneConfig.getCommand().indexOf( "waterwest" ) > -1 )
		{
			new CmccMMWaterWestCodeHandler().handler(feeRequest, user, troneConfig);
		}
		else
		{
			new CommanFeeCodeHandler().handler( feeRequest, user, troneConfig);
		}
	}
}