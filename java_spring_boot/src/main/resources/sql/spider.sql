/*
Navicat MySQL Data Transfer

Source Server         : MyConnect
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-06-03 22:05:55
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `spider_coronavirus`
-- ----------------------------
DROP TABLE IF EXISTS `spider_coronavirus`;
CREATE TABLE `spider_coronavirus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
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
-- Table structure for `spider_news`
-- ----------------------------
DROP TABLE IF EXISTS `spider_news`;
CREATE TABLE `spider_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `digest` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `view_count` bigint(20) NOT NULL,
  `label` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `news_date` datetime DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `channel` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `detail` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spider_news
-- ----------------------------

-- ----------------------------
-- Table structure for `spider_university`
-- ----------------------------
DROP TABLE IF EXISTS `spider_university`;
CREATE TABLE `spider_university` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `nature` varchar(255) DEFAULT NULL,
  `belong` varchar(255) DEFAULT NULL,
  `central` int(11) NOT NULL,
  `department` int(11) NOT NULL,
  `doublehigh` bit(1) NOT NULL,
  `f211` bit(1) NOT NULL,
  `f985` bit(1) NOT NULL,
  `is_recruitment` bit(1) NOT NULL,
  `dual_class` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `province_name` varchar(255) DEFAULT NULL,
  `single_province` varchar(255) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `county_name` varchar(255) DEFAULT NULL,
  `view_total_number` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spider_university
-- ----------------------------
