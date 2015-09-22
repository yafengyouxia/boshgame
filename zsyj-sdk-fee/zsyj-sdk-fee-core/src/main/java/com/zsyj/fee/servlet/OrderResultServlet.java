  package com.zsyj.fee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsyj.fee.handler.FeeRequestFactory;
import com.zsyj.fee.service.OrderLogService;
import com.zsyj.fee.service.impl.OrderLogServiceImpl;
import com.zsyj.fee.vo.FeeRequest;

public class OrderResultServlet extends HttpServlet  {
	
	private static final long serialVersionUID = -2974176115621449280L;

	private static final Logger logger = LoggerFactory.getLogger(OrderResultServlet.class);
	
	private FeeRequest feeRequest = null;
	private OrderLogService orderLogService = OrderLogServiceImpl.getInstance();
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException        
	{
		logger.info( " ======== upload order status " );
		
		this.feeRequest = FeeRequestFactory.create( req );
		
		try
		{
			if( StringUtils.isNotBlank( this.feeRequest.getOrderId() ) )
			{
				logger.info( "the order:" + feeRequest.getOrderId() + " is send sms status:" +  req.getParameter( "status" ) + "!" );
				String status = req.getParameter( "status" )==null?"-1":req.getParameter( "status" );
				
				//将订单状态更新为成功
				orderLogService.updateStatusByOrderId( this.feeRequest.getOrderId(), Integer.valueOf( status ) );
			}
			else
			{
				logger.error( "the orderid is null!" );
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
			logger.error( e.getMessage() );
		}
		
		resp.getWriter().print( "{\"result\":\"0\"}" );
	}
}
