// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PropertiesUtil.java

package com.feng.common.util;

import java.io.*;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertiesUtil
{

	private static Log log = LogFactory.getLog(com.feng.common.util.PropertiesUtil.class);

	public PropertiesUtil()
	{
	}

	public static String getProperty(String filePath, String key)
		throws Exception
	{
		FileInputStream fis;
		Exception exception;
		fis = null;
		String s;
		try
		{
			fis = new FileInputStream(new File(filePath));
			Properties prop = new Properties();
			prop.load(fis);
			s = (String)prop.get(key);
		}
		catch (Exception e)
		{
			log.error("加载properties文件时错误!", e);
			throw e;
		}
		finally
		{
			if (fis != null)
				try
				{
					fis.close();
				}
				catch (Exception e)
				{
					log.error("关闭文件流时错误!", e);
				} 
		}
		
		return s; 
	}

	public static void setProperty(String filePath, String key, String value)
		throws Exception
	{
		InputStream fis;
		OutputStream fos;
		fis = null;
		fos = null;
		try
		{
			fis = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fis);
			fos = new FileOutputStream(filePath);
			prop.setProperty(key, value);
			prop.store(fos, (new StringBuilder("Update '")).append(key).append("' value").toString());
		}
		catch (Exception e)
		{
			log.error("加载properties文件时错误!", e);
			throw e;
		}
		 
		if (fos != null)
			try
			{
				fos.close();
			}
			catch (Exception e)
			{
				log.error("关闭文件流时错误!", e);
			}
		if (fis != null)
			try
			{
				fis.close();
			}
			catch (Exception e)
			{
				log.error("关闭文件流时错误!", e);
			}
		 
		return;
	}

	public static Map getAllProperty(String filePath)
		throws Exception
	{
		FileInputStream fis;
		Exception exception;
		fis = null;
		Map map1;
		try
		{
			fis = new FileInputStream(new File(filePath));
			Properties prop = new Properties();
			prop.load(fis);
			Map map = new HashMap();
			java.util.Map.Entry entry;
			for (Iterator iterator = prop.entrySet().iterator(); iterator.hasNext(); map.put(entry.getKey().toString(), entry.getValue().toString()))
				entry = (java.util.Map.Entry)iterator.next();

			map1 = map;
		}
		catch (Exception e)
		{
			log.error("加载properties文件时错误!", e);
			throw e;
		}
		finally
		{
			if (fis != null)
				try
				{
					fis.close();
				}
				catch (Exception e)
				{
					log.error("关闭文件流时错误!", e);
				}
		} 
		return map1;
		 
	}

	public static void setAllProperty(String filePath, Map map)
		throws Exception
	{
		InputStream fis;
		OutputStream fos;
		fis = null;
		fos = null;
		try
		{
			fis = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fis);
			fos = new FileOutputStream(filePath);
			java.util.Map.Entry entry;
			for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); prop.setProperty((String)entry.getKey(), (String)entry.getValue()))
				entry = (java.util.Map.Entry)iterator.next();

			prop.store(fos, "Update all value");
		}
		catch (Exception e)
		{
			log.error("加载properties文件时错误!", e);
			throw e;
		}
		 
		if (fos != null)
			try
			{
				fos.close();
			}
			catch (Exception e)
			{
				log.error("关闭文件流时错误!", e);
			}
		if (fis != null)
			try
			{
				fis.close();
			}
			catch (Exception e)
			{
				log.error("关闭文件流时错误!", e);
			} 
		return;
	}

}
