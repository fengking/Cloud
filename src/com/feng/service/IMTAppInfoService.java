package com.feng.service;

import java.io.Serializable;
import java.util.List;

import com.feng.dto.MTAppInfo; 
import com.feng.pageModel.DataGrid;

/**
 * 
 * 应用接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IMTAppInfoService {

	/**
	 * 查询应用app列表分页
	 * @param users
	 * @return
	 * @throws Exception
	 */
    public List<MTAppInfo> findMTAppInfoPaging(MTAppInfo mtappinfos,int pageSize, int page) throws Exception;
    
    /**
     * 查询应用app列表
     * @param users
     * @return
     * @throws Exception
     */
    public List<MTAppInfo> findMTAppInfoList(MTAppInfo mtappinfos) throws Exception;
    
    /**
     * 查询应用app列表 分页
     * @param users
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid findMTAppInfoForPaging(MTAppInfo mtappinfos, int pageSize, int page,String sort,String order) throws Exception;
    
    /**
     * 查询应用app数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findMTAppInfoForCount(MTAppInfo mtappinfos) throws Exception;
    
    /**
     * 新增应用app信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveMTAppInfos(MTAppInfo mtappinfos) throws Exception;
    /**
     * 更新应用app信息
     * @param users
     * @throws Exception
     */
    public void updateMTAppInfos(MTAppInfo mtappinfos) throws Exception;
    
    /**
     * 删除应用app信息
     * @param users
     * @throws Exception
     */
    public void deleteMTAppInfos(String[] ids) throws Exception;
    
    /**
     * 根据应用app代码查询应用app
     * @param usercode
     * @return
     * @throws Exception
     */
    public MTAppInfo findMTAppInfosByID(String id) throws Exception;
}
