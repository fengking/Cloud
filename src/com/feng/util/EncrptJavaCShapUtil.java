package com.feng.util;

import java.io.UnsupportedEncodingException;

/**
 * Java C# 通用加密解密
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1
 *
 */
public class EncrptJavaCShapUtil {

	private static String key="!@#$%fengking@!@&*##@";

	/**
	 * 构造函数
	 */
	public EncrptJavaCShapUtil() {
		this("sitow");
	}

	/**
	 * 构造函数
	 * @param key
	 */
	public EncrptJavaCShapUtil(String key) {
		this.key = key;
	}

	/**
	 * 参照因子
	 */
	private  static final String[] reference = new String[] { "0a", "0b", "0c", "0d",
			"0e", "0f", "0g", "0h", "0i", "0j", "0k", "0l", "0m", "0n", "0o",
			"0p", "0q", "0r", "0s", "0t", "0u", "0v", "0w", "0x", "0y", "0z",
			"1a", "1b", "1c", "1d", "1e", "1f", "1g", "1h", "1i", "1j", "1k",
			"1l", "1m", "1n", "1o", "1p", "1q", "1r", "1s", "1t", "1u", "1v",
			"1w", "1x", "1y", "1z", "2a", "2b", "2c", "2d", "2e", "2f", "2g",
			"2h", "2i", "2j", "2k", "2l", "2m", "2n", "2o", "2p", "2q", "2r",
			"2s", "2t", "2u", "2v", "2w", "2x", "2y", "2z", "3a", "3b", "3c",
			"3d", "3e", "3f", "3g", "3h", "3i", "3j", "3k", "3l", "3m", "3n",
			"3o", "3p", "3q", "3r", "3s", "3t", "3u", "3v", "3w", "3x", "3y",
			"3z", "4a", "4b", "4c", "4d", "4e", "4f", "4g", "4h", "4i", "4j",
			"4k", "4l", "4m", "4n", "4o", "4p", "4q", "4r", "4s", "4t", "4u",
			"4v", "4w", "4x", "4y", "4z", "5a", "5b", "5c", "5d", "5e", "5f",
			"5g", "5h", "5i", "5j", "5k", "5l", "5m", "5n", "5o", "5p", "5q",
			"5r", "5s", "5t", "5u", "5v", "5w", "5x", "5y", "5z", "6a", "6b",
			"6c", "6d", "6e", "6f", "6g", "6h", "6i", "6j", "6k", "6l", "6m",
			"6n", "6o", "6p", "6q", "6r", "6s", "6t", "6u", "6v", "6w", "6x",
			"6y", "6z", "7a", "7b", "7c", "7d", "7e", "7f", "7g", "7h", "7i",
			"7j", "7k", "7l", "7m", "7n", "7o", "7p", "7q", "7r", "7s", "7t",
			"7u", "7v", "7w", "7x", "7y", "7z", "8a", "8b", "8c", "8d", "8e",
			"8f", "8g", "8h", "8i", "8j", "8k", "8l", "8m", "8n", "8o", "8p",
			"8q", "8r", "8s", "8t", "8u", "8v", "8w", "8x", "8y", "8z", "9a",
			"9b", "9c", "9d", "9e", "9f", "9g", "9h", "9i", "9j", "9k", "9l",
			"9m", "9n", "9o", "9p", "9q", "9r", "9s", "9t", "9u", "9v" };

	/**
	 * 加密
	 */
	private static int getIndex(String str) {
		int result = -1;
		for (int i = 0; i < reference.length; i++) {
			if (reference[i].equals(str)) {
				result = i;
				break;
			}
		}
		return result;
	}

	/**
	 * 加密
	 * @param str
	 * @return
	 */
	public static String Encrypt(String str) {
		if (str == null || str.trim().length() <= 0)
			return str;
		StringBuffer sb = new StringBuffer();
		try {
			int len = reference.length / 2;
			byte[] keyByte = key.getBytes("utf-8");
			byte[] strByte = str.getBytes("utf-8");

			if (keyByte.length > strByte.length) {
				byte[] keyTemp = new byte[strByte.length];
				byte a = 0;
				for (int i = strByte.length - 1; i < keyByte.length; i++) {
					a += keyByte[i];
				}
				keyByte[strByte.length - 1] = a;
				for (int i = 0; i < keyTemp.length; i++) {
					keyTemp[i] = keyByte[i];
				}
				keyByte = keyTemp;
			}
			for (int i = 0; i < strByte.length; i++) {
				int index = i % keyByte.length;
				byte refData = keyByte[index];
				byte data = (byte) (strByte[i] + refData);
				if (data < -128 || data > 127) {
					data = (byte) (strByte[i] - refData);
				}
				sb.append(reference[len + data]);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();

			return "";
		}
		return sb.toString();
	}

	/**
	 * 解密
	 * @param str
	 * @return
	 */
	public static String Decrypt(String str) {
		if (str == null || str.trim().length() <= 0)
			return str;
		String strResult = "";
		try {
			int len = reference.length / 2;
			byte[] keyByte = key.getBytes("utf-8");
			int strLen = str.length() / 2;
			byte[] result = new byte[strLen];
			if (keyByte.length > strLen) {
				byte[] keyTemp = new byte[strLen];
				byte a = 0;
				for (int i = strLen - 1; i < keyByte.length; i++) {
					a += keyByte[i];
				}
				keyByte[strLen - 1] = a;
				for (int i = 0; i < keyTemp.length; i++) {
					keyTemp[i] = keyByte[i];
				}
				keyByte = keyTemp;
			}
			for (int i = 0; i < strLen; i++) {
				int index = i % keyByte.length;
				String s = str.substring(i * 2, i * 2 + 2);
				int x = getIndex(s);
				byte refData = keyByte[index];
				int data = x - len;
				byte d = (byte) (data - refData);
				if (d < -128 || d > 127) {
					d = (byte) (data + refData);
				}
				result[i] = d;
			}
			strResult = new String(result, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
		return strResult;
	} 
}
