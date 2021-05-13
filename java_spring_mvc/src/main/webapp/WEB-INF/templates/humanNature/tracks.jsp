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
	<!-- datetimepicker -->
	<link href="/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
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
								<input type="text" placeholder="Search ..." class="nav-search-input"
									id="nav-search-input" autocomplete="off" />
								<i class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1> Human Nature <small>
							<i class="ace-icon fa fa-angle-double-right"></i> Tracks </small>
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
											<th>Track Id</th>
											<th>Target</th>
											<th>Type</th>
											<th>Description</th>
											<th>Assessment</th>
											<th>Date Time</th>
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
		<%@ include file="./trackAdd.jsp"%>
		<%@ include file="./trackEdit.jsp"%>
	</div>

	<!-- js -->
	<script src="/static/js/jquery-2.1.4.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<!-- data table -->
	<script src="/static/js/jquery.dataTables.min.js"></script>
	<script src="/static/js/jquery.dataTables.bootstrap.min.js"></script>
	<!-- datetimepicker -->
	<script src="/static/js/moment.min.js"></script>
	<script src="/static/js/bootstrap-datetimepicker.min.js"></script>
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
		var DEFAULT_PAGE_SIZE = 5;
		$(function() {
			initTable(DEFAULT_PAGE_SIZE);
			initTrackType();
			
			$('[name=dateTime]').datetimepicker({
				format: 'YYYY-MM-DD HH:mm:ss',
				icons: {
					time: 'fa fa-clock-o',
					date: 'fa fa-calendar',
					up: 'fa fa-chevron-up',
					down: 'fa fa-chevron-down',
					previous: 'fa fa-chevron-left',
					next: 'fa fa-chevron-right',
					today: 'fa fa-arrows ',
					clear: 'fa fa-trash',
					close: 'fa fa-times'
				}
			}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			
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
						url : "/api/tracks",
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
								var rowData = new RowData(rs.list[i].id, rs.list[i].target, rs.list[i].type,  
										rs.list[i].description, rs.list[i].assessment, rs.list[i].dateTime);
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
					{data: 'target', name: "target", sortable: true}, 
					{data: 'type', name: "type", sortable: true}, 
					{data: 'description', name: "description", sortable: true}, 
					{data: 'assessment', name: "assessment", sortable: true}, 
					{data: 'dateTime', name: "date_time", sortable: true}, 
					{data: 'operate', width: '80px', sortable: false}
				]
			});
		}
		
		//行数据结构
		function RowData(id, target, type, description, assessment, dateTime) {
			this.id = id;
			this.target = target;
			this.type = type;
			this.description = description;
			this.assessment = assessment;
			this.dateTime = dateTime;
			this.operate = function () {
				return "<a href='#' class='btn_editcolor' data-toggle='modal' data-target='#editModal' " + 
					"onclick='initEditModal(\"" + id + "\")'>编辑</a>&nbsp;" + 
					"<a href='javascript:void(0);' onclick='deleteModule(\"" + id + 
					"\")' class='btn_editcolor'>删除</a>";
			}
		}
		
		function initTrackType() {
			$.ajax({
				url : "/api/dict/trackTypes",
				type : "get",
				//contentType: "application/json",
				//data : JSON.stringify(track),
				success : function (data) {
					var trackType = $("[name=type]");
					$.each(data, function(i, item) {
						trackType.append("<option id='" + item.id + "'>" + item.name + "</option>");
					});
				},
				error : function (data) {
					layer.msg(data.responseText, {icon: 0});
				}
			});
		}
		
		// 初始化添加页面
		function initAddModal() {
			$("#targetForAddPage").val("");
			$("#typeForAddPage option:first").prop("selected", 'selected');
			$("#descriptionForAddPage").val("");
			$("#assessmentForAddPage").val("");
			$("#dateTimeForAddPage").val("");
		}
		
		// 添加模型
		function insertModule() {
			var track = {};
			track.target = $("#targetForAddPage").val();
			track.type = $("#typeForAddPage").val();
			track.description = $("#descriptionForAddPage").val();
			track.assessment = $("#assessmentForAddPage").val();
			track.dateTime = $("#dateTimeForAddPage").val();
			
			$.ajax({
				url : "/api/track",
				type : "post",
				contentType: "application/json",
				data : JSON.stringify(track),
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
			$.ajax({
				url : "/api/track/" + id,
				type : "get",
				contentType: "application/json",
				success : function (rs) {
					$("#idForEditPage").val(rs.id);
					$("#targetForEditPage").val(rs.target);
					$("#typeForEditPage").val(rs.type);
					$("#descriptionForEditPage").val(rs.description);
					$("#assessmentForEditPage").val(rs.assessment);
					$("#dateTimeForEditPage").val(rs.dateTime);
				},
				error : function (data) {
					layer.alert(data.responseText, {icon: 0});
				}
			});
		}
		
		// 修改模型
		function updateModule() {
			var track = {};
			track.id = $("#idForEditPage").val();
			track.target = $("#targetForEditPage").val();
			track.type = $("#typeForEditPage").val();
			track.description = $("#descriptionForEditPage").val();
			track.assessment = $("#assessmentForEditPage").val();
			track.dateTime = $("#dateTimeForEditPage").val();
			
			$.ajax({
				url : "/api/track",
				type : "put",
				contentType: "application/json",
				data : JSON.stringify(track),
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
						url : "/api/track/" + id,
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
