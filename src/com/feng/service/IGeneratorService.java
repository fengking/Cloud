package com.feng.service;

import java.util.List;

import com.feng.dto.TsColumn;
import com.feng.dto.TsTable;

/**
 * 
 * 接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IGeneratorService {
	
	public List<TsTable> findTableList(String projcode,String tabname,String tabcname) throws Exception;
	
	public List<TsColumn> findColumnList(Long itableid) throws Exception;
  
	/**
	 * 保存表信息
	 * @param list
	 * @throws Exception
	 */
	public void saveTableInfo(List<TsTable> list) throws Exception;
	/**
	 * 删除项目代码相关的表信息
	 * @param projectcode
	 * @throws Exception
	 */
	public void deleteTableInfo(String projectcode) throws Exception;
	/**
	 * 保存列信息
	 * @param list
	 * @throws Exception
	 */
	public void saveColumnsInfo(List<TsColumn> list) throws Exception;
	
}
