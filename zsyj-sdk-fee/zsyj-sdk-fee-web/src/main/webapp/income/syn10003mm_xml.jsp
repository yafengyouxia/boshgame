<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,org.apache.commons.logging.*,com.sz5z.fee.processor.trone.SmsMoMrProcess"%>
<%@ page import="java.io.*,org.dom4j.*,com.sz5z.service.*,com.sz5z.service.impl.*,com.sz5z.sdk.vo.*,com.sz5z.vo.*"%>
<%!
static Log logger = LogFactory.getLog( "syn10003mm_xml" );
%>
<%response.setContentType("text/html;charset=gb2312");%>
<%
	String result = "<?xml  version=\"1.0\"  encoding=\"UTF-8\"?>"
			+ "<SyncAppOrderResp  xmlns=\"http://www.monternet.com/dsmp/schemas/\">"
			+ "<Version>1.0.0</Version>"
			+ "<hRet>0</hRet></SyncAppOrderResp>";
	
	try
	{
		String bodyContent =  new com.sz5z.common.util.StringUtil().readStream( request.getInputStream() );
		
		logger.info( "content:" + bodyContent );
		
		if( bodyContent == null || bodyContent.length() < 30 )
		{
			out.print( result );
			return;
		}
		
		SolarCharge solarCharge = new SolarCharge();
		UsersService userService = UsersServiceImpl.getInstance();
		
		solarCharge.setUserMid( bodyContent.substring( bodyContent.indexOf( "<imsi>" ) + "<imsi>".length(),  bodyContent.indexOf( "</imsi>" ) ) );
		solarCharge.setUsedCash( bodyContent.substring( bodyContent.indexOf( "<TotalPrice>" ) + "<TotalPrice>".length(),  bodyContent.indexOf( "</TotalPrice>" ) ) );
		solarCharge.setLinkId( bodyContent.substring( bodyContent.indexOf( "<OrderID>" ) + "<OrderID>".length(),  bodyContent.indexOf( "</OrderID>" ) ) );
		solarCharge.setServiceId( bodyContent.substring( bodyContent.indexOf( "<ExData>" ) + "<ExData>".length(),  bodyContent.indexOf( "</ExData>" ) ) );
		solarCharge.setMoContent( bodyContent.substring( bodyContent.indexOf( "<AppID>" ) + "<AppID>".length(),  bodyContent.indexOf( "</AppID>" ) ) );
		
		if( !"".equals( solarCharge.getLinkId().replaceAll("0", "") )  )
		{
			solarCharge.setStatus( "1" );
		}
		else
		{
			solarCharge.setLinkId( bodyContent.substring( bodyContent.indexOf( "<ExData>" ) + "<ExData>".length(),  bodyContent.indexOf( "</ExData>" ) ) );
			solarCharge.setStatus( "fail" );
		}
		
		if( solarCharge.getServiceId() != null && solarCharge.getServiceId().indexOf( "_" ) > -1 && solarCharge.getServiceId().length() > 10 )
		{
			solarCharge.setUserMid( solarCharge.getServiceId().substring( 0, solarCharge.getServiceId().indexOf( "_" ) ) );
		}
		
		solarCharge.setSpid( 1005 );
		
		User user = userService.findByMid( solarCharge.getUserMid() );
		if( user != null )
		{
			solarCharge.setAppid( user.getAppId() );
			solarCharge.setUserSid( user.getSid() );
			solarCharge.setUserCid( user.getCid() );
			solarCharge.setArea( user.getAreaId() );
			solarCharge.setCity( user.getTelID() );
			solarCharge.setCallType( user.getTroneType() );
			solarCharge.setAppid( user.getAppId() );
		}
		
		SmsMoMrProcess smsMoMrUtil = new SmsMoMrProcess();
		solarCharge.setAdvance( false );	//非垫付资费
		smsMoMrUtil.processCharge( solarCharge );
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.error( e.getMessage() );
	}
	
	out.print( result );
%>