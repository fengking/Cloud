package com.feng.gen;

import java.io.File;
import java.io.StringWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.aspectj.util.FileUtil;

import com.feng.common.util.PathUtil;
import com.feng.dto.TpDbquery;
import com.feng.pageModel.Config;
import com.feng.util.ColumnInfo;
import com.feng.util.DBConvertUtil;
import com.feng.util.DBUtils;
import com.feng.util.NameConvert;
import com.feng.util.StringUtil;
import com.feng.util.TableInfo;

/**
 * 
 * 源码生成定义类
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class Generate {
	static VelocityContext context = new VelocityContext();
	static {
		try {
			//加载属性 
	        Properties properties = new Properties();  
	       
			if(PathUtil.getInstance().isInJarFile()){//判断是否在jar中
				
			}else{
		        properties.setProperty("resource.loader", "class");  
		        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			}
			properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
			properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
			properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");    
			Velocity.init(properties);
		} catch (Exception e) {
			System.out.println("设置velocity属性错误: " + e);
			System.exit(-1);
		}
	}
	
   /**
    * 生成模板文件
    * @param vm
    * @param list
    * @param map
    */
	public String generate(String vm, Map<String,Object> map) throws Exception{
		StringWriter writer = new StringWriter();
		for(Entry<String,Object> e : map.entrySet()){
			context.put(e.getKey(), e.getValue());
		}
		context.put("generatetime", new Timestamp(System.currentTimeMillis()));
		context.put("modeldesc", Config.getInstance().getModeldesc());
		Velocity.mergeTemplate(vm, "UTF-8", context, writer);
		return writer.toString();
	}
	
	public static void main(String[] args) throws Exception {
		
		DBUtils util = new DBUtils("root","root", "jdbc:mysql://localhost:3306/fkcloud?useUnicode=true&characterEncoding=UTF-8");
		util.setNameconvert(new NameConvert(NameConvert.UNDERLINE_TO_UPPERCASE, NameConvert.IGNORE_UNDERLINE));
	    TpDbquery query = new TpDbquery("mysql", "select TABLE_NAME,TABLE_COMMENT from information_schema.TABLES where TABLE_TYPE='BASE TABLE' and TABLE_NAME like ? and TABLE_SCHEMA = ?", "select COLUMN_NAME,COLUMN_COMMENT,DATA_TYPE,case when CHARACTER_MAXIMUM_LENGTH is null then NUMERIC_PRECISION else CHARACTER_MAXIMUM_LENGTH end,EXTRA,IS_NULLABLE,COLUMN_DEFAULT  from information_schema.COLUMNS where  TABLE_NAME=? and TABLE_SCHEMA=?", "select COLUMN_NAME  from information_schema.COLUMNS where COLUMN_KEY = 'PRI' and TABLE_NAME=? and TABLE_SCHEMA=?", "com.mysql.jdbc.Driver", "", "", "fkcloud", new Timestamp(System.currentTimeMillis()));
		util.setDbquery(query);
		util.setDbschema("fkcloud");
		Map<String,Object> map = new HashMap<String, Object>();
	
	   List<TableInfo> tableList = util.findTableList("%");
	   for(TableInfo table: tableList){
		map.put("table", table);
		String javaString = new Generate().generate("com/feng/vm/hibernate/model.vm", map);
		FileUtil.writeAsString(new File("d:\\"+table.getModelname()+".java"), javaString);
	   }
	}
}
