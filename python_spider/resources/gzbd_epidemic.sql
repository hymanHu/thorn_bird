/*
Navicat MySQL Data Transfer

Source Server         : mainDb
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2020-06-30 09:59:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `gzbd_epidemic`
-- ----------------------------
DROP TABLE IF EXISTS `gzbd_epidemic`;
CREATE TABLE `gzbd_epidemic` (
  `id` int(11) NOT NULL auto_increment,
  `region` varchar(255) default NULL,
  `date` varchar(255) default NULL,
  `diagnosis` int(11) default NULL,
  `overseas_import` int(11) default NULL,
  `cure` int(11) default NULL,
  `death` int(11) default NULL,
  `therapy` int(11) default NULL,
  `observation` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gzbd_epidemic
-- ----------------------------
