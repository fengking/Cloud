package com.feng.pageModel;

import java.util.List;
import java.util.Map;

/**
 * 
 * jquery easyUI 树 定义
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class TreeModel implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 节点id
	 */
	private Integer id;
	 /**
	  * 节点名称
	  */
    private String text;
    /**
     * 节点状态
     */
    private String state = "open";
    /**
     * 是否被选中
     */
    private boolean checked;
    /**
     * 子树
     */
    private List<TreeModel> children;
    /**
     * 其它属性
     */
    private Map<String,String> attributes;
    
    /**
     * 图标
     */
    private String iconCls;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void setState(boolean state){
		this.state = state ? "open" : "closed";
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<TreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

}
