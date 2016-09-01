-- phpMyAdmin SQL Dump
-- version phpStudy 2014
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 12 月 18 日 09:14
-- 服务器版本: 5.5.36
-- PHP 版本: 5.3.28

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `fkcloud`
--

-- --------------------------------------------------------

--
-- 表的结构 `mt_appinfo`
--

CREATE TABLE IF NOT EXISTS `mt_appinfo` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FAppURL` varchar(50) NOT NULL,
  `FCreateDate` datetime DEFAULT NULL,
  `FName_CHS` varchar(50) NOT NULL,
  `FName_CHT` varchar(50) NOT NULL,
  `FName_EN` varchar(50) NOT NULL,
  `FUpdateDate` datetime DEFAULT NULL,
  `FVersionCode` varchar(50) NOT NULL,
  `FVersionName` varchar(50) NOT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `mt_company`
--

CREATE TABLE IF NOT EXISTS `mt_company` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FCode` varchar(21) DEFAULT NULL,
  `FName` varchar(36) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `AdminEmail` varchar(30) NOT NULL,
  `AdminIM` varchar(20) DEFAULT NULL,
  `AdminIMType` varchar(1) DEFAULT NULL,
  `AdminMobile` varchar(15) NOT NULL,
  `AdminName` varchar(10) NOT NULL,
  `ApplyDate` datetime DEFAULT NULL,
  `AuditState` varchar(1) DEFAULT NULL,
  `Tel` varchar(20) DEFAULT NULL,
  `WebSite` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `mt_dept`
--

CREATE TABLE IF NOT EXISTS `mt_dept` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FCode` varchar(20) NOT NULL,
  `FName` varchar(50) NOT NULL,
  `CreateDateTime` datetime DEFAULT NULL,
  `ParentID` bigint(20) NOT NULL,
  `Remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `mt_emp`
--

CREATE TABLE IF NOT EXISTS `mt_emp` (
  `FID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID（自增）',
  `FNO` varchar(20) DEFAULT NULL COMMENT '工号',
  `MSISDN` varchar(20) DEFAULT NULL COMMENT ' ',
  `UserName` varchar(20) DEFAULT NULL COMMENT ' ',
  `EmpName` varchar(15) DEFAULT NULL COMMENT ' ',
  `Gender` int(11) DEFAULT NULL COMMENT '性别\r\n            1: 男（male）\r\n            0：女(female)\r\n            ',
  `Email` varchar(20) DEFAULT NULL COMMENT '电子邮箱',
  `DeptID` int(11) DEFAULT NULL COMMENT '部门ID',
  `Pwd` varchar(50) DEFAULT NULL COMMENT '密码(加密)',
  `Status` int(11) DEFAULT NULL COMMENT '员工状态，默认为启用\r\n            0：禁用\r\n            1：启用\r\n            ',
  `DeviceToken` varchar(50) DEFAULT NULL COMMENT '设备唯一编码',
  `Phonenumber` varchar(50) DEFAULT NULL COMMENT '获取到的手机号码',
  `InstallAction` varchar(50) DEFAULT NULL COMMENT '安装记录唯一码',
  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `Remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='员工信息' AUTO_INCREMENT=21 ;

 

-- --------------------------------------------------------

--
-- 表的结构 `mt_empdevice`
--

CREATE TABLE IF NOT EXISTS `mt_empdevice` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FEmpID` bigint(20) NOT NULL,
  `DeviceOS` varchar(80) NOT NULL,
  `DeviceToken` varchar(80) NOT NULL,
  `DeviceUA` varchar(100) NOT NULL,
  `DeviceUID` varchar(80) NOT NULL,
  `RegDate` datetime DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `mt_feedback`
--

CREATE TABLE IF NOT EXISTS `mt_feedback` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EmpID` bigint(20) NOT NULL,
  `Feedback` varchar(125) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Status` bigint(20) DEFAULT NULL,
  `Title` varchar(125) NOT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `mt_location`
--

CREATE TABLE IF NOT EXISTS `mt_location` (
  `LocID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EmpID` bigint(20) NOT NULL,
  `Latitude` double NOT NULL,
  `LocAddress` varchar(125) NOT NULL,
  `Longitude` double NOT NULL,
  `RecDateTime` datetime DEFAULT NULL,
  `Remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`LocID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `mt_point`
--

CREATE TABLE IF NOT EXISTS `mt_point` (
  `PointID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AddDateTime` datetime DEFAULT NULL,
  `AddEmpID` bigint(20) NOT NULL,
  `Description` varchar(125) NOT NULL,
  `Latitude` double NOT NULL,
  `LocAddress` varchar(125) NOT NULL,
  `Longitude` double NOT NULL,
  `PointName` varchar(125) NOT NULL,
  `PointTypeID` bigint(20) NOT NULL,
  `Status` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`PointID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `mt_pointtype`
--

CREATE TABLE IF NOT EXISTS `mt_pointtype` (
  `PointTypeID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PointTypeName` varchar(125) NOT NULL,
  PRIMARY KEY (`PointTypeID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `mt_worklog`
--

CREATE TABLE IF NOT EXISTS `mt_worklog` (
  `WorkID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AccessoryCount` bigint(20) NOT NULL,
  `Attachment` varchar(125) NOT NULL,
  `DescContent` longtext NOT NULL,
  `EmpID` bigint(20) NOT NULL,
  `LocusID` bigint(20) NOT NULL,
  `LogDate` datetime DEFAULT NULL,
  `PlanID` bigint(20) NOT NULL,
  `Title` varchar(125) NOT NULL,
  PRIMARY KEY (`WorkID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `mt_workplan`
--

CREATE TABLE IF NOT EXISTS `mt_workplan` (
  `PlanID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Descs` longtext NOT NULL,
  `EmpID` bigint(20) NOT NULL,
  `PlanDate` datetime DEFAULT NULL,
  `SubmitDateTime` datetime DEFAULT NULL,
  `Title` varchar(125) NOT NULL,
  PRIMARY KEY (`PlanID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `tl_log`
--

CREATE TABLE IF NOT EXISTS `tl_log` (
  `I_LOGID` bigint(20) NOT NULL AUTO_INCREMENT,
  `S_CLASSNAME` varchar(100) DEFAULT NULL,
  `S_DESC` longtext,
  `S_IP` varchar(36) DEFAULT NULL,
  `S_METHODNAME` varchar(125) DEFAULT NULL,
  `S_PROCEEDSTATE` varchar(1) DEFAULT NULL,
  `S_PROPTYPE` varchar(1) DEFAULT NULL,
  `S_USERCODE` varchar(36) DEFAULT NULL,
  `S_USERNAME` varchar(21) DEFAULT NULL,
  `TS_ENDDATE` datetime DEFAULT NULL,
  `TS_STARTDATE` datetime DEFAULT NULL,
  `TS_SYSUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`I_LOGID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=205 ;

--
-- 转存表中的数据 `tl_log`
--

INSERT INTO `tl_log` (`I_LOGID`, `S_CLASSNAME`, `S_DESC`, `S_IP`, `S_METHODNAME`, `S_PROCEEDSTATE`, `S_PROPTYPE`, `S_USERCODE`, `S_USERNAME`, `TS_ENDDATE`, `TS_STARTDATE`, `TS_SYSUPDATE`) VALUES
(1, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=null , 用户名 susername=admin , 用户密码 suserpwd=null , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=null , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败            0-未校验 semailvalflag=null , Email semail=null , 出生日期 dbirthday=nu', '127.0.0.1', 'findUsersForCount', '1', '6', NULL, '未登陆用户', '2014-10-11 10:28:05', '2014-10-11 10:28:04', '2014-10-11 10:28:05'),
(2, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=null , 用户名 susername=null , 用户密码 suserpwd=null , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=null , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败            0-未校验 semailvalflag=null , Email semail=zhongefeng@163.com , 出生日期', '127.0.0.1', 'findUsersForCount', '1', '6', NULL, '未登陆用户', '2014-10-11 10:28:05', '2014-10-11 10:28:05', '2014-10-11 10:28:05'),
(3, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=null , 用户名 susername=admin , 用户密码 suserpwd=admin123 , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=0 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败            0-未校验 semailvalflag=0 , Email semail=zhongefeng@163.com , 出生日期 ', '127.0.0.1', 'saveUsers', '1', '2', NULL, '未登陆用户', '2014-10-11 10:28:05', '2014-10-11 10:28:05', '2014-10-11 10:28:05'),
(4, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=null , 用户名 susername=admin , 用户密码 suserpwd=null , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=null , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败            0-未校验 semailvalflag=null , Email semail=null , 出生日期 dbirthday=nu', '127.0.0.1', 'findUserList', '1', '6', NULL, '未登陆用户', '2014-10-11 10:28:31', '2014-10-11 10:28:31', '2014-10-11 10:28:31'),
(5, NULL, '用户:null登陆时错误! 原因:用户状态已锁定!请联系管理员解锁', '127.0.0.1', NULL, '0', '1', NULL, '未登陆用户', '2014-10-11 10:28:31', '2014-10-11 10:28:31', '2014-10-11 10:28:31'),
(6, 'com.feng.service.ILogService', '参数:[null, 1, 用户:null登陆时错误! 原因:用户状态已锁定!请联系管理员解锁, false]', '127.0.0.1', 'addLog', '1', '2', NULL, '未登陆用户', '2014-10-11 10:28:31', '2014-10-11 10:28:31', '2014-10-11 10:28:31'),
(7, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=null , 用户名 susername=admin , 用户密码 suserpwd=null , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=null , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败            0-未校验 semailvalflag=null , Email semail=null , 出生日期 dbirthday=nu', '127.0.0.1', 'findUserList', '1', '6', NULL, '未登陆用户', '2014-10-11 11:19:40', '2014-10-11 11:19:39', '2014-10-11 11:19:40'),
(8, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.195 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过          ', '127.0.0.1', 'updateUsers', '1', '3', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:19:40', '2014-10-11 11:19:40', '2014-10-11 11:19:40'),
(9, NULL, '登陆成功', '127.0.0.1', NULL, '1', '1', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:19:40', '2014-10-11 11:19:40', '2014-10-11 11:19:40'),
(10, 'com.feng.service.ILogService', '参数:[null, 1, 登陆成功, true]', '127.0.0.1', 'addLog', '1', '2', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:19:40', '2014-10-11 11:19:40', '2014-10-11 11:19:40'),
(11, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败     ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:19:40', '2014-10-11 11:19:40', '2014-10-11 11:19:40'),
(12, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败     ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:22:52', '2014-10-11 11:22:52', '2014-10-11 11:22:52'),
(13, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败     ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:22:54', '2014-10-11 11:22:54', '2014-10-11 11:22:54'),
(14, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败     ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:22:57', '2014-10-11 11:22:57', '2014-10-11 11:22:57'),
(15, 'com.feng.service.ILogService', '参数:[日志编号 ilogid=null , 用户代码 susercode=null , 用户名 susername=null , 操作类型            1-登陆            2-添加            3-修改            4-生成            5-导出 sproptype=null , 描述 sdesc=null , 结束时间 tsenddate=null , 方法名 smethodname=null , 执行结果            1-成功            2-失败 sproceedstate=null , 开始时间 tsstartdate=null , 登陆IP sip=null , 系统更新时间 tssysupdate=null, null, null, 10, 1, ilogid, desc]', '127.0.0.1', 'findLogForpaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:23:03', '2014-10-11 11:23:03', '2014-10-11 11:23:03'),
(16, 'com.feng.service.IDbQueryService', '参数:[数据库 sdbtype=null , 查询表信息 squerytabinfo=null , 查询表所在列信息 squerycolumn=null , 查询表主键 squerypk=null , jdbc类名 sjdbcclass=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 系统更新时间 tssysupdate=null, 20, 1, sdbtype, asc]', '127.0.0.1', 'findDbqueryForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:23:06', '2014-10-11 11:23:06', '2014-10-11 11:23:06'),
(17, 'com.feng.service.IDbQueryService', '参数:[数据库 sdbtype=null , 查询表信息 squerytabinfo=null , 查询表所在列信息 squerycolumn=null , 查询表主键 squerypk=null , jdbc类名 sjdbcclass=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 系统更新时间 tssysupdate=null, 20, 0, sdbtype, asc]', '127.0.0.1', 'findDbqueryForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:23:06', '2014-10-11 11:23:06', '2014-10-11 11:23:06'),
(18, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:23:08', '2014-10-11 11:23:08', '2014-10-11 11:23:08'),
(19, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 0, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:23:08', '2014-10-11 11:23:08', '2014-10-11 11:23:08'),
(20, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:23:18', '2014-10-11 11:23:18', '2014-10-11 11:23:18'),
(21, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:23:18', '2014-10-11 11:23:18', '2014-10-11 11:23:18'),
(22, 'com.feng.service.IComboService', '参数:[]', '127.0.0.1', 'findProjectForComboList', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:23:20', '2014-10-11 11:23:20', '2014-10-11 11:23:20'),
(23, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败     ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:26:50', '2014-10-11 11:26:50', '2014-10-11 11:26:50'),
(24, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败     ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:29:17', '2014-10-11 11:29:17', '2014-10-11 11:29:17'),
(25, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败     ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:30:08', '2014-10-11 11:30:08', '2014-10-11 11:30:08'),
(26, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:31:08', '2014-10-11 11:31:08', '2014-10-11 11:31:08'),
(27, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:31:09', '2014-10-11 11:31:09', '2014-10-11 11:31:09'),
(28, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:31:09', '2014-10-11 11:31:09', '2014-10-11 11:31:09'),
(29, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:31:10', '2014-10-11 11:31:10', '2014-10-11 11:31:10'),
(30, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:31:10', '2014-10-11 11:31:10', '2014-10-11 11:31:10'),
(31, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:31:11', '2014-10-11 11:31:11', '2014-10-11 11:31:11'),
(32, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败     ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:33:48', '2014-10-11 11:33:48', '2014-10-11 11:33:48'),
(33, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=null , 用户名 susername=admin , 用户密码 suserpwd=null , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=null , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败            0-未校验 semailvalflag=null , Email semail=null , 出生日期 dbirthday=nu', '127.0.0.1', 'findUserList', '1', '6', NULL, '未登陆用户', '2014-10-11 11:34:03', '2014-10-11 11:34:03', '2014-10-11 11:34:03'),
(34, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:34:03.707 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过          ', '127.0.0.1', 'updateUsers', '1', '3', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:34:03', '2014-10-11 11:34:03', '2014-10-11 11:34:03'),
(35, NULL, '登陆成功', '127.0.0.1', NULL, '1', '1', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:34:03', '2014-10-11 11:34:03', '2014-10-11 11:34:03'),
(36, 'com.feng.service.ILogService', '参数:[null, 1, 登陆成功, true]', '127.0.0.1', 'addLog', '1', '2', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:34:03', '2014-10-11 11:34:03', '2014-10-11 11:34:03'),
(37, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:34:04', '2014-10-11 11:34:04', '2014-10-11 11:34:04'),
(38, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:35:01', '2014-10-11 11:35:01', '2014-10-11 11:35:01'),
(39, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:35:53', '2014-10-11 11:35:53', '2014-10-11 11:35:53'),
(40, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:41:06', '2014-10-11 11:41:06', '2014-10-11 11:41:06'),
(41, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:41:12', '2014-10-11 11:41:12', '2014-10-11 11:41:12'),
(42, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:41:31', '2014-10-11 11:41:31', '2014-10-11 11:41:31'),
(43, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:27', '2014-10-11 11:45:27', '2014-10-11 11:45:27'),
(44, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:27', '2014-10-11 11:45:27', '2014-10-11 11:45:27'),
(45, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:28', '2014-10-11 11:45:28', '2014-10-11 11:45:28'),
(46, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:28', '2014-10-11 11:45:28', '2014-10-11 11:45:28'),
(47, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:29', '2014-10-11 11:45:29', '2014-10-11 11:45:29'),
(48, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:29', '2014-10-11 11:45:29', '2014-10-11 11:45:29'),
(49, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:29', '2014-10-11 11:45:29', '2014-10-11 11:45:29'),
(50, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:30', '2014-10-11 11:45:30', '2014-10-11 11:45:30'),
(51, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:30', '2014-10-11 11:45:30', '2014-10-11 11:45:30'),
(52, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:31', '2014-10-11 11:45:31', '2014-10-11 11:45:31'),
(53, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:31', '2014-10-11 11:45:31', '2014-10-11 11:45:31'),
(54, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:32', '2014-10-11 11:45:32', '2014-10-11 11:45:32'),
(55, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:32', '2014-10-11 11:45:32', '2014-10-11 11:45:32'),
(56, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:33', '2014-10-11 11:45:33', '2014-10-11 11:45:33'),
(57, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:33', '2014-10-11 11:45:33', '2014-10-11 11:45:33'),
(58, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:34', '2014-10-11 11:45:34', '2014-10-11 11:45:34'),
(59, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:35', '2014-10-11 11:45:35', '2014-10-11 11:45:35'),
(60, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:35', '2014-10-11 11:45:35', '2014-10-11 11:45:35'),
(61, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:36', '2014-10-11 11:45:36', '2014-10-11 11:45:36'),
(62, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:36', '2014-10-11 11:45:36', '2014-10-11 11:45:36'),
(63, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:37', '2014-10-11 11:45:37', '2014-10-11 11:45:37'),
(64, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:37', '2014-10-11 11:45:37', '2014-10-11 11:45:37'),
(65, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:38', '2014-10-11 11:45:37', '2014-10-11 11:45:38'),
(66, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:38', '2014-10-11 11:45:38', '2014-10-11 11:45:38'),
(67, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:38', '2014-10-11 11:45:38', '2014-10-11 11:45:38'),
(68, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:39', '2014-10-11 11:45:39', '2014-10-11 11:45:39'),
(69, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:39', '2014-10-11 11:45:39', '2014-10-11 11:45:39'),
(70, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:39', '2014-10-11 11:45:39', '2014-10-11 11:45:39'),
(71, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:40', '2014-10-11 11:45:40', '2014-10-11 11:45:40'),
(72, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:40', '2014-10-11 11:45:40', '2014-10-11 11:45:40'),
(73, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:40', '2014-10-11 11:45:40', '2014-10-11 11:45:40'),
(74, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:41', '2014-10-11 11:45:41', '2014-10-11 11:45:41'),
(75, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:41', '2014-10-11 11:45:41', '2014-10-11 11:45:41'),
(76, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:41', '2014-10-11 11:45:41', '2014-10-11 11:45:41'),
(77, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:41', '2014-10-11 11:45:41', '2014-10-11 11:45:41'),
(78, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:42', '2014-10-11 11:45:42', '2014-10-11 11:45:42'),
(79, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:42', '2014-10-11 11:45:42', '2014-10-11 11:45:42'),
(80, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:42', '2014-10-11 11:45:42', '2014-10-11 11:45:42'),
(81, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:43', '2014-10-11 11:45:43', '2014-10-11 11:45:43'),
(82, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:43', '2014-10-11 11:45:43', '2014-10-11 11:45:43'),
(83, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:43', '2014-10-11 11:45:43', '2014-10-11 11:45:43'),
(84, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:44', '2014-10-11 11:45:44', '2014-10-11 11:45:44'),
(85, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:44', '2014-10-11 11:45:44', '2014-10-11 11:45:44'),
(86, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:45', '2014-10-11 11:45:45', '2014-10-11 11:45:45'),
(87, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:45', '2014-10-11 11:45:45', '2014-10-11 11:45:45'),
(88, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:45', '2014-10-11 11:45:45', '2014-10-11 11:45:45'),
(89, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:46', '2014-10-11 11:45:46', '2014-10-11 11:45:46'),
(90, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:46', '2014-10-11 11:45:46', '2014-10-11 11:45:46'),
(91, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:47', '2014-10-11 11:45:47', '2014-10-11 11:45:47'),
(92, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:47', '2014-10-11 11:45:47', '2014-10-11 11:45:47'),
(93, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:47', '2014-10-11 11:45:47', '2014-10-11 11:45:47'),
(94, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:48', '2014-10-11 11:45:48', '2014-10-11 11:45:48'),
(95, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:48', '2014-10-11 11:45:48', '2014-10-11 11:45:48'),
(96, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:49', '2014-10-11 11:45:49', '2014-10-11 11:45:49'),
(97, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:49', '2014-10-11 11:45:49', '2014-10-11 11:45:49'),
(98, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:49', '2014-10-11 11:45:49', '2014-10-11 11:45:49'),
(99, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:50', '2014-10-11 11:45:50', '2014-10-11 11:45:50'),
(100, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:50', '2014-10-11 11:45:50', '2014-10-11 11:45:50'),
(101, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:51', '2014-10-11 11:45:51', '2014-10-11 11:45:51'),
(102, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:51', '2014-10-11 11:45:51', '2014-10-11 11:45:51'),
(103, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:51', '2014-10-11 11:45:51', '2014-10-11 11:45:51'),
(104, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:52', '2014-10-11 11:45:52', '2014-10-11 11:45:52'),
(105, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:52', '2014-10-11 11:45:52', '2014-10-11 11:45:52'),
(106, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:52', '2014-10-11 11:45:52', '2014-10-11 11:45:52'),
(107, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:53', '2014-10-11 11:45:53', '2014-10-11 11:45:53'),
(108, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:53', '2014-10-11 11:45:53', '2014-10-11 11:45:53'),
(109, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:54', '2014-10-11 11:45:54', '2014-10-11 11:45:54'),
(110, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:54', '2014-10-11 11:45:54', '2014-10-11 11:45:54'),
(111, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:54', '2014-10-11 11:45:54', '2014-10-11 11:45:54'),
(112, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:55', '2014-10-11 11:45:55', '2014-10-11 11:45:55'),
(113, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:55', '2014-10-11 11:45:55', '2014-10-11 11:45:55'),
(114, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:55', '2014-10-11 11:45:55', '2014-10-11 11:45:55'),
(115, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:56', '2014-10-11 11:45:56', '2014-10-11 11:45:56'),
(116, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:56', '2014-10-11 11:45:56', '2014-10-11 11:45:56');
INSERT INTO `tl_log` (`I_LOGID`, `S_CLASSNAME`, `S_DESC`, `S_IP`, `S_METHODNAME`, `S_PROCEEDSTATE`, `S_PROPTYPE`, `S_USERCODE`, `S_USERNAME`, `TS_ENDDATE`, `TS_STARTDATE`, `TS_SYSUPDATE`) VALUES
(117, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:56', '2014-10-11 11:45:56', '2014-10-11 11:45:56'),
(118, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:57', '2014-10-11 11:45:57', '2014-10-11 11:45:57'),
(119, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:57', '2014-10-11 11:45:57', '2014-10-11 11:45:57'),
(120, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:58', '2014-10-11 11:45:58', '2014-10-11 11:45:58'),
(121, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:58', '2014-10-11 11:45:58', '2014-10-11 11:45:58'),
(122, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:45:59', '2014-10-11 11:45:59', '2014-10-11 11:45:59'),
(123, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:59', '2014-10-11 11:45:59', '2014-10-11 11:45:59'),
(124, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:45:59', '2014-10-11 11:45:59', '2014-10-11 11:45:59'),
(125, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:00', '2014-10-11 11:46:00', '2014-10-11 11:46:00'),
(126, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:46:00', '2014-10-11 11:46:00', '2014-10-11 11:46:00'),
(127, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:01', '2014-10-11 11:46:01', '2014-10-11 11:46:01'),
(128, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:01', '2014-10-11 11:46:01', '2014-10-11 11:46:01'),
(129, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:46:01', '2014-10-11 11:46:01', '2014-10-11 11:46:01'),
(130, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:02', '2014-10-11 11:46:02', '2014-10-11 11:46:02'),
(131, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:02', '2014-10-11 11:46:02', '2014-10-11 11:46:02'),
(132, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:46:03', '2014-10-11 11:46:03', '2014-10-11 11:46:03'),
(133, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:03', '2014-10-11 11:46:03', '2014-10-11 11:46:03'),
(134, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:04', '2014-10-11 11:46:04', '2014-10-11 11:46:04'),
(135, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:46:04', '2014-10-11 11:46:04', '2014-10-11 11:46:04'),
(136, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:05', '2014-10-11 11:46:05', '2014-10-11 11:46:05'),
(137, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:05', '2014-10-11 11:46:05', '2014-10-11 11:46:05'),
(138, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:46:06', '2014-10-11 11:46:05', '2014-10-11 11:46:06'),
(139, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:06', '2014-10-11 11:46:06', '2014-10-11 11:46:06'),
(140, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:07', '2014-10-11 11:46:07', '2014-10-11 11:46:07'),
(141, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:46:07', '2014-10-11 11:46:07', '2014-10-11 11:46:07'),
(142, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:07', '2014-10-11 11:46:07', '2014-10-11 11:46:07'),
(143, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:08', '2014-10-11 11:46:08', '2014-10-11 11:46:08'),
(144, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:46:08', '2014-10-11 11:46:08', '2014-10-11 11:46:08'),
(145, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:09', '2014-10-11 11:46:09', '2014-10-11 11:46:09'),
(146, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:46:09', '2014-10-11 11:46:09', '2014-10-11 11:46:09'),
(147, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:46:10', '2014-10-11 11:46:10', '2014-10-11 11:46:10'),
(148, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:50:55', '2014-10-11 11:50:55', '2014-10-11 11:50:55'),
(149, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:19:40.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 11:51:28', '2014-10-11 11:51:28', '2014-10-11 11:51:28'),
(150, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:52:37', '2014-10-11 11:52:37', '2014-10-11 11:52:37'),
(151, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:52:41', '2014-10-11 11:52:41', '2014-10-11 11:52:41'),
(152, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:53:22', '2014-10-11 11:53:22', '2014-10-11 11:53:22'),
(153, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:54:33', '2014-10-11 11:54:33', '2014-10-11 11:54:33'),
(154, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:54:38', '2014-10-11 11:54:38', '2014-10-11 11:54:38'),
(155, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:54:46', '2014-10-11 11:54:46', '2014-10-11 11:54:46'),
(156, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 11:54:57', '2014-10-11 11:54:57', '2014-10-11 11:54:57'),
(157, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 12:03:41', '2014-10-11 12:03:41', '2014-10-11 12:03:41'),
(158, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 12:04:23', '2014-10-11 12:04:23', '2014-10-11 12:04:23'),
(159, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 12:04:33', '2014-10-11 12:04:33', '2014-10-11 12:04:33'),
(160, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 12:34:53', '2014-10-11 12:34:53', '2014-10-11 12:34:53'),
(161, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 12:36:10', '2014-10-11 12:36:10', '2014-10-11 12:36:10'),
(162, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=null , 用户名 susername=admin , 用户密码 suserpwd=null , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=null , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败            0-未校验 semailvalflag=null , Email semail=null , 出生日期 dbirthday=nu', '127.0.0.1', 'findUserList', '1', '6', NULL, '未登陆用户', '2014-10-11 12:36:31', '2014-10-11 12:36:30', '2014-10-11 12:36:31'),
(163, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 12:36:31.463 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过          ', '127.0.0.1', 'updateUsers', '1', '3', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 12:36:31', '2014-10-11 12:36:31', '2014-10-11 12:36:31'),
(164, NULL, '登陆成功', '127.0.0.1', NULL, '1', '1', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 12:36:31', '2014-10-11 12:36:31', '2014-10-11 12:36:31'),
(165, 'com.feng.service.ILogService', '参数:[null, 1, 登陆成功, true]', '127.0.0.1', 'addLog', '1', '2', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 12:36:31', '2014-10-11 12:36:31', '2014-10-11 12:36:31'),
(166, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:34:03.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 12:36:32', '2014-10-11 12:36:32', '2014-10-11 12:36:32'),
(167, 'com.feng.service.IComboService', '参数:[]', '127.0.0.1', 'findProjectForComboList', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:04:19', '2014-10-11 13:04:19', '2014-10-11 13:04:19'),
(168, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:04:22', '2014-10-11 13:04:22', '2014-10-11 13:04:22'),
(169, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 0, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:04:22', '2014-10-11 13:04:22', '2014-10-11 13:04:22'),
(170, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:05:44', '2014-10-11 13:05:44', '2014-10-11 13:05:44'),
(171, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:05:45', '2014-10-11 13:05:45', '2014-10-11 13:05:45'),
(172, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:05:46', '2014-10-11 13:05:46', '2014-10-11 13:05:46'),
(173, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:05:46', '2014-10-11 13:05:46', '2014-10-11 13:05:46'),
(174, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:05:52', '2014-10-11 13:05:52', '2014-10-11 13:05:52'),
(175, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:07:44', '2014-10-11 13:07:44', '2014-10-11 13:07:44'),
(176, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 0, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:07:44', '2014-10-11 13:07:44', '2014-10-11 13:07:44'),
(177, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 11:34:03.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:07:48', '2014-10-11 13:07:48', '2014-10-11 13:07:48'),
(178, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:07:54', '2014-10-11 13:07:54', '2014-10-11 13:07:54'),
(179, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 0, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:07:54', '2014-10-11 13:07:54', '2014-10-11 13:07:54'),
(180, 'com.feng.service.IComboService', '参数:[]', '127.0.0.1', 'findFrameForComboList', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:09:01', '2014-10-11 13:09:01', '2014-10-11 13:09:01'),
(181, 'com.feng.service.IComboService', '参数:[]', '127.0.0.1', 'findDbqueryForComboList', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:09:01', '2014-10-11 13:09:01', '2014-10-11 13:09:01'),
(182, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:09:51', '2014-10-11 13:09:51', '2014-10-11 13:09:51'),
(183, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 0, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:09:51', '2014-10-11 13:09:51', '2014-10-11 13:09:51'),
(184, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:10:04', '2014-10-11 13:10:04', '2014-10-11 13:10:04'),
(185, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 0, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:10:04', '2014-10-11 13:10:04', '2014-10-11 13:10:04'),
(186, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:10:06', '2014-10-11 13:10:06', '2014-10-11 13:10:06'),
(187, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:10:08', '2014-10-11 13:10:08', '2014-10-11 13:10:08'),
(188, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 13:11:00', '2014-10-11 13:11:00', '2014-10-11 13:11:00'),
(189, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=null , 用户名 susername=admin , 用户密码 suserpwd=null , 上次登录时间 tslastlogin=null , 用户状态            0-锁定            1-正常 suserstate=null , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过            2-校验失败            0-未校验 semailvalflag=null , Email semail=null , 出生日期 dbirthday=nu', '127.0.0.1', 'findUserList', '1', '6', NULL, '未登陆用户', '2014-10-11 13:11:09', '2014-10-11 13:11:09', '2014-10-11 13:11:09'),
(190, 'com.feng.service.IUsersService', '参数:[用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 13:11:09.932 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过          ', '127.0.0.1', 'updateUsers', '1', '3', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:11:09', '2014-10-11 13:11:09', '2014-10-11 13:11:09'),
(191, NULL, '登陆成功', '127.0.0.1', NULL, '1', '1', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:11:09', '2014-10-11 13:11:09', '2014-10-11 13:11:09'),
(192, 'com.feng.service.ILogService', '参数:[null, 1, 登陆成功, true]', '127.0.0.1', 'addLog', '1', '2', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:11:09', '2014-10-11 13:11:09', '2014-10-11 13:11:09'),
(193, 'com.feng.service.IMenuService', '参数:[null, 用户代码 susercode=0d48adc5-c92d-431b-8e35-bb1f05a3dbaf , 用户名 susername=admin , 用户密码 suserpwd=f865b53623b121fd34ee5426c792e5c33af8c227 , 上次登录时间 tslastlogin=2014-10-11 12:36:31.0 , 用户状态            0-锁定            1-正常 suserstate=1 , 项目生成路径 sprojgenpath=null , Email是否已校验            1-已校验通过      ', '127.0.0.1', 'getMenu', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:11:16', '2014-10-11 13:11:16', '2014-10-11 13:11:16'),
(194, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:11:22', '2014-10-11 13:11:22', '2014-10-11 13:11:22'),
(195, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 0, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:11:22', '2014-10-11 13:11:22', '2014-10-11 13:11:22'),
(196, 'com.feng.service.IComboService', '参数:[]', '127.0.0.1', 'findFrameForComboList', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:11:32', '2014-10-11 13:11:32', '2014-10-11 13:11:32'),
(197, 'com.feng.service.IComboService', '参数:[]', '127.0.0.1', 'findDbqueryForComboList', '1', '6', '0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', 'admin', '2014-10-11 13:11:32', '2014-10-11 13:11:32', '2014-10-11 13:11:32'),
(198, 'com.feng.service.IProjectService', '参数:[项目代码 sprojcode=null , 项目名称 sprojname=null , 项目中文名称 sprojchename=null , 描述 sdesc=null , 开始时间 tsadddate=null , 数据库 sdbtype=null , 数据库密码 sdbpwd=null , 数据库用户名 sdbname=null , 数据库jdbc sdburl=null , 数据库schema sdbschema=null , 用户代码 susercode=null , 框架代码 iframecode=null , 系统更新时间 tssysupdate=null, 20, 1, sprojcode, asc]', '127.0.0.1', 'findProjectForPaging', '1', '6', NULL, '未登陆用户', '2014-10-11 14:11:13', '2014-10-11 14:11:13', '2014-10-11 14:11:13'),
(199, 'com.feng.service.ILogService', '参数:[日志编号 ilogid=null , 用户代码 susercode=null , 用户名 susername=null , 操作类型            1-登陆            2-添加            3-修改            4-生成            5-导出 sproptype=null , 描述 sdesc=null , 结束时间 tsenddate=null , 方法名 smethodname=null , 执行结果            1-成功            2-失败 sproceedstate=null , 开始时间 tsstartdate=null , 登陆IP sip=null , 系统更新时间 tssysupdate=null, null, null, 10, 1, ilogid, desc]', '127.0.0.1', 'findLogForpaging', '1', '6', NULL, '未登陆用户', '2014-10-11 14:11:17', '2014-10-11 14:11:17', '2014-10-11 14:11:17'),
(200, 'com.feng.service.ILogService', '参数:[日志编号 ilogid=null , 用户代码 susercode=null , 用户名 susername=null , 操作类型            1-登陆            2-添加            3-修改            4-生成            5-导出 sproptype=null , 描述 sdesc=null , 结束时间 tsenddate=null , 方法名 smethodname=null , 执行结果            1-成功            2-失败 sproceedstate=null , 开始时间 tsstartdate=null , 登陆IP sip=null , 系统更新时间 tssysupdate=null, null, null, 10, 2, ilogid, desc]', '127.0.0.1', 'findLogForpaging', '1', '6', NULL, '未登陆用户', '2014-10-11 14:11:49', '2014-10-11 14:11:49', '2014-10-11 14:11:49'),
(201, 'com.feng.service.ILogService', '参数:[日志编号 ilogid=null , 用户代码 susercode=null , 用户名 susername=null , 操作类型            1-登陆            2-添加            3-修改            4-生成            5-导出 sproptype=null , 描述 sdesc=null , 结束时间 tsenddate=null , 方法名 smethodname=null , 执行结果            1-成功            2-失败 sproceedstate=null , 开始时间 tsstartdate=null , 登陆IP sip=null , 系统更新时间 tssysupdate=null, null, null, 10, 3, ilogid, desc]', '127.0.0.1', 'findLogForpaging', '1', '6', NULL, '未登陆用户', '2014-10-11 14:11:51', '2014-10-11 14:11:51', '2014-10-11 14:11:51'),
(202, 'com.feng.service.ILogService', '参数:[日志编号 ilogid=null , 用户代码 susercode=null , 用户名 susername=null , 操作类型            1-登陆            2-添加            3-修改            4-生成            5-导出 sproptype=null , 描述 sdesc=null , 结束时间 tsenddate=null , 方法名 smethodname=null , 执行结果            1-成功            2-失败 sproceedstate=null , 开始时间 tsstartdate=null , 登陆IP sip=null , 系统更新时间 tssysupdate=null, null, null, 10, 4, ilogid, desc]', '127.0.0.1', 'findLogForpaging', '1', '6', NULL, '未登陆用户', '2014-10-11 14:11:52', '2014-10-11 14:11:52', '2014-10-11 14:11:52'),
(203, 'com.feng.service.ILogService', '参数:[日志编号 ilogid=null , 用户代码 susercode=null , 用户名 susername=null , 操作类型            1-登陆            2-添加            3-修改            4-生成            5-导出 sproptype=null , 描述 sdesc=null , 结束时间 tsenddate=null , 方法名 smethodname=null , 执行结果            1-成功            2-失败 sproceedstate=null , 开始时间 tsstartdate=null , 登陆IP sip=null , 系统更新时间 tssysupdate=null, null, null, 10, 5, ilogid, desc]', '127.0.0.1', 'findLogForpaging', '1', '6', NULL, '未登陆用户', '2014-10-11 14:11:53', '2014-10-11 14:11:53', '2014-10-11 14:11:53'),
(204, 'com.feng.service.IMenuService', '参数:[null, null]', '127.0.0.1', 'getMenu', '1', '6', NULL, '未登陆用户', '2014-10-11 14:12:00', '2014-10-11 14:12:00', '2014-10-11 14:12:00');

-- --------------------------------------------------------

--
-- 表的结构 `tp_datatype`
--

CREATE TABLE IF NOT EXISTS `tp_datatype` (
  `I_ENUMCLASS` bigint(20) NOT NULL AUTO_INCREMENT,
  `S_ENUMCLASSNAME` varchar(42) DEFAULT NULL,
  `S_ENUMREMARK` varchar(170) DEFAULT NULL,
  `S_PROJCODE` varchar(36) DEFAULT NULL,
  `S_USERCODE` varchar(36) DEFAULT NULL,
  `S_USERNAME` varchar(21) DEFAULT NULL,
  `TS_STARTDATE` datetime DEFAULT NULL,
  `TS_SYSUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`I_ENUMCLASS`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `tp_dbquery`
--

CREATE TABLE IF NOT EXISTS `tp_dbquery` (
  `S_DBTYPE` varchar(36) NOT NULL,
  `S_DBSCHEMA` varchar(36) DEFAULT NULL,
  `S_DBURL` varchar(170) DEFAULT NULL,
  `S_JDBCCLASS` varchar(42) DEFAULT NULL,
  `S_QUERYCOLUMN` varchar(170) DEFAULT NULL,
  `S_QUERYPK` varchar(170) DEFAULT NULL,
  `S_QUERYTABINFO` varchar(170) DEFAULT NULL,
  `S_USERCODE` varchar(36) DEFAULT NULL,
  `TS_SYSUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`S_DBTYPE`),
  UNIQUE KEY `S_DBTYPE` (`S_DBTYPE`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tp_enumdata`
--

CREATE TABLE IF NOT EXISTS `tp_enumdata` (
  `S_ENUMCODE` varchar(36) NOT NULL,
  `I_ENUMCLASS` bigint(20) NOT NULL,
  `S_ENUMNAME` varchar(42) DEFAULT NULL,
  `S_ENUMREMARK` varchar(170) DEFAULT NULL,
  `TS_STARTDATE` datetime DEFAULT NULL,
  `TS_SYSUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`S_ENUMCODE`,`I_ENUMCLASS`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tp_frame`
--

CREATE TABLE IF NOT EXISTS `tp_frame` (
  `I_FRAMECODE` int(11) NOT NULL AUTO_INCREMENT,
  `S_ACTIONPACKAGE` varchar(42) DEFAULT NULL,
  `S_BASEPACKAGE` varchar(21) DEFAULT NULL,
  `S_DESC` varchar(170) DEFAULT NULL,
  `S_FRAMENAME` varchar(42) DEFAULT NULL,
  `S_MODELPACKAGE` varchar(42) DEFAULT NULL,
  `S_MODELPRIEX` varchar(5) DEFAULT NULL,
  `S_SERVICEPACKAGE` varchar(42) DEFAULT NULL,
  `S_USERCODE` varchar(36) DEFAULT NULL,
  `S_XMLPACKAGE` varchar(42) DEFAULT NULL,
  `TS_STARTDATE` datetime DEFAULT NULL,
  `TS_SYSUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`I_FRAMECODE`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `tp_menu`
--

CREATE TABLE IF NOT EXISTS `tp_menu` (
  `I_MENUID` int(11) NOT NULL AUTO_INCREMENT,
  `I_SUPERMENUID` int(11) DEFAULT NULL,
  `S_MENUNAME` varchar(42) DEFAULT NULL,
  `S_MENUURL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`I_MENUID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `tp_menu`
--

INSERT INTO `tp_menu` (`I_MENUID`, `I_SUPERMENUID`, `S_MENUNAME`, `S_MENUURL`) VALUES
(1, NULL, '个人信息', './f/user_userinfo.html'),
(2, 1, '日志信息', './f/log_list.html'),
(3, 1, '表设计维护', './f/dbquery_list.html'),
(4, 1, '项目维护', './f/project_list.html'),
(5, 1, '表维护', './f/table_list.html'),
(6, 1, '个人信息', './f/user_userinfo.html'),
(7, NULL, '员工信息', './f/user_userinfo.html');

-- --------------------------------------------------------

--
-- 表的结构 `tp_project`
--

CREATE TABLE IF NOT EXISTS `tp_project` (
  `S_PROJCODE` varchar(36) NOT NULL,
  `I_FRAMECODE` int(11) DEFAULT NULL,
  `S_DBNAME` varchar(21) DEFAULT NULL,
  `S_DBPWD` varchar(21) DEFAULT NULL,
  `S_DBSCHEMA` varchar(36) DEFAULT NULL,
  `S_DBTYPE` varchar(36) DEFAULT NULL,
  `S_DBURL` varchar(170) DEFAULT NULL,
  `S_DESC` varchar(170) DEFAULT NULL,
  `S_PROJCHENAME` varchar(42) DEFAULT NULL,
  `S_PROJNAME` varchar(21) DEFAULT NULL,
  `S_USERCODE` varchar(36) DEFAULT NULL,
  `TS_ADDDATE` datetime DEFAULT NULL,
  `TS_SYSUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`S_PROJCODE`),
  UNIQUE KEY `S_PROJCODE` (`S_PROJCODE`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tp_systemconfig`
--

CREATE TABLE IF NOT EXISTS `tp_systemconfig` (
  `S_PROJCODE` varchar(36) NOT NULL,
  `S_PROJGENPATH` varchar(170) DEFAULT NULL,
  `S_PROJNAME` varchar(21) DEFAULT NULL,
  PRIMARY KEY (`S_PROJCODE`),
  UNIQUE KEY `S_PROJCODE` (`S_PROJCODE`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tp_users`
--

CREATE TABLE IF NOT EXISTS `tp_users` (
  `S_USERCODE` varchar(36) NOT NULL,
  `D_BIRTHDAY` date DEFAULT NULL,
  `S_ADMINFLAG` varchar(1) DEFAULT NULL,
  `S_EMAIL` varchar(30) DEFAULT NULL,
  `S_EMAILVALFLAG` varchar(1) DEFAULT NULL,
  `S_LASTLOGINIP` varchar(36) DEFAULT NULL,
  `S_PROJGENPATH` varchar(170) DEFAULT NULL,
  `S_REGIP` varchar(36) DEFAULT NULL,
  `S_REGUSERCODE` varchar(36) DEFAULT NULL,
  `S_SEX` varchar(1) DEFAULT NULL,
  `S_USERNAME` varchar(21) DEFAULT NULL,
  `S_USERPWD` varchar(85) DEFAULT NULL,
  `S_USERSTATE` varchar(1) DEFAULT NULL,
  `TS_LASTLOGIN` datetime DEFAULT NULL,
  `TS_REGDATETIME` datetime DEFAULT NULL,
  `TS_SYSUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`S_USERCODE`),
  UNIQUE KEY `S_USERCODE` (`S_USERCODE`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tp_users`
--

INSERT INTO `tp_users` (`S_USERCODE`, `D_BIRTHDAY`, `S_ADMINFLAG`, `S_EMAIL`, `S_EMAILVALFLAG`, `S_LASTLOGINIP`, `S_PROJGENPATH`, `S_REGIP`, `S_REGUSERCODE`, `S_SEX`, `S_USERNAME`, `S_USERPWD`, `S_USERSTATE`, `TS_LASTLOGIN`, `TS_REGDATETIME`, `TS_SYSUPDATE`) VALUES
('0d48adc5-c92d-431b-8e35-bb1f05a3dbaf', '2014-10-30', '1', 'zhongefeng@163.com', '1', '127.0.0.1', NULL, '127.0.0.1', NULL, '1', 'admin', 'f865b53623b121fd34ee5426c792e5c33af8c227', '1', '2014-10-11 13:11:09', '2014-10-11 10:28:05', '2014-10-11 13:11:09');

-- --------------------------------------------------------

--
-- 表的结构 `ts_column`
--

CREATE TABLE IF NOT EXISTS `ts_column` (
  `I_COLUMNID` bigint(20) NOT NULL AUTO_INCREMENT,
  `I_ENUMCLASS` bigint(20) DEFAULT NULL,
  `I_TABLEID` bigint(20) DEFAULT NULL,
  `S_COLUMNCNAME` varchar(85) DEFAULT NULL,
  `S_COLUMNNAME` varchar(42) DEFAULT NULL,
  `S_DISPLAY` varchar(1) DEFAULT NULL,
  `S_ISNULLS` varchar(1) DEFAULT NULL,
  `S_JAVATYPE` varchar(36) DEFAULT NULL,
  `S_PKS` varchar(1) DEFAULT NULL,
  `S_PROJCODE` varchar(36) DEFAULT NULL,
  `S_SCOPE` varchar(30) DEFAULT NULL,
  `S_TABNAME` varchar(42) DEFAULT NULL,
  `TS_STARTDATE` datetime DEFAULT NULL,
  `TS_SYSUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`I_COLUMNID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `ts_table`
--

CREATE TABLE IF NOT EXISTS `ts_table` (
  `I_TABLEID` bigint(20) NOT NULL AUTO_INCREMENT,
  `S_PROJCODE` varchar(36) DEFAULT NULL,
  `S_TABCNAME` varchar(42) DEFAULT NULL,
  `S_TABNAME` varchar(42) DEFAULT NULL,
  `S_USERCODE` varchar(36) DEFAULT NULL,
  `TS_STARTDATE` datetime DEFAULT NULL,
  `TS_SYSUPDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`I_TABLEID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `t_wxuser`
--

CREATE TABLE IF NOT EXISTS `t_wxuser` (
  `FID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FACCESSTOOKEN` varchar(50) NOT NULL,
  `FDate` datetime DEFAULT NULL,
  `FPHONE` varchar(20) NOT NULL,
  `FRemark` varchar(255) DEFAULT NULL,
  `FStatus` bigint(20) DEFAULT NULL,
  `FUSERID` varchar(50) NOT NULL,
  `FWEIXINNO` varchar(50) NOT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
