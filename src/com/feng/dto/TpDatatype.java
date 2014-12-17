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
 * table name: tp_datatype
 * table remark: 枚举值类型; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.444
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 */
@Entity
@Table(name = "tp_datatype")
public class TpDatatype implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//////////////////////////// Fields 1/////////////////////////////////////////
	
	  /** 枚举值编号  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19   */
	    protected Long  ienumclass;
	    
	  /** 枚举值名称  , varchar  ,     Length: 42   */
	    protected String  senumclassname;
	    
	  /** 枚举值备注  , varchar  ,     Length: 170   */
	    protected String  senumremark;
	    
	  /** 开始时间  , timestamp  ,     Length: 30  Default:CURRENT_TIMESTAMP */
	    protected java.sql.Timestamp  tsstartdate;
	    
	  /** 用户代码  , char  ,     Length: 36   */
	    protected String  susercode;
	    
	  /** 用户名  , varchar  ,     Length: 21   */
	    protected String  susername;
	    
	  /** 项目代码  , varchar  ,     Length: 36   */
	    protected String  sprojcode;
	    
	  /** 系统更新时间  , timestamp  ,     Length: 30  Default:0000-00-00 00:00:00 */
	    protected java.sql.Timestamp  tssysupdate;
	    

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public TpDatatype() {
	}

	/** minimal constructor */
	public TpDatatype( Long ienumclass) {
		super();
		this.ienumclass = ienumclass;        
        }

	/** full constructor */
	public TpDatatype( Long ienumclass, String senumclassname, String senumremark, java.sql.Timestamp tsstartdate, String susercode, String susername, String sprojcode, java.sql.Timestamp tssysupdate) {
		super();
		this.ienumclass = ienumclass;
		this.senumclassname = senumclassname;
		this.senumremark = senumremark;
		this.tsstartdate = tsstartdate;
		this.susercode = susercode;
		this.susername = susername;
		this.sprojcode = sprojcode;
		this.tssysupdate = tssysupdate;
	}
	
    // Property accessors
       /** 标准的annotation方式的主键生成策略如下 
       * AUTO - 可以是identity column类型,或者sequence类型或者table类型,取决于不同的底层数据库 
       * TABLE - 使用表保存id值（也就是会为应用的表创建一张专门保存Id的表，记录对应的表的对应最大的ID值 
       * IDENTITY - 自增 
       * SEQUENCE – sequence  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE") 
       **/
	
	/** 枚举值编号  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19 */
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "I_ENUMCLASS",  nullable = false,  length = 19)
   	public Long getIenumclass() {
		return this.ienumclass;
	}

	/** 枚举值编号 , bigint  ,  PK ,   NOT NULL  , Length: 19   */
	public void setIenumclass(Long ienumclass) {
		this.ienumclass = ienumclass;
	}
	
	/** 枚举值名称  , varchar  ,     Length: 42 */
    @Column(name = "S_ENUMCLASSNAME",  nullable = true,  length = 42)
   	public String getSenumclassname() {
		return this.senumclassname;
	}

	/** 枚举值名称 , varchar  ,    Length: 42   */
	public void setSenumclassname(String senumclassname) {
		this.senumclassname = senumclassname;
	}
	
	/** 枚举值备注  , varchar  ,     Length: 170 */
    @Column(name = "S_ENUMREMARK",  nullable = true,  length = 170)
   	public String getSenumremark() {
		return this.senumremark;
	}

	/** 枚举值备注 , varchar  ,    Length: 170   */
	public void setSenumremark(String senumremark) {
		this.senumremark = senumremark;
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
	
	/** 用户名  , varchar  ,     Length: 21 */
    @Column(name = "S_USERNAME",  nullable = true,  length = 21)
   	public String getSusername() {
		return this.susername;
	}

	/** 用户名 , varchar  ,    Length: 21   */
	public void setSusername(String susername) {
		this.susername = susername;
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
		return  "枚举值编号 ienumclass="+ienumclass+" , "+  "枚举值名称 senumclassname="+senumclassname+" , "+  "枚举值备注 senumremark="+senumremark+" , "+  "开始时间 tsstartdate="+tsstartdate+" , "+  "用户代码 susercode="+susercode+" , "+  "用户名 susername="+susername+" , "+  "项目代码 sprojcode="+sprojcode+" , "+  "系统更新时间 tssysupdate="+tssysupdate;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    TpDatatype model = new TpDatatype();
	    		  model.setIenumclass(this.ienumclass);
				  model.setSenumclassname(this.senumclassname);
				  model.setSenumremark(this.senumremark);
				  model.setTsstartdate(this.tsstartdate);
				  model.setSusercode(this.susercode);
				  model.setSusername(this.susername);
				  model.setSprojcode(this.sprojcode);
				  model.setTssysupdate(this.tssysupdate);
				return model;
	}

	public void close() throws IOException {
	}
}