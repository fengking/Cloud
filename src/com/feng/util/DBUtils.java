package com.feng.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.feng.dto.TpDbquery;
import com.feng.dto.TpProject;

/**
 * 
 * 数据库连接类
 * @author fengking (http://fengkinglbs.duapp.com/)
 * @version 1.0
 * @created 2014-10-1 
 *
 */
public class DBUtils {
	private Log log = LogFactory.getLog(DBUtils.class);
     private Connection conn;
     private String dbuser;
     private String dbpwd;
     private String dburl;
     private String dbschema;
     private TpDbquery dbquery;
     private NameConvert nameconvert;
     
     
     public DBUtils( String dbuser, String dbpwd, String dburl, TpDbquery dbquery){
    	 super();
  	     this.dburl = dburl;
  	     this.dbuser = dbuser;
  	     this.dbpwd = dbpwd;
  	     this.dbquery = dbquery;
     }
     
     public DBUtils(TpProject project, TpDbquery dbquery){
    	 super();
  	     this.dburl = project.getSdburl();
  	     this.dbuser = project.getSdbname();
  	     this.dbpwd = project.getSdbpwd();
  	     this.dbschema = project.getSdbschema();
  	     this.dbquery = dbquery;
     }
     
	public DBUtils(String dbuser,String dbpwd,String dburl) {
	   super();
	   this.dburl = dburl;
	   this.dbuser = dbuser;
	   this.dbpwd = dbpwd;
	}
	
	public void getConnection() throws Exception{
		try {
			log.debug("创建数据库连接...");
			Class.forName(dbquery.getSjdbcclass()).newInstance();
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
		} catch (Exception e) {
			log.error("connect to db error!", e);
			throw e;
		}
	}
	
	/**
	 * find tables
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<TableInfo> findTableList(String tabname) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		getConnection();
		try{
		  log.debug("查询表:"+dbquery.getSquerytabinfo());
		  ps = conn.prepareStatement(dbquery.getSquerytabinfo());
		  ps.setString( 1, tabname);
		  ps.setString( 2, dbschema);
		  rs = ps.executeQuery();
		  if(rs == null){
			  return null;
		  }
		  List<TableInfo> list = new ArrayList<TableInfo>();
		  TableInfo table = null;
		  while(rs.next()){
			  table = new TableInfo( rs.getString(1), rs.getString(2));
			  table.setModelname(nameconvert.tableConvert(rs.getString(1)));
//			  table.setColumns( findColumnInfo(rs.getString(1)));
			  list.add(table);
		  }
		  return list;
		}catch (Exception e) {
		  log.error("query base table info error!", e);
		  throw e;
		}finally{
			if(rs != null){
				try{
				  rs.close();
				}catch (Exception e) {
					 log.error("close ResultSet error!", e);
				}
			}if(ps != null){
				try{
				  ps.close();
				}catch (Exception e) {
					 log.error("close PreparedStatement error!", e);
				}
			}
		}
	}
	
	/**
	 * query column info
	 * @param tabname
	 * 列英文名 列中文名 数据类型 长度 (precision) 是否自增 是否为空 默认值 精点
	 * @return
	 * @throws Exception
	 */
	public List<ColumnInfo> findColumnInfo(String tabname) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		getConnection();
		try{
		  log.debug("查询列:"+dbquery.getSquerycolumn());
		  ps = conn.prepareStatement(dbquery.getSquerycolumn());
		  ps.setString( 1, tabname);
		  ps.setString( 2, dbschema);
		  rs = ps.executeQuery();
		  if(rs == null){
			  return null;
		  }
		  List<ColumnInfo> list = new ArrayList<ColumnInfo>();
		  ColumnInfo column = null;
		  List<String> pkList = findPkList(tabname);
		  while(rs.next()){
			  //列英文名  列中文名 数据类型 长度
			  column = new ColumnInfo( rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4));
			  column.setJavatype(DBConvertUtil.getInstance().dbType2JavaType(rs.getString(3)));//数据类型
			  column.setIdentity(DBConvertUtil.getInstance().getIdentityType(rs.getString(5)));//自增
			  column.setIsnulls(DBConvertUtil.getInstance().getNullable(rs.getString(6)));//是否为空
			  column.setDefaults(rs.getString(7));//默认值
			  column.setPrecision(null);//长度
			  column.setScale(null);//精度
			  if(DBConvertUtil.getInstance().getPrecision(rs.getString(3))){
				  column.setPrecision(rs.getInt(4));//长度4
				  column.setScale(rs.getInt(8));//精度8
			  }
			  column.setPks( pkList.contains( rs.getString(1)));
			  column.setPropertyname(nameconvert.columnConvert(rs.getString(1)));
			  list.add(column);
		  }
		  return list;
		}catch (Exception e) {
		  log.error("query columns info error!", e);
		  throw e;
		}finally{
			if(rs != null){
				try{
				  rs.close();
				}catch (Exception e) {
					 log.error("close ResultSet error!", e);
				}
			}if(ps != null){
				try{
				  ps.close();
				}catch (Exception e) {
					 log.error("close PreparedStatement error!", e);
				}
			}
		}
	}
	
	/**
	 * query pk info
	 * @param tabname
	 * @return
	 * @throws Exception
	 */
	public List<String> findPkList(String tabname) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		getConnection();
		try{
		  ps = conn.prepareStatement(dbquery.getSquerypk());
		  ps.setString( 1, tabname.toUpperCase());
		  ps.setString( 2, dbschema.toUpperCase());
		  rs = ps.executeQuery();
		  if(rs == null){
			  return null;
		  }
		  List<String> list = new ArrayList<String>();
		  while(rs.next()){
			  list.add(rs.getString(1));
		  }
		  return list;
		}catch (Exception e) {
		  log.error("query pk error!", e);
		  throw e;
		}finally{
			if(rs != null){
				try{
				  rs.close();
				}catch (Exception e) {
					 log.error("close ResultSet error!", e);
				}
			}if(ps != null){
				try{
				  ps.close();
				}catch (Exception e) {
					 log.error("close PreparedStatement error!", e);
				}
			}if(conn != null){
				try{
				  conn.close();
				}catch (Exception e) {
					 log.error("close Connection error!", e);
				}
			}
		}
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getDbuser() {
		return dbuser;
	}

	public void setDbuser(String dbuser) {
		this.dbuser = dbuser;
	}

	public String getDbpwd() {
		return dbpwd;
	}

	public void setDbpwd(String dbpwd) {
		this.dbpwd = dbpwd;
	}

	public String getDburl() {
		return dburl;
	}

	public void setDburl(String dburl) {
		this.dburl = dburl;
	}

	public String getDbschema() {
		return dbschema;
	}

	public void setDbschema(String dbschema) {
		this.dbschema = dbschema;
	}

	public TpDbquery getDbquery() {
		return dbquery;
	}

	public void setDbquery(TpDbquery dbquery) {
		this.dbquery = dbquery;
	}

	public NameConvert getNameconvert() {
		return nameconvert;
	}

	public void setNameconvert(NameConvert nameconvert) {
		this.nameconvert = nameconvert;
	}
          
}
