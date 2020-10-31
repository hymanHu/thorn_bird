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
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" rel="stylesheet" >
	<!-- Font Awesome -->
	<link href="/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" >
	<!-- Exam -->
	<link href="/static/css/exam/main.css" rel="stylesheet" >
	<link href="/static/css/exam/test.css" rel="stylesheet" >
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
	<input type="hidden" id="paperId" value="${paperId }"/>
	<div class="wrapper">
		<!-- 导航条 -->
		<%@ include file="../fragment/examNavigation.jsp"%>
		
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 name="subject" class="m-0 text-dark">
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
									<div name="questions" class="test">
										<div class="test_title">
											<p name="totalTime" class="test_time">
											</p>
											<font><input type="button" name="test_jiaojuan" value="交卷"></font>
										</div>
									</div>
					
								</div>
								<div class="nr_right">
									<div class="nr_rt_main">
										<div class="rt_nr1">
											<div class="rt_nr1_title">
												<h1>
													答题卡
												</h1>
												<p name="totalTime" class="test_time">
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
			initPaper();
			
			$('li.option').bind("click", function(){
				var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id');
				var cardLi = $("a[href='#" + examId + "']");
				if(!cardLi.hasClass('hasBeenAnswer')){
					cardLi.addClass('hasBeenAnswer');
				}
			});
		})
		
		function initPaper() {
			var paperId = $("#paperId").val();
			$.ajax({
				url : "/api/paper?paperId=" + paperId,
				type : "get",
				success : function (data) {
					$("[name='subject']").html(data.subject);
					$("[name='totalTime']").html("<b class='alt-1'>00:" + data.totalTime + ":00</b>");
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
					var singleChoice = [], singleChoiceScore = 0, 
						multipleChoice = [], multipleChoiceScore = 0, 
						fillBlank = [], fillBlankScore = 0, 
						shortAnswer = [], shortAnswerScore = 0, 
						programming = [], programmingScore = 0;
					$.each(data.questions, function(i, item) {
						if (item.type == 'singleChoice') {
							singleChoice.push(item);
							singleChoiceScore += item.score;
						} else if (item.type == 'multipleChoice') {
							multipleChoice.push(item);
							multipleChoiceScore += item.score;
						} else if (item.type == 'fillBlank') {
							fillBlank.push(item);
							fillBlankScore += item.score;
						} else if (item.type == 'shortAnswer') {
							shortAnswer.push(item);
							shortAnswerScore += item.score;
						} else if (item.type == 'programming') {
							programming.push(item);
							programmingScore += item.score;
						}
					});
					if (singleChoice.length > 0) {
						$("[name='questions']").append(buildQuestionsString("单选题", singleChoice, singleChoiceScore));
					}
					if (multipleChoice.length > 0) {
						$("[name='questions']").append(buildQuestionsString("多选题", multipleChoice, multipleChoiceScore));
					}
				},
				error : function (data) {
					layer.msg(data.responseText, {icon: 0});
				}
			});
		}
		
		function buildQuestionsString(questionType, questions, score) {
			var temp = "";
			temp += "<div class='test_content'>";
			temp += "<div class='test_content_title'>";
			temp += "<h2>" + questionType + "</h2>";
			temp += "<p>";
			temp += "<span>共</span><i class='content_lit'> " + questions.length + " </i><span>题，</span>";
			temp += "<span>合计</span><i class='content_fs'> " + score + " </i><span>分</span>";
			temp += "</p>";
			temp += "</div>";
			temp += "</div>";
			temp += "<div class='test_content_nr'>";
			temp += "<ul>";
			$.each(questions, function(i, item) {
				temp += "<li id='" + questionType + "_" + i + "'>";
				temp += "<div class='test_content_nr_tt'>";
				temp += "<i>" + (i + 1) + "</i><span>(" + item.score + "分)</span><font>" + item.content + "</font>";
				temp += "</div>";
				temp += "<div class='test_content_nr_main'>";
				temp += "<ul>";
				temp += "<li class='option'>";
				temp += "<input type='radio' class='radioOrCheck' name='answer" + i + "' id='" + questionType + "_answer_" + i + "_option_1' />";
				temp += "<label for='" + questionType + "_answer_" + i + "_option_1'> A. ";
				temp += "<p class='ue' style='display: inline;'>" + item.optionA + "</p>";
				temp += "</label>";
				temp += "</li>";
				temp += "<li class='option'>";
				temp += "<input type='radio' class='radioOrCheck' name='answer" + i + "' id='" + questionType + "_answer_" + i + "_option_2' />";
				temp += "<label for='" + questionType + "_answer_" + i + "_option_2'> B. ";
				temp += "<p class='ue' style='display: inline;'>" + item.optionB + "</p>";
				temp += "</label>";
				temp += "</li>";
				temp += "<li class='option'>";
				temp += "<input type='radio' class='radioOrCheck' name='answer" + i + "' id='" + questionType + "_answer_" + i + "_option_3' />";
				temp += "<label for='" + questionType + "_answer_" + i + "_option_3'> C. ";
				temp += "<p class='ue' style='display: inline;'>" + item.optionC + "</p>";
				temp += "</label>";
				temp += "</li>";
				temp += "<li class='option'>";
				temp += "<input type='radio' class='radioOrCheck' name='answer" + i + "' id='" + questionType + "_answer_" + i + "_option_4' />";
				temp += "<label for='" + questionType + "_answer_" + i + "_option_4'> D. ";
				temp += "<p class='ue' style='display: inline;'>" + item.optionD + "</p>";
				temp += "</label>";
				temp += "</li>";
				temp += "</ul>";
				temp += "</div>";
				temp += "</li>";
			});
			temp += "</ul>";
			temp += "</div>";
			
			return temp;
		}
	</script>
</body>
</html>
