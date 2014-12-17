package com.feng.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao; 
import com.feng.dto.MTPointType;
import com.feng.pageModel.DataGrid;
import com.feng.service.IMTPointTypeService;

/**
 * 
 * 应用接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("mtpointTypeService")
public class MTPointTypeServiceImpl implements IMTPointTypeService{

	private IBaseDao<MTPointType> baseDao;
	

	public IBaseDao<MTPointType> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<MTPointType> baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<MTPointType> findMTPointTypePaging(MTPointType pointtypes,
			int pageSize, int page) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForPaging(pointtypes, page, pageSize);
	}

	public List<MTPointType> findMTPointTypeList(MTPointType pointtypes)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForList(pointtypes);
	}

	public DataGrid findMTPointTypeForPaging(MTPointType pointtypes,
			int pageSize, int page, String sort, String order) throws Exception {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		dg.setRows(baseDao.findForPaging(pointtypes, page, pageSize, sort, order));
		dg.setTotal(baseDao.findForCount(pointtypes));
		return dg;
	}

	public long findMTPointTypeForCount(MTPointType pointtypes)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForCount(pointtypes);
	}

	public Serializable saveMTPointTypes(MTPointType pointtypes)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDao.saveModel(pointtypes);
	}

	public void updateMTPointTypes(MTPointType pointtypes) throws Exception {
		// TODO Auto-generated method stub
		baseDao.updateModel(pointtypes);
	}

	public void deleteMTPointTypes(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("delete from mt_PointType where PointTypeID in (");
	       for(int i=0;i<ids.length;i++){
	    	  sb.append("?");
	    	  if(i!=ids.length-1){
	    		 sb.append(","); 
	    	  }
	       }
	       sb.append(")");
	       baseDao.executeHql(sb.toString(), ids);
	}

	public MTPointType findMTPointTypesByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findByModelPK(MTPointType.class, id);
	}

}
