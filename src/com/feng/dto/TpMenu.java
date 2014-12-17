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
 * table name: tp_menu
 * table remark: 菜单; InnoDB free: 12288 kB
 * generate Time: 2014-05-09 16:02:09.491
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 */
@Entity
@Table(name = "tp_menu")
public class TpMenu implements java.io.Serializable,java.io.Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//////////////////////////// Fields 1/////////////////////////////////////////
	
	  /** 菜单id  , int  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 10   */
	    protected Integer  imenuid;
	    
	  /** 菜单名称  , varchar  ,     Length: 42   */
	    protected String  smenuname;
	    
	  /** 菜单url  , varchar  ,     Length: 255   */
	    protected String  smenuurl;
	    
	  /** 上级菜单url  , int  ,     Length: 10   */
	    protected Integer  isupermenuid;
	    

//////////////////////////////////////////////////////////////////////////////

	/** default constructor */
	public TpMenu() {
	}

	/** minimal constructor */
	public TpMenu( Integer imenuid) {
		super();
		this.imenuid = imenuid;        
        }

	/** full constructor */
	public TpMenu( Integer imenuid, String smenuname, String smenuurl, Integer isupermenuid) {
		super();
		this.imenuid = imenuid;
		this.smenuname = smenuname;
		this.smenuurl = smenuurl;
		this.isupermenuid = isupermenuid;
	}
	
    // Property accessors
       /** 标准的annotation方式的主键生成策略如下 
       * AUTO - 可以是identity column类型,或者sequence类型或者table类型,取决于不同的底层数据库 
       * TABLE - 使用表保存id值（也就是会为应用的表创建一张专门保存Id的表，记录对应的表的对应最大的ID值 
       * IDENTITY - 自增 
       * SEQUENCE – sequence  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE") 
       **/
	
	/** 菜单id  , int  ,  PK ,   NOT NULL  ,  Identity  ,   Length: 10 */
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "I_MENUID",  nullable = false,  length = 10)
   	public Integer getImenuid() {
		return this.imenuid;
	}

	/** 菜单id , int  ,  PK ,   NOT NULL  , Length: 10   */
	public void setImenuid(Integer imenuid) {
		this.imenuid = imenuid;
	}
	
	/** 菜单名称  , varchar  ,     Length: 42 */
    @Column(name = "S_MENUNAME",  nullable = true,  length = 42)
   	public String getSmenuname() {
		return this.smenuname;
	}

	/** 菜单名称 , varchar  ,    Length: 42   */
	public void setSmenuname(String smenuname) {
		this.smenuname = smenuname;
	}
	
	/** 菜单url  , varchar  ,     Length: 255 */
    @Column(name = "S_MENUURL",  nullable = true,  length = 255)
   	public String getSmenuurl() {
		return this.smenuurl;
	}

	/** 菜单url , varchar  ,    Length: 255   */
	public void setSmenuurl(String smenuurl) {
		this.smenuurl = smenuurl;
	}
	
	/** 上级菜单url  , int  ,     Length: 10 */
    @Column(name = "I_SUPERMENUID",  nullable = true,  length = 10)
   	public Integer getIsupermenuid() {
		return this.isupermenuid;
	}

	/** 上级菜单url , int  ,    Length: 10   */
	public void setIsupermenuid(Integer isupermenuid) {
		this.isupermenuid = isupermenuid;
	}

	public String toString() {
		return  "菜单id imenuid="+imenuid+" , "+  "菜单名称 smenuname="+smenuname+" , "+  "菜单url smenuurl="+smenuurl+" , "+  "上级菜单url isupermenuid="+isupermenuid;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    TpMenu model = new TpMenu();
	    		  model.setImenuid(this.imenuid);
				  model.setSmenuname(this.smenuname);
				  model.setSmenuurl(this.smenuurl);
				  model.setIsupermenuid(this.isupermenuid);
				return model;
	}

	public void close() throws IOException {
	}
}