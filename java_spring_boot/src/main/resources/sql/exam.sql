/*
Navicat MySQL Data Transfer

Source Server         : myConnection
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2021-05-25 14:50:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `exam_achievement`
-- ----------------------------
DROP TABLE IF EXISTS `exam_achievement`;
CREATE TABLE `exam_achievement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `total_score` double(11,2) NOT NULL,
  `reference_score` varchar(255) DEFAULT NULL,
  `score` double(11,2) DEFAULT NULL,
  `total_time` int(11) DEFAULT NULL,
  `spend_time` int(11) DEFAULT NULL,
  `exam_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of exam_achievement
-- ----------------------------
INSERT INTO `exam_achievement` VALUES ('60', '1', 'Java_Framework_j2101_周岩_admin', '67.50', '52.5', '52.50', '45', '14', '2021-05-13 13:53:38');
INSERT INTO `exam_achievement` VALUES ('62', '1', 'Java_Framework_j2101_李家富_admin', '67.50', '57.5', '57.50', '45', '15', '2021-05-13 13:57:14');
INSERT INTO `exam_achievement` VALUES ('63', '1', 'Java_Framework_j2101_尤行_admin', '67.50', '50.0', '50.00', '45', '15', '2021-05-13 13:57:37');
INSERT INTO `exam_achievement` VALUES ('64', '1', 'Java_Framework_j2101_朱彦宝_admin', '67.50', '57.5', '57.50', '45', '15', '2021-05-13 14:08:02');
INSERT INTO `exam_achievement` VALUES ('65', '1', 'Java_Framework_j2101_王天石_admin', '67.50', '47.5', '47.50', '45', '11', '2021-05-13 14:10:09');
INSERT INTO `exam_achievement` VALUES ('66', '1', 'Java_Framework_j2101_王永佳_admin', '67.50', '52.5', '52.50', '45', '11', '2021-05-13 14:12:24');
INSERT INTO `exam_achievement` VALUES ('67', '1', 'Java_Framework_j2101_覃运泉_admin', '67.50', '60.0', '60.00', '45', '11', '2021-05-13 16:35:28');
INSERT INTO `exam_achievement` VALUES ('68', '1', 'Java_Framework_j2101_王炼_admin', '67.50', '55.0', '55.00', '45', '12', '2021-05-14 09:05:24');

-- ----------------------------
-- Table structure for `exam_answer`
-- ----------------------------
DROP TABLE IF EXISTS `exam_answer`;
CREATE TABLE `exam_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `achievement_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `user_answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1622 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_answer
-- ----------------------------
INSERT INTO `exam_answer` VALUES ('1397', '60', '53', 'A');
INSERT INTO `exam_answer` VALUES ('1398', '60', '10', '');
INSERT INTO `exam_answer` VALUES ('1399', '60', '15', 'A');
INSERT INTO `exam_answer` VALUES ('1400', '60', '52', 'C');
INSERT INTO `exam_answer` VALUES ('1401', '60', '17', 'B');
INSERT INTO `exam_answer` VALUES ('1402', '60', '8', 'D');
INSERT INTO `exam_answer` VALUES ('1403', '60', '54', 'D');
INSERT INTO `exam_answer` VALUES ('1404', '60', '9', 'C');
INSERT INTO `exam_answer` VALUES ('1405', '60', '7', 'D');
INSERT INTO `exam_answer` VALUES ('1406', '60', '6', 'D');
INSERT INTO `exam_answer` VALUES ('1407', '60', '50', 'A');
INSERT INTO `exam_answer` VALUES ('1408', '60', '18', 'B');
INSERT INTO `exam_answer` VALUES ('1409', '60', '12', 'C');
INSERT INTO `exam_answer` VALUES ('1410', '60', '56', 'D');
INSERT INTO `exam_answer` VALUES ('1411', '60', '58', 'B');
INSERT INTO `exam_answer` VALUES ('1412', '60', '57', 'A');
INSERT INTO `exam_answer` VALUES ('1413', '60', '16', 'C');
INSERT INTO `exam_answer` VALUES ('1414', '60', '5', 'A');
INSERT INTO `exam_answer` VALUES ('1415', '60', '14', 'A,B');
INSERT INTO `exam_answer` VALUES ('1416', '60', '13', 'A,D');
INSERT INTO `exam_answer` VALUES ('1417', '60', '47', 'False');
INSERT INTO `exam_answer` VALUES ('1418', '60', '46', 'False');
INSERT INTO `exam_answer` VALUES ('1419', '60', '55', 'True');
INSERT INTO `exam_answer` VALUES ('1420', '60', '49', 'True');
INSERT INTO `exam_answer` VALUES ('1421', '60', '48', 'True');
INSERT INTO `exam_answer` VALUES ('1447', '62', '52', 'C');
INSERT INTO `exam_answer` VALUES ('1448', '62', '6', 'C');
INSERT INTO `exam_answer` VALUES ('1449', '62', '50', 'A');
INSERT INTO `exam_answer` VALUES ('1450', '62', '17', 'D');
INSERT INTO `exam_answer` VALUES ('1451', '62', '10', '');
INSERT INTO `exam_answer` VALUES ('1452', '62', '58', 'B');
INSERT INTO `exam_answer` VALUES ('1453', '62', '54', 'A');
INSERT INTO `exam_answer` VALUES ('1454', '62', '5', 'A');
INSERT INTO `exam_answer` VALUES ('1455', '62', '12', 'A');
INSERT INTO `exam_answer` VALUES ('1456', '62', '16', 'C');
INSERT INTO `exam_answer` VALUES ('1457', '62', '15', 'A');
INSERT INTO `exam_answer` VALUES ('1458', '62', '56', 'A');
INSERT INTO `exam_answer` VALUES ('1459', '62', '7', 'D');
INSERT INTO `exam_answer` VALUES ('1460', '62', '57', 'A');
INSERT INTO `exam_answer` VALUES ('1461', '62', '8', 'D');
INSERT INTO `exam_answer` VALUES ('1462', '62', '9', 'C');
INSERT INTO `exam_answer` VALUES ('1463', '62', '53', 'B');
INSERT INTO `exam_answer` VALUES ('1464', '62', '18', 'D');
INSERT INTO `exam_answer` VALUES ('1465', '62', '14', 'A,B');
INSERT INTO `exam_answer` VALUES ('1466', '62', '13', 'A,D');
INSERT INTO `exam_answer` VALUES ('1467', '62', '46', 'True');
INSERT INTO `exam_answer` VALUES ('1468', '62', '47', 'False');
INSERT INTO `exam_answer` VALUES ('1469', '62', '49', 'True');
INSERT INTO `exam_answer` VALUES ('1470', '62', '55', 'True');
INSERT INTO `exam_answer` VALUES ('1471', '62', '48', 'True');
INSERT INTO `exam_answer` VALUES ('1472', '63', '9', 'C');
INSERT INTO `exam_answer` VALUES ('1473', '63', '50', 'A');
INSERT INTO `exam_answer` VALUES ('1474', '63', '10', 'B');
INSERT INTO `exam_answer` VALUES ('1475', '63', '56', 'D');
INSERT INTO `exam_answer` VALUES ('1476', '63', '53', 'D');
INSERT INTO `exam_answer` VALUES ('1477', '63', '5', 'A');
INSERT INTO `exam_answer` VALUES ('1478', '63', '6', 'C');
INSERT INTO `exam_answer` VALUES ('1479', '63', '57', 'A');
INSERT INTO `exam_answer` VALUES ('1480', '63', '52', 'C');
INSERT INTO `exam_answer` VALUES ('1481', '63', '18', 'B');
INSERT INTO `exam_answer` VALUES ('1482', '63', '17', 'D');
INSERT INTO `exam_answer` VALUES ('1483', '63', '54', 'D');
INSERT INTO `exam_answer` VALUES ('1484', '63', '58', 'D');
INSERT INTO `exam_answer` VALUES ('1485', '63', '8', 'D');
INSERT INTO `exam_answer` VALUES ('1486', '63', '16', 'C');
INSERT INTO `exam_answer` VALUES ('1487', '63', '7', 'D');
INSERT INTO `exam_answer` VALUES ('1488', '63', '15', 'A');
INSERT INTO `exam_answer` VALUES ('1489', '63', '12', 'A');
INSERT INTO `exam_answer` VALUES ('1490', '63', '13', 'A,D');
INSERT INTO `exam_answer` VALUES ('1491', '63', '14', 'A,B');
INSERT INTO `exam_answer` VALUES ('1492', '63', '49', 'True');
INSERT INTO `exam_answer` VALUES ('1493', '63', '47', 'False');
INSERT INTO `exam_answer` VALUES ('1494', '63', '55', 'False');
INSERT INTO `exam_answer` VALUES ('1495', '63', '46', 'False');
INSERT INTO `exam_answer` VALUES ('1496', '63', '48', 'True');
INSERT INTO `exam_answer` VALUES ('1497', '64', '9', 'C');
INSERT INTO `exam_answer` VALUES ('1498', '64', '57', 'A');
INSERT INTO `exam_answer` VALUES ('1499', '64', '18', 'B');
INSERT INTO `exam_answer` VALUES ('1500', '64', '5', 'A');
INSERT INTO `exam_answer` VALUES ('1501', '64', '7', 'D');
INSERT INTO `exam_answer` VALUES ('1502', '64', '54', 'A');
INSERT INTO `exam_answer` VALUES ('1503', '64', '6', 'C');
INSERT INTO `exam_answer` VALUES ('1504', '64', '12', 'A');
INSERT INTO `exam_answer` VALUES ('1505', '64', '52', 'C');
INSERT INTO `exam_answer` VALUES ('1506', '64', '50', 'A');
INSERT INTO `exam_answer` VALUES ('1507', '64', '53', 'B');
INSERT INTO `exam_answer` VALUES ('1508', '64', '56', 'A');
INSERT INTO `exam_answer` VALUES ('1509', '64', '17', 'D');
INSERT INTO `exam_answer` VALUES ('1510', '64', '58', 'B');
INSERT INTO `exam_answer` VALUES ('1511', '64', '8', 'D');
INSERT INTO `exam_answer` VALUES ('1512', '64', '16', 'C');
INSERT INTO `exam_answer` VALUES ('1513', '64', '10', '');
INSERT INTO `exam_answer` VALUES ('1514', '64', '15', 'A');
INSERT INTO `exam_answer` VALUES ('1515', '64', '13', 'A,C,D');
INSERT INTO `exam_answer` VALUES ('1516', '64', '14', 'A,B');
INSERT INTO `exam_answer` VALUES ('1517', '64', '46', 'False');
INSERT INTO `exam_answer` VALUES ('1518', '64', '55', 'True');
INSERT INTO `exam_answer` VALUES ('1519', '64', '49', 'True');
INSERT INTO `exam_answer` VALUES ('1520', '64', '47', 'False');
INSERT INTO `exam_answer` VALUES ('1521', '64', '48', 'True');
INSERT INTO `exam_answer` VALUES ('1522', '65', '5', 'A');
INSERT INTO `exam_answer` VALUES ('1523', '65', '15', 'A');
INSERT INTO `exam_answer` VALUES ('1524', '65', '12', 'B');
INSERT INTO `exam_answer` VALUES ('1525', '65', '8', 'D');
INSERT INTO `exam_answer` VALUES ('1526', '65', '58', 'B');
INSERT INTO `exam_answer` VALUES ('1527', '65', '56', 'A');
INSERT INTO `exam_answer` VALUES ('1528', '65', '16', 'C');
INSERT INTO `exam_answer` VALUES ('1529', '65', '52', 'C');
INSERT INTO `exam_answer` VALUES ('1530', '65', '17', 'D');
INSERT INTO `exam_answer` VALUES ('1531', '65', '6', 'D');
INSERT INTO `exam_answer` VALUES ('1532', '65', '18', 'B');
INSERT INTO `exam_answer` VALUES ('1533', '65', '54', 'A');
INSERT INTO `exam_answer` VALUES ('1534', '65', '50', 'A');
INSERT INTO `exam_answer` VALUES ('1535', '65', '7', 'D');
INSERT INTO `exam_answer` VALUES ('1536', '65', '53', 'B');
INSERT INTO `exam_answer` VALUES ('1537', '65', '57', 'C');
INSERT INTO `exam_answer` VALUES ('1538', '65', '10', '');
INSERT INTO `exam_answer` VALUES ('1539', '65', '9', 'C');
INSERT INTO `exam_answer` VALUES ('1540', '65', '14', 'A,B,D');
INSERT INTO `exam_answer` VALUES ('1541', '65', '13', 'A,C,D');
INSERT INTO `exam_answer` VALUES ('1542', '65', '55', 'True');
INSERT INTO `exam_answer` VALUES ('1543', '65', '47', 'False');
INSERT INTO `exam_answer` VALUES ('1544', '65', '46', 'True');
INSERT INTO `exam_answer` VALUES ('1545', '65', '49', 'True');
INSERT INTO `exam_answer` VALUES ('1546', '65', '48', 'True');
INSERT INTO `exam_answer` VALUES ('1547', '66', '53', 'B');
INSERT INTO `exam_answer` VALUES ('1548', '66', '57', 'A');
INSERT INTO `exam_answer` VALUES ('1549', '66', '15', 'A');
INSERT INTO `exam_answer` VALUES ('1550', '66', '9', 'C');
INSERT INTO `exam_answer` VALUES ('1551', '66', '17', 'D');
INSERT INTO `exam_answer` VALUES ('1552', '66', '18', 'B');
INSERT INTO `exam_answer` VALUES ('1553', '66', '54', 'A');
INSERT INTO `exam_answer` VALUES ('1554', '66', '7', 'D');
INSERT INTO `exam_answer` VALUES ('1555', '66', '16', 'C');
INSERT INTO `exam_answer` VALUES ('1556', '66', '5', 'A');
INSERT INTO `exam_answer` VALUES ('1557', '66', '56', 'D');
INSERT INTO `exam_answer` VALUES ('1558', '66', '6', 'A');
INSERT INTO `exam_answer` VALUES ('1559', '66', '58', 'B');
INSERT INTO `exam_answer` VALUES ('1560', '66', '12', 'C');
INSERT INTO `exam_answer` VALUES ('1561', '66', '8', 'D');
INSERT INTO `exam_answer` VALUES ('1562', '66', '50', 'A');
INSERT INTO `exam_answer` VALUES ('1563', '66', '10', 'B');
INSERT INTO `exam_answer` VALUES ('1564', '66', '52', 'A');
INSERT INTO `exam_answer` VALUES ('1565', '66', '13', 'A,D');
INSERT INTO `exam_answer` VALUES ('1566', '66', '14', 'A,B');
INSERT INTO `exam_answer` VALUES ('1567', '66', '46', 'True');
INSERT INTO `exam_answer` VALUES ('1568', '66', '48', 'True');
INSERT INTO `exam_answer` VALUES ('1569', '66', '47', 'False');
INSERT INTO `exam_answer` VALUES ('1570', '66', '49', 'True');
INSERT INTO `exam_answer` VALUES ('1571', '66', '55', 'True');
INSERT INTO `exam_answer` VALUES ('1572', '67', '54', 'A');
INSERT INTO `exam_answer` VALUES ('1573', '67', '9', 'A');
INSERT INTO `exam_answer` VALUES ('1574', '67', '10', 'D');
INSERT INTO `exam_answer` VALUES ('1575', '67', '12', 'A');
INSERT INTO `exam_answer` VALUES ('1576', '67', '7', 'D');
INSERT INTO `exam_answer` VALUES ('1577', '67', '8', 'D');
INSERT INTO `exam_answer` VALUES ('1578', '67', '16', 'C');
INSERT INTO `exam_answer` VALUES ('1579', '67', '53', 'B');
INSERT INTO `exam_answer` VALUES ('1580', '67', '18', 'B');
INSERT INTO `exam_answer` VALUES ('1581', '67', '50', 'A');
INSERT INTO `exam_answer` VALUES ('1582', '67', '17', 'D');
INSERT INTO `exam_answer` VALUES ('1583', '67', '56', 'A');
INSERT INTO `exam_answer` VALUES ('1584', '67', '5', 'A');
INSERT INTO `exam_answer` VALUES ('1585', '67', '6', 'D');
INSERT INTO `exam_answer` VALUES ('1586', '67', '52', 'C');
INSERT INTO `exam_answer` VALUES ('1587', '67', '57', 'A');
INSERT INTO `exam_answer` VALUES ('1588', '67', '58', 'B');
INSERT INTO `exam_answer` VALUES ('1589', '67', '15', '');
INSERT INTO `exam_answer` VALUES ('1590', '67', '14', 'A,B');
INSERT INTO `exam_answer` VALUES ('1591', '67', '13', 'A,D');
INSERT INTO `exam_answer` VALUES ('1592', '67', '46', 'False');
INSERT INTO `exam_answer` VALUES ('1593', '67', '55', 'True');
INSERT INTO `exam_answer` VALUES ('1594', '67', '48', 'True');
INSERT INTO `exam_answer` VALUES ('1595', '67', '47', 'False');
INSERT INTO `exam_answer` VALUES ('1596', '67', '49', 'True');
INSERT INTO `exam_answer` VALUES ('1597', '68', '56', 'A');
INSERT INTO `exam_answer` VALUES ('1598', '68', '18', 'B');
INSERT INTO `exam_answer` VALUES ('1599', '68', '10', '');
INSERT INTO `exam_answer` VALUES ('1600', '68', '50', 'A');
INSERT INTO `exam_answer` VALUES ('1601', '68', '58', 'B');
INSERT INTO `exam_answer` VALUES ('1602', '68', '16', 'C');
INSERT INTO `exam_answer` VALUES ('1603', '68', '5', 'A');
INSERT INTO `exam_answer` VALUES ('1604', '68', '15', 'A');
INSERT INTO `exam_answer` VALUES ('1605', '68', '8', 'D');
INSERT INTO `exam_answer` VALUES ('1606', '68', '52', 'C');
INSERT INTO `exam_answer` VALUES ('1607', '68', '6', 'D');
INSERT INTO `exam_answer` VALUES ('1608', '68', '9', 'C');
INSERT INTO `exam_answer` VALUES ('1609', '68', '53', 'B');
INSERT INTO `exam_answer` VALUES ('1610', '68', '57', 'A');
INSERT INTO `exam_answer` VALUES ('1611', '68', '12', 'A');
INSERT INTO `exam_answer` VALUES ('1612', '68', '54', 'C');
INSERT INTO `exam_answer` VALUES ('1613', '68', '17', 'D');
INSERT INTO `exam_answer` VALUES ('1614', '68', '7', 'D');
INSERT INTO `exam_answer` VALUES ('1615', '68', '14', 'A,B');
INSERT INTO `exam_answer` VALUES ('1616', '68', '13', 'A,C,D');
INSERT INTO `exam_answer` VALUES ('1617', '68', '47', 'False');
INSERT INTO `exam_answer` VALUES ('1618', '68', '46', 'False');
INSERT INTO `exam_answer` VALUES ('1619', '68', '49', 'True');
INSERT INTO `exam_answer` VALUES ('1620', '68', '55', 'True');
INSERT INTO `exam_answer` VALUES ('1621', '68', '48', 'False');

-- ----------------------------
-- Table structure for `exam_paper`
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper`;
CREATE TABLE `exam_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) DEFAULT NULL,
  `total_time` int(11) DEFAULT NULL,
  `total_score` double(11,2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper
-- ----------------------------
INSERT INTO `exam_paper` VALUES ('67', 'Java_Framework_j2101_王炼_admin', '45', '67.50', '2021-05-14 08:39:14');

-- ----------------------------
-- Table structure for `exam_paper_question`
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper_question`;
CREATE TABLE `exam_paper_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1497 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper_question
-- ----------------------------
INSERT INTO `exam_paper_question` VALUES ('1472', '67', '9');
INSERT INTO `exam_paper_question` VALUES ('1473', '67', '57');
INSERT INTO `exam_paper_question` VALUES ('1474', '67', '54');
INSERT INTO `exam_paper_question` VALUES ('1475', '67', '7');
INSERT INTO `exam_paper_question` VALUES ('1476', '67', '18');
INSERT INTO `exam_paper_question` VALUES ('1477', '67', '50');
INSERT INTO `exam_paper_question` VALUES ('1478', '67', '16');
INSERT INTO `exam_paper_question` VALUES ('1479', '67', '5');
INSERT INTO `exam_paper_question` VALUES ('1480', '67', '14');
INSERT INTO `exam_paper_question` VALUES ('1481', '67', '13');
INSERT INTO `exam_paper_question` VALUES ('1482', '67', '47');
INSERT INTO `exam_paper_question` VALUES ('1483', '67', '49');
INSERT INTO `exam_paper_question` VALUES ('1484', '67', '55');
INSERT INTO `exam_paper_question` VALUES ('1485', '67', '48');
INSERT INTO `exam_paper_question` VALUES ('1486', '67', '53');
INSERT INTO `exam_paper_question` VALUES ('1487', '67', '12');
INSERT INTO `exam_paper_question` VALUES ('1488', '67', '17');
INSERT INTO `exam_paper_question` VALUES ('1489', '67', '56');
INSERT INTO `exam_paper_question` VALUES ('1490', '67', '10');
INSERT INTO `exam_paper_question` VALUES ('1491', '67', '58');
INSERT INTO `exam_paper_question` VALUES ('1492', '67', '15');
INSERT INTO `exam_paper_question` VALUES ('1493', '67', '8');
INSERT INTO `exam_paper_question` VALUES ('1494', '67', '52');
INSERT INTO `exam_paper_question` VALUES ('1495', '67', '46');
INSERT INTO `exam_paper_question` VALUES ('1496', '67', '6');

-- ----------------------------
-- Table structure for `exam_question`
-- ----------------------------
DROP TABLE IF EXISTS `exam_question`;
CREATE TABLE `exam_question` (
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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_question
-- ----------------------------
INSERT INTO `exam_question` VALUES ('1', 'singleChoice', 'Java_SE', '2.5', 'Java 字节码文件的扩展名是？', 'java', 'class', 'exe', 'jsp', 'B', '');
INSERT INTO `exam_question` VALUES ('2', 'singleChoice', 'Java_SE', '2.5', '下面哪项所占空间最小？', 'byte', 'short', 'boolean', 'long', 'C', '');
INSERT INTO `exam_question` VALUES ('3', 'singleChoice', 'Java_SE', '2.5', '下面哪项属于循环代码块？', 'for 语句', 'if 语句', 'main 方法', 'class 类', 'A', '');
INSERT INTO `exam_question` VALUES ('4', 'singleChoice', 'Java_SE', '2.5', '访问修饰符范围比较正确的是？', 'public > default > protected > private', 'public > default > privite > protected', 'public > protected > default > private', 'public > protected > 不写 > private', 'C', '');
INSERT INTO `exam_question` VALUES ('5', 'singleChoice', 'Java_Framework', '2.5', 'Spring Boot 配置，以下哪个优先级最高？', '外置：xx.jar 同目录下 /config/application.properties', '外置：xx.jar 同目录下 /config/application.yml', '内置：src/main/resources/config', '内置：src/main/resources', 'A', 'Spring Boot 配置');
INSERT INTO `exam_question` VALUES ('6', 'singleChoice', 'Java_Framework', '2.5', '注解的作用域不包括？', 'SOURCE', 'CLASS', 'RUNTIME', 'JAVA', 'D', '注解');
INSERT INTO `exam_question` VALUES ('7', 'singleChoice', 'Java_Framework', '2.5', '以下 Log 日志级别哪个最高？', 'DEBUG', 'INFO', 'WARN', 'ERROR', 'D', '');
INSERT INTO `exam_question` VALUES ('8', 'singleChoice', 'Java_Framework', '2.5', '以下不是 Spring Boot 的核心注解的是？', '@SpringBootConfiguration', '@EnableAutoConfiguration', '@ComponentScan', '@MapperScan', 'D', '');
INSERT INTO `exam_question` VALUES ('9', 'singleChoice', 'Java_Framework', '2.5', 'Spring Boot 中要使用 SpringMVC 的功能，哪个架包是必须加的？', 'spring-boot-starter-jdbc', 'spring-boot-starter-thymeleaf', 'spring-boot-starter-web', 'mybatis-spring-boot-starter', 'C', '');
INSERT INTO `exam_question` VALUES ('10', 'singleChoice', 'Java_Framework', '2.5', '以下哪个注解不能加在类上？', '@Controller', '@ResponseBody', '@RestController', '@RequestMapping', '无解', '');
INSERT INTO `exam_question` VALUES ('12', 'singleChoice', 'Java_Framework', '2.5', '当控制层上有 @RestController 注解时，方法中返回一个字符串“< h1>Hello< /h1>”，浏览器调用的结果是？', '一级标题显示的 Hello', '找不到 Hello.html', '<h1>Hello</h1>', 'Hello', 'A', '');
INSERT INTO `exam_question` VALUES ('13', 'multipleChoice', 'Java_Framework', '5', 'Spring Boot 项目中配置文件的格式？', 'properties', 'txt', 'xml', 'yml', 'A,D', '');
INSERT INTO `exam_question` VALUES ('14', 'multipleChoice', 'Java_Framework', '5', 'Spring Boot 核心配置文件包括？', 'bootstrap', 'application', 'application-dev', 'logback', 'A,B', '');
INSERT INTO `exam_question` VALUES ('15', 'singleChoice', 'Java_Framework', '2.5', '前台使用 Json 参数格式，控制器 consumer 属性、参数注解分别是？', 'application/josn ---- @RequestBody', 'application/josn ---- @ModelAttribute', 'application/x-www-form-urlencoded ---- @RequestBody', 'application/x-www-form-urlencoded ---- @ModelAttribute', 'A', '');
INSERT INTO `exam_question` VALUES ('16', 'singleChoice', 'Java_Framework', '2.5', '@Pointcut(\"execution(public * com.thornBird.sbd.modules.*.controller.*.*(..))\")，第三个 * 代表？', '代表返回类型不限', '代表 module 下所有子包', '代表 controller 包下所有类', '代表所有方法', 'C', '');
INSERT INTO `exam_question` VALUES ('17', 'singleChoice', 'Java_Framework', '2.5', 'Url 匹配风格中 /admin*，以下哪个匹配不正确？', '/admin', '/admin1', '/admin123', '/admin/1', 'D', '');
INSERT INTO `exam_question` VALUES ('18', 'singleChoice', 'Java_Framework', '2.5', 'Mybatis 框架中，插入数据使用那个注解', '@Update', '@Insert', '@Select', '@InsertMapping', 'B', '');
INSERT INTO `exam_question` VALUES ('19', 'fillBlank', 'Java_Framework', '2.5', '获取配置文件的属性值，使用哪个注解？', '', '', '', '', '@Value', '');
INSERT INTO `exam_question` VALUES ('20', 'fillBlank', 'Java_Framework', '2.5', 'Spring 配置依赖的 2 个注解是', '', '', '', '', '@Configration----@Bean', '');
INSERT INTO `exam_question` VALUES ('21', 'fillBlank', 'Java_Framework', '2.5', 'Spring Boot 修改 Tomcat 端口号为 9090 应该怎么写？', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('22', 'fillBlank', 'Java_Framework', '2.5', '自定义拦截器需要实现什么接口？', '', '', '', '', 'HandlerInterceptor', '');
INSERT INTO `exam_question` VALUES ('23', 'fillBlank', 'Java_EE', '2.5', '过滤器需要使用什么注解？', '', '', '', '', '@WebFilter', '');
INSERT INTO `exam_question` VALUES ('24', 'fillBlank', 'Java_Framework', '2.5', '上传文件使用什么对象接收文件？consumer使用什么类型？', '', '', '', '', 'MultipartFile----multipart/form-data', '');
INSERT INTO `exam_question` VALUES ('25', 'shortAnswer', 'Java_Framework', '5', '测试接口的方法？', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('26', 'shortAnswer', 'Java_Framework', '5', 'Mybatis 传参中，#{*}、${*}的区别？', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('27', 'shortAnswer', 'Java_Framework', '5', '简述 Restful 规则？', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('28', 'shortAnswer', 'Java_Framework', '5', '数据安全和证书安全的区别？', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('29', 'shortAnswer', 'Java_Framework', '5', '简述页面碎片化和页面模块化？', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('30', 'shortAnswer', 'Java_Framework', '5', '@SpringBootApplication 注解的作用是什么？', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('31', 'shortAnswer', 'Java_Framework', '5', '简述 Spring Boot pom 文件父子继承、start 按组聚集 jar 的运用？', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('32', 'shortAnswer', 'Java_Framework', '5', 'Spring Boot 中能否直接重定向到 templates 目录？', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('33', 'shortAnswer', 'Java_Framework', '5', '简述 Spring', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('34', 'shortAnswer', 'Java_Framework', '5', '简述 MVC、MVVM', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('35', 'shortAnswer', 'Java_Framework', '5', '简述 Git 使用流程，写几个常用 Git 命令', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('36', 'shortAnswer', 'Java_Framework', '5', '简述敏捷开发、Scrum 流程', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('37', 'shortAnswer', 'Java_Framework', '5', '简述项目开发流程', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('38', 'shortAnswer', 'Front_Js', '5', '简述 Ajax，Json 和 Form 提交', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('39', 'shortAnswer', 'Java_Framework', '5', '简述 Shiro 两大功能实现流程', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('40', 'shortAnswer', 'Java_Framework', '5', '简述 Mybatis 和 Jpa 的区别', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('41', 'shortAnswer', 'Java_Framework', '5', '为什么我们需要 spring-boot-maven-plugin', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('42', 'shortAnswer', 'Java_Framework', '5', '什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('43', 'programming', 'Java_Framework', '15', '访问控制层，将一个 List 装入 requset 中，再在页面上以表格的形式显示出来', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('44', 'programming', 'Java_Framework', '15', '请写出重定向到某个页面的代码', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('45', 'programming', 'Java_Framework', '15', '设计一套购物车接口，以 Cookie 或者 Redis 实现', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('46', 'judge', 'Java_Framework', '2.5', 'MyBatis 不支持延迟加载', '', '', '', '', 'False', '');
INSERT INTO `exam_question` VALUES ('47', 'judge', 'Java_Framework', '2.5', '分布式和集群是一回事', '', '', '', '', 'False', '');
INSERT INTO `exam_question` VALUES ('48', 'judge', 'Java_Framework', '2.5', 'MongoDB 是文件形数据库', '', '', '', '', 'True', '');
INSERT INTO `exam_question` VALUES ('49', 'judge', 'Java_Framework', '2.5', 'Redis 是内存数据库', '', '', '', '', 'True', '');
INSERT INTO `exam_question` VALUES ('50', 'singleChoice', 'Java_Framework', '2.5', 'Spring DAO 中最常用的类是？', 'JdbcTemplate', 'SimpleJdbcInsert', 'SimpleJdbcInsert', 'SimpleJdbcQuery', 'A', '');
INSERT INTO `exam_question` VALUES ('51', 'singleChoice', 'Java_EE', '2.5', 'Spring AOP 中， 织入（Weaving） 可以在下面什么时间完成？', '全部选项', 'Run time', 'Load time', 'Compile time', 'A', '');
INSERT INTO `exam_question` VALUES ('52', 'singleChoice', 'Java_Framework', '2.5', '下面关于Spring MVC 描述正确的是？', 'DispatcherServlet 在 Spring MVC 中是核心servlet , 它负责接收请求并将请求分发给适合的控制器', '在Spring MVC 中,可以配置多个 DispatcherServlet', '全部选项', '要使 Spring MVC 可用，DispatcherServlet 需要在 web.xml 中配置', 'C', '');
INSERT INTO `exam_question` VALUES ('53', 'singleChoice', 'Java_Framework', '2.5', '下面哪项是 Spring 自动装载模式？', 'autodetect', '全部选项', 'constructor', 'byname, byType', 'B', '');
INSERT INTO `exam_question` VALUES ('54', 'singleChoice', 'Java_Framework', '2.5', 'Spring 中，下面哪一项不是使用事务的方法？', 'proxies', 'declaratively', 'programmaticly', '全部', 'A', '');
INSERT INTO `exam_question` VALUES ('55', 'judge', 'Java_Framework', '2.5', 'Spring 提供了 JMS 层的抽象，正确吗？', '', '', '', '', 'True', '');
INSERT INTO `exam_question` VALUES ('56', 'singleChoice', 'Java_Framework', '2.5', '关于\"@Order\"注解，最正确的描述是？', '实现 org.springframework.core.Ordered 接口', '指定一个 bean 的范围', '通常用于注入域对象的属性', '全不正确', 'A', '');
INSERT INTO `exam_question` VALUES ('57', 'singleChoice', 'Java_Framework', '2.5', '如何在 Spring 应用中使用 SLF4J？', '作为日志框架', '全不正确', '作为一个 Bean', '作为 JDBC 框架', 'A', '');
INSERT INTO `exam_question` VALUES ('58', 'singleChoice', 'Java_Framework', '2.5', 'Spring Bean 的默认作用范围是？', '全不正确', 'Singleton', 'Prototype', 'Session', 'B', '');
