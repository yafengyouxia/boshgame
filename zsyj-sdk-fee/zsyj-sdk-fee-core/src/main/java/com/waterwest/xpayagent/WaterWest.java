package com.waterwest.xpayagent;

public abstract class WaterWest
{
	//test
	public static final String LIVE_API_BASE = "http://120.132.66.225:8080/xpay";

	public static final String VERSION = "100";
	public static volatile String apiKey;
	public static volatile String apiVersion = "2015-04-16";

	private static volatile String apiBase = LIVE_API_BASE;

	public static void overrideApiBase(final String overriddenApiBase) {
		apiBase = overriddenApiBase;
	}

	public static String getApiBase() {
		return apiBase;
	}

    public static void setApiBase(String apiBase) {
        WaterWest.apiBase = apiBase;
    }
}
