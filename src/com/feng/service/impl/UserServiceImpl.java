package com.feng.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.feng.common.security.SecurityEncoder;
import com.feng.dao.IBaseDao;
import com.feng.dto.TpUsers;
import com.feng.pageModel.DataGrid;
import com.feng.service.IUsersService;

/**
 * 
 * 用户接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("userService")
public class UserServiceImpl implements IUsersService {
	
	private IBaseDao<TpUsers> baseDao;
	

	public IBaseDao<TpUsers> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<TpUsers> baseDao) {
		this.baseDao = baseDao;
	}

	public List<TpUsers> findUsersPaging(TpUsers users, int page, int pageSize)
			throws Exception {
		return baseDao.findForPaging(users, page, pageSize);
	}

	public long findUsersForCount(TpUsers users) throws Exception {
		return baseDao.findForCount(users);
	}

	public Serializable saveUsers(TpUsers users) throws Exception {
		users.setSusercode(UUID.randomUUID().toString());//用户代码
		users.setSuserpwd(SecurityEncoder.encryptSHA(SecurityEncoder.ENCODE_SHA1, users.getSuserpwd()));//密码
		users.setTssysupdate(new java.sql.Timestamp(System.currentTimeMillis()));
		return baseDao.saveModel(users);
	}

	public void updateUsers(TpUsers users) throws Exception {
          baseDao.updateModel(users);
	}

	public List<TpUsers> findUserList(TpUsers users) throws Exception {
		return baseDao.findForList(users);
	}

	public DataGrid findUserForPaging(TpUsers users, int pageSize, int page,String sort,String order)
			throws Exception {
		DataGrid dg = new DataGrid();
		dg.setRows(baseDao.findForPaging(users, page, pageSize, sort, order));
		dg.setTotal(baseDao.findForCount(users));
		return dg;
	}

	public void deleteUsers(String[] usercodes) throws Exception {
       StringBuffer sb = new StringBuffer("delete from TpUsers where susercode in (");
       for(int i=0;i<usercodes.length;i++){
    	  sb.append("?");
    	  if(i!=usercodes.length-1){
    		 sb.append(","); 
    	  }
       }
       sb.append(")");
       baseDao.executeHql(sb.toString(), usercodes);
	}

	public TpUsers findUsersByUsercode(String usercode) throws Exception {
		return baseDao.findByModelPK(TpUsers.class, usercode);
	}

}
