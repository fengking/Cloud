package com.feng.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
 
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired; 
import com.feng.common.security.SecurityEncoder;
import com.feng.dao.IBaseDao;
import com.feng.dto.MTAppInfo;  
import com.feng.pageModel.DataGrid;
import com.feng.service.IMTAppInfoService; 

/**
 * 
 * 应用接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("mtappInfoService")
public class MTAppInfoServiceImpl implements IMTAppInfoService{

	private IBaseDao<MTAppInfo> baseDao;
	

	public IBaseDao<MTAppInfo> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<MTAppInfo> baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<MTAppInfo> findMTAppInfoPaging(MTAppInfo mtappinfos,
			int pageSize, int page) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForPaging(mtappinfos, page, pageSize);
	}

	public List<MTAppInfo> findMTAppInfoList(MTAppInfo mtappinfos)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForList(mtappinfos);
	}

	public DataGrid findMTAppInfoForPaging(MTAppInfo mtappinfos, int pageSize,
			int page, String sort, String order) throws Exception {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		dg.setRows(baseDao.findForPaging(mtappinfos, page, pageSize, sort, order));
		dg.setTotal(baseDao.findForCount(mtappinfos));
		return dg;
	}

	public long findMTAppInfoForCount(MTAppInfo mtappinfos) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForCount(mtappinfos);
	}

	public Serializable saveMTAppInfos(MTAppInfo mtappinfos) throws Exception {
		// TODO Auto-generated method stub 
		mtappinfos.setFCreateDate(new java.sql.Timestamp(System.currentTimeMillis()));
		return baseDao.saveModel(mtappinfos);
	}

	public void updateMTAppInfos(MTAppInfo mtappinfos) throws Exception {
		// TODO Auto-generated method stub
		mtappinfos.setFUpdateDate(new java.sql.Timestamp(System.currentTimeMillis()));
		baseDao.updateModel(mtappinfos);
		
	}

	public void deleteMTAppInfos(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("delete from mt_AppInfo where FID in (");
	       for(int i=0;i<ids.length;i++){
	    	  sb.append("?");
	    	  if(i!=ids.length-1){
	    		 sb.append(","); 
	    	  }
	       }
	       sb.append(")");
	       baseDao.executeHql(sb.toString(), ids);
		
	}

	public MTAppInfo findMTAppInfosByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findByModelPK(MTAppInfo.class, id);
	}

}
