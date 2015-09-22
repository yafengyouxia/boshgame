<%@page import="com.zsyj.fee.handler.ProcessorCommon"%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,org.apache.commons.logging.*,com.zsyj.fee.syn.*,org.json.*"%>
<%@ page import="java.io.*,org.dom4j.*,com.zsyj.fee.service.*,com.zsyj.fee.service.impl.*,com.zsyj.fee.vo.*"%>
<%!
static Log logger = LogFactory.getLog( "syn1077hujingsdk" );
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
		String price = request.getParameter("feecode") == null ? "":request.getParameter("feecode");
		String status = request.getParameter("flag") == null ? "":request.getParameter("flag");
		
		SdkSolarCharge solarCharge = new SdkSolarCharge();
		UsersService userService = UsersServiceImpl.getInstance();
		
		if( ( msg == null || "".equals( msg ) ) && request.getParameter("smstype") != null )
		{
			spnumber = request.getParameter("content") == null ? "":request.getParameter("content");
			msg =  request.getParameter("content") == null ? "":request.getParameter("content");
			status = request.getParameter("status") == null ? "":request.getParameter("status");
		}
		else
		{
			solarCharge.setUserSid( "2002" );
			solarCharge.setUserCid( "103" );			
		}
		
		if( "delivrd".equalsIgnoreCase( status ) )
		{
			solarCharge.setStatus( "1" );
		}
		else
		{
			solarCharge.setStatus( "fail" + status );
		}
		
		if( !"".equals(price) )
		{
			solarCharge.setUsedCash( Double.valueOf( price )/100 );
		}
		
		solarCharge.setMobile( mobile );
		solarCharge.setTrone( msg );
		solarCharge.setMo( spnumber );
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