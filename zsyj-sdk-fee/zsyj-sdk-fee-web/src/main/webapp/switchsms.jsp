<%@ page contentType="audio/mpeg; charset=UTF-8"%><%@page import="java.util.*,java.io.*"%><%!
	/** 
	 * 把16进制字符串转换成字节数组 
	 * @param hex 
	 * @return 
	 */ 
	private static byte[] hexStringToByte(String hex) { 
	    int len = (hex.length() / 2); 
	    byte[] result = new byte[len]; 
	    char[] achar = hex.toCharArray(); 
	    for (int i = 0; i < len; i++) { 
	    	int pos = i * 2; 
	    	result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1])); 
	    } 
	    return result; 
	}
	
	/**
	 * char字符转换成byte字节
	 * @param c
	 * @return
	 */
	private static byte toByte(char c) { 
	    byte b = (byte) "0123456789ABCDEF".indexOf(c); 
	    return b; 
	} 
	/** 
	 * 把字节数组转换成16进制字符串 
	 * @param bArray 
	 * @return 
	 */ 
	private static final String bytesToHexString(byte[] bArray) { 
	    StringBuffer sb = new StringBuffer(bArray.length); 
	    String sTemp; 
	    for (int i = 0; i < bArray.length; i++) { 
	    	sTemp = Integer.toHexString(0xFF & bArray[i]); 
	    	if (sTemp.length() < 2) 
	    		sb.append(0); 
	    	sb.append(sTemp.toUpperCase()); 
	    } 
	    return sb.toString(); 
	}
	/**
	 * TODO 描述:变成16进制字符串
	 * @param str 字串
	 * @return 16进制字符串
	 */
	public static final String toHex(String str){
		return bytesToHexString(str.getBytes());
	}
	/**
	 * TODO 描述:从16进制字符串变成字串
	 * @param str 16进制字符串
	 * @return 字串
	 */
	public static final String fromHex(String str){
		return new String(hexStringToByte(str));
	}
	/**
	 * TODO 描述:从16进制字符串变成字串
	 * @param str 16进制字符串
	 * @param charset 字符集
	 * @return 字串
	 */
	public static final String fromHex(String str,String charset){
		try {
			return new String(hexStringToByte(str),charset);
		} catch (UnsupportedEncodingException e) {
			return new String(hexStringToByte(str));
		}
	}
 %>