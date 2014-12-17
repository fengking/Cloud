package com.feng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.dao.IBaseDao;
import com.feng.dto.TsColumn;
import com.feng.dto.TsTable;
import com.feng.service.IGeneratorService;

/**
 * 
 * 接口实现
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Service("generatorService")
public class GeneratorServiceImpl implements IGeneratorService {
	
	private IBaseDao baseDao;
	
	public IBaseDao getBaseDao() {
		return baseDao;
	}
    
	@Autowired
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public void saveTableInfo(List<TsTable> list) throws Exception {
		for(TsTable table : list){
			table.setItableid((Long) baseDao.saveModel(table));
		}
	}

	public void deleteTableInfo(String projectcode) throws Exception {
		baseDao.executeHql("delete from TsTable where sprojcode=?", new String[]{projectcode});
		baseDao.executeHql("delete from TsColumn where sprojcode=?", new String[]{projectcode});
	}

	public void saveColumnsInfo(List<TsColumn> list) throws Exception {
		for(TsColumn column : list){
		  baseDao.saveModel(column);
		}
	}

	public List<TsTable> findTableList(String projcode,String tabname,String tabcname) throws Exception {
		List<String> params = new ArrayList<String>();
		String sql = "select ts from TsTable ts where stabname like ?";
		if(tabname != null && !"".equals(tabname)){
			params.add("%"+tabname.toUpperCase()+"%");
		}else{
			params.add("%");
		}
		if(tabcname != null && !"".equals(tabcname)){
			sql+=" and stabcname like ?";
			params.add("%"+tabcname+"%");
		}
		if(projcode != null && !projcode.equals("")){
			sql += " and sprojcode=?";
			params.add(projcode);
		}
		return baseDao.findForList( sql, params);
	}

	public List<TsColumn> findColumnList(Long itableid) throws Exception {
		TsColumn col = new TsColumn();
		col.setItableid(itableid);
		return baseDao.findForList(col);
	}



}
