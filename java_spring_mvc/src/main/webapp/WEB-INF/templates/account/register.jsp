<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	<title>Login Page - Java Spring</title>
	
	<meta name="description" content="User login page" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
	
	<!-- css -->
	<link href="/static/css/bootstrap.min.css" rel="stylesheet" />
	<link href="/static/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet" />
	<link href="/static/css/fonts.googleapis.com.css" rel="stylesheet" />
	<link href="/static/css/ace.min.css" rel="stylesheet" />
	<link href="/static/css/ace-rtl.min.css" rel="stylesheet" />
</head>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-leaf green"></i> <span class="red">Spring</span>
								<span class="white" id="id-text2">Application</span>
							</h1>
							<h4 class="blue" id="id-company-text">&copy; SFAC</h4>
						</div>
						<div class="space-6"></div>
						
						<div class="position-relative">
							<div id="signup-box" class="signup-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header green lighter bigger">
											<i class="ace-icon fa fa-users blue"></i>
											New User Registration
										</h4>
										<div class="space-6"></div>
										<p>Enter your details to begin:</p>
										<form>
											<fieldset>
												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<input type="email" name="email" 
															class="form-control" placeholder="Email" />
														<i class="ace-icon fa fa-envelope"></i>
													</span>
												</label>
												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<input type="text" name="userName" 
															class="form-control" placeholder="Username" />
														<i class="ace-icon fa fa-user"></i>
													</span>
												</label> 
												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<input type="password" name="password" 
															class="form-control" placeholder="Password" />
														<i class="ace-icon fa fa-lock"></i>
													</span>
												</label>
												<label class="block">
													<input type="checkbox" class="ace" name="agreement" />
													<span class="lbl"> I accept the <a href="#">User Agreement</a></span>
												</label>
												<div class="space-24"></div>
												<div class="clearfix">
													<button type="reset" class="width-30 pull-left btn btn-sm">
														<i class="ace-icon fa fa-refresh"></i>
														<span class="bigger-110">Reset</span>
													</button>
													<button type="button" name="registerBtn" 
														class="width-65 pull-right btn btn-sm btn-success">
														<span class="bigger-110">Register</span>
														<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									<div class="toolbar center">
										<a href="/login" data-target="#login-box"
											class="back-to-login-link">
											<i class="ace-icon fa fa-arrow-left"></i> Back to login
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- js -->
	<script src="/static/js/jquery-2.1.4.min.js"></script>
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js" type="text/javascript"></script>
	<script src="/static/js/bootbox.js"></script>
	<script type="text/javascript">
		$(function () {
			$("[name=registerBtn]").bind("click", function () {
				register();
			});
		});
		
		function register() {
			var agreement = $("[name=agreement]").prop("checked");
			if (!agreement) {
				layer.msg("Please accept the User Agreement", {icon: 0});
				return;
			}
			
			var user = {};
			user.email = $("[name=email]").val();
			user.userName = $("[name=userName]").val();
			user.password = $("[name=password]").val();
			$.ajax({
				url : "/api/user",
				type : "post",
				contentType: "application/json",
				data : JSON.stringify(user),
				success : function (data) {
					if (data.status == 200) {
						window.location.href = "/login";
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
