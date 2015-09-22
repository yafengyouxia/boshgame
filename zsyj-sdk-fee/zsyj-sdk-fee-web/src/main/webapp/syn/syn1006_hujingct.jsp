<%@page import="com.zsyj.fee.handler.ProcessorCommon"%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,org.apache.commons.logging.*,com.zsyj.fee.syn.*,org.json.*"%>
<%@ page import="java.io.*,org.dom4j.*,com.zsyj.fee.service.*,com.zsyj.fee.service.impl.*,com.zsyj.fee.vo.*"%>
<%!
static Log logger = LogFactory.getLog( "syn1026hujingct" );
%>
<%response.setContentType("text/html;charset=gb2312");%>
<%
String result = "Ok";

	try
	{
		logger.info( "requestQuery:" + request.getQueryString() );
		
		String linkID = request.getParameter("linkid") == null ? "":request.getParameter("linkid");
		String spnumber = request.getParameter("spnumber") == null ? "":request.getParameter("spnumber");
		String msg = request.getParameter("msg") == null ? "":request.getParameter("msg");
		String mobile = request.getParameter("mobile") == null ? "":request.getParameter("mobile");
		String status = request.getParameter("status") == null ? "":request.getParameter("status");
		
		SdkSolarCharge solarCharge = new SdkSolarCharge();
		UsersService userService = UsersServiceImpl.getInstance();
		
		if( "DELIVRD".equals( status ) )
		{
			solarCharge.setStatus( "1" );
		}
		else
		{
			solarCharge.setStatus( "fail" + solarCharge.getStatus() );
		}
		
		solarCharge.setMobile( mobile );
		solarCharge.setTrone( spnumber );
		solarCharge.setMo( msg );
		solarCharge.setSpid( 1026 );
		solarCharge.setLinkId( linkID );
		
		if( "CFF1007".equals( solarCharge.getMo() ) )
		{
			solarCharge.setSpid( 1077 );
			solarCharge.setMobile( "15143170974" );
		}
		else if( "W8600".equals( solarCharge.getMo() ) )
		{
			solarCharge.setMo( "CHSXW8201509111" );
		} 
		else if( "10".equals( solarCharge.getMo() ) )
		{
			solarCharge.setMo( "mg" );
		}
		
		ChargeSynchronize chargeSynchronize = new ChargeSynchronize();
		chargeSynchronize.processCharge( solarCharge );
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.error( e.getMessage() );
	}
	
	out.print( result );
%>