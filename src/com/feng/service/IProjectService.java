package com.feng.service;

import java.io.Serializable;

import com.feng.dto.TpProject;
import com.feng.pageModel.DataGrid;

/**
 * 
 * 工程接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IProjectService {
	
    /**
     * 查询项目列表 分页
     * @param project
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid<TpProject> findProjectForPaging(TpProject project, int pageSize, int page, String sort, String order) throws Exception;
    
    /**
     * 查询项目数量
     * @param project
     * @return
     * @throws Exception
     */
    public long findProjectForCount(TpProject project) throws Exception;
    
    /**
     * 新增项目信息
     * @param project
     * @return
     * @throws Exception
     */
    public Serializable saveProject(TpProject project) throws Exception;
    
    /**
     * 更新项目信息
     * @param project
     * @throws Exception
     */
    public void updateProject(TpProject project) throws Exception;
    
    /**
     * 删除项目信息
     * @param ids
     * @throws Exception
     */
    public void deleteProject(String[]  ids) throws Exception;
    
    public TpProject findPojectBycode(String projectcode) throws Exception;
}
