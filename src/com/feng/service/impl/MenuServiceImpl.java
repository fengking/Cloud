package com.feng.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao;
import com.feng.dto.TpMenu;
import com.feng.dto.TpProject;
import com.feng.dto.TpUsers;
import com.feng.pageModel.Config;
import com.feng.pageModel.DataGrid;
import com.feng.pageModel.TreeModel;
import com.feng.service.IMenuService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * 菜单接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("menuService")
public class MenuServiceImpl implements IMenuService {
	
	private IBaseDao<TpMenu> baseDao;
	
	public IBaseDao<TpMenu> getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(IBaseDao<TpMenu> baseDao) {
		this.baseDao = baseDao;
	}

	public List<TreeModel> getMenu(TreeModel tree,TpUsers user) throws Exception {
		List<Object> params = new ArrayList<Object>();
		String sql = null;
		if(tree == null || tree.getId() == null){
			if(user == null){
				return null;
			 	  //sql = "select m from TpMenu m where isupermenuid is null order by imenuid asc";
			}else{
				sql = "select m from TpMenu m where isupermenuid is null order by imenuid asc";
			}
		}else{
			if(user == null){
				return null;
				//sql = "select m from TpMenu m where isupermenuid = ? order by imenuid";
			}else{
				sql = "select m from TpMenu m where isupermenuid = ? order by imenuid";
			}
			params.add(tree.getId());
		}
		List<TpMenu> list = (List<TpMenu>) baseDao.findForList(sql, params);
		List<TreeModel> treelist = new ArrayList<TreeModel>();
		for(TpMenu m : list){
			  TreeModel model = new TreeModel();
			  model.setText(m.getSmenuname());
			  model.setId(m.getImenuid());
			  Map<String,String> attrebutes = new HashMap<String,String>();
			  attrebutes.put("url", m.getSmenuurl());
			  model.setAttributes(attrebutes);
			  model.setChildren(getMenu(model, user));
			  treelist.add(model);
			}
		return treelist;
	}
	
	public DataGrid<TpMenu> findMenuForPaging(TpMenu menu, int pageSize,
			int page, String sort, String order) throws Exception {
		return baseDao.findDataGridForPaging( menu, page, pageSize, sort, order);
	}
	
	public Serializable saveMenu(TpMenu menu) throws Exception {
		//Map<String,Object> session = ActionContext.getContext().getSession(); 
		return baseDao.saveModel(menu);
	}
	
	public void updateMenu(TpMenu menu) throws Exception {
		//project.setTssysupdate(new java.sql.Timestamp(System.currentTimeMillis()));
		baseDao.updateModel(menu);
	}
	
	public void deleteMenu(String[] ids) throws Exception {
	       for(String id : ids){
			long count = baseDao.findForCount("select count(table) from TsTable as table where imenuid = ?", new String[]{id});	
		    if(count != 0){
			  throw new Exception("该项目已经被使用，不能删除!"); 
		    }
		    baseDao.executeHql("delete from tp_menu where imenuid=?", new String[]{id});
	       }
		}
	
	public TpMenu findMenuByID(String menuid) throws Exception {
		return baseDao.findByModelPK(TpMenu.class, menuid);
	}

}
