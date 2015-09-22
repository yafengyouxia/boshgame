package com.zsyj.fee.common;

import org.apache.commons.codec.binary.Base64;

public class Base64Utils {
	
    // 解密  
    public static String getFromBase64(String s) 
    {  
    	byte[] b = null;  
        String result = null;
        
        if (s != null) 
        {  
            try 
            {
                b = Base64.decodeBase64( s.getBytes() );
                
                result= new String( b );
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        } 
        
        return result;
    }
    
    public static void main( String args [] )
    {
    	Base64Utils baseUtil = new Base64Utils();
    	String testContent = "4VzsiivWQDHiE0mt4UA0pYwoxVGlxSgOic1ZZ0jc8iirGo05WrBZxcG02pkxVlzl3e5qkXovRmvJtXhlhz6tT9jzOiNKZ/f2Cz+Wl6tZ/XG8cg7HSvOYiZOup9psfBocvu9NYvDeVtKgy2CvJ37P0edwuxyDxWwA";
    	String result = baseUtil.getFromBase64( testContent );
    	System.out.println( result );
    }
}