package com.feng.dto;

import java.sql.*;
import java.io.IOException;
import java.lang.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

                        
/**
 * table name: tl_log
 * table remark: 系统日志表; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.179
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 */
@Entity
@Table(name = "tl_log")
public class TlLog implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//////////////////////////// Fields 1/////////////////////////////////////////
	
	  /** 日志编号  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19   */
	    protected Long  ilogid;
	    
	  /** 用户代码  , char  ,     Length: 36   */
	    protected String  susercode;
	    
	  /** 用户名  , varchar  ,     Length: 21   */
	    protected String  susername;
	    
	  /** 操作类型
            1-登陆
            2-添加
            3-修改
            4-生成
            5-导出  , char  ,     Length: 1   */
	    protected String  sproptype;
	    
	  /** 描述  , varchar  ,     Length: 170   */
	    protected String  sdesc;
	    
	  /** 结束时间  , timestamp  ,     Length: 30  Default:CURRENT_TIMESTAMP */
	    protected java.sql.Timestamp  tsenddate;
	    
	  /** 方法名  , varchar  ,     Length: 10   */
	    protected String  smethodname;
	    
	  /** 执行结果
            1-成功
            2-失败  , char  ,     Length: 1   */
	    protected String  sproceedstate;
	    
	  /** 开始时间  , timestamp  ,     Length: 30  Default:0000-00-00 00:00:00 */
	    protected java.sql.Timestamp  tsstartdate;
	    
	  /** 登陆IP  , varchar  ,     Length: 36   */
	    protected String  sip;
	    
	  /** 系统更新时间  , timestamp  ,     Length: 30  Default:0000-00-00 00:00:00 */
	    protected java.sql.Timestamp  tssysupdate;
	    
	    /** 类名  , varchar  ,     Length: 100   */
	    protected String sclassname;
	    

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public TlLog() {
	}

	/** minimal constructor */
	public TlLog( Long ilogid) {
		super();
		this.ilogid = ilogid;        
        }

	/** full constructor */
	public TlLog( Long ilogid, String susercode, String susername, String sproptype, String sdesc, java.sql.Timestamp tsenddate, String smethodname, String sproceedstate, java.sql.Timestamp tsstartdate, String sip, String sclassname, java.sql.Timestamp tssysupdate) {
		super();
		this.ilogid = ilogid;
		this.susercode = susercode;
		this.susername = susername;
		this.sproptype = sproptype;
		this.sdesc = sdesc;
		this.tsenddate = tsenddate;
		this.smethodname = smethodname;
		this.sproceedstate = sproceedstate;
		this.tsstartdate = tsstartdate;
		this.sip = sip;
		this.sclassname = sclassname;
		this.tssysupdate = tssysupdate;
	}
	
    // Property accessors
       /** 标准的annotation方式的主键生成策略如下 
       * AUTO - 可以是identity column类型,或者sequence类型或者table类型,取决于不同的底层数据库 
       * TABLE - 使用表保存id值（也就是会为应用的表创建一张专门保存Id的表，记录对应的表的对应最大的ID值 
       * IDENTITY - 自增 
       * SEQUENCE – sequence  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE") 
       **/
	
	/** 日志编号  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19 */
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "I_LOGID",  nullable = false,  length = 19)
   	public Long getIlogid() {
		return this.ilogid;
	}

	/** 日志编号 , bigint  ,  PK ,   NOT NULL  , Length: 19   */
	public void setIlogid(Long ilogid) {
		this.ilogid = ilogid;
	}
	
	/** 用户代码  , char  ,     Length: 36 */
    @Column(name = "S_USERCODE",  nullable = true,  length = 36)
   	public String getSusercode() {
		return this.susercode;
	}

	/** 用户代码 , char  ,    Length: 36   */
	public void setSusercode(String susercode) {
		this.susercode = susercode;
	}
	
	/** 用户名  , varchar  ,     Length: 21 */
    @Column(name = "S_USERNAME",  nullable = true,  length = 21)
   	public String getSusername() {
		return this.susername;
	}

	/** 用户名 , varchar  ,    Length: 21   */
	public void setSusername(String susername) {
		this.susername = susername;
	}
	
	/** 操作类型
            1-登陆
            2-添加
            3-修改
            4-生成
            5-导出  , char  ,     Length: 1 */
    @Column(name = "S_PROPTYPE",  nullable = true,  length = 1)
   	public String getSproptype() {
		return this.sproptype;
	}

	/** 操作类型
            1-登陆
            2-添加
            3-修改
            4-生成
            5-导出 , char  ,    Length: 1   */
	public void setSproptype(String sproptype) {
		this.sproptype = sproptype;
	}
	
	/** 描述  , varchar  ,     Length: 512 */
    @Column(name = "S_DESC",  nullable = true,  length = 512)
   	public String getSdesc() {
		return this.sdesc;
	}

	/** 描述 , varchar  ,    Length: 170   */
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	
	/** 结束时间  , timestamp  ,     Length: 30 */
    @Column(name = "TS_ENDDATE",  nullable = true,  length = 30)
   	public java.sql.Timestamp getTsenddate() {
		return this.tsenddate;
	}

	/** 结束时间 , timestamp  ,    Length: 30   */
	public void setTsenddate(java.sql.Timestamp tsenddate) {
		this.tsenddate = tsenddate;
	}
	
	/** 方法名  , varchar  ,     Length: 125 */
    @Column(name = "S_METHODNAME",  nullable = true,  length = 125)
   	public String getSmethodname() {
		return this.smethodname;
	}

	/** 方法名 , varchar  ,    Length: 10   */
	public void setSmethodname(String smethodname) {
		this.smethodname = smethodname;
	}
	
	/** 执行结果
            1-成功
            2-失败  , char  ,     Length: 1 */
    @Column(name = "S_PROCEEDSTATE",  nullable = true,  length = 1)
   	public String getSproceedstate() {
		return this.sproceedstate;
	}

	/** 执行结果
            1-成功
            2-失败 , char  ,    Length: 1   */
	public void setSproceedstate(String sproceedstate) {
		this.sproceedstate = sproceedstate;
	}
	
	/** 开始时间  , timestamp  ,     Length: 30 */
    @Column(name = "TS_STARTDATE",  nullable = true,  length = 30)
   	public java.sql.Timestamp getTsstartdate() {
		return this.tsstartdate;
	}

	/** 开始时间 , timestamp  ,    Length: 30   */
	public void setTsstartdate(java.sql.Timestamp tsstartdate) {
		this.tsstartdate = tsstartdate;
	}
	
	/** 登陆IP  , varchar  ,     Length: 36 */
    @Column(name = "S_IP",  nullable = true,  length = 36)
   	public String getSip() {
		return this.sip;
	}

	/** 登陆IP , varchar  ,    Length: 36   */
	public void setSip(String sip) {
		this.sip = sip;
	}
	
	/** 系统更新时间  , timestamp  ,     Length: 30 */
    @Column(name = "TS_SYSUPDATE",  nullable = true,  length = 30)
   	public java.sql.Timestamp getTssysupdate() {
		return this.tssysupdate;
	}

	/** 系统更新时间 , timestamp  ,    Length: 30   */
	public void setTssysupdate(java.sql.Timestamp tssysupdate) {
		this.tssysupdate = tssysupdate;
	}
	
	/** 调用类名  , varchar  ,     Length: 100 */
    @Column(name = "S_CLASSNAME",  nullable = true,  length = 100)
	public String getSclassname() {
		return sclassname;
	}
    
    /** 调用类名  , varchar  ,     Length: 100 */
	public void setSclassname(String sclassname) {
		this.sclassname = sclassname;
	}

	public String toString() {
		return  "日志编号 ilogid="+ilogid+" , "+  "用户代码 susercode="+susercode+" , "+  "用户名 susername="+susername+" , "+  "操作类型            1-登陆            2-添加            3-修改            4-生成            5-导出 sproptype="+sproptype+" , "+  "描述 sdesc="+sdesc+" , "+  "结束时间 tsenddate="+tsenddate+" , "+  "方法名 smethodname="+smethodname+" , "+  "执行结果            1-成功            2-失败 sproceedstate="+sproceedstate+" , "+  "开始时间 tsstartdate="+tsstartdate+" , "+  "登陆IP sip="+sip+" , "+  "系统更新时间 tssysupdate="+tssysupdate;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    TlLog model = new TlLog();
	    		  model.setIlogid(this.ilogid);
				  model.setSusercode(this.susercode);
				  model.setSusername(this.susername);
				  model.setSproptype(this.sproptype);
				  model.setSdesc(this.sdesc);
				  model.setTsenddate(this.tsenddate);
				  model.setSmethodname(this.smethodname);
				  model.setSproceedstate(this.sproceedstate);
				  model.setTsstartdate(this.tsstartdate);
				  model.setSip(this.sip);
				  model.setSclassname(this.sclassname);
				  model.setTssysupdate(this.tssysupdate);
				return model;
	}

	public void close() throws IOException {
	}
}