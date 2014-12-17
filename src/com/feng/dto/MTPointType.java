package com.feng.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* table name: mt_PointType
* table remark: 签到点类型表; InnoDB free: 12288 kB
* generate Time: 2014-05-09 16:02:09.179
* @author fengking (http://fengkinglbs.duapp.com/)
* @version 1.0
* @created 2014-10-1 
*/
@Entity
@Table(name = "mt_PointType")
public class MTPointType implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19  
	 */
	protected long PointTypeID;
	
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
    @Column(name = "PointTypeID",  nullable = false,  length = 19)
   	public Long getPointTypeID() {
		return this.PointTypeID;
	}

	/** 主键 , 
	 * bigint  ,  
	 * PK ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setPointTypeID(Long PointTypeID) {
		this.PointTypeID = PointTypeID;
	}
	
	/** 
	 * 类型名称 , 
	 * varchar  ,     
	 * Length: 125   
	 * */
	protected String PointTypeName;
	
	/**
	 * 类型名称  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 125
	 * @return
	 */ 
    @Column(name = "PointTypeName",  nullable = false,  length = 125)
   	public String getPointTypeName() {
		return this.PointTypeName;
	}

	/** 
	 * 类型名称 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 125   
	 */
	public void setPointTypeName(String PointTypeName) {
		this.PointTypeName = PointTypeName;
	}
	
	public MTPointType()
	{
		
	}
	public MTPointType(Long PointTypeID)
	{
		super();
		this.PointTypeID=PointTypeID;
	}
	
	/**
	 * 字符串
	 */
	public String toString() {
		return  "主键 PointTypeID="+PointTypeID+" , "+  "类型名称 PointTypeName="+PointTypeName;
	}
	
	/**
	 * 对象克隆
	 */
	public Object clone() throws CloneNotSupportedException {
		MTPointType model = new MTPointType();
    		  model.setPointTypeID(this.PointTypeID); 
			  model.setPointTypeName(this.PointTypeName);  
			  return model;
	}
	
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
