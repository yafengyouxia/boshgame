<%@page import="com.zsyj.fee.handler.ProcessorCommon"%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,org.apache.commons.logging.*,com.zsyj.fee.syn.*,org.json.*"%>
<%@ page import="java.io.*,org.dom4j.*,com.zsyj.fee.service.*,com.zsyj.fee.service.impl.*,com.zsyj.fee.vo.*"%>
<%!
static Log logger = LogFactory.getLog( "syn1026hujingcmcc" );
%>
<%response.setContentType("text/html;charset=gb2312");%>
<%
String result = "Ok";

	try
	{
		logger.info( "requestQuery:" + request.getQueryString() );
		
		String linkID = request.getParameter("linkid") == null ? "":request.getParameter("linkid");
		String spnumber = request.getParameter("spnumber") == null ? "":request.getParameter("spnumber");
		String msg = request.getParameter("momsg") == null ? "":request.getParameter("momsg");
		String mobile = request.getParameter("mobile") == null ? "":request.getParameter("mobile");
		String status = request.getParameter("flag") == null ? "":request.getParameter("flag");
		
		SdkSolarCharge solarCharge = new SdkSolarCharge();
		UsersService userService = UsersServiceImpl.getInstance();
		
		if( "delivrd".equals( status ) )
		{
			solarCharge.setStatus( "1" );
		}
		else
		{
			solarCharge.setStatus( "fail" + status );
		}
		
		solarCharge.setMobile( mobile );
		solarCharge.setTrone( spnumber );
		solarCharge.setMo( msg );
		solarCharge.setSpid( 1026 );
		solarCharge.setLinkId( linkID );
		
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