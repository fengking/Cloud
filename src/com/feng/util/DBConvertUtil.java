package com.feng.util;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.feng.common.util.PathUtil;
import com.feng.common.util.PropertiesUtil;

/**
 * 
 * 数据转换类
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class DBConvertUtil {
	private Log log = LogFactory.getLog(DBConvertUtil.class);
	/**
	 * 是否为空
	 */
	private static String NULLABLE = "isNullable";
	/**
	 *自增
	 */
	private static String IDENTITY = "isIdentityType";
	/**
	 *精度
	 */
	private static String PRECISION = "isPrecision";
	private static Map<String, String> map;
	private static DBConvertUtil convert = new DBConvertUtil();

	public static DBConvertUtil getInstance() {
		return convert;
	}

	public DBConvertUtil() {
		init();
	}

	public Map<String, String> getMap() {
		return map;
	}

	/**
	 * 数据库类型转换为java类型
	 * 
	 * @param dbtype
	 * @return
	 */
	public String dbType2JavaType(String dbtype) {
		if (map == null) {
			return null;
		} else {
			return map.get(dbtype);
		}
	}
	/**
	 * 判断是否需要取精度
	 * @param dbtype
	 * @return
	 */
	public boolean getPrecision(String dbtype) {
		if (map != null) {
			String precision = map.get(PRECISION);
			if (precision != null) {
				if (Arrays.binarySearch(precision.split(","), dbtype) >= 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 *是否自增
	 * 
	 * @param identity
	 * @return
	 */
	public boolean getIdentityType(String identity) {
		if (map != null) {
			String type = map.get(IDENTITY);
			if (type != null) {
				if (Arrays.binarySearch(type.split(","), identity) >= 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 是否允许为空
	 * @param nullable
	 * @return
	 */
	public boolean getNullable(String nullable) {
		if (map != null) {
			String type = map.get(NULLABLE);
			if (type != null) {
				if (Arrays.binarySearch(type.split(","), nullable) >= 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
   * 
   */
	public void init() {
		try {
			map = PropertiesUtil.getAllProperty(PathUtil.getInstance().getRealPath() + "db-convert.properties");
		} catch (Exception e) {
			log.error("加载properties文件失败", e);
		}
	}
}
