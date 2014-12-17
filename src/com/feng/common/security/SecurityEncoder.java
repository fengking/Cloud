// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SecurityEncoder.java

package com.feng.common.security;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.feng.common.security:
//			Base64

public class SecurityEncoder
{

	public static final String ENCODE_SHA1 = "SHA-1";
	public static final String ENCODE_SHA256 = "SHA-256";
	public static final String ENCODE_SHA368 = "SHA-368";
	public static final String ENCODE_SHA512 = "SHA-512";
	public static final String KEY_MAC = "HmacMD5";

	public SecurityEncoder()
	{
	}

	public static byte[] decryptBase64(String key)
		throws Exception
	{
		return Base64.decode(key);
	}

	public static String decryptStrBase64(String key)
		throws Exception
	{
		return new String(decryptBase64(key));
	}

	public static String encryptBase64(byte data[])
	{
		return Base64.encode(data);
	}

	public static String encryptBase64(String key)
	{
		return Base64.encode(key.getBytes());
	}

	public static byte[] encryptMD5(byte data[])
		throws Exception
	{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(data);
		return md5.digest();
	}

	public static String encryptMD5(String key)
		throws Exception
	{
		byte data[] = encryptMD5(key.getBytes());
		char hexDigits[] = {
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
			'a', 'b', 'c', 'd', 'e', 'f'
		};
		int j = data.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++)
		{
			byte byte0 = data[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}

		return new String(str);
	}

	public static byte[] encryptSHA(String digest, byte data[])
		throws Exception
	{
		MessageDigest sha = MessageDigest.getInstance(digest);
		sha.update(data);
		return sha.digest();
	}

	public static String encryptSHA(String digest, String key)
		throws Exception
	{
		byte data[] = encryptSHA(digest, key.getBytes());
		char hexDigits[] = {
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
			'a', 'b', 'c', 'd', 'e', 'f'
		};
		int j = data.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++)
		{
			byte byte0 = data[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}

		return new String(str);
	}

	public static String initMacKey()
		throws Exception
	{
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey secretKey = keyGenerator.generateKey();
		return encryptBase64(secretKey.getEncoded());
	}

	public static byte[] encryptHMAC(byte data[], String key)
		throws Exception
	{
		SecretKey secretKey = new SecretKeySpec(decryptBase64(key), "HmacMD5");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}

	public static String encryptHMAC(String data, String key)
		throws Exception
	{
		BigInteger bi = new BigInteger(encryptHMAC(data.getBytes(), key));
		return bi.toString(16);
	}

	public static void main(String args[])
		throws Exception
	{
		System.out.println(encryptBase64("要盖章的数据句柄"));
		System.out.println(decryptStrBase64(encryptBase64("要盖章的数据句柄")));
		System.out.println(encryptMD5("要盖章的数据句柄"));
		System.out.println(encryptSHA("SHA-512", "要盖章的数据句柄"));
		String mac = initMacKey();
		System.out.println(mac);
		System.out.println(encryptHMAC("要盖章的数据句柄", mac));
	}
}
