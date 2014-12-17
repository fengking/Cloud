package com.feng.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* table name: mt_FeedBack
* table remark: 客户反馈信息表; InnoDB free: 12288 kB
* generate Time: 2014-05-09 16:02:09.179
* @author fengking (http://fengkinglbs.duapp.com/)
* @version 1.0
* @created 2014-10-1 
*/
@Entity
@Table(name = "mt_AppInfo")
public class MTAppInfo implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19  
	 */
	protected long FID;
	
	/**
	 * 主键  , 
	 * bigint  ,  
	 * PK ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 19
	 * @return
	 */
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "FID",  nullable = false,  length = 19)
   	public Long getFID() {
		return this.FID;
	}

	/** 主键 , 
	 * bigint  ,  
	 * PK ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setFID(Long FID) {
		this.FID = FID;
	}
	
	/** 
	 * 中文名称 , 
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String FName_CHS;
	
	/**
	 * 中文名称  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "FName_CHS",  nullable = false,  length = 50)
   	public String getFName_CHS() {
		return this.FName_CHS;
	}

	/** 
	 * 中文名称 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 50   
	 */
	public void setFName_CHS(String FName_CHS) {
		this.FName_CHS = FName_CHS;
	}
	
	/** 
	 * 英文名称 , 
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String FName_EN;
	
	/**
	 * 英文名称  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "FName_EN",  nullable = false,  length = 50)
   	public String getFName_EN() {
		return this.FName_EN;
	}

	/** 
	 * 英文名称 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 50   
	 */
	public void setFName_EN(String FName_EN) {
		this.FName_EN = FName_EN;
	}
	
	/** 
	 * 繁体名称 , 
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String FName_CHT;
	
	/**
	 * 繁体名称  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "FName_CHT",  nullable = false,  length = 50)
   	public String getFName_CHT() {
		return this.FName_CHT;
	}

	/** 
	 * 繁体名称 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 50   
	 */
	public void setFName_CHT(String FName_CHT) {
		this.FName_CHT = FName_CHT;
	}
	/** 
	 * 版本代码 , 
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String FVersionCode;
	
	/**
	 * 版本代码  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "FVersionCode",  nullable = false,  length = 50)
   	public String getFVersionCode() {
		return this.FVersionCode;
	}

	/** 
	 * 版本代码 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 50   
	 */
	public void setFVersionCode(String FVersionCode) {
		this.FVersionCode = FVersionCode;
	}
	/** 
	 * 版本名称 , 
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String FVersionName;
	
	/**
	 * 版本名称  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "FVersionName",  nullable = false,  length = 50)
   	public String getFVersionName() {
		return this.FVersionName;
	}

	/** 
	 * 版本名称 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 50   
	 */
	public void setFVersionName(String FVersionName) {
		this.FVersionName = FVersionName;
	}
	
	
	/** 
	 * 创建时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * */
	protected java.sql.Timestamp FCreateDate;
	
	/**
	 * 创建时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * @return
	 */ 
    @Column(name = "FCreateDate",  nullable = true,  length = 30)
   	public java.sql.Timestamp getFCreateDate() {
		return this.FCreateDate;
	}

	/** 
	 * 创建时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00        
	 */
	public void setFCreateDate(java.sql.Timestamp FCreateDate) {
		this.FCreateDate = FCreateDate;
	}
	/** 
	 * 更新时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * */
	protected java.sql.Timestamp FUpdateDate;
	
	/**
	 * 更新时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * @return
	 */ 
    @Column(name = "FUpdateDate",  nullable = true,  length = 30)
   	public java.sql.Timestamp getFUpdateDate() {
		return this.FUpdateDate;
	}

	/** 
	 * 更新时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00        
	 */
	public void setFUpdateDate(java.sql.Timestamp FUpdateDate) {
		this.FUpdateDate = FUpdateDate;
	}
	
	/** 
	 * 云端下载地址 , 
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String FAppURL;
	
	/**
	 * 云端下载地址  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "FAppURL",  nullable = false,  length = 50)
   	public String getFAppURL() {
		return this.FAppURL;
	}
    
    /** 
	 * 云端下载地址 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 50   
	 */
	public void setFAppURL(String FAppURL) {
		this.FAppURL = FAppURL;
	}
	public MTAppInfo()
	{
		
	}
	
	public MTAppInfo(Long FID)
	{
		super();
		this.FID=FID;
	}
	
	/**
	 * 字符串
	 */
	public String toString() {
		return  "主键 FID="+FID+" , "+  "中文名称 FName_CHS="+FName_CHS+" , "+  "英文名称 FName_EN="+FName_EN+" , "+  "繁体名称 FName_CHT="+FName_CHT 
				+" ,版本代码 FVersionCode="+FVersionCode+  " , "+  "版本名称 FVersionName="+FVersionName 
				+",创建时间 FCreateDate="+FCreateDate+",更新时间 FUpdateDate="+FUpdateDate+",云端下载地址 FAppURL="+FAppURL;
	}
	
	/**
	 * 对象克隆
	 */
	public Object clone() throws CloneNotSupportedException {
		MTAppInfo model = new MTAppInfo();
    		  model.setFID(this.FID);
			  model.setFName_CHS(this.FName_CHS);
			  model.setFName_EN(this.FName_EN);
			  model.setFName_CHT(this.FName_CHT);
			  model.setFVersionCode(this.FVersionCode);  
			  model.setFVersionName(this.FVersionName); 
			  model.setFCreateDate(this.FCreateDate); 
			  model.setFUpdateDate(this.FUpdateDate); 
			  model.setFAppURL(this.FAppURL); 
			  return model;
	}
	
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
