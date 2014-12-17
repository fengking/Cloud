// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ClobUtil.java

package com.feng.common.util;

import java.io.BufferedReader;
import java.sql.Clob;
import javax.sql.rowset.serial.SerialClob;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.feng.common.util:
//			FileUtil

public class ClobUtil
{

	private static Log log = LogFactory.getLog(com.feng.common.util.ClobUtil.class);

	public ClobUtil()
	{
	}

	public static String getString(Clob c)
		throws Exception
	{
		BufferedReader reader;
		Exception exception;
		reader = null;
		String s1;
		try
		{
			StringBuffer s = new StringBuffer();
			if (c != null)
			{
				reader = new BufferedReader(c.getCharacterStream());
				String str;
				while ((str = reader.readLine()) != null) 
					s.append(str);
			}
			s1 = s.toString();
		}
		catch (Exception e)
		{
			log.error("Clob转化为String异常", e);
			throw e;
		}
		finally
		{
			if (reader != null)
				try
				{
					reader.close();
				}
				catch (Exception e)
				{
					log.error("关闭reader时发生错误!", e);
					throw e;
				}
		}
		
		return s1; 
	}

	public static Clob getClob(String s)
		throws Exception
	{
		Clob c = null;
		try
		{
			if (s != null)
				c = new SerialClob(s.toCharArray());
		}
		catch (Exception e)
		{
			log.error("根据字符串取得Clob时错误!", e);
			throw e;
		}
		return c;
	}

	public static Clob getClob(String filePath, String encoding)
		throws Exception
	{
		try
		{
		String s = FileUtil.readFileToString(filePath, encoding);
		return getClob(s);
		}
		catch(Exception e)
		{
		log.error("根据文件取得Clob时错误!", e);
		throw e;
		}
	}

}
