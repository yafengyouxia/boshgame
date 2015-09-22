<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*,java.io.*,org.apache.http.*,org.apache.http.client.*,org.apache.http.client.methods.*" %>
<%@ page import="org.apache.commons.logging.*,com.zsyj.fee.common.*"%>
<%!
static Log logger = LogFactory.getLog( "codeService" );
%>
<%
long startTime = System.currentTimeMillis();
String requestQuery = request.getQueryString();
System.out.println( "requestQuery:" + requestQuery );

String url = "http://121.14.38.20:25494/if_mtk/service?" + requestQuery;
HttpGet get = new HttpGet();
HttpClient client = HttpConnectionManager.getHttpClient();

try
{
	get.setURI( new java.net.URI( url ) );
	
    HttpResponse httpResponse = client.execute( get );
    HttpEntity entity = httpResponse.getEntity();
    
    byte[] returnBytes = null;
    InputStream is = null;
	ByteArrayOutputStream bos = null;
	
	if (entity != null) {
		is = entity.getContent();
		bos = new ByteArrayOutputStream();
		byte[] data = new byte[1];
		while (is.read(data) > 0) {
			bos.write(data);
		}
		returnBytes = bos.toByteArray();
	}
	
	long costTime = System.currentTimeMillis() - startTime;
	
	logger.info( " costTime : " + costTime );
	
	com.zsyj.fee.threadpool.SdkThreadPool.getInstance().excute( new com.zsyj.fee.syn.CodeRquestLogJob( requestQuery, costTime ) );
	
	out.print( new String( returnBytes ) );
}
catch( Exception e )
{
	e.printStackTrace();
	logger.error( e.getMessage() );
}
%>