package com.feng.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* table name: mt_EmpDevice
* table remark: 员工设备信息表; InnoDB free: 12288 kB
* generate Time: 2014-05-09 16:02:09.179
* @author fengking (http://fengkinglbs.duapp.com/)
* @version 1.0
* @created 2014-10-1 
*/
@Entity
@Table(name = "mt_EmpDevice")
public class MTEmpDevice implements java.io.Serializable,java.io.Closeable{

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
	 * 员工ID  , 
	 * varchar  ,     
	 * Length: 19   
	 * */
	protected Long FEmpID;
	
	/**
	 * 员工ID  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 19
	 * @return
	 */ 
    @Column(name = "FEmpID",  nullable = false,  length = 19)
   	public Long getFEmpID() {
		return this.FEmpID;
	}

	/** 
	 * 员工ID , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setFEmpID(Long FEmpID) {
		this.FEmpID = FEmpID;
	}
	
	/** 
	 * 用户设备唯一码  , 
	 * varchar  ,     
	 * Length: 80   
	 * */
	protected String DeviceUID;
	
	/**
	 * 用户设备唯一码  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 80
	 * @return
	 */ 
    @Column(name = "DeviceUID",  nullable = false,  length = 80)
   	public String getDeviceUID() {
		return this.DeviceUID;
	}

	/** 
	 * 用户设备唯一码 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 80   
	 */
	public void setDeviceUID(String DeviceUID) {
		this.DeviceUID = DeviceUID;
	}
	
	/** 
	 * 设备Token,适用于苹果手机、iPad  , 
	 * varchar  ,     
	 * Length: 80   
	 * */
	protected String DeviceToken;
	
	/**
	 * 设备Token,适用于苹果手机、iPad  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 80
	 * @return
	 */ 
    @Column(name = "DeviceToken",  nullable = false,  length = 80)
   	public String getDeviceToken() {
		return this.DeviceToken;
	}

	/** 
	 * 设备Token,适用于苹果手机、iPad , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 80   
	 */
	public void setDeviceToken(String DeviceToken) {
		this.DeviceToken = DeviceToken;
	}
	
	/** 
	 * 手机操作系统  , 
	 * varchar  ,     
	 * Length: 80   
	 * */
	protected String DeviceOS;
	
	/**
	 * 手机操作系统  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 80
	 * @return
	 */ 
    @Column(name = "DeviceOS",  nullable = false,  length = 80)
   	public String getDeviceOS() {
		return this.DeviceOS;
	}

	/** 
	 * 手机操作系统 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 80   
	 */
	public void setDeviceOS(String DeviceOS) {
		this.DeviceOS = DeviceOS;
	}
	
	/** 
	 * 设备的User-Agent  , 
	 * varchar  ,     
	 * Length: 100   
	 * */
	protected String DeviceUA;
	
	/**
	 * 设备的User-Agent  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 100
	 * @return
	 */ 
    @Column(name = "DeviceUA",  nullable = false,  length = 100)
   	public String getDeviceUA() {
		return this.DeviceUA;
	}

	/** 
	 * 设备的User-Agent , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 100   
	 */
	public void setDeviceUA(String DeviceUA) {
		this.DeviceUA = DeviceUA;
	}
	
	/** 
	 * 设备激活时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * */
	protected java.sql.Timestamp RegDate;
	
	/**
	 * 设备激活时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * @return
	 */ 
    @Column(name = "RegDate",  nullable = true,  length = 30)
   	public java.sql.Timestamp getRegDate() {
		return this.RegDate;
	}

	/** 
	 * 设备激活时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00        
	 */
	public void setRegDate(java.sql.Timestamp RegDate) {
		this.RegDate = RegDate;
	}
	
	/**
	 * 构造函数
	 */
	public MTEmpDevice()
	{
		
	}
	
	/**
	 *	构造函数 
	 * @param FID 主键
	 */
	public MTEmpDevice(Long FID) {
		super();
		this.FID = FID;        
        }
	
	/**
	 * 字符串
	 */
	public String toString() {
		return  "主键 FID="+FID+" , "+  "员工ID FEmpID="+FEmpID+" , "+  "用户设备唯一码 DeviceUID="+DeviceUID+" , "+  "设备Token,适用于苹果手机、iPad DeviceToken="+DeviceToken
				+",手机操作系统  DeviceOS="+DeviceOS+", 设备的User-Agent DeviceUA"+DeviceUA
				+" , "+  "设备激活时间 RegDate="+RegDate;
	}
	
	/**
	 * 对象克隆
	 */
	public Object clone() throws CloneNotSupportedException {
		MTEmpDevice model = new MTEmpDevice();
    		  model.setFID(this.FID);
			  model.setFEmpID(this.FEmpID);
			  model.setDeviceUID(this.DeviceUID);
			  model.setDeviceToken(this.DeviceToken); 
			  model.setDeviceOS(this.DeviceOS); 
			  model.setDeviceUA(this.DeviceUA); 
			  model.setRegDate(this.RegDate); 
			  return model;
	}
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
