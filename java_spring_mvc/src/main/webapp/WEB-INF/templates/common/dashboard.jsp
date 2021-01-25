<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
						<li class="active">Dashboard</li>
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
						<h1> Dashboard <small>
							<i class="ace-icon fa fa-angle-double-right"></i> overview &amp; stats </small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="space-6"></div>
								<div class="col-sm-7 infobox-container">
									<div class="infobox infobox-green">
										<div class="infobox-icon">
											<i class="ace-icon fa fa-comments"></i>
										</div>
										<div class="infobox-data">
											<span class="infobox-data-number">32</span>
											<div class="infobox-content">comments + 2 reviews</div>
										</div>
										<div class="stat stat-success">8%</div>
									</div>
									<div class="infobox infobox-blue">
										<div class="infobox-icon">
											<i class="ace-icon fa fa-twitter"></i>
										</div>
										<div class="infobox-data">
											<span class="infobox-data-number">11</span>
											<div class="infobox-content">new followers</div>
										</div>
										<div class="badge badge-success">
											+32% <i class="ace-icon fa fa-arrow-up"></i>
										</div>
									</div>
									<div class="infobox infobox-pink">
										<div class="infobox-icon">
											<i class="ace-icon fa fa-shopping-cart"></i>
										</div>
										<div class="infobox-data">
											<span class="infobox-data-number">8</span>
											<div class="infobox-content">new orders</div>
										</div>
										<div class="stat stat-important">4%</div>
									</div>
									<div class="infobox infobox-red">
										<div class="infobox-icon">
											<i class="ace-icon fa fa-flask"></i>
										</div>
										<div class="infobox-data">
											<span class="infobox-data-number">7</span>
											<div class="infobox-content">experiments</div>
										</div>
									</div>

									<div class="infobox infobox-orange2">
										<div class="infobox-chart">
											<span class="sparkline"
												data-values="196,128,202,177,154,94,100,170,224"></span>
										</div>
										<div class="infobox-data">
											<span class="infobox-data-number">6,251</span>
											<div class="infobox-content">pageviews</div>
										</div>
										<div class="badge badge-success">
											7.2% <i class="ace-icon fa fa-arrow-up"></i>
										</div>
									</div>
									<div class="infobox infobox-blue2">
										<div class="infobox-progress">
											<div class="easy-pie-chart percentage" data-percent="42"
												data-size="46">
												<span class="percent">42</span>%
											</div>
										</div>
										<div class="infobox-data">
											<span class="infobox-text">traffic used</span>
											<div class="infobox-content">
												<span class="bigger-110">~</span> 58GB remaining
											</div>
										</div>
									</div>

									<div class="space-6"></div>

									<div class="infobox infobox-green infobox-small infobox-dark">
										<div class="infobox-progress">
											<div class="easy-pie-chart percentage" data-percent="61"
												data-size="39">
												<span class="percent">61</span>%
											</div>
										</div>
										<div class="infobox-data">
											<div class="infobox-content">Task</div>
											<div class="infobox-content">Completion</div>
										</div>
									</div>

									<div class="infobox infobox-blue infobox-small infobox-dark">
										<div class="infobox-chart">
											<span class="sparkline" data-values="3,4,2,3,4,4,2,2"></span>
										</div>
										<div class="infobox-data">
											<div class="infobox-content">Earnings</div>
											<div class="infobox-content">$32,000</div>
										</div>
									</div>
									<div class="infobox infobox-grey infobox-small infobox-dark">
										<div class="infobox-icon">
											<i class="ace-icon fa fa-download"></i>
										</div>
										<div class="infobox-data">
											<div class="infobox-content">Downloads</div>
											<div class="infobox-content">1,205</div>
										</div>
									</div>
								</div>

								<div class="vspace-12-sm"></div>

								<div class="col-sm-5">
									<div class="widget-box">
										<div class="widget-header widget-header-flat widget-header-small">
											<h5 class="widget-title">
												<i class="ace-icon fa fa-signal"></i> Traffic Sources
											</h5>
											<div class="widget-toolbar no-border">
												<div class="inline dropdown-hover">
													<button class="btn btn-minier btn-primary">
														This Week <i
															class="ace-icon fa fa-angle-down icon-on-right bigger-110"></i>
													</button>
													<ul class="dropdown-menu dropdown-menu-right dropdown-125 dropdown-lighter dropdown-close dropdown-caret">
														<li class="active">
															<a href="#" class="blue">
																<i class="ace-icon fa fa-caret-right bigger-110">&nbsp;</i>
																This Week
															</a>
														</li>
														<li>
															<a href="#">
																<i class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
																Last Week
															</a>
														</li>
													</ul>
												</div>
											</div>
										</div>
										<div class="widget-body">
											<div class="widget-main">
												<div id="piechart-placeholder"></div>
												<div class="hr hr8 hr-double"></div>
												<div class="clearfix">
													<div class="grid3">
														<span class="grey"> <i
															class="ace-icon fa fa-facebook-square fa-2x blue"></i>
															&nbsp; likes
														</span>
														<h4 class="bigger pull-right">1,255</h4>
													</div>

													<div class="grid3">
														<span class="grey"> <i
															class="ace-icon fa fa-twitter-square fa-2x purple"></i>
															&nbsp; tweets
														</span>
														<h4 class="bigger pull-right">941</h4>
													</div>

													<div class="grid3">
														<span class="grey"> <i
															class="ace-icon fa fa-pinterest-square fa-2x red"></i>
															&nbsp; pins
														</span>
														<h4 class="bigger pull-right">1,050</h4>
													</div>
												</div>
											</div>
											<!-- /.widget-main -->
										</div>
										<!-- /.widget-body -->
									</div>
									<!-- /.widget-box -->
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->

							<div class="hr hr32 hr-dotted"></div>
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
	<script src="/static/js/jquery-ui.custom.min.js"></script>
	<script src="/static/js/jquery.ui.touch-punch.min.js"></script>
	<script src="/static/js/jquery.easypiechart.min.js"></script>
	<script src="/static/js/jquery.sparkline.index.min.js"></script>
	<script src="/static/js/jquery.flot.min.js"></script>
	<script src="/static/js/jquery.flot.pie.min.js"></script>
	<script src="/static/js/jquery.flot.resize.min.js"></script>
	<script src="/static/js/ace-elements.min.js"></script>
	<script src="/static/js/ace.min.js"></script>
	<script src="/static/js/ace-extra.min.js"></script>
	<script src="/static/js/custom.js"></script>
	
	<script type="text/javascript">
		var placeholder = $('#piechart-placeholder').css({
			'width' : '90%',
			'min-height' : '150px'
		});
		var data = [ {
			label : "social networks",
			data : 38.7,
			color : "#68BC31"
		}, {
			label : "search engines",
			data : 24.5,
			color : "#2091CF"
		}, {
			label : "ad campaigns",
			data : 8.2,
			color : "#AF4E96"
		}, {
			label : "direct traffic",
			data : 18.6,
			color : "#DA5430"
		}, {
			label : "other",
			data : 10,
			color : "#FEE074"
		} ]
		function drawPieChart(placeholder, data, position) {
			$.plot(placeholder, data, {
				series : {
					pie : {
						show : true,
						tilt : 0.8,
						highlight : {
							opacity : 0.25
						},
						stroke : {
							color : '#fff',
							width : 2
						},
						startAngle : 2
					}
				},
				legend : {
					show : true,
					position : position || "ne",
					labelBoxBorderColor : null,
					margin : [ -30, 15 ]
				},
				grid : {
					hoverable : true,
					clickable : true
				}
			})
		}
		drawPieChart(placeholder, data);
	</script>
</body>
</html>
