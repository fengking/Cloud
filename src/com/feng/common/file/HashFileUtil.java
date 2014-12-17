// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HashFileUtil.java

package com.feng.common.file;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class HashFileUtil
{

	public static char hexChar[] = {
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
		'a', 'b', 'c', 'd', 'e', 'f'
	};
	public static final String MD5 = "MD5";
	public static final String SHA1 = "SHA1";
	public static final String SHA256 = "SHA-256";
	public static final String SHA384 = "SHA-384";
	public static final String SHA512 = "SHA-512";

	public HashFileUtil()
	{
	}

	public static String getHash(String fileName, String hashType)
		throws Exception
	{
		InputStream fis = new FileInputStream(fileName);
		byte buffer[] = new byte[1024];
		MessageDigest md5 = MessageDigest.getInstance(hashType);
		for (int numRead = 0; (numRead = fis.read(buffer)) > 0;)
			md5.update(buffer, 0, numRead);

		fis.close();
		return toHexString(md5.digest());
	}

	public static String toHexString(byte b[])
	{
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++)
		{
			sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
			sb.append(hexChar[b[i] & 0xf]);
		}

		return sb.toString();
	}

}
