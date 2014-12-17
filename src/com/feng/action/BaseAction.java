package com.feng.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.feng.pageModel.Json;
import com.feng.service.ILogService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础类拦截动作处理
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction extends ActionSupport implements  RequestAware, SessionAware, ApplicationAware{
	private static final long serialVersionUID = 1L;
	protected Log log = LogFactory.getLog(BaseAction.class);
    protected Map<String,Object> request;
    protected Map<String,Object> session;
    protected Map<String,Object> application;
    protected HttpServletResponse response = ServletActionContext.getResponse();
    protected HttpServletRequest httpRequest = ServletActionContext.getRequest();
    protected int page;//页数
    
    protected int rows;//每页数
	  
    protected String sort;//排序列
	  
    protected String order;//排序方法
    
    protected String ids;//删除使用ID
    
    private ILogService logService;
    
	public ILogService getLogService() {
		return logService;
	}
	
    @Autowired
	public void setLogService(ILogService logService) {
		this.logService = logService;
	}

	/**
	 * 将对象转换为json对象
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			log.error(e);
		}
	}
	
	public void writeErrorJson(Throwable e){
		log.error("运行时出现异常", e);
	    String errorInfo = "异常信息:";  
	    if(e.getCause() == null){
	    	errorInfo +=e.getMessage();
	    }else{
		  errorInfo += e.getCause().getMessage();
		}
		Json j = new Json();
		j.setMsg(errorInfo);
		j.setSuccess(false);
	    String json = JSON.toJSONStringWithDateFormat(j, "yyyy-MM-dd HH:mm:ss");
	    ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
	    ServletActionContext.getResponse().setStatus(500);
		try {
			ServletActionContext.getResponse().getWriter().write(json);
		    ServletActionContext.getResponse().getWriter().flush();
		    ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e1) {
			log.error(e1);
		}
   }
	
	
	/**
	 * 增加日誌
	 * @param sproptype 1登陆 2新增 3修改 4生成5导出 6查询7其它
	 * @param sdesc
	 * @throws Exception
	 */
	public void addLog(String sproptype, String sdesc,boolean proceedflag) throws Exception{
		logService.addLog(null, sproptype, sdesc, proceedflag);
	}
	
	/**
	 * 增加日誌
	 * @param sproptype 1登陆 2新增 3修改 4生成5导出 6查询7其它
	 * @param sdesc
	 * @throws Exception
	 */
	public void addLog(String usercode, String sproptype, String sdesc,boolean proceedflag) throws Exception{
		logService.addLog( usercode, sproptype, sdesc, proceedflag);
	}

	public void setApplication(Map<String, Object> application) {
	  this.application = application;
	}

	public void setSession(Map<String, Object> session) {
	  this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
	  this.request = request;
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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
} 
