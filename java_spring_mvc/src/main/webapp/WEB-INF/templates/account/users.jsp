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
						<li class="active">Account</li>
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
						<h1> Account <small>
							<i class="ace-icon fa fa-angle-double-right"></i> users </small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								This is users page.
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
