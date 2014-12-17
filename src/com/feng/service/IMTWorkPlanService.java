package com.feng.service;

import java.io.Serializable;
import java.util.List; 

import com.feng.dto.MTWorkPlan; 
import com.feng.pageModel.DataGrid;

/**
 * 
 * 工作计划接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IMTWorkPlanService {

	/**
	 * 查询工作计划列表分页
	 * @param users
	 * @return
	 * @throws Exception
	 */
    public List<MTWorkPlan> findMTWorkPlanPaging(MTWorkPlan workplans,int pageSize, int page) throws Exception;
    
    /**
     * 查询工作计划列表
     * @param users
     * @return
     * @throws Exception
     */
    public List<MTWorkPlan>findMTWorkPlanList(MTWorkPlan workplans) throws Exception;
    
    /**
     * 查询工作计划列表 分页
     * @param users
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid findMTWorkPlanForPaging(MTWorkPlan workplans, int pageSize, int page,String sort,String order) throws Exception;
    
    /**
     * 查询工作计划数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findMTWorkPlanForCount(MTWorkPlan workplans) throws Exception;
    
    /**
     * 新增工作计划信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveMTWorkPlans(MTWorkPlan workplans) throws Exception;
    /**
     * 更新工作计划信息
     * @param users
     * @throws Exception
     */
    public void updateMTWorkPlans(MTWorkPlan workplans) throws Exception;
    
    /**
     * 删除工作计划信息
     * @param users
     * @throws Exception
     */
    public void deleteMTWorkPlans(String[] ids) throws Exception;
    
    /**
     * 根据工作计划代码查询工作计划
     * @param usercode
     * @return
     * @throws Exception
     */
    public MTWorkPlan findMTWorkPlansByID(String id) throws Exception;
}
