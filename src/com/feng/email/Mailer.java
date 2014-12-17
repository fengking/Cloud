package com.feng.email;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.velocity.exception.VelocityException;

/**
 * 
 * 邮件基类接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface Mailer {
	
	/**
	 * 同步发送Email
	 * @param receiveEmail[]
	 * @param subject
	 * @param content
	 * @throws MessagingException
	 * @throws IOException
	 */
	public void sendMailBySynchronizationMode( String[] receiveEmail, String subject, String content) throws MessagingException, IOException;
	
	/**
	 * 异步发送Email
	 * @param receiveEmail[]
	 * @param subject
	 * @param content
	 */
	public void sendMailByAsynchronousMode(final String[] receiveEmail, final String subject, final String content);
	/**
	 * 使用Velocity模板发送邮件
	 * 
	 * @throws MessagingException
	 * @throws VelocityException 
	 */
	public void templateSend(Map<String,Object> map, String[] reveiveEmail, String subject,String vmFileName) throws MessagingException, VelocityException;
}
