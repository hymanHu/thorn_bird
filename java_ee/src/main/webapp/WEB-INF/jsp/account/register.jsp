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
	<link href="/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" >
	<!-- icheck bootstrap -->
	<link href="/static/plugins/icheck-bootstrap/icheck-bootstrap.min.css" rel="stylesheet" >
	<!-- Theme style -->
	<link href="/static/css/adminlte.css" type="text/css" rel="stylesheet">
	
</head>
<body class="hold-transition register-page">
	<div class="register-box">
		<div class="register-logo">
			<b>Java EE</b> System
		</div>
	
		<div class="card">
			<div class="card-body register-card-body">
				<p class="login-box-msg">Register a new membership</p>
	
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
								<input type="checkbox" id="agreeTerms" name="terms" value="agree">
								<label for="agreeTerms"> I agree to the <a href="#">terms</a>
								</label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-4">
							<button type="botton" id="registerBtn" class="btn btn-primary btn-block">Register</button>
						</div>
						<!-- /.col -->
					</div>
				</form>
	
				<a href="/login" class="text-center">I already have a membership</a>
			</div>
			<!-- /.form-box -->
		</div>
		<!-- /.card -->
	</div>
	<!-- /.register-box -->
	
	<!-- Js -->
	<!-- jQuery -->
	<script src="/static/plugins/jquery/jquery.min.js"  type="text/javascript"></script>
	<!-- Bootstrap 4 -->
	<script src="/static/plugins/bootstrap/js/bootstrap.bundle.min.js"  type="text/javascript"></script>
	<!-- layer -->
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js" type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="/static/js/adminlte.js" type="text/javascript"></script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$("#registerBtn").bind("click", function() {
			register();
		});
	})
	
	function register() {
		if ($("#agreeTerms").prop("checked") == false) {
			layer.msg("Please checked agree.", {icon: 0});
			return;
		}
		
		var user = {};
		user.userName = $("[name='userName']").val();
		user.password = $("[name='password']").val();
		$.ajax({
			url : "/api/user",
			type : "post",
			contentType: "application/json",
			data : JSON.stringify(user),
			success : function (data) {
				if (data.status == 200) {
					location.href = "/login";
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