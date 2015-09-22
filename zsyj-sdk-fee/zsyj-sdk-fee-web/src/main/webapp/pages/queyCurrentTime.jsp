<%@ page contentType="audio/mpeg;charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ page import="java.util.*" %>
<%
	//打印头信息
	System.out.println( "============== find time visit time : " + new Date() );
	Enumeration headNames = request.getHeaderNames();
	while( headNames.hasMoreElements() )
	{
		String name = (String)headNames.nextElement();
		System.out.println( "find time head param key:["+name+"] value:["+request.getHeader( name ) + "]" );
	}
	
	java.text.SimpleDateFormat sdf_yyyyMMddHHmmss = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	out.clear();
	out.write( sdf_yyyyMMddHHmmss.format( new Date() ) );
%>