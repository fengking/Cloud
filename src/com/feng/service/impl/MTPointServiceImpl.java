package com.feng.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao;  
import com.feng.dto.MTPoint;
import com.feng.pageModel.DataGrid;
import com.feng.service.IMTPointService;

/**
 * 
 * 应用接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("mtpointService")
public class MTPointServiceImpl implements IMTPointService{

	private IBaseDao<MTPoint> baseDao;
	

	public IBaseDao<MTPoint> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<MTPoint> baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<MTPoint> findMTPointPaging(MTPoint points, int pageSize,
			int page) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForPaging(points, page, pageSize);
	}

	public List<MTPoint> findMTPointList(MTPoint points) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForList(points);
	}

	public DataGrid findMTPointForPaging(MTPoint points, int pageSize,
			int page, String sort, String order) throws Exception {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		dg.setRows(baseDao.findForPaging(points, page, pageSize, sort, order));
		dg.setTotal(baseDao.findForCount(points));
		return dg;
	}

	public long findMTPointForCount(MTPoint points) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForCount(points);
	}

	public Serializable saveMTPoints(MTPoint points) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.saveModel(points);
	}

	public void updateMTPoints(MTPoint points) throws Exception {
		// TODO Auto-generated method stub
		baseDao.updateModel(points);
	}

	public void deleteMTPoints(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("delete from mt_Point where PointID in (");
	       for(int i=0;i<ids.length;i++){
	    	  sb.append("?");
	    	  if(i!=ids.length-1){
	    		 sb.append(","); 
	    	  }
	       }
	       sb.append(")");
	       baseDao.executeHql(sb.toString(), ids);
	}

	public MTPoint findMTPointsByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findByModelPK(MTPoint.class, id);
	}

}
