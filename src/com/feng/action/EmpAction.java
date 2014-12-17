package com.feng.action;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.feng.common.security.SecurityEncoder;
import com.feng.common.security.ThreeDES;
import com.feng.common.util.BeanUtil;
import com.feng.common.util.WebIpUtil;
import com.feng.dto.MtEmp; 
import com.feng.dto.TpUsers;
import com.feng.email.Mailer;
import com.feng.pageModel.Config;
import com.feng.pageModel.Json;
import com.feng.service.IMtEmpService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * 职员动作拦截
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Namespace("/")
public class EmpAction extends BaseAction implements ModelDriven<MtEmp>{

	public MtEmp getModel() {
		// TODO Auto-generated method stub
		return emps;
	}
	
	private Log log = LogFactory.getLog(EmpAction.class);
	private MtEmp emps = new MtEmp();
	
	private Mailer mailer;
	 
	private IMtEmpService mtempService;
	
	private String susernewpwd;
	
	public IMtEmpService getMtEmpService() {
		return mtempService;
	}
	
    @Autowired
	public void setMtEmpService(IMtEmpService mtempService) {
		this.mtempService = mtempService;
	}
    
    public Mailer getMailer() {
		return mailer;
	}
    
    @Autowired
	public void setMailer(Mailer mailer) {
		this.mailer = mailer;
	}

    
    @Action(value="empsregAction")
    public void regEmps(){
    	try{
			Json j = new Json();
			if(emps == null || emps.getEmpName() == null){
				j.setMsg("请输入用户名!");
			}else{
				MtEmp u = new MtEmp();
				u.setEmpName(emps.getEmpName());
				MtEmp u1 = new MtEmp();
				u1.setEmail(emps.getEmail());
				long count = mtempService.findMtEmpForCount(u);
				if(count > 0){
					j.setSuccess(false);
					j.setMsg(emps.getEmpName()+"已被注册,请更换用户名重试!");
				}else if(mtempService.findMtEmpForCount(u1) > 0){
					j.setSuccess(false);
					j.setMsg(emps.getEmail()+"已被注册,请更换Email重试!");
				}else{
					//emps.setSregip(WebIpUtil.getIpAddr(httpRequest));
					//emps.setTsregdatetime(new Timestamp(System.currentTimeMillis()));//注册时间
					//emps.setSemailvalflag("0");//未校验
					//emps.setSadminflag("0");//普通人
					//emps.setSuserstate("0");//锁定
				    Serializable s = mtempService.saveMtEmps(emps);
			        	if(s == null){
						  j.setMsg("注册失败!保存数据失败");
						  j.setSuccess(false);
			        	}else{
			        	  sendWolcomeEmail();
			        	  sendValidateEmail(emps);
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
    
    @Action(value="empsAddAction")
    public void addEmps(){
    	Json j = new Json();
    	MtEmp u = new MtEmp();
    	u.setEmpName(emps.getEmpName());
    	MtEmp u1 = new MtEmp();
    	u1.setEmail(emps.getEmail());
    	try {
			if(mtempService.findMtEmpForCount(u) > 0){
				j.setMsg("用户名"+emps.getEmpName()+"已被占用!请修改后再试");
			}else if(mtempService.findMtEmpForCount(u1) > 0){
				j.setMsg("邮箱"+emps.getEmail()+"已被占用!请修改后再试");
			}else{
				String ip = WebIpUtil.getIpAddr((HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST));
				 
		        mtempService.saveMtEmps(emps);
		        super.addLog("2", "新增用户"+emps.getEmpName()+" 用户代码:"+emps.getEmpName(), false);
				j.setMsg("新增用户成功!");
				j.setSuccess(true);
				j.setObj(emps);
			}
			super.writeJson(j);
		} catch (Exception e) {
			log.error("新增用户异常", e);
			super.writeErrorJson(e);
		}
    }
    
    @Action(value="empsEditAction")
    public void modifyEmps(){
    	try {
    		Json j = new Json();
    		MtEmp u = mtempService.findMtEmpsByMtEmpcode(emps.getEmpName());
			if(u != null){
				BeanUtil.copyPropertys(emps, u);
				mtempService.updateMtEmps(u);
				j.setMsg("修改成功!");
				j.setSuccess(true);
				j.setObj(u);
			}else{
				j.setMsg("原用户信息不存在!");
			}
			super.writeJson(j);
		} catch (Exception e) {
			super.writeErrorJson(e);
		}
    	
    }
    
    @Action(value="empschangePwdAction")
    public void editPwd() throws Exception{
    	try {
    		Json j = new Json();
    		if(emps.getPwd().equals(susernewpwd)){
    			j.setMsg("新密码和原密码不能相同!");
    			super.writeJson(j);
    			return ;
    		}
    		MtEmp u = mtempService.findMtEmpsByMtEmpcode(emps.getEmpName());
			if(u != null){
				if(!SecurityEncoder.encryptSHA(SecurityEncoder.ENCODE_SHA1, emps.getPwd()).equals(u.getPwd())){
					j.setMsg("原密码错误,请重试!");
				}else{
					emps.setPwd(SecurityEncoder.encryptSHA(SecurityEncoder.ENCODE_SHA1, susernewpwd));
					BeanUtil.copyPropertys(emps, u);
					mtempService.updateMtEmps(u);
					j.setMsg("修改成功!");
					j.setSuccess(true);
					j.setObj(u);
				}
			}else{
				j.setMsg("原用户信息不存在!");
			}
			super.writeJson(j);
		} catch (Exception e) {
			super.writeErrorJson(e);
		}
    }
    
    
    
    @Action(value="empsDelAction")
    public void delEmpe(){
      Json j = new Json();
      String[] usercodes  = ids.split(",");
      try {
    	  mtempService.deleteMtEmps(usercodes);
		 j.setSuccess(true);
		 j.setMsg("删除成功!");
		 super.writeJson(j);
	  } catch (Exception e) {
		  log.error("删除用户异常", e);
		 super.writeErrorJson(e);
	  }
    }
    
    @Action(value="empsloginAction")
    public void login(){
		try {
	    	Json j = new Json();
	    	if(emps == null || emps.getEmpName()== null || emps.getPwd() == null){
	    		j.setMsg("用户名密码必填!");
	    	}else{
	    		MtEmp u = new MtEmp();
	    		u.setEmpName(emps.getEmpName());
				List<MtEmp> list = mtempService.findMtEmpList(u);
				if(list == null || list.isEmpty()){
					j.setMsg("用户信息不存在!");
				}else{
					u = list.get(0);
					if(!SecurityEncoder.encryptSHA(SecurityEncoder.ENCODE_SHA1, emps.getPwd()).equals(u.getPwd())){
						j.setMsg("密码不一致!");
						super.addLog("1", "用户:"+emps.getEmpName()+"登陆时错误! 原因:密码不一致!请联系管理员解锁", false);
					}else if("0".equals(u.getStatus())){//锁定状态
						j.setMsg("用户状态已锁定!请联系管理员解锁");
						super.addLog("1", "用户:"+emps.getEmpName()+"登陆时错误! 原因:用户状态已锁定!请联系管理员解锁", false);
					}
//					else if(!"1".equals(u.getSemailvalflag())){
//						j.setMsg("Email未校验!请校验后再登陆");
//						super.addLog("1", "用户:"+users.getSusercode()+"登陆时错误! 原因:Email未校验!请校验后再登陆", false);
//					}
					else{
						j.setSuccess(true);
						j.setObj(u);
						j.setMsg("登陆成功!");
						session.put(Config.getInstance().getSessionInfoName(), u.clone());
						String ip = WebIpUtil.getIpAddr((HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST));
						session.put("IP", ip);
						 
						//u.setTslastlogin(new java.sql.Timestamp(System.currentTimeMillis()));
						mtempService.updateMtEmps(u);
						super.addLog("1", "登陆成功", true);
					}
				}
	    	}
	    	super.writeJson(j);
		} catch (Exception e) {
			log.error("登陆时异常", e);
			super.writeErrorJson(e);
		}
    }
    
    @Action(value="empsInfoAction")
    public void empsinfo(){
    	try{
    		Json j = new Json();
    		j.setSuccess(true);
    	    j.setObj(mtempService.findMtEmpsByMtEmpcode(emps.getEmpName()));
    		super.writeJson(j);
    	}catch(Exception e){
    		log.error("查询用户信息异常", e);
    		super.writeErrorJson(e);
    	}
    }

	@Action(value="empsAction")
   public void users() {
	 try {
		super.writeJson(mtempService.findMtEmpForPaging(emps, rows, page, sort, order));
	} catch (Exception e) {
		log.error("查询用户时异常", e);
		super.writeErrorJson(e);
	}
   }
	@Action("empslogoutAction")
	public void loginout(){
		session.remove(Config.getInstance().getSessionInfoName());
		Json j = new Json();
		j.setMsg("退出成功!");
		j.setSuccess(true);
		super.writeJson(j);
	}
	
	@Action(value="empsvalidateUser")
	public void valiteUser(){
		try{
			Json j = new Json();
			if(emps == null || emps.getEmpName() == null){
				
			}else{
				if(mtempService.findMtEmpForCount(emps) == 0){
					j.setSuccess(true);
					j.setMsg(emps.getEmpName()+"可以使用!");
				}else{
					j.setMsg(emps.getEmpName()+"已被注册,请更换用户名重试!");
				}
			}
			super.writeJson(j);
		}catch (Exception e) {
			log.error("校验用户名是否存在异常!", e);
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
		  map.put( "emps", emps);
		  map.put( "url", basePath);
		  mailer.templateSend( map, new String[]{emps.getEmail()}, "欢迎使用【志峰创业室】云系统", "wolcome-email.vm");
	}
	
	public void sendValidateEmail(MtEmp emps) throws Exception{
		try{
		  HttpServletRequest request = ServletActionContext.getRequest();
		  String path = request.getContextPath();
		  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		  Map<String,Object> map = new HashMap<String,Object>();
		  map.put( "emps", emps); 
		  ThreeDES des = new ThreeDES();
		  des.getKey(emps.getPwd());
		  String enc = des.getEncString(emps.getEmpName()+"_"+emps.getEmail()+"_"+System.currentTimeMillis());//将注册时的用户代码 注册IP 发送时间
		  map.put("url", basePath+"validateEmailAction.html?email="+SecurityEncoder.encryptBase64(emps.getEmail())+"&validate="+enc);
		  map.put("ip", WebIpUtil.getIpAddr(request));
		  mailer.templateSend( map, new String[]{emps.getEmail()}, "欢迎使用【志峰创业室】云系统-校验您的邮箱", "validate-email.vm");
	}catch(Exception e){
		log.error("发送", e);
	}
   }
 
	public String getSusernewpwd() {
		return susernewpwd;
	}

	public void setSusernewpwd(String susernewpwd) {
		this.susernewpwd = susernewpwd;
	}
}
