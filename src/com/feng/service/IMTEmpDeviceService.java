package com.feng.service;
import java.io.Serializable;
import java.util.List;
 

import com.feng.dto.MTEmpDevice; 
import com.feng.pageModel.DataGrid;

/**
 * 
 * 部门接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IMTEmpDeviceService {

	/**
	 * 查询部门列表分页
	 * @param users
	 * @return
	 * @throws Exception
	 */
    public List<MTEmpDevice> findMTEmpDevicePaging(MTEmpDevice empdevices,int pageSize, int page) throws Exception;
    
    /**
     * 查询部门列表
     * @param users
     * @return
     * @throws Exception
     */
    public List<MTEmpDevice> findMTEmpDeviceList(MTEmpDevice empdevices) throws Exception;
    
    /**
     * 查询部门列表 分页
     * @param users
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid findMTEmpDeviceForPaging(MTEmpDevice empdevices, int pageSize, int page,String sort,String order) throws Exception;
    
    /**
     * 查询部门数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findMTEmpDeviceForCount(MTEmpDevice empdevices) throws Exception;
    
    /**
     * 新增部门信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveMTEmpDevices(MTEmpDevice empdevices) throws Exception;
    /**
     * 更新部门信息
     * @param users
     * @throws Exception
     */
    public void updateMTEmpDevices(MTEmpDevice empdevices) throws Exception;
    
    /**
     * 删除部门信息
     * @param users
     * @throws Exception
     */
    public void deleteMTEmpDevices(String[] ids) throws Exception;
    
    /**
     * 根据部门代码查询部门
     * @param usercode
     * @return
     * @throws Exception
     */
    public MTEmpDevice findMTEmpDevicesByID(String id) throws Exception;
}
