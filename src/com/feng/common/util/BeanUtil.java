// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BeanUtil.java

package com.feng.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanUtil
{

	private static Log log = LogFactory.getLog(com.feng.common.util.BeanUtil.class);

	public BeanUtil()
	{
	}

	public static Object createObject(String clazzName)
		throws Exception
	{
		try
		{
		return Class.forName(clazzName).newInstance();
		}
		catch(ClassNotFoundException e)
		{
		log.error("加载类失败!类未找到", e);
		throw new Exception("加载类失败!类未找到", e);
		}
	}

	public static Object getProperties(Object obj, String name)
		throws Exception
	{
		Field field = obj.getClass().getDeclaredField(name);
		if (field == null)
		{
			log.error((new StringBuilder("获取对象:")).append(obj).append("中属性:").append(name).append("的值错误! 无此属性").toString());
			throw new Exception((new StringBuilder("获取对象:")).append(obj).append("中属性:").append(name).append("的值错误! 无此属性").toString());
		}
		Method method = null;
		try
		{
			method = obj.getClass().getMethod((new StringBuilder("get")).append(String.valueOf(name.charAt(0)).toUpperCase()).append(name.substring(1)).toString(), new Class[0]);
		}
		catch (NoSuchMethodException e)
		{
			log.error((new StringBuilder("获取对象:")).append(obj).append("中属性:").append(name).append("的值错误! 没有此方法").toString(), e);
			throw e;
		}
		if ("void".equals(method.getReturnType().toString()))
		{
			log.error((new StringBuilder("获取对象:")).append(obj).append("中属性:").append(name).append("的值错误! 方法返回值为空").toString());
			throw new Exception((new StringBuilder("获取对象:")).append(obj).append("中属性:").append(name).append("的值错误! 方法返回值为空").toString());
		} else
		{
			return method.invoke(obj, new Object[0]);
		}
	}

	public static void setProperties(Object obj, String name, Object value)
		throws Exception
	{
		Method method = null;
		try
		{
			method = obj.getClass().getMethod((new StringBuilder("set")).append(String.valueOf(name.charAt(0)).toUpperCase()).append(name.substring(1)).toString(), new Class[] {
				value != null ? value.getClass() : obj.getClass().getDeclaredField(name).getType()
			});
		}
		catch (NoSuchMethodException e)
		{
			log.error((new StringBuilder("设置对象:")).append(obj).append("中属性:").append(name).append("的值错误! 无此方法").toString());
			throw new Exception((new StringBuilder("设置对象:")).append(obj).append("中属性:").append(name).append("的值错误! 无此方法").toString());
		}
		method.invoke(obj, new Object[] {
			value
		});
	}

	public static void copyPropertys(Object fromobj, Object toobj)
		throws Exception
	{
		try
		{
			Map map = describeNullValue(fromobj);
			java.util.Map.Entry e;
			for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); setProperties(toobj, (String)e.getKey(), e.getValue()))
				e = (java.util.Map.Entry)iterator.next();

		}
		catch (Exception e)
		{
			log.error("将对象1中的不为空的数据拷贝到对象2异常", e);
			throw new Exception("将对象1中的不为空的数据拷贝到对象2异常", e);
		}
	}

	public static String getClassName(Object obj)
	{
		String className = obj.getClass().getCanonicalName();
		if (className.indexOf(".") != -1)
			return className.substring(className.lastIndexOf(".") + 1);
		else
			return className;
	}

	public static String getClassName(Class clazz)
	{
		String className = clazz.getName();
		if (className.indexOf(".") != -1)
			return className.substring(className.lastIndexOf(".") + 1);
		else
			return className;
	}

	public static Map describe(Object obj)
		throws Exception
	{
		Map map = new HashMap();
		Field fields[] = obj.getClass().getDeclaredFields();
		Field afield[];
		int j = (afield = fields).length;
		for (int i = 0; i < j; i++)
		{
			Field field = afield[i];
			map.put(field.getName(), getFieldValue(obj, field));
		}

		return map;
	}

	public static Map describeNullValue(Object obj)
		throws Exception
	{
		Map map = new HashMap();
		Field fields[] = obj.getClass().getDeclaredFields();
		Field afield[];
		int j = (afield = fields).length;
		for (int i = 0; i < j; i++)
		{
			Field field = afield[i];
			Object object = getFieldValue(obj, field);
			if (object != null)
				map.put(field.getName(), object);
		}

		return map;
	}

	public static Object invokeMethod(Class clazz, String methodName, Object params[])
		throws Exception
	{
		Object obj = clazz.newInstance();
		return invokeMethod(obj, methodName, params);
	}

	public static Object invokeMethod(Object obj, String methodName, Object params[])
		throws Exception
	{
		try
		{
		Method method;
		method = null;
		if (params == null)
		{
			method = obj.getClass().getMethod(methodName, new Class[0]);
		} else
		{
			Class clazzs[] = new Class[params.length];
			Object aobj[];
			int j = (aobj = params).length;
			for (int i = 0; i < j; i++)
			{
				Object o = aobj[i];
				clazzs[0] = o.getClass();
			}

			method = obj.getClass().getMethod(methodName, clazzs);
		}
		return method.invoke(obj, params);
		}
		catch(Exception e)
		{
		log.error((new StringBuilder("执行对象")).append(obj.getClass()).append("中方法:").append(methodName).append("时错误!").toString(), e);
		throw e;
		}
	}

	public static void populate(Object obj, Map map)
		throws Exception
	{
		java.util.Map.Entry e;
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); setProperties(obj, (String)e.getKey(), e.getValue()))
			e = (java.util.Map.Entry)iterator.next();

	}

	private static Object getFieldValue(Object obj, Field field)
		throws Exception
	{
		Method method = null;
		try
		{
			method = obj.getClass().getMethod((new StringBuilder("get")).append(String.valueOf(field.getName().charAt(0)).toUpperCase()).append(field.getName().substring(1)).toString(), new Class[0]);
		}
		catch (NoSuchMethodException e)
		{
			log.error((new StringBuilder("属性:")).append(field.getName()).append("没有get方法，无法拷贝值").toString());
			return null;
		}
		if (method.getReturnType().equals("void"))
			return null;
		else
			return method.invoke(obj, new Object[0]);
	}

}
