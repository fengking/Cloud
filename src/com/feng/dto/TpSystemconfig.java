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
 * table name: tp_systemconfig
 * table remark: 系统配置信息; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.507
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 */
@Entity
@Table(name = "tp_systemconfig")
public class TpSystemconfig implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//////////////////////////// Fields 1/////////////////////////////////////////
	
	  /** 项目生成路径  , varchar  ,     Length: 170   */
	    protected String  sprojgenpath;
	    
	  /** 项目代码  , varchar  ,  PK ,   NOT NULL  ,   Length: 36   */
	    protected String  sprojcode;
	    
	  /** 项目名称  , varchar  ,     Length: 21   */
	    protected String  sprojname;
	    

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public TpSystemconfig() {
	}

	/** minimal constructor */
	public TpSystemconfig( String sprojcode) {
		super();
		this.sprojcode = sprojcode;        
        }

	/** full constructor */
	public TpSystemconfig( String sprojgenpath, String sprojcode, String sprojname) {
		super();
		this.sprojgenpath = sprojgenpath;
		this.sprojcode = sprojcode;
		this.sprojname = sprojname;
	}
	
    // Property accessors
       /** 标准的annotation方式的主键生成策略如下 
       * AUTO - 可以是identity column类型,或者sequence类型或者table类型,取决于不同的底层数据库 
       * TABLE - 使用表保存id值（也就是会为应用的表创建一张专门保存Id的表，记录对应的表的对应最大的ID值 
       * IDENTITY - 自增 
       * SEQUENCE – sequence  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE") 
       **/
	
	/** 项目生成路径  , varchar  ,     Length: 170 */
    @Column(name = "S_PROJGENPATH",  nullable = true,  length = 170)
   	public String getSprojgenpath() {
		return this.sprojgenpath;
	}

	/** 项目生成路径 , varchar  ,    Length: 170   */
	public void setSprojgenpath(String sprojgenpath) {
		this.sprojgenpath = sprojgenpath;
	}
	
	/** 项目代码  , varchar  ,  PK ,   NOT NULL  ,   Length: 36 */
    @Id 
    @Column(name = "S_PROJCODE", unique = true, nullable = false,  length = 36)
   	public String getSprojcode() {
		return this.sprojcode;
	}

	/** 项目代码 , varchar  ,  PK ,   NOT NULL  , Length: 36   */
	public void setSprojcode(String sprojcode) {
		this.sprojcode = sprojcode;
	}
	
	/** 项目名称  , varchar  ,     Length: 21 */
    @Column(name = "S_PROJNAME",  nullable = true,  length = 21)
   	public String getSprojname() {
		return this.sprojname;
	}

	/** 项目名称 , varchar  ,    Length: 21   */
	public void setSprojname(String sprojname) {
		this.sprojname = sprojname;
	}

	public String toString() {
		return  "项目生成路径 sprojgenpath="+sprojgenpath+" , "+  "项目代码 sprojcode="+sprojcode+" , "+  "项目名称 sprojname="+sprojname;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    TpSystemconfig model = new TpSystemconfig();
	    		  model.setSprojgenpath(this.sprojgenpath);
				  model.setSprojcode(this.sprojcode);
				  model.setSprojname(this.sprojname);
				return model;
	}

	public void close() throws IOException {
	}
}