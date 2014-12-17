package com.feng.pageModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import com.feng.common.util.BeanUtil;

/**
 * 
 * 数据属性定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class PropertyData implements Serializable {
  private String name;
  
  private Object value;
  
  private String group;
  
  private String editor;
  
  
public PropertyData(String name, Object value) {
	super();
	this.name = name;
	this.value = value;
	setEditor();
}

public PropertyData(String name, String group, String editor) {
	super();
	this.name = name;
	this.group = group;
	this.editor = editor;
	setEditor();
}

public PropertyData(String name, Object value, String group, String editor) {
	super();
	this.name = name;
	this.value = value;
	this.group = group;
	this.editor = editor;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Object getValue() {
	return value;
}

public void setValue(Object value) {
	this.value = value;
}

public String getGroup() {
	return group;
}

public void setGroup(String group) {
	this.group = group;
}

public String getEditor() {
	return editor;
}

public void setEditor(String editor){
	if("email".equals(editor)){
		this.editor ="{\"type\":\"validatebox\",\"options\":{\"validType\":\"email\"}}";
	}
	this.editor = editor;
}

public void setEditor() {
	if(value == null || value instanceof String){
		this.editor = "Text";
	}else if(value instanceof Timestamp){
		this.editor = "datetimebox";
	}else if(value instanceof Time){
		this.editor = "timespinner";
	}else if(value instanceof Date){
		this.editor = "datebox";
	}else if(value instanceof Integer || value instanceof Long){
		this.editor = "numberspinner";
	}else if(value instanceof Float || value instanceof Double || value instanceof BigDecimal){
		this.editor = "numberbox";
	}

}
  
  
}
