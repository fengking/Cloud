// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MoneyFormatUtil.java

package com.feng.common.util;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

public class MoneyFormatUtil
{

	public static final String EMPTY = "";
	public static final String ZERO = "¡„";
	public static final String ONE = "“º";
	public static final String TWO = "∑°";
	public static final String THREE = "»˛";
	public static final String FOUR = "À¡";
	public static final String FIVE = "ŒÈ";
	public static final String SIX = "¬Ω";
	public static final String SEVEN = "∆‚";
	public static final String EIGHT = "∞∆";
	public static final String NINE = "æ¡";
	public static final String TEN = " ∞";
	public static final String HUNDRED = "∞€";
	public static final String THOUSAND = "«™";
	public static final String TEN_THOUSAND = "ÕÚ";
	public static final String HUNDRED_MILLION = "“⁄";
	public static final String YUAN = "‘™";
	public static final String JIAO = "Ω«";
	public static final String FEN = "∑÷";
	public static final String DOT = ".";
	private static MoneyFormatUtil formatter = null;
	private HashMap chineseNumberMap;
	private HashMap chineseMoneyPattern;
	private NumberFormat numberFormat;
	private DecimalFormat decimalFormat;

	private MoneyFormatUtil()
	{
		chineseNumberMap = new HashMap();
		chineseMoneyPattern = new HashMap();
		numberFormat = NumberFormat.getInstance();
		decimalFormat = new DecimalFormat("#,##0.00");
		decimalFormat.setDecimalSeparatorAlwaysShown(true);
		decimalFormat.setMaximumFractionDigits(2);
		decimalFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setGroupingUsed(false);
		chineseNumberMap.put("0", "¡„");
		chineseNumberMap.put("1", "“º");
		chineseNumberMap.put("2", "∑°");
		chineseNumberMap.put("3", "»˛");
		chineseNumberMap.put("4", "À¡");
		chineseNumberMap.put("5", "ŒÈ");
		chineseNumberMap.put("6", "¬Ω");
		chineseNumberMap.put("7", "∆‚");
		chineseNumberMap.put("8", "∞∆");
		chineseNumberMap.put("9", "æ¡");
		chineseNumberMap.put(".", ".");
		chineseMoneyPattern.put("1", " ∞");
		chineseMoneyPattern.put("2", "∞€");
		chineseMoneyPattern.put("3", "«™");
		chineseMoneyPattern.put("4", "ÕÚ");
		chineseMoneyPattern.put("5", " ∞");
		chineseMoneyPattern.put("6", "∞€");
		chineseMoneyPattern.put("7", "«™");
		chineseMoneyPattern.put("8", "“⁄");
	}

	public static MoneyFormatUtil getInstance()
	{
		if (formatter == null)
			formatter = new MoneyFormatUtil();
		return formatter;
	}

	public String format(String moneyStr)
	{
		String result = convertToChineseNumber(moneyStr);
		result = addUnitsToChineseMoneyString(result);
		return result;
	}

	public String format(double moneyDouble)
	{
		return format(numberFormat.format(moneyDouble));
	}

	public String format(int moneyInt)
	{
		return format(numberFormat.format(moneyInt));
	}

	public String format(long moneyLong)
	{
		return format(numberFormat.format(moneyLong));
	}

	public String format(Number moneyNum)
	{
		return format(numberFormat.format(moneyNum));
	}

	public String pattern(double moneyDouble)
	{
		return decimalFormat.format(moneyDouble);
	}

	public String pattern(long moneyLong)
	{
		return decimalFormat.format(moneyLong);
	}

	public String pattern(int moneyInt)
	{
		return decimalFormat.format(moneyInt);
	}

	private String convertToChineseNumber(String moneyStr)
	{
		StringBuffer cMoneyStringBuffer = new StringBuffer();
		for (int i = 0; i < moneyStr.length(); i++)
			cMoneyStringBuffer.append((String)chineseNumberMap.get(moneyStr.substring(i, i + 1)));

		int indexOfDot = cMoneyStringBuffer.indexOf(".");
		int moneyPatternCursor = 1;
		for (int i = indexOfDot - 1; i > 0; i--)
		{
			cMoneyStringBuffer.insert(i, (String)chineseMoneyPattern.get((new StringBuilder()).append(moneyPatternCursor).toString()));
			moneyPatternCursor = moneyPatternCursor != 8 ? moneyPatternCursor + 1 : 1;
		}

		String fractionPart = cMoneyStringBuffer.substring(cMoneyStringBuffer.indexOf("."));
		cMoneyStringBuffer.delete(cMoneyStringBuffer.indexOf("."), cMoneyStringBuffer.length());
		for (; cMoneyStringBuffer.indexOf("¡„ ∞") != -1; cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("¡„ ∞"), cMoneyStringBuffer.indexOf("¡„ ∞") + 2, "¡„"));
		for (; cMoneyStringBuffer.indexOf("¡„∞€") != -1; cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("¡„∞€"), cMoneyStringBuffer.indexOf("¡„∞€") + 2, "¡„"));
		for (; cMoneyStringBuffer.indexOf("¡„«™") != -1; cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("¡„«™"), cMoneyStringBuffer.indexOf("¡„«™") + 2, "¡„"));
		for (; cMoneyStringBuffer.indexOf("¡„ÕÚ") != -1; cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("¡„ÕÚ"), cMoneyStringBuffer.indexOf("¡„ÕÚ") + 2, "ÕÚ"));
		for (; cMoneyStringBuffer.indexOf("¡„“⁄") != -1; cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("¡„“⁄"), cMoneyStringBuffer.indexOf("¡„“⁄") + 2, "“⁄"));
		for (; cMoneyStringBuffer.indexOf("¡„¡„") != -1; cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("¡„¡„"), cMoneyStringBuffer.indexOf("¡„¡„") + 2, "¡„"));
		if (cMoneyStringBuffer.lastIndexOf("¡„") == cMoneyStringBuffer.length() - 1)
			cMoneyStringBuffer.delete(cMoneyStringBuffer.length() - 1, cMoneyStringBuffer.length());
		cMoneyStringBuffer.append(fractionPart);
		String result = cMoneyStringBuffer.toString();
		return result;
	}

	private String addUnitsToChineseMoneyString(String moneyStr)
	{
		StringBuffer cMoneyStringBuffer = new StringBuffer(moneyStr);
		int indexOfDot = cMoneyStringBuffer.indexOf(".");
		String Digits = cMoneyStringBuffer.substring(indexOfDot + 1);
		cMoneyStringBuffer.replace(indexOfDot, indexOfDot + 1, "‘™");
		String str = cMoneyStringBuffer.toString().substring(0, indexOfDot + 1);
		if (Digits.length() == 2)
		{
			if (Digits.equals("¡„¡„"))
			{
				str = (new StringBuilder(String.valueOf(str))).append("’˚").toString();
				return str;
			}
			if (Digits.substring(1).equals("¡„"))
			{
				Digits = (new StringBuilder(String.valueOf(Digits.substring(0, 1)))).append("Ω«").toString();
				return (new StringBuilder(String.valueOf(str))).append(Digits).toString();
			} else
			{
				Digits = (new StringBuilder(String.valueOf(Digits.substring(0, 1)))).append("Ω«").append(Digits.substring(1)).append("∑÷").toString();
				return (new StringBuilder(String.valueOf(str))).append(Digits).toString();
			}
		}
		if (Digits.length() == 1)
		{
			return (new StringBuilder(String.valueOf(str))).append(Digits).append("Ω«").toString();
		} else
		{
			Digits = Digits.substring(0, 2);
			return (new StringBuilder(String.valueOf(str))).append(Digits).toString();
		}
	}

	public static void main(String args[])
	{
		String strmoney = getInstance().format(1033456143.257D);
		System.out.println(strmoney);
		strmoney = getInstance().format("1033456143.25");
		System.out.println(strmoney);
		strmoney = getInstance().format(1033456143.2D);
		System.out.println(strmoney);
		strmoney = getInstance().format(1033456143.2D);
		System.out.println(strmoney);
		strmoney = getInstance().format(1033456143.02D);
		System.out.println(strmoney);
		strmoney = getInstance().pattern(1033456143.209D);
		System.out.println(strmoney);
		strmoney = getInstance().pattern(0x3d994a0f);
		System.out.println(strmoney);
		strmoney = getInstance().pattern(1033456143.201D);
		System.out.println(strmoney);
	}

}
