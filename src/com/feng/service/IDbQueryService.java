package com.feng.service;

import java.io.Serializable;

import com.feng.dto.TpDbquery;
import com.feng.pageModel.DataGrid;

/**
 * 
 * 数据查询接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IDbQueryService {
	/**
     * 查询数据库查询列表 分页
     * @param query
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid<TpDbquery> findDbqueryForPaging(TpDbquery query, int pageSize, int page, String sort, String order) throws Exception;
    
    /**
     * 查询数据库查询数量
     * @param query
     * @return
     * @throws Exception
     */
    public long findDbqueryForCount(TpDbquery query) throws Exception;
    
    /**
     * 根据数据库类型查询数据库配置信息
     * @param query
     * @return
     * @throws Exception
     */
    public TpDbquery findDbqueryBydbtype(String dbtype) throws Exception;
    
    /**
     * 新增数据库查询信息
     * @param query
     * @return
     * @throws Exception
     */
    public Serializable saveDbquery(TpDbquery query) throws Exception;
    
    /**
     * 更新数据库查询信息
     * @param query
     * @throws Exception
     */
    public void updateDbquery(TpDbquery query) throws Exception;
    
    /**
     * 删除数据库查询信息
     * @param ids
     * @throws Exception
     */
    public void deleteDbquery(String[] ids) throws Exception;
}
