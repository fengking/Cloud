// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Base64.java

package com.feng.common.security;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Base64
{

	private static char base64EncodeChars[] = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
		'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
		'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
		'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
		'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
		'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
		'8', '9', '+', '/'
	};
	private static byte base64DecodeChars[] = {
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
		-1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
		54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
		-1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
		5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
		15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
		25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
		29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
		39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
		49, 50, 51, -1, -1, -1, -1, -1
	};

	public Base64()
	{
	}

	public static String encode(byte data[])
	{
		StringBuffer sb = new StringBuffer();
		int len = data.length;
		for (int i = 0; i < len;)
		{
			int b1 = data[i++] & 0xff;
			if (i == len)
			{
				sb.append(base64EncodeChars[b1 >>> 2]);
				sb.append(base64EncodeChars[(b1 & 3) << 4]);
				sb.append("==");
				break;
			}
			int b2 = data[i++] & 0xff;
			if (i == len)
			{
				sb.append(base64EncodeChars[b1 >>> 2]);
				sb.append(base64EncodeChars[(b1 & 3) << 4 | (b2 & 0xf0) >>> 4]);
				sb.append(base64EncodeChars[(b2 & 0xf) << 2]);
				sb.append("=");
				break;
			}
			int b3 = data[i++] & 0xff;
			sb.append(base64EncodeChars[b1 >>> 2]);
			sb.append(base64EncodeChars[(b1 & 3) << 4 | (b2 & 0xf0) >>> 4]);
			sb.append(base64EncodeChars[(b2 & 0xf) << 2 | (b3 & 0xc0) >>> 6]);
			sb.append(base64EncodeChars[b3 & 0x3f]);
		}

		return sb.toString();
	}

	public static byte[] decode(String str)
		throws UnsupportedEncodingException
	{
		StringBuffer sb = new StringBuffer();
		byte data[] = str.getBytes("US-ASCII");
		int len = data.length;
		for (int i = 0; i < len;)
		{
			int b1;
			do
				b1 = base64DecodeChars[data[i++]];
			while (i < len && b1 == -1);
			if (b1 == -1)
				break;
			int b2;
			do
				b2 = base64DecodeChars[data[i++]];
			while (i < len && b2 == -1);
			if (b2 == -1)
				break;
			sb.append((char)(b1 << 2 | (b2 & 0x30) >>> 4));
			int b3;
			do
			{
				b3 = data[i++];
				if (b3 == 61)
					return sb.toString().getBytes("iso8859-1");
				b3 = base64DecodeChars[b3];
			} while (i < len && b3 == -1);
			if (b3 == -1)
				break;
			sb.append((char)((b2 & 0xf) << 4 | (b3 & 0x3c) >>> 2));
			int b4;
			do
			{
				b4 = data[i++];
				if (b4 == 61)
					return sb.toString().getBytes("iso8859-1");
				b4 = base64DecodeChars[b4];
			} while (i < len && b4 == -1);
			if (b4 == -1)
				break;
			sb.append((char)((b3 & 3) << 6 | b4));
		}

		return sb.toString().getBytes("iso8859-1");
	}

	public static void main(String args[])
		throws UnsupportedEncodingException
	{
		String s = "abcd";
		System.out.println((new StringBuilder("加密前：")).append(s).toString());
		String x = encode(s.getBytes());
		System.out.println((new StringBuilder("加密后：")).append(x).toString());
		String x1 = new String(decode(x));
		System.out.println((new StringBuilder("解密后：")).append(x1).toString());
	}

}
