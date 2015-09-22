package com.waterwest.xpayagent.model;

import java.util.Map;

import com.waterwest.xpayagent.exception.APIConnectionException;
import com.waterwest.xpayagent.exception.APIException;
import com.waterwest.xpayagent.exception.AuthenticationException;
import com.waterwest.xpayagent.exception.InvalidRequestException;


public interface MetadataStore<T> {
	Map<String, String> getMetadata();
	void setMetadata(Map<String, String> metadata);

	MetadataStore<T> update(Map<String, Object> params) throws AuthenticationException, InvalidRequestException,
		APIConnectionException, APIException;
	MetadataStore<T> update(Map<String, Object> params, String apiKey) throws AuthenticationException, InvalidRequestException,
		APIConnectionException, APIException;
}
