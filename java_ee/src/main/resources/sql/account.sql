/*
Navicat MySQL Data Transfer

Source Server         : MyConnect
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-01-12 22:03:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account_resource`
-- ----------------------------
DROP TABLE IF EXISTS `account_resource`;
CREATE TABLE `account_resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `account_role`
-- ----------------------------
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_role
-- ----------------------------

-- ----------------------------
-- Table structure for `account_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `account_role_resource`;
CREATE TABLE `account_role_resource` (
  `role_resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY (`role_resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `account_user`
-- ----------------------------
DROP TABLE IF EXISTS `account_user`;
CREATE TABLE `account_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_user
-- ----------------------------
INSERT INTO `account_user` VALUES ('1', 'admin', '111111', '2020-10-22 00:00:00');
INSERT INTO `account_user` VALUES ('2', 'hyman', '111111', '2020-10-22 00:00:00');

-- ----------------------------
-- Table structure for `account_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `account_user_role`;
CREATE TABLE `account_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_user_role
-- ----------------------------
