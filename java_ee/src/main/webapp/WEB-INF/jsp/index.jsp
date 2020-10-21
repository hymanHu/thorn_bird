<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<meta charset="UTF-8">
	<title>Java EE</title>
	
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
	<!-- 导航条 -->
	<%@ include file="./fragment/header.jsp"%>
	<!-- 左侧栏 -->
	<%@ include file="./fragment/sidebar.jsp"%>
	
	<!-- 内容区 -->
	<c:if test="${template != '' && template != null}">
		${template}
		<!-- include 指令 file 无法使用 el 表达式，但在页面上可以使用 el 表达式 -->
		<%-- <%@ include file="${template}"%> --%>
		<!-- include 动作 page 可以使用 el 表达式，但直接加载页面路劲，那么页面上无法使用 el 表达式 -->
		<%-- <jsp:include page="${template}"  flush = "true" /> --%>
	</c:if>

	<!-- 尾部 -->
	<%@ include file="./fragment/footer.jsp"%>
</body>
</html>