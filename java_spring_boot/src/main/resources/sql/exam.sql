/*
Navicat MySQL Data Transfer

Source Server         : myConnection
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2021-05-31 16:18:10
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
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

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
INSERT INTO `exam_question` VALUES ('39', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Shiro 两大功能实现流程', null, '5', '', '', '', '', '', '');
INSERT INTO `exam_question` VALUES ('40', '2021-05-28 08:58:23', 'shortAnswer', 'Java', '简述 Mybatis 和 Jpa 的区别？', null, '5', '', '', '', '', 'Mybatis：在 JdbcTemplate 的基础上，自动填充 JavaBean 参数，自动映射 JavaBean，但仍需要手动写 Sql，被称之为“半自动 ORM”；\nHibernate：自动填充 JavaBean 参数，自动映射 JavaBean，自动解析 JavaBean 为 Hql、Jpql 语句（使用代理技术，框架读取代理类，代理类继承 JavaBean，并对 get、set 方法做了重写，这样代理类可以跟踪到 JavaBean 属性的变化，并封装为 Hql 语句，再转换为 Sql 语句对数据库进行操作），提供缓存（一级缓存（Session 缓存）、二级缓存（跨 Session 缓存）），被称之为“全自动 ORM”；\nJpa：Sun 公司制定的 ORM 规范，自己并没实现，常用的实现框架为 Hibernate；', '');
INSERT INTO `exam_question` VALUES ('41', '2021-05-28 08:58:24', 'shortAnswer', 'Java', '为什么我们需要 spring-boot-maven-plugin？', null, '5', '', '', '', '', 'spring-boot-maven-plugin 提供了一些像 jar 一样打包或者运行应用程序的命令；\nspring-boot:run：运行你的 SpringBoot 应用程序；\nspring-boot:repackage：重新打包你的 jar 包或者是 war 包使其可执行；\nspring-boot:start 和 spring-boot：stop 管理 Spring Boot 应用程序的生命周期（也可以说是为了集成测试）；\nspring-boot:build-info：生成执行器可以使用的构造信息；', '');
INSERT INTO `exam_question` VALUES ('42', '2021-05-28 08:58:24', 'shortAnswer', 'Java', '什么是嵌入式服务器？我们为什么要使用嵌入式服务器?', null, '5', '', '', '', '', '在虚拟机上部署服务：java环境 ---- web服务器 ---- 部署应用程序 war 包；\n嵌入式：使服务器成为应用程序的一部分，你只需要一个安装了 Java 的虚拟机，就可以直接在上面部署应用程序了；', '');
INSERT INTO `exam_question` VALUES ('43', '2021-05-28 08:58:24', 'programming', 'Java', '提供一个控制层接口或页面控制器，返回 user list 或包装 user list 数据；页面以表格形式展示 user list 数据。格的形式显示出来', null, '15', '', '', '', '', '@GetMapping(\"/thymeleafIndex\")\npublic String thymeleafIndexPage(ModelMap modelMap) {\n	int countryId = 522;\n	List<City> cities = cityService.getCitiesByCountryId(countryId);\n	\n	modelMap.addAttribute(\"cities\", cities);\n	\n	return \"index\";\n}\n<table>\n	<tr><td>ID</td><td>City Name</td></tr>\n	<tr th:each=\"city : ${cities}\">\n		<td th:text=\"${city.cityId}\"></td>\n		<td th:text=\"${city.cityName}\"></td>\n	</tr>\n</table>', '');
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
