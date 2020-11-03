<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Online Paper</title>
	
	<!-- css -->
	<!-- Exam -->
	<link href="/static/css/exam/main.css" rel="stylesheet" />
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" rel="stylesheet" />
	<!-- Font Awesome -->
	<link href="/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" />
	<!-- Select2 -->
	<link href="/static/plugins/select2/css/select2.min.css" rel="stylesheet">
	<link href="/static/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css" rel="stylesheet" />
	<!-- DataTables -->
	<link href="/static/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css" rel="stylesheet" />
	<link href="/static/plugins/datatables-responsive/css/responsive.bootstrap4.min.css" rel="stylesheet" />
	<!-- admin -->
	<link href="/static/css/exam/adminlte.css" type="text/css" rel="stylesheet" />
	
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
							<h1 name="subject" class="m-0 text-dark">Papers List</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Papers</li>
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
							<h3 class="card-title">试卷生成器（随机生成对应阶段的试卷，100 分制）</h3>
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
										<select class="form-control select2" style="width: 100%;">
											<option selected="selected">Java_SE</option>
											<option>Java_EE</option>
											<option>Java_Framework</option>
											<option>Python_Base</option>
											<option>Python_Spider</option>
											<option>DB_Sql</option>
											<option>DB_NoSql</option>
											<option>Front_Html</option>
											<option>Front_Css</option>
											<option>Front_Js</option>
										</select>
									</div>
									<div class="form-group">
										<label>试卷标题</label>
										<input type="text" class="form-control">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>试题类型</label>
										<div class="select2-purple">
											<select class="select2bs4" multiple="multiple"
												data-placeholder="选择题型" style="width: 100%;">
												<option>单选题</option>
												<option>多选题</option>
												<option>判断题</option>
												<option>填空题</option>
												<option>简答题</option>
												<option>编程题</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>测试时间</label>
										<select class="form-control select2" style="width: 100%;">
											<option selected="selected">45 分钟</option>
											<option>60 分钟</option>
											<option>90 分钟</option>
											<option>120 分钟</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<!-- /.card-body -->
						<div class="card-footer">
							<button type="submit" class="btn btn-primary btn-lg">创建</button>
						</div>
					</div>
					
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">试卷列表</h3>
						</div>
						<div class="card-body">
							<table id="datatable" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>试卷 ID</th>
										<th>试卷标题</th>
										<th>考试时间</th>
										<th>创建日期</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
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
	<script src="/static/plugins/datatables/jquery.dataTables.min.js"  type="text/javascript"></script>
	<script src="/static/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"  type="text/javascript"></script>
	<script src="/static/plugins/datatables-responsive/js/dataTables.responsive.min.js"  type="text/javascript"></script>
	<script src="/static/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"  type="text/javascript"></script>
	<!-- admin -->
	<!-- <script src="/static/js/adminlte.js"></script> -->
	
	<script type="text/javascript">
		PAGE_SIZE = 5;
		$(document).ready(function() {
		    //Initialize Select2 Elements
			$('.select2').select2();
		    $('.select2bs4').select2({
				theme: 'bootstrap4'
		    });
		    
		    initTable(PAGE_SIZE);
		})
		
		function initTable(pageSize) {
			$('#datatable').DataTable({
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
					var sort = data.order[0].dir;
					var orderBy = data.columns[columIndex].name;
					pageSize = data.length == undefined  ? pageSize : data.length;
					
					var searchVo = {};
					searchVo.currentPage = (data.start / pageSize) + 1;
					searchVo.pageSize = pageSize;
					searchVo.orderBy = orderBy;
					searchVo.sort = sort;
					searchVo.keyWord = data.search.value;
		
					$.ajax({
						url : "/api/papers",
						type : "post",
						contentType: "application/json",
						data : JSON.stringify(searchVo),
						success : function (rs) {
							var fData = {
								draw :0,
								recordsTotal: 0,
								recordsFiltered: 0,
								data: []
							};
							if (!rs) {
								layer.alert("请求出错，请稍后重试" + rs.errmsg, {icon: 2});
								callback(fData);
								return;
							};
							if (rs.list == null) {
								$('#datatable tbody tr').remove();
								$('#loading').remove();
								callback(fData);
								return;
							}
							$('#loading').remove();
							var gearDatas = [];
							for (var i = 0; i < rs.list.length; i++) {
								//包装行数据
								var rowData = new TData(rs.list[i].id, rs.list[i].subject, 
										rs.list[i].totalTime, rs.list[i].createDate);
								// 将行数据放到数组里
								gearDatas.push(rowData);
							}
							fData.data = gearDatas;
							fData.recordsTotal = rs.total;
							fData.recordsFiltered = rs.total;
							callback(fData);
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
					{data: 'createDate', name: "create_date", sortable: true}, 
					{data: 'operate', width: '80px', sortable: false}
				]
			});
		}
		
		//行数据结构
		function TData(id, subject, totalTime, createDate) {
			this.id = id;
			this.subject = subject;
			this.totalTime = totalTime;
			this.createDate = createDate;
			this.operate = function () {
				return "<a href='/paper?paperId=" + id + "' class='btn_editcolor'>考试</a>&nbsp;";
			}
		}
	</script>
</body>
</html>
