// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PKIUtils.java

package com.feng.common.security;

import java.io.InputStream;
import java.security.*;
import java.security.cert.*;
import java.security.cert.Certificate;

import javax.crypto.Cipher;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PKIUtils
{

	private static final Log log = LogFactory.getLog(com.feng.common.security.PKIUtils.class);

	private PKIUtils()
	{
	}

	public static byte[] signature(InputStream in, String storePassword, String keyPassword, String key, byte data[])
	{
		try
		{
		byte signed[];
		PrivateKey privateKey = getPrivateKey(in, storePassword, keyPassword, key);
		Signature signet = Signature.getInstance("MD5withRSA");
		signet.initSign(privateKey);
		signet.update(data);
		signed = signet.sign();
		return signed;
		}
		catch(Exception ex)
		{ 
		log.error("签名失败", ex);
		return null;
		}
	}

	public static boolean verifySignature(InputStream in, byte data[], byte signatureData[])
	{
		try
		{
		boolean result;
		PublicKey key = getPublicKey(in);
		Signature signet = Signature.getInstance("MD5withRSA");
		signet.initVerify(key);
		signet.update(data);
		result = signet.verify(signatureData);
		return result;
		}
		catch(Exception ex)
		{
		 
		log.error("验证签名失败", ex);
		return false;
		}
	}

	private static PublicKey getPublicKey(InputStream in)
	{
		try
		{
		PublicKey key;
		CertificateFactory factory = CertificateFactory.getInstance("X.509");
		Certificate cert = factory.generateCertificate(in);
		key = cert.getPublicKey();
		return key;
		}
		catch(CertificateException ex)
		{
		log.error("获取证书公钥失败", ex);
		return null;
		}
	}

	public static byte[] encrypt(Key key, byte data[])
	{
		try
		{
		byte encryptedData[];
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(1, key);
		encryptedData = cipher.doFinal(data);
		return encryptedData;
		}
		catch(Exception ex)
		{
		 
		log.error("加密数据失败", ex);
		return null;
		}
	}

	public static byte[] encryptWithPublicKey(InputStream in, byte data[])
	{
		try
		{
		byte encryptedData[];
		PublicKey key = getPublicKey(in);
		encryptedData = encrypt(key, data);
		return encryptedData;
		}
		catch(Exception ex){
		log.error("用证书的公钥加密失败", ex);
		return null;
		}
	}

	public static byte[] encryptWithPrivateKey(InputStream in, String storePassword, String keyPassword, String key, byte data[])
	{
		try
		{
		byte encryptedData[];
		PrivateKey privateKey = getPrivateKey(in, storePassword, keyPassword, key);
		encryptedData = encrypt(privateKey, data);
		return encryptedData;
		}
		catch(Exception ex){
		log.error("用证书的私钥加密失败", ex);
		return null;
		}
	}

	private static PrivateKey getPrivateKey(InputStream in, String storePassword, String keyPassword, String key)
	{
		try
		{
		PrivateKey privateKey;
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(in, storePassword.toCharArray());
		privateKey = (PrivateKey)ks.getKey(key, keyPassword.toCharArray());
		return privateKey;
		}catch(Exception ex)
		{
		log.error("获取证书私钥失败", ex);
		return null;
		}
	}

	public static byte[] decrypt(Key key, byte data[])
	{
		try
		{
		byte result[];
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(2, key);
		result = cipher.doFinal(data);
		return result;
		}
		catch(Exception ex)
		{
		 
		log.error("解密数据失败", ex);
		return null;}
	}

	public static byte[] decryptWithPrivateKey(InputStream in, String storePassword, String keyPassword, String key, byte data[])
	{
		try
		{
		byte result[];
		PrivateKey privateKey = getPrivateKey(in, storePassword, keyPassword, key);
		result = decrypt(privateKey, data);
		return result;
		}
		catch(Exception ex)
		{
		log.error("用证书的私钥解密失败", ex);
		return null;
		}
	}

	public static byte[] decryptWithPublicKey(InputStream in, byte data[])
	{
		try
		{
		byte result[];
		PublicKey key = getPublicKey(in);
		result = decrypt(key, data);
		return result;
		}
		catch(Exception ex){
		log.error("用证书的公钥解密失败", ex);
		return null;
		}
	}

}
