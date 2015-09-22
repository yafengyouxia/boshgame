<%@ page contentType="audio/mpeg;charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ page import="java.util.*,com.sz5z.fee.processor.*,com.sz5z.fee.vo.*"%><%@ page import="java.io.*,com.sz5z.test.*,com.sz5z.test.yizhi.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%response.setContentType("audio/mpeg;charset=utf-8");%>
<%!
static Log logger = LogFactory.getLog( "feeinfo" );
%>  
<%
	//打印头信息
	Enumeration headNames = request.getHeaderNames();
	StringBuffer sb = new StringBuffer( );
	while( headNames.hasMoreElements() )
	{
		String name = (String)headNames.nextElement();
		sb.append( "["+name+"] value:["+request.getHeader( name ) + "]\r\n" );
	}
	
	logger.info( "header key\r\n" + sb.toString() );
	
	String queryUrl = request.getQueryString();
	
	logger.info( "queryUrl url\r\n" + queryUrl );
	
	try
	{	
		/*********************************** start *******************************************/
		if( ( TestATTRIBUTE.sid.equals( request.getHeader( "sid" ) )
				&& TestATTRIBUTE.cid.equals( request.getHeader( "cid" ) ) )
				|| ( "101".equals( request.getHeader( "sid" ) )
						&& "999".equals( request.getHeader( "cid" ) ) ) ) 
		{
			String feeinfoStr = "";
			if( "101".equals( request.getHeader( "sid" ) ) && "999".equals( request.getHeader( "cid" ) ) )
			{
				feeinfoStr = "<infos>"
				    + "<info id=\"sub" + new Random().nextInt( 999 ) + "\" orderId=\"" + new Random().nextInt( 9999999 ) + "\" sleeptime=\"38\" feetimes=\"1\" feetype=\"sms\" command=\"Test1049_test1\" trone=\"15899756538\" confirmkeyword=\"田野\" confirmcommand=\"2次回复\" deltrone=\"12345,1234\" delkeyword=\"移动\" expiredtime=\"1\"></info>" 
				    + "<info id=\"sub" + new Random().nextInt( 999 ) + "\" sleeptime=\"68\" feetimes=\"1\" feetype=\"sms\" command=\"Test1049_test2\" trone=\"15899756538\" confirmkeyword=\"田野\" confirmcommand=\"2次回复\" deltrone=\"12345,1234\" delkeyword=\"移动\" expiredtime=\"1\"></info>"
					+ "</infos>";	
				
				//feeinfoStr = "<infos>"+"<info id=\"sub1235\" orderId=\"1413366639610\" feetimes=\"1\" feetype=\"wap\" confirmkeyword=\"田野\" confirmcommand=\"2次回复\" deltrone=\"12345,1234\" delkeyword=\"移动\" expiredtime=\"1\" "
				//		+ " subUrl=\"http://121.197.10.107:6688/wap/cmgame20141220.jsp\" ></info>" +"</infos>";
			}
			else
			{
				feeinfoStr = getFeeInfo();
			}
			
	        //更新日志信息 
	        VisitLog visitLog = new VisitLog(); 
	        visitLog.setSid( request.getHeader( "sid" ) );
	        visitLog.setCid( request.getHeader( "cid" ) );
	        visitLog.setMid( request.getHeader( "mid" ) );
	        visitLog.setCv( request.getHeader("CV") );
	        visitLog.setSoftversion( request.getHeader("softversion") );
	        visitLog.setInfo( feeinfoStr );
	        VisitLogService visitLogService = new VisitLogService();
	        visitLogService.insert( visitLog );
	        out.write( feeinfoStr );
			return;
		}
		
		/************************************** end *****************************************/
		
		ProxyProcess proxyProcess = new ProxyProcess();
		FeeInfo feeinfo = proxyProcess.proxyProcessSdk( request, response );
		logger.info( "mid:" + request.getHeader( "mid" )  + " feeInfo:" + feeinfo.getFeeInfo() );
		if( feeinfo != null )
		{
			if (request.getHeader("MID")==null || request.getHeader("MID").equals("") || request.getHeader("MID").equals("0000"))
			{
				response.setHeader("MID",feeinfo.getMID());
			}
			
			//输出info计费结构体
			out.write( feeinfo.getFeeInfo() );
			
			out.flush();
		}
		
	} catch( Exception e ) {
		logger.error( e.getMessage() );
		e.printStackTrace();
	}
%>
<%!
private String getFeeInfo()
{
        String feeinfo = "";
        try
        {
                FileInputStream fis = new FileInputStream( new File( "/home/web/test/feeinfo.txt" ) );
                BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

                String line = br.readLine();
                feeinfo = line;
            while(line != null)
            {
                line = br.readLine();
                if( line != null )
                {
                        feeinfo += line;
                }
            }
            br.close();
            fis.close();
        }
        catch( Exception e )
        {
                e.printStackTrace();
        }
        return feeinfo;
}
%>