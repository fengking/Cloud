package com.feng.converter;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.aspectj.weaver.reflect.Java14GenericSignatureInformationProvider;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

/**
 * 日期自定义类型转换器
 * 
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 * 
 */
public class DateConverter extends DefaultTypeConverter {
	private static final String FROMDATE = "yyyy-MM-dd";
	private static final String FROMDATETIME = "yyyy-MM-dd HH:mm:ss";
	private static final String FORMATIME = "HH:mm:ss";

	@SuppressWarnings("unchecked")
	@Override
	public Object convertValue(Map<String, Object> context, Object value, Class toType) {
		
		try {
			SimpleDateFormat sdf = null;
				String[] params = (String[]) value;
					if(toType == java.sql.Time.class){
						sdf = new SimpleDateFormat(FORMATIME);
					}else if(toType == java.sql.Timestamp.class){
						sdf = new SimpleDateFormat(FROMDATETIME);
					}else{
						sdf = new SimpleDateFormat(FROMDATE);
					}
					if(toType == java.sql.Date.class){
						return new java.sql.Date(sdf.parse(params[0]).getTime());
					}else if (toType == Date.class) { // 当字符串向Date类型转换时
						return sdf.parse(params[0]);
					}else if(toType == java.sql.Timestamp.class){
						return new Timestamp(sdf.parse(params[0]).getTime());
					}else if(toType == java.sql.Time.class){
						return new Time(sdf.parse(params[0]).getTime());
					}else if(toType == String.class){ // 当Date转换成字符串时
						if(value instanceof java.sql.Timestamp){
						   sdf = new SimpleDateFormat(FROMDATETIME);
						}else if(value instanceof java.sql.Time){
						   sdf = new SimpleDateFormat(FORMATIME);
						}else{
						   sdf = new SimpleDateFormat(FROMDATE);
						}
						return sdf.format((Date) value);
					}
			
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}