package com.feng.service;

import java.io.Serializable;
import java.util.List;
  


import com.feng.dto.MTPoint; 
import com.feng.pageModel.DataGrid;

/**
 * 
 * 签到点接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IMTPointService {

	/**
	 * 查询签到点列表分页
	 * @param users
	 * @return
	 * @throws Exception
	 */
    public List<MTPoint> findMTPointPaging(MTPoint points,int pageSize, int page) throws Exception;
    
    /**
     * 查询签到点列表
     * @param users
     * @return
     * @throws Exception
     */
    public List<MTPoint> findMTPointList(MTPoint points) throws Exception;
    
    /**
     * 查询签到点列表 分页
     * @param users
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid findMTPointForPaging(MTPoint points, int pageSize, int page,String sort,String order) throws Exception;
    
    /**
     * 查询签到点数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findMTPointForCount(MTPoint points) throws Exception;
    
    /**
     * 新增签到点信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveMTPoints(MTPoint points) throws Exception;
    /**
     * 更新签到点信息
     * @param users
     * @throws Exception
     */
    public void updateMTPoints(MTPoint points) throws Exception;
    
    /**
     * 删除签到点信息
     * @param users
     * @throws Exception
     */
    public void deleteMTPoints(String[] ids) throws Exception;
    
    /**
     * 根据签到点代码查询签到点
     * @param usercode
     * @return
     * @throws Exception
     */
    public MTPoint findMTPointsByID(String id) throws Exception;
}
