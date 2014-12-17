// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DecimalUtil.java

package com.feng.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalUtil
{

	private static final String CURRENT_FORMAT_TWO = "##0.00";
	private static final String CURRENT_FORMAT_FORE = "##0.0000";
	private static final String CURRENT_FORMAT_COMMA = "###,###,###,###,###,###,###,###,###,##0.00";
	private static final String CURRENT_FORMAT_INT = "#";
	private static final String ORMID = "0000";

	public DecimalUtil()
	{
	}

	public static String currentFormatTwo(BigDecimal current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("##0.00");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatTwo(int current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("##0.00");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatTwo(float current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("##0.00");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatTwo(double current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("##0.00");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatORM(double number)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("0000");
		String formatCur = doubleFormat.format(number);
		return formatCur;
	}

	public static String currentFormatTwo(String current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("##0.00");
		BigDecimal bdCurrent = new BigDecimal(current);
		String formatCur = doubleFormat.format(bdCurrent);
		if (formatCur.equals("-0.00"))
			formatCur = "0.00";
		return formatCur;
	}

	public static String currentFormatFour(BigDecimal current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("##0.0000");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatFour(int current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("##0.0000");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatFour(float current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("##0.0000");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatFour(double current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("##0.0000");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatFour(String current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("##0.0000");
		BigDecimal bdCurrent = new BigDecimal(current);
		String formatCur = doubleFormat.format(bdCurrent);
		return formatCur;
	}

	public static String currentFormatInt(BigDecimal current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("#");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatInt(int current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("#");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatInt(float current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("#");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatComma(BigDecimal current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("###,###,###,###,###,###,###,###,###,##0.00");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatInt(double current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("#");
		String formatCur = doubleFormat.format(current);
		return formatCur;
	}

	public static String currentFormatInt(String current)
	{
		DecimalFormat doubleFormat = new DecimalFormat();
		doubleFormat.applyPattern("#");
		BigDecimal bdCurrent = new BigDecimal(current);
		String formatCur = doubleFormat.format(bdCurrent);
		return formatCur;
	}

	public static BigDecimal add(Object num1, Object num2)
	{
		BigDecimal bigD_1 = new BigDecimal(0);
		BigDecimal bigD_2 = new BigDecimal(0);
		if (num1 != null)
			bigD_1 = new BigDecimal(num1.toString().trim());
		if (num2 != null)
			bigD_2 = new BigDecimal(num2.toString().trim());
		return bigD_1.add(bigD_2);
	}

	public static BigDecimal subtract(Object num1, Object num2)
	{
		BigDecimal bigD_1 = new BigDecimal(0);
		BigDecimal bigD_2 = new BigDecimal(0);
		if (num1 != null)
			bigD_1 = new BigDecimal(num1.toString().trim());
		if (num2 != null)
			bigD_2 = new BigDecimal(num2.toString().trim());
		return bigD_1.subtract(bigD_2);
	}

	public static BigDecimal multiply(Object num1, Object num2)
	{
		BigDecimal bigD_1 = new BigDecimal(0);
		BigDecimal bigD_2 = new BigDecimal(0);
		if (num1 != null)
			bigD_1 = new BigDecimal(num1.toString().trim());
		if (num1 != null)
			bigD_2 = new BigDecimal(num2.toString().trim());
		return bigD_1.multiply(bigD_2);
	}

	public static BigDecimal multiply(Object num1, Object num2, int scale)
	{
		BigDecimal bigD_1 = new BigDecimal(0);
		BigDecimal bigD_2 = new BigDecimal(0);
		if (num1 != null)
			bigD_1 = new BigDecimal(num1.toString().trim());
		if (num1 != null)
			bigD_2 = new BigDecimal(num2.toString().trim());
		return bigD_1.multiply(bigD_2).setScale(4);
	}

	public static BigDecimal divide(Object num1, Object num2, int scale)
	{
		BigDecimal bigD_1 = new BigDecimal(0);
		BigDecimal bigD_2 = new BigDecimal(0);
		if (num1 != null)
			bigD_1 = new BigDecimal(num1.toString().trim());
		if (num2 != null)
			bigD_2 = new BigDecimal(num2.toString().trim());
		return bigD_1.divide(bigD_2, scale, 4);
	}
}
