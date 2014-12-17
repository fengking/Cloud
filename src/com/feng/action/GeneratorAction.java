package com.feng.action;


import java.net.ConnectException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.feng.dto.TpDbquery;
import com.feng.dto.TpProject;
import com.feng.dto.TpUsers;
import com.feng.dto.TsColumn;
import com.feng.dto.TsTable;
import com.feng.pageModel.Config;
import com.feng.pageModel.DataGrid;
import com.feng.pageModel.Json;
import com.feng.service.IDbQueryService;
import com.feng.service.IGeneratorService;
import com.feng.service.IProjectService;
import com.feng.util.ColumnInfo;
import com.feng.util.DBUtils;
import com.feng.util.NameConvert;
import com.feng.util.TableInfo;


/**
 * 
 * 
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Namespace("/")
public class GeneratorAction extends BaseAction {
	//项目
	private TpProject project = new TpProject();
	//数据查询
	private TpDbquery dbquery  = new TpDbquery();
	//英文名称
	private TsTable table = new TsTable();
	
	private IDbQueryService dbQueryService;
	
	private IProjectService projectService;
	
	private IGeneratorService generatorService;
	
	
	public IDbQueryService getDbQueryService() {
		return dbQueryService;
	}
	
	@Autowired
	public void setDbQueryService(IDbQueryService dbQueryService) {
		this.dbQueryService = dbQueryService;
	}
	

	public IProjectService getProjectService() {
		return projectService;
	}
	
	@Autowired
	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}
	
	public IGeneratorService getGeneratorService() {
		return generatorService;
	}
    @Autowired
	public void setGeneratorService(IGeneratorService generatorService) {
		this.generatorService = generatorService;
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Action("listTableAction")
	public void listtable(){
		if(project == null || project.getSprojcode() == null){
			super.writeJson(new DataGrid<TsTable>(0L, new ArrayList()));
			return ;
		}
		try {
			
//			project = projectService.findPojectBycode(project.getSprojcode());
//			dbquery = dbQueryService.findDbqueryBydbtype(project.getSdbtype());
//			DBUtils dbUtils = new DBUtils( project, dbquery);
//			dbUtils.setNameconvert(new NameConvert(NameConvert.UNDERLINE_TO_UPPERCASE, NameConvert.IGNORE_UNDERLINE));
//			List<TableInfo> list = dbUtils.findTableList(tablename);
//			List<TsTable> tableList = new ArrayList<TsTable>();
//			long i = 0L;
//			for(TableInfo tab : list){
//				tableList.add(new TsTable(i, tab.getTabname(), tab.getTabcname(), new java.sql.Timestamp(System.currentTimeMillis()), session.get(Config.getInstance().getSessionInfoName()) == null ? "" : ((TpUsers)(session.get(Config.getInstance().getSessionInfoName()))).getSusercode(), null, project.getSprojcode()));
//			    i++;
//			}
			List<TsTable> tableList = generatorService.findTableList( project.getSprojcode(), table.getStabname(), table.getStabcname());
			super.writeJson(new DataGrid<TsTable>(Long.valueOf(tableList == null ? 0 :tableList.size()), tableList));
		}catch (Exception e) {
			log.error("查询数据库异常", e);
			super.writeErrorJson(e);
		}
	}
	
	@Action("structsDbAction")
	public void dbDesc(){
       try {
    	   Json j = new Json();
			project = projectService.findPojectBycode(project.getSprojcode());
			dbquery = dbQueryService.findDbqueryBydbtype(project.getSdbtype());
			generatorService.deleteTableInfo(project.getSprojcode());
			DBUtils dbUtils = new DBUtils( project, dbquery);
			dbUtils.setNameconvert(new NameConvert(NameConvert.UNDERLINE_TO_UPPERCASE, NameConvert.IGNORE_UNDERLINE));
			List<TableInfo> list = dbUtils.findTableList("%");
			List<TsTable> tableList = new ArrayList<TsTable>();
			for(TableInfo tab : list){
				tableList.add(new TsTable( null, tab.getTabname(), tab.getTabcname(), new java.sql.Timestamp(System.currentTimeMillis()), session.get(Config.getInstance().getSessionInfoName()) == null ? "" : ((TpUsers)(session.get(Config.getInstance().getSessionInfoName()))).getSusercode(), null, project.getSprojcode()));
			}
			generatorService.saveTableInfo(tableList);
			List<TsColumn> colList = new ArrayList();
			for(TsTable tab : tableList){
				List<ColumnInfo> columnList = dbUtils.findColumnInfo(tab.getStabname());
				for(ColumnInfo columnInfo : columnList){
					colList.add(new TsColumn(null, columnInfo.getColumnname(), columnInfo.getColumncname(), columnInfo.getPks()?"1":"0", null, null, columnInfo.getIsnulls()?"1":"0", "1", columnInfo.getJavatype(), tab.getStabname(), tab.getItableid(), project.getSprojcode(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
				}
			}
			generatorService.saveColumnsInfo(colList);
			j.setMsg("更新数据库结构成功!");
			j.setSuccess(true);
			super.writeJson(j);
		}catch(ConnectException e){
			log.error("数据库连接超时!", e);
			super.writeJson(new Json("连接数据库超时!请检查数据库网络连接,或修改项目参数"));
		}catch(ClassNotFoundException e){
			log.error("数据库JDBC驱动错误!", e);
			super.writeJson(new Json("数据库JDBC驱动错误,情检查JDBC是否存在项目中,或修改数据查询参数"));
		}catch (Exception e) {
			log.error("查询数据库异常", e);
			super.writeErrorJson(e);
		}
	}

	public TpProject getProject() {
		return project;
	}

	public void setProject(TpProject project) {
		this.project = project;
	}

	public TpDbquery getDbquery() {
		return dbquery;
	}

	public void setDbquery(TpDbquery dbquery) {
		this.dbquery = dbquery;
	}

	public TsTable getTable() {
		return table;
	}

	public void setTable(TsTable table) {
		this.table = table;
	}
	
}
