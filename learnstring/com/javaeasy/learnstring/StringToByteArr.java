package com.javaeasy.learnstring;

import java.io.UnsupportedEncodingException;

public class StringToByteArr {
	public static void main(String[] args) {
		try {
			String content = "abc";
			byte[] contentBytes = content.getBytes("UTF-16BE");
												// 将字符串转换为byte数组
			System.out.println("长度为" + content.length() + "的字符串在UTF-16BE编码下对应的字节数组长度为：" + contentBytes.length);
			System.out.println(((byte)contentBytes[0])+" "+contentBytes[1]+" "+contentBytes[4]);
			String str = new String( contentBytes,"UTF-16BE");
			System.out.println(str);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
