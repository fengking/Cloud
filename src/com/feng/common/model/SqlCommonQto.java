// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SqlCommonQto.java

package com.feng.common.model;

import java.util.ArrayList;
import java.util.List;

public class SqlCommonQto
{

	private String hql;
	private String wherehsql;
	private String counthql;
	private List params;

	public SqlCommonQto()
	{
		params = new ArrayList();
	}

	public String getHql()
	{
		return hql;
	}

	public void setHql(String hql)
	{
		this.hql = hql;
	}

	public List getParams()
	{
		return params;
	}

	public void setParams(List params)
	{
		this.params = params;
	}

	public void addParams(Object o)
	{
		params.add(o);
	}

	public String getWherehsql()
	{
		return wherehsql;
	}

	public void setWherehsql(String wherehsql)
	{
		this.wherehsql = wherehsql;
	}

	public String getCounthql()
	{
		return counthql;
	}

	public void setCounthql(String counthql)
	{
		this.counthql = counthql;
	}
}
