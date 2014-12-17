package com.feng.action;

import java.sql.Timestamp;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.feng.dto.TlLog;
import com.feng.dto.TpUsers;
import com.feng.pageModel.Config;
import com.feng.pageModel.Json;
import com.feng.service.ILogService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * 日志动作拦截
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Namespace("/")
public class LogAction extends BaseAction implements ModelDriven<TlLog>{
  private TlLog log = new TlLog();
  private Timestamp startTime;
  
  private Timestamp endTime;


public TlLog getModel() {
	return log;
}

private ILogService logService;

public ILogService getLogService() {
	return logService;
}

@Autowired
public void setLogService(ILogService logService) {
	this.logService = logService;
}

@Action("loglistAction")
public void list(){
	try{
	  super.writeJson(logService.findLogForpaging(log, startTime, endTime, rows, page, sort, order));
	}catch(Exception e){
	  super.writeErrorJson(e);
	}
}

@Action("lastLoginAction")
public void lastLoginLoglist(){
	try{
		Json j = new Json();
		TlLog l = new TlLog();
		TpUsers users = (TpUsers) session.get(Config.getInstance().getSessionInfoName());
		if(users != null){
		l.setSusercode(users.getSusercode());
		}
		l.setSproptype("1");
		j.setSuccess(true);
		j.setObj(logService.findLogForpaging( l, null, null, 5, 1, "tsstartdate", "desc").getRows());
	    super.writeJson(j);
	}catch(Exception e){
		super.writeErrorJson(e);
	}
}

public Timestamp getStartTime() {
	return startTime;
}

public void setStartTime(Timestamp startTime) {
	this.startTime = startTime;
}

public Timestamp getEndTime() {
	return endTime;
}

public void setEndTime(Timestamp endTime) {
	this.endTime = endTime;
}

public int getPage() {
	return page;
}

public void setPage(int page) {
	this.page = page;
}

public int getRows() {
	return rows;
}

public void setRows(int rows) {
	this.rows = rows;
}

  
}
