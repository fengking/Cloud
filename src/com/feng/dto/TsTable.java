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
 * table name: ts_table
 * table remark: 表信息; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.538
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 */
@Entity
@Table(name = "ts_table")
public class TsTable implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//////////////////////////// Fields 1/////////////////////////////////////////
	
	  /** 表编号  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19   */
	    protected Long  itableid;
	    
	  /** 表名称  , varchar  ,     Length: 42   */
	    protected String  stabname;
	    
	  /** 表中文名称  , varchar  ,     Length: 42   */
	    protected String  stabcname;
	    
	  /** 开始时间  , timestamp  ,     Length: 30  Default:CURRENT_TIMESTAMP */
	    protected java.sql.Timestamp  tsstartdate;
	    
	  /** 用户代码  , char  ,     Length: 36   */
	    protected String  susercode;
	    
	  /** 系统更新时间  , timestamp  ,     Length: 30  Default:0000-00-00 00:00:00 */
	    protected java.sql.Timestamp  tssysupdate;
	    
	  /** 项目代码  , varchar  ,     Length: 36   */
	    protected String  sprojcode;
	    

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public TsTable() {
	}

	/** minimal constructor */
	public TsTable( Long itableid) {
		super();
		this.itableid = itableid;        
        }

	/** full constructor */
	public TsTable( Long itableid, String stabname, String stabcname, java.sql.Timestamp tsstartdate, String susercode, java.sql.Timestamp tssysupdate, String sprojcode) {
		super();
		this.itableid = itableid;
		this.stabname = stabname;
		this.stabcname = stabcname;
		this.tsstartdate = tsstartdate;
		this.susercode = susercode;
		this.tssysupdate = tssysupdate;
		this.sprojcode = sprojcode;
	}
	
    // Property accessors
       /** 标准的annotation方式的主键生成策略如下 
       * AUTO - 可以是identity column类型,或者sequence类型或者table类型,取决于不同的底层数据库 
       * TABLE - 使用表保存id值（也就是会为应用的表创建一张专门保存Id的表，记录对应的表的对应最大的ID值 
       * IDENTITY - 自增 
       * SEQUENCE – sequence  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE") 
       **/
	
	/** 表编号  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19 */
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "I_TABLEID",  nullable = false,  length = 19)
   	public Long getItableid() {
		return this.itableid;
	}

	/** 表编号 , bigint  ,  PK ,   NOT NULL  , Length: 19   */
	public void setItableid(Long itableid) {
		this.itableid = itableid;
	}
	
	/** 表名称  , varchar  ,     Length: 42 */
    @Column(name = "S_TABNAME",  nullable = true,  length = 42)
   	public String getStabname() {
		return this.stabname;
	}

	/** 表名称 , varchar  ,    Length: 42   */
	public void setStabname(String stabname) {
		this.stabname = stabname;
	}
	
	/** 表中文名称  , varchar  ,     Length: 42 */
    @Column(name = "S_TABCNAME",  nullable = true,  length = 42)
   	public String getStabcname() {
		return this.stabcname;
	}

	/** 表中文名称 , varchar  ,    Length: 42   */
	public void setStabcname(String stabcname) {
		this.stabcname = stabcname;
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
	
	/** 用户代码  , char  ,     Length: 36 */
    @Column(name = "S_USERCODE",  nullable = true,  length = 36)
   	public String getSusercode() {
		return this.susercode;
	}

	/** 用户代码 , char  ,    Length: 36   */
	public void setSusercode(String susercode) {
		this.susercode = susercode;
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
	
	/** 项目代码  , varchar  ,     Length: 36 */
    @Column(name = "S_PROJCODE",  nullable = true,  length = 36)
   	public String getSprojcode() {
		return this.sprojcode;
	}

	/** 项目代码 , varchar  ,    Length: 36   */
	public void setSprojcode(String sprojcode) {
		this.sprojcode = sprojcode;
	}

	public String toString() {
		return  "表编号 itableid="+itableid+" , "+  "表名称 stabname="+stabname+" , "+  "表中文名称 stabcname="+stabcname+" , "+  "开始时间 tsstartdate="+tsstartdate+" , "+  "用户代码 susercode="+susercode+" , "+  "系统更新时间 tssysupdate="+tssysupdate+" , "+  "项目代码 sprojcode="+sprojcode;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    TsTable model = new TsTable();
	    		  model.setItableid(this.itableid);
				  model.setStabname(this.stabname);
				  model.setStabcname(this.stabcname);
				  model.setTsstartdate(this.tsstartdate);
				  model.setSusercode(this.susercode);
				  model.setTssysupdate(this.tssysupdate);
				  model.setSprojcode(this.sprojcode);
				return model;
	}

	public void close() throws IOException {
	}
}