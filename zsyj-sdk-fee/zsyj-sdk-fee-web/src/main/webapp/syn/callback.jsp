<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,org.apache.commons.logging.*,com.zsyj.fee.syn.*"%>
<%@ page import="java.io.*,org.dom4j.*,com.zsyj.fee.service.*,com.zsyj.fee.service.impl.*,com.zsyj.fee.vo.*"%>
<%!
static Log logger = LogFactory.getLog( "SynCmSingleGame" );
%>
<%response.setContentType("text/html;charset=gb2312");%>
<%
	String TransactionID = "";
	try
	{
		String bodyContent =  new com.zsyj.fee.common.StringUtil().readStream( request.getInputStream() );
		
		logger.info( "content:" + bodyContent );
		
		if( bodyContent == null || bodyContent.length() < 30 )
		{
			out.print( "nothing" );
			return;
		}
		
		TransactionID = bodyContent.substring( bodyContent.indexOf( "<TransactionID>" ) + "<TransactionID>".length(),  bodyContent.indexOf( "</TransactionID>" ) );
		
		SdkSolarCharge solarCharge = new SdkSolarCharge();
		UsersService userService = UsersServiceImpl.getInstance();
		
		solarCharge.setTroneType( (byte)0 );
		solarCharge.setLinkId( bodyContent.substring( bodyContent.indexOf( "<TradeID>" ) + "<TradeID>".length(),  bodyContent.indexOf( "</TradeID>" ) ) );
		solarCharge.setStatus( bodyContent.substring( bodyContent.indexOf( "<ActionID>" ) + "<ActionID>".length(),  bodyContent.indexOf( "</ActionID>" ) ) );
		solarCharge.setOrderId( bodyContent.substring( bodyContent.indexOf( "<ExData>" ) + "<ExData>".length(),  bodyContent.indexOf( "</ExData>" ) ) );
		solarCharge.setAppId( bodyContent.substring( bodyContent.indexOf( "<AppID>" ) + "<AppID>".length(),  bodyContent.indexOf( "</AppID>" ) ) );
		solarCharge.setTrone(  bodyContent.substring( bodyContent.indexOf( "<AppID>" ) + "<AppID>".length(),  bodyContent.indexOf( "</AppID>" ) ) );
		solarCharge.setMo( bodyContent.substring( bodyContent.indexOf( "<PayCode>" ) + "<PayCode>".length(),  bodyContent.indexOf( "</PayCode>" ) ) );
		solarCharge.setUsedCash( Double.valueOf( bodyContent.substring( bodyContent.indexOf( "<Price>" ) + "<Price>".length(),  bodyContent.indexOf( "</Price>" ) ) )/100 );
		solarCharge.setUserSid( bodyContent.substring( bodyContent.indexOf( "<ChannelID>" ) + "<ChannelID>".length(),  bodyContent.indexOf( "</ChannelID>" ) ) );
		//solarCharge.setImsi( bodyContent.substring( bodyContent.indexOf( "<OrderID>" ) + "<OrderID>".length(),  bodyContent.indexOf( "</OrderID>" ) ) );
		
		String exdata = bodyContent.substring( bodyContent.indexOf( "<ExData>" ) + "<ExData>".length(),  bodyContent.indexOf( "</ExData>" ) );
		if( exdata.indexOf( "\"" ) > -1 )
		{
			solarCharge.setOrderId( exdata.substring( 0, exdata.indexOf( "\"" ) ) );
			solarCharge.setUserSid( exdata.substring( exdata.indexOf( "\"" ) + 1 ) );
		}
		
		if(  !"00000000000000000000".equals( solarCharge.getImsi() ) && "1".equals( solarCharge.getStatus() ) )  //失败订单为20个0
		{
			solarCharge.setStatus( "1" );
		}
		else
		{
			solarCharge.setStatus( "-" + solarCharge.getStatus() );
		}
		
		DFChargeSynchronize chargeSynchronize = new DFChargeSynchronize();
		chargeSynchronize.processCharge( solarCharge, bodyContent );
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logger.error( e.getMessage() );
	}

	String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
			"<SyncAppOrderResp xmlns=\" http://www.monternet.com/dsmp/schemas/\">" +
			"<TransactionID>" + TransactionID + "</TransactionID>" +
			"<MsgType>SyncAppOrderResp</MsgType>" +
			"<Version>1.0.0</Version>" +
			"< hRet >0</ hRet >" +
			"</SyncAppOrderResp>";
	
	out.print( result );
%>