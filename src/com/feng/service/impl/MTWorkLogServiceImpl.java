package com.feng.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao; 
import com.feng.dto.MTWorkLog;
import com.feng.pageModel.DataGrid;
import com.feng.service.IMTWorkLogService;

/**
 * 
 * 应用接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("mtworLogService")
public class MTWorkLogServiceImpl implements IMTWorkLogService{

	private IBaseDao<MTWorkLog> baseDao;
	

	public IBaseDao<MTWorkLog> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<MTWorkLog> baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<MTWorkLog> findMTWorkLogPaging(MTWorkLog worklogs,
			int pageSize, int page) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForPaging(worklogs, page, pageSize);
	}

	public List<MTWorkLog> findMTWorkLogList(MTWorkLog worklogs)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForList(worklogs);
	}

	public DataGrid findMTWorkLogForPaging(MTWorkLog worklogs, int pageSize,
			int page, String sort, String order) throws Exception {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		dg.setRows(baseDao.findForPaging(worklogs, page, pageSize, sort, order));
		dg.setTotal(baseDao.findForCount(worklogs));
		return dg;
	}

	public long findMTWorkLogForCount(MTWorkLog worklogs) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForCount(worklogs);
	}

	public Serializable saveMTWorkLogs(MTWorkLog worklogs) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.saveModel(worklogs);
	}

	public void updateMTWorkLogs(MTWorkLog worklogs) throws Exception {
		// TODO Auto-generated method stub
		baseDao.updateModel(worklogs);
	}

	public void deleteMTWorkLogs(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("delete from mt_workLog where WorkID in (");
	       for(int i=0;i<ids.length;i++){
	    	  sb.append("?");
	    	  if(i!=ids.length-1){
	    		 sb.append(","); 
	    	  }
	       }
	       sb.append(")");
	       baseDao.executeHql(sb.toString(), ids);
	}

	public MTWorkLog findMTWorkLogsByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findByModelPK(MTWorkLog.class, id);
	}

}
