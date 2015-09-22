<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,org.apache.commons.logging.*,com.zsyj.fee.syn.*"%>
<%@ page import="java.io.*,org.dom4j.*,com.zsyj.fee.service.*,com.zsyj.fee.service.impl.*,com.zsyj.fee.vo.*"%>
<%!
static Log logger = LogFactory.getLog( "syn1007gzlhjk_sms" );
%>
<%response.setContentType("text/html;charset=gb2312");%>
<%
	String result = "ok";

	try
	{
		logger.info( "requestQuery:" + request.getQueryString() );
		
		String linkID = request.getParameter("Linkid") == null ? "":request.getParameter("Linkid");
		String spnumber = request.getParameter("Dest_Id") == null ? "":request.getParameter("Dest_Id");
		String msg = request.getParameter("MO_Msg") == null ? "":request.getParameter("MO_Msg");
		String mobile = request.getParameter("statphone") == null ? "":request.getParameter("statphone");
		String status = request.getParameter("stat") == null ? "":request.getParameter("stat");
		
		SdkSolarCharge solarCharge = new SdkSolarCharge();
		
		if( "DeliveredToTerminal".equals( status ) )
		{
			status = "1";
		}
		else
		{
			status = "-" + status;
		}
		
		solarCharge.setLinkId( linkID );
		solarCharge.setStatus( status );
		solarCharge.setTrone( spnumber );
		solarCharge.setMo( msg );
		solarCharge.setMobile( mobile );
		solarCharge.setSpid( 1007 );
		
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