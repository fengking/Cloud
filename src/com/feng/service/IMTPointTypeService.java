package com.feng.service;

import java.io.Serializable;
import java.util.List; 
import com.feng.dto.MTPointType; 
import com.feng.pageModel.DataGrid;

/**
 * 
 * 签到点类型接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IMTPointTypeService {

	/**
	 * 查询签到点类型列表分页
	 * @param users
	 * @return
	 * @throws Exception
	 */
    public List<MTPointType> findMTPointTypePaging(MTPointType pointtypes,int pageSize, int page) throws Exception;
    
    /**
     * 查询签到点类型列表
     * @param users
     * @return
     * @throws Exception
     */
    public List<MTPointType>findMTPointTypeList(MTPointType pointtypes) throws Exception;
    
    /**
     * 查询签到点类型列表 分页
     * @param users
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid findMTPointTypeForPaging(MTPointType pointtypes, int pageSize, int page,String sort,String order) throws Exception;
    
    /**
     * 查询签到点类型数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findMTPointTypeForCount(MTPointType pointtypes) throws Exception;
    
    /**
     * 新增签到点类型信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveMTPointTypes(MTPointType pointtypes) throws Exception;
    /**
     * 更新签到点类型信息
     * @param users
     * @throws Exception
     */
    public void updateMTPointTypes(MTPointType pointtypes) throws Exception;
    
    /**
     * 删除签到点类型信息
     * @param users
     * @throws Exception
     */
    public void deleteMTPointTypes(String[] ids) throws Exception;
    
    /**
     * 根据签到点类型代码查询签到点类型
     * @param usercode
     * @return
     * @throws Exception
     */
    public MTPointType findMTPointTypesByID(String id) throws Exception;
}
