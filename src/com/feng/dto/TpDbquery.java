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
 * table name: tp_dbquery
 * table remark: 查询数据表方式; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.46
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 */
@Entity
@Table(name = "tp_dbquery")
public class TpDbquery implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//////////////////////////// Fields 1/////////////////////////////////////////
	
	  /** 数据库  , varchar  ,  PK ,   NOT NULL  ,   Length: 36   */
	    protected String  sdbtype;
	    
	  /** 查询表信息  , varchar  ,     Length: 170   */
	    protected String  squerytabinfo;
	    
	  /** 查询表所在列信息  , varchar  ,     Length: 170   */
	    protected String  squerycolumn;
	    
	  /** 查询表主键  , varchar  ,     Length: 170   */
	    protected String  squerypk;
	    
	  /** jdbc类名  , varchar  ,     Length: 42   */
	    protected String  sjdbcclass;
	    
	  /** 数据库jdbc  , varchar  ,     Length: 170   */
	    protected String  sdburl;
	    
	  /** 数据库schema  , varchar  ,     Length: 36   */
	    protected String  sdbschema;
	    
	  /** 用户代码  , char  ,     Length: 36   */
	    protected String  susercode;
	    
	  /** 系统更新时间  , timestamp  ,     Length: 30  Default:CURRENT_TIMESTAMP */
	    protected java.sql.Timestamp  tssysupdate;
	    

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public TpDbquery() {
	}

	/** minimal constructor */
	public TpDbquery( String sdbtype) {
		super();
		this.sdbtype = sdbtype;        
        }

	/** full constructor */
	public TpDbquery( String sdbtype, String squerytabinfo, String squerycolumn, String squerypk, String sjdbcclass, String sdburl, String sdbschema, String susercode, java.sql.Timestamp tssysupdate) {
		super();
		this.sdbtype = sdbtype;
		this.squerytabinfo = squerytabinfo;
		this.squerycolumn = squerycolumn;
		this.squerypk = squerypk;
		this.sjdbcclass = sjdbcclass;
		this.sdburl = sdburl;
		this.sdbschema = sdbschema;
		this.susercode = susercode;
		this.tssysupdate = tssysupdate;
	}
	
    // Property accessors
       /** 标准的annotation方式的主键生成策略如下 
       * AUTO - 可以是identity column类型,或者sequence类型或者table类型,取决于不同的底层数据库 
       * TABLE - 使用表保存id值（也就是会为应用的表创建一张专门保存Id的表，记录对应的表的对应最大的ID值 
       * IDENTITY - 自增 
       * SEQUENCE – sequence  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE") 
       **/
	
	/** 数据库  , varchar  ,  PK ,   NOT NULL  ,   Length: 36 */
    @Id 
    @Column(name = "S_DBTYPE", unique = true, nullable = false,  length = 36)
   	public String getSdbtype() {
		return this.sdbtype;
	}

	/** 数据库 , varchar  ,  PK ,   NOT NULL  , Length: 36   */
	public void setSdbtype(String sdbtype) {
		this.sdbtype = sdbtype;
	}
	
	/** 查询表信息  , varchar  ,     Length: 170 */
    @Column(name = "S_QUERYTABINFO",  nullable = true,  length = 170)
   	public String getSquerytabinfo() {
		return this.squerytabinfo;
	}

	/** 查询表信息 , varchar  ,    Length: 170   */
	public void setSquerytabinfo(String squerytabinfo) {
		this.squerytabinfo = squerytabinfo;
	}
	
	/** 查询表所在列信息  , varchar  ,     Length: 170 */
    @Column(name = "S_QUERYCOLUMN",  nullable = true,  length = 170)
   	public String getSquerycolumn() {
		return this.squerycolumn;
	}

	/** 查询表所在列信息 , varchar  ,    Length: 170   */
	public void setSquerycolumn(String squerycolumn) {
		this.squerycolumn = squerycolumn;
	}
	
	/** 查询表主键  , varchar  ,     Length: 170 */
    @Column(name = "S_QUERYPK",  nullable = true,  length = 170)
   	public String getSquerypk() {
		return this.squerypk;
	}

	/** 查询表主键 , varchar  ,    Length: 170   */
	public void setSquerypk(String squerypk) {
		this.squerypk = squerypk;
	}
	
	/** jdbc类名  , varchar  ,     Length: 42 */
    @Column(name = "S_JDBCCLASS",  nullable = true,  length = 42)
   	public String getSjdbcclass() {
		return this.sjdbcclass;
	}

	/** jdbc类名 , varchar  ,    Length: 42   */
	public void setSjdbcclass(String sjdbcclass) {
		this.sjdbcclass = sjdbcclass;
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
		return  "数据库 sdbtype="+sdbtype+" , "+  "查询表信息 squerytabinfo="+squerytabinfo+" , "+  "查询表所在列信息 squerycolumn="+squerycolumn+" , "+  "查询表主键 squerypk="+squerypk+" , "+  "jdbc类名 sjdbcclass="+sjdbcclass+" , "+  "数据库jdbc sdburl="+sdburl+" , "+  "数据库schema sdbschema="+sdbschema+" , "+  "用户代码 susercode="+susercode+" , "+  "系统更新时间 tssysupdate="+tssysupdate;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    TpDbquery model = new TpDbquery();
	    		  model.setSdbtype(this.sdbtype);
				  model.setSquerytabinfo(this.squerytabinfo);
				  model.setSquerycolumn(this.squerycolumn);
				  model.setSquerypk(this.squerypk);
				  model.setSjdbcclass(this.sjdbcclass);
				  model.setSdburl(this.sdburl);
				  model.setSdbschema(this.sdbschema);
				  model.setSusercode(this.susercode);
				  model.setTssysupdate(this.tssysupdate);
				return model;
	}

	public void close() throws IOException {
	}
}