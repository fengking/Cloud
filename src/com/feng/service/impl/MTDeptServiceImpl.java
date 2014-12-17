package com.feng.service.impl;
import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
 






import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired; 

import com.feng.common.security.SecurityEncoder;
import com.feng.dao.IBaseDao; 
import com.feng.dto.MTAppInfo;
import com.feng.dto.MTDept; 
import com.feng.pageModel.DataGrid;
import com.feng.service.IMTDeptService; 

/**
 * 
 * 应用接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("mtdeptService")
public class MTDeptServiceImpl implements IMTDeptService{

	private IBaseDao<MTDept> baseDao;
	

	public IBaseDao<MTDept> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<MTDept> baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<MTDept> findMTDeptPaging(MTDept mtdepts, int pageSize, int page)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForPaging(mtdepts, page, pageSize);
	}

	public List<MTDept> findMTDeptList(MTDept mtdepts) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForList(mtdepts);
	}

	public DataGrid findMTDeptForPaging(MTDept mtdepts, int pageSize, int page,
			String sort, String order) throws Exception {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		dg.setRows(baseDao.findForPaging(mtdepts, page, pageSize, sort, order));
		dg.setTotal(baseDao.findForCount(mtdepts));
		return dg;
	}

	public long findMTDeptForCount(MTDept mtdepts) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForCount(mtdepts);
	}

	public Serializable saveMTDepts(MTDept mtdepts) throws Exception {
		// TODO Auto-generated method stub
		mtdepts.setCreateDateTime(new java.sql.Timestamp(System.currentTimeMillis()));
		return baseDao.saveModel(mtdepts);
	}

	public void updateMTDepts(MTDept mtdepts) throws Exception {
		// TODO Auto-generated method stub 
		baseDao.updateModel(mtdepts);
	}

	public void deleteMTDepts(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("delete from mt_Dept where FID in (");
	       for(int i=0;i<ids.length;i++){
	    	  sb.append("?");
	    	  if(i!=ids.length-1){
	    		 sb.append(","); 
	    	  }
	       }
	       sb.append(")");
	       baseDao.executeHql(sb.toString(), ids);
	}

	public MTDept findMTDeptsByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findByModelPK(MTDept.class, id);
	}

}
