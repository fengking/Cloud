package com.feng.service;

import java.util.List;

import com.feng.dto.TpDbquery;
import com.feng.dto.TpFrame;
import com.feng.dto.TpProject;

/**
 * 
 * 下拉接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface IComboService {
	
	/**
	 * 查询框架下拉框值
	 * @return
	 * @throws Exception
	 */
   public List<TpFrame> findFrameForComboList() throws Exception;
   
   /**
    * 查询数据方式枚举值
    * @return
    * @throws Exception
    */
   public List<TpDbquery> findDbqueryForComboList() throws Exception;
   
   /**
    * 查询项目下拉框
    * @return
    * @throws Exception
    */
   public List<TpProject> findProjectForComboList() throws Exception;
}
