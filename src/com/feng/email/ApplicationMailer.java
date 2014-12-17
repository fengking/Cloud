package com.feng.email;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * 
 * 邮件发送类处理
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class ApplicationMailer implements Mailer{
	private JavaMailSender mailSender;

	private TaskExecutor taskExecutor;

	private SimpleMailMessage preConfiguredMessage;
	
	private VelocityEngine velocityEngine;
	
	/**
	 * 使用Velocity模板发送邮件
	 * 
	 * @throws MessagingException
	 * @throws VelocityException 
	 */
	public void templateSend(Map<String,Object> map, String[] reveiveEmail, String subject,String vmFileName) throws MessagingException, VelocityException {
	    // 声明Map对象，并填入用来填充模板文件的键值对
	    // Spring提供的VelocityEngineUtils将模板进行数据填充，并转换成普通的String对象
	    String emailText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, vmFileName, map);
	    // 和上面一样的发送邮件的工作
	    MimeMessage msg = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
	    helper.setFrom(preConfiguredMessage.getFrom());
	    helper.setTo(reveiveEmail);
	    if( subject == null){
			  helper.setSubject(preConfiguredMessage.getSubject());// 邮件主题
			}else{
			  helper.setSubject(subject);// 邮件主题
			}
	    helper.setText(emailText, true);
	  
	    mailSender.send(msg);
	}

	/**
	 * 同步发送Email
	 * @param receiveEmail[]
	 * @param subject
	 * @param content
	 * @throws MessagingException
	 * @throws IOException
	 */
	public void sendMailBySynchronizationMode(String[] receiveEmail, String subject, String content) throws MessagingException, IOException {
		Session session = Session.getDefaultInstance(new Properties());
		MimeMessage mime = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(mime, true, "UTF-8");
		helper.setFrom(preConfiguredMessage.getFrom());// 发件人
		helper.setCc(receiveEmail);
		// helper.setBcc("administrator@chinaptp.com");//暗送
		// helper.setReplyTo("xxx@sina.com");//回复到
		if( subject == null){
		  helper.setSubject(preConfiguredMessage.getSubject());// 邮件主题
		}else{
		  helper.setSubject(subject);// 邮件主题
		}
		if(content == null){
		  helper.setText(preConfiguredMessage.getText());
		}else{
		  helper.setText(content, true);// true表示设定html格式
		}
		mailSender.send(mime);
		
	}

	/**
	 * 异步发送Email
	 * @param receiveEmail[]
	 * @param subject
	 * @param content
	 */
	public void sendMailByAsynchronousMode( final String[] receiveEmail, final String subject, final String content) {
		taskExecutor.execute(new Runnable() {
			public void run() {
				try {
					sendMailBySynchronizationMode( receiveEmail, subject, content);
				} catch (Exception e) {
				}
			}
		});
	}
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}
	
	@Autowired
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}
	
	@Autowired
	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public SimpleMailMessage getPreConfiguredMessage() {
		return preConfiguredMessage;
	}
	
	@Autowired
	public void setPreConfiguredMessage(SimpleMailMessage preConfiguredMessage) {
		this.preConfiguredMessage = preConfiguredMessage;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}
	
	@Autowired
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

}
