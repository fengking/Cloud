package com.feng.action;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
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
import com.feng.dto.TpUsers;
import com.feng.email.Mailer;
import com.feng.pageModel.Config;
import com.feng.pageModel.Json;
import com.feng.service.IUsersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * 用户动作拦截
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Namespace("/")
public class UserAction extends BaseAction implements ModelDriven<TpUsers>{
	private Log log = LogFactory.getLog(UserAction.class);
	private TpUsers users = new TpUsers();
	
	private Mailer mailer;
	 
	private IUsersService userService;
	
	private String susernewpwd;
	
	public IUsersService getUserService() {
		return userService;
	}
	
    @Autowired
	public void setUserService(IUsersService userService) {
		this.userService = userService;
	}
    
    public Mailer getMailer() {
		return mailer;
	}
    
    @Autowired
	public void setMailer(Mailer mailer) {
		this.mailer = mailer;
	}

	@Action(value="regAction")
    public void regUser(){
    	try{
			Json j = new Json();
			if(users == null || users.getSusername() == null){
				j.setMsg("请输入用户名!");
			}else{
				TpUsers u = new TpUsers();
				u.setSusername(users.getSusername());
				TpUsers u1 = new TpUsers();
				u1.setSemail(users.getSemail());
				long count = userService.findUsersForCount(u);
				if(count > 0){
					j.setSuccess(false);
					j.setMsg(users.getSusername()+"已被注册,请更换用户名重试!");
				}else if(userService.findUsersForCount(u1) > 0){
					j.setSuccess(false);
					j.setMsg(users.getSemail()+"已被注册,请更换Email重试!");
				}else{
					users.setSregip(WebIpUtil.getIpAddr(httpRequest));
					users.setTsregdatetime(new Timestamp(System.currentTimeMillis()));//注册时间
					users.setSemailvalflag("0");//未校验
					users.setSadminflag("0");//普通人
					users.setSuserstate("0");//锁定
				    Serializable s = userService.saveUsers(users);
			        	if(s == null){
						  j.setMsg("注册失败!保存数据失败");
						  j.setSuccess(false);
			        	}else{
			        	  sendWolcomeEmail();
			        	  sendValidateEmail(users);
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
    
    @Action(value="usersAddAction")
    public void addUser(){
    	Json j = new Json();
    	TpUsers u = new TpUsers();
    	u.setSusername(users.getSusername());
    	TpUsers u1 = new TpUsers();
    	u1.setSemail(users.getSemail());
    	try {
			if(userService.findUsersForCount(u) > 0){
				j.setMsg("用户名"+users.getSusername()+"已被占用!请修改后再试");
			}else if(userService.findUsersForCount(u1) > 0){
				j.setMsg("邮箱"+users.getSemail()+"已被占用!请修改后再试");
			}else{
				String ip = WebIpUtil.getIpAddr((HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST));
		    	users.setSusercode(UUID.randomUUID().toString());//
		    	users.setSemailvalflag("0");//email是否已校验
		    	users.setSregip(ip);
		    	users.setSregusercode(session.get(Config.getInstance().getSessionInfoName()) == null ? null : ((TpUsers)(session.get(Config.getInstance().getSessionInfoName()))).getSusercode());
		        users.setTsregdatetime(new java.sql.Timestamp(System.currentTimeMillis()));//注册时间
		        users.setSuserstate("1");
		        userService.saveUsers(users);
		        super.addLog("2", "新增用户"+users.getSusername()+" 用户代码:"+users.getSusercode(), false);
				j.setMsg("新增用户成功!");
				j.setSuccess(true);
				j.setObj(users);
			}
			super.writeJson(j);
		} catch (Exception e) {
			log.error("新增用户异常", e);
			super.writeErrorJson(e);
		}
    }
    
    @Action(value="usersEditAction")
    public void modifyUser(){
    	try {
    		Json j = new Json();
			TpUsers u = userService.findUsersByUsercode(users.getSusercode());
			if(u != null){
				BeanUtil.copyPropertys(users, u);
				userService.updateUsers(u);
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
    
    @Action(value="changePwdAction")
    public void editPwd() throws Exception{
    	try {
    		Json j = new Json();
    		if(users.getSuserpwd().equals(susernewpwd)){
    			j.setMsg("新密码和原密码不能相同!");
    			super.writeJson(j);
    			return ;
    		}
			TpUsers u = userService.findUsersByUsercode(users.getSusercode());
			if(u != null){
				if(!SecurityEncoder.encryptSHA(SecurityEncoder.ENCODE_SHA1, users.getSuserpwd()).equals(u.getSuserpwd())){
					j.setMsg("原密码错误,请重试!");
				}else{
					users.setSuserpwd(SecurityEncoder.encryptSHA(SecurityEncoder.ENCODE_SHA1, susernewpwd));
					BeanUtil.copyPropertys(users, u);
					userService.updateUsers(u);
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
    
    
    
    @Action(value="usersDelAction")
    public void delUser(){
      Json j = new Json();
      String[] usercodes  = ids.split(",");
      try {
		 userService.deleteUsers(usercodes);
		 j.setSuccess(true);
		 j.setMsg("删除成功!");
		 super.writeJson(j);
	  } catch (Exception e) {
		  log.error("删除用户异常", e);
		 super.writeErrorJson(e);
	  }
    }
    
    @Action(value="loginAction")
    public void login(){
		try {
	    	Json j = new Json();
	    	if(users == null || users.getSusername()== null || users.getSuserpwd() == null){
	    		j.setMsg("用户名密码必填!");
	    	}else{
	    		TpUsers u = new TpUsers();
	    		u.setSusername(users.getSusername());
				List<TpUsers> list = userService.findUserList(u);
				if(list == null || list.isEmpty()){
					j.setMsg("用户信息不存在!");
				}else{
					u = list.get(0);
					if(!SecurityEncoder.encryptSHA(SecurityEncoder.ENCODE_SHA1, users.getSuserpwd()).equals(u.getSuserpwd())){
						j.setMsg("密码不一致!");
						super.addLog("1", "用户:"+users.getSusercode()+"登陆时错误! 原因:密码不一致!请联系管理员解锁", false);
					}else if("0".equals(u.getSuserstate())){//锁定状态
						j.setMsg("用户状态已锁定!请联系管理员解锁");
						super.addLog("1", "用户:"+users.getSusercode()+"登陆时错误! 原因:用户状态已锁定!请联系管理员解锁", false);
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
						u.setSlastloginip(ip);
						u.setTslastlogin(new java.sql.Timestamp(System.currentTimeMillis()));
						userService.updateUsers(u);
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
    
    @Action(value="userInfoAction")
    public void userinfo(){
    	try{
    		Json j = new Json();
    		j.setSuccess(true);
    	    j.setObj(userService.findUsersByUsercode(users.getSusercode()));
    		super.writeJson(j);
    	}catch(Exception e){
    		log.error("查询用户信息异常", e);
    		super.writeErrorJson(e);
    	}
    }

	@Action(value="usersAction")
   public void users() {
	 try {
		super.writeJson(userService.findUserForPaging(users, rows, page, sort, order));
	} catch (Exception e) {
		log.error("查询用户时异常", e);
		super.writeErrorJson(e);
	}
   }
	@Action("logoutAction")
	public void loginout(){
		session.remove(Config.getInstance().getSessionInfoName());
		Json j = new Json();
		j.setMsg("退出成功!");
		j.setSuccess(true);
		super.writeJson(j);
	}
	
	@Action(value="validateUser")
	public void valiteUser(){
		try{
			Json j = new Json();
			if(users == null || users.getSusername() == null){
				
			}else{
				if(userService.findUsersForCount(users) == 0){
					j.setSuccess(true);
					j.setMsg(users.getSusername()+"可以使用!");
				}else{
					j.setMsg(users.getSusername()+"已被注册,请更换用户名重试!");
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
		  map.put( "users", users);
		  map.put( "url", basePath);
		  mailer.templateSend( map, new String[]{users.getSemail()}, "欢迎使用【志峰创业室】云系统", "wolcome-email.vm");
	}
	
	public void sendValidateEmail(TpUsers users) throws Exception{
		try{
		  HttpServletRequest request = ServletActionContext.getRequest();
		  String path = request.getContextPath();
		  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		  Map<String,Object> map = new HashMap<String,Object>();
		  map.put( "users", users); 
		  ThreeDES des = new ThreeDES();
		  des.getKey(users.getSusercode());
		  String enc = des.getEncString(users.getSusercode()+"_"+users.getSemail()+users.getSusercode()+users.getSregip()+"_"+System.currentTimeMillis());//将注册时的用户代码 注册IP 发送时间
		  map.put("url", basePath+"validateEmailAction.html?email="+SecurityEncoder.encryptBase64(users.getSemail())+"&validate="+enc);
		  map.put("ip", WebIpUtil.getIpAddr(request));
		  mailer.templateSend( map, new String[]{users.getSemail()}, "欢迎使用【志峰创业室】云系统-校验您的邮箱", "validate-email.vm");
	}catch(Exception e){
		log.error("发送", e);
	}
   }

	public TpUsers getModel() {
		return users;
	}

	public String getSusernewpwd() {
		return susernewpwd;
	}

	public void setSusernewpwd(String susernewpwd) {
		this.susernewpwd = susernewpwd;
	}
	
}
