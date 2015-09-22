package com.zsyj.fee.common.enums;

public enum CacheEnum {
	
	ConfirmDialogArea( "confrim_dialog_area" ),
	
	SMS_CONFIGINFO( "dfsms_configinfo" ),
	
	TRONE_CONFIGINFO( "trone_configinfo" ),
	
	TRONE_FRESHPV( "trone_freshPV" ),
	
	TRONE_SPCOMPANY( "trone_spcompany" ),
	
	TRONE_STRATEGY( "trone_strategy" ),
	
	CFG_AGENT( "cfg_agent" ),
	
	CFG_AGENT_PROJECT( "cfg_agent_project" ),
	
	CFG_AREA_IPINFO( "cfg_area_ip" ),
	
	CFG_AREA_SUBMOBILE( "cfg_area_submobile" ),
	
	CFG_SUB_LIST( "cfg_sub_list" ),
	
	CFG_SMSCENTER( "cfg_smscenter" ),
	
	CFG_ALIGN( "cfgAlign" ),
	
	CFG_Produce( "cfgProduce" ),
	
	GROUPSMS_USERINFO( "groupUserInfo" ),
	
	SOLAR_CHARGE_LINKID( "solarcharge_linkId" ),
	
	LIMIT_SERVICECODE_LIST( "limitServiceCodeList" ),
	
	Strategy_Info( "strategy_info" ),
	
	Channel_Strategy( "channelStrategy" ),
	
	CFG_GROUPSUB_LIST( "cfgGroupSubList" ),
	
	//百度广告
	MEMCACHE_BDADVERT( "wap_baidu_" ),
	
    USER_MID ("userMid"),
    
    AGENT_ALL ("agent_all"),	//渠道列表
    
    MONITOR_ALL ("monitor_all"),	//渠道列表
    
    USER_MOBILE ("mobile"),
    
    ORDER_LOG ("order_log"),
    
    USER_IMSI ("userImsi"),
    
	USER_UUID ("userUuid");
	
    private String code;
    
    CacheEnum (String code) {
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
    
    public static void main( String args [] ) {
    	System.out.println( CacheEnum.CFG_GROUPSUB_LIST );
    }
}
