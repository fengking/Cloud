package com.feng.service.impl;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.common.util.WebIpUtil;
import com.feng.dao.IBaseDao;
import com.feng.dto.TlLog;
import com.feng.dto.TpUsers;
import com.feng.pageModel.Config;
import com.feng.service.IAutoLogService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * 系统自动日志接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("autoLogService")
public class AutoLogServiceImpl implements IAutoLogService {
    private Log log = LogFactory.getLog(AutoLogServiceImpl.class);
	private IBaseDao<TlLog> baseDao;
	
	public IBaseDao<TlLog> getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(IBaseDao<TlLog> baseDao) {
		this.baseDao = baseDao;
	}

	public void beforeLog(JoinPoint point) {
		// TODO Auto-generated method stub

	}

	public void afterLog(JoinPoint point) {
		// TODO Auto-generated method stub

	}

	public Object aroundLog(ProceedingJoinPoint point) {
		String methodName = point.getSignature().getName();// 获得方法名称
		
		Object[] args = point.getArgs();
		Map<String,Object> session = ActionContext.getContext().getSession();
		TlLog tllog = new TlLog();
		if(session != null && session.get(Config.getInstance().getSessionInfoName()) != null){
			TpUsers user = (TpUsers) session.get(Config.getInstance().getSessionInfoName());
			tllog.setSusercode(user.getSusercode());
			tllog.setSusername(user.getSusername());
		}else{
			tllog.setSusername("未登陆用户");
		}
		tllog.setSip(WebIpUtil.getIpAddr((HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST)));
		tllog.setSclassname(point.getSignature().getDeclaringType().getName());
		StringBuffer sb = new StringBuffer();
		if(methodName.startsWith("login")){//登陆
		    tllog.setSproptype("1");
		}else if(methodName.startsWith("add")||methodName.startsWith("save")){//新增
			tllog.setSproptype("2");
		}else if(methodName.startsWith("update")||methodName.startsWith("modify")||methodName.startsWith("edit")){//修改
			tllog.setSproptype("3");
		}else if(methodName.startsWith("gen")){//生成
			tllog.setSproptype("4");
		}else if(methodName.startsWith("export")){//导出
			tllog.setSproptype("5");
		}else if(methodName.startsWith("find")||methodName.startsWith("get")||methodName.startsWith("query")||methodName.startsWith("show")||methodName.startsWith("list")){//查询
			tllog.setSproptype("6");
		}else{//其它
			tllog.setSproptype("7");
		}
		tllog.setSmethodname(methodName);
		tllog.setTsstartdate(new Timestamp(System.currentTimeMillis()));
		sb.append("参数:").append(Arrays.toString(args));
		Object o = null;
		try {
			o = point.proceed();
			tllog.setSproceedstate("1");
			tllog.setSdesc(sb.toString().getBytes().length > 512 ? sb.toString().substring(0, 300) : sb.toString());
		} catch (Throwable e) {
			tllog.setSproceedstate("0");
			tllog.setSdesc(sb.toString().getBytes().length > 512 ? sb.toString().substring(0, 300) : sb.toString());
			log.error("执行方法失败", e);
		}// 继续
		tllog.setTsenddate(new Timestamp(System.currentTimeMillis()));
		try {
			baseDao.saveModel(tllog);
		} catch (Exception e) {
			log.error("保存日志信息失败!", e);
		}
		return o;
	}

}
