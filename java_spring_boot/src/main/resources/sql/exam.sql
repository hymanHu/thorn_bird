/*
Navicat MySQL Data Transfer

Source Server         : myConnection
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2021-06-29 11:19:31
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_achievement
-- ----------------------------
INSERT INTO `exam_achievement` VALUES ('1', '2021-06-18 12:37:51', '1', '\n													Java\n												_aaaaa_admin', '100', '0.0 ~ 50.0', '0', '0', '45', '45', '2021-06-18 12:37:51');
INSERT INTO `exam_achievement` VALUES ('2', '2021-06-18 12:37:51', '1', '\n													Java\n												_aaaaa_admin', '100', '0.0 ~ 50.0', '0', '0', '45', '45', '2021-06-18 12:37:51');

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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_answer
-- ----------------------------
INSERT INTO `exam_answer` VALUES ('1', null, '1', '15', '');
INSERT INTO `exam_answer` VALUES ('2', null, '1', '9', '');
INSERT INTO `exam_answer` VALUES ('3', null, '1', '54', '');
INSERT INTO `exam_answer` VALUES ('4', null, '1', '7', '');
INSERT INTO `exam_answer` VALUES ('5', null, '1', '52', '');
INSERT INTO `exam_answer` VALUES ('6', null, '1', '51', '');
INSERT INTO `exam_answer` VALUES ('7', null, '1', '8', '');
INSERT INTO `exam_answer` VALUES ('8', null, '1', '57', '');
INSERT INTO `exam_answer` VALUES ('9', null, '1', '99', '');
INSERT INTO `exam_answer` VALUES ('10', null, '1', '90', '');
INSERT INTO `exam_answer` VALUES ('11', null, '1', '14', '');
INSERT INTO `exam_answer` VALUES ('12', null, '1', '105', '');
INSERT INTO `exam_answer` VALUES ('13', null, '1', '93', '');
INSERT INTO `exam_answer` VALUES ('14', null, '1', '47', '');
INSERT INTO `exam_answer` VALUES ('15', null, '1', '109', '');
INSERT INTO `exam_answer` VALUES ('16', null, '2', '15', '');
INSERT INTO `exam_answer` VALUES ('17', null, '2', '9', '');
INSERT INTO `exam_answer` VALUES ('18', null, '2', '54', '');
INSERT INTO `exam_answer` VALUES ('19', null, '1', '87', '');
INSERT INTO `exam_answer` VALUES ('20', null, '2', '7', '');
INSERT INTO `exam_answer` VALUES ('21', null, '2', '52', '');
INSERT INTO `exam_answer` VALUES ('22', null, '2', '51', '');
INSERT INTO `exam_answer` VALUES ('23', null, '2', '8', '');
INSERT INTO `exam_answer` VALUES ('24', null, '2', '57', '');
INSERT INTO `exam_answer` VALUES ('25', null, '2', '99', '');
INSERT INTO `exam_answer` VALUES ('26', null, '1', '23', '');
INSERT INTO `exam_answer` VALUES ('27', null, '2', '90', '');
INSERT INTO `exam_answer` VALUES ('28', null, '1', '107', '');
INSERT INTO `exam_answer` VALUES ('29', null, '1', '88', '');
INSERT INTO `exam_answer` VALUES ('30', null, '2', '14', '');
INSERT INTO `exam_answer` VALUES ('31', null, '2', '105', '');
INSERT INTO `exam_answer` VALUES ('32', null, '2', '93', '');
INSERT INTO `exam_answer` VALUES ('33', null, '2', '47', '');
INSERT INTO `exam_answer` VALUES ('34', null, '2', '109', '');
INSERT INTO `exam_answer` VALUES ('35', null, '2', '87', '');
INSERT INTO `exam_answer` VALUES ('36', null, '2', '23', '');
INSERT INTO `exam_answer` VALUES ('37', null, '1', '20', '');
INSERT INTO `exam_answer` VALUES ('38', null, '1', '104', '');
INSERT INTO `exam_answer` VALUES ('39', null, '2', '107', '');
INSERT INTO `exam_answer` VALUES ('40', null, '1', '25', '');
INSERT INTO `exam_answer` VALUES ('41', null, '1', '45', '');
INSERT INTO `exam_answer` VALUES ('42', null, '1', '43', '');
INSERT INTO `exam_answer` VALUES ('43', null, '2', '88', '');
INSERT INTO `exam_answer` VALUES ('44', null, '2', '20', '');
INSERT INTO `exam_answer` VALUES ('45', null, '2', '104', '');
INSERT INTO `exam_answer` VALUES ('46', null, '2', '25', '');
INSERT INTO `exam_answer` VALUES ('47', null, '2', '45', '');
INSERT INTO `exam_answer` VALUES ('48', null, '2', '43', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper
-- ----------------------------
INSERT INTO `exam_paper` VALUES ('1', '2021-06-18 11:51:22', '\n													Java\n												_aaaaa_admin', '45', '100');

-- ----------------------------
-- Table structure for `exam_paper_question`
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper_question`;
CREATE TABLE `exam_paper_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paper_question
-- ----------------------------
INSERT INTO `exam_paper_question` VALUES ('1', '1', '15');
INSERT INTO `exam_paper_question` VALUES ('2', '1', '9');
INSERT INTO `exam_paper_question` VALUES ('3', '1', '54');
INSERT INTO `exam_paper_question` VALUES ('4', '1', '7');
INSERT INTO `exam_paper_question` VALUES ('5', '1', '52');
INSERT INTO `exam_paper_question` VALUES ('6', '1', '51');
INSERT INTO `exam_paper_question` VALUES ('7', '1', '8');
INSERT INTO `exam_paper_question` VALUES ('8', '1', '57');
INSERT INTO `exam_paper_question` VALUES ('9', '1', '23');
INSERT INTO `exam_paper_question` VALUES ('10', '1', '107');
INSERT INTO `exam_paper_question` VALUES ('11', '1', '88');
INSERT INTO `exam_paper_question` VALUES ('12', '1', '20');
INSERT INTO `exam_paper_question` VALUES ('13', '1', '99');
INSERT INTO `exam_paper_question` VALUES ('14', '1', '90');
INSERT INTO `exam_paper_question` VALUES ('15', '1', '14');
INSERT INTO `exam_paper_question` VALUES ('16', '1', '105');
INSERT INTO `exam_paper_question` VALUES ('17', '1', '93');
INSERT INTO `exam_paper_question` VALUES ('18', '1', '47');
INSERT INTO `exam_paper_question` VALUES ('19', '1', '109');
INSERT INTO `exam_paper_question` VALUES ('20', '1', '87');
INSERT INTO `exam_paper_question` VALUES ('21', '1', '104');
INSERT INTO `exam_paper_question` VALUES ('22', '1', '25');
INSERT INTO `exam_paper_question` VALUES ('23', '1', '45');
INSERT INTO `exam_paper_question` VALUES ('24', '1', '43');

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
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_question
-- ----------------------------
INSERT INTO `exam_question` VALUES ('1', '2021-05-28 08:58:20', 'singleChoice', 'Java', 'Java 字节码文件的扩展名是？', null, '2.5', 'java', 'class', 'exe', 'jsp', 'B', '');
INSERT INTO `exam_question` VALUES ('2', '2021-05-28 08:58:21', 'singleChoice', 'Java', '下面哪项所占空间最小？', null, '2.5', 'byte', 'short', 'boolean', 'long', 'C', '');
INSERT INTO `exam_question` VALUES ('3', '2021-05-28 08:58:21', 'singleChoice', 'Java', '下面哪项属于循环代码块？', null, '2.5', 'for 语句', 'if 语句', 'main 方法', 'class 类', 'A', '');
INSERT INTO `exam_question` VALUES ('4', '2021-05-28 08:58:21', 'singleChoice', 'Java', '访问修饰符范围比较正确的是？', null, '2.5', 'public > default > protected > private', 'public > default > privite > protected', 'public > protected > default > private', 'public > protected > 不写 > private', 'C', '');
INSERT INTO `exam_question` VALUES ('5', '2021-05-28 08:58:21', 'singleChoice', 'Java', 'Spring Boot 配置，以下哪个优先级最高？', null, '2.5', '外置：xx.jar 同目录下 /config/application.properties', '外置：xx.jar 同目录下 /config/application.yml', '内置：src/main/resources/config', '内置：src/main/resources', 'A', 'Spring Boot 配置');
INSERT INTO `exam_question` VALUES ('6', '2021-05-28 08:58:21', 'singleChoice', 'Java', '注解的作用域不包括？', null, '2.5', 'SOURCE', 'CLASS', 'RUNTIME', 'JAVA', 'D', '注解');
INSERT INTO `exam_question` VALUES ('7', '2021-05-28 08:58:21', 'singleChoice', 'Java', '以下 Log 日志级别哪个最高？', null, '2.5', 'DEBUG', 'INFO', 'WARN', 'ERROR', 'D', 'TRACE < DEBUG < INFO < WARN < ERROR');
INSERT INTO `exam_question` VALUES ('8', '2021-05-28 08:58:21', 'singleChoice', 'Java', '以下不是 Spring Boot 的核心注解的是？', null, '2.5', '@SpringBootConfiguration', '@EnableAutoConfiguration', '@ComponentScan', '@MapperScan', 'D', '');
INSERT INTO `exam_question` VALUES ('9', '2021-05-28 08:58:21', 'singleChoice', 'Java', 'Spring Boot 中要使用 SpringMVC 的功能，哪个架包是必须加的？', null, '2.5', 'spring-boot-starter-jdbc', 'spring-boot-starter-thymeleaf', 'spring-boot-starter-web', 'mybatis-spring-boot-starter', 'C', '');
INSERT INTO `exam_question` VALUES ('10', '2021-05-28 08:58:21', 'singleChoice', 'Java', '以下哪个注解不能加在类上？', null, '2.5', '@Controller', '@ResponseBody', '@RestController', '都可以', 'D', '');
INSERT INTO `exam_question` VALUES ('12', '2021-05-28 08:58:21', 'singleChoice', 'Java', '当控制层上有 @RestController 注解时，方法中返回一个字符串“< h1>Hello< /h1>”，浏览器调用的结果是？', null, '2.5', '一级标题显示的 Hello', '找不到 Hello.html', '字符串“< h1>Hello< /h1>”', 'Hello', 'A', '');
INSERT INTO `exam_question` VALUES ('13', '2021-05-28 08:58:21', 'multipleChoice', 'Java', 'Spring Boot 项目中配置文件的格式？', null, '5', 'properties', 'txt', 'xml', 'yml', 'A,D', '');
INSERT INTO `exam_question` VALUES ('14', '2021-05-28 08:58:21', 'multipleChoice', 'Java', 'Spring Boot 核心配置文件包括？', null, '5', 'bootstrap', 'application', 'application-dev', 'logback', 'A,B', '');
INSERT INTO `exam_question` VALUES ('15', '2021-05-28 08:58:21', 'singleChoice', 'Java', '前台使用 Json 参数格式，控制器 consumer 属性、参数注解分别是？', null, '2.5', 'application/josn ---- @RequestBody', 'application/josn ---- @ModelAttribute', 'application/x-www-form-urlencoded ---- @RequestBody', 'application/x-www-form-urlencoded ---- @ModelAttribute', 'A', '');
INSERT INTO `exam_question` VALUES ('16', '2021-05-28 08:58:22', 'singleChoice', 'Java', '@Pointcut(\"execution(public * com.thornBird.sbd.modules.*.controller.*.*(..))\")，第三个 * 代表？', null, '2.5', '代表返回类型不限', '代表 module 下所有子包', '代表 controller 包下所有类', '代表所有方法', 'C', '');
INSERT INTO `exam_question` VALUES ('17', '2021-05-28 08:58:22', 'singleChoice', 'Java', 'Url 匹配风格中 /admin*，以下哪个匹配不正确？', null, '2.5', '/admin', '/admin1', '/admin123', '/admin/1', 'D', '');
INSERT INTO `exam_question` VALUES ('18', '2021-05-28 08:58:22', 'singleChoice', 'Java', 'Mybatis 框架中，插入数据使用那个注解', null, '2.5', '@Update', '@Insert', '@Select', '@InsertMapping', 'B', '');
INSERT INTO `exam_question` VALUES ('19', '2021-05-28 08:58:22', 'fillBlank', 'Java', '获取配置文件的属性值，使用哪个注解？', null, '2.5', '', '', '', '', '@Value', '');
INSERT INTO `exam_question` VALUES ('20', '2021-05-28 08:58:22', 'fillBlank', 'Java', 'Spring 配置依赖的 2 个注解是', null, '2.5', '', '', '', '', '@Configration、@Bean', '');
INSERT INTO `exam_question` VALUES ('21', '2021-05-28 08:58:22', 'fillBlank', 'Java', 'Spring Boot 修改 Tomcat 端口号为 9090 应该怎么写？', null, '2.5', '', '', '', '', 'server.port=9090', '');
INSERT INTO `exam_question` VALUES ('22', '2021-05-28 08:58:22', 'fillBlank', 'Java', '自定义拦截器需要实现什么接口？', null, '2.5', '', '', '', '', 'HandlerInterceptor', '');
INSERT INTO `exam_question` VALUES ('23', '2021-05-28 08:58:22', 'fillBlank', 'Java', '过滤器需要使用什么注解？', null, '2.5', '', '', '', '', '@WebFilter', '');
INSERT INTO `exam_question` VALUES ('24', '2021-05-28 08:58:22', 'fillBlank', 'Java', '上传文件使用什么对象接收文件？consumer 使用什么类型？', null, '2.5', '', '', '', '', 'MultipartFile、multipart/form-data', '');
INSERT INTO `exam_question` VALUES ('25', '2021-05-28 08:58:22', 'shortAnswer', 'Java', '测试接口的方法？', null, '5', '', '', '', '', 'Get 请求直接用浏览器测试，非 Get 请求用 Postman 测试', '');
INSERT INTO `exam_question` VALUES ('26', '2021-05-28 08:58:22', 'shortAnswer', 'Java', 'Mybatis 传参中，#{*}、${*}的区别？', null, '5', '', '', '', '', '#{*} 相当于 prepared statement，传入的数据被当做字符串，拼接字符串时候自动添加引号，所以在 order by 的时候不能使用 # 的方式；\n${*} 相当于 statement；', '');
INSERT INTO `exam_question` VALUES ('27', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Restful 规则？', null, '5', '', '', '', '', 'URI 结尾不应包含 /； \n分隔符 / 用来指示层级关系； \n应使用连字符 - 来提高 URI 的可读性； \n不得在 URI 中使用下划线 _； \nURI 路径中全都使用小写字母； URI 相同时，请求方式不同； \n根据实体 Bean 或模块名命名，注意单复数，有 Id 的放在路径上，多条件查询的使用 post 请求；', '');
INSERT INTO `exam_question` VALUES ('28', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '数据安全和证书安全的区别？', null, '5', '', '', '', '', '数据安全：在传输数据时对数据进行加密，使用 Https 协议； \n证书安全：在使用 Https 协议时，用自己生成的证书，并未到公钥基础设施中注册，故此证书不安全；', '');
INSERT INTO `exam_question` VALUES ('29', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述页面碎片化和页面模块化？', null, '5', '', '', '', '', '模块化：根据页面的功能，分成不同模块页面，在前端进行分包治理，与后端一一对应； \n碎片化：将页面中公共的部分拆分出来形成单独的碎片页面，再通过碎片组装器，将碎片组装成完整的页面；', '');
INSERT INTO `exam_question` VALUES ('30', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '@SpringBootApplication 注解的作用是什么？', null, '5', '', '', '', '', '@ComponentScan ---- 组件扫描，加载到 IOC 容器； \n@EnableAutoConfiguration ---- 通过 @Import 将所有符合自动配置条件的 Bean 定义加载到 IOC 容器，通俗讲加载 @Configuration 类； \n@SpringBootConfiguration ---- 继承自 @Configuration，标注当前类是配置类；', '');
INSERT INTO `exam_question` VALUES ('31', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Spring Boot pom 文件父子继承、start 按组聚集 jar 的运用？', null, '5', '', '', '', '', 'Starter 依赖，将常用的依赖按组聚集在一起，形成单条依赖，以 Maven 继承的方式，非常方便地进行包管理；', '');
INSERT INTO `exam_question` VALUES ('32', '2021-05-28 08:58:23', 'shortAnswer', 'Java', 'Spring Boot 中能否直接重定向到 templates 目录？', null, '5', '', '', '', '', '不行，Templates 文件夹下放置页面模版，不能直接访问；', '');
INSERT INTO `exam_question` VALUES ('33', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Spring', null, '5', '', '', '', '', 'Spring 是一个支持快速开发 Java EE 应用程序的框架，它提供了一系列底层容器和基础设施，并可以和大量常用的开源框架无缝集成，可以说是开发 Java EE 应用程序的必备； \nSpring Framework 的核心提供了一个 IOC 容器，它可以管理所有轻量级的 JavaBean 组件，提供的底层服务包括：组件的生命周期管理、配置和组装服务、AOP 支持、建立在 AOP 基础上的声明式事务服务等；', '');
INSERT INTO `exam_question` VALUES ('34', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 MVC', null, '5', '', '', '', '', 'Model View Controller，是 Web 开发中常用的设计思想，有如下三个组件： \nModel：模型层，可以是一个 JavaBean，也可以是包含多个对象的 Map，好比 User，不但代表一个实体，还包含了 User 相关的业务处理； \nView：视图层，负责将 Model 渲染出来； \nController：控制层，负责连接视图层和模型层，负责请求和响应绑定、数据传递；', '');
INSERT INTO `exam_question` VALUES ('35', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Git 使用流程，写几个常用 Git 命令', null, '5', '', '', '', '', '将远程代码仓库克隆到本地； \n增删改文件； \n将变更文件添加到提交序列； \n将提交序列文件提交到本地仓库； \n将本地仓库文件推送到远程仓库； \nclone、add、commit、push、checkout、branch、status；', '');
INSERT INTO `exam_question` VALUES ('36', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述敏捷开发、Scrum 流程', null, '5', '', '', '', '', '敏捷开发：客户需求为核心，高效，迭代增量，大项目分成小项目，分别完成独立运行，控制时间周期和任务优先级，交付功能模块，根据客户反馈持续集成； \nScrum： \n一个大的需求，预估工作量和时间，比如 2 个月时间，形成一个 Sprint， 划分成任务列表；\n计划会议，将任务细化成 Issue，每个 Issue 的开发周期控制在 1~2 天，分派到个人头上； \n根据每个任务创建父类分支，细化的 Issue 提交到对应的分支上，每日做 Daily Merge，确保开发主分支（Dev）能正常集成编译，每日进行 Standing Meeting，讲工作进度以及遇到的问题； \n一个 Sprint 完成，进行演示和总结会议，回顾优缺点；', '');
INSERT INTO `exam_question` VALUES ('37', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述项目开发流程', null, '5', '', '', '', '', '需求分析；\n原型设计（数据库设计）；\n接口设计；\n前端设计；\n搭建框架；\n开发、测试、运行；\n文档总结；', '');
INSERT INTO `exam_question` VALUES ('38', '2021-05-28 08:58:23', 'shortAnswer', 'JavaScript', '简述 Ajax，Json 和 Form 提交', null, '5', '', '', '', '', 'var user = {};\nuser.account = $(\"[name=\'account\']\").val();\nuser.password = $(\"[name=\'password\']\").val();\nuser.rememberMe = $(\"[name=\'rememberMe\']\").prop(\'checked\');\n$.ajax({\n	url : \"/doLogin\",\n	type : \"post\",\n	contentType: \"application/json\",\n	data : JSON.stringify(user),\n	success : function (data) {\n		if (data.status == 200) {\n			location.href = \"/index\";\n		} else {\n			layer.msg(data.message, {icon: 0});\n		}\n	},\n	error : function (data) {\n		layer.msg(data.responseText, {icon: 0});\n	}\n});\n$.ajax({\n	url :\"/organization/addDepartment\",\n	type : \"POST\",\n	data : $(\'#form1\').serialize(),\n	dataType : \"text\",\n	success : function(data) {\n		var result = eval(\"(\" + data + \")\");\n		if (result.status == 200) {\n			layer.msg(\"修改成功\",{\n				icon : 1,\n				time: 500,\n			},function () {\n				var index = parent.layer.getFrameIndex(window.name);\n				parent.location.reload();\n				parent.layer.close(index);\n			});\n		} else {\n			layer.msg(result.message, {icon: 0});\n		}\n	},\n		error : function() {\n			layer.msg(\'无法连接服务器\', {icon: 2});\n		}\n	});   \n	return false;\n});', '');
INSERT INTO `exam_question` VALUES ('39', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Shiro 两大功能实现流程', null, '5', '', '', '', '', '身份验证：用户登录后，获得 Subject 组件，包装令牌，调用 login 方法，传入令牌，进入 realm 组件，查询数据库用户，返回身份验证器，并与令牌做比对，成功则登录成功，反之报错；\n资源授权：用户登录时，调用 subject.checkRoles 方法，登录成功后，当页面遇到 shiro 标签或调用接口含有 shiro 注解时，进入 realm 获取当前用户的角色和资源，并返回身份验证器，与标签或注解比对，匹配则显示或调用，反之则不显示或抛出异常；', '');
INSERT INTO `exam_question` VALUES ('40', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Mybatis 和 Jpa 的区别？', null, '5', '', '', '', '', 'Mybatis：在 JdbcTemplate 的基础上，自动填充 JavaBean 参数，自动映射 JavaBean，但仍需要手动写 Sql，被称之为“半自动 ORM”；\nHibernate：自动填充 JavaBean 参数，自动映射 JavaBean，自动解析 JavaBean 为 Hql、Jpql 语句（使用代理技术，框架读取代理类，代理类继承 JavaBean，并对 get、set 方法做了重写，这样代理类可以跟踪到 JavaBean 属性的变化，并封装为 Hql 语句，再转换为 Sql 语句对数据库进行操作），提供缓存（一级缓存（Session 缓存）、二级缓存（跨 Session 缓存）），被称之为“全自动 ORM”；\nJpa：Sun 公司制定的 ORM 规范，自己并没实现，常用的实现框架为 Hibernate；', '');
INSERT INTO `exam_question` VALUES ('41', '2021-05-28 08:58:24', 'shortAnswer', 'Java', '为什么我们需要 spring-boot-maven-plugin？', null, '5', '', '', '', '', 'spring-boot-maven-plugin 提供了一些像 jar 一样打包或者运行应用程序的命令；\nspring-boot:run：运行你的 SpringBoot 应用程序；\nspring-boot:repackage：重新打包你的 jar 包或者是 war 包使其可执行；\nspring-boot:start 和 spring-boot：stop 管理 Spring Boot 应用程序的生命周期（也可以说是为了集成测试）；\nspring-boot:build-info：生成执行器可以使用的构造信息；', '');
INSERT INTO `exam_question` VALUES ('42', '2021-05-28 08:58:24', 'shortAnswer', 'Java', '什么是嵌入式服务器？我们为什么要使用嵌入式服务器?', null, '5', '', '', '', '', '在虚拟机上部署服务：java环境 ---- web服务器 ---- 部署应用程序 war 包；\n嵌入式：使服务器成为应用程序的一部分，你只需要一个安装了 Java 的虚拟机，就可以直接在上面部署应用程序了；', '');
INSERT INTO `exam_question` VALUES ('43', '2021-05-28 08:58:24', 'programming', 'Java', '提供一个控制层接口或页面控制器，返回 user list 或包装 user list 数据；页面以表格形式展示 user list 数据。', null, '15', '', '', '', '', '@GetMapping(\"/thymeleafIndex\")\npublic String thymeleafIndexPage(ModelMap modelMap) {\n	int countryId = 522;\n	List<City> cities = cityService.getCitiesByCountryId(countryId);\n	\n	modelMap.addAttribute(\"cities\", cities);\n	\n	return \"index\";\n}\n<table>\n	<tr><td>ID</td><td>City Name</td></tr>\n	<tr th:each=\"city : ${cities}\">\n		<td th:text=\"${city.cityId}\"></td>\n		<td th:text=\"${city.cityName}\"></td>\n	</tr>\n</table>', '');
INSERT INTO `exam_question` VALUES ('44', '2021-05-28 08:58:24', 'programming', 'Java', '提供退出登录控制器，重定向到登录页面；', null, '15', '', '', '', '', '@GetMapping(\"/logout\")\npublic String logout() {\n	userService.logout();\n	return \"redirect:/login\";\n}', '');
INSERT INTO `exam_question` VALUES ('45', '2021-05-28 08:58:24', 'programming', 'Java', '设计一套购物车接口；', null, '15', '', '', '', '', '/api/redis/cart ---- get\n/api/redis/cartItem ---- post\n/api/redis/cartItem ---- put\n/api/redis/cartItem ---- delete\n/api/redis/cartItems ---- put\n/api/redis/cartItems ---- delete\n/api/redis/cart/checked ---- get', '');
INSERT INTO `exam_question` VALUES ('46', '2021-05-28 08:58:24', 'judge', 'Java', 'MyBatis 不支持延迟加载？', null, '2.5', '', '', '', '', 'False', '');
INSERT INTO `exam_question` VALUES ('47', '2021-05-28 08:58:24', 'judge', 'Java', '分布式和集群是一回事？', null, '2.5', '', '', '', '', 'False', '');
INSERT INTO `exam_question` VALUES ('48', '2021-05-28 08:58:24', 'judge', 'Java', 'MongoDB 是文件形数据库？', null, '2.5', '', '', '', '', 'True', '');
INSERT INTO `exam_question` VALUES ('49', '2021-05-28 08:58:24', 'judge', 'Java', 'Redis 是内存数据库？', null, '2.5', '', '', '', '', 'True', '');
INSERT INTO `exam_question` VALUES ('50', '2021-05-28 08:58:24', 'singleChoice', 'Java', 'Spring DAO 中最常用的类是？', null, '2.5', 'JdbcTemplate', 'SimpleJdbcInsert', 'SimpleJdbcInsert', 'SimpleJdbcQuery', 'A', '');
INSERT INTO `exam_question` VALUES ('51', '2021-05-28 08:58:24', 'singleChoice', 'Java', 'Spring AOP 中， 织入（Weaving） 可以在下面什么时间完成？', null, '2.5', '全部选项', 'Run time', 'Load time', 'Compile time', 'A', '');
INSERT INTO `exam_question` VALUES ('52', '2021-05-28 08:58:24', 'singleChoice', 'Java', '下面关于 Spring MVC 描述正确的是？', null, '2.5', 'DispatcherServlet 在 Spring MVC 中是核心servlet , 它负责接收请求并将请求分发给适合的控制器；', '在Spring MVC 中,可以配置多个 DispatcherServlet；', '全部选项', '要使 Spring MVC 可用，DispatcherServlet 需要在 web.xml 中配置；', 'C', '');
INSERT INTO `exam_question` VALUES ('53', '2021-05-28 08:58:25', 'singleChoice', 'Java', '下面哪项是 Spring 自动装载模式？', null, '2.5', 'autodetect', '全部选项', 'constructor', 'byname, byType', 'B', '');
INSERT INTO `exam_question` VALUES ('54', '2021-05-28 08:58:25', 'singleChoice', 'Java', 'Spring 中，下面哪一项不是使用事务的方法？', null, '2.5', 'proxies', 'declaratively', 'programmaticly', '全部', 'A', '');
INSERT INTO `exam_question` VALUES ('55', '2021-05-28 08:58:25', 'judge', 'Java', 'Spring 提供了 JMS 层的抽象，正确吗？', null, '2.5', '', '', '', '', 'True', '');
INSERT INTO `exam_question` VALUES ('56', '2021-05-28 08:58:25', 'singleChoice', 'Java', '关于 @Order 注解，最正确的描述是？', null, '2.5', '实现 org.springframework.core.Ordered 接口', '指定一个 bean 的范围', '通常用于注入域对象的属性', '全不正确', 'A', '');
INSERT INTO `exam_question` VALUES ('57', '2021-05-28 08:58:25', 'singleChoice', 'Java', '如何在 Spring 应用中使用 SLF4J？', null, '2.5', '作为日志框架', '全不正确', '作为一个 Bean', '作为 JDBC 框架', 'A', '');
INSERT INTO `exam_question` VALUES ('58', '2021-05-28 08:58:25', 'singleChoice', 'Java', 'Spring Bean 的默认作用范围是？', null, '2.5', '全不正确', 'Singleton', 'Prototype', 'Session', 'B', '');
INSERT INTO `exam_question` VALUES ('59', '2021-05-31 14:30:25', 'singleChoice', 'Python', '以下哪个不是 python 解释器？', '', '2.5', 'CPython', 'IPython', 'Jython', 'py', 'D', '');
INSERT INTO `exam_question` VALUES ('60', '2021-05-31 14:31:54', 'singleChoice', 'Python', '下列哪个表达式在 Python 中是非法的？', '', '2.5', 'x = y = z = 1', 'x = (y = z + 1)', 'x, y = y, x', 'x += y', 'B', '');
INSERT INTO `exam_question` VALUES ('61', '2021-05-31 14:32:43', 'singleChoice', 'Python', 'print(\"%d %% %d\"%(3, 5)) 输出结果是？', '', '2.5', '3 % 5', '3 %% 5', '2', '1', 'A', '');
INSERT INTO `exam_question` VALUES ('62', '2021-05-31 14:34:54', 'singleChoice', 'Python', '“今年第一季度 GDP 提高了 x%”，x 为 float 值，格式化字符串，x 保留两位小数，下面哪个是正确的？', '', '2.5', 'print(\"今年第一季度 GDP 提高了 %.2f\"%(22.234,))', 'print(\"今年第一季度 GDP 提高了 %.2f%\"%(22.234,))', 'print(\"今年第一季度 GDP 提高了 %.2f%%\"%(22.234,))', 'print(\"今年第一季度 GDP 提高了 {0}%\".format(22.234))', 'C', '');
INSERT INTO `exam_question` VALUES ('63', '2021-05-31 14:35:53', 'singleChoice', 'Python', 'l = [\"cdsa\", 32, 33.2, None, True]; l.pop(); print(l); 打印结果是？', '', '2.5', '[\"cdsa\", 32, 33.2, True]', '[\"cdsa\", 32, None, True]', '[\"cdsa\", 32, 33.2, None]', '[32, 33.2, None, True]', 'C', '');
INSERT INTO `exam_question` VALUES ('64', '2021-05-31 14:36:56', 'singleChoice', 'Python', 'print(15 // 2) 打印结果是？', '', '2.5', '1', '7', '7.5', '8', 'B', '');
INSERT INTO `exam_question` VALUES ('65', '2021-05-31 14:38:35', 'singleChoice', 'Python', '下面哪个不是 python 的数据类型？', '', '2.5', 'int', 'str', 'set', 'double', 'D', '');
INSERT INTO `exam_question` VALUES ('66', '2021-05-31 14:39:23', 'singleChoice', 'Python', 'Python 中 *args 代表什么参数？', '', '2.5', '位置参数', '可变参数', '可变关键字参数', '命名关键字参数', 'B', '');
INSERT INTO `exam_question` VALUES ('67', '2021-05-31 14:40:09', 'singleChoice', 'Python', '函数多个返回值，实际上返回的是什么数据类型？', '', '2.5', 'list', 'set', 'tuple', 'dict', 'C', '');
INSERT INTO `exam_question` VALUES ('68', '2021-05-31 14:41:11', 'singleChoice', 'Python', '安装 Django2.0.7 版本，使用什么命令？', '', '2.5', 'pip install django', 'pip install django=2.0.7', 'pip install django==2.0.7', 'pip install django version=2.0.7', 'C', '');
INSERT INTO `exam_question` VALUES ('69', '2021-05-31 14:42:45', 'fillBlank', 'Python', 'Python 中，字符串前面添加 u、r、b 分别代表什么？', '', '2.5', '', '', '', '', 'u ---- 后面字符串是以 Unicode 编码；\nr ---- 表明后面字符串是普通字符；\nb ---- 表明后面是 bytes；', '');
INSERT INTO `exam_question` VALUES ('70', '2021-05-31 14:44:49', 'fillBlank', 'Python', 'requests 模块请求远程服务器，如何设置相应编码？', '', '2.5', '', '', '', '', 'r = requests.get(url, headers=request_headers)\nr.encoding = r.apparent_encoding', '');
INSERT INTO `exam_question` VALUES ('71', '2021-05-31 14:46:46', 'fillBlank', 'Python', 'windows 下执行 python 的方式有？', '', '2.5', '', '', '', '', 'cmd ---- python ---- 进入交互式环境执行；\ncmd ---- python ***.py ---- 运行 Python 文件；', '');
INSERT INTO `exam_question` VALUES ('72', '2021-05-31 14:47:44', 'fillBlank', 'Python', '创建 python package，会自动生成什么文件？', '', '2.5', '', '', '', '', '__init__.py', '');
INSERT INTO `exam_question` VALUES ('73', '2021-05-31 14:50:15', 'fillBlank', 'Python', 'python 变量作用域有哪些？', '', '2.5', '', '', '', '', 'L （Local） ---- 局部作用域；\nE （Enclosing） ---- 闭包函数外的函数中；\nG （Global） ---- 全局作用域；\nB （Built-in） ---- 内建作用域；', '');
INSERT INTO `exam_question` VALUES ('74', '2021-05-31 14:50:59', 'shortAnswer', 'Python', 'python 命名规则？', '', '5', '', '', '', '', '英文字母、数字和下划线，不能以数字开头，扩展名 .py；', '');
INSERT INTO `exam_question` VALUES ('75', '2021-05-31 14:52:15', 'shortAnswer', 'Python', '正则表达式中 match、search 区别？', '', '5', '', '', '', '', 'match，从第一个字符开始匹配；\nsearch，全文搜索匹配；', '');
INSERT INTO `exam_question` VALUES ('76', '2021-05-31 14:53:39', 'shortAnswer', 'Python', 'set 删除操作中 pop、remove 的区别？', '', '5', '', '', '', '', 'pop：删除重新排序后的第一个元素，无参；\nremove：带参，删除与参数匹配的第一个元素；', '');
INSERT INTO `exam_question` VALUES ('77', '2021-05-31 14:56:30', 'shortAnswer', 'Python', 'list 使用 += 和 append 函数的区别？', '', '5', '', '', '', '', '+=：将目标 list 中的元素合并到前面 list 中；\nappend：将目标 list 作为一个元素添加到前面 list 中；', '');
INSERT INTO `exam_question` VALUES ('78', '2021-05-31 15:07:56', 'shortAnswer', 'Python', '简述 pymysql 操作数据库流程；', '', '5', '', '', '', '', '获取连接、游标；\n执行 sql 语句，增删改返回影响条目数，查询返回结果集；\n增删改操作，提交事务；\n关闭连接和游标；', '');
INSERT INTO `exam_question` VALUES ('79', '2021-05-31 15:09:57', 'shortAnswer', 'Python', '使用 bs4 解析响应内容，获取某 div（class 为 aaa）下所有 span 节点；', '', '5', '', '', '', '', 'bs.find(name=\"div\", attrs={\"class\": \"aaa\"}).find_all(name=\'span\')', '');
INSERT INTO `exam_question` VALUES ('80', '2021-05-31 15:14:50', 'shortAnswer', 'Python', '简述 Django 操作流程、组件的作用；', '', '5', '', '', '', '', '控制器（Url）：URL 分发，映射对应的 View；\n模型（Model）：提供数据访问接口和模块，包括数据字段、元数据、数据关系等的定义及操作；\n视图（View）：Django 的视图层封装了 HTTP Request 和 Response 的一系列操作和数据流，其主要功能包括 URL 映射机制、绑定模板等；\n模板（Template）：是一套 Django 自己的页面渲染模板语言，用若干内置的 tags 和 filters 定义页面的生成方式；', '');
INSERT INTO `exam_question` VALUES ('81', '2021-05-31 15:16:53', 'shortAnswer', 'Python', 'python 文件头部添加的如下代码，分别代表什么意思？ #!/usr/bin/env python3 # -*- coding: utf-8 -*- __author__ = \"HymanHu\";', '', '5', '', '', '', '', '第一行：告诉 Linux 系统，这是一个 Python 文件；\n第二行：让解释器以 utf8 编码去解析文件内容；\n第三行：该文件作者；', '');
INSERT INTO `exam_question` VALUES ('82', '2021-05-31 15:17:43', 'programming', 'Python', '定义一个函数，接受 0 个或多个参数，返回累计乘积；', '', '15', '', '', '', '', 'def product(*numbers):\n    if len(numbers) == 0:\n        raise TypeError(\"Param is error.\");\n    count = 1;\n    for i in numbers:\n        count *= i;\n    return count;\nprint(product(*[1,2,4,6,7]));\nprint(product(1,2,4,6,7));', '');
INSERT INTO `exam_question` VALUES ('83', '2021-05-31 15:19:31', 'programming', 'Python', '定义一个函数，去掉字符串前后的空格；', '', '15', '', '', '', '', 'def trim(s):\n    if len(s) == 0 or s.isspace():\n        return \'\';\n    while s[0] == \' \':\n        s = s[1:];\n    while s[-1] == \' \':\n        s = s[:-1];\n    return s;\nprint(trim(\"\"));\nprint(trim(\"  dsadad  \"));\n\nimport re;\ndef fun_2(s):\n    if s.startswith(\' \') or s.endswith(\' \'):\n        return re.sub(r\"^(\\s+)|(\\s+)$\", \"\", s);', '');
INSERT INTO `exam_question` VALUES ('84', '2021-05-31 15:20:08', 'programming', 'Python', '查找 list 中的最大值和最小值', '', '15', '', '', '', '', 'def find_max_min(l):\n    if len(l) == 0:\n        return (None, None);\n    if len(l) == 1:\n        return (l[0], l[0]);\n    max = l[0];\n    min = l[0];\n    for item in l:\n        if item > max:\n            max = item;\n        if item < min:\n            min = item;\n    return (min, max);\nprint(find_max_min([]));\nprint(find_max_min([1]));\nprint(find_max_min(range(10)));', '');
INSERT INTO `exam_question` VALUES ('85', '2021-05-31 21:40:37', 'shortAnswer', 'Java', '简述 JDK && JRE && JVM', '', '5', '', '', '', '', 'JDK：Java Development Kit，Java 开发包，Java 开发工具，包含 JRE、编译器、调试器、DOC 等；\nJRE：Java RunTime Envirment，Java 运行环境；\nJVM：java virtual machine，Java 虚拟机，类装载器、字节码校验器、解释器三个功能，是 Java 跨平台性的关键；', '');
INSERT INTO `exam_question` VALUES ('86', '2021-05-31 21:41:46', 'shortAnswer', 'Java', '简述执行 Java 文件流程', '', '5', '', '', '', '', 'Java 源程序 *.java ---- java编译器 ---- 转换成字节码*.class 文件 ---- 交给 JVM；\nJVM 共做三个步骤：\n类装载器\n字节码校验器\n解释器\n交给操作系统平台进行显示；', '');
INSERT INTO `exam_question` VALUES ('87', '2021-05-31 21:43:31', 'judge', 'Java', '能否在加载类的时候，对字节码进行修改？', '', '2.5', '', '', '', '', 'True', '使用 Java 探针技术（javaagent），运行在 main 方法之前的拦截器，它内定的方法名叫 premain，通过配置 -javaagent VM 参数实现；');
INSERT INTO `exam_question` VALUES ('88', '2021-05-31 21:53:43', 'fillBlank', 'Java', 'JVM 垃圾收集算法', '', '2.5', '', '', '', '', '标记-清除算法；\n复制算法；\n标记-整理算法；\n分代算法；', '');
INSERT INTO `exam_question` VALUES ('89', '2021-05-31 21:59:04', 'shortAnswer', 'Java', '简述 JVM 内存划分', '', '5', '', '', '', '', '类加载器（ClassLoader）；\n运行时数据区（Runtime Data Area） ---- 程序计数器、虚拟机栈、本地方法栈、堆、方法区；\n执行引擎（Execution Engine）；\n本地库接口（Native Interface）；', '');
INSERT INTO `exam_question` VALUES ('90', '2021-05-31 22:01:21', 'multipleChoice', 'Java', '下面哪些是 Java 的特征？', '', '5', '面向对象', '封装', '继承', '多态', 'A,B,C,D', '');
INSERT INTO `exam_question` VALUES ('91', '2021-05-31 22:02:53', 'shortAnswer', 'Java', '简述 System.out 和 System.in 的区别？', '', '5', '', '', '', '', 'System.in：标准输入流，此流已打开并准备提供输入数据，通常对应键盘输入；\nSystem.out：标准输出流，此流已打开并准备接受输出数据，通常，此流对应于显示器输出；', '');
INSERT INTO `exam_question` VALUES ('92', '2021-05-31 22:04:13', 'fillBlank', 'Java', 'Java 的基本数据类型是？', '', '2.5', '', '', '', '', '整形：字节型 byte 占 8bit、短整形 short 占 2B、整形 int 占 4B、长整形 long 占 8B；\n浮点型：单精度 float 占 4B、双精度 double 占 8B；\n字符型：char，采用 Unicode 编码，每个字符占 2B；\n逻辑型：布尔型 boolean，占 1bit；', '');
INSERT INTO `exam_question` VALUES ('93', '2021-05-31 22:07:43', 'judge', 'Java', 'long（8 byte）所占字节数大于 float（4 byte），所以数值范围 long 大。', '', '2.5', '', '', '', '', 'False', 'byte，short，int，long 它们在内存中都是直接换算成二进制存储的，所以我们可以直接计算出它们的最大值，二进制的第一位是符号位不计算入数值；\nfloat 类型，4 个字节，32 位，浮点数在内存中的二进制值不是直接转换为十进制数值的，而是按照公式计算而来，虽然只用到了 4 个字节，但是浮点数却比长整型的最大值要大；');
INSERT INTO `exam_question` VALUES ('94', '2021-05-31 22:10:17', 'singleChoice', 'Java', 'char x = \'b\'; int i = 0; System.out.println(true ? x : 0); System.out.println(true ? x : 65536); System.out.println(true ? x : 111111111); System.out.println(false ? i: x);', '', '2.5', 'b、98、98、98', '98、98、98、98', 'b、b、b、b', 'b、b、98、98', 'A', '// boolean -- 1byte, char -- 2byte, 0(short:0-65535) -- 2byte, int -- 4byte\n// 三目运算中自动转换类型，都打印x，但转换类型后结果为b、98、98、98');
INSERT INTO `exam_question` VALUES ('95', '2021-05-31 22:12:59', 'singleChoice', 'Java', 'Java 算术表达式优先级正确的是？', '', '2.5', '关系运算符 > 逻辑运算符! > 基本运算符 > 逻辑运算符 > 条件运算符 > 赋值运算符', '逻辑运算符! > 基本运算符 > 关系运算符 > 逻辑运算符 > 条件运算符 > 赋值运算符', '关系运算符 > 逻辑运算符! > 条件运算符 > 基本运算符 > 逻辑运算符 > 赋值运算符', '条件运算符 > 关系运算符 > 逻辑运算符! > 基本运算符 > 逻辑运算符 > 赋值运算符', 'B', '');
INSERT INTO `exam_question` VALUES ('96', '2021-05-31 22:14:08', 'singleChoice', 'Java', '5%3、-5%3、5%-3、-5%-3', '', '2.5', '-2、-2、-2、-2', '2、2、2、2', '2、-2、2、-2', '2、-2、-2、2', 'C', '符号看前面；');
INSERT INTO `exam_question` VALUES ('97', '2021-05-31 22:15:05', 'shortAnswer', 'Java', '简述 euqals 和 == 的区别', '', '5', '', '', '', '', 'euqals 和 == 的区别；\nequals：String比较值，引用型对象比较值和地址；', '');
INSERT INTO `exam_question` VALUES ('98', '2021-05-31 22:16:03', 'judge', 'Java', '两个对象的 hashCode() 相同，则 equals() 也一定为 true？', '', '2.5', '', '', '', '', 'False', 'hashCode() 相等即两个键值对的哈希值相等，然而哈希值相等，并不一定能得出键值对相等；');
INSERT INTO `exam_question` VALUES ('99', '2021-05-31 22:17:54', 'multipleChoice', 'Java', 'Java 访问修饰符有哪些？', '', '5', 'public', 'protected', '默认', 'private', 'A,B,C,D', '');
INSERT INTO `exam_question` VALUES ('100', '2021-05-31 22:21:01', 'shortAnswer', 'Java', '阐述 Java 中 final 关键字的作用。', '', '5', '', '', '', '', '修饰变量叫常量，不能被修改；\n修饰类叫终态类或最终类，不能被继承；\n修饰方法的时候，该方法不能被重写；', '');
INSERT INTO `exam_question` VALUES ('101', '2021-05-31 22:21:48', 'judge', 'Java', '抽象类必须要有抽象方法。', '', '2.5', '', '', '', '', 'False', '');
INSERT INTO `exam_question` VALUES ('102', '2021-05-31 22:22:27', 'judge', 'Java', '抽象类能使用 final 修饰。', '', '2.5', '', '', '', '', 'False', '不能，定义抽象类就是让其他类继承的，如果定义为 final 该类就不能被继承，这样彼此就会产生矛盾，所以 final 不能修饰抽象类；');
INSERT INTO `exam_question` VALUES ('103', '2021-05-31 22:23:18', 'fillBlank', 'Java', 'Math. round(-1. 5)', '', '2.5', '', '', '', '', '-1，在坐标轴上，向右取整；', '');
INSERT INTO `exam_question` VALUES ('104', '2021-05-31 22:23:54', 'shortAnswer', 'Java', '阐述 JavaBean 规范。', '', '5', '', '', '', '', 'JavaBean 必须包含一个无参的 public 构造方法；\n对私有属性必须提供符合规范的 get 和 set 方法；\nJavaBean 应该尽可能的串行化（序列化，实现 Serializable 接口）；', '');
INSERT INTO `exam_question` VALUES ('105', '2021-05-31 22:24:56', 'multipleChoice', 'Java', 'Java 中产生对象的方式有？', '', '5', 'new', '序列化和反序列化', '克隆', '反射', 'A,B,C,D', '');
INSERT INTO `exam_question` VALUES ('106', '2021-05-31 22:26:27', 'shortAnswer', 'Java', '阐述 Java 中 final、finally、finalize 的区别。', '', '5', '', '', '', '', 'final ---- 关键字\n修饰变量叫常量，不能被修改；\n修饰类叫终态类或最终类，不能被继承，例如 String 类；\n修饰方法的时候，该方法不能被重写；\nfinally ---- 关键字\n在 try、catch 和 finally 语句中，无论前面是否有异常，都会执行 finally 代码段；\n一般用于资源的回收和流关闭；\nfinalize ---- 方法名\n属于 object 类中的方法，作用是销毁对象、回收内存；\n注意和 System.gc(); 的区别 ---- 垃圾回收器，通知提醒内存进行内存回收；', '');
INSERT INTO `exam_question` VALUES ('107', '2021-05-31 22:28:51', 'fillBlank', 'Java', '填写五个 Java 异常；', '', '2.5', '', '', '', '', 'IOException、FileNotFoundException、NullPointerException、ArithmeticException、ArrayIndexOutOfBoundsException、ClassNotFoundException', '');
INSERT INTO `exam_question` VALUES ('108', '2021-05-31 22:29:40', 'shortAnswer', 'Java', 'Java 中 throw 和 throws 的区别', '', '5', '', '', '', '', 'throw：是真实抛出一个异常；\nthrows：是声明可能会抛出一个异常；', '');
INSERT INTO `exam_question` VALUES ('109', '2021-05-31 22:30:54', 'judge', 'Java', 'Java 中 try-catch-finally 语句都不可省略。', '', '2.5', '', '', '', '', 'False', '');
INSERT INTO `exam_question` VALUES ('110', '2021-05-31 22:32:07', 'shortAnswer', 'Java', '并行和并发有什么区别？', '', '5', '', '', '', '', '并行：多个处理器或多核处理器同时处理多个任务；\n并发：多个任务在同一个 CPU 核上，按细分的时间片轮流(交替)执行，从逻辑上来看那些任务是同时执行；', '');
INSERT INTO `exam_question` VALUES ('111', '2021-05-31 22:33:01', 'judge', 'Java', 'Java 中垃圾回收线程是特殊的守护线程。', '', '2.5', '', '', '', '', 'True', '');
INSERT INTO `exam_question` VALUES ('112', '2021-05-31 22:34:00', 'shortAnswer', 'Java', '线程实现方式？', '', '5', '', '', '', '', '继承 Thread 类，覆盖该类的 run 方法；\n实现 Runnable 接口，实现 run 方法；\n利用匿名内部类产生：方法中添加：new Thread(){public void run() {super.run();}}.start();', '');
INSERT INTO `exam_question` VALUES ('113', '2021-05-31 22:35:00', 'fillBlank', 'Java', '线程的几种状态？', '', '2.5', '', '', '', '', '创建、就绪、运行、阻塞、死亡', '');
INSERT INTO `exam_question` VALUES ('114', '2021-05-31 22:36:23', 'shortAnswer', 'Java', '阐述 Synchronized 与 Lock 的区别。', '', '5', '', '', '', '', 'synchronized：关键字、获取锁的线程执行完或异常才释放锁、等待线程会一直等待，无法判断锁状态、可重入、非公平（释放锁后，所有线程去竞争）、等待线程不可中断、少量同步；\nLock：\n接口、lock 之后需要在 finally 中 unlock，可用 tryLock 判断锁状态，尝试获取锁，失败后，等待线程不用一直等待、可重入、可公平（等待线程先到先得）、大量同步；\nReentrantLock：是 Lock 的一个实现分类，独占锁，公平锁，一个线程已经有锁了，其内部还能申请锁；', '');
INSERT INTO `exam_question` VALUES ('115', '2021-06-29 09:31:48', 'programming', 'Java', '设计行政区域表和接口，实现根据行政区域名字查询当前区域以及其子节点的功能。', '', '15', '', '', '', '', 'public class Region {\n	private String cityCode;\n	private String adCode;\n	private String name;\n	private String center;\n	private String level;\n	private String area;\n	private String perimeter;\n	private List<Region> districts;\n}\n\n/**\n * - 设置某行政区域子节点\n * @param region		行政区域\n * @param maxSeries		加载子节点最大级数\n */\npublic void buildSubDistric(Region region, int maxSeries) {\n	if (region == null || maxSeries == 0) {\n		return;\n	}\n	String adCode = region.getAdCode();\n	RegionLevel currentRegionLevel = RegionLevel.getRegionLevel(region.getLevel());\n	RegionLevel subRegionLevel = RegionLevel.getSubRegionLevel(currentRegionLevel.code);\n	if (subRegionLevel == null) {\n		return;\n	}\n	\n	String parentCode = \"\";\n	if (currentRegionLevel == RegionLevel.COUNTRY) {\n		parentCode = \"\";\n	} else if (currentRegionLevel == RegionLevel.PROVINCE) {\n		parentCode = adCode.substring(0, 2);\n	} else if (currentRegionLevel == RegionLevel.CITY) {\n		parentCode = adCode.substring(0, 4);\n	} else {\n		parentCode = adCode;\n	}\n	// 设置当前 region 子节点\n	List<Region> districts = regionDao.getRegionsByParentCodeAndLevel(parentCode, subRegionLevel.level);\n	region.setDistricts(districts);\n	\n	// 循环子节点，递归调用\n	districts.stream().forEach(item -> {\n		buildSubDistric(item, maxSeries - 1);\n	});\n}', '');
INSERT INTO `exam_question` VALUES ('116', '2021-06-29 11:17:21', 'shortAnswer', 'DB_Sql', 'Mysql 中查询十分钟之内的数据，表 A 有时间字段 report_time；', '', '5', '', '', '', '', 'select * from A where TIMESTAMPDIFF(MINUTE, report_time, now()) < 10', '');
