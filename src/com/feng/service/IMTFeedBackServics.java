package com.feng.service;

import java.io.Serializable;
import java.util.List;
  
import com.feng.dto.MTFeedBack; 
import com.feng.pageModel.DataGrid;

/**
 * 
 * 反馈接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IMTFeedBackServics {
	
	/**
	 * 查询反馈列表分页
	 * @param users
	 * @return
	 * @throws Exception
	 */
    public List<MTFeedBack> findMTFeedBackPaging(MTFeedBack feedbacks,int pageSize, int page) throws Exception;
    
    /**
     * 查询反馈列表
     * @param users
     * @return
     * @throws Exception
     */
    public List<MTFeedBack> findMTFeedBackList(MTFeedBack feedbacks) throws Exception;
    
    /**
     * 查询反馈列表 分页
     * @param users
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid findMTFeedBackForPaging(MTFeedBack feedbacks, int pageSize, int page,String sort,String order) throws Exception;
    
    /**
     * 查询反馈数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findMTFeedBackForCount(MTFeedBack feedbacks) throws Exception;
    
    /**
     * 新增反馈信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveMTFeedBacks(MTFeedBack feedbacks) throws Exception;
    /**
     * 更新反馈信息
     * @param users
     * @throws Exception
     */
    public void updateMTFeedBacks(MTFeedBack feedbacks) throws Exception;
    
    /**
     * 删除反馈信息
     * @param users
     * @throws Exception
     */
    public void deleteMTFeedBacks(String[] ids) throws Exception;
    
    /**
     * 根据反馈代码查询反馈
     * @param usercode
     * @return
     * @throws Exception
     */
    public MTFeedBack findMTFeedBacksByID(String id) throws Exception;
}
