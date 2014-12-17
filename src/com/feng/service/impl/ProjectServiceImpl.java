package com.feng.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao;
import com.feng.dto.TpProject;
import com.feng.dto.TpUsers;
import com.feng.pageModel.Config;
import com.feng.pageModel.DataGrid;
import com.feng.service.IProjectService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * 工程接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("projectService")
public class ProjectServiceImpl implements IProjectService {
	private IBaseDao<TpProject> baseDao;
	
	public IBaseDao<TpProject> getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(IBaseDao<TpProject> baseDao) {
		this.baseDao = baseDao;
	}

	public DataGrid<TpProject> findProjectForPaging(TpProject project, int pageSize,
			int page, String sort, String order) throws Exception {
		return baseDao.findDataGridForPaging( project, page, pageSize, sort, order);
	}

	public long findProjectForCount(TpProject project) throws Exception {
		return baseDao.findForCount(project);
	}

	public Serializable saveProject(TpProject project) throws Exception {
		Map<String,Object> session = ActionContext.getContext().getSession();
		project.setSprojcode(UUID.randomUUID().toString());//项目编号
		TpUsers users = (TpUsers) session.get(Config.getInstance().getSessionInfoName());
		if(users != null){
		  project.setSusercode(users.getSusercode());
		}
		project.setTsadddate(new java.sql.Timestamp(System.currentTimeMillis()));
		return baseDao.saveModel(project);
	}

	public void updateProject(TpProject project) throws Exception {
		project.setTssysupdate(new java.sql.Timestamp(System.currentTimeMillis()));
		baseDao.updateModel(project);
	}

	public void deleteProject(String[] ids) throws Exception {
       for(String id : ids){
		long count = baseDao.findForCount("select count(table) from TsTable as table where sprojcode = ?", new String[]{id});	
	    if(count != 0){
		  throw new Exception("该项目已经被使用，不能删除!"); 
	    }
	    baseDao.executeHql("delete from TpProject where sprojcode=?", new String[]{id});
       }
	}

	public TpProject findPojectBycode(String projectcode) throws Exception {
		return baseDao.findByModelPK(TpProject.class, projectcode);
	}

}
