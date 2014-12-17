// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ThreeDES.java

package com.feng.common.security;

import java.io.PrintStream;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

// Referenced classes of package com.feng.common.security:
//			Base64

public class ThreeDES
{

	private Key key;

	public ThreeDES()
	{
	}

	public void getKey(String strKey)
	{
		try
		{
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			_generator.init(new SecureRandom(strKey.getBytes()));
			key = _generator.generateKey();
			_generator = null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getEncString(String strMing)
	{
		String strMi;
		byte byteMi[] = (byte[])null;
		byte byteMing[] = (byte[])null;
		strMi = "";
		Base64 base64en = new Base64();
		try
		{
			byteMing  = strMing.getBytes("UTF8");
			byteMi  = getEncCode(byteMing);
			strMi = Base64.encode(byteMi); 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		 
		return strMi;
	}

	public String getDesString(String strMi)
	{
		String strMing;
		Base64 base64De = new Base64();
		byte byteMing[] = (byte[])null;
		byte byteMi[] = (byte[])null;
		strMing = "";
		try
		{
			byteMi = Base64.decode(strMi);
			byteMing= getDesCode(byteMi);
			strMing = new String(byteMing, "UTF8");
			 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		 
		return strMing;
	}

	private byte[] getEncCode(byte byteS[])
	{
		byte byteFina[] = (byte[])null;
		Cipher cipher;
		try
		{
			cipher = Cipher.getInstance("DES");
			cipher.init(1, key);
			byteFina = cipher.doFinal(byteS);
			 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		return byteFina;
	}

	private byte[] getDesCode(byte byteD[])
	{
		byte byteFina[] = (byte[])null;
		Cipher cipher;
		try
		{
			cipher = Cipher.getInstance("DES");
			cipher.init(2, key);
			byteFina = cipher.doFinal(byteD);
			 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		 
		return byteFina;
	}

	public static void main(String args[])
	{
		ThreeDES des = new ThreeDES();
		des.getKey("abcdefgasiainfo");
		String strEnc = des.getEncString("abc");
		System.out.println(strEnc);
		String strDes = des.getDesString(strEnc);
		System.out.println(strDes);
	}
}
