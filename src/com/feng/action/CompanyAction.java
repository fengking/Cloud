package com.feng.action;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.feng.common.security.SecurityEncoder;
import com.feng.common.security.ThreeDES;
import com.feng.common.util.WebIpUtil;
import com.feng.dto.MTCompany; 
import com.feng.dto.TlLog;
import com.feng.dto.TpUsers;
import com.feng.email.Mailer;
import com.feng.pageModel.Config;
import com.feng.pageModel.Json;
import com.feng.service.ICompanyService; 
import com.feng.service.ILogService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * 公司动作拦截
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Namespace("/")
public class CompanyAction extends BaseAction implements ModelDriven<MTCompany>{

	private Log log = LogFactory.getLog(UserAction.class);
	private MTCompany Company = new MTCompany();
	  private Timestamp startTime;
	  
	  private Timestamp endTime;


	public MTCompany getModel() {
		return Company;
	}

	private ICompanyService companyService;

	public ICompanyService getCompanyService() {
		return companyService;
	}
	
	@Autowired
	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
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
	
	private Mailer mailer;
	
	public Mailer getMailer() {
		return mailer;
	}
    
    @Autowired
	public void setMailer(Mailer mailer) {
		this.mailer = mailer;
	}

	@Action(value="commanyregAction")
    public void regCommany(){
    	try{
			Json j = new Json();
			if(Company == null || Company.getFName()== null){
				j.setMsg("请输入公司名!");
			}else{
				MTCompany u = new MTCompany();
				u.setFName(Company.getFName()); 
				MTCompany u1 = new MTCompany();
				u1.setAdminEmail(Company.getAdminEmail());
				long count = companyService.findCompanyForCount(u);
				if(count > 0){
					j.setSuccess(false);
					j.setMsg(Company.getFName()+"已被注册,请更换用户名重试!");
				}else if(companyService.findCompanyForCount(u1) > 0){
					j.setSuccess(false);
					j.setMsg(Company.getAdminEmail()+"已被注册,请更换Email重试!");
				}else{
					//users.setSregip(WebIpUtil.getIpAddr(httpRequest)); 
					Company.setApplyDate(new Timestamp(System.currentTimeMillis()));
					 
				    Serializable s = companyService.saveCompany(Company);
			        	if(s == null){
						  j.setMsg("注册失败!保存数据失败");
						  j.setSuccess(false);
			        	}else{
			        	  sendWolcomeEmail();
			        	  sendValidateEmail(Company);
					      j.setSuccess(true);
					      j.setMsg("注册成功!请查看邮箱并确认邮件或等待管理员确认后即可使用!");
			        	}
				}
			}
			super.writeJson(j);
		}catch (Exception e) {
			log.error("注册用户异常!", e);
			super.writeErrorJson(e);
		}
    }
	
	@Action("commanylistAction")
	public void list(){
		try{
		  super.writeJson(companyService.findCompanyForpaging(Company, startTime, endTime, rows, page, sort, order));
		}catch(Exception e){
		  super.writeErrorJson(e);
		}
	}
	
	
	/**
	 * 发送欢迎信息
	 * @throws Exception
	 */
	public void sendWolcomeEmail() throws Exception{
		  HttpServletRequest request = ServletActionContext.getRequest();
		  String path = request.getContextPath();
		  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		  Map<String,Object> map = new HashMap<String,Object>();
		  map.put( "company", Company);
		  map.put( "url", basePath);
		  mailer.templateSend( map, new String[]{Company.getAdminEmail()}, "欢迎使用【志峰创业室】云系统", "wolcome-emailc.vm");
	}
	
	public void sendValidateEmail(MTCompany Company) throws Exception{
		try{
		  HttpServletRequest request = ServletActionContext.getRequest();
		  String path = request.getContextPath();
		  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		  Map<String,Object> map = new HashMap<String,Object>();
		  map.put( "company", Company); 
		  ThreeDES des = new ThreeDES();
		  des.getKey(Company.getFCode());
		  String enc = des.getEncString(Company.getFCode()+"_"+Company.getAdminEmail()+Company.getAdminName()+"_"+System.currentTimeMillis());//将注册时的用户代码 注册IP 发送时间
		  map.put("url", basePath+"validateEmailAction.html?email="+SecurityEncoder.encryptBase64(Company.getAdminEmail())+"&validate="+enc);
		  map.put("ip", WebIpUtil.getIpAddr(request));
		  mailer.templateSend( map, new String[]{Company.getAdminEmail()}, "欢迎使用【志峰创业室】云系统-校验您的邮箱", "validate-emailc.vm");
	}catch(Exception e){
		log.error("发送", e);
	}
   }
}
