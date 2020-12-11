/*
Navicat MySQL Data Transfer

Source Server         : myConnection
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2020-11-12 13:13:53
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pager_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------

-- ----------------------------
-- Table structure for `exam`
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `paper_id` int(11) NOT NULL,
  `reference_score` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `spend_time` int(11) NOT NULL,
  `exam_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------

-- ----------------------------
-- Table structure for `paper`
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `total_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('1', 'Java_SE', '2020-10-29 14:59:52', '60');
INSERT INTO `paper` VALUES ('2', 'Java_EE', '2020-11-01 19:32:28', '60');
INSERT INTO `paper` VALUES ('3', 'Java_Framework', '2020-11-01 19:32:49', '60');
INSERT INTO `paper` VALUES ('4', 'Python_Base', '2020-11-01 19:33:13', '60');
INSERT INTO `paper` VALUES ('5', 'Python_Spider', '2020-11-01 19:33:37', '60');
INSERT INTO `paper` VALUES ('6', 'Python_Web', '2020-11-01 19:33:58', '60');
INSERT INTO `paper` VALUES ('7', 'DB_Sql', '2020-11-01 19:34:14', '60');
INSERT INTO `paper` VALUES ('8', 'DB_NoSql', '2020-11-01 19:34:27', '60');
INSERT INTO `paper` VALUES ('9', 'Front_Html', '2020-11-01 19:34:40', '60');
INSERT INTO `paper` VALUES ('10', 'Front_Css', '2020-11-01 19:35:04', '60');
INSERT INTO `paper` VALUES ('11', 'Front_Js', '2020-11-01 19:35:18', '60');

-- ----------------------------
-- Table structure for `paper_question`
-- ----------------------------
DROP TABLE IF EXISTS `paper_question`;
CREATE TABLE `paper_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper_question
-- ----------------------------
INSERT INTO `paper_question` VALUES ('1', '1', '1');
INSERT INTO `paper_question` VALUES ('2', '1', '2');
INSERT INTO `paper_question` VALUES ('3', '1', '3');
INSERT INTO `paper_question` VALUES ('4', '1', '4');

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `option_a` varchar(255) DEFAULT NULL,
  `option_b` varchar(255) DEFAULT NULL,
  `option_c` varchar(255) DEFAULT NULL,
  `option_d` varchar(255) DEFAULT NULL,
  `reference_answer` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', 'singleChoice', 'Java_SE', '2', 'Java 字节码文件的扩展名是？', 'java', 'class', 'exe', 'jsp', 'B', null);
INSERT INTO `question` VALUES ('2', 'singleChoice', 'Java_SE', '2', '下面哪项所占空间最小？', 'byte', 'short', 'boolean', 'long', 'C', null);
INSERT INTO `question` VALUES ('3', 'multipleChoice', 'Java_SE', '2', '下面哪项属于循环代码块？', 'for 语句', 'if 语句', 'main 方法', 'class 类', 'A', null);
INSERT INTO `question` VALUES ('4', 'multipleChoice', 'Java_SE', '2', '访问修饰符范围比较正确的是？', 'public > default > protected > private', 'public > default > privite > protected', 'public > protected > default > private', 'public > protected > 不写 > private', 'C', null);
