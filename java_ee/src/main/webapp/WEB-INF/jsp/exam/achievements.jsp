<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>成绩列表</title>
	
	<!-- css -->
	<!-- Exam -->
	<link href="/static/_exam/css/main.css" rel="stylesheet" />
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" 
		rel="stylesheet" />
	<!-- Font Awesome -->
	<link href="/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" />
	<!-- DataTables -->
	<link href="/static/plugins/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet" />
	<link href="/static/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css" rel="stylesheet" />
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
							<h1 name="subject" class="m-0 text-dark">成绩列表</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">主页</a></li>
								<li class="breadcrumb-item active">成绩列表</li>
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
					<div class="card">
						<div class="card-body">
							<table id="papersTable" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>测试 ID</th>
										<th>试卷标题</th>
										<th>测试用户</th>
										<th>参考分数</th>
										<th>分数</th>
										<th>用时(分钟)</th>
										<th>测试时间</th>
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
	<script src="/static/plugins/jquery/jquery.min.js" type="text/javascript"></script>
	<!-- bootstrap -->
	<script src="/static/plugins/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>
	<!-- DataTables -->
	<script src="/static/plugins/datatables.net/js/jquery.dataTables.min.js" type="text/javascript"></script>
	<script src="/static/plugins/datatables.net-bs/js/dataTables.bootstrap.min.js" type="text/javascript"/>
	<!-- loading -->
	<script src="/static/plugins/jquery.mloading/src/jquery.mloading.js" type="text/javascript"></script>
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
		    // 初始化试卷列表
		    initTable(PAGE_SIZE);
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
						url : "/api/achievements",
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
								var rowData = new RowData(rs.list[i].id, rs.list[i].userId, rs.list[i].subject, 
										rs.list[i].totalScore, rs.list[i].referenceScore, rs.list[i].score, 
										rs.list[i].totalTime, rs.list[i].spendTime, rs.list[i].examDate, 
										rs.list[i].userName);
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
					{data: 'id', name: "a.id", sortable: true}, 
					{data: 'subject', name: "a.subject", sortable: true}, 
					{data: 'userName', name: "u.user_name", sortable: true}, 
					{data: 'referenceScore', name: "a.reference_score", sortable: true}, 
					{data: 'score', name: "a.score", sortable: true}, 
					{data: 'spendTime', name: "a.spend_time", sortable: true}, 
					{data: 'examDate', name: "a.exam_date", sortable: true}, 
					{data: 'operate', width: '80px', sortable: false}
				]
			});
		}
		
		//行数据结构
		function RowData(id, userId, subject, totalScore, referenceScore, 
				score, totalTime, spendTime, examDate, userName) {
			this.id = id;
			this.userId = userId;
			this.subject = subject;
			this.totalScore = totalScore;
			this.referenceScore = referenceScore;
			if (score == 0) {
				this.score = "总分待批改";
			} else {
				this.score = score;
			}
			this.totalTime = totalTime;
			this.spendTime = spendTime;
			this.examDate = examDate;
			this.userName = userName;
			this.operate = function () {
				var temp = "";
				var userName = $("#userName").val();
				if (userName == "admin") {
					if (score == 0) {
						temp += "<a href='/exam/achievement/" + id + "' class='btn_editcolor'>批改</a>&nbsp;&nbsp;";
					}
					temp += "<a href='javascript:void(0);' onclick='deleteModule(\"" + id + 
							"\")' class='btn_editcolor'>删除</a>&nbsp;&nbsp;"
				} else {
					temp = "<a href='/exam/achievement/" + id + "' class='btn_editcolor'>查看</a>";
				}
				return temp;
			}
		}
		
		// 删除模型
		function deleteModule(id) {
			bootbox.confirm("Are you sure?", function(result) {
				if(result) {
					$.ajax({
						url : "/api/achievement/" + id,
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
