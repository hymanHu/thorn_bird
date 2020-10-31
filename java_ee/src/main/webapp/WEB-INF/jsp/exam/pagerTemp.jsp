<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Exam Paper</title>
	
	<!-- css -->
	<!-- Exam -->
	<link href="/static/css/exam/main.css" rel="stylesheet" >
	<link href="/static/css/exam/test.css" rel="stylesheet" >
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" rel="stylesheet" >
	<!-- Font Awesome -->
	<link href="/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" >
	<!-- Theme style -->
	<link href="/static/css/exam/adminlte.css" type="text/css" rel="stylesheet">
	<style>
		.hasBeenAnswer {
			background: #5d9cec;
			color: #fff;
		}
	</style>
	
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
							<h1 class="m-0 text-dark">
								Java_SE_20201010
							</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Exam</li>
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
	    	<div class="content">
	    		<div class="container">
	    			<div class="row">
			    		<div class="main">
							<!--nr start-->
							<div class="test_main">
								<div class="nr_left">
									<div class="test">
										<form action="" method="post">
											<div class="test_title">
												<p class="test_time">
													<b class="alt-1">01:40</b>
												</p>
												<font><input type="button" name="test_jiaojuan" value="交卷"></font>
											</div>
					
											<div class="test_content">
												<div class="test_content_title">
													<h2>单选题</h2>
													<p>
														<span>共</span><i class="content_lit">60</i><span>题，</span><span>合计</span>
														<i class="content_fs">60</i><span>分</span>
													</p>
												</div>
											</div>
											<div class="test_content_nr">
												<ul>
													<li id="qu_0_0">
														<div class="test_content_nr_tt">
															<i>1</i><span>(1分)</span><font>在生产管理信息系统中，下列操</font>
														</div>
														<div class="test_content_nr_main">
															<ul>
																<li class="option">
																	<input type="radio" class="radioOrCheck" name="answer1" 
																		id="0_answer_1_option_1" />
																	<label for="0_answer_1_option_1"> A.
																		<p class="ue" style="display: inline;">在工具栏中点击“workflow”标签</p>
																	</label>
																</li>
																<li class="option">
																	<input type="radio" class="radioOrCheck" name="answer1" 
																		id="0_answer_1_option_2" />
																	<label for="0_answer_1_option_2"> B.
																		<p class="ue" style="display: inline;">在缺陷单界面中点击“推进流程”按钮</p>
																	</label>
																</li>
																<li class="option">
																	<input type="radio" class="radioOrCheck" name="answer1" 
																		id="0_answer_1_option_3" />
																	<label for="0_answer_1_option_3"> C.
																		<p class="ue" style="display: inline;">在缺陷单界面中点击“提交”按钮</p>
																	</label>
																</li>
																<li class="option">
																	<input type="radio" class="radioOrCheck" name="answer1" 
																		id="0_answer_1_option_4" />
																	<label for="0_answer_1_option_4"> D.
																		<p class="ue" style="display: inline;">后台启动流程推进</p>
																	</label>
																</li>
															</ul>
														</div>
													</li>
													<li id="qu_0_1">
														<div class="test_content_nr_tt">
															<i>2</i><span>(1分)</span><font>在营销系统中查询客户有无欠费、余额及抄表数据接待客户时应做到哪些最基本的礼仪？</font>
														</div>
														<div class="test_content_nr_main">
															<ul>
																<li class="option">
																	<input type="radio" class="radioOrCheck" name="answer2" 
																		id="0_answer_2_option_1" />
																	<label for="0_answer_2_option_1">A.
																		<p class="ue" style="display: inline;">起身、微笑、示坐、问候客户</p>
																	</label>
																</li>
																<li class="option">
																	<input type="radio" class="radioOrCheck" name="answer2"
																		id="0_answer_2_option_2" />
																	<label for="0_answer_2_option_2">B.
																		<p class="ue" style="display: inline;">坐着，问候客户</p>
																	</label>
																</li>
																<li class="option">
																	<input type="radio" class="radioOrCheck" name="answer2"
																		id="0_answer_2_option_3" />
																	<label for="0_answer_2_option_3">C.
																		<p class="ue" style="display: inline;">坐着，问候客户</p>
																	</label>
																</li>
																<li class="option">
																	<input type="radio" class="radioOrCheck" name="answer2"
																		id="0_answer_2_option_4" />
																	<label for="0_answer_2_option_4">D.
																		<p class="ue" style="display: inline;">请问需要办理什么业务</p>
																	</label>
																</li>
															</ul>
														</div>
													</li>
												</ul>
											</div>
					
											<div class="test_content">
												<div class="test_content_title">
													<h2>多选题</h2>
													<p>
														<span>共</span><i class="content_lit">30</i><span>题，</span><span>合计</span>
														<i class="content_fs">30</i><span>分</span>
													</p>
												</div>
											</div>
											<div class="test_content_nr">
												<ul>
													<li id="qu_1_0">
														<div class="test_content_nr_tt">
															<i>1</i><span>(1分)</span><font>以下属于南方电网员工职业操守中明文规定的有()</font>
														</div>
														<div class="test_content_nr_main">
															<ul>
																<li class="option">
																	<input type="checkbox" class="radioOrCheck" name="answer1" 
																		id="1_answer_1_option_1" />
																	<label for="1_answer_1_option_1"> A.
																		<p class="ue" style="display: inline;">热爱祖国、热爱南网、热爱岗位</p>
																	</label>
																</li>
																<li class="option">
																	<input type="checkbox" class="radioOrCheck" name="answer1" 
																		id="1_answer_1_option_2" />
																	<label for="1_answer_1_option_2"> B.
																		<p class="ue" style="display: inline;">遵纪守法、忠于职守、令行禁止</p>
																	</label>
																</li>
																<li class="option">
																	<input type="checkbox" class="radioOrCheck" name="answer1" 
																		id="1_answer_1_option_3" />
																	<label for="1_answer_1_option_3"> C.
																		<p class="ue" style="display: inline;">客户至上、诚实守信、优质服务</p>
																	</label>
																</li>
					
																<li class="option">
																	<input type="checkbox" class="radioOrCheck" name="answer1" 
																		id="1_answer_1_option_4" />
																	<label for="1_answer_1_option_4"> D.
																		<p class="ue" style="display: inline;">公平竞争、互相监督、服从监管</p>
																	</label>
																</li>
															</ul>
														</div>
													</li>
					
													<li id="qu_1_1">
														<div class="test_content_nr_tt">
															<i>2</i><span>(1分)</span><font>以下属于南方电网员工职业禁区的有()</font>
														</div>
														<div class="test_content_nr_main">
															<ul>
																<li class="option">
																	<input type="checkbox" class="radioOrCheck" name="answer2" 
																		id="1_answer_2_option_1" />
																	<label for="1_answer_2_option_1"> A.
																		<p class="ue" style="display: inline;">严禁违反人文道德</p>
																	</label>
																</li>	
					
																<li class="option">
																	<input type="checkbox" class="radioOrCheck" name="answer2" 
																		id="1_answer_2_option_2" />
																	<label for="1_answer_2_option_2"> B.
																		<p class="ue" style="display: inline;">严禁违反安全规定</p>
																	</label>
																</li>
					
																<li class="option">
																	<input type="checkbox" class="radioOrCheck" name="answer2" 
																		id="1_answer_2_option_3" />
																	<label for="1_answer_2_option_3"> C.
																		<p class="ue" style="display: inline;">严禁违背行风规定</p>
																	</label>
																</li>
					
																<li class="option">
																	<input type="checkbox" class="radioOrCheck" name="answer2" 
																		id="1_answer_2_option_4" />
																	<label for="1_answer_2_option_4"> D.
																		<p class="ue" style="display: inline;">严禁违反财经纪律</p>
																	</label>
																</li>
															</ul>
														</div>
													</li>
												</ul>
											</div>
										</form>
									</div>
					
								</div>
								<div class="nr_right">
									<div class="nr_rt_main">
										<div class="rt_nr1">
											<div class="rt_nr1_title">
												<h1>
													答题卡
												</h1>
												<p class="test_time">
													<b class="alt-1">01:40</b>
												</p>
											</div>
											<div class="rt_content">
												<div class="rt_content_tt">
													<h2>单选题</h2>
													<p>
														<span>共</span><i class="content_lit">60</i><span>题</span>
													</p>
												</div>
												<div class="rt_content_nr answerSheet">
													<ul>
														<li><a href="#qu_0_0">1</a></li>
														<li><a href="#qu_0_1">2</a></li>
													</ul>
												</div>
											</div>
											<div class="rt_content">
												<div class="rt_content_tt">
													<h2>多选题</h2>
													<p>
														<span>共</span><i class="content_lit">30</i><span>题</span>
													</p>
												</div>
												<div class="rt_content_nr answerSheet">
													<ul>
														<li><a href="#qu_1_0">1</a></li>
														<li><a href="#qu_1_1">2</a></li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!--nr end-->
							<div class="foot"></div>
						</div>
						<div style="text-align: center; margin: 10px 0; font: normal 14px/24px 'MicroSoft YaHei';">
						</div>
					</div>
				</div>
	    	</div>
		</div>
	</div>
	
	<!-- js -->
	<!-- jQuery -->
	<script src="/static/plugins/jquery/jquery.min.js"  type="text/javascript"></script>
	<script src="/static/plugins/bootstrap/js/bootstrap.bundle.min.js"  type="text/javascript"></script>
	<script src="/static/js/exam/jquery.countdown.js"  type="text/javascript"></script>
	<script src="/static/js/adminlte.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('li.option').bind("click", function(){
				var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id');
				var cardLi = $("a[href='#" + examId + "']");
				if(!cardLi.hasClass('hasBeenAnswer')){
					cardLi.addClass('hasBeenAnswer');
				}
			});
		})
		window.jQuery(function($) {
			"use strict";
			$('time').countDown({
				with_separators : false
			});
			$('.alt-1').countDown({
				css_class : 'countdown-alt-1'
			});
			$('.alt-2').countDown({
				css_class : 'countdown-alt-2'
			});
		});
	</script>
</body>
</html>
