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
						<li class="active">Human Nature</li>
					</ul>

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon">
								<input type="text" placeholder="Search ..." class="nav-search-input" autocomplete="off" />
								<i class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1> Human Nature <small>
							<i class="ace-icon fa fa-angle-double-right"></i> Track Chart </small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div id="edit-basic" class="tab-pane active">
						<h4 class="header blue bolder smaller">事件&轨迹分析</h4>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<div class="input-group">
									<input type="text" id="target" class="form-control search-query" placeholder="Type target name">
									<span class="input-group-btn">
										<button id="targetBtn" type="button" class="btn btn-inverse btn-white">
											<span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
											Search
										</button>
									</span>
								</div>
							</div>
							<div class="vspace-12-sm"></div>
							<div class="col-xs-12 col-sm-8">
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right">姓名</label>
									<span id="userNameSpan"></span>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right">人品估值</label>
									<span id="assessmentSpan"></span>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right">推测标签</label>
									<span id="labelSpan"></span>
								</div>
								<div class="space-2"></div>
							</div>
						</div>
					</div>
					<div class="hr hr32 hr-dotted"></div>
					<div class="row">
						<div class="col-sm-6">
							<div class="widget-box transparent">
								<div class="widget-header widget-header-flat">
									<h4 class="widget-title lighter">
										<i class="ace-icon fa fa-signal"></i>
										列表统计
									</h4>
									<div class="widget-toolbar">
										<a href="#" data-action="collapse">
											<i class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div>
								</div>
								
								<div class="widget-body">
									<ul id="tracksLiPanel" class="item-list ui-sortable"></ul>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="widget-box transparent">
								<div class="widget-header widget-header-flat">
									<h4 class="widget-title lighter">
										<i class="ace-icon fa fa-signal"></i>
										饼图统计
									</h4>
									<div class="widget-toolbar">
										<a href="#" data-action="collapse">
											<i class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div>
								</div>

								<div class="widget-body">
									<div class="widget-main padding-4">
										<div id="tracksPiePanel"></div>
										<div id="hover"></div>
										<div class="hr hr8 hr-double"></div>
										<div class="clearfix" id="tracksPiePanelFooter"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="hr hr32 hr-dotted"></div>
					<div class="row">
						<div class="col-sm-12">
							<div class="widget-box transparent">
								<div class="widget-header widget-header-flat">
									<h4 class="widget-title lighter">
										<i class="ace-icon fa fa-signal"></i>
										曲线统计图
									</h4>
									<select name="type"></select>
									<div class="widget-toolbar">
										<a href="#" data-action="collapse">
											<i class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main padding-4">
										<div id="tracksLinePanel"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>

		<!-- footer -->
		<%@ include file="../fragments/footer.jsp"%>
		
		<!-- 新增、修改页面 -->
		<%@ include file="./trackAdd.jsp"%>
		<%@ include file="./trackEdit.jsp"%>
	</div>

	<!-- js -->
	<script src="/static/js/jquery-2.1.4.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<!-- layer -->
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js"></script>
	<!-- confirm box -->
	<script src="/static/js/bootbox.js"></script>
	<!-- plot -->
	<script src="/static/js/jquery.flot.min.js"></script>
	<script src="/static/js/jquery.flot.pie.min.js"></script>
	<script src="/static/js/jquery.flot.resize.min.js"></script>
	<script src="/static/js/jquery.flot.time.js"></script>
	<!-- ace -->
	<script src="/static/js/ace-elements.min.js"></script>
	<script src="/static/js/ace.min.js"></script>
	<script src="/static/js/ace-extra.min.js"></script>
	<!-- custom -->
	<script src="/static/js/custom.js"></script>
	
	<script type="text/javascript">
		$(function() {
			initTrackType();
			getTracksTypeCount("");
			getTrackTypeStatistics("", "");
			
			$("#targetBtn").bind("click", function() {
				var target = $("#target").val();
				getTracksTypeCount(target);
				getTrackTypeStatistics(target, "");
			});
			
			$("[name=type]").bind("change", function() {
				var target = $("#target").val();
				var type = $("[name=type]").val();
				getTrackTypeStatistics(target, type);
			});
		});
		
		// 初始化事件类型下拉框
		function initTrackType() {
			$.ajax({
				url : "/api/dict/trackTypes",
				type : "get",
				success : function (data) {
					var trackType = $("[name=type]");
					trackType.append("<option value=''>请选择类型</option>");
					$.each(data, function(i, item) {
						trackType.append("<option value='" + item.name + "'>" + item.name + "</option>");
					});
				},
				error : function (data) {
					layer.msg(data.responseText, {icon: 0});
				}
			});
		}
		
		// 获取事件类型总统计数据
		function getTracksTypeCount(target) {
			$.ajax({
				url : "/api/trackTypeVos/count?target=" + target,
				type : "get",
				success : function (rs) {
					drawLiPanel(rs);
					drawPiePanel(rs);
					initAnalysisPanel(rs);
				},
				error : function (rs) {
					layer.msg(rs.responseText, {icon: 0});
				}
			});
		}
		
		// 获取事件类型每月统计数据
		function getTrackTypeStatistics(target, type) {
			$.ajax({
				url : "/api/trackTypeVos/statistics?target=" + target + "&type=" + type,
				type : "get",
				success : function (rs) {
					drawLinePanel(rs);
				},
				error : function (rs) {
					layer.msg(rs.responseText, {icon: 0});
				}
			});
		}
		
		function initAnalysisPanel(rs) {
			var target = $("#target").val();
			if (target == "" || rs.length == 0) {
				$("#userNameSpan").html(target == "" ? "未选定目标" : target);
				$("#assessmentSpan").html("没有数据");
				$("#labelSpan").html("没有数据");
				return;
			}
			var assessmentCount = 0;
			var label = [];
			$.each(rs, function(i, item) {
				assessmentCount += item.assessment;
				if (i < 3) {
					label.push(item.label);
				}
			});
			$("#userNameSpan").html(target);
			$("#assessmentSpan").html(assessmentCount + "分");
			$("#labelSpan").html(label.join("、"));
		}
		
		// 初始化 li 列表面板
		function drawLiPanel(rs) {
			if (rs.length == 0) {
				$("#tracksLiPanel").html("没有数据");
				return;
			}
			
			var temp = "";
			$.each(rs, function(i, item) {
				if (i <= 4) {
					temp += "<li class='item-red clearfix ui-sortable-handle'>";
					temp += "<label class='inline'>";
					temp += "<span class='lbl'>" + item.type + "</span>";
					temp += "</label>";
					temp += "<div class='pull-right'>";
					temp += "<span>" + item.count + "</span> 次";
					temp += "</div>";
					temp += "</li>";
				}
			});
			$("#tracksLiPanel").html(temp);
		}
		
		// 饼图设置
		var pieGraphSettings = {
			series: {
				pie: {
					show: true,
					tilt: 0.8,
					highlight: {
						opacity: 0.25
					},
					stroke: {
						color: '#fff',
						width: 2
					},
					startAngle: 2,
				}
			},
			legend: {
				show: true,
				position: "ne", 
				labelBoxBorderColor: null,
				margin:[-30,15]
			},
			grid: {
				hoverable: true,
				clickable: true
			},
		};
		
		// 初始化饼图面板
		function drawPiePanel(rs) {
			if (rs.length == 0) {
				$("#tracksPiePanel").html("没有数据");
				$("#tracksPiePanelFooter").html("没有数据");
				return;
			}
			
			var pieData = [];
			var otherPercent = 0;
			var other = {};
			var tracksPiePanelFooter = $("#tracksPiePanelFooter");
			var footerString = "";
			$.each(rs, function(i, item) {
				if (i < 4) {
					var temp = {};
					temp.label = item.type;
					temp.data = item.percent;
					otherPercent += item.percent;
					pieData.push(temp);
				}
				if (i < 3) {
					footerString += "<div class='grid3'>";
					footerString += "<span class='grey'>";
					footerString += "<i class='ace-icon fa fa-bell fa-2x blue'></i>";
					footerString += item.type;
					footerString += "</span>";
					footerString += "<h4 class='bigger pull-right'>" + item.count + "次</h4>";
					footerString += "</div>";
				}
			});
			if (otherPercent < 100) {
				other.label = "其他";
				other.data = 100 - otherPercent;
				pieData.push(other);
			}
			tracksPiePanelFooter.html(footerString);
			
			var tracksPiePanel = $("#tracksPiePanel").css({'width':'90%' , 'min-height':'150px'});
			$.plot(tracksPiePanel, pieData, pieGraphSettings);
			
			tracksPiePanel.bind("plothover", function(event, pos, obj) {
				if (!obj)  return;  
				percent = parseFloat(obj.series.percent).toFixed(2);  
				$("#hover").html('<span style="font-weight: bold; color: ' + obj.series.color + '">' 
					+ obj.series.label + ' (' + percent + '%)</span>');
			});
		}
		
		// 曲线图设置
		var lineGraphSettings = {
			hoverable: true,
			shadowSize: 0,
			series: {
				lines: { show: true },
				points: { show: true }
			},
			xaxis: {
				tickColor : "rgba(51, 51, 51, 0.06)",
				position: 'bottom',
				mode : "time",
				timeformat: "%Y/%m",
				tickSize : [ 1, "month" ],
			},
			yaxis: {
				ticks : 10,
				tickColor : "rgba(51, 51, 51, 0.06)",
				axisLabel : "次数",
				tickSize : 1,
			},
			grid: {
				backgroundColor: { colors: [ "#fff", "#fff" ] },
				borderWidth: 1,
				borderColor:'#555'
			}
		};
		
		// 初始化曲线图面板
		function drawLinePanel(rs) {
			if ($.isEmptyObject(rs) == true) {
				$("#tracksLinePanel").html("没有数据");
				return;
			}
			
			$("#tracksLinePanel").html("");
			var data = [];
			var index = 0;
			$.each(rs, function(key, value) {
				if (index < 3) {
					var line = [];
					$.each(value, function(i, item) {
						var temp = [];
						temp.push(new Date(item.yearMounth + "-01"));
						temp.push(item.count);
						line.push(temp);
					});
					//data.push(line);
					data.push({label:"<div style='color: #0b2e13'>" + key + "</div>", data:line});
					index += 1;
				}
			});
			var tracksLinePanel = $("#tracksLinePanel").css({'width':'100%' , 'height':'220px'});
			$.plot(tracksLinePanel, data, lineGraphSettings);
		}
	</script>
</body>
</html>
