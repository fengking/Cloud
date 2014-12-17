package com.feng.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* table name: mt_workLog
* table remark: 工作日志表; InnoDB free: 12288 kB
* generate Time: 2014-05-09 16:02:09.179
* @author fengking (http://fengkinglbs.duapp.com/)
* @version 1.0
* @created 2014-10-1 
*/
@Entity
@Table(name = "mt_workLog")
public class MTWorkLog implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 * , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19  
	 */
	protected long WorkID;
	
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
    @Column(name = "WorkID",  nullable = false,  length = 19)
   	public Long getWorkID() {
		return this.WorkID;
	}

	/** 主键 , 
	 * bigint  ,  
	 * PK ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setWorkID(Long WorkID) {
		this.WorkID = WorkID;
	}
	
	/** 
	 * 计划ID  , 
	 * varchar  ,     
	 * Length: 19   
	 * */
	protected Long PlanID;
	
	/**
	 * 计划ID  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 19
	 * @return
	 */ 
    @Column(name = "PlanID",  nullable = false,  length = 19)
   	public Long getPlanID() {
		return this.PlanID;
	}

	/** 
	 * 计划ID , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setPlanID(Long PlanID) {
		this.PlanID = PlanID;
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
	 * 签到ID  , 
	 * varchar  ,     
	 * Length: 19   
	 * */
	protected Long LocusID;
	
	/**
	 * 签到ID  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 19
	 * @return
	 */ 
    @Column(name = "LocusID",  nullable = false,  length = 19)
   	public Long getLocusID() {
		return this.LocusID;
	}

	/** 
	 * 签到ID , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setLocusID(Long LocusID) {
		this.LocusID = LocusID;
	}
	
	
	/** 
	 * 工作日志title , 
	 * varchar  ,     
	 * Length: 125   
	 * */
	protected String Title;
	
	/**
	 * 工作日志title  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 125
	 * @return
	 */ 
    @Column(name = "Title",  nullable = false,  length = 125)
   	public String getTitle() {
		return this.Title;
	}

	/** 
	 * 工作日志title , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 125   
	 */
	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	/** 
	 * 工作日志描述 , 
	 * varchar  ,     
	 * Length: 512   
	 * */
	protected String DescContent;
	
	/**
	 * 工作日志描述  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 512
	 * @return
	 */ 
    @Column(name = "DescContent",  nullable = false,  length = 512)
   	public String getDescContent() {
		return this.DescContent;
	}

	/** 
	 * 工作日志描述 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 512   
	 */
	public void setDescContent(String DescContent) {
		this.DescContent = DescContent;
	}
	
	/** 
	 * 工作日志时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * */
	protected java.sql.Timestamp LogDate;
	
	/**
	 * 工作日志时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * @return
	 */ 
    @Column(name = "LogDate",  nullable = true,  length = 30)
   	public java.sql.Timestamp getLogDate() {
		return this.LogDate;
	}

	/** 
	 * 工作日志时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00        
	 */
	public void setLogDate(java.sql.Timestamp LogDate) {
		this.LogDate = LogDate;
	}
	
	/** 
	 * 附件路径及文件名 , 
	 * varchar  ,     
	 * Length: 125   
	 * */
	protected String Attachment;
	
	/**
	 * 附件路径及文件名  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 125
	 * @return
	 */ 
    @Column(name = "Attachment",  nullable = false,  length = 125)
   	public String getAttachment() {
		return this.Attachment;
	}

	/** 
	 * 附件路径及文件名 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 125   
	 */
	public void setAttachment(String Attachment) {
		this.Attachment = Attachment;
	}
	
	/** 
	 * 附件总数  , 
	 * varchar  ,     
	 * Length: 19   
	 * */
	protected Long AccessoryCount;
	
	/**
	 * 附件总数  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 19
	 * @return
	 */ 
    @Column(name = "AccessoryCount",  nullable = false,  length = 19)
   	public Long getAccessoryCount() {
		return this.AccessoryCount;
	}

	/** 
	 * 附件总数 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setAccessoryCount(Long AccessoryCount) {
		this.AccessoryCount = AccessoryCount;
	}
	
	/**
	 * 字符串
	 */
	public String toString() {
		return  "主键 WorkID="+WorkID+" , "+  "职员ID EmpID="+EmpID+" , "+  "工作日志title Title="+Title+" , "+  "工作日志描述  DescContent="+DescContent 
				+" , "+  "工作日志时间 LogDate="+LogDate+" , "+  "附件路径及文件名 Attachment="+Attachment
				+",计划ID PlanID="+PlanID+",签到ID LocusID="+LocusID+",附件总数 AccessoryCount="+	AccessoryCount;
	}
	
	/**
	 * 对象克隆
	 */
	public Object clone() throws CloneNotSupportedException {
		MTWorkLog model = new MTWorkLog();
    		  model.setWorkID(this.WorkID);
    		  model.setPlanID(this.PlanID);
    		  model.setLocusID(this.LocusID); 
			  model.setEmpID(this.EmpID);
			  model.setTitle(this.Title);
			  model.setDescContent(this.DescContent); 
			  model.setLogDate(this.LogDate);
			  model.setAttachment(this.Attachment); 
			  model.setAccessoryCount(this.	AccessoryCount); 
			  return model;
	}
	
	public MTWorkLog()
	{
		
	}
	
	public MTWorkLog(Long WorkID)
	{
		super();
		this.WorkID = WorkID;
	}
	
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
