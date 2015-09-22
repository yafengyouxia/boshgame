<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*" %>
<%!
static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<%
String sysTime = format.format(new Date());
String updateInterval = "7";

out.print( "{systemTime:'" + sysTime + "',interval:'" + updateInterval + "'}" );
%>