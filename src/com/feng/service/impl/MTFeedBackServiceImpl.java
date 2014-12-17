package com.feng.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao;  
import com.feng.dto.MTFeedBack;
import com.feng.pageModel.DataGrid;
import com.feng.service.IMTFeedBackServics;

/**
 * 
 * 应用接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("mtfeedbackService")
public class MTFeedBackServiceImpl implements IMTFeedBackServics{

	private IBaseDao<MTFeedBack> baseDao;
	

	public IBaseDao<MTFeedBack> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<MTFeedBack> baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<MTFeedBack> findMTFeedBackPaging(MTFeedBack feedbacks,
			int pageSize, int page) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForPaging(feedbacks, page, pageSize);
	}

	public List<MTFeedBack> findMTFeedBackList(MTFeedBack feedbacks)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForList(feedbacks);
	}

	public DataGrid findMTFeedBackForPaging(MTFeedBack feedbacks, int pageSize,
			int page, String sort, String order) throws Exception {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		dg.setRows(baseDao.findForPaging(feedbacks, page, pageSize, sort, order));
		dg.setTotal(baseDao.findForCount(feedbacks));
		return dg;
	}

	public long findMTFeedBackForCount(MTFeedBack feedbacks) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForCount(feedbacks);
	}

	public Serializable saveMTFeedBacks(MTFeedBack feedbacks) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.saveModel(feedbacks);
	}

	public void updateMTFeedBacks(MTFeedBack feedbacks) throws Exception {
		// TODO Auto-generated method stub
		baseDao.updateModel(feedbacks);
	}

	public void deleteMTFeedBacks(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("delete from mt_FeedBack where FID in (");
	       for(int i=0;i<ids.length;i++){
	    	  sb.append("?");
	    	  if(i!=ids.length-1){
	    		 sb.append(","); 
	    	  }
	       }
	       sb.append(")");
	       baseDao.executeHql(sb.toString(), ids);
	}

	public MTFeedBack findMTFeedBacksByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findByModelPK(MTFeedBack.class, id);
	}

}
