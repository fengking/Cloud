package com.feng.pageModel;

import java.io.Serializable;

/**
 * 
 * JSON 自定义类
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class Json implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;
	
	/**
	 * 构造函数
	 */
	public Json() {
		super();
	}

	/**
	 * 返回JSON数据
	 * @param msg
	 */
	public Json(String msg) {
		super();
		this.msg = msg;
	}
	
	/**
	 * 返回格式的JSON
	 * @param success 是否成功
	 * @param msg	消息
	 * @param obj	对象
	 */
	public Json(boolean success, String msg, Object obj) {
		super();
		this.success = success;
		this.msg = msg;
		this.obj = obj;
	}

	/**
	 * 是否成功
	 * @return
	 */
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
