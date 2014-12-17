package com.feng.service;

import java.io.Serializable;
import java.util.List;

import com.feng.dto.MtEmp;
import com.feng.pageModel.DataGrid;


/**
 * 
 * 职员接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IMtEmpService {

	/**
	 * 查询用户列表分页
	 * @param users
	 * @return
	 * @throws Exception
	 */
    public List<MtEmp> findMtEmpPaging(MtEmp emps,int pageSize, int page) throws Exception;
    
    /**
     * 查询用户列表
     * @param users
     * @return
     * @throws Exception
     */
    public List<MtEmp> findMtEmpList(MtEmp emps) throws Exception;
    
    /**
     * 查询用户列表 分页
     * @param users
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid findMtEmpForPaging(MtEmp emps, int pageSize, int page,String sort,String order) throws Exception;
    
    /**
     * 查询用户数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findMtEmpForCount(MtEmp emps) throws Exception;
    
    /**
     * 新增用户信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveMtEmps(MtEmp emps) throws Exception;
    /**
     * 更新用户信息
     * @param users
     * @throws Exception
     */
    public void updateMtEmps(MtEmp emps) throws Exception;
    
    /**
     * 删除用户信息
     * @param users
     * @throws Exception
     */
    public void deleteMtEmps(String[] empcodes) throws Exception;
    
    /**
     * 根据用户代码查询用户
     * @param usercode
     * @return
     * @throws Exception
     */
    public MtEmp findMtEmpsByMtEmpcode(String empcode) throws Exception;
}
