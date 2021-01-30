<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	<meta name="description" content="overview &amp; stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
	<title>Java_Spring_Mvc</title>
	
	<!-- css -->
	<!-- bootstrap -->
	<link href="/static/css/bootstrap.min.css" rel="stylesheet" />
	<!-- fontawesome -->
	<link href="/static/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet" />
	<!-- text fonts -->
	<link href="/static/css/fonts.googleapis.com.css" rel="stylesheet" />
	<!-- ace styles -->
	<link href="/static/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" rel="stylesheet" />
	<link href="/static/css/ace-skins.min.css" rel="stylesheet" />
	<link href="/static/css/ace-rtl.min.css" rel="stylesheet" />
</head>
<body class="no-skin">
	<!-- header -->
	<%@ include file="../fragments/header.jsp"%>
	
	<div class="main-container ace-save-state" id="main-container">
		<!-- sidebar -->
		<%@ include file="../fragments/sidebar.jsp"%>

		<!-- main content -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i><a href="#">Home</a></li>
						<li class="active">Test</li>
					</ul>

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon">
								<input type="text" placeholder="Search ..." class="nav-search-input"
									id="nav-search-input" autocomplete="off" />
								<i class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1> Test <small>
							<i class="ace-icon fa fa-angle-double-right"></i> index page </small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="space-6"></div>
								<h1>This is jsp test index page.</h1>
								<h3>获取变量</h3>
								<p>userName: ${userName }</p>
								<p>==================================================================</p>
								<h3>数据格式化</h3>
								<p>Date格式化: <fmt:formatDate value="${current1}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
								<p>LocalDateTime格式化: 
									<fmt:parseDate value="${current2}" pattern="y-M-dd'T'H:m:s" var="myParseDate"></fmt:parseDate> 
									<fmt:formatDate value="${myParseDate}"  pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate >
								</p>
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
									<c:forEach var="city" items="${cities }">
										<li>${city.cityName }</li>
									</c:forEach>
								</ul>
								<table>
									<thead><tr><td>Id</td><td>CityName</td></tr></thead>
									<tbody>
										<c:forEach var="city" items="${cities }">
											<tr><td>${city.cityId }</td><td>${city.cityName }</td></tr>
										</c:forEach>
									</tbody>
								</table>
								<select>
									<c:forEach var="city" items="${cities }">
										<option id="${city.cityId }">${city.cityName }</option>
									</c:forEach>
								</select>
								<p>==================================================================</p>
								<h3>Form</h3>
								<form action="/test/city" method="post">
									<input type="hidden" name="_method" value="put">
									<input type="hidden" value="${city.cityId }" name="cityId" />
									<p>City Name: <input type="text" name="cityName" value="${city.cityName }" /></p>
									<p>Local City Name: <input type="text" name="localCityName" value="${city.localCityName }"/></p>
									<p><button type="submit">Submit</button></p>
								</form>
								<p>==================================================================</p>
								<h3>File Upload</h3>
								<p>${message}</p>
								<img src="${relativePath }" width="200px;" height="200px;">
								<p>上传文件，使用multipart/form-data类型</p>
								<form action="/test/file" method="post" enctype="multipart/form-data">
									<input type="file" name="file">
									<button type="submit">上传</button>
								</form>
								<form action="/test/files" method="post" enctype="multipart/form-data">
									<input type="file" name="files">
									<input type="file" name="files">
									<button type="submit">上传</button>
								</form>
								<p>==================================================================</p>
							</div>
						</div>
					</div>
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

		<!-- footer -->
		<%@ include file="../fragments/footer.jsp"%>
	</div>
	<!-- /.main-container -->

	<!-- js -->
	<script src="/static/js/jquery-2.1.4.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<script src="/static/js/ace-elements.min.js"></script>
	<script src="/static/js/ace.min.js"></script>
	<script src="/static/js/ace-extra.min.js"></script>
	<script src="/static/js/custom.js"></script>
</body>
</html>
