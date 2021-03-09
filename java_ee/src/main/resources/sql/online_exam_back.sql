/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : onlineexamsystem

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-04-10 15:14:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_course`
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('1', '语文');
INSERT INTO `t_course` VALUES ('2', '历史');

-- ----------------------------
-- Table structure for `t_question`
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `question_title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `question_optionA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `question_optionB` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `question_optionC` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `question_optionD` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `question_answer` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `question_score` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES ('1', '单选', '下列加点字的注音完全正确的一项是（）', '骸骨（hái） 笼罩（lóng）峰峦（luán）街坊（fāng）', '嫌恶（wù）潜（qiǎn）行踉跄（niàng）连亘（gèn）\r\n', '悄然（qiāo） 花蕾（lěi）妥当（dang）潺潺（chán）\r\n', '狩猎（shòu） 模样（mú）惩罚（chéng）荫蔽（yīn）\r\n', 'D', '2');
INSERT INTO `t_question` VALUES ('2', '单选', '下列词语中没有错别字的一项是（）', '丝丝缕缕疲惫不堪眉开眼笑开膛破肚\r\n', '自做主张轻飞慢舞随声附合孤苦伶仃\r\n', '水波粼粼心驰神往莽莽榛榛宽洪大量\r\n', '更胜一筹贪婪自私御骋织师津津有味\r\n', 'C', '2');
INSERT INTO `t_question` VALUES ('3', '单选', '下列成语使用不正确的一项是：（）', '在过去的2013年，中央电视台推出的《梦想星搭档》因其以“为了孩子”为主题的公益性比其他同类的歌唱选秀节目更胜一筹。\r\n', '2014年伊始，随着黄金价格持续下降，“中国大妈”赴海外抢金的风暴真是到了骇人听闻的地步。\r\n', '面对考试成绩，我们既不能沾沾自喜，也无须灰心丧气，因为“塞翁失马，焉知非福”。\r\n', '我们应该尽我们所能把能做的事情做得更加的一丝不苟。\r\n', 'B', '2');
INSERT INTO `t_question` VALUES ('4', '单选', '下列文学常识及课文内容表述有误的一项是：（）', '老舍对济南的山山水水一往情深。在他的眼中，济南的冬天是温晴的、慈善的，所以冬天的济南“真得算个宝地”。\r\n', '《绿色蝈蝈》是法国著名昆虫学家法布尔所写，文章以生动活泼的笔法写出了作者对蝈蝈的喜爱和对生命的尊重。\r\n', '清代小说家吴承恩著的《西游记》第五回把孙悟空塑造成了一个有情有义、神通广大、无所顾忌的英雄形象。\r\n', '宗璞的《紫藤萝瀑布》采用托物言志的手法，从那一树树盛开的紫藤萝花中感悟到人生的美好和生命的永恒，从而增强了生活的勇气。\r\n', 'A', '2');
INSERT INTO `t_question` VALUES ('5', '单选', '下列句子有语病的一项是（）', '在重庆，很多人的一天是从一碗面条开始的。 \r\n', '重庆人离不开小面，小面的故事在民间广为传承。 \r\n', '一碗小面的背后隐藏着许多重庆人悲欢离合的人生故事。 \r\n', '重庆的小面成为了我们这座城市的生活作料，难怪郭沫若说“重庆值得回忆”。 \r\n', 'D', '2');
INSERT INTO `t_question` VALUES ('6', '单选', '下列句子中比喻不贴切的一项是（）', '弯弯的金水河像一条玉带横贯东西，河上是五座精美的汉白玉石桥。\r\n', '远远的看见有一只小船从苇塘里撑出来，在淀里，像一支利箭，奔着东南去了。\r\n', '苏州宝带桥53孔之多，如果坐小船缓缓看一遍，你会感到像读了一篇史诗似的满足。\r\n', '天渐渐破晓，淡青色的天空镶着几颗残星，大地朦朦胧胧的，如同覆盖着银灰色的薄纱。\r\n', 'B', '2');
INSERT INTO `t_question` VALUES ('7', '单选', '17、18世纪先后发生了英国资产阶级革命、美国独立战争和法国大革命，这三次革命的共同点不包括（）', '都推翻了封建统治，处死了国王', '都具有资产阶级革命性质\r\n', '都促进了资本主义的发展	', '都建立了资产阶级统治\r\n', 'A', '5');
INSERT INTO `t_question` VALUES ('8', '单选', '比较评价历史人物，是历史学科能力要求之一。华盛顿、拿破仑作为资产阶级政治家，其历史作用的相同之处是（）', '赢得了民族独立', '维护了国家统一', '打击了封建势力', '推动了资产阶级民主政治进程', 'A', '5');
INSERT INTO `t_question` VALUES ('9', '单选', '从中国“制造”到中国“创造”，反映了中国民族工业从无到有，由弱变强的发展历程。下面叙述不正确的是（）', '洋务运动诞生了中国第一批近代企业', '张謇倡导“实业救国”，创办了大生纱厂', '“一五计划”完成，我国实现了工业化\r\n', '改革开放后，中国工业创新水平不断提高\r\n', 'C', '5');
INSERT INTO `t_question` VALUES ('10', '单选', '如果你有机会到宝岛台湾一游，建议你到台南市参观当地的名胜古迹----赤嵌楼。这里敬奉着一位民族英雄，他是（）	', '郑成功', '戚继光', '郑和', '林则徐', 'A', '5');

-- ----------------------------
-- Table structure for `t_question_testpaper`
-- ----------------------------
DROP TABLE IF EXISTS `t_question_testpaper`;
CREATE TABLE `t_question_testpaper` (
  `paper_question_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_question_id` int(11) DEFAULT NULL,
  `fk_testpaper_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`paper_question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_question_testpaper
-- ----------------------------
INSERT INTO `t_question_testpaper` VALUES ('1', '1', '1');
INSERT INTO `t_question_testpaper` VALUES ('2', '2', '1');
INSERT INTO `t_question_testpaper` VALUES ('3', '4', '1');
INSERT INTO `t_question_testpaper` VALUES ('4', '3', '2');
INSERT INTO `t_question_testpaper` VALUES ('5', '5', '2');
INSERT INTO `t_question_testpaper` VALUES ('6', '6', '2');
INSERT INTO `t_question_testpaper` VALUES ('7', '7', '3');
INSERT INTO `t_question_testpaper` VALUES ('8', '8', '4');
INSERT INTO `t_question_testpaper` VALUES ('9', '10', '4');
INSERT INTO `t_question_testpaper` VALUES ('10', '9', '3');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', '超级管理员');
INSERT INTO `t_role` VALUES ('2', 'manager', '管理员');
INSERT INTO `t_role` VALUES ('3', 'student', '学生');

-- ----------------------------
-- Table structure for `t_score`
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `result` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fk_course_id` int(11) DEFAULT NULL,
  `fk_stu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_score
-- ----------------------------

-- ----------------------------
-- Table structure for `t_stu`
-- ----------------------------
DROP TABLE IF EXISTS `t_stu`;
CREATE TABLE `t_stu` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stu_profession` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stu_sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stu_num` int(11) DEFAULT NULL,
  `fk_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_stu
-- ----------------------------

-- ----------------------------
-- Table structure for `t_testpaper`
-- ----------------------------
DROP TABLE IF EXISTS `t_testpaper`;
CREATE TABLE `t_testpaper` (
  `testPaper_id` int(11) NOT NULL AUTO_INCREMENT,
  `testPaper_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fk_course_id` int(11) DEFAULT NULL,
  `testPaper_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`testPaper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_testpaper
-- ----------------------------
INSERT INTO `t_testpaper` VALUES ('1', '2015学年重庆开县七年级上学期期末考试语文试卷（A）', '1', '1');
INSERT INTO `t_testpaper` VALUES ('2', '2015学年重庆开县七年级上学期期末考试语文试卷（B）', '1', '2');
INSERT INTO `t_testpaper` VALUES ('3', '2015学年重庆开县七年级上学期期末考试历史试卷（A）', '2', '1');
INSERT INTO `t_testpaper` VALUES ('4', '2015学年重庆开县七年级上学期期末考试历史试卷（B）', '2', '2');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `register_time` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'zs', '7aa19ed6f1b27c7a3cf5db2414cb34f6', '2020-04-08');
INSERT INTO `t_user` VALUES ('2', 'ls', 'ca84703baca2fd0566c6c3c208de42f0', '2020-04-08');

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_user_id` int(11) DEFAULT NULL,
  `fk_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '3');
INSERT INTO `t_user_role` VALUES ('2', '2', '3');
