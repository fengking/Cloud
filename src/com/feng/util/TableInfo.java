package com.feng.util;

import java.util.List;

/**
 * 
 * 表对象类
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class TableInfo {
  /**
   * 表名
   */
	private String tabname;
  /**
   * 表中文名
   */
  private String tabcname;
  
  /**
   * 列
   */
  private List<ColumnInfo> columns;
  
  /**
   * model名称
   */
  private String modelname;
  

  public TableInfo(String tabname, String tabcname) {
	super();
	this.tabname = tabname;
	this.tabcname = tabcname;
 }



	public String getTabname() {
		return tabname;
	}
	
	public void setTabname(String tabname) {
		this.tabname = tabname;
	}
	
	public String getTabcname() {
		return tabcname;
	}
	
	public void setTabcname(String tabcname) {
		this.tabcname = tabcname;
	}
	
	public List<ColumnInfo> getColumns() {
		return columns;
	}
	
	public void setColumns(List<ColumnInfo> columns) {
		this.columns = columns;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
  
}
