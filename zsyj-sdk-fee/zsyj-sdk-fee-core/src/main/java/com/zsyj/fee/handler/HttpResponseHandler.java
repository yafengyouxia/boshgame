package com.zsyj.fee.handler;

import org.apache.http.HttpResponse;

public abstract class HttpResponseHandler {

	public abstract void handler( HttpResponse response );
}