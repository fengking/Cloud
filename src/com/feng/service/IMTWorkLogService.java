package com.feng.service;


import java.io.Serializable;
import java.util.List; 

import com.feng.dto.MTWorkLog; 
import com.feng.pageModel.DataGrid;

/**
 * 
 * 工作日志接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IMTWorkLogService {

	/**
	 * 查询工作日志列表分页
	 * @param users
	 * @return
	 * @throws Exception
	 */
    public List<MTWorkLog> findMTWorkLogPaging(MTWorkLog worklogs,int pageSize, int page) throws Exception;
    
    /**
     * 查询工作日志列表
     * @param users
     * @return
     * @throws Exception
     */
    public List<MTWorkLog>findMTWorkLogList(MTWorkLog worklogs) throws Exception;
    
    /**
     * 查询工作日志列表 分页
     * @param users
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid findMTWorkLogForPaging(MTWorkLog worklogs, int pageSize, int page,String sort,String order) throws Exception;
    
    /**
     * 查询工作日志数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findMTWorkLogForCount(MTWorkLog worklogs) throws Exception;
    
    /**
     * 新增工作日志信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveMTWorkLogs(MTWorkLog worklogs) throws Exception;
    /**
     * 更新工作日志信息
     * @param users
     * @throws Exception
     */
    public void updateMTWorkLogs(MTWorkLog worklogs) throws Exception;
    
    /**
     * 删除工作日志信息
     * @param users
     * @throws Exception
     */
    public void deleteMTWorkLogs(String[] ids) throws Exception;
    
    /**
     * 根据工作日志代码查询工作日志
     * @param usercode
     * @return
     * @throws Exception
     */
    public MTWorkLog findMTWorkLogsByID(String id) throws Exception;
}
