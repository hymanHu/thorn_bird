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
	<!-- fileinput -->
	<link href="/static/plugin/bootstrap-fileinput/css/fileinput.css" rel="stylesheet" />
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
			<div class="page-content">
				<div class="page-header">
					<h1>User Profile
						<small>
							<i class="ace-icon fa fa-angle-double-right"></i>
							人间忽晚，山河已秋
						</small>
					</h1>
				</div>
			
				<div class="row">
					<div class="col-xs-12">
						<div>
							<div id="user-profile-1" class="user-profile row">
								<div class="col-xs-12 col-sm-3 center">
									<div>
										<span class="profile-picture">
											<img name="userImage" class="editable img-responsive" src="" />
										</span>
										<div class="space-4"></div>
										<div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
											<div class="inline position-relative">
												<a href="javascript:void(0);" class="user-title-label">
													<i class="ace-icon fa fa-circle light-green"></i>
													<span name="userName" class="white">Hyman Hu</span>
												</a>
											</div>
										</div>
									</div>
									<div class="space-6"></div>
									<div class="profile-contact-info">
										<div class="profile-contact-links align-left">
											<a href="#" class="btn btn-link" data-toggle='modal' data-target='#editModal'>
												<i class="ace-icon fa fa-gears bigger-120 green"></i>
												Edit profile
											</a>
											<a href="#" class="btn btn-link">
												<i class="ace-icon fa fa-envelope bigger-120 pink"></i>
												Send a message
											</a>
										</div>
										<div class="space-6"></div>
										<div class="profile-social-links align-center">
											<a href="#" class="tooltip-info" title="" data-original-title="Visit my Facebook">
												<i class="middle ace-icon fa fa-facebook-square fa-2x blue"></i>
											</a>
											<a href="#" class="tooltip-info" title="" data-original-title="Visit my Twitter">
												<i class="middle ace-icon fa fa-twitter-square fa-2x light-blue"></i>
											</a>
											<a href="#" class="tooltip-error" title="" data-original-title="Visit my Pinterest">
												<i class="middle ace-icon fa fa-pinterest-square fa-2x red"></i>
											</a>
										</div>
									</div>
									<div class="hr hr12 dotted"></div>
									<div class="clearfix">
										<div class="grid2">
											<span class="bigger-175 blue">25</span>
											<br />
											Followers
										</div>
										<div class="grid2">
											<span class="bigger-175 blue">12</span>
											<br />
											Following
										</div>
									</div>
									<div class="hr hr16 dotted"></div>
								</div>
			
								<div class="col-xs-12 col-sm-9">
									<div class="center">
										<span class="btn btn-app btn-sm btn-light no-hover">
											<span class="line-height-1 bigger-170 blue"> 1,411 </span>
											<br />
											<span class="line-height-1 smaller-90"> Views </span>
										</span>
										<span class="btn btn-app btn-sm btn-yellow no-hover">
											<span class="line-height-1 bigger-170"> 32 </span>
											<br />
											<span class="line-height-1 smaller-90"> Followers </span>
										</span>
										<span class="btn btn-app btn-sm btn-pink no-hover">
											<span class="line-height-1 bigger-170"> 4 </span>
											<br />
											<span class="line-height-1 smaller-90"> Projects </span>
										</span>
										<span class="btn btn-app btn-sm btn-grey no-hover">
											<span class="line-height-1 bigger-170"> 23 </span>
											<br />
											<span class="line-height-1 smaller-90"> Reviews </span>
										</span>
										<span class="btn btn-app btn-sm btn-success no-hover">
											<span class="line-height-1 bigger-170"> 7 </span>
											<br />
											<span class="line-height-1 smaller-90"> Albums </span>
										</span>
										<span class="btn btn-app btn-sm btn-primary no-hover">
											<span class="line-height-1 bigger-170"> 55 </span>
											<br />
											<span class="line-height-1 smaller-90"> Contacts </span>
										</span>
									</div>
									<div class="space-12"></div>
									<div class="profile-user-info profile-user-info-striped">
										<div class="profile-info-row">
											<div class="profile-info-name"> Username </div>
											<div class="profile-info-value">
												<span class="editable" name="userName">Hyman Hu</span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name"> Email </div>
											<div class="profile-info-value">
												<span class="editable" name="email">hj@163.com</span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name"> Location </div>
											<div class="profile-info-value">
												<i class="fa fa-map-marker light-orange bigger-110"></i>
												<span class="editable" id="country">Netherlands</span>
												<span class="editable" id="city">Amsterdam</span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name"> Age </div>
											<div class="profile-info-value">
												<span class="editable" id="age">38</span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name"> Joined </div>
											<div class="profile-info-value">
												<span class="editable" id="signup">2010/06/20</span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name"> Last Online </div>
											<div class="profile-info-value">
												<span class="editable" id="login">3 hours ago</span>
											</div>
										</div>
										<div class="profile-info-row">
											<div class="profile-info-name"> About Me </div>
											<div class="profile-info-value">
												<span class="editable" id="about">Editable as WYSIWYG</span>
											</div>
										</div>
									</div>
									<div class="space-20"></div>
									<div class="widget-box transparent">
										<div class="widget-header widget-header-small">
											<h4 class="widget-title blue smaller">
												<i class="ace-icon fa fa-rss orange"></i>
												Recent Activities
											</h4>
											<div class="widget-toolbar action-buttons">
												<a href="#" data-action="reload">
													<i class="ace-icon fa fa-refresh blue"></i>
												</a>
												<a href="#" class="pink">
													<i class="ace-icon fa fa-trash-o"></i>
												</a>
											</div>
										</div>
										<div class="widget-body">
											<div class="widget-main padding-8">
												<div id="profile-feed-1" class="profile-feed">
													<div class="profile-activity clearfix">
														<div>
															<img class="pull-left" alt="Alex Doe's avatar" src="/static/images/avatars/avatar5.png" />
															<a class="user" href="#"> Alex Doe </a>
															changed his profile photo.
															<a href="#">Take a look</a>
															<div class="time">
																<i class="ace-icon fa fa-clock-o bigger-110"></i>
																an hour ago
															</div>
														</div>
														<div class="tools action-buttons">
															<a href="#" class="blue">
																<i class="ace-icon fa fa-pencil bigger-125"></i>
															</a>
															<a href="#" class="red">
																<i class="ace-icon fa fa-times bigger-125"></i>
															</a>
														</div>
													</div>
													<div class="profile-activity clearfix">
														<div>
															<img class="pull-left" alt="Susan Smith's avatar" src="/static/images/avatars/avatar1.png" />
															<a class="user" href="#"> Susan Smith </a>
															is now friends with Alex Doe.
															<div class="time">
																<i class="ace-icon fa fa-clock-o bigger-110"></i>
																2 hours ago
															</div>
														</div>
														<div class="tools action-buttons">
															<a href="#" class="blue">
																<i class="ace-icon fa fa-pencil bigger-125"></i>
															</a>
															<a href="#" class="red">
																<i class="ace-icon fa fa-times bigger-125"></i>
															</a>
														</div>
													</div>
													<div class="profile-activity clearfix">
														<div>
															<i class="pull-left thumbicon fa fa-check btn-success no-hover"></i>
															<a class="user" href="#"> Alex Doe </a>
															joined
															<a href="#">Country Music</a>
															group.
															<div class="time">
																<i class="ace-icon fa fa-clock-o bigger-110"></i>
																5 hours ago
															</div>
														</div>
														<div class="tools action-buttons">
															<a href="#" class="blue">
																<i class="ace-icon fa fa-pencil bigger-125"></i>
															</a>
															<a href="#" class="red">
																<i class="ace-icon fa fa-times bigger-125"></i>
															</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="hr hr2 hr-double"></div>
									<div class="space-6"></div>
									<div class="center">
										<button type="button" class="btn btn-sm btn-primary btn-white btn-round">
											<i class="ace-icon fa fa-rss bigger-150 middle orange2"></i>
											<span class="bigger-110">View more activities</span>
											<i class="icon-on-right ace-icon fa fa-arrow-right"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.page-content -->
		</div>

		<!-- footer -->
		<%@ include file="../fragments/footer.jsp"%>
		
		<!-- 修改页面 -->
		<%@ include file="./profileEdit.jsp"%>
	</div>

	<!-- js -->
	<!-- jquery -->
	<script src="/static/js/jquery-2.1.4.min.js"></script>
	<script src="/static/js/jquery-ui.custom.min.js"></script>
	<script src="/static/js/jquery.ui.touch-punch.min.js"></script>
	<script src="/static/js/jquery.gritter.min.js"></script>
	<script src="/static/js/jquery.easypiechart.min.js"></script>
	<script src="/static/js/jquery.hotkeys.index.min.js"></script>
	<script src="/static/js/jquery.maskedinput.min.js"></script>
	<!-- bootstrap -->
	<script src="/static/js/bootstrap.min.js"></script>
	<script src="/static/js/bootstrap-datepicker.min.js"></script>
	<script src="/static/js/bootstrap-wysiwyg.min.js"></script>
	<script src="/static/js/bootstrap-editable.min.js"></script>
	<!-- select2 -->
	<script src="/static/js/select2.min.js"></script>
	<!-- spinbox -->
	<script src="/static/js/spinbox.min.js"></script>
	<!-- layer -->
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js"></script>
	<!-- confirm box -->
	<script src="/static/js/bootbox.js"></script>
	<!-- fileinput -->
	<script src="/static/plugin/bootstrap-fileinput/js/fileinput.js"></script>
	<!-- ace -->
	<script src="/static/js/ace-elements.min.js"></script>
	<script src="/static/js/ace.min.js"></script>
	<script src="/static/js/ace-extra.min.js"></script>
	<script src="/static/js/ace-editable.min.js"></script>
	<!-- custom -->
	<script src="/static/js/custom.js"></script>
	
	<script type="text/javascript">
		$(function() {
			initProfile()
			initFileInput();
		});
		
		function initProfile() {
			var userId = $("#userId").val();
			$.ajax({
				url : "/api/user/" + userId,
				type : "get",
				//contentType: "application/json",
				//data : JSON.stringify(role),
				success : function (data) {
					var userImage = "/static/images/avatars/profile-pic.jpg";
					if (data.userImage != null) {
						userImage = data.userImage;
					}
					$("[name=userImage]").attr("src", userImage);
					$("[name=userName]").html(data.userName);
					$("[name=userName]").val(data.userName);
					$("[name=email]").val(data.email);
				},
				error : function (data) {
					layer.msg(data.responseText, {icon: 0});
				}
			});
		}
		
		function initFileInput() {
			$("#uploadImage").fileinput({
				uploadUrl: "/api/image/profile-big",
				enctype: 'multipart/form-data',
				previewFileType: "image",
				uploadAsync: true,
				allowedFileExtensions: ["png", "jpg", "jpeg", "ico", "bmp", "gif"],
				maxFileCount: 1,
				maxFileSize: 1024,
				minImageWidth: 50,
		        minImageHeight: 50,
		        maxImageWidth: 300,
		        maxImageHeight: 500,
		        msgFilesTooMany: "Upload file count({n} - {m})",
				showCaption: false,
				dropZoneEnabled:false,
				showBrowse: true,
				browseClass: "btn btn-primary",
				uploadClass: "btn btn-info",
				removeClass: "btn btn-danger"
			}).on('fileerror', function (event, data, msg) {
				layer.alert("Upload file failed" + msg, {icon: 0});
			}).on('fileuploaded', function (event, data) {
				if (data.response.status == 200) {
					$("#userImage").val(data.response.data);
					$('#uploadImage').fileinput('disable');
				} else {
					$(".fileinput-remove-button").click()
				}
				layer.alert(data.response.message, {icon: 0});
			}).on('fileclear', function (event) {
			});
		}
		
	</script>
</body>
</html>
