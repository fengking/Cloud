package com.feng.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.feng.common.model.SqlCommonQto;
import com.feng.common.util.BeanUtil;
import com.feng.common.util.SqlUtil;
import com.feng.dao.IBaseDao;
import com.feng.pageModel.DataGrid;

/**
 * 
 * 数据库基类接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 * @param <T>
 */
@Repository("baseDao")
public class BaseDaoImpl<T extends java.io.Serializable> implements IBaseDao<T> {
	protected SessionFactory sessionFactory;

	/**
	 * 回话工厂 
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 获取当前ǰsession
	 * 
	 * @return
	 */
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 新增数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Serializable saveModel(T model) throws Exception {
		BeanUtil.setProperties(model, "tssysupdate", new Timestamp(System.currentTimeMillis()));
		return getCurrentSession().save(model);
	}

	/**
	 * 更新数据
	 * @param model
	 * @throws Exception
	 */
	public void updateModel(T model) throws Exception {
		BeanUtil.setProperties(model, "tssysupdate", new Timestamp(System.currentTimeMillis()));
		getCurrentSession().update(model);
	}

	/**
	 * 执行hql语句
	 * @param hql
	 * @param params
	 * @throws Exception
	 */
	public void executeHql(String hql, List<Object> params) throws Exception {
		executeHql(hql, params.toArray());
	}

	/**
	 * 执行hql语句
	 * @param hql
	 * @param params
	 * @throws Exception
	 */
	public void executeHql(String hql, Object[] params) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		int i = 0;
		for (Object o : params) {
			q.setParameter(i, o);
			i++;
		}
		q.executeUpdate();
	}

	   /**
	    * 查询数据分页使用
	    * @param hql
	    * @param params
	    * @param page
	    * @param pageSize
	    * @return
	    * @throws Exception
	    */
	public List<T> findForPaging(String hql, List<Object> params, int page, int pageSize) throws Exception {
		return findForPaging(hql, params.toArray(), page, pageSize);
	}

	   /**
	    * 查询数据分页使用
	    * @param hql
	    * @param params
	    * @param page
	    * @param pageSize
	    * @return
	    * @throws Exception
	    */
	public List<T> findForPaging(String hql, Object[] params, int page, int pageSize) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		int i = 0;
		for (Object o : params) {
			q.setParameter(i, o);
			i++;
		}
		return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).list();
	}

	   /**
	    * 查询数据
	    * @param hql
	    * @param params
	    * @return
	    * @throws Exception
	    */
	public List<T> findForList(String hql, List<Object> params) throws Exception {
		return findForList(hql, params.toArray());
	}

	   /**
	    * 查询数据
	    * @param hql
	    * @param params
	    * @return
	    * @throws Exception
	    */
	public List<T> findForList(String hql, Object[] params) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		int i = 0;
		if(params != null){
			for (Object o : params) {
				q.setParameter(i, o);
				i++;
			}
		}
		return q.list();
	}

	   /**
	    * 根据主键查询数据
	    * @param pk
	    * @return
	    * @throws Exception
	    */
	public T findByModelPK(Class clazz,Serializable serializable) throws Exception {
		return (T) getCurrentSession().get( clazz, serializable);
	}

	   /**
	    * 查询总数
	    * @param hql
	    * @param params
	    * @return
	    * @throws Exception
	    */
	public long findForCount(String hql, Object[] params) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		int i = 0;
		if(params != null){
			for (Object o : params) {
				q.setParameter(i, o);
				i++;
			}
		}
		return (Long) q.list().iterator().next();
	}
	
	   /**
	    * 查询数据分页使用
	    * @param model
	    * @param page
	    * @param pageSize
	    * @return
	    * @throws Exception
	    */
	public List<T> findForPaging(T model, int page, int pageSize)
			throws Exception {
		 SqlCommonQto  qto = SqlUtil.getSqlCommonQto(model);
		return findForPaging(qto.getHql(), qto.getParams(), page, pageSize);
	}
	
	   /**
	    * 查询数据
	    * @param model
	    * @return
	    * @throws Exception
	    */
	public List<T> findForList(T model) throws Exception {
		 SqlCommonQto  qto = SqlUtil.getSqlCommonQto(model);
		return findForList(qto.getHql(), qto.getParams());
	}
	
	   /**
	    * 查询总数
	    * @param model
	    * @return
	    * @throws Exception
	    */
	public long findForCount(T model) throws Exception {
		 SqlCommonQto  qto = SqlUtil.getSqlCommonQto(model);
		return findForCount(qto.getCounthql(), qto.getParams());
	}

	   /**
	    * 查询总数
	    * @param hql
	    * @param params
	    * @return
	    * @throws Exception
	    */
	public long findForCount(String hql, List<Object> params) throws Exception {
		return findForCount(hql, params.toArray());
	}

	   /**
	    * 原生sql执行
	    * @param sql
	    * @param objs
	    * @return
	    * @throws Exception
	    */
	public List<Object[]> findWithSql(String sql, Object[] params) throws Exception {
		Query q = getCurrentSession().createSQLQuery(sql);
		int i = 0;
		if(params != null){
			for (Object o : params) {
				q.setParameter(i, o);
				i++;
			}
		}
		return q.list();
	}
	
	   /**
	    * 查询分页封装到DataGrid
	    * @param model
	    * @param page
	    * @param pageSize
	    * @return
	    * @throws Exception
	    */
	public DataGrid<T> findDataGridForPaging(T model, int page, int pageSize)
			throws Exception {
		DataGrid<T> dg = new DataGrid<T>();
		SqlCommonQto  qto = SqlUtil.getSqlCommonQto(model);
		dg.setRows(findForPaging( qto.getHql(), qto.getParams(), page, pageSize));
		dg.setTotal(findForCount(qto.getCounthql(), qto.getParams()));
		return dg;
	}
	
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
	public List<T> findForPaging(T model, int page, int pageSize, String sort,
			String order) throws Exception {
		 SqlCommonQto  qto = SqlUtil.getSqlCommonQto(model);
	     return findForPaging(qto.getHql() + (sort == null ? " order by "+ sort + " " + order : ""), qto.getParams(), page, pageSize);
	}
	
	  /**
	    * 查询数据
	    * @param hql
	    * @param params
	    * @param sort 排序列名
	    * @param order 排序方式 
	    * @return
	    * @throws Exception
	    */
	public List<T> findForList(String hql, List<Object> params, String sort,
			String order) throws Exception {
		 return findForList(hql + (sort == null ? " order by "+ sort + " " + order : ""), params);
	}
	
	   /**
	    * 查询数据
	    * @param model
	    * @param sort 排序列名
	    * @param order 排序方式 
	    * @return
	    * @throws Exception
	    */
	public List<T> findForList(T model, String sort, String order)
			throws Exception {
		 SqlCommonQto  qto = SqlUtil.getSqlCommonQto(model);
		 return findForList(qto.getHql() + (sort == null ? " order by "+ sort + " " + order : ""), qto.getParams());
	}
	

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
	public DataGrid<T> findDataGridForPaging(T model, int page, int pageSize,
			String sort, String order) throws Exception {
		DataGrid<T> dg = new DataGrid<T>();
		SqlCommonQto  qto = SqlUtil.getSqlCommonQto(model);
		dg.setRows(findForPaging( qto.getHql(), qto.getParams(), page, pageSize, sort, order));
		dg.setTotal(findForCount(qto.getCounthql(), qto.getParams()));
		return dg;
	}
	
	  
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
	public List<T> findForPaging(String hql, List<Object> params, int page,
			int pageSize, String sort, String order) throws Exception {
		return findForPaging(hql + (sort == null ? " order by "+ sort + " " + order : "") ,params, page, pageSize);
	}
	 
}
