package com.zsyj.fee.service;

import java.util.List;

import com.zsyj.fee.entity.SdkConfirmDialogArea;
import com.zsyj.fee.vo.SdkUser;

public interface SdkConfirmDialogAreaService {

	public SdkConfirmDialogArea findById( int id );
	
	public SdkConfirmDialogArea findByUser( SdkUser user );
	
	public List<SdkConfirmDialogArea> findAll();
	
	public boolean update( SdkConfirmDialogArea sdkConfirmDialogArea );
}
