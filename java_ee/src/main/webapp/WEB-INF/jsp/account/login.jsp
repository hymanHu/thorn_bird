<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>Java EE Login</title>
	
	<!-- Css -->
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" rel="stylesheet" >
	<!-- Font Awesome -->
	<link href="${pageContext.request.contextPath}/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" >
	<!-- icheck bootstrap -->
	<link href="${pageContext.request.contextPath}/static/plugins/icheck-bootstrap/icheck-bootstrap.min.css" rel="stylesheet" >
	<!-- Theme style -->
	<link href="${pageContext.request.contextPath}/static/css/adminlte.css" type="text/css" rel="stylesheet">
	
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<b>Java EE</b> System
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">Sign in to start your session</p>
	
				<form action="javascript:void(0);">
					<div class="input-group mb-3">
						<input type="text" name="userName" class="form-control" placeholder="User Name">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-user"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" name="password" class="form-control" placeholder="Password">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-8">
							<div class="icheck-primary">
								<input type="checkbox" id="remember"> <label
									for="remember"> Remember Me </label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-4">
							<button id="loginButton" type="button" 
								class="btn btn-primary btn-block">Sign In</button>
						</div>
						<!-- /.col -->
					</div>
				</form>
	
				<p class="mb-0">
					<a href="/register" class="text-center">Register a new membership</a>
				</p>
			</div>
			<!-- /.login-card-body -->
		</div>
	</div>
	<!-- /.login-box -->
	
	<!-- Js -->
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/static/plugins/jquery/jquery.min.js"  type="text/javascript"></script>
	<!-- Bootstrap 4 -->
	<script src="${pageContext.request.contextPath}/static/plugins/bootstrap/js/bootstrap.bundle.min.js"  type="text/javascript"></script>
	<!-- layer -->
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js" type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="${pageContext.request.contextPath}/static/js/adminlte.js" type="text/javascript"></script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$("#loginButton").bind("click", function() {
			login();
		});
	})
	
	function login() {
		var user = {};
		user.userName = $("[name='userName']").val();
		user.password = $("[name='password']").val();
		$.ajax({
			url : "/login",
			type : "post",
			contentType: "application/json",
			data : JSON.stringify(user),
			success : function (data) {
				if (data.status == 200) {
					alert("Login Success.");
					//location.href = "/common/dashboard";
				} else {
					layer.msg(data.message, {icon: 0});
				}
			},
			error : function (data) {
				layer.msg(data.responseText, {icon: 0});
			}
		});
	}
	</script>
</body>
</html>