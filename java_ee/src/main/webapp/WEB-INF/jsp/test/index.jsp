<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>Java EE</title>
	
	<!-- Css -->
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" rel="stylesheet" >
	<!-- Font Awesome -->
	<link href="/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" >
	<!-- overlayScrollbars -->
	<link href="/static/plugins/overlayScrollbars/css/OverlayScrollbars.min.css" rel="stylesheet" >
	<!-- Theme style -->
	<link href="/static/css/adminlte.css" type="text/css" rel="stylesheet">
	
</head>
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
	<div class="wrapper">
		<!-- 导航条 -->
		<%@ include file="../fragment/header.jsp"%>
		<!-- 左侧栏 -->
		<%@ include file="../fragment/sidebar.jsp"%>
		
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">Test</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="/dashboard">Home</a></li>
								<li class="breadcrumb-item active">Jsp Test Page</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->
		
			<!-- Main content -->
			<section class="content">
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
							<tr><td>${user.userId }</td><td>${user.userName }</td></tr>
						</c:forEach>
					</tbody>
				</table>
				<select>
					<c:forEach var="user" items="${users }">
						<option id="${user.userId }">${user.userName }</option>
					</c:forEach>
				</select>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		
		<!-- 尾部 -->
		<%@ include file="../fragment/footer.jsp"%>
	</div>
	
	<!-- Js -->
	<!-- jQuery -->
	<script src="/static/plugins/jquery/jquery.min.js"  type="text/javascript"></script>
	<!-- Bootstrap 4 -->
	<script src="/static/plugins/bootstrap/js/bootstrap.bundle.min.js"  type="text/javascript"></script>
	<!-- overlayScrollbars -->
	<script src="/static/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"  type="text/javascript"></script>
	<!-- ChartJS -->
	<script src="/static/plugins/chart.js/Chart.min.js"  type="text/javascript"></script>
	<!-- layer -->
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js" type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="/static/js/adminlte.js" type="text/javascript"></script>
	<!-- demo -->
	<script src="/static/js/demo.js" type="text/javascript"></script>
	<!-- custom -->
	<script src="/static/js/custom.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
		});
	</script>
</body>
</html>