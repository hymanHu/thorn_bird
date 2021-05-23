/*
Navicat MySQL Data Transfer

Source Server         : MyConnect
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-05-23 20:21:23
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `spider_coronavirus`
-- ----------------------------
DROP TABLE IF EXISTS `spider_coronavirus`;
CREATE TABLE `spider_coronavirus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(20) DEFAULT NULL,
  `region` varchar(20) DEFAULT NULL,
  `diagnosis` int(11) DEFAULT NULL,
  `overseas_import` int(11) DEFAULT NULL,
  `cure` int(11) DEFAULT NULL,
  `death` int(11) DEFAULT NULL,
  `therapy` int(11) DEFAULT NULL,
  `observation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spider_coronavirus
-- ----------------------------

-- ----------------------------
-- Table structure for `spider_university`
-- ----------------------------
DROP TABLE IF EXISTS `spider_university`;
CREATE TABLE `spider_university` (
  `id` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `school_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `level` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nature` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `belong` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `central` int(11) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  `doublehigh` int(1) DEFAULT NULL,
  `f211` int(1) DEFAULT NULL,
  `f985` int(1) DEFAULT NULL,
  `is_recruitment` int(1) DEFAULT NULL,
  `dual_class` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `province_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `single_province` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `city_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `county_name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `view_total_number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of spider_university
-- ----------------------------
