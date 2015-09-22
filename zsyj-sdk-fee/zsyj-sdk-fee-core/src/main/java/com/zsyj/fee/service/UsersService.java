package com.zsyj.fee.service;

import com.zsyj.fee.vo.FeeRequest;
import com.zsyj.fee.vo.SdkUser;

public interface UsersService {

	public SdkUser findByUuid( String uuid );
	
	public SdkUser findByImsi( String imsi );
	
	public boolean addNewUser( SdkUser user);
	
	public boolean updateUser( SdkUser user );
	
	public SdkUser handlerUserInfoByFeeRequest( FeeRequest feeRequest );
}
