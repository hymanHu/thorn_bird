/*
Navicat MySQL Data Transfer

Source Server         : myConnection
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2020-12-25 22:20:15
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `user_answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('151', '7', '53', 'B');
INSERT INTO `answer` VALUES ('152', '7', '6', 'D');
INSERT INTO `answer` VALUES ('153', '7', '18', 'B');
INSERT INTO `answer` VALUES ('154', '7', '57', 'A');
INSERT INTO `answer` VALUES ('155', '7', '56', 'A');
INSERT INTO `answer` VALUES ('156', '7', '8', 'D');
INSERT INTO `answer` VALUES ('157', '7', '15', 'A');
INSERT INTO `answer` VALUES ('158', '7', '7', 'D');
INSERT INTO `answer` VALUES ('159', '7', '12', 'A');
INSERT INTO `answer` VALUES ('160', '7', '9', 'C');
INSERT INTO `answer` VALUES ('161', '7', '13', 'A,D');
INSERT INTO `answer` VALUES ('162', '7', '14', 'A,B');
INSERT INTO `answer` VALUES ('163', '7', '49', 'True');
INSERT INTO `answer` VALUES ('164', '7', '46', 'True');
INSERT INTO `answer` VALUES ('165', '7', '55', 'False');
INSERT INTO `answer` VALUES ('166', '7', '47', 'False');
INSERT INTO `answer` VALUES ('167', '7', '19', 'cdsacdascd');
INSERT INTO `answer` VALUES ('168', '7', '24', 'cdacdsacdas');
INSERT INTO `answer` VALUES ('169', '7', '22', 'csacdsa');
INSERT INTO `answer` VALUES ('170', '7', '21', 'cdsacdsacdas');
INSERT INTO `answer` VALUES ('171', '7', '31', 'cdsacdasc');
INSERT INTO `answer` VALUES ('172', '7', '26', 'cdascdas');
INSERT INTO `answer` VALUES ('173', '7', '32', 'csadcdas');
INSERT INTO `answer` VALUES ('174', '7', '45', 'cdsacdasc');
INSERT INTO `answer` VALUES ('175', '7', '43', 'cadscdasds');
INSERT INTO `answer` VALUES ('176', '8', '7', 'D');
INSERT INTO `answer` VALUES ('177', '8', '9', 'C');
INSERT INTO `answer` VALUES ('178', '8', '17', 'D');
INSERT INTO `answer` VALUES ('179', '8', '5', 'A');
INSERT INTO `answer` VALUES ('180', '8', '58', 'A');
INSERT INTO `answer` VALUES ('181', '8', '56', 'A');
INSERT INTO `answer` VALUES ('182', '8', '16', 'C');
INSERT INTO `answer` VALUES ('183', '8', '54', 'D');
INSERT INTO `answer` VALUES ('184', '8', '10', 'B');
INSERT INTO `answer` VALUES ('185', '8', '53', 'B');
INSERT INTO `answer` VALUES ('186', '8', '12', 'A');
INSERT INTO `answer` VALUES ('187', '8', '18', 'B');
INSERT INTO `answer` VALUES ('188', '8', '50', 'A');
INSERT INTO `answer` VALUES ('189', '8', '52', '');
INSERT INTO `answer` VALUES ('190', '8', '6', 'D');
INSERT INTO `answer` VALUES ('191', '8', '15', 'A');
INSERT INTO `answer` VALUES ('192', '8', '8', 'D');
INSERT INTO `answer` VALUES ('193', '8', '57', 'A');
INSERT INTO `answer` VALUES ('194', '8', '13', 'A,D');
INSERT INTO `answer` VALUES ('195', '8', '14', 'A,B');
INSERT INTO `answer` VALUES ('196', '8', '47', 'True');
INSERT INTO `answer` VALUES ('197', '8', '48', 'True');
INSERT INTO `answer` VALUES ('198', '8', '49', 'False');
INSERT INTO `answer` VALUES ('199', '8', '55', 'False');
INSERT INTO `answer` VALUES ('200', '8', '46', 'False');

-- ----------------------------
-- Table structure for `exam`
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('7', '4', 'Java_Framework_20201224_admin', '100.00', '40.0 ~ 95.0', '0.00', '60', '1', '2020-12-25 22:14:52');
INSERT INTO `exam` VALUES ('8', '4', 'Java_Framework_1932_admin', '67.50', '50.0 ~ 50.0', '50.00', '60', '2', '2020-12-25 22:18:02');

-- ----------------------------
-- Table structure for `paper`
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) DEFAULT NULL,
  `total_time` int(11) DEFAULT NULL,
  `total_score` double(11,2) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('43', 'Java_Framework_20201224_admin', '60', '100.00', '2020-12-24 08:18:05');
INSERT INTO `paper` VALUES ('44', 'Java_Framework_1932_admin', '60', '67.50', '2020-12-25 21:58:37');

-- ----------------------------
-- Table structure for `paper_question`
-- ----------------------------
DROP TABLE IF EXISTS `paper_question`;
CREATE TABLE `paper_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=967 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper_question
-- ----------------------------
INSERT INTO `paper_question` VALUES ('917', '43', '15');
INSERT INTO `paper_question` VALUES ('918', '43', '7');
INSERT INTO `paper_question` VALUES ('919', '43', '12');
INSERT INTO `paper_question` VALUES ('920', '43', '9');
INSERT INTO `paper_question` VALUES ('921', '43', '53');
INSERT INTO `paper_question` VALUES ('922', '43', '6');
INSERT INTO `paper_question` VALUES ('923', '43', '18');
INSERT INTO `paper_question` VALUES ('924', '43', '57');
INSERT INTO `paper_question` VALUES ('925', '43', '19');
INSERT INTO `paper_question` VALUES ('926', '43', '24');
INSERT INTO `paper_question` VALUES ('927', '43', '22');
INSERT INTO `paper_question` VALUES ('928', '43', '21');
INSERT INTO `paper_question` VALUES ('929', '43', '13');
INSERT INTO `paper_question` VALUES ('930', '43', '14');
INSERT INTO `paper_question` VALUES ('931', '43', '46');
INSERT INTO `paper_question` VALUES ('932', '43', '55');
INSERT INTO `paper_question` VALUES ('933', '43', '47');
INSERT INTO `paper_question` VALUES ('934', '43', '49');
INSERT INTO `paper_question` VALUES ('935', '43', '31');
INSERT INTO `paper_question` VALUES ('936', '43', '26');
INSERT INTO `paper_question` VALUES ('937', '43', '45');
INSERT INTO `paper_question` VALUES ('938', '43', '43');
INSERT INTO `paper_question` VALUES ('939', '43', '56');
INSERT INTO `paper_question` VALUES ('940', '43', '32');
INSERT INTO `paper_question` VALUES ('941', '43', '8');
INSERT INTO `paper_question` VALUES ('942', '44', '9');
INSERT INTO `paper_question` VALUES ('943', '44', '17');
INSERT INTO `paper_question` VALUES ('944', '44', '58');
INSERT INTO `paper_question` VALUES ('945', '44', '16');
INSERT INTO `paper_question` VALUES ('946', '44', '10');
INSERT INTO `paper_question` VALUES ('947', '44', '53');
INSERT INTO `paper_question` VALUES ('948', '44', '18');
INSERT INTO `paper_question` VALUES ('949', '44', '52');
INSERT INTO `paper_question` VALUES ('950', '44', '13');
INSERT INTO `paper_question` VALUES ('951', '44', '14');
INSERT INTO `paper_question` VALUES ('952', '44', '55');
INSERT INTO `paper_question` VALUES ('953', '44', '46');
INSERT INTO `paper_question` VALUES ('954', '44', '47');
INSERT INTO `paper_question` VALUES ('955', '44', '48');
INSERT INTO `paper_question` VALUES ('956', '44', '5');
INSERT INTO `paper_question` VALUES ('957', '44', '56');
INSERT INTO `paper_question` VALUES ('958', '44', '54');
INSERT INTO `paper_question` VALUES ('959', '44', '49');
INSERT INTO `paper_question` VALUES ('960', '44', '12');
INSERT INTO `paper_question` VALUES ('961', '44', '50');
INSERT INTO `paper_question` VALUES ('962', '44', '6');
INSERT INTO `paper_question` VALUES ('963', '44', '15');
INSERT INTO `paper_question` VALUES ('964', '44', '8');
INSERT INTO `paper_question` VALUES ('965', '44', '57');
INSERT INTO `paper_question` VALUES ('966', '44', '7');

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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', 'singleChoice', 'Java_SE', '2.5', 'Java 字节码文件的扩展名是？', 'java', 'class', 'exe', 'jsp', 'B', '');
INSERT INTO `question` VALUES ('2', 'singleChoice', 'Java_SE', '2.5', '下面哪项所占空间最小？', 'byte', 'short', 'boolean', 'long', 'C', '');
INSERT INTO `question` VALUES ('3', 'singleChoice', 'Java_SE', '2.5', '下面哪项属于循环代码块？', 'for 语句', 'if 语句', 'main 方法', 'class 类', 'A', '');
INSERT INTO `question` VALUES ('4', 'singleChoice', 'Java_SE', '2.5', '访问修饰符范围比较正确的是？', 'public > default > protected > private', 'public > default > privite > protected', 'public > protected > default > private', 'public > protected > 不写 > private', 'C', '');
INSERT INTO `question` VALUES ('5', 'singleChoice', 'Java_Framework', '2.5', 'Spring Boot 配置，以下哪个优先级最高？', '外置：xx.jar 同目录下 /config/application.properties', '外置：xx.jar 同目录下 /config/application.yml', '内置：src/main/resources/config', '内置：src/main/resources', 'A', 'Spring Boot 配置');
INSERT INTO `question` VALUES ('6', 'singleChoice', 'Java_Framework', '2.5', '注解的作用域不包括？', 'SOURCE', 'CLASS', 'RUNTIME', 'JAVA', 'D', '注解');
INSERT INTO `question` VALUES ('7', 'singleChoice', 'Java_Framework', '2.5', '以下 Log 日志级别哪个最高？', 'DEBUG', 'INFO', 'WARN', 'ERROR', 'D', '');
INSERT INTO `question` VALUES ('8', 'singleChoice', 'Java_Framework', '2.5', '以下不是 Spring Boot 的核心注解的是？', '@SpringBootConfiguration', '@EnableAutoConfiguration', '@ComponentScan', '@MapperScan', 'D', '');
INSERT INTO `question` VALUES ('9', 'singleChoice', 'Java_Framework', '2.5', 'Spring Boot 中要使用 SpringMVC 的功能，哪个架包是必须加的？', 'spring-boot-starter-jdbc', 'spring-boot-starter-thymeleaf', 'spring-boot-starter-web', 'mybatis-spring-boot-starter', 'C', '');
INSERT INTO `question` VALUES ('10', 'singleChoice', 'Java_Framework', '2.5', '以下哪个注解不能加在类上？', '@Controller', '@ResponseBody', '@RestController', '@RequestMapping', '无解', '');
INSERT INTO `question` VALUES ('12', 'singleChoice', 'Java_Framework', '2.5', '当控制层上有 @RestController 注解时，方法中返回一个字符串“< h1>Hello< /h1>”，浏览器调用的结果是？', '一级标题显示的 Hello', '找不到 Hello.html', '<h1>Hello</h1>', 'Hello', 'A', '');
INSERT INTO `question` VALUES ('13', 'multipleChoice', 'Java_Framework', '5', 'Spring Boot 项目中配置文件的格式？', 'properties', 'txt', 'xml', 'yml', 'A,D', '');
INSERT INTO `question` VALUES ('14', 'multipleChoice', 'Java_Framework', '5', 'Spring Boot 核心配置文件包括？', 'bootstrap', 'application', 'application-dev', 'logback', 'A,B', '');
INSERT INTO `question` VALUES ('15', 'singleChoice', 'Java_Framework', '2.5', '前台使用 Json 参数格式，控制器 consumer 属性、参数注解分别是？', 'application/josn ---- @RequestBody', 'application/josn ---- @ModelAttribute', 'application/x-www-form-urlencoded ---- @RequestBody', 'application/x-www-form-urlencoded ---- @ModelAttribute', 'A', '');
INSERT INTO `question` VALUES ('16', 'singleChoice', 'Java_Framework', '2.5', '@Pointcut(\"execution(public * com.thornBird.sbd.modules.*.controller.*.*(..))\")，第三个 * 代表？', '代表返回类型不限', '代表 module 下所有子包', '代表 controller 包下所有类', '代表所有方法', 'C', '');
INSERT INTO `question` VALUES ('17', 'singleChoice', 'Java_Framework', '2.5', 'Url 匹配风格中 /admin*，以下哪个匹配不正确？', '/admin', '/admin1', '/admin123', '/admin/1', 'D', '');
INSERT INTO `question` VALUES ('18', 'singleChoice', 'Java_Framework', '2.5', 'Mybatis 框架中，插入数据使用那个注解', '@Update', '@Insert', '@Select', '@InsertMapping', 'B', '');
INSERT INTO `question` VALUES ('19', 'fillBlank', 'Java_Framework', '2.5', '获取配置文件的属性值，使用哪个注解？', '', '', '', '', '@Value', '');
INSERT INTO `question` VALUES ('20', 'fillBlank', 'Java_Framework', '2.5', 'Spring 配置依赖的 2 个注解是', '', '', '', '', '@Configration----@Bean', '');
INSERT INTO `question` VALUES ('21', 'fillBlank', 'Java_Framework', '2.5', 'Spring Boot 修改 Tomcat 端口号为 9090 应该怎么写？', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('22', 'fillBlank', 'Java_Framework', '2.5', '自定义拦截器需要实现什么接口？', '', '', '', '', 'HandlerInterceptor', '');
INSERT INTO `question` VALUES ('23', 'fillBlank', 'Java_EE', '2.5', '过滤器需要使用什么注解？', '', '', '', '', '@WebFilter', '');
INSERT INTO `question` VALUES ('24', 'fillBlank', 'Java_Framework', '2.5', '上传文件使用什么对象接收文件？consumer使用什么类型？', '', '', '', '', 'MultipartFile----multipart/form-data', '');
INSERT INTO `question` VALUES ('25', 'shortAnswer', 'Java_Framework', '5', '测试接口的方法？', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('26', 'shortAnswer', 'Java_Framework', '5', 'Mybatis 传参中，#{*}、${*}的区别？', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('27', 'shortAnswer', 'Java_Framework', '5', '简述 Restful 规则？', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('28', 'shortAnswer', 'Java_Framework', '5', '数据安全和证书安全的区别？', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('29', 'shortAnswer', 'Java_Framework', '5', '简述页面碎片化和页面模块化？', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('30', 'shortAnswer', 'Java_Framework', '5', '@SpringBootApplication 注解的作用是什么？', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('31', 'shortAnswer', 'Java_Framework', '5', '简述 Spring Boot pom 文件父子继承、start 按组聚集 jar 的运用？', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('32', 'shortAnswer', 'Java_Framework', '5', 'Spring Boot 中能否直接重定向到 templates 目录？', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('33', 'shortAnswer', 'Java_Framework', '5', '简述 Spring', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('34', 'shortAnswer', 'Java_Framework', '5', '简述 MVC、MVVM', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('35', 'shortAnswer', 'Java_Framework', '5', '简述 Git 使用流程，写几个常用 Git 命令', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('36', 'shortAnswer', 'Java_Framework', '5', '简述敏捷开发、Scrum 流程', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('37', 'shortAnswer', 'Java_Framework', '5', '简述项目开发流程', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('38', 'shortAnswer', 'Front_Js', '5', '简述 Ajax，Json 和 Form 提交', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('39', 'shortAnswer', 'Java_Framework', '5', '简述 Shiro 两大功能实现流程', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('40', 'shortAnswer', 'Java_Framework', '5', '简述 Mybatis 和 Jpa 的区别', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('41', 'shortAnswer', 'Java_Framework', '5', '为什么我们需要 spring-boot-maven-plugin', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('42', 'shortAnswer', 'Java_Framework', '5', '什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('43', 'programming', 'Java_Framework', '15', '访问控制层，将一个 List 装入 requset 中，再在页面上以表格的形式显示出来', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('44', 'programming', 'Java_Framework', '15', '请写出重定向到某个页面的代码', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('45', 'programming', 'Java_Framework', '15', '设计一套购物车接口，以 Cookie 或者 Redis 实现', '', '', '', '', '', '');
INSERT INTO `question` VALUES ('46', 'judge', 'Java_Framework', '2.5', 'MyBatis 不支持延迟加载', '', '', '', '', 'False', '');
INSERT INTO `question` VALUES ('47', 'judge', 'Java_Framework', '2.5', '分布式和集群是一回事', '', '', '', '', 'False', '');
INSERT INTO `question` VALUES ('48', 'judge', 'Java_Framework', '2.5', 'MongoDB 是文件形数据库', '', '', '', '', 'True', '');
INSERT INTO `question` VALUES ('49', 'judge', 'Java_Framework', '2.5', 'Redis 是内存数据库', '', '', '', '', 'True', '');
INSERT INTO `question` VALUES ('50', 'singleChoice', 'Java_Framework', '2.5', 'Spring DAO 中最常用的类是？', 'JdbcTemplate', 'SimpleJdbcInsert', 'SimpleJdbcInsert', 'SimpleJdbcQuery', 'A', '');
INSERT INTO `question` VALUES ('51', 'singleChoice', 'Java_EE', '2.5', 'Spring AOP 中， 织入（Weaving） 可以在下面什么时间完成？', '全部选项', 'Run time', 'Load time', 'Compile time', 'A', '');
INSERT INTO `question` VALUES ('52', 'singleChoice', 'Java_Framework', '2.5', '下面关于Spring MVC 描述正确的是？', 'DispatcherServlet 在 Spring MVC 中是核心servlet , 它负责接收请求并将请求分发给适合的控制器', '在Spring MVC 中,可以配置多个 DispatcherServlet', '全部选项', '要使 Spring MVC 可用，DispatcherServlet 需要在 web.xml 中配置', 'C', '');
INSERT INTO `question` VALUES ('53', 'singleChoice', 'Java_Framework', '2.5', '下面哪项是 Spring 自动装载模式？', 'autodetect', '全部选项', 'constructor', 'byname, byType', 'B', '');
INSERT INTO `question` VALUES ('54', 'singleChoice', 'Java_Framework', '2.5', 'Spring 中，下面哪一项不是使用事务的方法？', 'proxies', 'declaratively', 'programmaticly', '全部', 'A', '');
INSERT INTO `question` VALUES ('55', 'judge', 'Java_Framework', '2.5', 'Spring 提供了 JMS 层的抽象，正确吗？', '', '', '', '', 'True', '');
INSERT INTO `question` VALUES ('56', 'singleChoice', 'Java_Framework', '2.5', '关于\"@Order\"注解，最正确的描述是？', '实现 org.springframework.core.Ordered 接口', '指定一个 bean 的范围', '通常用于注入域对象的属性', '全不正确', 'A', '');
INSERT INTO `question` VALUES ('57', 'singleChoice', 'Java_Framework', '2.5', '如何在 Spring 应用中使用 SLF4J？', '作为日志框架', '全不正确', '作为一个 Bean', '作为 JDBC 框架', 'A', '');
INSERT INTO `question` VALUES ('58', 'singleChoice', 'Java_Framework', '2.5', 'Spring Bean 的默认作用范围是？', '全不正确', 'Singleton', 'Prototype', 'Session', 'B', '');
