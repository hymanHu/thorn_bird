<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>试卷列表</title>
	
	<!-- css -->
	<!-- Exam -->
	<link href="/static/_exam/css/main.css" rel="stylesheet" />
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" rel="stylesheet" />
	<!-- Font Awesome -->
	<link href="/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" />
	<!-- Select2 -->
	<link href="/static/plugins/select2/css/select2.min.css" rel="stylesheet">
	<link href="/static/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css" rel="stylesheet" />
	<!-- DataTables -->
	<link href="/static/plugins/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet" />
	<link href="/static/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css" rel="stylesheet" />
	<!-- loading -->
	<link href="/static/plugins/jquery.mloading/src/jquery.mloading.css" rel="stylesheet" />
	<!-- admin -->
	<link href="/static/_exam/css/adminlte.css" type="text/css" rel="stylesheet" />
	<!-- custom -->
	<link href="/static/css/custom.css" type="text/css" rel="stylesheet" />
	
</head>
<body class="hold-transition layout-top-nav">
	<div class="wrapper">
		<!-- 导航条 -->
		<%@ include file="../fragment/examNavigation.jsp"%>
		
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 name="subject" class="m-0 text-dark">试卷列表</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">主页</a></li>
								<li class="breadcrumb-item active">试卷列表</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->
			
			<section class="content">
				<div class="container">
					<div class="card card-default">
						<div class="card-header">
							<h3 class="card-title">试卷生成器</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool" data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
								<button type="button" class="btn btn-tool" data-card-widget="remove">
									<i class="fas fa-times"></i>
								</button>
							</div>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label>测试阶段</label>
										<select name="flag" class="form-control select2" style="width: 100%;"></select>
									</div>
									<div class="form-group">
										<label>试卷标题</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span name="titlePrefix" class="input-group-text"></span>
											</div>
											<input name="title" type="text" class="form-control" placeholder="">
											<div class="input-group-append">
												<span name="titleSuffix" class="input-group-text">_${sessionScope.user.userName}</span>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>试题类型</label>
										<div class="select2-purple">
											<select name="type" class="select2bs4" multiple="multiple"
												data-placeholder="选择题型" style="width: 100%;">
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>测试时间</label>
										<select name="paperTime" class="form-control select2" style="width: 100%;">
											<option value="45" selected="selected">45 分钟</option>
											<option value="60">60 分钟</option>
											<option value="90">90 分钟</option>
											<option value="120">120 分钟</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<!-- /.card-body -->
						<div class="card-footer">
							<button name="paperBuilderBtn" type="button" class="btn btn-primary btn-lg">创建</button>
						</div>
					</div>
					
					<div class="card">
						<div class="card-header">
							<span class="nav-link">试卷列表</span>
							<!-- <h3 class="card-title"><span class="nav-link">试卷列表</span></h3>
							<h3 class="card-title" style="float:right;">
								<a href="/exam/achievements" class="nav-link">成绩列表</a>
							</h3> -->
						</div>
						<div class="card-body">
							<table id="papersTable" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>试卷 ID</th>
										<th>试卷标题</th>
										<th>考试时间</th>
										<th>总分</th>
										<th>创建日期</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody></tbody>
							</table>
						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
			</section>
		</div>
	</div>
	
	<!-- js -->
	<!-- jQuery -->
	<script src="/static/plugins/jquery/jquery.min.js"  type="text/javascript"></script>
	<!-- bootstrap -->
	<script src="/static/plugins/bootstrap/js/bootstrap.bundle.min.js"  type="text/javascript"></script>
	<!-- Select2 -->
	<script src="/static/plugins/select2/js/select2.full.min.js"  type="text/javascript"></script>
	<!-- DataTables -->
	<script src="/static/plugins/datatables.net/js/jquery.dataTables.min.js"  type="text/javascript"></script>
	<script src="/static/plugins/datatables.net-bs/js/dataTables.bootstrap.min.js"  type="text/javascript"></script>
	<!-- loading -->
	<script src="/static/plugins/jquery.mloading/src/jquery.mloading.js"  type="text/javascript"></script>
	<!-- layer -->
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js" type="text/javascript"></script>
	<!-- confirm-->
	<script src="/static/js/bootbox.js" type="text/javascript"></script>
	<!-- admin -->
	<script src="/static/js/adminlte.js"></script>
	<!-- custom -->
	<script src="/static/js/custom.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		PAGE_SIZE = 5;
		$(document).ready(function() {
		    // Initialize Select2 Elements
			$('.select2').select2();
		    $('.select2bs4').select2({
				theme: 'bootstrap4'
		    });
		    
		    // 初始化试题阶段下拉列表、绑定 change 事件
		    initQuestionFlag();
		    $("[name=flag]").bind("change", function() {
		    	$("[name=titlePrefix]").html($(this).val() + "_");
		    });
		    // 初始化试卷类型下拉框
		    initQuestionType();
		    
		    // 初始化试卷列表
		    initTable(PAGE_SIZE);
		    
		    // 绑定新增按钮
		    $("[name=paperBuilderBtn]").bind("click", function() {
				addPaper();
			});
		})
		
		function initTable(pageSize) {
			$('#papersTable').DataTable({
				'paging': true, //分页
				"serverSide": true, //开启后端分页
				"pagingType": "full_numbers", //分页样式的类型simple/simple_numbers/full/full_numbers
				"pageLength": pageSize, //定义初始的页长
				"processing": true, 
				"destroy": true, //允许销毁替换，在表格重新查询时，可以自动销毁以前的data
				'lengthChange': true, //控制是否能够调整每页的条数
				'searching': true,
				'data-show-refresh': true,
				'ordering': true,
				'autoWidth': false,
				"ajax": function (data, callback, settings) {
					// 从data获取查询数据
					var columIndex = data.order[0].column;
					var direction = data.order[0].dir;
					var orderBy = data.columns[columIndex].name;
					pageSize = data.length == undefined  ? pageSize : data.length;
					
					var searchBean = {};
					searchBean.currentPage = (data.start / pageSize) + 1;
					searchBean.pageSize = pageSize;
					searchBean.orderBy = orderBy;
					searchBean.direction = direction;
					searchBean.keyWord = data.search.value;
		
					$.ajax({
						url : "/api/papers",
						type : "post",
						contentType: "application/json",
						data : JSON.stringify(searchBean),
						success : function (rs) {
							var tableData = {
								draw :0,
								recordsTotal: 0,
								recordsFiltered: 0,
								data: []
							};
							if (!rs) {
								layer.alert("请求出错，请稍后重试" + rs.errmsg, {icon: 2});
								callback(tableData);
								return;
							};
							if (rs.list == null) {
								$('#datatable tbody tr').remove();
								$('#loading').remove();
								callback(tableData);
								return;
							}
							$('#loading').remove();
							var rowsDatas = [];
							for (var i = 0; i < rs.list.length; i++) {
								//包装行数据
								var rowData = new RowData(rs.list[i].id, rs.list[i].subject, 
										rs.list[i].totalTime, rs.list[i].totalScore, rs.list[i].createDate);
								// 将行数据放到数组里
								rowsDatas.push(rowData);
							}
							tableData.data = rowsDatas;
							tableData.recordsTotal = rs.total;
							tableData.recordsFiltered = rs.total;
							console.log(tableData);
							callback(tableData);
						},
						error : function (data) {
							layer.alert(data.responseText, {icon: 0});
						}
					});
				},
				"columns": [ //定义行数据字段
					{data: 'id', name: "id", sortable: true}, 
					{data: 'subject', name: "subject", sortable: true}, 
					{data: 'totalTime', name: "total_time", sortable: true}, 
					{data: 'totalScore', name: "total_score", sortable: true}, 
					{data: 'createDate', name: "create_date", sortable: true}, 
					{data: 'operate', width: '80px', sortable: false}
				]
			});
		}
		
		//行数据结构
		function RowData(id, subject, totalTime, totalScore, createDate) {
			this.id = id;
			this.subject = subject;
			this.totalTime = totalTime;
			this.totalScore = totalScore;
			this.createDate = createDate;
			this.operate = function () {
				var temp = "<a href='/exam/paper/" + id + "' class='btn_editcolor'>考试</a>&nbsp;&nbsp;";
				var userName = $("#userName").val();
				if (userName == "admin") {
					temp += "<a href='javascript:void(0);' onclick='deleteModule(\"" + 
						id + "\")' class='btn_editcolor'>删除</a>";
				}
				return temp;
			}
		}
		
		// 添加试卷
		function addPaper() {
			if ($("[name=type]").val().length == 0) {
				layer.msg("请选择试题类型", {icon: 0});
				return;
			}
			if ($("[name=title]").val() == "") {
				layer.msg("请选择试题标题", {icon: 0});
				return;
			}
			
			var paperBuilder = {};
			paperBuilder.paperTitle = $("[name=titlePrefix]").html() + 
				$("[name=title]").val() + $("[name=titleSuffix]").html();
			paperBuilder.paperFlage = $("[name=flag]").val();
			paperBuilder.paperTime = $("[name=paperTime]").val();
			paperBuilder.paperTypes = $("[name=type]").val();
			
			$("body").mLoading("show");
			$.ajax({
				url : "/api/paper",
				type : "post",
				contentType: "application/json",
				data : JSON.stringify(paperBuilder),
				success : function (data) {
					$("body").mLoading("hide");
					if (data.status == 200) {
						initTable(PAGE_SIZE);
					} else {
						layer.msg(data.message, {icon: 0});
					}
				},
				error : function (data) {
					$("body").mLoading("hide");
					layer.msg(data.responseText, {icon: 0});
				}
			});
		}
		
		// 删除模型
		function deleteModule(id) {
			bootbox.confirm("Are you sure?", function(result) {
				if(result) {
					$.ajax({
						url : "/api/paper/" + id,
						type : "delete",
						success : function (data) {
							if (data.status == 200) {
								initTable(PAGE_SIZE);
							} else {
								//window.location.href = data.object;
								layer.msg(data.message, {icon: 0});
							}
						},
						error : function (data) {
							layer.msg(data.responseText, {icon: 0});
						}
					});
				}
			});
		}
	</script>
</body>
</html>
