package com.feng.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* table name: mt_Point
* table remark: 签到点表; InnoDB free: 12288 kB
* generate Time: 2014-05-09 16:02:09.179
* @author fengking (http://fengkinglbs.duapp.com/)
* @version 1.0
* @created 2014-10-1 
*/
@Entity
@Table(name = "mt_Point")
public class MTPoint implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19  
	 */
	protected long PointID;
	
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
    @Column(name = "PointID",  nullable = false,  length = 19)
   	public Long getPointID() {
		return this.PointID;
	}

	/** 主键 , 
	 * bigint  ,  
	 * PK ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setPointID(Long PointID) {
		this.PointID = PointID;
	}
	
	/**
	 * 签到点类型ID
	 * , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19  
	 */
	protected long PointTypeID;
	
	/**
	 * 签到点类型ID , 
	 * bigint  ,  
	 * PK ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 19
	 * @return
	 */ 
    @Column(name = "PointTypeID",  nullable = false,  length = 19)
   	public Long getPointTypeID() {
		return this.PointTypeID;
	}

	/** 签到点类型ID , 
	 * bigint  ,  
	 * PK ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setPointTypeID(Long PointTypeID) {
		this.PointTypeID = PointTypeID;
	}
	
	/** 
	 * 签到点名称 , 
	 * varchar  ,     
	 * Length: 125   
	 * */
	protected String PointName;
	
	/**
	 * 签到点名称  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 125
	 * @return
	 */ 
    @Column(name = "PointName",  nullable = false,  length = 125)
   	public String getPointName() {
		return this.PointName;
	}

	/** 
	 * 签到点名称 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 125   
	 */
	public void setPointName(String PointName) {
		this.PointName = PointName;
	}
	
	/** 
	 * 经度  , 
	 * Double  ,     
	 * Length: 23   
	 * */
	protected Double Longitude;
	
	/**
	 * 经度  , 
	 * Double  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 23
	 * @return
	 */ 
    @Column(name = "Longitude",  nullable = false,  length = 23)
   	public Double getLongitude() {
		return this.Longitude;
	}

	/** 
	 * 经度 , 
	 * Double  ,   
	 * NOT NULL  , 
	 * Length: 23   
	 */
	public void setLongitude(Double Longitude) {
		this.Longitude = Longitude;
	}
	
	/** 
	 * 纬度  , 
	 * Double  ,     
	 * Length: 23   
	 * */
	protected Double Latitude;
	
	/**
	 * 纬度  , 
	 * Double  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 23
	 * @return
	 */ 
    @Column(name = "Latitude",  nullable = false,  length = 23)
   	public Double getLatitude() {
		return this.Latitude;
	}

	/** 
	 * 纬度 , 
	 * Double  ,   
	 * NOT NULL  , 
	 * Length: 23   
	 */
	public void setLatitude(Double Latitude) {
		this.Latitude = Latitude;
	}
	
	/** 
	 * 地址 , 
	 * varchar  ,     
	 * Length: 125   
	 * */
	protected String LocAddress;
	
	/**
	 * 地址  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 125
	 * @return
	 */ 
    @Column(name = "LocAddress",  nullable = false,  length = 125)
   	public String getLocAddress() {
		return this.LocAddress;
	}

	/** 
	 * 地址 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 125   
	 */
	public void setLocAddress(String LocAddress) {
		this.LocAddress = LocAddress;
	}
	
	/** 
	 * 描述 , 
	 * varchar  ,     
	 * Length: 125   
	 * */
	protected String Description;
	
	/**
	 * 描述  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 125
	 * @return
	 */ 
    @Column(name = "Description",  nullable = false,  length = 125)
   	public String getDescription() {
		return this.Description;
	}

	/** 
	 * 描述 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 125   
	 */
	public void setDescription(String Description) {
		this.Description = Description;
	}
	
	/** 
	 * 添加人  , 
	 * varchar  ,     
	 * Length: 19   
	 * */
	protected Long AddEmpID;
	
	/**
	 * 添加人  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 19
	 * @return
	 */ 
    @Column(name = "AddEmpID",  nullable = false,  length = 19)
   	public Long getAddEmpID() {
		return this.AddEmpID;
	}

	/** 
	 * 添加人 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setAddEmpID(Long AddEmpID) {
		this.AddEmpID = AddEmpID;
	}
	
	/** 
	 * 添加时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * */
	protected java.sql.Timestamp AddDateTime;
	
	/**
	 * 添加时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * @return
	 */ 
    @Column(name = "AddDateTime",  nullable = true,  length = 30)
   	public java.sql.Timestamp getAddDateTime() {
		return this.AddDateTime;
	}

	/** 
	 * 添加时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00        
	 */
	public void setAddDateTime(java.sql.Timestamp AddDateTime) {
		this.AddDateTime = AddDateTime;
	}
	
	/** 
	 * 状态(0无效，1有效)  , 
	 * varchar  ,     
	 * Length: 19   
	 * */
	protected Long Status;
	
	/**
	 * 状态(0无效，1有效)  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 19
	 * @return
	 */ 
    @Column(name = "Status",  nullable = true,  length = 19)
   	public Long getStatus() {
		return this.Status;
	}

	/** 
	 * 状态(0无效，1有效) , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setStatus(Long Status) {
		this.Status = Status;
	}
	
	public MTPoint()
	{
		
	}
	
	public MTPoint(Long PointID)
	{
		super();
		this.PointID = PointID; 
	}
	
	/**
	 * 字符串
	 */
	public String toString() {
		return  "主键 PointID="+PointID+" , "+  "签到点类型ID PointTypeID="+PointTypeID+" , "+  "经度 Longitude="+Longitude+" , "+  "纬度 Latitude="+Latitude 
				+" ,地址 LocAddress="+LocAddress+  "添加时间 AddDateTime="+AddDateTime+" , "+  "状态(0无效，1有效) Status="+Status
				+",签到点名称 PointName="+PointName+",描述 Description="+Description+",添加人 AddEmpID="+AddEmpID;
	}
	
	/**
	 * 对象克隆
	 */
	public Object clone() throws CloneNotSupportedException {
		MTPoint model = new MTPoint();
    		  model.setPointID(this.PointID);
			  model.setPointTypeID(this.PointTypeID);
			  model.setPointName(this.PointName);
			  model.setLongitude(this.Longitude);
			  model.setLatitude(this.Latitude); 
			  model.setLocAddress(this.LocAddress); 
			  model.setDescription(this.Description); 
			  model.setAddEmpID(this.AddEmpID); 
			  model.setAddDateTime(this.AddDateTime);
			  model.setStatus(this.Status); 
			  return model;
	}
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
