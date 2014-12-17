package com.feng.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * 日志接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IAutoLogService {
	
	/**
	 * 动作前日志
	 * @param point
	 */
	public void beforeLog(JoinPoint point);

	/**
	 * 动作后日志
	 * @param point
	 */
	public void afterLog(JoinPoint point);

	/**
	 * 相关日志
	 * @param point
	 * @return
	 */
	public Object aroundLog(ProceedingJoinPoint point);
}
