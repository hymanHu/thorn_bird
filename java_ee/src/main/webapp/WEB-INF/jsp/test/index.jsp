<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>Java EE</title>
	
	<!-- Css -->
	<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/custom.css" type="text/css" rel="stylesheet">
	
	<!-- Js -->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<!-- layer -->
	<script th:src="@{https://cdn.bootcss.com/layer/2.1/layer.js}" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/js/custom.js" type="text/javascript"></script>
</head>
<body>
	<!-- 导航条 -->
	<%@ include file="../fragment/header.jsp"%>
	<!-- 左侧栏 -->
	<%@ include file="../fragment/sidebar.jsp"%>
	
	<!-- 内容区 -->
	<h1>This is jsp test index page.</h1>
	<h3>获取变量</h3>
	<p>userName: ${userName }</p>
	<p>otherName: ${otherName }</p>
	<p>==================================================================</p>
	<h3>数据格式化</h3>
	<p>时间格式化: <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
	<p>数字式化百分比: <fmt:formatNumber type="percent" value="${number / 100 }" maxFractionDigits="3" />
	<p>数字式化货币: <fmt:formatNumber type="currency" value="${number }" />
	<p>数字式化: <fmt:formatNumber type="number" value="${number }" maxFractionDigits="2" />
	<p>==================================================================</p>
	<h3>判断标签</h3>
	<c:set var="title" scope="page" value="青年"/>
	<c:if test="${age > 10 && age < 20}">
	   <p>称谓: <c:out value="${title}"/><p>
	</c:if>
	<c:choose>
	    <c:when test="${age < 10}">
	        <p>称谓: 儿童<p>
	    </c:when>
	    <c:when test="${age >= 10 && age < 30}">
	        <p>称谓: 青年<p>
	    </c:when>
	    <c:when test="${age >= 30 && age < 50}">
	        <p>称谓: 中年<p>
	    </c:when>
	    <c:otherwise>
	        <p>称谓: 老年<p>
	    </c:otherwise>
	</c:choose>
	<p>==================================================================</p>
	<h3>循环标签</h3>
	<ul>
		<c:forEach var="user" items="${users }">
			<li>${user.userName }</li>
		</c:forEach>
	</ul>
	<table>
		<thead><tr><td>Id</td><td>Name</td></tr></thead>
		<tbody>
			<c:forEach var="user" items="${users }">
				<tr><td>${user.id }</td><td>${user.userName }</td></tr>
			</c:forEach>
		</tbody>
	</table>
	<select>
		<c:forEach var="user" items="${users }">
			<option id="${user.id }">${user.userName }</option>
		</c:forEach>
	</select>

	<!-- 尾部 -->
	<%@ include file="../fragment/footer.jsp"%>
</body>
</html>