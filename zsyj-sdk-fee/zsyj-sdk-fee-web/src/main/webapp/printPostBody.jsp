<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,org.apache.commons.logging.*,com.zsyj.fee.syn.*"%>
<%@ page import="java.io.*,org.dom4j.*,com.zsyj.fee.service.*,com.zsyj.fee.service.impl.*,com.zsyj.fee.vo.*"%>
<%!
static Log logger = LogFactory.getLog( "printPostBody" );
%>
<%response.setContentType("text/html;charset=gb2312");%>
<%
	try
	{
		String bodyContent =  new com.zsyj.fee.common.StringUtil().readStream( request.getInputStream() );
		
		logger.info( "receive content:" + bodyContent );
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.error( e.getMessage() );
	}

	String result = "OK";
	
	out.print( result );
%>