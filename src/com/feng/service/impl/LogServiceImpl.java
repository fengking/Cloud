package com.feng.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.common.model.SqlCommonQto;
import com.feng.common.util.SqlUtil;
import com.feng.common.util.WebIpUtil;
import com.feng.dao.IBaseDao;
import com.feng.dto.TlLog;
import com.feng.dto.TpUsers;
import com.feng.pageModel.Config;
import com.feng.pageModel.DataGrid;
import com.feng.service.ILogService;

/**
 * 
 * 日志接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("logService")
public class LogServiceImpl implements ILogService {

	private IBaseDao<TlLog> baseDao;
	

	public IBaseDao<TlLog> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<TlLog> baseDao) {
		this.baseDao = baseDao;
	}
	
	public Serializable addLog(String usercode,String sproptype, String sdesc,boolean proceedflag) throws Exception {
		TlLog log = new TlLog();
		log.setSdesc(sdesc);
		log.setSproptype(sproptype);
		log.setTsstartdate(new Timestamp(System.currentTimeMillis()));//添加时间
		log.setTsenddate(new Timestamp(System.currentTimeMillis()));//添加时间
		log.setSproceedstate(proceedflag? "1" : "0");
		log.setSip(WebIpUtil.getIpAddr(ServletActionContext.getRequest()));
		log.setSusercode(usercode);
		if(usercode == null){
			HttpSession session = ServletActionContext.getRequest().getSession();
			TpUsers users = (TpUsers) session.getAttribute(Config.getInstance().getSessionInfoName());
			if(users == null){
				log.setSusername("未登陆用户");
			}else{
				log.setSusercode(users.getSusercode());//用户代码
				log.setSusername(users.getSusername());//用户名称
			}
		}
		return baseDao.saveModel(log);
	}

	public DataGrid<TlLog> findLogForpaging(TlLog log, Timestamp startTime, Timestamp endTime, int pageSize, int page, String sort, String order) throws Exception {
      SqlCommonQto qto = SqlUtil.getSqlCommonQto(log);
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
      DataGrid<TlLog> dm = new DataGrid<TlLog>();
      dm.setRows(baseDao.findForPaging( hsql, params, page, pageSize));
	  dm.setTotal(baseDao.findForCount( hcountsql, params));
	  return dm;
	}

}
