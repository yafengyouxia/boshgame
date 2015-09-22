<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,org.apache.commons.logging.*,com.zsyj.fee.syn.*"%>
<%@ page import="java.io.*,org.dom4j.*,com.zsyj.fee.service.*,com.zsyj.fee.service.impl.*,com.zsyj.fee.vo.*"%>
<%!
static Log logger = LogFactory.getLog( "1009szlongli" );
%>
<%response.setContentType("text/html;charset=gb2312");%>
<%
String result = "ok";

	try
	{
		//MDO synchronize mobile=13800138000&longnum=10658077696628&consumeCode=LQMDO_bb8a_3&fee=600&hret=0&status=&linkid=201505111722085850&cpparam=YX,259137,3,bb8a,1822058,628010&province=
		
		logger.info( "content:" + request.getQueryString() );
		
		SdkSolarCharge solarCharge = new SdkSolarCharge();
		UsersService userService = UsersServiceImpl.getInstance();
		
		solarCharge.setLinkId( request.getParameter( "linkid" ) );
		solarCharge.setStatus( request.getParameter( "hret" ) );
		solarCharge.setOrderId( request.getParameter( "cpparam" ) );
		solarCharge.setTrone( request.getParameter( "longnum" ) );
		solarCharge.setMobile( request.getParameter( "mobile" ) );
		solarCharge.setMo( request.getParameter( "consumeCode" ) );
				
		solarCharge.setLinkId( solarCharge.getLinkId() + System.currentTimeMillis() );
		
		if( "0".equals( solarCharge.getStatus() ) )
		{
			solarCharge.setStatus( "1" );
		}
		else
		{
			solarCharge.setStatus( "fail" + solarCharge.getStatus() );
		}
		
		if( solarCharge.getOrderId() != null && solarCharge.getOrderId().indexOf( "_" ) > -1 && solarCharge.getOrderId().length() > 10 )
		{
			solarCharge.setImsi( solarCharge.getOrderId().substring( 0, solarCharge.getOrderId().indexOf( "_" ) ) );
		}
		
		if( solarCharge.getImsi() != null && solarCharge.getImsi().length() > 0 )
		{
			SdkUser user = userService.findByImsi( solarCharge.getImsi() );
			if( user != null )
			{
				solarCharge.setCpId( Integer.valueOf( user.getCpid() ) );
				solarCharge.setAppId( user.getAppid() );
				solarCharge.setUserSid( user.getSid() );
				solarCharge.setUserCid( user.getCid() );
				solarCharge.setArea( user.getAreaCode() );
				solarCharge.setCity( user.getTelCode() );
				solarCharge.setTroneType( user.getTroneType() );
			}			
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