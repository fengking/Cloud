package com.feng.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.feng.common.util.BeanUtil;
import com.feng.dto.TpMenu;  
import com.feng.dto.TpProject;
import com.feng.dto.TpUsers;
import com.feng.pageModel.Config;
import com.feng.pageModel.Json;
import com.feng.service.IMenuService;


/**
 * 
 * 菜单动作拦截
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Namespace("/")
public class MenuAction extends BaseAction {
	private TpMenu menu = new TpMenu();
	private Log log = LogFactory.getLog(MenuAction.class);
	private IMenuService menuService;
	
	public IMenuService getMenuService() {
		return menuService;
	}

    @Autowired
	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

    public TpMenu getModel() {
		return menu;
	}
    
	@Action(value="menuAction")
   public void show(){
		  try {
			super.writeJson(menuService.getMenu(null, (TpUsers)session.get(Config.getInstance().getSessionInfoName())));
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			super.writeErrorJson(e);
		}
   }
	
	@Action("menulistAction")
	public void list(){
		try {
			super.writeJson(menuService.findMenuForPaging(menu, rows, page, sort, order));
		} catch (Exception e) {
			super.writeErrorJson(e);
		}
	}
	
	@Action("addmenuAction")
	public void add(){
		Json j = new Json();
		if(menu == null){
			j.setSuccess(false);
			j.setMsg("请填写菜单信息!");
		}else{
			try {
				String projcode = (String) menuService.saveMenu(menu); 
				j.setObj(menu);
				j.setMsg("保存成功!");
				j.setSuccess(true);
				super.writeJson(j);
			} catch (Exception e) {
				super.writeErrorJson(e);
			}
		}
	}
	
	@Action("delmenuAction")
	public void delete(){
		Json j = new Json();
		try {
			menuService.deleteMenu(ids.split(","));
			j.setMsg("保存成功!");
			j.setSuccess(true);
			super.writeJson(j);
		} catch (Exception e) {
			super.writeErrorJson(e);
		}
	}
	
	@Action("editprojectAction")
	public void edit(){
		Json j = new Json();
		try {
			TpMenu pj = menuService.findMenuByID(menu.getImenuid().toString());
			if(pj == null){
				j.setMsg("原项目不存在!请重新查询后再试");
				super.writeJson(j);
				return;
			}
			BeanUtil.copyPropertys(menu, pj);
			menuService.updateMenu(pj);
			j.setMsg("修改成功!");
			j.setSuccess(true);
			j.setObj(menu);
			super.writeJson(j);
		} catch (Exception e) {
			super.writeErrorJson(e);
		}
	}
	
	
}
