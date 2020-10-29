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
	<link href="${pageContext.request.contextPath}/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" >
	<!-- overlayScrollbars -->
	<link href="${pageContext.request.contextPath}/static/plugins/overlayScrollbars/css/OverlayScrollbars.min.css" rel="stylesheet" >
	<!-- Theme style -->
	<link href="${pageContext.request.contextPath}/static/css/adminlte.css" type="text/css" rel="stylesheet">
	
</head>
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
	<div class="wrapper">
		<!-- 导航条 -->
		<%@ include file="./fragment/header.jsp"%>
		<!-- 左侧栏 -->
		<%@ include file="./fragment/sidebar.jsp"%>
		
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">Dashboard</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="/dashboard">Home</a></li>
								<li class="breadcrumb-item active">Dashboard</li>
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
				<div class="container-fluid">
					<!-- Info boxes -->
					<div class="row">
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box">
								<span class="info-box-icon bg-info elevation-1"><i
									class="fas fa-cog"></i></span>
		
								<div class="info-box-content">
									<span class="info-box-text">CPU Traffic</span> <span
										class="info-box-number"> 10 <small>%</small>
									</span>
								</div>
								<!-- /.info-box-content -->
							</div>
							<!-- /.info-box -->
						</div>
						<!-- /.col -->
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box mb-3">
								<span class="info-box-icon bg-danger elevation-1"><i
									class="fas fa-thumbs-up"></i></span>
		
								<div class="info-box-content">
									<span class="info-box-text">Likes</span> <span
										class="info-box-number">41,410</span>
								</div>
								<!-- /.info-box-content -->
							</div>
							<!-- /.info-box -->
						</div>
						<!-- /.col -->
		
						<!-- fix for small devices only -->
						<div class="clearfix hidden-md-up"></div>
		
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box mb-3">
								<span class="info-box-icon bg-success elevation-1"><i
									class="fas fa-shopping-cart"></i></span>
		
								<div class="info-box-content">
									<span class="info-box-text">Sales</span> <span
										class="info-box-number">760</span>
								</div>
								<!-- /.info-box-content -->
							</div>
							<!-- /.info-box -->
						</div>
						<!-- /.col -->
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box mb-3">
								<span class="info-box-icon bg-warning elevation-1"><i
									class="fas fa-users"></i></span>
		
								<div class="info-box-content">
									<span class="info-box-text">New Members</span> <span
										class="info-box-number">2,000</span>
								</div>
								<!-- /.info-box-content -->
							</div>
							<!-- /.info-box -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
		
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<h5 class="card-title">Monthly Recap Report</h5>
		
									<div class="card-tools">
										<button type="button" class="btn btn-tool"
											data-card-widget="collapse">
											<i class="fas fa-minus"></i>
										</button>
										<div class="btn-group">
											<button type="button" class="btn btn-tool dropdown-toggle"
												data-toggle="dropdown">
												<i class="fas fa-wrench"></i>
											</button>
											<div class="dropdown-menu dropdown-menu-right" role="menu">
												<a href="#" class="dropdown-item">Action</a> <a href="#"
													class="dropdown-item">Another action</a> <a href="#"
													class="dropdown-item">Something else here</a> <a
													class="dropdown-divider"></a> <a href="#"
													class="dropdown-item">Separated link</a>
											</div>
										</div>
										<button type="button" class="btn btn-tool"
											data-card-widget="remove">
											<i class="fas fa-times"></i>
										</button>
									</div>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<div class="row">
										<div class="col-md-8">
											<p class="text-center">
												<strong id="gzbdTitle"></strong>
											</p>
		
											<div class="chart">
												<!-- Sales Chart Canvas -->
												<canvas id="salesChart" height="180" style="height: 180px;"></canvas>
											</div>
											<!-- /.chart-responsive -->
										</div>
										<!-- /.col -->
										<div class="col-md-4">
											<p class="text-center">
												<strong>Goal Completion</strong>
											</p>
		
											<div class="progress-group">
												<span class="progress-text">确诊数</span>
												<span class="float-right"><b name="diagnosisValue">160</b>/200</span>
												<div class="progress progress-sm">
													<div name="diagnosisProgress" class="progress-bar bg-primary" style="width: 80%"></div>
												</div>
											</div>
											<!-- /.progress-group -->
		
											<div class="progress-group">
												<span class="progress-text">境外输入数</span>
												<span class="float-right"><b name="overseasImportValue">310</b>/200</span>
												<div class="progress progress-sm">
													<div name="overseasImportProgress" class="progress-bar bg-warning" style="width: 75%"></div>
												</div>
											</div>
		
											<!-- /.progress-group -->
											<div class="progress-group">
												<span class="progress-text">治愈数</span>
												<span class="float-right"><b name="cureValue">480</b>/200</span>
												<div class="progress progress-sm">
													<div name="cureImportProgress" class="progress-bar bg-success" style="width: 60%"></div>
												</div>
											</div>
		
											<!-- /.progress-group -->
											<div class="progress-group">
												<span class="progress-text">死亡数</span>
												<span class="float-right"><b name="deathValue">480</b>/200</span>
												<div class="progress progress-sm">
													<div name="deathProgress" class="progress-bar bg-danger" style="width: 50%"></div>
												</div>
											</div>
											<!-- /.progress-group -->
										</div>
										<!-- /.col -->
									</div>
									<!-- /.row -->
								</div>
								<!-- ./card-body -->
								<div class="card-footer">
									<div class="row">
										<div class="col-sm-3 col-6">
											<div class="description-block border-right">
												<span name="diagnosisPercent" class="description-percentage text-success">
													<i class="fas fa-caret-up"></i> 17%
												</span>
												<h5 name="diagnosisValue" class="description-header">$35,210.43</h5>
												<span class="description-text">确诊病例</span>
											</div>
											<!-- /.description-block -->
										</div>
										<!-- /.col -->
										<div class="col-sm-3 col-6">
											<div class="description-block border-right">
												<span name="overseasImportPercent" class="description-percentage text-warning">
													<i class="fas fa-caret-left"></i> 0%
												</span>
												<h5 name="overseasImportValue" class="description-header">$10,390.90</h5>
												<span class="description-text">境外输入</span>
											</div>
											<!-- /.description-block -->
										</div>
										<!-- /.col -->
										<div class="col-sm-3 col-6">
											<div class="description-block border-right">
												<span name="curePercent" class="description-percentage text-success">
													<i class="fas fa-caret-up"></i> 20%
												</span>
												<h5 name="cureValue" class="description-header">$24,813.53</h5>
												<span class="description-text">治愈</span>
											</div>
											<!-- /.description-block -->
										</div>
										<!-- /.col -->
										<div class="col-sm-3 col-6">
											<div class="description-block">
												<span name="deathPercent" class="description-percentage text-danger">
													<i class="fas fa-caret-down"></i> 18%
												</span>
												<h5 name="deathValue" class="description-header">1200</h5>
												<span class="description-text">死亡</span>
											</div>
											<!-- /.description-block -->
										</div>
									</div>
									<!-- /.row -->
								</div>
								<!-- /.card-footer -->
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
		
				</div>
				<!--/. container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		
		<!-- 尾部 -->
		<%@ include file="./fragment/footer.jsp"%>
	</div>
	
	<!-- Js -->
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/static/plugins/jquery/jquery.min.js"  type="text/javascript"></script>
	<!-- Bootstrap 4 -->
	<script src="${pageContext.request.contextPath}/static/plugins/bootstrap/js/bootstrap.bundle.min.js"  type="text/javascript"></script>
	<!-- overlayScrollbars -->
	<script src="${pageContext.request.contextPath}/static/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"  type="text/javascript"></script>
	<!-- layer -->
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js" type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="${pageContext.request.contextPath}/static/js/adminlte.js" type="text/javascript"></script>
	<!-- demo -->
	<script src="${pageContext.request.contextPath}/static/js/demo.js" type="text/javascript"></script>
	<!-- ChartJS -->
	<script src="${pageContext.request.contextPath}/static/plugins/chart.js/Chart.min.js"  type="text/javascript"></script>
	<!-- custom -->
	<script src="${pageContext.request.contextPath}/static/js/custom.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			gzbdLineGraph();
		});
		
		function gzbdLineGraph() {
			$.ajax({
				url: "/api/gzbds",
				type: "get",
				success: function (result) {
					var labels = [], diagnosis = [], overseasImport = [], cure = [], death = [];
					$.each(result.reverse(), function(i, item) {
						labels.push(item.date);
						diagnosis.push(item.diagnosis);
						overseasImport.push(item.overseasImport);
						cure.push(item.cure);
						death.push(item.death);
					});
					
					$("#gzbdTitle").html("GZBD: " + labels[0] + " ~ " + labels[labels.length - 1]);
					
					var gzbdChartData = {
						labels : labels,
						datasets : [ {
							label : '确诊数',
							backgroundColor : 'rgba(0,123,255,1)',
							borderColor : 'rgba(0,123,255,1)',
							pointRadius : false,
							pointColor : '#3b8bba',
							pointStrokeColor : 'rgba(60,141,188,1)',
							pointHighlightFill : '#fff',
							pointHighlightStroke : 'rgba(60,141,188,1)',
							data : diagnosis
						}, {
							label : '治愈数',
							backgroundColor : '	rgba(40,167,69,1)',
							borderColor : '	rgba(40,167,69,1)',
							pointRadius : false,
							pointColor : 'rgba(210, 214, 222, 1)',
							pointStrokeColor : '#c1c7d1',
							pointHighlightFill : '#fff',
							pointHighlightStroke : 'rgba(220,220,220,1)',
							data : cure
						}, {
							label : '死亡数',
							backgroundColor : '	rgba(220,53,69,1)',
							borderColor : '	rgba(220,53,69,1)',
							pointRadius : false,
							pointColor : 'rgba(210, 214, 222, 1)',
							pointStrokeColor : '#c1c7d1',
							pointHighlightFill : '#fff',
							pointHighlightStroke : 'rgba(220,220,220,1)',
							data : death
						}, {
							label : '输入数',
							backgroundColor : 'rgba(255,193,7,1)',
							borderColor : 'rgba(255,193,7,1)',
							pointRadius : false,
							pointColor : 'rgba(210, 214, 222, 1)',
							pointStrokeColor : '#c1c7d1',
							pointHighlightFill : '#fff',
							pointHighlightStroke : 'rgba(220,220,220,1)',
							data : overseasImport
						} ]
					};
					
					var gzbdChartOptions = {
						maintainAspectRatio : false,
						responsive : true,
						legend : {
							display : false
						},
						scales : {
							xAxes : [ {
								gridLines : {
									display : false
								}
							} ],
							yAxes : [ {
								gridLines : {
									display : false
								}
							} ]
						}
					};
					
					// draw gzbd lines graph
					var salesChart = new Chart($('#salesChart'), {
						type : 'line',
						data : gzbdChartData,
						options : gzbdChartOptions
					});
					
					// fill the gzbd data
					var diagnosisValue = diagnosis[diagnosis.length - 1];
					var diagnosisPercent = parseFloat(((diagnosis[diagnosis.length - 1] - diagnosis[diagnosis.length - 2]) 
							/ diagnosis[diagnosis.length - 2]) * 100).toFixed(2) ;
					var diagnosisString = "<i class='fas fa-caret-up'></i> " + diagnosisPercent + "%";
					if (diagnosisPercent == 0) {
						diagnosisString = "<i class='fas fa-caret-left'></i> " + diagnosisPercent + "%";
					} else if (diagnosisPercent < 0) {
						diagnosisString = "<i class='fas fa-caret-down'></i> " + diagnosisPercent + "%";
					}
					$("[name=diagnosisPercent]").html(diagnosisString);
					$("[name=diagnosisValue]").html(diagnosisValue);
					
					var overseasImportValue = overseasImport[overseasImport.length - 1];
					var overseasImportPercent = parseFloat(((overseasImport[overseasImport.length - 1] - overseasImport[overseasImport.length - 2]) 
							/ overseasImport[overseasImport.length - 2]) * 100).toFixed(2) ;
					var overseasImportString = "<i class='fas fa-caret-up'></i> " + overseasImportPercent + "%";
					if (overseasImportPercent == 0) {
						overseasImportString = "<i class='fas fa-caret-left'></i> " + overseasImportPercent + "%";
					} else if (overseasImportPercent < 0) {
						overseasImportString = "<i class='fas fa-caret-down'></i> " + overseasImportPercent + "%";
					}
					$("[name=overseasImportPercent]").html(overseasImportString);
					$("[name=overseasImportValue]").html(overseasImportValue);
					
					var cureValue = cure[cure.length - 1];
					var curePercent = parseFloat(((cure[cure.length - 1] - cure[cure.length - 2]) 
							/ cure[cure.length - 2]) * 100).toFixed(2) ;
					var cureString = "<i class='fas fa-caret-up'></i> " + curePercent + "%";
					if (curePercent == 0) {
						cureString = "<i class='fas fa-caret-left'></i> " + curePercent + "%";
					} else if (curePercent < 0) {
						cureString = "<i class='fas fa-caret-down'></i> " + curePercent + "%";
					}
					$("[name=curePercent]").html(cureString);
					$("[name=cureValue]").html(cureValue);
					
					var deathValue = death[death.length - 1];
					var deathPercent = parseFloat(((death[death.length - 1] - death[death.length - 2]) 
							/ death[death.length - 2]) * 100).toFixed(2) ;
					var deathString = "<i class='fas fa-caret-up'></i> " + deathPercent + "%";
					if (deathPercent == 0) {
						deathString = "<i class='fas fa-caret-left'></i> " + deathPercent + "%";
					} else if (deathPercent < 0) {
						deathString = "<i class='fas fa-caret-down'></i> " + deathPercent + "%";
					}
					$("[name=deathPercent]").html(deathString);
					$("[name=deathValue]").html(deathValue);
					
					// fill the gzbd progress data
					$("[name=diagnosisProgress]").css("width", diagnosisValue * 100 / 200 + "%")
					$("[name=cureProgress]").css("width", cureValue * 100 / 200 + "%")
					$("[name=overseasImportProgress]").css("width", overseasImportValue * 100 / 200 + "%")
					$("[name=deathProgress]").css("width", deathValue * 100 / 200 + "%")
					
				},
				error : function (data) {
					layer.msg(data.responseText, {icon: 0});
				}
			});
		}
		
	</script>
</body>
</html>