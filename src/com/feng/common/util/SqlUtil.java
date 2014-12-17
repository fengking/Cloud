// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SqlUtil.java

package com.feng.common.util;

import com.feng.common.model.SqlCommonQto;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.feng.common.util:
//			BeanUtil

public class SqlUtil
{

	private static Log log = LogFactory.getLog(com.feng.common.util.SqlUtil.class);

	public SqlUtil()
	{
	}

	public static String getModelName(Serializable model)
		throws Exception
	{
		return getModelName(model.getClass());
	}

	public static String getModelName(Class clazz)
		throws Exception
	{
		return BeanUtil.getClassName(clazz);
	}

	public static SqlCommonQto getSqlCommonQto(Serializable model)
		throws Exception
	{
		try
		{
		SqlCommonQto qto;
		Map map;
		String modelName;
		String aliasName;
		qto = new SqlCommonQto();
		map = BeanUtil.describeNullValue(model);
		modelName = getModelName(model);
		aliasName = modelName.toLowerCase();
		if (map != null && !map.isEmpty())
			 
		qto.setHql((new StringBuilder("select ")).append(aliasName).append(" from ").append(modelName).append(" as ").append(aliasName).append("  where 1=1 ").toString());
		qto.setCounthql((new StringBuilder("select count(")).append(aliasName).append(") from ").append(modelName).append(" as ").append(aliasName).append(" where 1=1 ").toString());
		return qto;
		StringBuffer sb = new StringBuffer(" (");
		java.util.Map.Entry e;
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); qto.addParams(e.getValue()))
		{
			e = (java.util.Map.Entry)iterator.next();
			sb.append(" ").append((String)e.getKey()).append("=? and");
		}

		sb.delete(sb.length() - 3, sb.length()).append(") ");
		qto.setHql((new StringBuilder("select ")).append(aliasName).append(" from ").append(modelName).append(" as ").append(aliasName).append(" where ").append(sb.toString()).toString());
		qto.setCounthql((new StringBuilder("select count(")).append(aliasName).append(") from ").append(modelName).append(" as ").append(aliasName).append(" where ").append(sb.toString()).toString());
		qto.setWherehsql(sb.toString());
		return qto;
		}
		catch(Exception e)
		{
		log.error("将model文件转化为hql异常", e);
		throw e;
		}
	}

	public static void main(String args[])
		throws Exception
	{
		System.out.println(getModelName(com.feng.common.util.SqlUtil.class));
	}

}
