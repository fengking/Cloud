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
 * table name: ts_column
 * table remark: 列信息; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.538
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 */
@Entity
@Table(name = "ts_column")
public class TsColumn implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//////////////////////////// Fields 1/////////////////////////////////////////
	
	  /** 列编号  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19   */
	    protected Long  icolumnid;
	    
	  /** 列名  , varchar  ,     Length: 42   */
	    protected String  scolumnname;
	    
	  /** 列中文名  , varchar  ,     Length: 85   */
	    protected String  scolumncname;
	    
	  /** 是否主键
            0-否1-是  , char  ,     Length: 1   */
	    protected String  spks;
	    
	  /** 枚举值编号  , bigint  ,     Length: 19   */
	    protected Long  ienumclass;
	    
	  /** 所属范围  , char  ,     Length: 30   */
	    protected String  sscope;
	    
	  /** 必填
            0-不必填
            1-必填  , char  ,     Length: 1   */
	    protected String  sisnulls;
	    
	  /** 显示
            0-不显示
            1-显示  , char  ,     Length: 1   */
	    protected String  sdisplay;
	    
	  /** 类型  , varchar  ,     Length: 36   */
	    protected String  sjavatype;
	    
	  /** 表名称  , varchar  ,     Length: 42   */
	    protected String  stabname;
	    
	  /** 表编号  , bigint  ,     Length: 19   */
	    protected Long  itableid;
	    
	  /** 项目代码  , varchar  ,     Length: 36   */
	    protected String  sprojcode;
	    
	  /** 开始时间  , timestamp  ,     Length: 30  Default:CURRENT_TIMESTAMP */
	    protected java.sql.Timestamp  tsstartdate;
	    
	  /** 系统更新时间  , timestamp  ,     Length: 30  Default:0000-00-00 00:00:00 */
	    protected java.sql.Timestamp  tssysupdate;
	    

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public TsColumn() {
	}

	/** minimal constructor */
	public TsColumn( Long icolumnid) {
		super();
		this.icolumnid = icolumnid;        
        }

	/** full constructor */
	public TsColumn( Long icolumnid, String scolumnname, String scolumncname, String spks, Long ienumclass, String sscope, String sisnulls, String sdisplay, String sjavatype, String stabname, Long itableid, String sprojcode, java.sql.Timestamp tsstartdate, java.sql.Timestamp tssysupdate) {
		super();
		this.icolumnid = icolumnid;
		this.scolumnname = scolumnname;
		this.scolumncname = scolumncname;
		this.spks = spks;
		this.ienumclass = ienumclass;
		this.sscope = sscope;
		this.sisnulls = sisnulls;
		this.sdisplay = sdisplay;
		this.sjavatype = sjavatype;
		this.stabname = stabname;
		this.itableid = itableid;
		this.sprojcode = sprojcode;
		this.tsstartdate = tsstartdate;
		this.tssysupdate = tssysupdate;
	}
	
    // Property accessors
       /** 标准的annotation方式的主键生成策略如下 
       * AUTO - 可以是identity column类型,或者sequence类型或者table类型,取决于不同的底层数据库 
       * TABLE - 使用表保存id值（也就是会为应用的表创建一张专门保存Id的表，记录对应的表的对应最大的ID值 
       * IDENTITY - 自增 
       * SEQUENCE – sequence  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE") 
       **/
	
	/** 列编号  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19 */
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "I_COLUMNID",  nullable = false,  length = 19)
   	public Long getIcolumnid() {
		return this.icolumnid;
	}

	/** 列编号 , bigint  ,  PK ,   NOT NULL  , Length: 19   */
	public void setIcolumnid(Long icolumnid) {
		this.icolumnid = icolumnid;
	}
	
	/** 列名  , varchar  ,     Length: 42 */
    @Column(name = "S_COLUMNNAME",  nullable = true,  length = 42)
   	public String getScolumnname() {
		return this.scolumnname;
	}

	/** 列名 , varchar  ,    Length: 42   */
	public void setScolumnname(String scolumnname) {
		this.scolumnname = scolumnname;
	}
	
	/** 列中文名  , varchar  ,     Length: 85 */
    @Column(name = "S_COLUMNCNAME",  nullable = true,  length = 85)
   	public String getScolumncname() {
		return this.scolumncname;
	}

	/** 列中文名 , varchar  ,    Length: 85   */
	public void setScolumncname(String scolumncname) {
		this.scolumncname = scolumncname;
	}
	
	/** 是否主键
            0-否1-是  , char  ,     Length: 1 */
    @Column(name = "S_PKS",  nullable = true,  length = 1)
   	public String getSpks() {
		return this.spks;
	}

	/** 是否主键
            0-否1-是 , char  ,    Length: 1   */
	public void setSpks(String spks) {
		this.spks = spks;
	}
	
	/** 枚举值编号  , bigint  ,     Length: 19 */
    @Column(name = "I_ENUMCLASS",  nullable = true,  length = 19)
   	public Long getIenumclass() {
		return this.ienumclass;
	}

	/** 枚举值编号 , bigint  ,    Length: 19   */
	public void setIenumclass(Long ienumclass) {
		this.ienumclass = ienumclass;
	}
	
	/** 所属范围  , char  ,     Length: 30 */
    @Column(name = "S_SCOPE",  nullable = true,  length = 30)
   	public String getSscope() {
		return this.sscope;
	}

	/** 所属范围 , char  ,    Length: 30   */
	public void setSscope(String sscope) {
		this.sscope = sscope;
	}
	
	/** 必填
            0-不必填
            1-必填  , char  ,     Length: 1 */
    @Column(name = "S_ISNULLS",  nullable = true,  length = 1)
   	public String getSisnulls() {
		return this.sisnulls;
	}

	/** 必填
            0-不必填
            1-必填 , char  ,    Length: 1   */
	public void setSisnulls(String sisnulls) {
		this.sisnulls = sisnulls;
	}
	
	/** 显示
            0-不显示
            1-显示  , char  ,     Length: 1 */
    @Column(name = "S_DISPLAY",  nullable = true,  length = 1)
   	public String getSdisplay() {
		return this.sdisplay;
	}

	/** 显示
            0-不显示
            1-显示 , char  ,    Length: 1   */
	public void setSdisplay(String sdisplay) {
		this.sdisplay = sdisplay;
	}
	
	/** 类型  , varchar  ,     Length: 36 */
    @Column(name = "S_JAVATYPE",  nullable = true,  length = 36)
   	public String getSjavatype() {
		return this.sjavatype;
	}

	/** 类型 , varchar  ,    Length: 36   */
	public void setSjavatype(String sjavatype) {
		this.sjavatype = sjavatype;
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
	
	/** 表编号  , bigint  ,     Length: 19 */
    @Column(name = "I_TABLEID",  nullable = true,  length = 19)
   	public Long getItableid() {
		return this.itableid;
	}

	/** 表编号 , bigint  ,    Length: 19   */
	public void setItableid(Long itableid) {
		this.itableid = itableid;
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
	
	/** 开始时间  , timestamp  ,     Length: 30 */
    @Column(name = "TS_STARTDATE",  nullable = true,  length = 30)
   	public java.sql.Timestamp getTsstartdate() {
		return this.tsstartdate;
	}

	/** 开始时间 , timestamp  ,    Length: 30   */
	public void setTsstartdate(java.sql.Timestamp tsstartdate) {
		this.tsstartdate = tsstartdate;
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
		return  "列编号 icolumnid="+icolumnid+" , "+  "列名 scolumnname="+scolumnname+" , "+  "列中文名 scolumncname="+scolumncname+" , "+  "是否主键            0-否1-是 spks="+spks+" , "+  "枚举值编号 ienumclass="+ienumclass+" , "+  "所属范围 sscope="+sscope+" , "+  "必填            0-不必填            1-必填 sisnulls="+sisnulls+" , "+  "显示            0-不显示            1-显示 sdisplay="+sdisplay+" , "+  "类型 sjavatype="+sjavatype+" , "+  "表名称 stabname="+stabname+" , "+  "表编号 itableid="+itableid+" , "+  "项目代码 sprojcode="+sprojcode+" , "+  "开始时间 tsstartdate="+tsstartdate+" , "+  "系统更新时间 tssysupdate="+tssysupdate;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    TsColumn model = new TsColumn();
	    		  model.setIcolumnid(this.icolumnid);
				  model.setScolumnname(this.scolumnname);
				  model.setScolumncname(this.scolumncname);
				  model.setSpks(this.spks);
				  model.setIenumclass(this.ienumclass);
				  model.setSscope(this.sscope);
				  model.setSisnulls(this.sisnulls);
				  model.setSdisplay(this.sdisplay);
				  model.setSjavatype(this.sjavatype);
				  model.setStabname(this.stabname);
				  model.setItableid(this.itableid);
				  model.setSprojcode(this.sprojcode);
				  model.setTsstartdate(this.tsstartdate);
				  model.setTssysupdate(this.tssysupdate);
				return model;
	}

	public void close() throws IOException {
	}
}