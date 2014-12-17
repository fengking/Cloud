package com.feng.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
* table name: mt_emp
* table remark: 职员表; InnoDB free: 12288 kB
* generate Time: 2014-05-09 16:02:09.179
* @author fengking (http://fengkinglbs.duapp.com/)
* @version 1.0
* @created 2014-10-1 
*/
@Entity
@Table(name = "mt_emp")
public class MtEmp implements java.io.Serializable,java.io.Closeable{

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
	 * 工号  , 
	 * varchar  ,     
	 * Length: 20   
	 * */
	protected String FNO;
	
	/**
	 * 工号  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 20
	 * @return
	 */ 
    @Column(name = "FNO",  nullable = false,  length = 20)
   	public String getFNO() {
		return this.FNO;
	}

	/** 工号 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 20   
	 */
	public void setFNO(String FNO) {
		this.FNO = FNO;
	}
	
	/** 
	 * 安装唯一码  , 
	 * varchar  ,     
	 * Length: 20   
	 * */
	protected String MSISDN;
	
	/**
	 * 安装唯一码  , 
	 * varchar  ,     
	 * Length: 20
	 * @return
	 */ 
    @Column(name = "MSISDN",  nullable = true,  length = 20)
   	public String getMSISDN() {
		return this.MSISDN;
	}

	/** 工号 , 
	 * varchar  ,    
	 * Length: 20   
	 */
	public void setMSISDN(String MSISDN) {
		this.MSISDN = MSISDN;
	}
	
	/** 
	 * 用户手机号码  , 登录使用
	 * varchar  ,     
	 * Length: 20   
	 * */
	protected String UserName;
	
	/**
	 * 用户手机号码  , 登录使用  , 
	 * varchar  ,     
	 * Length: 20
	 * @return
	 */ 
    @Column(name = "UserName",  nullable = false,  length = 20)
   	public String getUserName() {
		return this.UserName;
	}

	/** 
	 * 用户手机号码  , 登录使用
	 * varchar  ,     
	 * Length: 20   
	 */
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	
	/** 
	 * 员工真实姓名   ,  
	 * varchar  ,     
	 * Length: 15   
	 * */
	protected String EmpName;
	
	/**
	 * 员工真实姓名   ,  
	 * varchar  ,     
	 * Length: 15 
	 * @return
	 */ 
    @Column(name = "EmpName",  nullable = true,  length = 15)
   	public String getEmpName() {
		return this.EmpName;
	}

	/** 
	 * 员工真实姓名   ,  
	 * varchar  ,     
	 * Length: 15    
	 */
	public void setEmpName(String EmpName) {
		this.EmpName = EmpName;
	}
	
	/** 
	 * 性别  ,  0 女 1 男
	 * char  ,     
	 * Length: 1  
	 * */
	protected String Gender;
	
	/**
	 * 性别  ,  0 女 1 男
	 * char  ,     
	 * Length: 1 
	 * @return
	 */ 
    @Column(name = "Gender",  nullable = true,  length = 1)
   	public String getGender() {
		return this.Gender;
	}

	/** 
	 * 性别  ,  0 女 1 男
	 * char  ,     
	 * Length: 1    
	 */
	public void setGender(String Gender) {
		this.Gender = Gender;
	}
	
	/** 
	 * 电子邮箱  ,  
	 * varchar  ,     
	 * Length: 20   
	 * */
	protected String Email;
	
	/**
	 * 电子邮箱  ,  
	 * varchar  ,     
	 * Length: 20 
	 * @return
	 */ 
    @Column(name = "Email",  nullable = false,  length = 20)
   	public String getEmail() {
		return this.Email;
	}

	/** 
	 * 电子邮箱  ,  
	 * varchar  ,     
	 * Length: 20     
	 */
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	/**
	 * 部门ID, 
	 * bigint,   
	 * Length: 19  
	 */
	protected long 	DeptID;
	
	/**
	 * 部门ID, 
	 * bigint,   
	 * Length: 19 
	 * @return
	 */ 
    @Column(name = "DeptID",  nullable = true,  length = 19)
   	public long getDeptID() {
		return this.DeptID;
	}

	/** 
	 * 部门ID, 
	 * bigint,   
	 * Length: 19    
	 */
	public void setDeptID(long DeptID) {
		this.DeptID = DeptID;
	}
	
	/** 
	 * 用户密码  ,  
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String Pwd;
	
	/**
	 * 用户密码  ,  
	 * varchar  ,     
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "Pwd",  nullable = false,  length = 50)
   	public String getPwd() {
		return this.Pwd;
	}

	/** 
	 * 用户密码  ,  
	 * varchar  ,     
	 * Length: 50     
	 */
	public void setPwd(String Pwd) {
		this.Pwd = Pwd;
	}
	
	/** 
	 * 用户状态  ,  0 禁用 1 启用
	 * char  ,     
	 * Length: 1   
	 * */
	protected String Status;
	
	
	/**
	 * 用户状态  ,  0 禁用 1 启用
	 * char  ,     
	 * Length: 1 
	 * @return
	 */ 
    @Column(name = "Status",  nullable = true,  length = 1)
   	public String getStatus() {
		return this.Status;
	}

	/** 
	 * 用户状态  ,  0 禁用 1 启用
	 * char  ,     
	 * Length: 1     
	 */
	public void setStatus(String Status) {
		this.Status = Status;
	}
	
	/** 
	 * 设备授权唯一编码  ,  
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String DeviceToken;
	
	/**
	 * 设备授权唯一编码  ,  
	 * varchar  ,     
	 * Length: 50
	 * @return
	 */ 
    @Column(name = "DeviceToken",  nullable = true,  length = 50)
   	public String getDeviceToken() {
		return this.DeviceToken;
	}

	/** 
	 * 设备授权唯一编码  ,  
	 * varchar  ,     
	 * Length: 50     
	 */
	public void setDeviceToken(String DeviceToken) {
		this.DeviceToken = DeviceToken;
	}
	
	/** 
	 * 手机号码 ,  
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String Phonenumber;
	
	/**
	 * 手机号码 ,  
	 * varchar  ,     
	 * Length: 50 
	 * @return
	 */ 
    @Column(name = "Phonenumber",  nullable = true,  length = 50)
   	public String getPhonenumber() {
		return this.Phonenumber;
	}

	/** 
	 * 手机号码 ,  
	 * varchar  ,     
	 * Length: 50      
	 */
	public void setPhonenumber(String Phonenumber) {
		this.Phonenumber = Phonenumber;
	}
	
	/** 
	 * 安装应用唯一码  ,  
	 * varchar  ,     
	 * Length: 50   
	 * */
	protected String InstallAction;
	
	/**
	 * 安装应用唯一码  ,  
	 * varchar  ,     
	 * Length: 50  
	 * @return
	 */ 
    @Column(name = "InstallAction",  nullable = true,  length = 50)
   	public String getInstallAction() {
		return this.InstallAction;
	}

	/** 
	 * 安装应用唯一码  ,  
	 * varchar  ,     
	 * Length: 50       
	 */
	public void setInstallAction(String InstallAction) {
		this.InstallAction = InstallAction;
	}
	
	/** 
	 * 创建时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * */
	protected java.sql.Timestamp CreateTime;
	
	/**
	 * 创建时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * @return
	 */ 
    @Column(name = "CreateTime",  nullable = true,  length = 30)
   	public java.sql.Timestamp getCreateTime() {
		return this.CreateTime;
	}

	/** 
	 * 创建时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00        
	 */
	public void setCreateTime(java.sql.Timestamp CreateTime) {
		this.CreateTime = CreateTime;
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
	public MtEmp() {
	}

	/**
	 *	构造函数 
	 * @param FID 主键
	 */
	public MtEmp(Long FID) {
		super();
		this.FID = FID;        
        }
		
	
	public String toString() {
		return  "主键 FID="+FID+" , "+  "工号 FNO="+FNO+" , "+  "安装唯一码 MSISDN="+MSISDN+" , "+  "用户手机号码 UserName="+UserName+" , "+  "员工真实姓名 EmpName="+EmpName
				+" , "+  "性别 0女 1男 Gender="+Gender+" , "+  "电子邮箱  Email="+Email+" , "+  "部门ID DeptID="+DeptID+" , "+  "用户密码 Pwd="+Pwd
				+" , "+  "用户状态            0禁用		1启用 Status="+Status+" , "+  "设备授权唯一编码 DeviceToken="+DeviceToken+" , "+  "手机号码 Phonenumber="+Phonenumber
				+" , "+  "安装应用唯一码 InstallAction="+InstallAction+" , "+  "创建时间 CreateTime="+CreateTime+" , "+  "备注 Remark="+Remark;
	}
	
	public Object clone() throws CloneNotSupportedException {
		MtEmp model = new MtEmp();
    		  model.setFID(this.FID);
			  model.setFNO(this.FNO);
			  model.setMSISDN(this.MSISDN);
			  model.setUserName(this.UserName);
			  model.setEmpName(this.EmpName);
			   
			  model.setGender(this.Gender);
			  model.setEmail(this.Email);
			  model.setDeptID(this.DeptID);
			  model.setPwd(this.Pwd);
			  model.setStatus(this.Status);
			  model.setDeviceToken(this.DeviceToken);
			  model.setPhonenumber(this.Phonenumber);
			  model.setInstallAction(this.InstallAction);
			  model.setCreateTime(this.CreateTime);
			  model.setRemark(this.Remark); 
			  return model;
	}
	
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
