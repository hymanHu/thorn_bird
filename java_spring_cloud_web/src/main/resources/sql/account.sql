/*
Navicat MySQL Data Transfer

Source Server         : myConnection
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2021-04-14 09:51:12
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account_resource`
-- ----------------------------
DROP TABLE IF EXISTS `account_resource`;
CREATE TABLE `account_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_resource
-- ----------------------------
INSERT INTO `account_resource` VALUES ('1', '2021-03-09 09:28:00', 'deleteUser');
INSERT INTO `account_resource` VALUES ('3', '2021-03-23 09:56:57', 'deleteResource');
INSERT INTO `account_resource` VALUES ('4', '2021-03-23 10:22:22', 'deleteResource1');

-- ----------------------------
-- Table structure for `account_role`
-- ----------------------------
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_role
-- ----------------------------
INSERT INTO `account_role` VALUES ('1', '2021-03-08 14:18:29', 'admin');
INSERT INTO `account_role` VALUES ('2', '2021-03-08 14:18:36', 'manager');
INSERT INTO `account_role` VALUES ('3', '2021-03-08 14:18:44', 'staff');

-- ----------------------------
-- Table structure for `account_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `account_role_resource`;
CREATE TABLE `account_role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_role_resource
-- ----------------------------
INSERT INTO `account_role_resource` VALUES ('7', '1', '1');

-- ----------------------------
-- Table structure for `account_role_respurce`
-- ----------------------------
DROP TABLE IF EXISTS `account_role_respurce`;
CREATE TABLE `account_role_respurce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_role_respurce
-- ----------------------------

-- ----------------------------
-- Table structure for `account_user`
-- ----------------------------
DROP TABLE IF EXISTS `account_user`;
CREATE TABLE `account_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2u0as4ayxp45uhelagx5pg4w5` (`email`),
  UNIQUE KEY `UK_oj7jmhydgi99xm39nhacptlq9` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_user
-- ----------------------------
INSERT INTO `account_user` VALUES ('1', '2021-03-03 13:35:48', 'admin1@163.com', 'admin', '51c017d79ab2eea8548f22543409cd05', '/upload/profile-big/1615274591701.png');
INSERT INTO `account_user` VALUES ('2', '2021-03-05 14:49:33', 'manager@163.com', 'manager', '51c017d79ab2eea8548f22543409cd05', null);
INSERT INTO `account_user` VALUES ('3', '2021-03-05 15:02:20', 'staff@163.com', 'staff', '51c017d79ab2eea8548f22543409cd05', null);
INSERT INTO `account_user` VALUES ('4', '2021-03-08 10:48:51', 'hyman1@163.com', 'hyman1', '51c017d79ab2eea8548f22543409cd05', null);
INSERT INTO `account_user` VALUES ('5', '2021-03-08 10:49:06', 'hyman2@163.com', 'hyman2', '51c017d79ab2eea8548f22543409cd05', null);
INSERT INTO `account_user` VALUES ('6', '2021-03-08 10:49:32', 'hyman3@163.com', 'hyman3', '51c017d79ab2eea8548f22543409cd05', null);
INSERT INTO `account_user` VALUES ('10', '2021-03-08 14:59:30', 'hyman4@163.com', 'hyman4', '51c017d79ab2eea8548f22543409cd05', '');
INSERT INTO `account_user` VALUES ('11', '2021-03-11 09:13:22', 'hyman5@163.com', 'hyman55', '51c017d79ab2eea8548f22543409cd05', '/upload/profile-big/1615427003695.png');
INSERT INTO `account_user` VALUES ('12', '2021-03-15 15:58:53', 'hj111@163.com', 'hj111', '51c017d79ab2eea8548f22543409cd05', '');

-- ----------------------------
-- Table structure for `account_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `account_user_role`;
CREATE TABLE `account_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_user_role
-- ----------------------------
INSERT INTO `account_user_role` VALUES ('4', '10', '3');
INSERT INTO `account_user_role` VALUES ('6', '2', '2');
INSERT INTO `account_user_role` VALUES ('7', '3', '3');
INSERT INTO `account_user_role` VALUES ('17', '11', '3');
INSERT INTO `account_user_role` VALUES ('21', '1', '1');
INSERT INTO `account_user_role` VALUES ('22', '12', '3');
