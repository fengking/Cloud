package com.feng.util;

/**
 * 
 * 列定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class ColumnInfo {
	
   /**
    * 列名
    */
	private String columnname;
	
	/**
	 *列中文名
	 */
	private String columncname;
	
	/**
	 *主键
	 */
	private boolean pks;
	
	/**
	 * 总精度
	 */
	private Integer precision;
	
	/**
	 * 精度
	 */
	private Integer scale;
	
	/**
	 * java类型
	 */
	private String javatype;
	
	/**
	 * 数据库类型
	 */
	private String datatype;
	
	/**
	 * 自增
	 */
	private boolean identity;
	
	/**
	 *是否为空
	 */
	private boolean isnulls;
	
	/**
	 *长度
	 */
	private Long length;
	
	/**
	 *属性名
	 */
	private String propertyname;
	
	/**
	 * 默认值
	 */
	private String defaults;
	
	/**
	 * 
	 * @param columnname  列英文名
	 * @param columncname  列中文名
	 * @param datatype 数据类型
	 * @param length 长度
	 */
	public ColumnInfo(String columnname, String columncname,String datatype, Long length) {
		super();
		this.columnname = columnname;
		this.columncname = columncname;
		this.datatype = datatype;
		this.length = length;
	}

	public String getColumnname() {
		return columnname;
	}

	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}

	public String getColumncname() {
		return columncname;
	}

	public void setColumncname(String columncname) {
		this.columncname = columncname;
	}

	public boolean getPks() {
		return pks;
	}

	public void setPks(boolean pks) {
		this.pks = pks;
	}

	public String getJavatype() {
		return javatype;
	}

	public void setJavatype(String javatype) {
		this.javatype = javatype;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public boolean getIdentity() {
		return identity;
	}

	public void setIdentity(boolean identity) {
		this.identity = identity;
	}

	public boolean getIsnulls() {
		return isnulls;
	}

	public void setIsnulls(boolean isnulls) {
		this.isnulls = isnulls;
	}
	
	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public String getPropertyname() {
		return propertyname;
	}

	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}

	public Integer getPrecision() {
		return precision;
	}

	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public String getDefaults() {
		return defaults;
	}

	public void setDefaults(String defaults) {
		this.defaults = defaults;
	}
	
}
