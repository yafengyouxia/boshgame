package com.zsyj.fee.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.zsyj.fee.entity.SdkStrategy;

/**
 * 计费策略
 * */
public class PayStrategy extends SdkStrategy implements Serializable  {

	private static final long serialVersionUID = 8243258755345508957L;

	public static PayStrategy getDefaultInstance()
	{
		PayStrategy sdkStrategy = new PayStrategy();
		sdkStrategy.setName( "default" );
		sdkStrategy.setCode( "default" );
		sdkStrategy.setFeeLimitDay( 20 );
		sdkStrategy.setFeeLimitMonth( 50 );
		sdkStrategy.setConfirmDialogType( (byte)0 );
		sdkStrategy.setIsFreshOne( (byte)0 );
		return sdkStrategy;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
