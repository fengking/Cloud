package com.feng.pageModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 基础配置加载处理
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class Config {
	static ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	public static Config getInstance() {
      return  (Config) context.getBean("config");
	}

	private String sessionInfoName;

	private String uploadFieldName;

	private String uploadFileMaxSize;

	private String uploadFileExts;

	private String uploadDirectory;
	
	private String modeldesc;

	public String getSessionInfoName() {
		return sessionInfoName;
	}

	public void setSessionInfoName(String sessionInfoName) {
		this.sessionInfoName = sessionInfoName;
	}

	public String getUploadFieldName() {
		return uploadFieldName;
	}

	public void setUploadFieldName(String uploadFieldName) {
		this.uploadFieldName = uploadFieldName;
	}

	public String getUploadFileMaxSize() {
		return uploadFileMaxSize;
	}

	public void setUploadFileMaxSize(String uploadFileMaxSize) {
		this.uploadFileMaxSize = uploadFileMaxSize;
	}

	public String getUploadFileExts() {
		return uploadFileExts;
	}

	public void setUploadFileExts(String uploadFileExts) {
		this.uploadFileExts = uploadFileExts;
	}

	public String getUploadDirectory() {
		return uploadDirectory;
	}

	public void setUploadDirectory(String uploadDirectory) {
		this.uploadDirectory = uploadDirectory;
	}

	public String getModeldesc() {
		return modeldesc;
	}

	public void setModeldesc(String modeldesc) {
		this.modeldesc = modeldesc;
	}
	public static void main(String[] args) {
		Config.getInstance();
	}
}
