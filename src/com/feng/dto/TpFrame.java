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
 * table name: tp_frame
 * table remark: 框架信息; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.476
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 */
@Entity
@Table(name = "tp_frame")
public class TpFrame implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//////////////////////////// Fields 1/////////////////////////////////////////
	
	  /** 框架代码  , int  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 10   */
	    protected Integer  iframecode;
	    
	  /** 框架名称  , varchar  ,     Length: 42   */
	    protected String  sframename;
	    
	  /** 描述  , varchar  ,     Length: 170   */
	    protected String  sdesc;
	    
	  /** 基础包名  , varchar  ,     Length: 21   */
	    protected String  sbasepackage;
	    
	  /** action包名  , varchar  ,     Length: 42   */
	    protected String  sactionpackage;
	    
	  /** service包名  , varchar  ,     Length: 42   */
	    protected String  sservicepackage;
	    
	  /** xml包名  , varchar  ,     Length: 42   */
	    protected String  sxmlpackage;
	    
	  /** model包名  , varchar  ,     Length: 42   */
	    protected String  smodelpackage;
	    
	  /** model后缀名  , varchar  ,     Length: 5   */
	    protected String  smodelpriex;
	    
	  /** 开始时间  , timestamp  ,     Length: 30  Default:CURRENT_TIMESTAMP */
	    protected java.sql.Timestamp  tsstartdate;
	    
	  /** 用户代码  , char  ,     Length: 36   */
	    protected String  susercode;
	    
	  /** 系统更新时间  , timestamp  ,     Length: 30  Default:0000-00-00 00:00:00 */
	    protected java.sql.Timestamp  tssysupdate;
	    

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public TpFrame() {
	}

	/** minimal constructor */
	public TpFrame( Integer iframecode) {
		super();
		this.iframecode = iframecode;        
        }

	/** full constructor */
	public TpFrame( Integer iframecode, String sframename, String sdesc, String sbasepackage, String sactionpackage, String sservicepackage, String sxmlpackage, String smodelpackage, String smodelpriex, java.sql.Timestamp tsstartdate, String susercode, java.sql.Timestamp tssysupdate) {
		super();
		this.iframecode = iframecode;
		this.sframename = sframename;
		this.sdesc = sdesc;
		this.sbasepackage = sbasepackage;
		this.sactionpackage = sactionpackage;
		this.sservicepackage = sservicepackage;
		this.sxmlpackage = sxmlpackage;
		this.smodelpackage = smodelpackage;
		this.smodelpriex = smodelpriex;
		this.tsstartdate = tsstartdate;
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
	
	/** 框架代码  , int  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 10 */
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "I_FRAMECODE",  nullable = false,  length = 10)
   	public Integer getIframecode() {
		return this.iframecode;
	}

	/** 框架代码 , int  ,  PK ,   NOT NULL  , Length: 10   */
	public void setIframecode(Integer iframecode) {
		this.iframecode = iframecode;
	}
	
	/** 框架名称  , varchar  ,     Length: 42 */
    @Column(name = "S_FRAMENAME",  nullable = true,  length = 42)
   	public String getSframename() {
		return this.sframename;
	}

	/** 框架名称 , varchar  ,    Length: 42   */
	public void setSframename(String sframename) {
		this.sframename = sframename;
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
	
	/** 基础包名  , varchar  ,     Length: 21 */
    @Column(name = "S_BASEPACKAGE",  nullable = true,  length = 21)
   	public String getSbasepackage() {
		return this.sbasepackage;
	}

	/** 基础包名 , varchar  ,    Length: 21   */
	public void setSbasepackage(String sbasepackage) {
		this.sbasepackage = sbasepackage;
	}
	
	/** action包名  , varchar  ,     Length: 42 */
    @Column(name = "S_ACTIONPACKAGE",  nullable = true,  length = 42)
   	public String getSactionpackage() {
		return this.sactionpackage;
	}

	/** action包名 , varchar  ,    Length: 42   */
	public void setSactionpackage(String sactionpackage) {
		this.sactionpackage = sactionpackage;
	}
	
	/** service包名  , varchar  ,     Length: 42 */
    @Column(name = "S_SERVICEPACKAGE",  nullable = true,  length = 42)
   	public String getSservicepackage() {
		return this.sservicepackage;
	}

	/** service包名 , varchar  ,    Length: 42   */
	public void setSservicepackage(String sservicepackage) {
		this.sservicepackage = sservicepackage;
	}
	
	/** xml包名  , varchar  ,     Length: 42 */
    @Column(name = "S_XMLPACKAGE",  nullable = true,  length = 42)
   	public String getSxmlpackage() {
		return this.sxmlpackage;
	}

	/** xml包名 , varchar  ,    Length: 42   */
	public void setSxmlpackage(String sxmlpackage) {
		this.sxmlpackage = sxmlpackage;
	}
	
	/** model包名  , varchar  ,     Length: 42 */
    @Column(name = "S_MODELPACKAGE",  nullable = true,  length = 42)
   	public String getSmodelpackage() {
		return this.smodelpackage;
	}

	/** model包名 , varchar  ,    Length: 42   */
	public void setSmodelpackage(String smodelpackage) {
		this.smodelpackage = smodelpackage;
	}
	
	/** model后缀名  , varchar  ,     Length: 5 */
    @Column(name = "S_MODELPRIEX",  nullable = true,  length = 5)
   	public String getSmodelpriex() {
		return this.smodelpriex;
	}

	/** model后缀名 , varchar  ,    Length: 5   */
	public void setSmodelpriex(String smodelpriex) {
		this.smodelpriex = smodelpriex;
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
    @Column(name = "TS_SYSUPDATE",  nullable = true,  length =30)
   	public java.sql.Timestamp getTssysupdate() {
		return this.tssysupdate;
	}

	/** 系统更新时间 , timestamp  ,    Length: 30   */
	public void setTssysupdate(java.sql.Timestamp tssysupdate) {
		this.tssysupdate = tssysupdate;
	}

	public String toString() {
		return  "框架代码 iframecode="+iframecode+" , "+  "框架名称 sframename="+sframename+" , "+  "描述 sdesc="+sdesc+" , "+  "基础包名 sbasepackage="+sbasepackage+" , "+  "action包名 sactionpackage="+sactionpackage+" , "+  "service包名 sservicepackage="+sservicepackage+" , "+  "xml包名 sxmlpackage="+sxmlpackage+" , "+  "model包名 smodelpackage="+smodelpackage+" , "+  "model后缀名 smodelpriex="+smodelpriex+" , "+  "开始时间 tsstartdate="+tsstartdate+" , "+  "用户代码 susercode="+susercode+" , "+  "系统更新时间 tssysupdate="+tssysupdate;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    TpFrame model = new TpFrame();
	    		  model.setIframecode(this.iframecode);
				  model.setSframename(this.sframename);
				  model.setSdesc(this.sdesc);
				  model.setSbasepackage(this.sbasepackage);
				  model.setSactionpackage(this.sactionpackage);
				  model.setSservicepackage(this.sservicepackage);
				  model.setSxmlpackage(this.sxmlpackage);
				  model.setSmodelpackage(this.smodelpackage);
				  model.setSmodelpriex(this.smodelpriex);
				  model.setTsstartdate(this.tsstartdate);
				  model.setSusercode(this.susercode);
				  model.setTssysupdate(this.tssysupdate);
				return model;
	}

	public void close() throws IOException {
	}
}