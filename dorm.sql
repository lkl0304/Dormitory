# Host: localhost  (Version: 5.5.53)
# Date: 2017-07-14 21:16:48
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES gb2312 */;

#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=gbk COMMENT='管理员';

#
# Data for table "admin"
#

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

#
# Structure for table "lou"
#

DROP TABLE IF EXISTS `lou`;
CREATE TABLE `lou` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=57 DEFAULT CHARSET=gbk;

#
# Data for table "lou"
#

/*!40000 ALTER TABLE `lou` DISABLE KEYS */;
INSERT INTO `lou` VALUES (45,'3123','男寝');
/*!40000 ALTER TABLE `lou` ENABLE KEYS */;

#
# Structure for table "record"
#

DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(128) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=537 DEFAULT CHARSET=gbk;

#
# Data for table "record"
#

/*!40000 ALTER TABLE `record` DISABLE KEYS */;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `stuid` bigint(15) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `sex` varchar(128) DEFAULT NULL,
  `lou` varchar(128) DEFAULT NULL,
  `home` int(1) DEFAULT NULL,
  `tel` bigint(16) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=62 DEFAULT CHARSET=gbk;

#
# Data for table "student"
#

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (61,2015123123,'222','难','233',211,13554455662);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
