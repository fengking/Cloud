package com.feng.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao; 
import com.feng.dto.MTWorkPlan;
import com.feng.pageModel.DataGrid;
import com.feng.service.IMTWorkPlanService;

/**
 * 
 * 应用接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("mtworPlanService")
public class MTWorkPlanServiceImpl implements IMTWorkPlanService{

	private IBaseDao<MTWorkPlan> baseDao;
	

	public IBaseDao<MTWorkPlan> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<MTWorkPlan> baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<MTWorkPlan> findMTWorkPlanPaging(MTWorkPlan workplans,
			int pageSize, int page) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForPaging(workplans, page, pageSize);
	}

	public List<MTWorkPlan> findMTWorkPlanList(MTWorkPlan workplans)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForList(workplans);
	}

	public DataGrid findMTWorkPlanForPaging(MTWorkPlan workplans, int pageSize,
			int page, String sort, String order) throws Exception {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		dg.setRows(baseDao.findForPaging(workplans, page, pageSize, sort, order));
		dg.setTotal(baseDao.findForCount(workplans));
		return dg;
	}

	public long findMTWorkPlanForCount(MTWorkPlan workplans) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForCount(workplans);
	}

	public Serializable saveMTWorkPlans(MTWorkPlan workplans) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.saveModel(workplans);
	}

	public void updateMTWorkPlans(MTWorkPlan workplans) throws Exception {
		// TODO Auto-generated method stub
		baseDao.updateModel(workplans);
	}

	public void deleteMTWorkPlans(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("delete from mt_WorkPlan where PlanID in (");
	       for(int i=0;i<ids.length;i++){
	    	  sb.append("?");
	    	  if(i!=ids.length-1){
	    		 sb.append(","); 
	    	  }
	       }
	       sb.append(")");
	       baseDao.executeHql(sb.toString(), ids);
	}

	public MTWorkPlan findMTWorkPlansByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findByModelPK(MTWorkPlan.class, id);
	}

}
