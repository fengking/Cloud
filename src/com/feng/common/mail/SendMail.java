// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SendMail.java

package com.feng.common.mail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendMail
{

	private String hostName;
	private String sendMailAddress;
	private String mailPassword;
	private boolean TLS;
	private String getMailAddress[];
	private String mailTitle;
	private String mailContent;

	public SendMail()
	{
		TLS = false;
	}

	public void send()
	{
		SimpleEmail email = new SimpleEmail();
		email.setTLS(TLS);
		email.setHostName(hostName);
		try
		{
			email.setFrom(sendMailAddress, sendMailAddress);
			email.setAuthentication(sendMailAddress, mailPassword);
			email.setCharset("utf-8");
			email.setSubject(mailTitle);
			email.setMsg(mailContent);
			for (int i = 0; i < getMailAddress.length; i++)
			{
				email.addTo(getMailAddress[i]);
				email.send();
			}

		}
		catch (EmailException emailexception) { }
	}

	public String getHostName()
	{
		return hostName;
	}

	public void setHostName(String hostName)
	{
		this.hostName = hostName;
	}

	public String getSendMailAddress()
	{
		return sendMailAddress;
	}

	public void setSendMailAddress(String sendMailAddress)
	{
		this.sendMailAddress = sendMailAddress;
	}

	public String getMailPassword()
	{
		return mailPassword;
	}

	public void setMailPassword(String mailPassword)
	{
		this.mailPassword = mailPassword;
	}

	public boolean isTLS()
	{
		return TLS;
	}

	public void setTLS(boolean tls)
	{
		TLS = tls;
	}

	public String[] getGetMailAddress()
	{
		return getMailAddress;
	}

	public void setGetMailAddress(String getMailAddress[])
	{
		this.getMailAddress = getMailAddress;
	}

	public String getMailTitle()
	{
		return mailTitle;
	}

	public void setMailTitle(String mailTitle)
	{
		this.mailTitle = mailTitle;
	}

	public String getMailContent()
	{
		return mailContent;
	}

	public void setMailContent(String mailContent)
	{
		this.mailContent = mailContent;
	}
}
