package com.feng.service;

import java.io.Serializable;
import java.sql.Timestamp;

import com.feng.dto.MTCompany;   
import com.feng.pageModel.DataGrid;
/**
 * 
 * 公司接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface ICompanyService {
	
	
	/**
     * 查询公司数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findCompanyForCount(MTCompany Company) throws Exception;
    
    /**
     * 新增用户信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveCompany(MTCompany Company) throws Exception;
    
	 /**
	    * 增加公司信息
	    * @param log
	    * @return
	    * @throws Exception
	    */
	   public Serializable addCompany( String FName, String FCode, String Tel,String WebSite,String Address,String AdminName,String AdminMobile
				,String AdminEmail,String AdminIMType,String AdminIM ) throws Exception;
	   
	   /**
	    * 查询公司信息
	    * @param Company
	    * @param startTime
	    * @param endTime
	    * @param pageSize
	    * @param page
	    * @return
	    * @throws Exception
	    */
	   public DataGrid findCompanyForpaging(MTCompany Company, Timestamp startTime, Timestamp endTime, int pageSize ,int page,String  sort,String order) throws Exception;


}
