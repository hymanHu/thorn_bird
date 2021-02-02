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
						<li class="active">Account</li>
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
						<h1> Account <small>
							<i class="ace-icon fa fa-angle-double-right"></i> resources </small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<div class="clearfix">
								<div class="pull-left tableTools-container">
									<button type="button" class="btn btn-primary" id="addModuleBtn"
										data-toggle="modal" data-target="#addModal">新    增</button>
								</div>
								<!-- <div class="pull-right tableTools-container">
									<button type="button" class="btn btn-primary" id="exportToExcelBtn">导出 Excel</button>
								</div> -->
							</div>
							<div>
								<table id="moduleTable" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>Resource Id</th>
											<th>permission</th>
											<th>Create Date</th>
											<th>Operation</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- footer -->
		<%@ include file="../fragments/footer.jsp"%>
		
		<!-- 新增、修改页面 -->
		<%@ include file="./resourceAdd.jsp"%>
		<%@ include file="./resourceEdit.jsp"%>
	</div>

	<!-- js -->
	<script src="/static/js/jquery-2.1.4.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<!-- data table -->
	<script src="/static/js/jquery.dataTables.min.js"></script>
	<script src="/static/js/jquery.dataTables.bootstrap.min.js"></script>
	<!-- layer -->
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js"></script>
	<!-- confirm box -->
	<script src="/static/js/bootbox.js"></script>
	<!-- ace -->
	<script src="/static/js/ace-elements.min.js"></script>
	<script src="/static/js/ace.min.js"></script>
	<script src="/static/js/ace-extra.min.js"></script>
	<!-- custom -->
	<script src="/static/js/custom.js"></script>
	
	<script type="text/javascript">
		$(function() {
			initTable(DEFAULT_PAGE_SIZE);
			
			$("#addModuleBtn").bind("click", function() {
				initAddModal();
			});
			$("#addBtn").bind("click", function() {
				insertModule();
			});
			$("#editBtn").bind("click", function() {
				updateModule();
			});
		});
		
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
						url : "/api/resources",
						type : "post",
						contentType: "application/json",
						data : JSON.stringify(searchBean),
						success : function (rs) {
							// 定义表格数据结构
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
							var rowsData = [];
							for (var i = 0; i < rs.list.length; i++) {
								//包装行数据
								var rowData = new RowData(rs.list[i].id, rs.list[i].permission, rs.list[i].createDate);
								// 将行数据放到数组里
								rowsData.push(rowData);
							}
							tableData.data = rowsData;
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
					{data: 'permission', name: "permission", sortable: true}, 
					{data: 'createDate', name: "create_date", sortable: true}, 
					{data: 'operate', width: '80px', sortable: false}
				]
			});
		}
		
		//行数据结构
		function RowData(id, permission, createDate) {
			this.id = id;
			this.permission = permission;
			this.createDate = createDate;
			this.operate = function () {
				return "<a href='#' class='btn_editcolor' data-toggle='modal' data-target='#editModal' " + 
					"onclick='initEditModal(\"" + id + "\")'>编辑</a>&nbsp;" + 
					"<a href='javascript:void(0);' onclick='deleteModule(\"" + id + 
					"\")' class='btn_editcolor'>删除</a>";
			}
		}
		
		// 初始化添加页面
		function initAddModal() {
			$("#permissionForAddPage").val("");
			initRoles("rolesForAddPage", "roleForAddPage");
		}
		
		// 添加模型
		function insertModule() {
			var resource = {};
			resource.permission = $("#permissionForAddPage").val();
			var roles = [];
			$.each($("input[name=roleForAddPage]"), function(i, item) {
				if(this.checked){
					var role = {};
					role.id = $(this).val();
					roles.push(role);
				}
			});
			resource.roles = roles;
			
			$.ajax({
				url : "/api/resource",
				type : "post",
				contentType: "application/json",
				data : JSON.stringify(resource),
				success : function (data) {
					if (data.status == 200) {
						initTable(DEFAULT_PAGE_SIZE);
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
			initRoles("rolesForEditPage", "roleForEditPage");
			
			$.ajax({
				url : "/api/resource/" + id,
				type : "get",
				contentType: "application/json",
				success : function (rs) {
					$("#idForEditPage").val(rs.id);
					$("#permissionForEditPage").val(rs.permission);
					$.each(rs.roles, function(i, item){
						$("input[name='roleForEditPage'][value=" + item.id + "]")
							.attr("checked","checked");
					});
				},
				error : function (data) {
					layer.alert(data.responseText, {icon: 0});
				}
			});
		}
		
		// 修改模型
		function updateModule() {
			var resource = {};
			resource.id = $("#idForEditPage").val();
			resource.permission = $("#permissionForEditPage").val();
			var roles = [];
			$.each($("input[name=roleForEditPage]"), function(i, item) {
				if(this.checked){
					var role = {};
					role.id = $(this).val();
					roles.push(role);
				}
			});
			resource.roles = roles;
			
			$.ajax({
				url : "/api/resource",
				type : "put",
				contentType: "application/json",
				data : JSON.stringify(resource),
				success : function (data) {
					if (data.status == 200) {
						initTable(DEFAULT_PAGE_SIZE);
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
						url : "/api/resource/" + id,
						type : "delete",
						contentType: "application/json",
						success : function (data) {
							if (data.status == 200) {
								initTable(DEFAULT_PAGE_SIZE);
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
