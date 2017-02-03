package cn.qtech.xf.common.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by mtf81 on 2017/2/3.
 */
public class Md5Util {
	public static String EncodeByMd5(String str) {
//		确定加密方法
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			//加密后的字符串
			String newStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
			return newStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
