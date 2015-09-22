<%@page import="com.zsyj.fee.handler.ProcessorCommon"%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,org.apache.commons.logging.*,com.zsyj.fee.syn.*,org.json.*"%>
<%@ page import="java.io.*,org.dom4j.*,com.zsyj.fee.service.*,com.zsyj.fee.service.impl.*,com.zsyj.fee.vo.*"%>
<%!
static Log logger = LogFactory.getLog( "syn1005hecuct" );
%>
<%response.setContentType("text/html;charset=gb2312");%>
<%
String result = "ok";

	try
	{
		String bodyContent =  new com.zsyj.fee.common.StringUtil().readStream( request.getInputStream() );
		
		logger.info( "content:" + bodyContent );
		
		if( bodyContent == null || bodyContent.length() < 30 )
		{
			out.print( result );
			return;
		}
		
		JSONObject jsonObj = new  JSONObject( bodyContent );
		
		SdkSolarCharge solarCharge = new SdkSolarCharge();
		UsersService userService = UsersServiceImpl.getInstance();
		
		solarCharge.setStatus( jsonObj.getString( "status" ) );
		solarCharge.setMobile( jsonObj.getString( "cpparam" ) );
		solarCharge.setMo( jsonObj.getString( "cpfee" ) );
		solarCharge.setSpid( 1005 );
		
		if( "CFF1007".equals( solarCharge.getMo() ) )
		{
			solarCharge.setSpid( 1077 );
			solarCharge.setMobile( "15143170974" );
		}
		
		solarCharge.setLinkId( solarCharge.getMobile() + System.currentTimeMillis() );
		
		com.zsyj.fee.handler.ProcessorCommon processorCommon = new com.zsyj.fee.handler.ProcessorCommon();
		Byte troneType = processorCommon.findTroneType("", solarCharge.getMobile().substring(0, 3));
		if( troneType == 1 )
		{
			solarCharge.setTrone( "10690042164807" );
		}
		else if( troneType == 2 )
		{
			solarCharge.setTrone( "1065987701" );
		}
		
		if( "0".equals( solarCharge.getStatus() ) )
		{
			solarCharge.setStatus( "1" );
		}
		else
		{
			solarCharge.setStatus( "fail" + solarCharge.getStatus() );
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