package com.feng.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.feng.dto.TpDbquery;
import com.feng.pageModel.Json;
import com.feng.service.IDbQueryService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * 数据库查询动作拦截
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Namespace("/")
public class DbQueryAction extends BaseAction implements ModelDriven<TpDbquery> {
	private Log log = LogFactory.getLog(DbQueryAction.class);
	private IDbQueryService dbQueryService;
	private TpDbquery query = new TpDbquery();

	public IDbQueryService getDbQueryService() {
		return dbQueryService;
	}

	@Autowired
	public void setDbQueryService(IDbQueryService dbQueryService) {
		this.dbQueryService = dbQueryService;
	}

	@Action("dbqueryAction")
	public void list() {
		try {
			super.writeJson(dbQueryService.findDbqueryForPaging(query, rows,
					page, sort, order));
		} catch (Exception e) {
			log.error("查询异常", e);
			super.writeErrorJson(e);
		}
	}

	@Action("dbqueryAddAction")
	public void add() {
		try {
			Json j = new Json();
			TpDbquery q = new TpDbquery(query.getSdbtype());
			if (dbQueryService.findDbqueryForCount(q) > 0) {
				j.setMsg("数据库类型已存在!请修改后再试");
			} else {
				dbQueryService.saveDbquery(query);
				j.setObj(query);
				j.setSuccess(true);
				j.setMsg("新增成功!");
			}
			super.writeJson(j);
		} catch (Exception e) {
			log.error("新增异常", e);
			super.writeErrorJson(e);
		}
	}

	@Action("dbqueryEditAction")
	public void edit() {
		try {
			Json j = new Json();
			dbQueryService.updateDbquery(query);
			j.setSuccess(true);
			j.setObj(query);
			j.setMsg("修改成功!");
			super.writeJson(j);
		} catch (Exception e) {
			log.error("修改异常", e);
			super.writeErrorJson(e);
		}
	}

	@Action("dbqueryDelAction")
	public void delete() {
		try {
			Json j = new Json();
			dbQueryService.deleteDbquery(ids.split(","));
			j.setSuccess(true);
			j.setMsg("删除成功!");
			j.setObj(query);
			super.writeJson(j);
		} catch (Exception e) {
			log.error("删除异常", e);
			super.writeErrorJson(e);
		}
	}

	public TpDbquery getModel() {
		return query;
	}
}
