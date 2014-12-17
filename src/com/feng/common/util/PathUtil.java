// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PathUtil.java

package com.feng.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PathUtil
{

	private static Log log = LogFactory.getLog(com.feng.common.util.PathUtil.class);
	private static PathUtil pathutil = new PathUtil();

	public static PathUtil getInstance()
	{
		return pathutil;
	}

	public PathUtil()
	{
	}

	public String getRealPath()
	{
		String realPath = pathutil.getClass().getResource("/").getPath();
		if (realPath != null)
		{
			if (realPath.endsWith("!"))
				realPath = realPath.substring(0, realPath.lastIndexOf("/"));
			if (realPath.startsWith("file"))
				realPath = realPath.substring(realPath.indexOf("/") + 1);
			try
			{
				realPath = URLDecoder.decode(realPath, "utf-8");
			}
			catch (UnsupportedEncodingException e)
			{
				log.error("对地址进行转码失败", e);
			}
			if (realPath.charAt(0) == '/')
				realPath = realPath.substring(1);
			log.debug((new StringBuilder("使用配置文件")).append(realPath).toString());
			return realPath;
		} else
		{
			return null;
		}
	}

	public boolean isInJarFile()
	{
		String path = getRealPath();
		return path.endsWith("!");
	}

}
