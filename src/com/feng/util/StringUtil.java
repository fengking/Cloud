package com.feng.util;

import java.util.Map;
import java.util.Map.Entry;

import com.feng.common.model.SqlCommonQto;
import com.feng.common.util.BeanUtil;
import com.feng.common.util.SqlUtil;
import com.feng.dto.TpUsers;

/**
 * 字符串工具类
 * 
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class StringUtil {
	/**
	 * ascii转换为字符串
	 * @param src
	 * @return
	 */
  public static String valueOf(String src){
	  return new String(src);
  }
  
  public static void main(String[] args) throws Exception {
	TpUsers u = new TpUsers();
	u.setSadminflag("1");
	u.setSprojgenpath("222");
	System.out.println(SqlUtil.getModelName(u.getClass()));
	SqlCommonQto qto = getSqlCommonQto(u);
	System.out.println(qto.getHql());
}
  
	/**
	 * 根据对象得到查询对象
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public static SqlCommonQto getSqlCommonQto(java.io.Serializable model) throws Exception{
		try{
			SqlCommonQto qto = new SqlCommonQto();
			Map<String,Object> map = BeanUtil.describeNullValue(model);
			if(map == null || map.isEmpty()){
				qto.setHql("select m from Model");
				return qto;
			}
			StringBuffer sb = new StringBuffer(" (");
			for(Entry<String, Object> e : map.entrySet()){
				sb.append(" m.").append(e.getKey()).append("=? and");
				qto.addParams(e.getValue());
			}
			sb.delete( sb.length()-3, sb.length()).append(") ");
			qto.setHql("select m from Model where "+sb.toString());
			qto.setWherehsql(sb.toString());
			return qto;
		}catch(Exception e){
			throw e;
		}
	}
  
}
