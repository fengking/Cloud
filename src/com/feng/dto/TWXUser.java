package com.feng.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* table name: t_WXUser
* table remark: 用户手机微信号对应表; InnoDB free: 12288 kB
* generate Time: 2014-05-09 16:02:09.179
* @author fengking (http://fengkinglbs.duapp.com/)
* @version 1.0
* @created 2014-10-1 
*/
@Entity
@Table(name = "t_WXUser")
public class TWXUser implements java.io.Serializable,java.io.Closeable{

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
	
	public TWXUser()
	{
		
	}
	public TWXUser(Long FID)
	{
		super();
		this.FID=FID;
	}
	
	/** 
	 * 手机号 , 
	 * varchar  ,     
	 * Length: 20   
	 * */
	protected String FPHONE;
	
	/**
	 * 手机号  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 20
	 * @return
	 */ 
    @Column(name = "FPHONE",  nullable = false,  length = 20)
   	public String getFPHONE() {
		return this.FPHONE;
	}

	/** 
	 * 手机号 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 20   
	 */
	public void setFPHONE(String FPHONE) {
		this.FPHONE = FPHONE;
	}
	
	/** 
	 * 微信号 , 
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String FWEIXINNO;
	
	/**
	 * 微信号  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "FWEIXINNO",  nullable = false,  length = 50)
   	public String getFWEIXINNO() {
		return this.FWEIXINNO;
	}

	/** 
	 * 微信号 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 50   
	 */
	public void setFWEIXINNO(String FWEIXINNO) {
		this.FWEIXINNO = FWEIXINNO;
	}
	
	/** 
	 * 用户状态 1：绑定；2解绑；3关注；4取消关注  , 
	 * varchar  ,     
	 * Length: 19   
	 * */
	protected Long FStatus;
	
	/**
	 * 用户状态 1：绑定；2解绑；3关注；4取消关注  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 19
	 * @return
	 */ 
    @Column(name = "FStatus",  nullable = true,  length = 19)
   	public Long getFStatus() {
		return this.FStatus;
	}

	/** 
	 * 用户状态 1：绑定；2解绑；3关注；4取消关注 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setFStatus(Long FStatus) {
		this.FStatus = FStatus;
	}
	
	/** 
	 * 手机用户ID[例如第三方分配的ID] , 
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String FUSERID;
	
	/**
	 * 手机用户ID[例如第三方分配的ID]  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "FUSERID",  nullable = false,  length = 50)
   	public String getFUSERID() {
		return this.FUSERID;
	}

	/** 
	 * 手机用户ID[例如第三方分配的ID] , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 50   
	 */
	public void setFUSERID(String FUSERID) {
		this.FUSERID = FUSERID;
	}
	
	/** 
	 * 用户进入的权限校验码 , 
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String FACCESSTOOKEN;
	
	/**
	 * 用户进入的权限校验码  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "FACCESSTOOKEN",  nullable = false,  length = 50)
   	public String getFACCESSTOOKEN() {
		return this.FACCESSTOOKEN;
	}

	/** 
	 * 用户进入的权限校验码 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 50   
	 */
	public void setFACCESSTOOKEN(String FACCESSTOOKEN) {
		this.FACCESSTOOKEN = FACCESSTOOKEN;
	}
	
	/** 
	 * 提交时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * */
	protected java.sql.Timestamp FDate;
	
	/**
	 * 提交时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * @return
	 */ 
    @Column(name = "FDate",  nullable = true,  length = 30)
   	public java.sql.Timestamp getFDate() {
		return this.FDate;
	}

	/** 
	 * 提交时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00        
	 */
	public void setFDate(java.sql.Timestamp FDate) {
		this.FDate = FDate;
	}
	
	/** 
	 * 备注  ,  
	 * varchar  ,     
	 * Length: 255   
	 * */
	protected String FRemark;
	
	/**
	 * 备注  ,  
	 * varchar  ,     
	 * Length: 255   
	 * @return
	 */ 
    @Column(name = "FRemark",  nullable = true,  length = 255)
   	public String getFRemark() {
		return this.FRemark;
	}

	/** 
	 * 备注  ,  
	 * varchar  ,     
	 * Length: 255        
	 */
	public void setFRemark(String FRemark) {
		this.FRemark = FRemark;
	}
	
	/**
	 * 字符串
	 */
	public String toString() {
		return  "主键 FID="+FID+" , "+  "手机号 FPHONE="+FPHONE+" , "+  "微信号 FWEIXINNO="+FWEIXINNO+" , "+  "用户状态 1：绑定；2解绑；3关注；4取消关注 FStatus="+FStatus 
				+" ,手机用户ID[例如第三方分配的ID] FUSERID="+FUSERID+  ",用户进入的权限校验码 FACCESSTOOKEN="+FACCESSTOOKEN+",增加日期 FDate"+FDate+" , "+  "备注 FRemark="+FRemark;
	}
	
	/**
	 * 对象克隆
	 */
	public Object clone() throws CloneNotSupportedException {
		TWXUser model = new TWXUser();
    		  model.setFID(this.FID);
			  model.setFPHONE(this.FPHONE);
			  model.setFWEIXINNO(this.FWEIXINNO);
			  model.setFStatus(this.FStatus); 
			  model.setFUSERID(this.FUSERID); 
			  model.setFACCESSTOOKEN(this.FACCESSTOOKEN);
			  model.setFDate(this.FDate);
			  model.setFRemark(this.FRemark); 
			  return model;
	}
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
