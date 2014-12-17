package com.feng.dto;

import java.sql.*;
import java.io.IOException;
import java.lang.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

                
/**
 * table name: tp_enumdata
 * table remark: 枚举值值; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.46
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 */
@Entity
@Table(name = "tp_enumdata")
public class TpEnumdata implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//////////////////////////// Fields 2/////////////////////////////////////////
	
	  /** 枚举值编号  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19   */
	    protected Long  ienumclass;
	    
	  /** 枚举值代码  , varchar  ,  PK ,   NOT NULL  ,   Length: 10   */
	    protected String  senumcode;
	    
	  /** 枚举值说明  , varchar  ,     Length: 42   */
	    protected String  senumname;
	    
	  /** 枚举值备注  , varchar  ,     Length: 170   */
	    protected String  senumremark;
	    
	  /** 开始时间  , timestamp  ,     Length: 30  Default:CURRENT_TIMESTAMP */
	    protected java.sql.Timestamp  tsstartdate;
	    
	  /** 系统更新时间  , timestamp  ,     Length: 30  Default:0000-00-00 00:00:00 */
	    protected java.sql.Timestamp  tssysupdate;
	    

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public TpEnumdata() {
	}

	/** minimal constructor */
	public TpEnumdata( Long ienumclass, String senumcode) {
		super();
		this.ienumclass = ienumclass;		this.senumcode = senumcode;        
        }

	/** full constructor */
	public TpEnumdata( Long ienumclass, String senumcode, String senumname, String senumremark, java.sql.Timestamp tsstartdate, java.sql.Timestamp tssysupdate) {
		super();
		this.ienumclass = ienumclass;
		this.senumcode = senumcode;
		this.senumname = senumname;
		this.senumremark = senumremark;
		this.tsstartdate = tsstartdate;
		this.tssysupdate = tssysupdate;
	}
	
    // Property accessors
       /** 标准的annotation方式的主键生成策略如下 
       * AUTO - 可以是identity column类型,或者sequence类型或者table类型,取决于不同的底层数据库 
       * TABLE - 使用表保存id值（也就是会为应用的表创建一张专门保存Id的表，记录对应的表的对应最大的ID值 
       * IDENTITY - 自增 
       * SEQUENCE – sequence  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE") 
       **/
	
	/** 枚举值编号  , bigint  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 19 */
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "I_ENUMCLASS",  nullable = false,  length = 19)
   	public Long getIenumclass() {
		return this.ienumclass;
	}

	/** 枚举值编号 , bigint  ,  PK ,   NOT NULL  , Length: 19   */
	public void setIenumclass(Long ienumclass) {
		this.ienumclass = ienumclass;
	}
	
	/** 枚举值代码  , varchar  ,  PK ,   NOT NULL  ,   Length: 36 */
    @Id 
    @Column(name = "S_ENUMCODE", nullable = false,  length = 36)
   	public String getSenumcode() {
		return this.senumcode;
	}

	/** 枚举值代码 , varchar  ,  PK ,   NOT NULL  , Length: 36   */
	public void setSenumcode(String senumcode) {
		this.senumcode = senumcode;
	}
	
	/** 枚举值说明  , varchar  ,     Length: 42 */
    @Column(name = "S_ENUMNAME",  nullable = true,  length = 42)
   	public String getSenumname() {
		return this.senumname;
	}

	/** 枚举值说明 , varchar  ,    Length: 42   */
	public void setSenumname(String senumname) {
		this.senumname = senumname;
	}
	
	/** 枚举值备注  , varchar  ,     Length: 170 */
    @Column(name = "S_ENUMREMARK",  nullable = true,  length = 170)
   	public String getSenumremark() {
		return this.senumremark;
	}

	/** 枚举值备注 , varchar  ,    Length: 170   */
	public void setSenumremark(String senumremark) {
		this.senumremark = senumremark;
	}
	
	/** 开始时间  , timestamp  ,     Length: 30 */
    @Column(name = "TS_STARTDATE",  nullable = true,  length = 30)
   	public java.sql.Timestamp getTsstartdate() {
		return this.tsstartdate;
	}

	/** 开始时间 , timestamp  ,    Length: 30   */
	public void setTsstartdate(java.sql.Timestamp tsstartdate) {
		this.tsstartdate = tsstartdate;
	}
	
	/** 系统更新时间  , timestamp  ,     Length: 30 */
    @Column(name = "TS_SYSUPDATE",  nullable = true,  length = 30)
   	public java.sql.Timestamp getTssysupdate() {
		return this.tssysupdate;
	}

	/** 系统更新时间 , timestamp  ,    Length: 30   */
	public void setTssysupdate(java.sql.Timestamp tssysupdate) {
		this.tssysupdate = tssysupdate;
	}

	public String toString() {
		return  "枚举值编号 ienumclass="+ienumclass+" , "+  "枚举值代码 senumcode="+senumcode+" , "+  "枚举值说明 senumname="+senumname+" , "+  "枚举值备注 senumremark="+senumremark+" , "+  "开始时间 tsstartdate="+tsstartdate+" , "+  "系统更新时间 tssysupdate="+tssysupdate;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    TpEnumdata model = new TpEnumdata();
	    		  model.setIenumclass(this.ienumclass);
				  model.setSenumcode(this.senumcode);
				  model.setSenumname(this.senumname);
				  model.setSenumremark(this.senumremark);
				  model.setTsstartdate(this.tsstartdate);
				  model.setTssysupdate(this.tssysupdate);
				return model;
	}

	public void close() throws IOException {
	}
}