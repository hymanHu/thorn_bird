/*
Navicat MySQL Data Transfer

Source Server         : MyConnect
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-02-14 21:25:47
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `hn_track`
-- ----------------------------
DROP TABLE IF EXISTS `hn_track`;
CREATE TABLE `hn_track` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `assessment` double NOT NULL,
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hn_track
-- ----------------------------
INSERT INTO `hn_track` VALUES ('1', '2021-02-10 17:02:05', '翠花', '城内一日游', '旅行', '1', '2020-05-23 14:07:16');
INSERT INTO `hn_track` VALUES ('2', '2021-02-10 17:02:05', '翠花', '约定端午同游', '计划&承诺', '0', '2020-05-28 21:08:50');
INSERT INTO `hn_track` VALUES ('3', '2021-02-10 17:02:05', '翠花', '同事聚会烧烤店', '交际', '0', '2020-05-31 23:09:57');
INSERT INTO `hn_track` VALUES ('4', '2021-02-10 17:02:05', '翠花', '加班开会', '工作', '0', '2020-06-05 23:10:36');
INSERT INTO `hn_track` VALUES ('5', '2021-02-10 17:02:05', '翠花', '公司不批假，端午出游计划搁浅', '失信', '-1', '2020-06-07 21:11:35');
INSERT INTO `hn_track` VALUES ('6', '2021-02-10 17:02:05', '翠花', '短期内不会换工作，未达目标，近两年不变动', '心理', '0', '2020-06-08 21:12:50');
INSERT INTO `hn_track` VALUES ('7', '2021-02-10 17:02:05', '翠花', '陪客户喝酒，喝醉', '工作', '0', '2020-06-09 23:13:24');
INSERT INTO `hn_track` VALUES ('8', '2021-02-10 17:02:05', '翠花', '陪父母孩子夜游', '家庭', '1', '2020-06-11 21:14:02');
INSERT INTO `hn_track` VALUES ('9', '2021-02-10 17:02:05', '翠花', '加班陪客户', '工作', '0', '2020-06-19 22:06:40');
INSERT INTO `hn_track` VALUES ('10', '2021-02-10 17:02:05', '翠花', '大姨妈', '生理', '0', '2020-06-14 21:33:19');
INSERT INTO `hn_track` VALUES ('11', '2021-02-10 17:02:05', '翠花', '月薪1w左右，期望2w', '工作', '0', '2020-06-20 22:32:16');
INSERT INTO `hn_track` VALUES ('12', '2021-02-10 17:02:05', '翠花', '计划纹身，纹在脚上', '妆容', '0', '2020-06-21 21:43:18');
INSERT INTO `hn_track` VALUES ('13', '2021-02-10 17:02:05', '翠花', '加班陪客户', '工作', '0', '2020-06-23 21:36:16');
INSERT INTO `hn_track` VALUES ('14', '2021-02-10 17:02:05', '翠花', '期望理解与包容', '心理', '0', '2020-06-25 23:03:13');
INSERT INTO `hn_track` VALUES ('15', '2021-02-10 17:02:05', '翠花', '准备买衣服，暗示没有外套', '妆容', '0', '2020-06-27 21:59:36');
INSERT INTO `hn_track` VALUES ('17', '2021-02-10 17:02:05', '翠花', '没什么工作，和同事逛街', '消费', '0', '2020-07-02 21:58:50');
INSERT INTO `hn_track` VALUES ('18', '2021-02-10 17:02:05', '翠花', '加班员工大会，聚餐到晚11点半', '工作', '0', '2020-07-03 21:34:31');
INSERT INTO `hn_track` VALUES ('19', '2021-02-10 17:02:05', '翠花', '加班到凌晨', '工作', '0', '2020-07-05 21:37:59');
INSERT INTO `hn_track` VALUES ('20', '2021-02-10 17:02:05', '翠花', '开会', '工作', '0', '2020-07-11 22:30:58');
INSERT INTO `hn_track` VALUES ('21', '2021-02-10 17:02:05', '翠花', '大姨妈头疼刮痧', '生理', '0', '2020-07-13 22:02:50');
INSERT INTO `hn_track` VALUES ('22', '2021-02-10 17:02:05', '翠花', '技能培训到凌晨', '工作', '0', '2020-07-15 21:40:06');
INSERT INTO `hn_track` VALUES ('23', '2021-02-10 17:02:05', '翠花', '加班到10点', '工作', '0', '2020-07-30 21:36:54');
INSERT INTO `hn_track` VALUES ('24', '2021-02-10 17:02:05', '翠花', '未回消息，说是太累睡了', '失信', '-1', '2020-08-03 21:30:38');
INSERT INTO `hn_track` VALUES ('25', '2021-02-10 17:02:05', '翠花', '未回消息', '失信', '-1', '2020-08-05 21:34:31');
INSERT INTO `hn_track` VALUES ('26', '2021-02-10 17:02:05', '翠花', '开会', '工作', '0', '2020-08-09 21:56:17');
INSERT INTO `hn_track` VALUES ('27', '2021-02-10 17:02:05', '翠花', '大姨妈无力', '生理', '0', '2020-08-11 21:59:07');
INSERT INTO `hn_track` VALUES ('28', '2021-02-10 17:02:05', '翠花', '休假找朋友玩', '交际', '0', '2020-08-12 21:59:33');
INSERT INTO `hn_track` VALUES ('29', '2021-02-10 17:02:05', '翠花', '未回消息', '失信', '-1', '2020-08-17 22:48:27');
INSERT INTO `hn_track` VALUES ('30', '2021-02-10 17:02:05', '翠花', '未回消息', '失信', '-1', '2020-08-31 21:48:47');
INSERT INTO `hn_track` VALUES ('31', '2021-02-10 17:02:05', '翠花', '未回消息', '失信', '-1', '2020-09-06 22:01:25');
INSERT INTO `hn_track` VALUES ('32', '2021-02-10 17:02:05', '翠花', '未回消息', '失信', '-1', '2020-09-19 20:23:15');
INSERT INTO `hn_track` VALUES ('33', '2021-02-10 17:02:05', '翠花', '未回消息', '失信', '-1', '2020-09-20 22:12:34');
INSERT INTO `hn_track` VALUES ('34', '2021-02-10 17:02:05', '翠花', '未回消息', '失信', '-1', '2020-09-27 21:26:02');
INSERT INTO `hn_track` VALUES ('35', '2021-02-10 17:02:05', '翠花', '大姨妈陪朋友喝酒，喝醉', '交际', '-2', '2020-11-18 21:52:47');
INSERT INTO `hn_track` VALUES ('36', '2021-02-10 17:02:05', '翠花', '未回消息', '失信', '-1', '2020-11-23 21:34:20');
INSERT INTO `hn_track` VALUES ('38', '2021-02-10 17:02:05', '翠花', '未回消息', '失信', '-1', '2020-12-04 22:35:58');
