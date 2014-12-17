package com.feng.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
/**
 * table name: mt_Company
 * table remark: 公司[互联网版专用]表; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.179
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 */
@Entity
@Table(name = "mt_Company")
public class MTCompany implements java.io.Serializable,java.io.Closeable{

//////////////////////////// Fields 1/////////////////////////////////////////
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  /** 公司ID  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19   */
	    protected Long  FID;
	    
	  /** 公司名称  , char  ,     Length: 36   */
	    protected String  FName;
	    
	  /** 公司编码  , varchar  ,     Length: 21   */
	    protected String  FCode;
	    
	    /**
	     * 固定电话 , varchar  ,     Length: 20
	     */
	    protected String Tel;
	   
	    /**
	     * 公司网址, varchar  ,     Length: 60
	     */
	    protected String WebSite; 
	    
	    /**
	     * 公司地址, varchar  ,     Length: 100
	     */
	    protected String Address;
	    /**
	     * 管理员姓名,varchar  ,     Length: 10
	     */
	    protected String AdminName;
	    /**
	     * 管理员手机, varchar  ,     Length: 15
	     */
	    protected String AdminMobile;
	    /**
	     * 管理员Email, varchar  ,     Length: 30
	     */
	    protected String AdminEmail;
	    /**
	     * IM类型,
	     * 	1：QQ
            2：MSN
            3：飞信, char  ,     Length: 1
	     */
	    protected String AdminIMType;
	    /**
	     * IM号码, varchar  ,     Length: 20
	     */
	    protected String AdminIM;
	    /**
	     * 申请日期, timestamp  ,     Length: 30  Default:0000-00-00 00:00:00
	     */
	    protected java.sql.Timestamp ApplyDate;
	    /**
	     * 审核状态,(0待审,1开通,-1禁用), char  ,     Length: 1
	     */
	    protected String AuditState;
	    
	     

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public MTCompany() {
	}

	/** minimal constructor */
	public MTCompany( Long FID) {
		super();
		this.FID = FID;        
        }

	/** full constructor */
	public MTCompany( Long FID, String FName, String FCode,String Tel, String WebSite,String Address,String AdminName,String AdminMobile
			,String AdminEmail,String AdminIMType,String AdminIM, java.sql.Timestamp ApplyDate,String AuditState) {
		super();
		this.FID = FID;
		this.FName = FName;
		this.FCode = FCode;
		this.Tel=Tel;
		this.WebSite=WebSite;
		this.Address=Address;
		this.AdminName=AdminName;
		this.AdminMobile=AdminMobile;
		this.AdminEmail=AdminEmail;
		this.AdminIMType=AdminIMType;
		this.AdminIM=AdminIM;
		this.ApplyDate=ApplyDate;
		this.AuditState=AuditState; 
		 
	}
	
    // Property accessors
       /** 标准的annotation方式的主键生成策略如下 
       * AUTO - 可以是identity column类型,或者sequence类型或者table类型,取决于不同的底层数据库 
       * TABLE - 使用表保存id值（也就是会为应用的表创建一张专门保存Id的表，记录对应的表的对应最大的ID值 
       * IDENTITY - 自增 
       * SEQUENCE – sequence  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE") 
       **/
	
	/** 公司ID  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19 */
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "FID",  nullable = false,  length = 19)
   	public Long getFID() {
		return this.FID;
	}

	/** 公司ID , bigint  ,  PK ,   NOT NULL  , Length: 19   */
	public void setFID(Long FID) {
		this.FID = FID;
	}
	
	/** 公司名称  , char  ,     Length: 36 */
    @Column(name = "FName",  nullable = true,  length = 36)
   	public String getFName() {
		return this.FName;
	}

	/** 公司名称 , char  ,    Length: 36   */
	public void setFName(String FName) {
		this.FName = FName;
	}
	
	/** 公司编码  , varchar  ,     Length: 21 */
    @Column(name = "FCode",  nullable = true,  length = 21)
   	public String getFCode() {
		return this.FCode;
	}

	/** 公司编码 , varchar  ,    Length: 21   */
	public void setFCode(String FCode) {
		this.FCode = FCode;
	}
	
	/** 固定电话  , varchar  ,     Length: 20 */
    @Column(name = "Tel",  nullable = true,  length = 20)
   	public String getTel() {
		return this.Tel;
	}

	/** 固定电话 , varchar  ,    Length: 20   */
	public void setTel(String Tel) {
		this.Tel = Tel;
	}
	
	/** 固定电话  , varchar  ,     Length: 60 */
    @Column(name = "WebSite",  nullable = true,  length = 60)
   	public String getWebSite() {
		return this.WebSite;
	}

	/** 固定电话 , varchar  ,    Length: 60   */
	public void setWebSite(String WebSite) {
		this.WebSite = WebSite;
	}
	
	/** 公司地址  , varchar  ,     Length: 100 */
    @Column(name = "Address",  nullable = true,  length = 100)
	public String getAddress()
	{
		return this.Address;
	}
    
    /** 公司地址  , varchar  ,     Length: 100 */
    public void setAddress(String Address)
    {
    	this.Address=Address;
    }
    
    /** 管理员姓名  , varchar  ,     Length: 10 */
    @Column(name = "AdminName",  nullable = false,  length = 10)
	public String getAdminName()
	{
		return this.AdminName;
	}
    
    /** 管理员姓名  , varchar  ,     Length: 10 */
    public void setAdminName(String AdminName)
    {
    	this.AdminName=AdminName;
    }
    
    /** 管理员手机  , varchar  ,     Length: 15 */
    @Column(name = "AdminMobile",  nullable = false,  length = 15)
	public String getAdminMobile()
	{
		return this.AdminMobile;
	}
    
    /** 公司地址  , varchar  ,     Length: 100 */
    public void setAdminMobile(String AdminMobile)
    {
    	this.AdminMobile=AdminMobile;
    }
    /** 管理员Email  , varchar  ,     Length: 30 */
    @Column(name = "AdminEmail",  nullable = false,  length = 30)
	public String getAdminEmail()
	{
		return this.AdminEmail;
	}
    
    /** 公司地址  , varchar  ,     Length: 30 */
    public void setAdminEmail(String AdminEmail)
    {
    	this.AdminEmail=AdminEmail;
    }
    /** IM类型 
     		1：QQ
            2：MSN
            3：飞信  , char  ,     Length: 1 */
    @Column(name = "AdminIMType",  nullable = true,  length = 1)
	public String getAdminIMType()
	{
		return this.AdminIMType;
	}
    
    /** IM类型   , char  ,     Length: 1 */
    public void setAdminIMType(String AdminIMType)
    {
    	this.AdminIMType=AdminIMType;
    }
    /** IM号码  , varchar  ,     Length: 20 */
    @Column(name = "AdminIM",  nullable = true,  length = 20)
	public String getAdminIM()
	{
		return this.AdminIM;
	}
    
    /** 公司地址  , varchar  ,     Length: 20 */
    public void setAdminIM(String AdminIM)
    {
    	this.AdminIM=AdminIM;
    }
    
    /** 申请日期  , timestamp  ,     Length: 30 */
    @Column(name = "ApplyDate",  nullable = true,  length = 30)
	public java.sql.Timestamp getApplyDate()
	{
		return this.ApplyDate;
	}
    
    /** 申请日期  , timestamp  ,     Length: 30 */
    public void setApplyDate(java.sql.Timestamp ApplyDate)
    {
    	this.ApplyDate=ApplyDate;
    }
    
    /** 审核状态 0待审,1开通,-1禁用 , char  ,     Length: 1 */
    @Column(name = "AuditState",  nullable = true,  length = 1)
	public String getAuditState()
	{
		return this.AuditState;
	}
    
    /** 审核状态  
     	0待审
		1开通
		-1禁用, char  ,     Length: 1 */
    public void setAuditState(String AuditState)
    {
    	this.AuditState=AuditState;
    }
    

	public String toString() {
		return  "公司ID FID="+FID+" , "+  "公司名称 FName="+FName+" , "+  "公司编码 FCode="+FCode+" , "+  "固定电话 Tel="+Tel+" , "+  "公司网址 WebSite="+WebSite
				+" , "+  "公司地址 Address="+Address+" , "+  "管理员姓名  AdminName="+AdminName+" , "+  "管理员手机 AdminMobile="+AdminMobile+" , "+  "管理员Email AdminEmail="+AdminEmail
				+" , "+  "IM类型            1QQ		2MSN		3飞信 AdminIMType="+AdminIMType+" , "+  "IM号码 AdminIM="+AdminIM+" , "+  "申请日期 ApplyDate="+ApplyDate+" , "+  "审核状态 0待审 1开通 -1禁用 AuditState="+AuditState;
	}
	
	public Object clone() throws CloneNotSupportedException {
		MTCompany model = new MTCompany();
	    		  model.setFID(this.FID);
				  model.setFName(this.FName);
				  model.setFCode(this.FCode);
				  model.setTel(this.Tel);
				  model.setWebSite(this.WebSite);
				   
				return model;
	}

	public void close() throws IOException {
	}
}
