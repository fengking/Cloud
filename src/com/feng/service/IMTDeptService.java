package com.feng.service;

import java.io.Serializable;
import java.util.List;
 
import com.feng.dto.MTDept; 
import com.feng.pageModel.DataGrid;

/**
 * 
 * 部门接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IMTDeptService {

	/**
	 * 查询部门列表分页
	 * @param users
	 * @return
	 * @throws Exception
	 */
    public List<MTDept> findMTDeptPaging(MTDept mtdepts,int pageSize, int page) throws Exception;
    
    /**
     * 查询部门列表
     * @param users
     * @return
     * @throws Exception
     */
    public List<MTDept> findMTDeptList(MTDept mtdepts) throws Exception;
    
    /**
     * 查询部门列表 分页
     * @param users
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid findMTDeptForPaging(MTDept mtdepts, int pageSize, int page,String sort,String order) throws Exception;
    
    /**
     * 查询部门数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findMTDeptForCount(MTDept mtdepts) throws Exception;
    
    /**
     * 新增部门信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveMTDepts(MTDept mtdepts) throws Exception;
    /**
     * 更新部门信息
     * @param users
     * @throws Exception
     */
    public void updateMTDepts(MTDept mtdepts) throws Exception;
    
    /**
     * 删除部门信息
     * @param users
     * @throws Exception
     */
    public void deleteMTDepts(String[] ids) throws Exception;
    
    /**
     * 根据部门代码查询部门
     * @param usercode
     * @return
     * @throws Exception
     */
    public MTDept findMTDeptsByID(String id) throws Exception;
}
