package com.feng.service;

import java.io.Serializable;
import java.sql.Timestamp;

import com.feng.dto.TlLog;
import com.feng.pageModel.DataGrid;

/**
 * 
 * 日志接口定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public interface ILogService {
   /**
    * 增加日志信息
    * @param log
    * @return
    * @throws Exception
    */
   public Serializable addLog( String usercode, String sproptype, String sdesc,boolean proceedflag) throws Exception;
   
   /**
    * 查询日志信息
    * @param log
    * @param startTime
    * @param endTime
    * @param pageSize
    * @param page
    * @return
    * @throws Exception
    */
   public DataGrid findLogForpaging(TlLog log, Timestamp startTime, Timestamp endTime, int pageSize ,int page,String  sort,String order) throws Exception;

}
