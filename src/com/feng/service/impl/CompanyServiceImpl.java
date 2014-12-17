package com.feng.service.impl;
 


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List; 
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.common.model.SqlCommonQto;
import com.feng.common.security.SecurityEncoder;
import com.feng.common.util.SqlUtil;
import com.feng.common.util.WebIpUtil;
import com.feng.dao.IBaseDao;
import com.feng.dto.MTCompany; 
import com.feng.dto.TpUsers;
import com.feng.pageModel.Config;
import com.feng.pageModel.DataGrid;
import com.feng.service.ICompanyService; 

/**
 * 
 * 日志接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("companyService")
public class CompanyServiceImpl implements ICompanyService{

	private IBaseDao<MTCompany> baseDao;
	

	public IBaseDao<MTCompany> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<MTCompany> baseDao) {
		this.baseDao = baseDao;
	}
	
	public long findCompanyForCount(MTCompany Company) throws Exception {
		return baseDao.findForCount(Company);
	}
	
	public Serializable saveCompany(MTCompany Company) throws Exception {
		Company.setFCode(UUID.randomUUID().toString()); 
		//users.setSuserpwd(SecurityEncoder.encryptSHA(SecurityEncoder.ENCODE_SHA1, users.getSuserpwd()));//密码
		//users.setTssysupdate(new java.sql.Timestamp(System.currentTimeMillis()));
		return baseDao.saveModel(Company);
	}
	
	/**
	 * 
	 */
	public Serializable addCompany(String FName, String FCode, String Tel,
			String WebSite, String Address, String AdminName,
			String AdminMobile, String AdminEmail, String AdminIMType,
			String AdminIM) throws Exception {
		// TODO Auto-generated method stub
		MTCompany Company = new MTCompany();
		Company.setFName(FName);
		Company.setFCode(FCode);
		Company.setTel(Tel);
		Company.setWebSite(WebSite);
		Company.setAddress(Address);
		Company.setAdminName(AdminName);
		Company.setAdminMobile(AdminMobile);
		Company.setAdminEmail(AdminEmail);
		Company.setAdminIMType(AdminIMType);
		Company.setAdminIM(AdminIM);
		Company.setAuditState("1");
		Company.setApplyDate(new Timestamp(System.currentTimeMillis()));//添加时间
		 
		 
		HttpSession session = ServletActionContext.getRequest().getSession();
		TpUsers users = (TpUsers) session.getAttribute(Config.getInstance().getSessionInfoName()); 
		return baseDao.saveModel(Company);
		 
	}

	public DataGrid findCompanyForpaging(MTCompany Company,
			Timestamp startTime, Timestamp endTime, int pageSize, int page,
			String sort, String order) throws Exception {
		
		SqlCommonQto qto = SqlUtil.getSqlCommonQto(Company);
	      String hsql = qto.getHql();
	      String hcountsql = qto.getCounthql();
	      List<Object> params = new ArrayList<Object>();
	      params.addAll(qto.getParams());
	      if(startTime != null){
	    	  hsql += " and tssysupdate >= ?";
	    	  hcountsql +=" and tssysupdate >= ? ";
	    	  params.add(startTime);
	      }
	      if(endTime != null){
	    	  hsql += " and tssysupdate <= ?";
	    	  hsql += " and tssysupdate >= ?";
	    	  params.add(endTime);
	      }
	      if(sort != null){
	    	  hsql +=" order by " + sort + " " + order;
	      }
	      DataGrid<MTCompany> dm = new DataGrid<MTCompany>();
	      dm.setRows(baseDao.findForPaging( hsql, params, page, pageSize));
		  dm.setTotal(baseDao.findForCount( hcountsql, params));
		  return dm;
	} 

}
