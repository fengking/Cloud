package com.feng.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* table name: mt_Dept
* table remark: 部门表; InnoDB free: 12288 kB
* generate Time: 2014-05-09 16:02:09.179
* @author fengking (http://fengkinglbs.duapp.com/)
* @version 1.0
* @created 2014-10-1 
*/
@Entity
@Table(name = "mt_Dept")
public class MTDept  implements java.io.Serializable,java.io.Closeable{

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
	 * 部门名称  , 
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String FName;
	
	/**
	 * 部门名称  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "FName",  nullable = false,  length = 50)
   	public String getFName() {
		return this.FName;
	}

	/** 
	 * 部门名称 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 50   
	 */
	public void setFName(String FName) {
		this.FName = FName;
	}
	
	
	/** 
	 * 部门编码  , 
	 * varchar  ,     
	 * Length: 20   
	 * */
	protected String FCode;
	
	/**
	 * 部门编码  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 20
	 * @return
	 */ 
    @Column(name = "FCode",  nullable = false,  length = 20)
   	public String getFCode() {
		return this.FCode;
	}

	/** 
	 * 部门编码 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 20   
	 */
	public void setFCode(String FCode) {
		this.FCode = FCode;
	}
	
	/** 
	 * 父部门ID（本期不用）  , 
	 * varchar  ,     
	 * Length: 19   
	 * */
	protected Long ParentID;
	
	/**
	 * 父部门ID（本期不用）  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 19
	 * @return
	 */ 
    @Column(name = "ParentID",  nullable = false,  length = 19)
   	public Long getParentID() {
		return this.ParentID;
	}

	/** 
	 * 父部门ID（本期不用） , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setParentID(Long ParentID) {
		this.ParentID = ParentID;
	}
	
	/** 
	 * 创建时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * */
	protected java.sql.Timestamp CreateDateTime;
	
	/**
	 * 创建时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * @return
	 */ 
    @Column(name = "CreateDateTime",  nullable = true,  length = 30)
   	public java.sql.Timestamp getCreateDateTime() {
		return this.CreateDateTime;
	}

	/** 
	 * 创建时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00        
	 */
	public void setCreateDateTime(java.sql.Timestamp CreateDateTime) {
		this.CreateDateTime = CreateDateTime;
	}
	
	/** 
	 * 备注  ,  
	 * varchar  ,     
	 * Length: 255   
	 * */
	protected String Remark;
	
	/**
	 * 备注  ,  
	 * varchar  ,     
	 * Length: 255   
	 * @return
	 */ 
    @Column(name = "Remark",  nullable = true,  length = 255)
   	public String getRemark() {
		return this.Remark;
	}

	/** 
	 * 备注  ,  
	 * varchar  ,     
	 * Length: 255        
	 */
	public void setRemark(String Remark) {
		this.Remark = Remark;
	}
	
	/**
	 * 构造函数
	 */
	public MTDept()
	{
		
	}
	
	/**
	 *	构造函数 
	 * @param FID 主键
	 */
	public MTDept(Long FID) {
		super();
		this.FID = FID;        
    }
	
	/**
	 * 字符串
	 */
	public String toString() {
		return  "主键 FID="+FID+" , "+  "部门名称 FName="+FName+" , "+  "部门编码 FCode="+FCode+" , "+  "父部门ID（本期不用） ParentID="+ParentID 
				+" , "+  "创建时间 CreateDateTime="+CreateDateTime+" , "+  "备注 Remark="+Remark;
	}
	
	/**
	 * 对象克隆
	 */
	public Object clone() throws CloneNotSupportedException {
		MTDept model = new MTDept();
    		  model.setFID(this.FID);
			  model.setFName(this.FName);
			  model.setFCode(this.FCode);
			  model.setParentID(this.ParentID); 
			  model.setCreateDateTime(this.CreateDateTime);
			  model.setRemark(this.Remark); 
			  return model;
	}
	
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
	

}
