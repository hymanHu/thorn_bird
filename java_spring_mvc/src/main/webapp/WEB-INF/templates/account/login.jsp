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
							<div id="login-box" class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> Please Enter Your Information
										</h4>
										<div class="space-6"></div>
										<form>
											<fieldset>
												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<input type="text" class="form-control" 
															name="userName" placeholder="user name" />
														<i class="ace-icon fa fa-user"></i>
													</span>
												</label>
												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<input type="password" class="form-control"
															name="password" placeholder="password" />
														<i class="ace-icon fa fa-lock"></i>
													</span>
												</label>
												<label class="block clearfix inline">
													<input class="form-control input-val" type="text" value="" 
														placeholder="请输入验证码（不区分大小写）" 
														style="float:left; width:65%; margin-bottom: 0px;" />
													<canvas id="canvas" width="100" height="36" ></canvas>
												</label>
												<div class="space"></div>
												<div class="clearfix">
													<label class="inline">
														<input type="checkbox" class="ace" />
														<span class="lbl"> Remember Me</span>
													</label>
													<button type="button" name="loginBtn" 
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="ace-icon fa fa-key"></i>
														<span class="bigger-110">Login</span>
													</button>
												</div>
												<div class="space-4"></div>
											</fieldset>
										</form>
										<div class="social-or-login center">
											<span class="bigger-110">Or Login Using</span>
										</div>
										<div class="space-6"></div>
										<div class="social-login center">
											<a class="btn btn-primary">
												<i class="ace-icon fa fa-facebook"></i>
											</a>
											<a class="btn btn-info">
												<i class="ace-icon fa fa-twitter"></i>
											</a>
											<a class="btn btn-danger">
												<i class="ace-icon fa fa-google-plus"></i>
											</a>
										</div>
									</div>
									<div class="toolbar clearfix">
										<div>
											<a href="/forgot" data-target="#forgot-box" class="forgot-password-link">
												<i class="ace-icon fa fa-arrow-left"></i> I forgot my password
											</a>
										</div>
										<div>
											<a href="/register" data-target="#signup-box" class="user-signup-link">
												I want to register <i class="ace-icon fa fa-arrow-right"></i>
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
	</div>

	<!-- js -->
	<script src="/static/js/jquery-2.1.4.min.js"></script>
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js" type="text/javascript"></script>
	<script src="/static/js/bootbox.js"></script>
	<script type="text/javascript">
		var show_num = [];
		$(function() {
			draw(show_num);
			$("#canvas").on('click',function(){
				draw(show_num);
			});
			
			$("[name=loginBtn]").bind("click", function() {
				login();
			});
		});
		
		function login() {
			/* var code = $(".input-val").val();
			var num = show_num.join("");
			if (code == "") {
				layer.msg("Please input Verification Code.", {icon: 0});
				return;
			} else if (code != num) {
				layer.msg("The input code is error", {icon: 0});
				return;
			} */
			
			var user = {};
			user.userName = $("[name=userName]").val();
			user.password = $("[name=password]").val();
			if (user.userName == "" || user.password == "") {
				layer.msg("Please input user name and password", {icon: 0});
				return;
			}
			
			$.ajax({
				url : "/api/login",
				type : "post",
				contentType: "application/json",
				data : JSON.stringify(user),
				success : function (data) {
					if (data.status == 200) {
						window.location.href = "/common/dashboard";
					} else {
						layer.msg(data.message, {icon: 0});
					}
				},
				error : function (data) {
					layer.msg(data.responseText, {icon: 0});
				}
			});
		}
		
		//动态验证码
		function draw(show_num) {
			var canvas_width=$('#canvas').width();
			var canvas_height=$('#canvas').height();
			var canvas = document.getElementById("canvas");
			var context = canvas.getContext("2d");
			canvas.width = canvas_width;
			canvas.height = canvas_height;
			var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
			var aCode = sCode.split(",");
			var aLength = aCode.length;
			
			for (var i = 0; i <= 3; i++) {
				var j = Math.floor(Math.random() * aLength);
				var deg = Math.random() * 30 * Math.PI / 180;
				var txt = aCode[j];
				show_num[i] = txt.toLowerCase();
				var x = 10 + i * 20;
				var y = 20 + Math.random() * 8;
				context.font = "bold 23px 微软雅黑";

				context.translate(x, y);
				context.rotate(deg);

				context.fillStyle = randomColor();
				context.fillText(txt, 0, 0);

				context.rotate(-deg);
				context.translate(-x, -y);
			}
			for (var i = 0; i <= 5; i++) {
				context.strokeStyle = randomColor();
				context.beginPath();
				context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
				context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
				context.stroke();
			}
			for (var i = 0; i <= 30; i++) {
				context.strokeStyle = randomColor();
				context.beginPath();
				var x = Math.random() * canvas_width;
				var y = Math.random() * canvas_height;
				context.moveTo(x, y);
				context.lineTo(x + 1, y + 1);
				context.stroke();
			}
		}

		function randomColor() {
			var r = Math.floor(Math.random() * 256);
			var g = Math.floor(Math.random() * 256);
			var b = Math.floor(Math.random() * 256);
			return "rgb(" + r + "," + g + "," + b + ")";
		}
		
	</script>
</body>
</html>
