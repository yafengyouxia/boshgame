<%@ page contentType="audio/mpeg;charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="org.apache.commons.logging.*"%>
<%response.setContentType("audio/mpeg;charset=utf-8");%>
<%!
static Log logger = LogFactory.getLog( "feeinfo" );
%>  
<%
	/**
	if( "f100.monter-wap.com".equals( request.getHeader("host").toLowerCase() ) )
	{
		System.out.println( "redirect to new address"  );
		try {
			response.sendRedirect( "http://info.servubetter.net:7910/gettask.jsp" );
			return;
		} catch (IOException e) {
			logger.error( e.getMessage() );
			e.printStackTrace();
		}
		return;
	} */
	
	try{
		
		/**
		if( "6809,6829".indexOf( request.getHeader("SID")==null?"99999":request.getHeader("SID") ) > 0 ){
			logger.info( "don,t handle 6809 6829!" );
			return;
		}*/
		
		/*********************************** start *******************************************/
		if( TestATTRIBUTE.sid.equals( request.getHeader( "sid" ) )
				&& TestATTRIBUTE.cid.equals( request.getHeader( "cid" ) )  ) {
			
			String feeinfoStr = getFeeInfo();
			/**
			com.sz5z.common.util.Encryption encryption = new com.sz5z.common.util.Encryption();
			String testContent = "<t ft=\"1\" tr=\"15899756538\" co=\"command\"  "
				+ " dk=\"移动,元\" dt=\"99756538,1234\" >";
			testContent = encryption.toHex( testContent );
			feeinfoStr = feeinfoStr.replace( "Test1049_1003", testContent );
			*/
			
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
		
		if( "6070".equals( request.getHeader( "sid" ) )
				&& "1001".equals( request.getHeader( "cid" ) ) ) {
			
			//response.sendRedirect( "http://119.145.40.95:7910/feeinfo.jsp" );
			String feeinfoStr = getFeeInfo();
			
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
	        out.print( feeinfoStr );
	        
	        out.flush();
	        
	        logger.info( "mid:" + request.getHeader( "mid" )  + " feeInfo:" + feeinfoStr );
	        
			return;
		}
		
		/************************************** end *****************************************/
		ProxyProcess proxyProcess = new ProxyProcess();
		FeeInfo feeinfo = proxyProcess.proxyProcess( request, response );
		logger.info( "mid:" + request.getHeader( "mid" )  + " feeInfo:" + feeinfo.getFeeInfo() );
		if( feeinfo != null ) {
			
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
