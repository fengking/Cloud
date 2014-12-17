package com.feng.service;

import java.io.Serializable;
import java.util.List;

import com.feng.dto.TpUsers;
import com.feng.pageModel.DataGrid;

/**
 * 
 * 用户接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IUsersService {
	/**
	 * 查询用户列表分页
	 * @param users
	 * @return
	 * @throws Exception
	 */
    public List<TpUsers> findUsersPaging(TpUsers users,int pageSize, int page) throws Exception;
    
    /**
     * 查询用户列表
     * @param users
     * @return
     * @throws Exception
     */
    public List<TpUsers> findUserList(TpUsers users) throws Exception;
    
    /**
     * 查询用户列表 分页
     * @param users
     * @param pageSize
     * @param page
     * @return
     * @throws Exception
     */
    public DataGrid findUserForPaging(TpUsers users, int pageSize, int page,String sort,String order) throws Exception;
    
    /**
     * 查询用户数量
     * @param users
     * @return
     * @throws Exception
     */
    public long findUsersForCount(TpUsers users) throws Exception;
    
    /**
     * 新增用户信息
     * @param users
     * @return
     * @throws Exception
     */
    public Serializable saveUsers(TpUsers users) throws Exception;
    /**
     * 更新用户信息
     * @param users
     * @throws Exception
     */
    public void updateUsers(TpUsers users) throws Exception;
    
    /**
     * 删除用户信息
     * @param users
     * @throws Exception
     */
    public void deleteUsers(String[] usercodes) throws Exception;
    
    /**
     * 根据用户代码查询用户
     * @param usercode
     * @return
     * @throws Exception
     */
    public TpUsers findUsersByUsercode(String usercode) throws Exception;
}
