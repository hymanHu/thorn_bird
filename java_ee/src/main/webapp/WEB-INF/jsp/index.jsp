<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<meta charset="UTF-8">
	<title>Java EE</title>
</head>
<body>
	<!-- 导航条 -->
	<%@ include file="./fragment/header.jsp"%>
	<!-- 左侧栏 -->
	<%@ include file="./fragment/sidebar.jsp"%>
	
	<!-- 内容区 -->
	<c:if test="${template != '' && template != null}">
		<!-- include 指令无法使用 el 表达式 -->
		<%-- <%@ include file="${template}"%> --%>
		<%-- <jsp:include page="${template}"  flush = "true" /> --%>
		${template}
		<iframe scrolling="auto" rameborder="0" src="${template}" name="right" width="100%" height="100%"></iframe>
	</c:if>

	<!-- 尾部 -->
	<%@ include file="./fragment/footer.jsp"%>
</body>
</html>