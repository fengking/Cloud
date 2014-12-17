package com.feng.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.common.security.SecurityEncoder;
import com.feng.dao.IBaseDao;
import com.feng.dto.MtEmp; 
import com.feng.dto.TpUsers;
import com.feng.pageModel.DataGrid;
import com.feng.service.IMtEmpService;

/**
 * 
 * 职员接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("mtempService")
public class MtEmpServiceImpl implements IMtEmpService{

	private IBaseDao<MtEmp> baseDao;
	

	public IBaseDao<MtEmp> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<MtEmp> baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<MtEmp> findMtEmpPaging(MtEmp emps, int pageSize, int page)
			throws Exception {
		// TODO Auto-generated method stub 
		return baseDao.findForPaging(emps, page, pageSize);
	}

	public List<MtEmp> findMtEmpList(MtEmp emps) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForList(emps);
	}

	public DataGrid findMtEmpForPaging(MtEmp emps, int pageSize, int page,
			String sort, String order) throws Exception {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		dg.setRows(baseDao.findForPaging(emps, page, pageSize, sort, order));
		dg.setTotal(baseDao.findForCount(emps));
		return dg;
	}

	public long findMtEmpForCount(MtEmp emps) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findForCount(emps);
	}

	public Serializable saveMtEmps(MtEmp emps) throws Exception {
		// TODO Auto-generated method stub
		emps.setFNO(UUID.randomUUID().toString());//用户代码
		emps.setPwd(SecurityEncoder.encryptSHA(SecurityEncoder.ENCODE_SHA1, emps.getPwd()));//密码
		emps.setCreateTime(new java.sql.Timestamp(System.currentTimeMillis()));
		return baseDao.saveModel(emps);
	}

	public void updateMtEmps(MtEmp emps) throws Exception {
		// TODO Auto-generated method stub
		baseDao.updateModel(emps);
		
	}

	public void deleteMtEmps(String[] empcodes) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("delete from TpUsers where susercode in (");
	       for(int i=0;i<empcodes.length;i++){
	    	  sb.append("?");
	    	  if(i!=empcodes.length-1){
	    		 sb.append(","); 
	    	  }
	       }
	       sb.append(")");
	       baseDao.executeHql(sb.toString(), empcodes);
		
	}

	public MtEmp findMtEmpsByMtEmpcode(String empcode) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.findByModelPK(MtEmp.class, empcode);
	}

}
