package com.feng.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* table name: mt_WorkPlan
* table remark: 工作计划表; InnoDB free: 12288 kB
* generate Time: 2014-05-09 16:02:09.179
* @author fengking (http://fengkinglbs.duapp.com/)
* @version 1.0
* @created 2014-10-1 
*/
@Entity
@Table(name = "mt_WorkPlan")
public class MTWorkPlan implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19  
	 */
	protected long PlanID;
	
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
    @Column(name = "PlanID",  nullable = false,  length = 19)
   	public Long getPlanID() {
		return this.PlanID;
	}

	/** 主键 , 
	 * bigint  ,  
	 * PK ,   
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
	 * 标题 , 
	 * varchar  ,     
	 * Length: 125   
	 * */
	protected String Title;
	
	/**
	 * 标题  , 
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
	 * 标题 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 125   
	 */
	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	/** 
	 * 内容 , 
	 * varchar  ,     
	 * Length: 512   
	 * */
	protected String Descs;
	
	/**
	 * 内容  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 512
	 * @return
	 */ 
    @Column(name = "Descs",  nullable = false,  length = 512)
   	public String getDescs() {
		return this.Descs;
	}

	/** 
	 * 内容 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 512   
	 */
	public void setDescs(String Descs) {
		this.Descs = Descs;
	}
	
	/** 
	 * 计划时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * */
	protected java.sql.Timestamp PlanDate;
	
	/**
	 * 计划时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * @return
	 */ 
    @Column(name = "PlanDate",  nullable = true,  length = 30)
   	public java.sql.Timestamp getPlanDate() {
		return this.PlanDate;
	}

	/** 
	 * 计划时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00        
	 */
	public void setPlanDate(java.sql.Timestamp PlanDate) {
		this.PlanDate = PlanDate;
	}
	
	/** 
	 * 提交时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * */
	protected java.sql.Timestamp SubmitDateTime;
	
	/**
	 * 提交时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00  
	 * @return
	 */ 
    @Column(name = "SubmitDateTime",  nullable = true,  length = 30)
   	public java.sql.Timestamp getSubmitDateTime() {
		return this.SubmitDateTime;
	}

	/** 
	 * 提交时间,
	 *  timestamp  ,     
	 *  Length: 30  Default:0000-00-00 00:00:00        
	 */
	public void setSubmitDateTime(java.sql.Timestamp SubmitDateTime) {
		this.SubmitDateTime = SubmitDateTime;
	}
	
	public MTWorkPlan()
	{
		
	}
	public MTWorkPlan(Long PlanID)
	{
		super();
		this.PlanID=PlanID;
	}
	
	/**
	 * 字符串
	 */
	public String toString() {
		return  "主键 PlanID="+PlanID+" , "+  "职员ID EmpID="+EmpID+" , "+  "标题 Title="+Title+" , "+  "内容  Descs="+Descs 
				+" , "+  "计划时间 PlanDate="+PlanDate+" , "+  "提交时间 SubmitDateTime="+SubmitDateTime;
	}
	
	/**
	 * 对象克隆
	 */
	public Object clone() throws CloneNotSupportedException {
		MTWorkPlan model = new MTWorkPlan();
    		  model.setPlanID(this.PlanID); 
			  model.setEmpID(this.EmpID);
			  model.setTitle(this.Title);
			  model.setDescs(this.Descs); 
			  model.setPlanDate(this.PlanDate);
			  model.setSubmitDateTime(this.SubmitDateTime);  
			  return model;
	}
	
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
