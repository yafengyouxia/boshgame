package com.zsyj.fee.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Sign {

	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	private static String appkey = "vision";
	private static String version = "1.0";
	private static String securitykey = "7dc43b95086a2873ff2f83d1e5ef1079";
	private static String method = "biz.acceptance";
	
	public static void main(String[] args) {
		
		Map<String, String> params = new HashMap<String, String>();
		// timestamp参数
		params.put("timestamp", Constant.sdf_yyyyMMddHHmmss.format(new Date()));
		// 调用者第三方公钥
		params.put("appkey", appkey);
		// open api暴露的API接口名
		params.put("method", method);
		// 版本号
		params.put("v", version);
		
		Sign.getSigString( params );
		// System.out.println(md5(appkey));
	}
	
	public static String getSigString( Map<String, String> params ) {

		StringBuilder sb = new StringBuilder();
		Object[] keys = params.keySet().toArray();
		// 按照参数名（KEY）做升序排序
		Arrays.sort(keys);
		// 对参数名和参数值联接成字符串
		for (Object key : keys) {
			sb.append(key).append(params.get(key));
		}
		// SHA算法加密前，加上密码串
		String sig = SHAUtils.ShaEncrypt(sb.toString().concat(securitykey));
		System.out.println("client sig ------>" + sig);
		return sig;
	}

	/**
	 * md5加密
	 * 
	 * @param password
	 * @return
	 */
	public static String md5(String password) {
		if (password == null) {
			return null;
		}
		try {
			byte[] temp = password.getBytes();
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(temp);
			byte[] md = digest.digest();
			int length = md.length;
			char buffer[] = new char[length * 2];
			int k = 0;
			for (int i = 0; i < length; i++) {
				byte byte0 = md[i];
				buffer[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buffer[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buffer);
		} catch (Exception e) {
			return null;
		}
	}
}

class SHAUtils {
	public static final String KEY_SHA = "SHA";
	public static final String KEY_MD5 = "MD5";

	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);
		return md5.digest();
	}

	/**
	 * SHA加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptSHA(byte[] data) throws Exception {
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);
		return sha.digest();
	}

	/**
	 * SHA加密算法
	 * 
	 * @param inputStr
	 * @return
	 */
	public static String ShaEncrypt(String inputStr) {
		byte[] inputData = inputStr.getBytes();
		String returnString = "";
		try {
			inputData = encryptSHA(inputData);
			for (int i = 0; i < inputData.length; i++) {
				returnString += byteToHexString(inputData[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnString;
	}

	// 将字节转换为十六进制字符串
	private static String byteToHexString(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}

	/**
	 * MD5的加密算法
	 * 
	 * @param inputStr
	 * @return
	 */
	public static String md5Encrypt(String inputStr) {
		byte[] inputData = inputStr.getBytes();
		String returnString = "";
		try {
			BigInteger md5 = new BigInteger(encryptMD5(inputData));
			// System.err.println("MD5:\n" + md5.toString(16));
			returnString = md5.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnString;
	}

	public static void main(String[] args) {

	}
}