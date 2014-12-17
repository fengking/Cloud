package com.feng.service;

import java.io.Serializable;
import java.util.List;
  

import com.feng.dto.MTLocation; 
import com.feng.pageModel.DataGrid;

/**
 * 
 * 回签接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IMTLocationService {
	
	/**
	 * 查询回签列表分页
	 * @param users
	 * @return
	 * @throws Exception
	 */
    public List<MTLocation> findMTLocationPaging(MTLocation locations,int pageSize, int page) throws Exception;
    
    /**
     * 查询回签列表
     * @param users
     * @return
     * @throws Exception
     */
    public List<MTLocation> findMTLocationList(MTLocation locations) throws Exception;
    
    /**
     * 查询回签列表 分页
     * @param users
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid findMTLocationForPaging(MTLocation locations, int pageSize, int page,String sort,String order) throws Exception;
    
    /**
     * 查询回签数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findMTLocationForCount(MTLocation locations) throws Exception;
    
    /**
     * 新增回签信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveMTLocations(MTLocation locations) throws Exception;
    /**
     * 更新回签信息
     * @param users
     * @throws Exception
     */
    public void updateMTLocations(MTLocation locations) throws Exception;
    
    /**
     * 删除回签信息
     * @param users
     * @throws Exception
     */
    public void deleteMTLocations(String[] ids) throws Exception;
    
    /**
     * 根据回签代码查询回签
     * @param usercode
     * @return
     * @throws Exception
     */
    public MTLocation findMTLocationsByID(String id) throws Exception;
}
