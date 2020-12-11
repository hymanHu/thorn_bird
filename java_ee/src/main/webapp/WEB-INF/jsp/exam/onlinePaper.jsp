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
	<link href="/static/css/exam/test.css" rel="stylesheet" />
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" rel="stylesheet" />
	<!-- Font Awesome -->
	<link href="/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" />
	<!-- admin -->
	<link href="/static/css/exam/adminlte.css" type="text/css" rel="stylesheet" />
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
								<li class="breadcrumb-item active">Paper</li>
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
										<div name="answerSheet" class="rt_nr1">
											<div class="rt_nr1_title">
												<h1>
													答题卡
												</h1>
												<p name="totalTime" class="test_time"></p>
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
	<!-- bootstrap -->
	<script src="/static/plugins/bootstrap/js/bootstrap.bundle.min.js"  type="text/javascript"></script>
	<!-- countdown -->
	<script src="/static/js/exam/jquery.countdown.js"  type="text/javascript"></script>
	<!-- admin -->
	<script src="/static/js/adminlte.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			initPaper();
			
			// 监测滚动条事件，设置答题卡样式
			$(window).scroll(function () {
				var top = $(this).scrollTop();
				console.log(top);
				if (top > 120) {
					$('.rt_nr1').addClass("fix_position");
				} else {
					$('.rt_nr1').removeClass("fix_position");
				}
			});
		})
		
		// 初始化试题和答题卡
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
						$("[name='questions']").append(buildChoiceString("单选题", singleChoice, singleChoiceScore));
						$("[name='answerSheet']").append(buildAnswerSheetString("单选题", singleChoice));
					}
					if (multipleChoice.length > 0) {
						$("[name='questions']").append(buildChoiceString("多选题", multipleChoice, multipleChoiceScore));
						$("[name='answerSheet']").append(buildAnswerSheetString("多选题", multipleChoice));
					}
					
					$('li.option').bind("click", function(){
						var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id');
						var cardLi = $("a[href='#" + examId + "']");
						if(!cardLi.hasClass('hasBeenAnswer')){
							cardLi.addClass('hasBeenAnswer');
						}
					});
				},
				error : function (data) {
					layer.msg(data.responseText, {icon: 0});
				}
			});
		}
		
		// 创建选择题字符串
		function buildChoiceString(questionType, questions, score) {
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
				temp += "<li id='" + item.type + "_" + i + "'>";
				temp += "<div class='test_content_nr_tt'>";
				temp += "<i>" + (i + 1) + "</i><span>(" + item.score + "分)</span><font>" + item.content + "</font>";
				temp += "</div>";
				temp += "<div class='test_content_nr_main'>";
				temp += "<ul>";
				temp += buildOption(i, item, "A");
				temp += buildOption(i, item, "B");
				temp += buildOption(i, item, "C");
				temp += buildOption(i, item, "D");
				temp += "</ul>";
				temp += "</div>";
				temp += "</li>";
			});
			temp += "</ul>";
			temp += "</div>";
			
			return temp;
		}
		
		// 创建选项字符串
		function buildOption(i, item, optionName) {
			var optionValue = "";
			if (optionName == "A") {
				optionValue = item.optionA;
			} else if (optionName == "B") {
				optionValue = item.optionB;
			} else if (optionName == "C") {
				optionValue = item.optionC;
			} else if (optionName == "D") {
				optionValue = item.optionD;
			}
			var temp = "";
			temp += "<li class='option'>";
			if (item.type == "singleChoice") {
				temp += "<input type='radio' class='radioOrCheck' name='answer" + i + "' id='" + item.type + "_answer_" + i + "_option_" + optionName + "' />";
			} else if (item.type == "multipleChoice") {
				temp += "<input type='checkbox' class='radioOrCheck' name='answer" + i + "' id='" + item.type + "_answer_" + i + "_option_" + optionName + "' />";
			}
			temp += "<label for='" + item.type + "_answer_" + i + "_option_" + optionName + "'> " + optionName + ". ";
			temp += "<p class='ue' style='display: inline;'>" + optionValue + "</p>";
			temp += "</label>";
			temp += "</li>";
			return temp;
		}
		
		// 创建答题卡字符串
		function buildAnswerSheetString(questionType, questions) {
			var temp = "";
			temp += "<div class='rt_content'>";
			temp += "<div class='rt_content_tt'>";
			temp += "<h2>" + questionType + "</h2>";
			temp += "<p><span>共</span><i class='content_lit'> " + questions.length + " </i><span>题</span></p>";
			temp += "</div>";
			temp += "<div class='rt_content_nr answerSheet'>";
			temp += "<ul>";
			$.each(questions, function(i, item) {
				temp += "<li><a href='#" + item.type + "_" + i + "'>" + (i + 1) + "</a></li>";
			});
			temp += "</ul>";
			temp += "</div>";
			temp += "</div>";
			
			return temp;
		}
	</script>
</body>
</html>
