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
 * table name: tp_users
 * table remark: 用户表; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.522
 */
@Entity
@Table(name = "tp_users")
public class TpUsers implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//////////////////////////// Fields 1/////////////////////////////////////////
	
	  /** 用户代码  , char  ,  PK ,   NOT NULL  ,   Length: 36   */
	    protected String  susercode;
	    
	  /** 用户名  , varchar  ,     Length: 21   */
	    protected String  susername;
	    
	  /** 用户密码  , varchar  ,     Length: 85   */
	    protected String  suserpwd;
	    
	  /** 上次登录时间  , timestamp  ,     Length: 20  Default:CURRENT_TIMESTAMP */
	    protected java.sql.Timestamp  tslastlogin;
	    
	  /** 用户状态
            0-锁定
            1-正常
            
              , char  ,     Length: 1   */
	    protected String  suserstate;
	    
	  /** 项目生成路径  , varchar  ,     Length: 170   */
	    protected String  sprojgenpath;
	    
	  /** Email是否已校验
            1-已校验通过
            2-校验失败
            0-未校验
              , char  ,     Length: 1   */
	    protected String  semailvalflag;
	    
	  /** Email  , varchar  ,     Length: 30   */
	    protected String  semail;
	    
	  /** 出生日期  , date  ,     Length: 20   */
	    protected java.sql.Date  dbirthday;
	    
	  /** 性别
            1-男
            2-女  , char  ,     Length: 1   */
	    protected String  ssex;
	    
	  /** 注册时间  , timestamp  ,     Length: 30  Default:0000-00-00 00:00:00 */
	    protected java.sql.Timestamp  tsregdatetime;
	    
	  /**   , char  ,     Length: 36   */
	    protected String  sregusercode;
	    
	  /** 注册IP  , varchar  ,     Length: 36   */
	    protected String  sregip;
	    
	  /** 上次登陆IP  , varchar  ,     Length: 36   */
	    protected String  slastloginip;
	    
	  /** 是否管理员
            1-是
            0-否  , char  ,     Length: 1   */
	    protected String  sadminflag;
	    
	  /** 系统更新时间  , timestamp  ,     Length: 30  Default:0000-00-00 00:00:00 */
	    protected java.sql.Timestamp  tssysupdate;
	    

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public TpUsers() {
	}

	/** minimal constructor */
	public TpUsers( String susercode) {
		super();
		this.susercode = susercode;        
        }

	/** full constructor */
	public TpUsers( String susercode, String susername, String suserpwd, java.sql.Timestamp tslastlogin, String suserstate, String sprojgenpath, String semailvalflag, String semail, java.sql.Date dbirthday, String ssex, java.sql.Timestamp tsregdatetime, String sregusercode, String sregip, String slastloginip, String sadminflag, java.sql.Timestamp tssysupdate) {
		super();
		this.susercode = susercode;
		this.susername = susername;
		this.suserpwd = suserpwd;
		this.tslastlogin = tslastlogin;
		this.suserstate = suserstate;
		this.sprojgenpath = sprojgenpath;
		this.semailvalflag = semailvalflag;
		this.semail = semail;
		this.dbirthday = dbirthday;
		this.ssex = ssex;
		this.tsregdatetime = tsregdatetime;
		this.sregusercode = sregusercode;
		this.sregip = sregip;
		this.slastloginip = slastloginip;
		this.sadminflag = sadminflag;
		this.tssysupdate = tssysupdate;
	}
	
    // Property accessors
       /** 标准的annotation方式的主键生成策略如下 
       * AUTO - 可以是identity column类型,或者sequence类型或者table类型,取决于不同的底层数据库 
       * TABLE - 使用表保存id值（也就是会为应用的表创建一张专门保存Id的表，记录对应的表的对应最大的ID值 
       * IDENTITY - 自增 
       * SEQUENCE – sequence  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE") 
       **/
	
	/** 用户代码  , char  ,  PK ,   NOT NULL  ,   Length: 36 */
    @Id 
    @Column(name = "S_USERCODE", unique = true, nullable = false,  length = 36)
   	public String getSusercode() {
		return this.susercode;
	}

	/** 用户代码 , char  ,  PK ,   NOT NULL  , Length: 36   */
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
	
	/** 用户密码  , varchar  ,     Length: 85 */
    @Column(name = "S_USERPWD",  nullable = true,  length = 85)
   	public String getSuserpwd() {
		return this.suserpwd;
	}

	/** 用户密码 , varchar  ,    Length: 85   */
	public void setSuserpwd(String suserpwd) {
		this.suserpwd = suserpwd;
	}
	
	/** 上次登录时间  , timestamp  ,     Length: 20 */
    @Column(name = "TS_LASTLOGIN",  nullable = true,  length = 20)
   	public java.sql.Timestamp getTslastlogin() {
		return this.tslastlogin;
	}

	/** 上次登录时间 , timestamp  ,    Length: 20   */
	public void setTslastlogin(java.sql.Timestamp tslastlogin) {
		this.tslastlogin = tslastlogin;
	}
	
	/** 用户状态
            0-锁定
            1-正常
            
              , char  ,     Length: 1 */
    @Column(name = "S_USERSTATE",  nullable = true,  length = 1)
   	public String getSuserstate() {
		return this.suserstate;
	}

	/** 用户状态
            0-锁定
            1-正常
            
             , char  ,    Length: 1   */
	public void setSuserstate(String suserstate) {
		this.suserstate = suserstate;
	}
	
	/** 项目生成路径  , varchar  ,     Length: 170 */
    @Column(name = "S_PROJGENPATH",  nullable = true,  length = 170)
   	public String getSprojgenpath() {
		return this.sprojgenpath;
	}

	/** 项目生成路径 , varchar  ,    Length: 170   */
	public void setSprojgenpath(String sprojgenpath) {
		this.sprojgenpath = sprojgenpath;
	}
	
	/** Email是否已校验
            1-已校验通过
            2-校验失败
            0-未校验
              , char  ,     Length: 1 */
    @Column(name = "S_EMAILVALFLAG",  nullable = true,  length = 1)
   	public String getSemailvalflag() {
		return this.semailvalflag;
	}

	/** Email是否已校验
            1-已校验通过
            2-校验失败
            0-未校验
             , char  ,    Length: 0   */
	public void setSemailvalflag(String semailvalflag) {
		this.semailvalflag = semailvalflag;
	}
	
	/** Email  , varchar  ,     Length: 30 */
    @Column(name = "S_EMAIL",  nullable = true,  length = 30)
   	public String getSemail() {
		return this.semail;
	}

	/** Email , varchar  ,    Length: 30   */
	public void setSemail(String semail) {
		this.semail = semail;
	}
	
	/** 出生日期  , date  ,     Length: 20 */
    @Column(name = "D_BIRTHDAY",  nullable = true,  length = 20)
   	public java.sql.Date getDbirthday() {
		return this.dbirthday;
	}

	/** 出生日期 , date  ,    Length: 20   */
	public void setDbirthday(java.sql.Date dbirthday) {
		this.dbirthday = dbirthday;
	}
	
	/** 性别
            1-男
            2-女  , char  ,     Length: 1 */
    @Column(name = "S_SEX",  nullable = true,  length = 1)
   	public String getSsex() {
		return this.ssex;
	}

	/** 性别
            1-男
            2-女 , char  ,    Length: 1   */
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	
	/** 注册时间  , timestamp  ,     Length: 30 */
    @Column(name = "TS_REGDATETIME",  nullable = true,  length = 30)
   	public java.sql.Timestamp getTsregdatetime() {
		return this.tsregdatetime;
	}

	/** 注册时间 , timestamp  ,    Length: 30   */
	public void setTsregdatetime(java.sql.Timestamp tsregdatetime) {
		this.tsregdatetime = tsregdatetime;
	}
	
	/**   , char  ,     Length: 36 */
    @Column(name = "S_REGUSERCODE",  nullable = true,  length = 36)
   	public String getSregusercode() {
		return this.sregusercode;
	}

	/**  , char  ,    Length: 36   */
	public void setSregusercode(String sregusercode) {
		this.sregusercode = sregusercode;
	}
	
	/** 注册IP  , varchar  ,     Length: 36 */
    @Column(name = "S_REGIP",  nullable = true,  length = 36)
   	public String getSregip() {
		return this.sregip;
	}

	/** 注册IP , varchar  ,    Length: 36   */
	public void setSregip(String sregip) {
		this.sregip = sregip;
	}
	
	/** 上次登陆IP  , varchar  ,     Length: 36 */
    @Column(name = "S_LASTLOGINIP",  nullable = true,  length = 36)
   	public String getSlastloginip() {
		return this.slastloginip;
	}

	/** 上次登陆IP , varchar  ,    Length: 36   */
	public void setSlastloginip(String slastloginip) {
		this.slastloginip = slastloginip;
	}
	
	/** 是否管理员
            1-是
            0-否  , char  ,     Length: 1 */
    @Column(name = "S_ADMINFLAG",  nullable = true,  length = 1)
   	public String getSadminflag() {
		return this.sadminflag;
	}

	/** 是否管理员
            1-是
            0-否 , char  ,    Length: 1   */
	public void setSadminflag(String sadminflag) {
		this.sadminflag = sadminflag;
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
		return  "用户代码 susercode="+susercode+" , "+  "用户名 susername="+susername+" , "+  "用户密码 suserpwd="+suserpwd+" , "+  "上次登录时间 tslastlogin="+tslastlogin+" , "+  "用户状态            0-锁定            1-正常 suserstate="+suserstate+" , "+  "项目生成路径 sprojgenpath="+sprojgenpath+" , "+  "Email是否已校验            1-已校验通过            2-校验失败            0-未校验 semailvalflag="+semailvalflag+" , "+  "Email semail="+semail+" , "+  "出生日期 dbirthday="+dbirthday+" , "+  "性别            1-男            2-女 ssex="+ssex+" , "+  "注册时间 tsregdatetime="+tsregdatetime+" , "+  " sregusercode="+sregusercode+" , "+  "注册IP sregip="+sregip+" , "+  "上次登陆IP slastloginip="+slastloginip+" , "+  "是否管理员            1-是            0-否 sadminflag="+sadminflag+" , "+  "系统更新时间 tssysupdate="+tssysupdate;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    TpUsers model = new TpUsers();
	    		  model.setSusercode(this.susercode);
				  model.setSusername(this.susername);
				  model.setSuserpwd(this.suserpwd);
				  model.setTslastlogin(this.tslastlogin);
				  model.setSuserstate(this.suserstate);
				  model.setSprojgenpath(this.sprojgenpath);
				  model.setSemailvalflag(this.semailvalflag);
				  model.setSemail(this.semail);
				  model.setDbirthday(this.dbirthday);
				  model.setSsex(this.ssex);
				  model.setTsregdatetime(this.tsregdatetime);
				  model.setSregusercode(this.sregusercode);
				  model.setSregip(this.sregip);
				  model.setSlastloginip(this.slastloginip);
				  model.setSadminflag(this.sadminflag);
				  model.setTssysupdate(this.tssysupdate);
				return model;
	}

	public void close() throws IOException {
	}
}