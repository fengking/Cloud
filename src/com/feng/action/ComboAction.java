package com.feng.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.feng.dto.TpDbquery;
import com.feng.dto.TpFrame;
import com.feng.dto.TpProject;
import com.feng.service.IComboService;

/**
 * 
 * 项目下拉列表处理动作
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
@Namespace("/")
public class ComboAction extends BaseAction {
	private IComboService comboService;

	public IComboService getComboService() {
		return comboService;
	}

	@Autowired
	public void setComboService(IComboService comboService) {
		this.comboService = comboService;
	}

	/**
	 * 下拉框
	 */
	@Action("frameComboAction")
	public void frameCombo() {
		try {
			List<TpFrame> list = comboService.findFrameForComboList();
			super.writeJson(list);
		} catch (Exception e) {
			super.writeErrorJson(e);
		}
	}

	@Action("dbqueryComboAction")
	public void dbqueryCombo() {
		try {
			List<TpDbquery> list = comboService.findDbqueryForComboList();
			super.writeJson(list);
		} catch (Exception e) {
			super.writeErrorJson(e);
		}
	}
	
	@Action("projectComboAction")
	public void projectCombo(){
		try {
			List<TpProject> list = comboService.findProjectForComboList();
			super.writeJson(list);
		} catch (Exception e) {
			super.writeErrorJson(e);
		}
	}
}
