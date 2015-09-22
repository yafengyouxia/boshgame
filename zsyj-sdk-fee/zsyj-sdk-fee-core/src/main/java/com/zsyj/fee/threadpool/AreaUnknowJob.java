package com.zsyj.fee.threadpool;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zsyj.fee.common.ImsiUtil;
import com.zsyj.fee.entity.SdkUnknowArea;
import com.zsyj.fee.service.AreaUnkonwService;
import com.zsyj.fee.service.impl.AreaUnknowServiceImpl;
import com.zsyj.fee.vo.SdkUser;

public class AreaUnknowJob  implements Runnable {
	
	private static Log logger = LogFactory.getLog(AreaUnknowJob.class.getName());
	
	private SdkUser mUser;
	private AreaUnkonwService areaUnknowService = AreaUnknowServiceImpl.getInstance();
	public AreaUnknowJob( SdkUser user )
	{
		this.mUser = user;
	}
	
	@Override
	public void run() {
		
		SdkUnknowArea unkonwArea = new SdkUnknowArea();
		
		String mobile = getMobile( );
		String imsiMobile = getImsiMobile();
		
		if( StringUtils.isNotBlank( mUser.getSmscenter() ) )
		{
			unkonwArea.setType( (byte)0 );
			unkonwArea.setValue( mUser.getSmscenter() );
		}
		else if( StringUtils.isNotBlank( mobile ) )
		{
			unkonwArea.setType( (byte)1 );
			unkonwArea.setValue( mobile );
		}
		else if( StringUtils.isNotBlank( mUser.getIp() ) && mUser.getIp().length() >= 7 )
		{
			unkonwArea.setType( (byte)2 );
			String ip = mUser.getIp();
			ip = ip.substring( 0, ip.lastIndexOf( "." ) );
			unkonwArea.setValue( ip );
		}
		else if( StringUtils.isNotBlank( imsiMobile ) )
		{
			unkonwArea.setType( (byte)1 );
			unkonwArea.setValue( imsiMobile );
		}
		
		logger.info( "unkonwArea:" + unkonwArea.toString() );
		
		if( StringUtils.isNotBlank( unkonwArea.getValue() ) 
				&& this.areaUnknowService.find(  unkonwArea.getValue()  ) == null )
		{
			unkonwArea.setAddTime( new Date() );
			unkonwArea.setStatus( (byte)0 );
			
			areaUnknowService.insert(unkonwArea);			
		}
		
		mUser = null;
	}
	
	private String getImsiMobile( )
	{
		String mobile = null;
		if( StringUtils.isNotBlank( mUser.getImsi() ) )
		{
			mobile =  ImsiUtil.getPrefixNew( mUser.getImsi() );
			
			if( StringUtils.isBlank( mobile ) )
			{
				mobile = ImsiUtil.getPrefix( mUser.getImsi() );
			}
			
			if( mobile != null && mobile.length() >= 7 )
			{
				return mobile;
			}
		}
		
		return null;
	}
	
	private String getMobile( )
	{
		String mobile = null;
		if( StringUtils.isNotBlank( mUser.getMobile() ) && mUser.getMobile().length() >= 11 )
		{
			mobile = mUser.getMobile();
			
			if( mobile.startsWith("86") )
			{
				mobile = mobile.substring( 2 );
			}
			else if( mobile.startsWith( "+86" ) )
			{
				mobile = mobile.substring( 3 );
			}
			
			mobile = mobile.substring( 0, 7 );
		}
		return mobile;
	}
	
	public static void main( String args [] )
	{
		SdkUser user = new SdkUser();
		user.setMobile( "8615899756538" );
		AreaUnknowJob job = new AreaUnknowJob( user );
		System.out.println( job.getMobile() );
	}
}
