package com.feng.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao;
import com.feng.dto.TpDbquery;
import com.feng.dto.TpFrame;
import com.feng.dto.TpProject;
import com.feng.dto.TpUsers;
import com.feng.pageModel.Config;
import com.feng.service.IComboService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * 下拉数据接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("comboService")
public class ComboServiceImpl implements IComboService {
    private Log log = LogFactory.getLog(ComboServiceImpl.class);
	private IBaseDao baseDao;
	
	public IBaseDao getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(IBaseDao<TpFrame> baseDao) {
		this.baseDao = baseDao;
	}

	public List<TpFrame> findFrameForComboList() throws Exception{
		try {
			Map<String,Object> session = ActionContext.getContext().getSession();
			TpUsers users = (TpUsers) session.get(Config.getInstance().getSessionInfoName());
			return baseDao.findForList("select f from TpFrame f where susercode is null or susercode =?",new String[]{users == null ? "":users.getSusercode()});
		} catch (Exception e) {
			log.error("查询数据异常", e);
			throw e;
		}
	}

	public List<TpDbquery> findDbqueryForComboList() throws Exception {
		try {
			Map<String,Object> session = ActionContext.getContext().getSession();
			TpUsers users = (TpUsers) session.get(Config.getInstance().getSessionInfoName());
			return baseDao.findForList("select tp from TpDbquery tp where susercode is null or susercode =?", new String[]{users == null ? "":users.getSusercode()});
		} catch (Exception e) {
			log.error("查询数据异常", e);
			throw e;
		}
	}

	public List<TpProject> findProjectForComboList() throws Exception {
		try {
			Map<String,Object> session = ActionContext.getContext().getSession();
			TpUsers users = (TpUsers) session.get(Config.getInstance().getSessionInfoName());
			return baseDao.findForList("select tp from TpProject tp where susercode is null or susercode =?", new String[]{users == null ? "":users.getSusercode()});
		} catch (Exception e) {
			log.error("查询数据异常", e);
			throw e;
		}
	}

}
