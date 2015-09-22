<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,org.apache.commons.logging.*,com.zsyj.fee.syn.*"%>
<%@ page import="java.io.*,org.dom4j.*,com.zsyj.fee.service.*,com.zsyj.fee.service.impl.*,com.zsyj.fee.vo.*"%>
<%!
static Log logger = LogFactory.getLog( "laoliangsyndata" );
%>
<%response.setContentType("text/html;charset=gb2312");%>
<%
	String TransactionID = "";
	try
	{
		logger.info( "requestQuery:" + request.getQueryString() );
		
		SdkSolarCharge solarCharge = new SdkSolarCharge();
		UsersService userService = UsersServiceImpl.getInstance();
		
		//OrderID=11150820151613495716&ActionTime=20150820151613&ChannelID=3004007333&TotalPrice=800&ExData=xxac_kwken_183_s_460022452553706&PayCode=30000892257403
		
		String linkId = request.getParameter( "OrderID" );
		String payCode = request.getParameter( "PayCode" );
		
		solarCharge.setTroneType( (byte)0 );
		solarCharge.setLinkId( linkId );
		solarCharge.setStatus( "1" );
		solarCharge.setAppId( payCode.substring(0, payCode.length() -2 ) );
		solarCharge.setTrone( payCode.substring(0, payCode.length() -2 ) );
		solarCharge.setMo( request.getParameter( "PayCode" ) );
		solarCharge.setUsedCash( Double.valueOf( request.getParameter( "TotalPrice" ) )/100 );
		solarCharge.setUserSid( request.getParameter( "ChannelID" ) );
				
		String exdata = request.getParameter( "ExData" ).replace("xxac_", "");
		solarCharge.setOrderId( exdata );
		
		DFChargeSynchronize chargeSynchronize = new DFChargeSynchronize();
		chargeSynchronize.processCharge( solarCharge, "" );
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.error( e.getMessage() );
	}

	String result = "OK";
	
	out.print( result );
%>