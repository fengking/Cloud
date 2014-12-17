package com.feng.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao;
import com.feng.dto.TpDbquery;
import com.feng.dto.TpProject;
import com.feng.pageModel.DataGrid;
import com.feng.service.IDbQueryService;

/**
 * 
 * 数据库接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("dbQueryService")
public class DbQueryServiceImpl implements IDbQueryService {
private IBaseDao<TpDbquery> baseDao;
	
	public IBaseDao<TpDbquery> getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(IBaseDao<TpDbquery> baseDao) {
		this.baseDao = baseDao;
	}

	public DataGrid<TpDbquery> findDbqueryForPaging(TpDbquery query, int pageSize, int page, String sort, String order) throws Exception {
		return baseDao.findDataGridForPaging(query, page, pageSize, sort, order);
	}

	public long findDbqueryForCount(TpDbquery query) throws Exception {
		return baseDao.findForCount(query);
	}

	public Serializable saveDbquery(TpDbquery query) throws Exception {
		return baseDao.saveModel(query);
	}

	public void updateDbquery(TpDbquery query) throws Exception {
        baseDao.updateModel(query);
	}

	public void deleteDbquery(String[] ids) throws Exception {
       for(String id : ids){
    	   baseDao.executeHql("delete from TpDbquery where sdbtype=?", new String[]{id});
       }
	}

	public TpDbquery findDbqueryBydbtype(String dbtype) throws Exception {
		return baseDao.findByModelPK(TpDbquery.class ,dbtype);
	}

}
