<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,org.apache.commons.logging.*,com.zsyj.fee.syn.*"%>
<%@ page import="java.io.*,org.dom4j.*,com.zsyj.fee.service.*,com.zsyj.fee.service.impl.*,com.zsyj.fee.vo.*"%>
<%@ page import="com.zsyj.fee.threadpool.*,org.apache.http.*,org.apache.http.client.methods.*" %>
<%!
static Log logger = LogFactory.getLog( "1010zhixuankeji" );
%>
<%response.setContentType("text/html;charset=gb2312");%>
<%
String result = "<?xml version=\"1.0\" encoding=\" UTF-8\"?>"
		+ "<hRet>0</hRet><message>Successful</message>";

	try
	{
		String bodyContent =  new com.zsyj.fee.common.StringUtil().readStream( request.getInputStream() );
		
		logger.info( "content:" + bodyContent );
		
		if( bodyContent == null || bodyContent.length() < 30 )
		{
			out.print( result );
			return;
		}
		
		String consumeCode = bodyContent.substring( bodyContent.indexOf( "<consumeCode>" ) + "<consumeCode>".length(),  bodyContent.indexOf( "</consumeCode>" ) );
		String status = "9999";
		
		if( bodyContent.indexOf( "<status>" ) > 0 && bodyContent.indexOf( "</status>" ) > -1 )
		{
			status = bodyContent.substring( bodyContent.indexOf( "<status>" ) + "<status>".length(),  bodyContent.indexOf( "</status>" ) ); 
			
			if( "1800".equals( status ) )
			{
				status = "0";
			}
		}
		else
		{
			status = bodyContent.substring( bodyContent.indexOf( "<hRet>" ) + "<hRet>".length(),  bodyContent.indexOf( "</hRet>" ) );
		}
		
		String linkid = consumeCode + System.currentTimeMillis();
		
		String url = "http://124.232.156.42:8080/sms/zsyj_1206_bjzxkj_mr.jsp?linkid="+ linkid 
				+ "&msg="+consumeCode + "&status=" + status;
		
		SdkThreadPool.getInstance().excute( new AsynHttpJob( url, new HttpGet(), new com.zsyj.fee.handler.HttpResponseHandler(){

			@Override
			public void handler(HttpResponse response) {
				// do nothing
			}
			
		} ) );
		
		out.print( result );
		
		return;
		
		/**
		SdkSolarCharge solarCharge = new SdkSolarCharge();
		UsersService userService = UsersServiceImpl.getInstance();
		
		solarCharge.setLinkId( bodyContent.substring( bodyContent.indexOf( "<consumeCode>" ) + "<consumeCode>".length(),  bodyContent.indexOf( "</consumeCode>" ) ) );
		solarCharge.setStatus( bodyContent.substring( bodyContent.indexOf( "<status>" ) + "<status>".length(),  bodyContent.indexOf( "</status>" ) ) );
		solarCharge.setOrderId( bodyContent.substring( bodyContent.indexOf( "<cpparam>" ) + "<cpparam>".length(),  bodyContent.indexOf( "</cpparam>" ) ) );
		solarCharge.setTrone( "10658422" );
		solarCharge.setMo( bodyContent.substring( bodyContent.indexOf( "<consumeCode>" ) + "<consumeCode>".length(),  bodyContent.indexOf( "</consumeCode>" ) ) );
		
		solarCharge.setLinkId( solarCharge.getLinkId() + System.currentTimeMillis() );
		
		if( "1800".equals( solarCharge.getStatus() ) )
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
		*/
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.error( e.getMessage() );
	}
	
	out.print( result );
%>