package com.feng.action;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.feng.common.security.SecurityEncoder;
import com.feng.common.security.ThreeDES;
import com.feng.dto.TpUsers;
import com.feng.service.IUsersService;

/**
 * 
 * 邮件验证等动作拦截
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Namespace("/")
//@Results({  
//	  @Result(name="failure", location="/WEB-INF/page/email.jsp")  
//	})  
public class EmailAction extends BaseAction {
   private String validate;
   private String email;
   
   private IUsersService userService;

   public IUsersService getUserService() {
		return userService;
	}
   
    @Autowired
	public void setUserService(IUsersService userService) {
		this.userService = userService;
	}

    @Action(value="validateEmailAction",results={@Result(name = SUCCESS, location = "/WEB-INF/page/email.jsp"),@Result(name = "failure", location = "/WEB-INF/page/email.jsp")})
    public String validateEmail(){
    	if(validate == null || email == null){
    		request.put("validate", 0);
    		request.put("msg", "请求的url不合法，请确认!");
    		return "failure";
    	}
    	try {
			String decryemail = SecurityEncoder.decryptStrBase64(email);
			TpUsers u = new TpUsers();
			u.setSemail(decryemail);
			List<TpUsers> list = userService.findUserList(u);
			if(list == null || list.isEmpty()){
				request.put("validate", 0);
	    		request.put("msg", "您的Email对应的用户信息不存在!");
	    		return "failure";
			}else{
				u = list.get(0);
				if(!u.getSemailvalflag().equals("0")){
					request.put("validate", 0);
		    		request.put("msg", "该链接已失效!");
		    		return "failure";
				}
				ThreeDES des = new ThreeDES();
				des.getKey(u.getSusercode());
				String decryStr = des.getDesString(validate);//解密后的字符串
				String[] strs = decryStr.split("_");
				if(strs.length != 3 || !strs[0].equals(u.getSusercode()) || !strs[1].equals(u.getSusercode()+u.getSregip())){
					request.put("validate", 0);
		    		request.put("msg", "请求的url不合法，请确认!");
		    	    return "failure";
				}
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, -3);
				if(Long.valueOf(strs[3]) < cal.getTimeInMillis()){//3天前
					request.put("validate", 0);
		    		request.put("msg", "该认证已超时，请重新认证!");
		    	    return "failure";
				}
				u.setSemailvalflag("1");
				userService.updateUsers(u);
				request.put("validate", 1);
				request.put("msg", "您的Email校验成功!感谢您的使用!");
				return SUCCESS;
			}
		} catch (Exception e) {
			log.error("校验Email异常", e);
			request.put("validate", 1);
    		request.put("msg", "校验Email异常");
			return "failure";
		}
   }
   
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
