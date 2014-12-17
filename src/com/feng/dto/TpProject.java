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
 * table name: tp_project
 * table remark: 项目信息; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.507
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 */
@Entity
@Table(name = "tp_project")
public class TpProject implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//////////////////////////// Fields 1/////////////////////////////////////////
	
	  /** 项目代码  , varchar  ,  PK ,   NOT NULL  ,   Length: 36   */
	    protected String  sprojcode;
	    
	  /** 项目名称  , varchar  ,     Length: 21   */
	    protected String  sprojname;
	    
	  /** 项目中文名称  , varchar  ,     Length: 42   */
	    protected String  sprojchename;
	    
	  /** 描述  , varchar  ,     Length: 170   */
	    protected String  sdesc;
	    
	  /** 开始时间  , timestamp  ,     Length: 30  Default:CURRENT_TIMESTAMP */
	    protected java.sql.Timestamp  tsadddate;
	    
	  /** 数据库  , varchar  ,     Length: 36   */
	    protected String  sdbtype;
	    
	  /** 数据库密码  , varchar  ,     Length: 21   */
	    protected String  sdbpwd;
	    
	  /** 数据库用户名  , varchar  ,     Length: 21   */
	    protected String  sdbname;
	    
	  /** 数据库jdbc  , varchar  ,     Length: 170   */
	    protected String  sdburl;
	    
	  /** 数据库schema  , varchar  ,     Length: 36   */
	    protected String  sdbschema;
	    
	  /** 用户代码  , char  ,     Length: 36   */
	    protected String  susercode;
	    
	  /** 框架代码  , int  ,     Length: 10   */
	    protected Integer  iframecode;
	    
	  /** 系统更新时间  , timestamp  ,     Length: 30  Default:0000-00-00 00:00:00 */
	    protected java.sql.Timestamp  tssysupdate;
	    

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public TpProject() {
	}

	/** minimal constructor */
	public TpProject( String sprojcode) {
		super();
		this.sprojcode = sprojcode;        
        }

	/** full constructor */
	public TpProject( String sprojcode, String sprojname, String sprojchename, String sdesc, java.sql.Timestamp tsadddate, String sdbtype, String sdbpwd, String sdbname, String sdburl, String sdbschema, String susercode, Integer iframecode, java.sql.Timestamp tssysupdate) {
		super();
		this.sprojcode = sprojcode;
		this.sprojname = sprojname;
		this.sprojchename = sprojchename;
		this.sdesc = sdesc;
		this.tsadddate = tsadddate;
		this.sdbtype = sdbtype;
		this.sdbpwd = sdbpwd;
		this.sdbname = sdbname;
		this.sdburl = sdburl;
		this.sdbschema = sdbschema;
		this.susercode = susercode;
		this.iframecode = iframecode;
		this.tssysupdate = tssysupdate;
	}
	
    // Property accessors
       /** 标准的annotation方式的主键生成策略如下 
       * AUTO - 可以是identity column类型,或者sequence类型或者table类型,取决于不同的底层数据库 
       * TABLE - 使用表保存id值（也就是会为应用的表创建一张专门保存Id的表，记录对应的表的对应最大的ID值 
       * IDENTITY - 自增 
       * SEQUENCE – sequence  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE") 
       **/
	
	/** 项目代码  , varchar  ,  PK ,   NOT NULL  ,   Length: 36 */
    @Id 
    @Column(name = "S_PROJCODE", unique = true, nullable = false,  length = 36)
   	public String getSprojcode() {
		return this.sprojcode;
	}

	/** 项目代码 , varchar  ,  PK ,   NOT NULL  , Length: 36   */
	public void setSprojcode(String sprojcode) {
		this.sprojcode = sprojcode;
	}
	
	/** 项目名称  , varchar  ,     Length: 21 */
    @Column(name = "S_PROJNAME",  nullable = true,  length = 21)
   	public String getSprojname() {
		return this.sprojname;
	}

	/** 项目名称 , varchar  ,    Length: 21   */
	public void setSprojname(String sprojname) {
		this.sprojname = sprojname;
	}
	
	/** 项目中文名称  , varchar  ,     Length: 42 */
    @Column(name = "S_PROJCHENAME",  nullable = true,  length = 42)
   	public String getSprojchename() {
		return this.sprojchename;
	}

	/** 项目中文名称 , varchar  ,    Length: 42   */
	public void setSprojchename(String sprojchename) {
		this.sprojchename = sprojchename;
	}
	
	/** 描述  , varchar  ,     Length: 170 */
    @Column(name = "S_DESC",  nullable = true,  length = 170)
   	public String getSdesc() {
		return this.sdesc;
	}

	/** 描述 , varchar  ,    Length: 170   */
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	
	/** 开始时间  , timestamp  ,     Length: 30 */
    @Column(name = "TS_ADDDATE",  nullable = true,  length = 30)
   	public java.sql.Timestamp getTsadddate() {
		return this.tsadddate;
	}

	/** 开始时间 , timestamp  ,    Length: 30   */
	public void setTsadddate(java.sql.Timestamp tsadddate) {
		this.tsadddate = tsadddate;
	}
	
	/** 数据库  , varchar  ,     Length: 36 */
    @Column(name = "S_DBTYPE",  nullable = true,  length = 36)
   	public String getSdbtype() {
		return this.sdbtype;
	}

	/** 数据库 , varchar  ,    Length: 36   */
	public void setSdbtype(String sdbtype) {
		this.sdbtype = sdbtype;
	}
	
	/** 数据库密码  , varchar  ,     Length: 21 */
    @Column(name = "S_DBPWD",  nullable = true,  length = 21)
   	public String getSdbpwd() {
		return this.sdbpwd;
	}

	/** 数据库密码 , varchar  ,    Length: 21   */
	public void setSdbpwd(String sdbpwd) {
		this.sdbpwd = sdbpwd;
	}
	
	/** 数据库用户名  , varchar  ,     Length: 21 */
    @Column(name = "S_DBNAME",  nullable = true,  length = 21)
   	public String getSdbname() {
		return this.sdbname;
	}

	/** 数据库用户名 , varchar  ,    Length: 21   */
	public void setSdbname(String sdbname) {
		this.sdbname = sdbname;
	}
	
	/** 数据库jdbc  , varchar  ,     Length: 170 */
    @Column(name = "S_DBURL",  nullable = true,  length = 170)
   	public String getSdburl() {
		return this.sdburl;
	}

	/** 数据库jdbc , varchar  ,    Length: 170   */
	public void setSdburl(String sdburl) {
		this.sdburl = sdburl;
	}
	
	/** 数据库schema  , varchar  ,     Length: 36 */
    @Column(name = "S_DBSCHEMA",  nullable = true,  length = 36)
   	public String getSdbschema() {
		return this.sdbschema;
	}

	/** 数据库schema , varchar  ,    Length: 36   */
	public void setSdbschema(String sdbschema) {
		this.sdbschema = sdbschema;
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
	
	/** 框架代码  , int  ,     Length: 10 */
    @Column(name = "I_FRAMECODE",  nullable = true,  length = 10)
   	public Integer getIframecode() {
		return this.iframecode;
	}

	/** 框架代码 , int  ,    Length: 10   */
	public void setIframecode(Integer iframecode) {
		this.iframecode = iframecode;
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

	public String toString() {
		return  "项目代码 sprojcode="+sprojcode+" , "+  "项目名称 sprojname="+sprojname+" , "+  "项目中文名称 sprojchename="+sprojchename+" , "+  "描述 sdesc="+sdesc+" , "+  "开始时间 tsadddate="+tsadddate+" , "+  "数据库 sdbtype="+sdbtype+" , "+  "数据库密码 sdbpwd="+sdbpwd+" , "+  "数据库用户名 sdbname="+sdbname+" , "+  "数据库jdbc sdburl="+sdburl+" , "+  "数据库schema sdbschema="+sdbschema+" , "+  "用户代码 susercode="+susercode+" , "+  "框架代码 iframecode="+iframecode+" , "+  "系统更新时间 tssysupdate="+tssysupdate;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    TpProject model = new TpProject();
	    		  model.setSprojcode(this.sprojcode);
				  model.setSprojname(this.sprojname);
				  model.setSprojchename(this.sprojchename);
				  model.setSdesc(this.sdesc);
				  model.setTsadddate(this.tsadddate);
				  model.setSdbtype(this.sdbtype);
				  model.setSdbpwd(this.sdbpwd);
				  model.setSdbname(this.sdbname);
				  model.setSdburl(this.sdburl);
				  model.setSdbschema(this.sdbschema);
				  model.setSusercode(this.susercode);
				  model.setIframecode(this.iframecode);
				  model.setTssysupdate(this.tssysupdate);
				return model;
	}

	public void close() throws IOException {
	}
}