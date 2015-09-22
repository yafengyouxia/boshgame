package com.waterwest.xpayagent.exception;

public abstract class WaterWestException extends Exception {

	public WaterWestException(String message) {
		super(message, null);
	}

	public WaterWestException(String message, Throwable e) {
		super(message, e);
	}

	private static final long serialVersionUID = 1L;

}
