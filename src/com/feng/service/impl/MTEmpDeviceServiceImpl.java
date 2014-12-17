package com.feng.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao;  
import com.feng.dto.MTEmpDevice;
import com.feng.pageModel.DataGrid;
import com.feng.service.IMTEmpDeviceService;

/**
 * 
 * 应用接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("mtempDeviceService")
public class MTEmpDeviceServiceImpl implements IMTEmpDeviceService{

	private IBaseDao<MTEmpDevice> baseDao;
	

	public IBaseDao<MTEmpDevice> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<MTEmpDevice> baseDao) {
		this.baseDao = baseDao;
	}
	public List<MTEmpDevice> findMTEmpDevicePaging(MTEmpDevice empdevices,
			int pageSize, int page) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForPaging(empdevices, page, pageSize);
	}

	public List<MTEmpDevice> findMTEmpDeviceList(MTEmpDevice empdevices)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForList(empdevices);
	}

	public DataGrid findMTEmpDeviceForPaging(MTEmpDevice empdevices,
			int pageSize, int page, String sort, String order) throws Exception {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		dg.setRows(baseDao.findForPaging(empdevices, page, pageSize, sort, order));
		dg.setTotal(baseDao.findForCount(empdevices));
		return dg;
	}

	public long findMTEmpDeviceForCount(MTEmpDevice empdevices)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForCount(empdevices);
	}

	public Serializable saveMTEmpDevices(MTEmpDevice empdevices)
			throws Exception {
		// TODO Auto-generated method stub 
		return baseDao.saveModel(empdevices);
	}

	public void updateMTEmpDevices(MTEmpDevice empdevices) throws Exception {
		// TODO Auto-generated method stub
		baseDao.updateModel(empdevices);
	}

	public void deleteMTEmpDevices(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("delete from mt_EmpDevice where FID in (");
	       for(int i=0;i<ids.length;i++){
	    	  sb.append("?");
	    	  if(i!=ids.length-1){
	    		 sb.append(","); 
	    	  }
	       }
	       sb.append(")");
	       baseDao.executeHql(sb.toString(), ids);
	}

	public MTEmpDevice findMTEmpDevicesByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findByModelPK(MTEmpDevice.class, id);
	}

}
