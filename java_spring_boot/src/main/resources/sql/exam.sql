/*
Navicat MySQL Data Transfer

Source Server         : myConnection
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2021-05-28 09:04:13
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `exam_achievement`
-- ----------------------------
DROP TABLE IF EXISTS `exam_achievement`;
CREATE TABLE `exam_achievement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `total_score` double DEFAULT NULL,
  `reference_score` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `percent_score` double DEFAULT NULL,
  `total_time` int(11) DEFAULT NULL,
  `spend_time` int(11) DEFAULT NULL,
  `exam_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_achievement
-- ----------------------------

-- ----------------------------
-- Table structure for `exam_answer`
-- ----------------------------
DROP TABLE IF EXISTS `exam_answer`;
CREATE TABLE `exam_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `achievement_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `user_answer` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_answer
-- ----------------------------

-- ----------------------------
-- Table structure for `exam_paper`
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper`;
CREATE TABLE `exam_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `subject` text,
  `total_time` int(11) DEFAULT NULL,
  `total_score` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper
-- ----------------------------

-- ----------------------------
-- Table structure for `exam_paper_question`
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper_question`;
CREATE TABLE `exam_paper_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper_question
-- ----------------------------

-- ----------------------------
-- Table structure for `exam_question`
-- ----------------------------
DROP TABLE IF EXISTS `exam_question`;
CREATE TABLE `exam_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `content` text,
  `image` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `option_a` varchar(255) DEFAULT NULL,
  `option_b` varchar(255) DEFAULT NULL,
  `option_c` varchar(255) DEFAULT NULL,
  `option_d` varchar(255) DEFAULT NULL,
  `reference_answer` text,
  `comment` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_question
-- ----------------------------
INSERT INTO `exam_question` VALUES ('1', '2021-05-28 08:58:20', 'singleChoice', 'Java', 'Java 字节码文件的扩展名是？', null, '2.5', 'java', 'class', 'exe', 'jsp', 'B', '');
INSERT INTO `exam_question` VALUES ('2', '2021-05-28 08:58:21', 'singleChoice', 'Java', '下面哪项所占空间最小？', null, '2.5', 'byte', 'short', 'boolean', 'long', 'C', '');
INSERT INTO `exam_question` VALUES ('3', '2021-05-28 08:58:21', 'singleChoice', 'Java', '下面哪项属于循环代码块？', null, '2.5', 'for 语句', 'if 语句', 'main 方法', 'class 类', 'A', '');
INSERT INTO `exam_question` VALUES ('4', '2021-05-28 08:58:21', 'singleChoice', 'Java', '访问修饰符范围比较正确的是？', null, '2.5', 'public > default > protected > private', 'public > default > privite > protected', 'public > protected > default > private', 'public > protected > 不写 > private', 'C', '');
INSERT INTO `exam_question` VALUES ('5', '2021-05-28 08:58:21', 'singleChoice', 'Java', 'Spring Boot 配置，以下哪个优先级最高？', null, '2.5', '外置：xx.jar 同目录下 /config/application.properties', '外置：xx.jar 同目录下 /config/application.yml', '内置：src/main/resources/config', '内置：src/main/resources', 'A', 'Spring Boot 配置');
INSERT INTO `exam_question` VALUES ('6', '2021-05-28 08:58:21', 'singleChoice', 'Java', '注解的作用域不包括？', null, '2.5', 'SOURCE', 'CLASS', 'RUNTIME', 'JAVA', 'D', '注解');
INSERT INTO `exam_question` VALUES ('7', '2021-05-28 08:58:21', 'singleChoice', 'Java', '以下 Log 日志级别哪个最高？', null, '2.5', 'DEBUG', 'INFO', 'WARN', 'ERROR', 'D', '');
INSERT INTO `exam_question` VALUES ('8', '2021-05-28 08:58:21', 'singleChoice', 'Java', '以下不是 Spring Boot 的核心注解的是？', null, '2.5', '@SpringBootConfiguration', '@EnableAutoConfiguration', '@ComponentScan', '@MapperScan', 'D', '');
INSERT INTO `exam_question` VALUES ('9', '2021-05-28 08:58:21', 'singleChoice', 'Java', 'Spring Boot 中要使用 SpringMVC 的功能，哪个架包是必须加的？', null, '2.5', 'spring-boot-starter-jdbc', 'spring-boot-starter-thymeleaf', 'spring-boot-starter-web', 'mybatis-spring-boot-starter', 'C', '');
INSERT INTO `exam_question` VALUES ('10', '2021-05-28 08:58:21', 'singleChoice', 'Java', '以下哪个注解不能加在类上？', null, '2.5', '@Controller', '@ResponseBody', '@RestController', '@RequestMapping', '无解', '');
INSERT INTO `exam_question` VALUES ('12', '2021-05-28 08:58:21', 'singleChoice', 'Java', '当控制层上有 @RestController 注解时，方法中返回一个字符串“< h1>Hello< /h1>”，浏览器调用的结果是？', null, '2.5', '一级标题显示的 Hello', '找不到 Hello.html', '<h1>Hello</h1>', 'Hello', 'A', '');
INSERT INTO `exam_question` VALUES ('13', '2021-05-28 08:58:21', 'multipleChoice', 'Java', 'Spring Boot 项目中配置文件的格式？', null, '5', 'properties', 'txt', 'xml', 'yml', 'A,D', '');
INSERT INTO `exam_question` VALUES ('14', '2021-05-28 08:58:21', 'multipleChoice', 'Java', 'Spring Boot 核心配置文件包括？', null, '5', 'bootstrap', 'application', 'application-dev', 'logback', 'A,B', '');
INSERT INTO `exam_question` VALUES ('15', '2021-05-28 08:58:21', 'singleChoice', 'Java', '前台使用 Json 参数格式，控制器 consumer 属性、参数注解分别是？', null, '2.5', 'application/josn ---- @RequestBody', 'application/josn ---- @ModelAttribute', 'application/x-www-form-urlencoded ---- @RequestBody', 'application/x-www-form-urlencoded ---- @ModelAttribute', 'A', '');
INSERT INTO `exam_question` VALUES ('16', '2021-05-28 08:58:22', 'singleChoice', 'Java', '@Pointcut(\"execution(public * com.thornBird.sbd.modules.*.controller.*.*(..))\")，第三个 * 代表？', null, '2.5', '代表返回类型不限', '代表 module 下所有子包', '代表 controller 包下所有类', '代表所有方法', 'C', '');
INSERT INTO `exam_question` VALUES ('17', '2021-05-28 08:58:22', 'singleChoice', 'Java', 'Url 匹配风格中 /admin*，以下哪个匹配不正确？', null, '2.5', '/admin', '/admin1', '/admin123', '/admin/1', 'D', '');
INSERT INTO `exam_question` VALUES ('18', '2021-05-28 08:58:22', 'singleChoice', 'Java', 'Mybatis 框架中，插入数据使用那个注解', null, '2.5', '@Update', '@Insert', '@Select', '@InsertMapping', 'B', '');
INSERT INTO `exam_question` VALUES ('19', '2021-05-28 08:58:22', 'fillBlank', 'Java', '获取配置文件的属性值，使用哪个注解？', null, '2.5', '', '', '', '', '@Value', '');
INSERT INTO `exam_question` VALUES ('20', '2021-05-28 08:58:22', 'fillBlank', 'Java', 'Spring 配置依赖的 2 个注解是', null, '2.5', '', '', '', '', '@Configration----@Bean', '');
INSERT INTO `exam_question` VALUES ('21', '2021-05-28 08:58:22', 'fillBlank', 'Java', 'Spring Boot 修改 Tomcat 端口号为 9090 应该怎么写？', null, '2.5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('22', '2021-05-28 08:58:22', 'fillBlank', 'Java', '自定义拦截器需要实现什么接口？', null, '2.5', '', '', '', '', 'HandlerInterceptor', '');
INSERT INTO `exam_question` VALUES ('23', '2021-05-28 08:58:22', 'fillBlank', 'Java', '过滤器需要使用什么注解？', null, '2.5', '', '', '', '', '@WebFilter', '');
INSERT INTO `exam_question` VALUES ('24', '2021-05-28 08:58:22', 'fillBlank', 'Java', '上传文件使用什么对象接收文件？consumer使用什么类型？', null, '2.5', '', '', '', '', 'MultipartFile----multipart/form-data', '');
INSERT INTO `exam_question` VALUES ('25', '2021-05-28 08:58:22', 'shortAnswer', 'Java', '测试接口的方法？', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('26', '2021-05-28 08:58:22', 'shortAnswer', 'Java', 'Mybatis 传参中，#{*}、${*}的区别？', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('27', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Restful 规则？', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('28', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '数据安全和证书安全的区别？', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('29', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述页面碎片化和页面模块化？', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('30', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '@SpringBootApplication 注解的作用是什么？', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('31', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Spring Boot pom 文件父子继承、start 按组聚集 jar 的运用？', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('32', '2021-05-28 08:58:23', 'shortAnswer', 'Java', 'Spring Boot 中能否直接重定向到 templates 目录？', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('33', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Spring', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('34', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 MVC、MVVM', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('35', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Git 使用流程，写几个常用 Git 命令', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('36', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述敏捷开发、Scrum 流程', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('37', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述项目开发流程', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('38', '2021-05-28 08:58:23', 'shortAnswer', 'JavaScript', '简述 Ajax，Json 和 Form 提交', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('39', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Shiro 两大功能实现流程', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('40', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Mybatis 和 Jpa 的区别', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('41', '2021-05-28 08:58:24', 'shortAnswer', 'Java', '为什么我们需要 spring-boot-maven-plugin', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('42', '2021-05-28 08:58:24', 'shortAnswer', 'Java', '什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('43', '2021-05-28 08:58:24', 'programming', 'Java', '访问控制层，将一个 List 装入 requset 中，再在页面上以表格的形式显示出来', null, '15', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('44', '2021-05-28 08:58:24', 'programming', 'Java', '请写出重定向到某个页面的代码', null, '15', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('45', '2021-05-28 08:58:24', 'programming', 'Java', '设计一套购物车接口，以 Cookie 或者 Redis 实现', null, '15', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('46', '2021-05-28 08:58:24', 'judge', 'Java', 'MyBatis 不支持延迟加载', null, '2.5', '', '', '', '', 'False', '');
INSERT INTO `exam_question` VALUES ('47', '2021-05-28 08:58:24', 'judge', 'Java', '分布式和集群是一回事', null, '2.5', '', '', '', '', 'False', '');
INSERT INTO `exam_question` VALUES ('48', '2021-05-28 08:58:24', 'judge', 'Java', 'MongoDB 是文件形数据库', null, '2.5', '', '', '', '', 'True', '');
INSERT INTO `exam_question` VALUES ('49', '2021-05-28 08:58:24', 'judge', 'Java', 'Redis 是内存数据库', null, '2.5', '', '', '', '', 'True', '');
INSERT INTO `exam_question` VALUES ('50', '2021-05-28 08:58:24', 'singleChoice', 'Java', 'Spring DAO 中最常用的类是？', null, '2.5', 'JdbcTemplate', 'SimpleJdbcInsert', 'SimpleJdbcInsert', 'SimpleJdbcQuery', 'A', '');
INSERT INTO `exam_question` VALUES ('51', '2021-05-28 08:58:24', 'singleChoice', 'Java', 'Spring AOP 中， 织入（Weaving） 可以在下面什么时间完成？', null, '2.5', '全部选项', 'Run time', 'Load time', 'Compile time', 'A', '');
INSERT INTO `exam_question` VALUES ('52', '2021-05-28 08:58:24', 'singleChoice', 'Java', '下面关于Spring MVC 描述正确的是？', null, '2.5', 'DispatcherServlet 在 Spring MVC 中是核心servlet , 它负责接收请求并将请求分发给适合的控制器', '在Spring MVC 中,可以配置多个 DispatcherServlet', '全部选项', '要使 Spring MVC 可用，DispatcherServlet 需要在 web.xml 中配置', 'C', '');
INSERT INTO `exam_question` VALUES ('53', '2021-05-28 08:58:25', 'singleChoice', 'Java', '下面哪项是 Spring 自动装载模式？', null, '2.5', 'autodetect', '全部选项', 'constructor', 'byname, byType', 'B', '');
INSERT INTO `exam_question` VALUES ('54', '2021-05-28 08:58:25', 'singleChoice', 'Java', 'Spring 中，下面哪一项不是使用事务的方法？', null, '2.5', 'proxies', 'declaratively', 'programmaticly', '全部', 'A', '');
INSERT INTO `exam_question` VALUES ('55', '2021-05-28 08:58:25', 'judge', 'Java', 'Spring 提供了 JMS 层的抽象，正确吗？', null, '2.5', '', '', '', '', 'True', '');
INSERT INTO `exam_question` VALUES ('56', '2021-05-28 08:58:25', 'singleChoice', 'Java', '关于\"@Order\"注解，最正确的描述是？', null, '2.5', '实现 org.springframework.core.Ordered 接口', '指定一个 bean 的范围', '通常用于注入域对象的属性', '全不正确', 'A', '');
INSERT INTO `exam_question` VALUES ('57', '2021-05-28 08:58:25', 'singleChoice', 'Java', '如何在 Spring 应用中使用 SLF4J？', null, '2.5', '作为日志框架', '全不正确', '作为一个 Bean', '作为 JDBC 框架', 'A', '');
INSERT INTO `exam_question` VALUES ('58', '2021-05-28 08:58:25', 'singleChoice', 'Java', 'Spring Bean 的默认作用范围是？', null, '2.5', '全不正确', 'Singleton', 'Prototype', 'Session', 'B', '');
