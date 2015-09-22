package com.zsyj.fee.common.enums;

public enum SdkResultEnum {
	
	SUCCESS( 0 ),	//成功
	
	 //{ "0成功", "1无配置", "2机型关闭", "3黑名单", "4厂商地区关闭", "5匹配不到地区", "6无通道", "7计费上限","8测试", "9请求参数错误"};
	
	FAIL_NoConfig( 1 ),  //无配置
	
	FAIL_CloseAPP( 2 ),  //应用关闭
	
	FAIL_Black( 3 ),    //黑名单
	
	FAIL_CloseChannel( 4 ),  //渠道关闭
	
	FAIL_NoArea( 5 ),   //找不到地区
	
	FAIL_NoCode( 6 ),   //找不到计费代码
	
	FAIL_MaxDayLimit( 7 ),  //日上限
	
	FAIL_MaxMonthLimit( 8 ), //月上限
	
	FAIL_Test( 9 ),    //测试
	
	FAIL_PayFrequent( 11 ), //订购太频繁
	
	FAIL_IdleTime( 12 ), //订购太频繁
	
	FAIL_ParamError( 10 );  //参数错误
	
    private Integer code;
    
    SdkResultEnum (Integer code) {
        if (code == null)
            throw new NullPointerException ("code should not be null");
        this.code = code;
    }
    
    /**
     * Returns the code representation of this enum.
     * 
     * @return
     */
    public Byte getCode () {
        return code.byteValue();
    }
    
    public static void main( String args [] ) {
    	System.out.println( SdkResultEnum.FAIL_CloseChannel );
    }
}
