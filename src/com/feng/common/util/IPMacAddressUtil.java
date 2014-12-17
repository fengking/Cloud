// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   IPMacAddressUtil.java

package com.feng.common.util;

import java.net.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.net.util.IPAddressUtil;

public class IPMacAddressUtil
{

	private static Log log = LogFactory.getLog(com.feng.common.util.IPMacAddressUtil.class);
	private static String IPV4 = "IPv4";
	private static String IPV6 = "IPv6";

	public IPMacAddressUtil()
	{
	}

	public static String convNumToIPv4(long ip)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 3; i >= 0; i--)
		{
			sb.append(ip >>> i * 8 & 255L);
			if (i != 0)
				sb.append('.');
		}

		return sb.toString();
	}

	public static long convIpv4ToNum(String ip)
	{
		long num = 0L;
		String sections[] = ip.split("\\.");
		int i = 3;
		String as[];
		int k = (as = sections).length;
		for (int j = 0; j < k; j++)
		{
			String str = as[j];
			num += Long.parseLong(str) << i * 8;
			i--;
		}

		return num;
	}

	public static String convIntToIpv4(int ip1, int ip2, int ip3, int ip4)
	{
		String ip = (new StringBuilder(String.valueOf(String.valueOf(ip1)))).append(".").append(String.valueOf(ip2)).append(".").append(String.valueOf(ip3)).append(".").append(String.valueOf(ip4)).toString();
		if (isIPv4(ip))
			return ip;
		else
			return null;
	}

	public static boolean isIPv4(String ipAddress)
	{
		String ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		Pattern pattern = Pattern.compile(ip);
		Matcher matcher = pattern.matcher(ipAddress);
		return matcher.matches();
	}

	public static boolean isIPV6(String address)
	{
		return IPAddressUtil.isIPv6LiteralAddress(address);
	}

	public static String getLocalIP()
	{
		return null;
	}

	public static boolean isAfter(String ipv4, String beforeIpv4)
	{
		long ipint = convIpv4ToNum(ipv4);
		long beforeint = convIpv4ToNum(beforeIpv4);
		return ipint > beforeint;
	}

	public static boolean isBefore(String ipv4, String afterIpv4)
	{
		long ipint = convIpv4ToNum(ipv4);
		long afterint = convIpv4ToNum(afterIpv4);
		return ipint < afterint;
	}

	public int compore(String ipv4, String ipv4two)
	{
		long ipint = convIpv4ToNum(ipv4);
		long afterint = convIpv4ToNum(ipv4two);
		if (ipint > afterint)
			return 1;
		return ipint != afterint ? -1 : 0;
	}

	public static String getIPAddress()
		throws Exception
	{
		try
		{
		String ipString;
		ipString = null;
		InetAddress ipAddress = null;
		InetAddress ipAddress = InetAddress.getLocalHost();
		ipString = ipAddress.getHostAddress();
		return ipString;
		}
		catch(UnknownHostException e)
		{
		String error = "解析IP地址发生异常！";
		log.error(error, e);
		throw new Exception(error, e);
		}
	}

	public static Map getAllIPAddress()
		throws Exception
	{
		try
		{
		Map map = new HashMap();
		for (Enumeration e1 = NetworkInterface.getNetworkInterfaces(); e1.hasMoreElements();)
		{
			NetworkInterface nic = (NetworkInterface)e1.nextElement();
			for (Enumeration e2 = nic.getInetAddresses(); e2.hasMoreElements();)
			{
				InetAddress ia = (InetAddress)e2.nextElement();
				if (ia instanceof Inet6Address)
					map.put(ia.getHostAddress(), IPV6);
				else
					map.put(ia.getHostAddress(), IPV4);
			}

		}

		return map;
		}
		catch(Exception e)
		{
		String error = "解析IP地址发生异常！";
		log.error(error, e);
		throw new Exception(error, e);
		}
	}

	public static Map getAllPhysicalAddress()
		throws Exception
	{
		try
		{
		Map map = new HashMap();
		String MacAddr = "";
		String str = "";
		for (Enumeration e1 = NetworkInterface.getNetworkInterfaces(); e1.hasMoreElements();)
		{
			NetworkInterface nic = (NetworkInterface)e1.nextElement();
			byte buf[] = nic.getHardwareAddress();
			for (int i = 0; i < buf.length; i++)
				str = (new StringBuilder(String.valueOf(str))).append(byteHEX(buf[i])).toString();

			MacAddr = str.toUpperCase();
			InetAddress ia;
			for (Enumeration e2 = nic.getInetAddresses(); e2.hasMoreElements(); map.put(ia.getHostAddress(), MacAddr))
				ia = (InetAddress)e2.nextElement();

		}

		return map;
		}
		catch(Exception e)
		{
		String error = "解析MAC地址发生异常！";
		log.error(error, e);
		throw new Exception(error, e);
		}
	}

	public static String getPhysicalAddress(String ipString)
		throws Exception
	{
		try
		{
		String physicalAddress = "";
		for (Enumeration e1 = NetworkInterface.getNetworkInterfaces(); e1.hasMoreElements();)
		{
			NetworkInterface nic = (NetworkInterface)e1.nextElement();
			byte buf[] = nic.getHardwareAddress();
			for (Enumeration e2 = nic.getInetAddresses(); e2.hasMoreElements();)
			{
				InetAddress ia = (InetAddress)e2.nextElement();
				if (ipString.equals(ia.getHostAddress()))
				{
					for (int i = 0; i < buf.length; i++)
						physicalAddress = (new StringBuilder(String.valueOf(physicalAddress))).append(byteHEX(buf[i])).append(":").toString();

					physicalAddress = physicalAddress.substring(0, physicalAddress.length() - 1).toUpperCase();
				}
			}

		}

		return physicalAddress;
		}
		catch(Exception e)
		{
		String error = "解析MAC地址发生异常！";
		log.error(error, e);
		throw new Exception(error, e);
		}
	}

	public static String getPhysicalAddress()
		throws Exception
	{
		String ipString = getIPAddress();
		return getPhysicalAddress(ipString);
	}

	public static String byteHEX(byte ib)
	{
		char Digit[] = {
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
			'a', 'b', 'c', 'd', 'e', 'f'
		};
		char ob[] = new char[2];
		ob[0] = Digit[ib >>> 4 & 0xf];
		ob[1] = Digit[ib & 0xf];
		String s = new String(ob);
		return s;
	}

}
