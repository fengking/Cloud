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
@Table(name = "mt_FeedBack")
public class MTFeedBack implements java.io.Serializable,java.io.Closeable{

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
	 * 手机号码 , 
	 * varchar  ,     
	 * Length: 20   
	 * */
	protected String Phone;
	
	/**
	 * 手机号码  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 20
	 * @return
	 */ 
    @Column(name = "Phone",  nullable = false,  length = 20)
   	public String getPhone() {
		return this.Phone;
	}

	/** 
	 * 手机号码 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 20   
	 */
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	
	/** 
	 * 手机号码 , 
	 * varchar  ,     
	 * Length: 125   
	 * */
	protected String Title;
	
	/**
	 * 手机号码  , 
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
	 * 手机号码 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 125   
	 */
	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	/** 
	 * 反馈信息 , 
	 * varchar  ,     
	 * Length: 125   
	 * */
	protected String Feedback;
	
	/**
	 * 反馈信息  , 
	 * varchar  ,   
	 * NOT NULL  ,  
	 * Identity  ,   
	 * Length: 125
	 * @return
	 */ 
    @Column(name = "Feedback",  nullable = false,  length = 125)
   	public String getFeedback() {
		return this.Feedback;
	}

	/** 
	 * 反馈信息 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 125   
	 */
	public void setFeedback(String Feedback) {
		this.Feedback = Feedback;
	}
	
	/** 
	 * 添加人  , 
	 * varchar  ,     
	 * Length: 19   
	 * */
	protected Long EmpID;
	
	/**
	 * 添加人  , 
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
	 * 添加人 , 
	 * varchar  ,   
	 * NOT NULL  , 
	 * Length: 19   
	 */
	public void setEmpID(Long EmpID) {
		this.EmpID = EmpID;
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
	
	public MTFeedBack()
	{
		
	}
	
	public MTFeedBack(Long FID)
	{
		super();
		this.FID=FID; 
	}
	
	/**
	 * 字符串
	 */
	public String toString() {
		return  "主键 FID="+FID+" , "+  "手机号码 Phone="+Phone+" , "+  "主题 Title="+Title+" , "+  "反馈信息 Feedback="+Feedback 
				+" ,员工号 EmpID="+EmpID+  " , "+  "状态(0无效，1有效) Status="+Status ;
	}
	
	/**
	 * 对象克隆
	 */
	public Object clone() throws CloneNotSupportedException {
		MTFeedBack model = new MTFeedBack();
    		  model.setFID(this.FID);
			  model.setPhone(this.Phone);
			  model.setTitle(this.Title);
			  model.setFeedback(this.Feedback);
			  model.setEmpID(this.EmpID);  
			  model.setStatus(this.Status); 
			  return model;
	}
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
