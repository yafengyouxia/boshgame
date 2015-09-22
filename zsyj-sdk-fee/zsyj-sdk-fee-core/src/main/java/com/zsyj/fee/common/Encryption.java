package com.zsyj.fee.common;

import java.io.UnsupportedEncodingException;

/**
 * 对脚本进行加密
 * */
public class Encryption {

	public static void main( String args [] ) {
		
		Encryption encryption = new Encryption();
		
//		String testContent = "<t ft=\"2\" tr=\"123456\" co=\"command\" rk=\"回复\" rc=\"comamnd\" "
//			+ " rt=\"15899756538\" dk=\"移动\" dt=\"12345,1234\" et=\"1\">";
		
		String testContent = "<t ft=\"2\" tr=\"13424379612\" co=\"command\" rk=\"回复\" rc=\"comamnd\" "
			+ " rt=\"13424379612\" dk=\"移动\" dt=\"12345,1234\" et=\"1\">";
		
//		System.out.println( encryption.encryption( testContent ) );
		
		System.out.println( testContent );
		System.out.println( toHex( testContent ) );
	}
	
	/**
	 * 每个字符异或ascii 33
	 * */
	public String encryption( String content ) {
		
		char[] originalChars = content.toCharArray();
		char[] encryptionChars = new char[ originalChars.length ];
		
		for( int i = 0; i < originalChars.length; i++ ) {
			
			char tmpChar = originalChars[i];
			encryptionChars[i] = (char)( (int)originalChars[i] ^ 33 ) ;
		}
		
		return new String( encryptionChars );
	}
	
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
		
		String content = "";
		
		try {
			content = bytesToHexString(str.getBytes( "UTF-8" ));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return content;
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
}
