package com.feng.service;

import java.io.Serializable;
import java.util.List;

import com.feng.dto.TpMenu; 
import com.feng.dto.TpProject;
import com.feng.dto.TpUsers;
import com.feng.pageModel.DataGrid;
import com.feng.pageModel.TreeModel;

/**
 * 
 * 菜单接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IMenuService {
	
	/**
	 * 查询菜单
	 * @param user
	 * @return
	 * @throws Exception
	 */
   public List<TreeModel> getMenu(TreeModel tree,TpUsers user) throws Exception;
   
   /**
    * 查询菜单列表 分页
    * @param menu
    * @param pageSize
    * @param page
    * @return
    * @throws Exception
    */
   public DataGrid<TpMenu> findMenuForPaging(TpMenu menu, int pageSize, int page, String sort, String order) throws Exception;
   
   /**
    * 新增菜单信息
    * @param menu
    * @return
    * @throws Exception
    */
   public Serializable saveMenu(TpMenu menu) throws Exception;
   
   /**
    * 更新项目信息
    * @param menu
    * @throws Exception
    */
   public void updateMenu(TpMenu menu) throws Exception;
   
   
   /**
    * 删除菜单信息
    * @param ids
    * @throws Exception
    */
   public void deleteMenu(String[]  ids) throws Exception;
   
   public TpMenu findMenuByID(String menuid) throws Exception;
   
   
}
