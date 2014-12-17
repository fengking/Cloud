// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DateUtil.java

package com.feng.common.util;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{

	private static String hours[] = {
		"", "1小时", "2小时", "3小时", "4小时", "5小时", "6小时", "7小时", "8小时", "9小时", 
		"10小时", "11小时", "12小时", "13小时", "14小时", "15小时", "16小时", "17小时", "18小时", "19小时", 
		"20小时", "21小时", "22小时", "23小时"
	};
	private static String mins[] = {
		"", "1分钟", "2分钟", "3分钟", "4分钟", "5分钟", "6分钟", "7分钟", "8分钟", "9分钟", 
		"10分钟", "11分钟", "12分钟", "13分钟", "14分钟", "15分钟", "16分钟", "17分钟", "18分钟", "19分钟", 
		"20分钟", "21分钟", "22分钟", "23分钟", "24分钟", "25分钟", "26分钟", "27分钟", "28分钟", "29分钟", 
		"30分钟", "31分钟", "32分钟", "33分钟", "34分钟", "35分钟", "36分钟", "37分钟", "38分钟", "39分钟", 
		"40分钟", "41分钟", "42分钟", "43分钟", "44分钟", "45分钟", "46分钟", "47分钟", "48分钟", "49分钟", 
		"50分钟", "51分钟", "52分钟", "53分钟", "54分钟", "55分钟", "56分钟", "57分钟", "58分钟", "59分钟"
	};
	private static String secs[] = {
		"", "1秒", "2秒", "3秒", "4秒", "5秒", "6秒", "7秒", "8秒", "9秒", 
		"10秒", "11秒", "12秒", "13秒", "14秒", "15秒", "16秒", "17秒", "18秒", "19秒", 
		"20秒", "21秒", "22秒", "23秒", "24秒", "25秒", "26秒", "27秒", "28秒", "29秒", 
		"30秒", "31秒", "32秒", "33秒", "34秒", "35秒", "36秒", "37秒", "38秒", "39秒", 
		"40秒", "41秒", "42秒", "43秒", "44秒", "45秒", "46秒", "47秒", "48秒", "49秒", 
		"50秒", "51秒", "52秒", "53秒", "54秒", "55秒", "56秒", "57秒", "58秒", "59秒"
	};
	private static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";
	private static final String DATE_FORMAT_MMDD = "MM-dd";
	private static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	private static final String DATE_FORMAT_YYMMDDHHMMSS = "yyMMddHHmmss";
	private static int DAY = 0x5265c00;
	private static int HOUR = 0x36ee80;
	private static int MIN = 60000;
	private static int SEC = 1000;

	public DateUtil()
	{
	}

	public static String dateFormat(Date date)
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String formatCur = dateFormatter.format(date);
		return formatCur;
	}

	public static String dateFormatMMDD(Date date)
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd");
		String formatCur = dateFormatter.format(date);
		return formatCur;
	}

	public static String dateFormat(String date)
		throws ParseException
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFormat = dateFormatter.parse(date);
		String formatCur = dateFormatter.format(dateFormat);
		return formatCur;
	}

	public static String dateFormatHHMMSS(Date date)
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (date == null)
			return "";
		else
			return dateFormatter.format(date);
	}

	public static String timestampFormatyyMMddHHmmss(Date date)
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyMMddHHmmss");
		if (date == null)
			return "";
		else
			return dateFormatter.format(date);
	}

	public static String dateFormatHHMMSS(String date)
		throws ParseException
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateFormat = dateFormatter.parse(date);
		String formatCur = dateFormatter.format(dateFormat);
		return formatCur;
	}

	public static long DateDiff(Date startDate, Date endDate)
	{
		long diff = endDate.getTime() - startDate.getTime();
		return diff / 0x5265c00L;
	}

	public static java.sql.Date DateAddDays(java.sql.Date date, int days)
	{
		Calendar temp = Calendar.getInstance();
		temp.setTimeInMillis(date.getTime());
		temp.add(5, days);
		return new java.sql.Date(temp.getTimeInMillis());
	}

	public static java.sql.Date getCurrentDateTime()
	{
		Date date = new Date();
		return new java.sql.Date(date.getTime());
	}

	public static String getTimeStr(long diff)
	{
		long day = 0L;
		long hour = 0L;
		long min = 0L;
		long sec = 0L;
		day = diff / (long)DAY;
		hour = (diff % (long)DAY) / (long)HOUR;
		min = (diff % (long)HOUR) / (long)MIN;
		sec = (diff % (long)MIN) / (long)SEC;
		return (new StringBuilder(String.valueOf(day <= 0L ? "" : ((Object) ((new StringBuilder(String.valueOf(day))).append("天").toString()))))).append(hours[(int)hour]).append(mins[(int)min]).append(secs[(int)sec]).toString();
	}

	public static String getLimitTimeStr(long diff)
	{
		long day = 0L;
		long hour = 0L;
		long min = 0L;
		long sec = 0L;
		long time = diff - System.currentTimeMillis();
		String ret = "";
		if (time < 0L)
		{
			ret = "已过去";
			time *= -1L;
		} else
		if (time > 0L)
			ret = "还有";
		day = time / (long)DAY;
		hour = (time % (long)DAY) / (long)HOUR;
		min = (time % (long)HOUR) / (long)MIN;
		sec = (time % (long)MIN) / (long)SEC;
		return (new StringBuilder(String.valueOf(ret))).append(day <= 0L ? "" : (new StringBuilder(String.valueOf(day))).append("天").toString()).append(hours[(int)hour]).append(mins[(int)min]).append(secs[(int)sec]).toString();
	}

	public static String dateFormat(Date date, String format)
	{
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	public static void main(String args[])
	{
		System.out.println(getLimitTimeStr(System.currentTimeMillis() - 0x5f5e100L));
	}

}
