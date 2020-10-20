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
	${template}
	<c:if test="${template != '' && template != null}">
		${template}
		<%@ include file="/WEB-INF/jsp/test/index.jsp"%>
	</c:if>

	<!-- 尾部 -->
	<%@ include file="./fragment/footer.jsp"%>
</body>
</html>