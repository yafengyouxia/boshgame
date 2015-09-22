<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="azul.*,java.util.*,java.io.*" %>
<%@ page import="org.apache.commons.logging.*"%>
<%!
static Log logger = LogFactory.getLog( "feeinfoSdkSucc" );
%>
<%

String orderId = request.getParameter( "orderId" )==null?"":request.getParameter( "orderId" );

logger.info( "queryUrl url\r\n" + request.getQueryString() );
logger.info( "sucOrderId result orderId:" + orderId );

if( orderId != null && orderId.length() > 0 )
{
	com.sz5z.service.impl.MoidmappingLogServiceImpl.getInstance().updateStatus( orderId, 1 );
}
out.print( "ok" );
%>