/*
Navicat MySQL Data Transfer

Source Server         : myConnection
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2021-03-12 17:06:57
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `traffic_parking_charge`
-- ----------------------------
DROP TABLE IF EXISTS `traffic_parking_charge`;
CREATE TABLE `traffic_parking_charge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `car_license` varchar(255) DEFAULT NULL,
  `charge_type` int(11) NOT NULL,
  `parking_id` int(11) NOT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `sum` int(11) NOT NULL,
  `fee` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traffic_parking_charge
-- ----------------------------

-- ----------------------------
-- Table structure for `traffic_parking_space`
-- ----------------------------
DROP TABLE IF EXISTS `traffic_parking_space`;
CREATE TABLE `traffic_parking_space` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `parking_space_type` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traffic_parking_space
-- ----------------------------
INSERT INTO `traffic_parking_space` VALUES ('1', '2021-03-11 16:43:47', 'standard', '1');
INSERT INTO `traffic_parking_space` VALUES ('2', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('3', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('4', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('5', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('6', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('7', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('8', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('9', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('10', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('11', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('12', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('13', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('14', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('15', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('16', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('17', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('18', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('19', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('20', '2021-03-11 16:43:47', 'mini', '0');
INSERT INTO `traffic_parking_space` VALUES ('21', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('22', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('23', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('24', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('25', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('26', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('27', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('28', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('29', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('30', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('31', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('32', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('33', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('34', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('35', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('36', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('37', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('38', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('39', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('40', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('41', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('42', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('43', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('44', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('45', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('46', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('47', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('48', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('49', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('50', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('51', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('52', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('53', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('54', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('55', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('56', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('57', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('58', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('59', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('60', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('61', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('62', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('63', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('64', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('65', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('66', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('67', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('68', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('69', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('70', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('71', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('72', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('73', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('74', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('75', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('76', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('77', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('78', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('79', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('80', '2021-03-11 16:43:47', 'standard', '0');
INSERT INTO `traffic_parking_space` VALUES ('81', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('82', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('83', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('84', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('85', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('86', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('87', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('88', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('89', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('90', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('91', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('92', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('93', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('94', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('95', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('96', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('97', '2021-03-11 16:43:47', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('98', '2021-03-11 16:44:15', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('99', '2021-03-11 16:44:15', 'large', '0');
INSERT INTO `traffic_parking_space` VALUES ('100', '2021-03-11 16:44:15', 'large', '0');
