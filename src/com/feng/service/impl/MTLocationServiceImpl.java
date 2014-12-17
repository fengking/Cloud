package com.feng.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao; 
import com.feng.dto.MTFeedBack;
import com.feng.dto.MTLocation;
import com.feng.pageModel.DataGrid;
import com.feng.service.IMTLocationService;

/**
 * 
 * 应用接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("mtlocationService")
public class MTLocationServiceImpl implements IMTLocationService{

	private IBaseDao<MTLocation> baseDao;
	

	public IBaseDao<MTLocation> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<MTLocation> baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<MTLocation> findMTLocationPaging(MTLocation locations,
			int pageSize, int page) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForPaging(locations, page, pageSize);
	}

	public List<MTLocation> findMTLocationList(MTLocation locations)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForList(locations);
	}

	public DataGrid findMTLocationForPaging(MTLocation locations, int pageSize,
			int page, String sort, String order) throws Exception {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		dg.setRows(baseDao.findForPaging(locations, page, pageSize, sort, order));
		dg.setTotal(baseDao.findForCount(locations));
		return dg;
	}

	public long findMTLocationForCount(MTLocation locations) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForCount(locations);
	}

	public Serializable saveMTLocations(MTLocation locations) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.saveModel(locations);
	}

	public void updateMTLocations(MTLocation locations) throws Exception {
		// TODO Auto-generated method stub
		baseDao.updateModel(locations);
	}

	public void deleteMTLocations(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("delete from mt_Location where LocID in (");
	       for(int i=0;i<ids.length;i++){
	    	  sb.append("?");
	    	  if(i!=ids.length-1){
	    		 sb.append(","); 
	    	  }
	       }
	       sb.append(")");
	       baseDao.executeHql(sb.toString(), ids);
	}

	public MTLocation findMTLocationsByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findByModelPK(MTLocation.class, id);
	}

}
