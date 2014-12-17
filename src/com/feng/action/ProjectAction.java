package com.feng.action;

import java.net.ConnectException;
import java.sql.SQLException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.feng.common.util.BeanUtil;
import com.feng.dto.TpDbquery;
import com.feng.dto.TpProject;
import com.feng.pageModel.Json;
import com.feng.service.IDbQueryService;
import com.feng.service.IProjectService;
import com.feng.util.DBUtils;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * 工程动作拦截
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Namespace("/")
public class ProjectAction extends BaseAction implements ModelDriven<TpProject>{
	private TpProject project = new TpProject();
	
	private IProjectService projectService;
	private IDbQueryService dbQueryService;

	public IProjectService getProjectService() {
		return projectService;
	}
	
    @Autowired
	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}

	public IDbQueryService getDbQueryService() {
		return dbQueryService;
	}
	
	@Autowired
	public void setDbQueryService(IDbQueryService dbQueryService) {
		this.dbQueryService = dbQueryService;
	}

	@Action("projectlistAction")
	public void list(){
		try {
			super.writeJson(projectService.findProjectForPaging(project, rows, page, sort, order));
		} catch (Exception e) {
			super.writeErrorJson(e);
		}
	}
	
	@Action("dbtestConnAction")
	public void testDBConnection(){
		Json j = new Json();
		TpDbquery query = null;
		try{
	       query = dbQueryService.findDbqueryBydbtype(project.getSdbtype());
		}catch (Exception e) {
			super.writeErrorJson(e);
		}
		if(query == null){
			j.setMsg("数据库类型不正确!");
			j.setSuccess(false);
			super.writeJson(j);
			return ;
		}
		DBUtils util = new DBUtils(project.getSdbname(), project.getSdbpwd(), project.getSdburl(), query);
		try {
			util.getConnection();
			j.setMsg("连接成功!");
			j.setSuccess(true);
		} catch (ClassNotFoundException e) {
			log.error("类未找到!", e);
			j.setMsg("未找到该数据库对应的驱动!请确认该数据库驱动正确~");
		}catch(ConnectException e){
			log.error("连接错误!", e);
			j.setMsg("连接错误!请确认数据库连接是否正常~");
		}catch(SQLException e){
			log.error("数据库错误!", e);
			j.setMsg("数据库用户名或密码错误!请确认是否正确~");
		}catch(Exception e){
			log.error("其他错误", e);
			j.setMsg(e.getMessage());
		}
		super.writeJson(j);
	}
	
	@Action("addprojectAction")
	public void add(){
		Json j = new Json();
		if(project == null){
			j.setSuccess(false);
			j.setMsg("请填写项目信息!");
		}else{
			try {
				String projcode = (String) projectService.saveProject(project);
				project.setSprojcode(projcode);
				j.setObj(project);
				j.setMsg("保存成功!");
				j.setSuccess(true);
				super.writeJson(j);
			} catch (Exception e) {
				super.writeErrorJson(e);
			}
		}
	}
	
	@Action("editprojectAction")
	public void edit(){
		Json j = new Json();
		try {
			TpProject pj = projectService.findPojectBycode(project.getSprojcode());
			if(pj == null){
				j.setMsg("原项目不存在!请重新查询后再试");
				super.writeJson(j);
				return;
			}
			BeanUtil.copyPropertys(project, pj);
			projectService.updateProject(pj);
			j.setMsg("修改成功!");
			j.setSuccess(true);
			j.setObj(project);
			super.writeJson(j);
		} catch (Exception e) {
			super.writeErrorJson(e);
		}
	}
	
	@Action("delprojectAction")
	public void delete(){
		Json j = new Json();
		try {
			projectService.deleteProject(ids.split(","));
			j.setMsg("保存成功!");
			j.setSuccess(true);
			super.writeJson(j);
		} catch (Exception e) {
			super.writeErrorJson(e);
		}
	}

	public TpProject getModel() {
		return project;
	}
	
}
