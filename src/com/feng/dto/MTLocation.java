package com.feng.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* table name: mt_Location
* table remark: 员工上报位置表; InnoDB free: 12288 kB
* generate Time: 2014-05-09 16:02:09.179
* @author fengking (http://fengkinglbs.duapp.com/)
* @version 1.0
* @created 2014-10-1 
*/
@Entity
@Table(name = "mt_Location ")
public class MTLocation implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 * , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19  
	 */
	protected long LocID;
	
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
    @Column(name = "LocID",  nullable = false,  length = 19)
   	public Long getLocID() {
		return this.LocID;
	}

	/** 主键 , 
	 * bigint  ,  
	 * PK ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setLocID(Long LocID) {
		this.LocID = LocID;
	}
	
	/** 
	 * 员工ID  , 
	 * varchar  ,     
	 * Length: 19   
	 * */
	protected Long EmpID;
	
	/**
	 * 员工ID  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 19
	 * @return
	 */ 
    @Column(name = "EmpID",  nullable = false,  length = 19)
   	public Long getEmpID() {
		return this.EmpID;
	}

	/** 
	 * 员工ID , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setEmpID(Long EmpID) {
		this.EmpID = EmpID;
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
	 * 定位地址 , 
	 * varchar  ,     
	 * Length: 125   
	 * */
	protected String LocAddress;
	
	/**
	 * 定位地址  , 
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
	 * 定位地址 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 125   
	 */
	public void setLocAddress(String LocAddress) {
		this.LocAddress = LocAddress;
	}
	
	/** 
	 * 考勤时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * */
	protected java.sql.Timestamp RecDateTime;
	
	/**
	 * 考勤时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * @return
	 */ 
    @Column(name = "RecDateTime",  nullable = true,  length = 30)
   	public java.sql.Timestamp getRecDateTime() {
		return this.RecDateTime;
	}

	/** 
	 * 考勤时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00        
	 */
	public void setRecDateTime(java.sql.Timestamp RecDateTime) {
		this.RecDateTime = RecDateTime;
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
	
	public MTLocation()
	{
		
	}
	
	public MTLocation(Long LocID)
	{
		super();
		this.LocID = LocID; 
	}
	
	/**
	 * 字符串
	 */
	public String toString() {
		return  "主键 LocID="+LocID+" , "+  "员工ID EmpID="+EmpID+" , "+  "经度 Longitude="+Longitude+" , "+  "纬度 Latitude="+Latitude 
				+" ,定位地址 LocAddress="+LocAddress+  ",考勤时间 RecDateTime="+RecDateTime+" , "+  "备注 Remark="+Remark;
	}
	
	/**
	 * 对象克隆
	 */
	public Object clone() throws CloneNotSupportedException {
		MTLocation model = new MTLocation();
    		  model.setLocID(this.LocID);
			  model.setEmpID(this.EmpID);
			  model.setLongitude(this.Longitude);
			  model.setLatitude(this.Latitude); 
			  model.setLocAddress(this.LocAddress); 
			  model.setRecDateTime(this.RecDateTime);
			  model.setRemark(this.Remark); 
			  return model;
	}
	
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
