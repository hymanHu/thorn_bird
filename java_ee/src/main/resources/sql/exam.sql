/*
Navicat MySQL Data Transfer

Source Server         : MyConnect
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-12-27 20:45:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `exam_achievement`
-- ----------------------------
DROP TABLE IF EXISTS `exam_achievement`;
CREATE TABLE `exam_achievement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `total_score` double(11,2) NOT NULL,
  `reference_score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `score` double(11,2) DEFAULT NULL,
  `total_time` int(11) DEFAULT NULL,
  `spend_time` int(11) DEFAULT NULL,
  `exam_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of exam_achievement
-- ----------------------------
INSERT INTO `exam_achievement` VALUES ('21', '1', 'Java_Framework_20201224_admin', '100.00', '40.0 ~ 95.0', '0.00', '60', '1', '2020-12-27 20:41:49');
INSERT INTO `exam_achievement` VALUES ('22', '1', 'Java_Framework_1932_admin', '67.50', '52.5', '52.50', '60', '1', '2020-12-27 20:42:50');

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
) ENGINE=InnoDB AUTO_INCREMENT=551 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_answer
-- ----------------------------
INSERT INTO `exam_answer` VALUES ('501', '21', '15', 'A');
INSERT INTO `exam_answer` VALUES ('502', '21', '8', 'D');
INSERT INTO `exam_answer` VALUES ('503', '21', '7', 'D');
INSERT INTO `exam_answer` VALUES ('504', '21', '12', 'A');
INSERT INTO `exam_answer` VALUES ('505', '21', '9', 'C');
INSERT INTO `exam_answer` VALUES ('506', '21', '53', 'B');
INSERT INTO `exam_answer` VALUES ('507', '21', '6', 'D');
INSERT INTO `exam_answer` VALUES ('508', '21', '18', 'B');
INSERT INTO `exam_answer` VALUES ('509', '21', '56', 'A');
INSERT INTO `exam_answer` VALUES ('510', '21', '57', 'A');
INSERT INTO `exam_answer` VALUES ('511', '21', '13', 'A,D');
INSERT INTO `exam_answer` VALUES ('512', '21', '14', 'A,B');
INSERT INTO `exam_answer` VALUES ('513', '21', '47', 'True');
INSERT INTO `exam_answer` VALUES ('514', '21', '49', 'True');
INSERT INTO `exam_answer` VALUES ('515', '21', '46', 'True');
INSERT INTO `exam_answer` VALUES ('516', '21', '55', 'True');
INSERT INTO `exam_answer` VALUES ('517', '21', '19', 'cascscas');
INSERT INTO `exam_answer` VALUES ('518', '21', '24', 'cdsacdsa');
INSERT INTO `exam_answer` VALUES ('519', '21', '22', 'cdsacdas');
INSERT INTO `exam_answer` VALUES ('520', '21', '21', 'cdsacads');
INSERT INTO `exam_answer` VALUES ('521', '21', '31', 'cdsacdsa');
INSERT INTO `exam_answer` VALUES ('522', '21', '26', 'cdsacdas');
INSERT INTO `exam_answer` VALUES ('523', '21', '32', 'cdsacdas');
INSERT INTO `exam_answer` VALUES ('524', '21', '45', 'cdascads');
INSERT INTO `exam_answer` VALUES ('525', '21', '43', 'cdsacdas');
INSERT INTO `exam_answer` VALUES ('526', '22', '9', 'C');
INSERT INTO `exam_answer` VALUES ('527', '22', '54', 'D');
INSERT INTO `exam_answer` VALUES ('528', '22', '7', 'D');
INSERT INTO `exam_answer` VALUES ('529', '22', '17', 'D');
INSERT INTO `exam_answer` VALUES ('530', '22', '58', 'A');
INSERT INTO `exam_answer` VALUES ('531', '22', '12', 'A');
INSERT INTO `exam_answer` VALUES ('532', '22', '16', 'C');
INSERT INTO `exam_answer` VALUES ('533', '22', '50', 'A');
INSERT INTO `exam_answer` VALUES ('534', '22', '10', 'C');
INSERT INTO `exam_answer` VALUES ('535', '22', '6', 'D');
INSERT INTO `exam_answer` VALUES ('536', '22', '53', 'B');
INSERT INTO `exam_answer` VALUES ('537', '22', '15', 'A');
INSERT INTO `exam_answer` VALUES ('538', '22', '18', 'B');
INSERT INTO `exam_answer` VALUES ('539', '22', '5', 'A');
INSERT INTO `exam_answer` VALUES ('540', '22', '8', 'D');
INSERT INTO `exam_answer` VALUES ('541', '22', '52', 'C');
INSERT INTO `exam_answer` VALUES ('542', '22', '56', 'A');
INSERT INTO `exam_answer` VALUES ('543', '22', '57', 'A');
INSERT INTO `exam_answer` VALUES ('544', '22', '13', 'A,D');
INSERT INTO `exam_answer` VALUES ('545', '22', '14', 'A,B');
INSERT INTO `exam_answer` VALUES ('546', '22', '49', '');
INSERT INTO `exam_answer` VALUES ('547', '22', '55', 'False');
INSERT INTO `exam_answer` VALUES ('548', '22', '46', 'True');
INSERT INTO `exam_answer` VALUES ('549', '22', '47', 'False');
INSERT INTO `exam_answer` VALUES ('550', '22', '48', 'True');

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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper
-- ----------------------------
INSERT INTO `exam_paper` VALUES ('43', 'Java_Framework_20201224_admin', '60', '100.00', '2020-12-24 08:18:05');
INSERT INTO `exam_paper` VALUES ('44', 'Java_Framework_1932_admin', '60', '67.50', '2020-12-25 21:58:37');
INSERT INTO `exam_paper` VALUES ('45', 'Java_Framework_20201227_admin', '60', '100.00', '2020-12-27 14:13:42');
INSERT INTO `exam_paper` VALUES ('46', 'Java_Framework_202012271_admin', '60', '100.00', '2020-12-27 15:42:00');

-- ----------------------------
-- Table structure for `exam_paper_question`
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper_question`;
CREATE TABLE `exam_paper_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1017 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper_question
-- ----------------------------
INSERT INTO `exam_paper_question` VALUES ('917', '43', '15');
INSERT INTO `exam_paper_question` VALUES ('918', '43', '7');
INSERT INTO `exam_paper_question` VALUES ('919', '43', '12');
INSERT INTO `exam_paper_question` VALUES ('920', '43', '9');
INSERT INTO `exam_paper_question` VALUES ('921', '43', '53');
INSERT INTO `exam_paper_question` VALUES ('922', '43', '6');
INSERT INTO `exam_paper_question` VALUES ('923', '43', '18');
INSERT INTO `exam_paper_question` VALUES ('924', '43', '57');
INSERT INTO `exam_paper_question` VALUES ('925', '43', '19');
INSERT INTO `exam_paper_question` VALUES ('926', '43', '24');
INSERT INTO `exam_paper_question` VALUES ('927', '43', '22');
INSERT INTO `exam_paper_question` VALUES ('928', '43', '21');
INSERT INTO `exam_paper_question` VALUES ('929', '43', '13');
INSERT INTO `exam_paper_question` VALUES ('930', '43', '14');
INSERT INTO `exam_paper_question` VALUES ('931', '43', '46');
INSERT INTO `exam_paper_question` VALUES ('932', '43', '55');
INSERT INTO `exam_paper_question` VALUES ('933', '43', '47');
INSERT INTO `exam_paper_question` VALUES ('934', '43', '49');
INSERT INTO `exam_paper_question` VALUES ('935', '43', '31');
INSERT INTO `exam_paper_question` VALUES ('936', '43', '26');
INSERT INTO `exam_paper_question` VALUES ('937', '43', '45');
INSERT INTO `exam_paper_question` VALUES ('938', '43', '43');
INSERT INTO `exam_paper_question` VALUES ('939', '43', '56');
INSERT INTO `exam_paper_question` VALUES ('940', '43', '32');
INSERT INTO `exam_paper_question` VALUES ('941', '43', '8');
INSERT INTO `exam_paper_question` VALUES ('942', '44', '9');
INSERT INTO `exam_paper_question` VALUES ('943', '44', '17');
INSERT INTO `exam_paper_question` VALUES ('944', '44', '58');
INSERT INTO `exam_paper_question` VALUES ('945', '44', '16');
INSERT INTO `exam_paper_question` VALUES ('946', '44', '10');
INSERT INTO `exam_paper_question` VALUES ('947', '44', '53');
INSERT INTO `exam_paper_question` VALUES ('948', '44', '18');
INSERT INTO `exam_paper_question` VALUES ('949', '44', '52');
INSERT INTO `exam_paper_question` VALUES ('950', '44', '13');
INSERT INTO `exam_paper_question` VALUES ('951', '44', '14');
INSERT INTO `exam_paper_question` VALUES ('952', '44', '55');
INSERT INTO `exam_paper_question` VALUES ('953', '44', '46');
INSERT INTO `exam_paper_question` VALUES ('954', '44', '47');
INSERT INTO `exam_paper_question` VALUES ('955', '44', '48');
INSERT INTO `exam_paper_question` VALUES ('956', '44', '5');
INSERT INTO `exam_paper_question` VALUES ('957', '44', '56');
INSERT INTO `exam_paper_question` VALUES ('958', '44', '54');
INSERT INTO `exam_paper_question` VALUES ('959', '44', '49');
INSERT INTO `exam_paper_question` VALUES ('960', '44', '12');
INSERT INTO `exam_paper_question` VALUES ('961', '44', '50');
INSERT INTO `exam_paper_question` VALUES ('962', '44', '6');
INSERT INTO `exam_paper_question` VALUES ('963', '44', '15');
INSERT INTO `exam_paper_question` VALUES ('964', '44', '8');
INSERT INTO `exam_paper_question` VALUES ('965', '44', '57');
INSERT INTO `exam_paper_question` VALUES ('966', '44', '7');
INSERT INTO `exam_paper_question` VALUES ('967', '45', '7');
INSERT INTO `exam_paper_question` VALUES ('968', '45', '50');
INSERT INTO `exam_paper_question` VALUES ('969', '45', '12');
INSERT INTO `exam_paper_question` VALUES ('970', '45', '15');
INSERT INTO `exam_paper_question` VALUES ('971', '45', '18');
INSERT INTO `exam_paper_question` VALUES ('972', '45', '17');
INSERT INTO `exam_paper_question` VALUES ('973', '45', '16');
INSERT INTO `exam_paper_question` VALUES ('974', '45', '9');
INSERT INTO `exam_paper_question` VALUES ('975', '45', '20');
INSERT INTO `exam_paper_question` VALUES ('976', '45', '19');
INSERT INTO `exam_paper_question` VALUES ('977', '45', '22');
INSERT INTO `exam_paper_question` VALUES ('978', '45', '24');
INSERT INTO `exam_paper_question` VALUES ('979', '45', '14');
INSERT INTO `exam_paper_question` VALUES ('980', '45', '13');
INSERT INTO `exam_paper_question` VALUES ('981', '45', '47');
INSERT INTO `exam_paper_question` VALUES ('982', '45', '49');
INSERT INTO `exam_paper_question` VALUES ('983', '45', '48');
INSERT INTO `exam_paper_question` VALUES ('984', '45', '46');
INSERT INTO `exam_paper_question` VALUES ('985', '45', '41');
INSERT INTO `exam_paper_question` VALUES ('986', '45', '25');
INSERT INTO `exam_paper_question` VALUES ('987', '45', '44');
INSERT INTO `exam_paper_question` VALUES ('988', '45', '45');
INSERT INTO `exam_paper_question` VALUES ('989', '45', '30');
INSERT INTO `exam_paper_question` VALUES ('990', '45', '8');
INSERT INTO `exam_paper_question` VALUES ('991', '45', '52');
INSERT INTO `exam_paper_question` VALUES ('992', '46', '18');
INSERT INTO `exam_paper_question` VALUES ('993', '46', '56');
INSERT INTO `exam_paper_question` VALUES ('994', '46', '16');
INSERT INTO `exam_paper_question` VALUES ('995', '46', '50');
INSERT INTO `exam_paper_question` VALUES ('996', '46', '8');
INSERT INTO `exam_paper_question` VALUES ('997', '46', '9');
INSERT INTO `exam_paper_question` VALUES ('998', '46', '6');
INSERT INTO `exam_paper_question` VALUES ('999', '46', '58');
INSERT INTO `exam_paper_question` VALUES ('1000', '46', '22');
INSERT INTO `exam_paper_question` VALUES ('1001', '46', '20');
INSERT INTO `exam_paper_question` VALUES ('1002', '46', '24');
INSERT INTO `exam_paper_question` VALUES ('1003', '46', '21');
INSERT INTO `exam_paper_question` VALUES ('1004', '46', '14');
INSERT INTO `exam_paper_question` VALUES ('1005', '46', '13');
INSERT INTO `exam_paper_question` VALUES ('1006', '46', '46');
INSERT INTO `exam_paper_question` VALUES ('1007', '46', '55');
INSERT INTO `exam_paper_question` VALUES ('1008', '46', '48');
INSERT INTO `exam_paper_question` VALUES ('1009', '46', '47');
INSERT INTO `exam_paper_question` VALUES ('1010', '46', '31');
INSERT INTO `exam_paper_question` VALUES ('1011', '46', '28');
INSERT INTO `exam_paper_question` VALUES ('1012', '46', '43');
INSERT INTO `exam_paper_question` VALUES ('1013', '46', '44');
INSERT INTO `exam_paper_question` VALUES ('1014', '46', '42');
INSERT INTO `exam_paper_question` VALUES ('1015', '46', '10');
INSERT INTO `exam_paper_question` VALUES ('1016', '46', '57');

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
