package com.feng.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import com.feng.pageModel.DataGrid;

/**
 * 
 * 数据库基类接口
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 * @param <T> 模型对象
 */
public interface IBaseDao<T extends java.io.Serializable> {
	
	/**
	 * 新增数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Serializable saveModel(T model) throws Exception;
	
	/**
	 * 更新数据
	 * @param model
	 * @throws Exception
	 */
	public void updateModel(T model) throws Exception;
	
	/**
	 * 执行hql语句
	 * @param hql
	 * @param params
	 * @throws Exception
	 */
	public void executeHql(String hql, List<Object> params) throws Exception;
	
	/**
	 * 执行hql语句
	 * @param hql
	 * @param params
	 * @throws Exception
	 */
	public void executeHql(String hql,Object[] params) throws Exception;
	
   /**
    * 查询数据分页使用
    * @param hql
    * @param params
    * @param page
    * @param pageSize
    * @return
    * @throws Exception
    */
   public List<T> findForPaging( String hql, List<Object> params, int page, int pageSize) throws Exception;
   
   /**
    * 查询数据分页使用
    * @param hql
    * @param params
    * @param page
    * @param pageSize    
    * @param sort 排序列名
    * @param order 排序方式
    * @return
    * @throws Exception
    */
   public List<T> findForPaging( String hql, List<Object> params, int page, int pageSize, String sort, String order) throws Exception;
   
   /**
    * 查询数据分页使用
    * @param hql
    * @param params
    * @param page
    * @param pageSize
    * @return
    * @throws Exception
    */
   public List<T> findForPaging( String hql, Object[] params, int page, int pageSize) throws Exception;
   
   /**
    * 查询数据分页使用
    * @param model
    * @param page
    * @param pageSize
    * @return
    * @throws Exception
    */
   public List<T> findForPaging( T model, int page, int pageSize) throws Exception;
   
   
   /**
    * 查询数据分页使用
    * @param model
    * @param page
    * @param pageSize
    * @param sort 排序列名
    * @param order 排序方式
    * @return
    * @throws Exception
    */
   public List<T> findForPaging( T model, int page, int pageSize, String sort, String order) throws Exception;
   
   /**
    * 查询数据
    * @param hql
    * @param params
    * @return
    * @throws Exception
    */
   public List<T> findForList(String hql,List<Object> params) throws Exception;
   
   /**
    * 查询数据
    * @param hql
    * @param params
    * @param sort 排序列名
    * @param order 排序方式 
    * @return
    * @throws Exception
    */
   public List<T> findForList(String hql,List<Object> params, String sort, String order) throws Exception;
   /**
    * 查询数据
    * @param hql
    * @param params
    * @return
    * @throws Exception
    */
   public List<T> findForList(String hql,Object[] params) throws Exception;
   
   /**
    * 查询数据
    * @param model
    * @return
    * @throws Exception
    */
   public List<T> findForList(T model) throws Exception;
   
   /**
    * 查询数据
    * @param model
    * @param sort 排序列名
    * @param order 排序方式 
    * @return
    * @throws Exception
    */
   public List<T> findForList(T model, String sort, String order) throws Exception;
   
   /**
    * 根据主键查询数据
    * @param pk
    * @return
    * @throws Exception
    */
   public T findByModelPK(Class clazz,Serializable serializable) throws Exception;
   /**
    * 查询总数
    * @param hql
    * @param params
    * @return
    * @throws Exception
    */
   public long findForCount(String hql,Object[] params) throws Exception;
   /**
    * 查询总数
    * @param hql
    * @param params
    * @return
    * @throws Exception
    */
   public long findForCount(String hql,List<Object> params) throws Exception;
   
   /**
    * 查询总数
    * @param model
    * @return
    * @throws Exception
    */
   public long findForCount(T model) throws Exception;
   
   /**
    * 查询分页封装到DataGrid
    * @param model
    * @param page
    * @param pageSize
    * @return
    * @throws Exception
    */
   public DataGrid<T> findDataGridForPaging( T model, int page, int pageSize) throws Exception;
   
  
   /**
    * 查询分页封装到DataGrid
    * @param model
    * @param page
    * @param pageSize
    * @param sort 排序列名
    * @param order 排序方式
    * @return
    * @throws Exception
    */
   public DataGrid<T> findDataGridForPaging( T model, int page, int pageSize, String sort, String order) throws Exception;
   
   /**
    * 原生sql执行
    * @param sql
    * @param objs
    * @return
    * @throws Exception
    */
   public List<Object[]> findWithSql(String sql,Object[] params) throws Exception;
   
}
