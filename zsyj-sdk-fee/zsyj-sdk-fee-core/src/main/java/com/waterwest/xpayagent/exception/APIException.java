package com.waterwest.xpayagent.exception;

public class APIException extends WaterWestException {

	private static final long serialVersionUID = 1L;

	public APIException(String message, Throwable e) {
		super(message, e);
	}

}
