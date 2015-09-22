package com.zsyj.fee.common.enums;

public enum StatisLogEnum{
    
    SUCC ("succ"),

    /** 该手机对应的sid\cid或者产品没有配置相应的计费信息 */
    NOCONFIG ("noconfig"),
    
    /** 手机黑名单 */
    BLACTMOBILE ("blackMobile"),
    
    /** sid,cid limit */
    LIMIT_SID_CID( "limit_sid_cid" ),
    
    /** serviceCode limit */
    LIMIT_SERVICECODE( "limit_serviceCode" ),
    
    /** no area */
    NOAREA( "no_area" ),
    
    /** 已达到计费上限 */
    FULL_FEE( "full_fee" );
    
    private String code;
    
    StatisLogEnum (String code) {
        if (code == null)
            throw new NullPointerException ("code should not be null");
        this.code = code;
    }
    
    /**
     * Returns the code representation of this enum.
     * 
     * @return
     */
    public String getCode () {
        return code;
    }
    
    public String toString() {
    	return code;
    }
}
