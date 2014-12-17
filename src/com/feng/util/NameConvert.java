package com.feng.util;

/**
 * 表名字段转换规则
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class NameConvert {
	/**
	 * 遇到下划线大写
	 */
	public static String UNDERLINE_TO_UPPERCASE = "UNDERLINE_TO_UPPERCASE";
	
	/**
	 * 忽略下划线,全小写
	 */
	public static String IGNORE_UNDERLINE = "IGNORE_UNDERLINE";
	
	/**
	 *  遇到下划线大写
	 */
	private String tableconvert = UNDERLINE_TO_UPPERCASE;
	/**
	 *  忽略下划线,全小写
	 */
	private String columnconvert = IGNORE_UNDERLINE;
	
	public NameConvert(String tableconvert,String columnconvert) {
		super();
		this.tableconvert = tableconvert;
		this.columnconvert = columnconvert;
	}
	
	public NameConvert(String convert){
		super();
		this.tableconvert = convert;
		this.columnconvert = convert;
	}

	/**
	 * 表名转换
	 * @param columnname
	 * @return
	 */
   public String tableConvert(String name){
	   name = name.toLowerCase();
	  if(tableconvert.equals(IGNORE_UNDERLINE)){ 
		 String str = name.replaceAll("_", "");
		 return String.valueOf(str.charAt(0)).toUpperCase()+str.substring(1);
	  }else if(tableconvert.equals(UNDERLINE_TO_UPPERCASE)){ 
		  StringBuffer sb = new StringBuffer();
		  String[]  strs = name.split("_");
		  for(String str : strs){
			  sb.append(String.valueOf(str.charAt(0)).toUpperCase());
			  if(str.length()>1){
				  sb.append(str.substring(1));
			  }
		  }
		  return sb.toString();
	  }
	  return name;
   }
   
   /**
    * 列明转换
    * @param name
    * @return
    */
   public String columnConvert(String name){
	   name = name.toLowerCase();
	   if(columnconvert.equals(IGNORE_UNDERLINE)){ 
			  return name.replaceAll("_", "").toLowerCase();
		  }else if(columnconvert.equals(UNDERLINE_TO_UPPERCASE)){ 
			  StringBuffer sb = new StringBuffer();
			  String[]  strs = name.split("_");
			  for(String str : strs){
				  sb.append(String.valueOf(str.charAt(0)).toUpperCase());
				  if(str.length()>1){
					  sb.append(str.substring(1));
				  }
			  }
			  return sb.toString();
		  }
		  return name;
   }
   
   public static void main(String[] args) {
	NameConvert convert = new NameConvert( UNDERLINE_TO_UPPERCASE);
	System.out.println(convert.columnConvert("tp_s_sd_serwer"));
  }
}
