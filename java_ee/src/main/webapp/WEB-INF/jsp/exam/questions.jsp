<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Users</title>
	
	<!-- css -->
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" rel="stylesheet" />
	<!-- Font Awesome -->
	<link href="/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" />
	<!-- DataTables -->
	<link href="/static/plugins/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet" />
	<link href="/static/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css" rel="stylesheet" />
	<!-- admin -->
	<link href="/static/css/adminlte.css" type="text/css" rel="stylesheet" />
	<!-- custom -->
	<link href="/static/css/custom.css" type="text/css" rel="stylesheet" />
	
</head>
<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
	<div class="wrapper">
		<!-- 导航条 -->
		<%@ include file="../fragment/header.jsp"%>
		<!-- 左侧栏 -->
		<%@ include file="../fragment/sidebar.jsp"%>
		
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">Questions</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="/dashboard">Home</a></li>
								<li class="breadcrumb-item active">Questions</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->
			
			<div class="content">
				<div class="container">
					<div class="card">
						<div class="card-header">
							<ul class="nav panel_toolbox" style="margin-left:0; float: left;">
								<li>
									<button type="button" class="btn btn-primary" id="addModuleBtn"
										data-toggle="modal" data-target="#addModal">新    增</button>
								</li>
							</ul>
							<div class="clearfix"></div>
						</div>
						<div class="card-body">
							<table id="moduleTable" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>ID</th>
										<th>试题类型</th>
										<th>试题阶段</th>
										<th>试题内容</th>
										<th>试题分值</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody></tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 尾部 -->
		<%@ include file="../fragment/footer.jsp"%>
		
		<!-- 新增、修改页面 -->
		<%@ include file="./questionAdd.jsp"%>
		<%@ include file="./questionEdit.jsp"%>
	</div>
	
	<!-- js -->
	<!-- jQuery -->
	<script src="/static/plugins/jquery/jquery.min.js"  type="text/javascript"></script>
	<!-- bootstrap -->
	<script src="/static/plugins/bootstrap/js/bootstrap.bundle.min.js"  type="text/javascript"></script>
	<!-- DataTables -->
	<script src="/static/plugins/datatables.net/js/jquery.dataTables.min.js"  type="text/javascript"></script>
	<script src="/static/plugins/datatables.net-bs/js/dataTables.bootstrap.min.js"  type="text/javascript"></script>
	<!-- layer -->
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js" type="text/javascript"></script>
	<!-- confirm-->
	<script src="/static/js/bootbox.js" type="text/javascript"></script>
	<!-- admin -->
	<script src="/static/js/adminlte.js" type="text/javascript"></script>
	<!-- custom -->
	<script src="/static/js/custom.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		PAGE_SIZE = 5;
		$(document).ready(function() {
			initTable(PAGE_SIZE);
			
			// 绑定页面按钮
			$("#addModuleBtn").bind("click", function() {
				initAddModal();
			});
			$("#addBtn").bind("click", function() {
				insertModule();
			});
			$("#editBtn").bind("click", function() {
				updateModule();
			});
		})
		
		function initTable(pageSize) {
			$('#moduleTable').DataTable({
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
						url : "/api/questions",
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
								$('#moduleTable tbody tr').remove();
								$('#loading').remove();
								callback(tableData);
								return;
							}
							$('#loading').remove();
							var rowsDatas = [];
							for (var i = 0; i < rs.list.length; i++) {
								//包装行数据
								var rowData = new RowData(rs.list[i].id, rs.list[i].type, 
										rs.list[i].flag, rs.list[i].score, 
										rs.list[i].content, rs.list[i].optionA, 
										rs.list[i].optionB, rs.list[i].optionC, 
										rs.list[i].optionD, rs.list[i].referenceAnswer, 
										rs.list[i].comment);
								// 将行数据放到数组里
								rowsDatas.push(rowData);
							}
							tableData.data = rowsDatas;
							tableData.recordsTotal = rs.total;
							tableData.recordsFiltered = rs.total;
							callback(tableData);
						},
						error : function (data) {
							layer.alert(data.responseText, {icon: 0});
						}
					});
				},
				"columns": [ //定义行数据字段
					{data: 'id', name: "id", sortable: true}, 
					{data: 'type', name: "type", sortable: true}, 
					{data: 'flag', name: "flag", sortable: true}, 
					{data: 'content', name: "content", sortable: true}, 
					{data: 'score', name: "score", sortable: true}, 
					{data: 'operate', width: '80px', sortable: false}
				]
			});
		}
		
		//行数据结构
		function RowData(id, type, flag, score, content, optionA, 
				optionB, optionC, optionD, referenceAnswer, comment) {
			this.id = id;
			this.type = type;
			this.flag = flag;
			this.score = score;
			this.content = content;
			this.optionA = optionA;
			this.optionB = optionB;
			this.optionC = optionC;
			this.optionD = optionD;
			this.referenceAnswer = referenceAnswer;
			this.comment = comment;
			this.operate = function () {
				return "<a href='#' class='btn_editcolor' data-toggle='modal' data-target='#editModal' " + 
					"onclick='initEditModal(\"" + id + "\")'>编辑</a>&nbsp;" + 
					"<a href='javascript:void(0);' onclick='deleteModule(\"" + id + "\")' class='btn_editcolor'>删除</a>";
			}
		}
		
		// 初始化添加页面
		function initAddModal() {
			$("#userNameForAddPage").val("");
			$("#passwordForAddPage").val("");
		}
		
		// 添加模型
		function insertModule() {
			var user = {};
			user.userName = $("#userNameForAddPage").val();
			user.password = $("#passwordForAddPage").val();
			
			$.ajax({
				url : "/register",
				type : "post",
				contentType: "application/json",
				data : JSON.stringify(user),
				success : function (data) {
					if (data.status == 200) {
						initTable(PAGE_SIZE);
					} else {
						layer.msg(data.message, {icon: 0});
					}
				},
				error : function (data) {
					layer.msg(data.responseText, {icon: 0});
				}
			});
		}
		
		// 初始化编辑页面
		function initEditModal(id) {
			$.ajax({
				url : "/api/user?userId=" + id,
				type : "get",
				contentType: "application/json",
				success : function (rs) {
					$("#userIdForEditPage").val(rs.data.userId);
					$("#userNameForEditPage").val(rs.data.userName);
					$("#passwordForEditPage").val(rs.data.password);
				},
				error : function (data) {
					layer.alert(data.responseText, {icon: 0});
				}
			});
		}
		
		// 修改模型
		function updateModule() {
			var user = {};
			user.userId = $("#userIdForEditPage").val();
			user.userName = $("#userNameForEditPage").val();
			user.password = $("#passwordForEditPage").val();
			
			$.ajax({
				url : "/api/user",
				type : "put",
				contentType: "application/json",
				data : JSON.stringify(user),
				success : function (data) {
					if (data.status == 200) {
						initTable(PAGE_SIZE);
					} else {
						layer.msg(data.message, {icon: 0});
					}
				},
				error : function (data) {
					layer.msg(data.responseText, {icon: 0});
				}
			});
		}
		
		// 删除模型
		function deleteModule(id) {
			bootbox.confirm("Are you sure?", function(result) {
				if(result) {
					$.ajax({
						url : "/api/user?userId=" + id,
						type : "delete",
						contentType: "application/json",
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
