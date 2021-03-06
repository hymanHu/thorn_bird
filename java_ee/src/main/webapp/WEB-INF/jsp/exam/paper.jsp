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
	<link href="/static/_exam/css/main.css" rel="stylesheet" />
	<link href="/static/_exam/css/test.css" rel="stylesheet" />
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" rel="stylesheet" />
	<!-- Font Awesome -->
	<link href="/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" />
	<!-- loading -->
	<link href="/static/plugins/jquery.mloading/src/jquery.mloading.css" rel="stylesheet" />
	<!-- admin -->
	<link href="/static/_exam/css/adminlte.css" type="text/css" rel="stylesheet" />
	<style>
		.hasBeenAnswer {
			background: #5d9cec;
			color: #fff;
		}
	</style>
	
</head>
<body class="hold-transition layout-top-nav">
	<input type="hidden" id="paperId" value="${paperId }"/>
	<input type="hidden" id="userName" value="${user.userName }"/>
	<div class="wrapper">
		<!-- 导航条 -->
		<%@ include file="../fragment/examNavigation.jsp"%>
		
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 name="subject" totalScore="" subject="" class="m-0 text-dark"></h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">主页</a></li>
								<li class="breadcrumb-item active">试卷</li>
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
											<p name="totalTime" totalTime="" class="test_time"></p>
											<font><input type="button" name="handInBtn" value="交卷"></font>
										</div>
									</div>
								</div>
								<div class="nr_right">
									<div class="nr_rt_main">
										<div name="answerSheet" class="rt_nr1">
											<div class="rt_nr1_title">
												<h1>答题卡</h1>
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
	
	<div class="modal fade" id="achievementResult" tabindex="-1" role="dialog" 
		aria-labelledby="achievementResultLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="achievementResultLabel" style="font-size: 18px; 
						font-weight: 500;">考试结果</h4>
					<!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<label class="control-label col-md-3">试卷名称</label>
						<div class="col-md-8">
							<div id="achievementSubject"></div>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">考试人</label>
						<div class="col-md-8">
							<div id="achievementUserName"></div>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">耗时</label>
						<div class="col-md-8">
							<div id="achievementSpendTime"></div>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">总分</label>
						<div class="col-md-8">
							<div id="achievementTotalScore"></div>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">参考得分</label>
						<div class="col-md-8">
							<div id="achievementReferenceScore"></div>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">最终得分</label>
						<div class="col-md-8">
							<div id="achievementScore"></div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<a href="/exam/achievements" class="btn btn-primary">
						<i class="fa fa-fw fa-lg fa-check-circle"></i>确定
					</a>
				</div>
			</div>
		</div>
	</div>
	
	<!-- js -->
	<!-- jQuery -->
	<script src="/static/plugins/jquery/jquery.min.js"  type="text/javascript"></script>
	<!-- bootstrap -->
	<script src="/static/plugins/bootstrap/js/bootstrap.bundle.min.js"  type="text/javascript"></script>
	<!-- loading -->
	<script src="/static/plugins/jquery.mloading/src/jquery.mloading.js"  type="text/javascript"></script>
	<!-- layer -->
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js" type="text/javascript"></script>
	<!-- countdown -->
	<script src="/static/plugins/jquery.countdown/jquery.countdown.js"  type="text/javascript"></script>
	<!-- admin -->
	<script src="/static/js/adminlte.js"></script>
	<script type="text/javascript">
		var spendTime = 0;
		var totalTime = 0;
		$(document).ready(function() {
			initPaper();
			
			// 监测滚动条事件，设置答题卡样式
			$(window).scroll(function () {
				var top = $(this).scrollTop();
				if (top > 120) {
					$('.rt_nr1').addClass("fix_position");
				} else {
					$('.rt_nr1').removeClass("fix_position");
				}
			});
			
			// 交卷按钮点击事件
			$("[name=handInBtn]").bind("click", function() {
				handInPaper();
			});
		})
		
		// 初始化时间计数插件
		function initCountDown() {
			$('time').countDown({
	            with_separators: false
	        });
	        $('.alt-1').countDown({
	            css_class: 'countdown-alt-1',
	            with_labels: false,
	        });
	        $('.alt-1').on('time.elapsed', function () {
	        	handInPaper();
	        });
	        $('.alt-1').on('time.tick', function (ev, ms) {
	            spendTime = totalTime - Math.floor(ms / (1000 * 60));
	        });
		}
		
		// 初始化试题和答题卡
		function initPaper() {
			var paperId = $("#paperId").val();
			$.ajax({
				url : "/api/paper/" + paperId,
				type : "get",
				success : function (data) {
					$("[name='subject']").html(data.subject + "(" + data.totalScore + "分)");
					$("[name='subject']").attr("totalScore", data.totalScore);
					$("[name='subject']").attr("subject", data.subject);
					$("[name='totalTime']").html("<b class='alt-1'>00:" + data.totalTime + ":00</b>");
					$("[name='totalTime']").attr("totalTime", data.totalTime);
					totalTime = data.totalTime;
					
					// 初始化倒计时时间插件
					initCountDown();
					
					// 计算各类型题目集合以及分数
					var singleChoice = [], singleChoiceScore = 0, 
						multipleChoice = [], multipleChoiceScore = 0, 
						judge = [], judgeScore = 0, 
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
						} else if (item.type == 'judge') {
							judge.push(item);
							judgeScore += item.score;
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
					
					// 填充试卷和答题卡
					if (singleChoice.length > 0) {
						$("[name='questions']").append(buildQuestionString("单选题", singleChoice, singleChoiceScore));
						$("[name='answerSheet']").append(buildAnswerSheetString("单选题", singleChoice));
					}
					if (multipleChoice.length > 0) {
						$("[name='questions']").append(buildQuestionString("多选题", multipleChoice, multipleChoiceScore));
						$("[name='answerSheet']").append(buildAnswerSheetString("多选题", multipleChoice));
					}
					if (judge.length > 0) {
						$("[name='questions']").append(buildQuestionString("判断题", judge, multipleChoiceScore));
						$("[name='answerSheet']").append(buildAnswerSheetString("判断题", judge));
					}
					if (fillBlank.length > 0) {
						$("[name='questions']").append(buildQuestionString("填空题", fillBlank, fillBlankScore));
						$("[name='answerSheet']").append(buildAnswerSheetString("填空题", fillBlank));
					}
					if (shortAnswer.length > 0) {
						$("[name='questions']").append(buildQuestionString("简答题", shortAnswer, shortAnswerScore));
						$("[name='answerSheet']").append(buildAnswerSheetString("简答题", shortAnswer));
					}
					if (programming.length > 0) {
						$("[name='questions']").append(buildQuestionString("编程题", programming, programmingScore));
						$("[name='answerSheet']").append(buildAnswerSheetString("编程题", programming));
					}
					
					// 绑定试卷和答题卡颜色变化事件
					$('li.option').bind("click", function(){
						var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id');
						var cardLi = $("a[href='#" + examId + "']");
						if(!cardLi.hasClass('hasBeenAnswer')){
							cardLi.addClass('hasBeenAnswer');
						}
					});
					$('textarea').bind("change", function() {
						var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id');
						console.log(examId);
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
		
		// 创建试题字符串
		function buildQuestionString(questionType, questions, score) {
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
			if (questions[0].type == 'singleChoice' || questions[0].type == 'multipleChoice') {
				$.each(questions, function(i, item) {
					temp += "<li id='" + item.type + "_" + i + "'>";
					temp += "<div name='question' id='" + item.id + "' type='" + item.type + "' class='test_content_nr_tt'>";
					temp += "<i>" + (i + 1) + "</i><span>(" + item.score + "分)</span><font>" + item.content + "</font>";
					temp += "</div>";
					temp += "<div class='test_content_nr_main'>";
					temp += "<ul>";
					temp += buildChoiceOption(i, item, "A");
					temp += buildChoiceOption(i, item, "B");
					temp += buildChoiceOption(i, item, "C");
					temp += buildChoiceOption(i, item, "D");
					temp += "</ul>";
					temp += "</div>";
					temp += "</li>";
				});
			} else if (questions[0].type == 'judge') {
				$.each(questions, function(i, item) {
					temp += "<li id='" + item.type + "_" + i + "'>";
					temp += "<div name='question' id='" + item.id + "' type='" + item.type + "' class='test_content_nr_tt'>";
					temp += "<i>" + (i + 1) + "</i><span>(" + item.score + "分)</span><font>" + item.content + "</font>";
					temp += "</div>";
					temp += "<div class='test_content_nr_main'>";
					temp += "<ul>";
					temp += buildJudgeString(i, item, "A");
					temp += buildJudgeString(i, item, "B");
					temp += "</ul>";
					temp += "</div>";
					temp += "</li>";
				});
			} else if (questions[0].type == 'fillBlank' || 
					questions[0].type == 'shortAnswer' || questions[0].type == 'programming') {
				$.each(questions, function(i, item) {
					temp += "<li id='" + item.type + "_" + i + "'>";
					temp += "<div name='question' id='" + item.id + "' type='" + item.type + "' class='test_content_nr_tt'>";
					temp += "<i>" + (i + 1) + "</i><span>(" + item.score + "分)</span><font>" + item.content + "</font>";
					temp += "</div>";
					temp += "<div class='test_content_nr_main'>";
					//temp += "<ul>";
					temp += buildAnswerString(i, item);
					//temp += "</ul>";
					temp += "</div>";
					temp += "</li>";
				});
			}
			temp += "</ul>";
			temp += "</div>";
			
			return temp;
		}
		
		// 创建选项字符串
		function buildChoiceOption(i, item, optionName) {
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
				temp += "<input type='radio' class='radioOrCheck' name='answer" + item.id + "' id='" + 
					item.type + "_answer_" + i + "_option_" + optionName + "' value='" + optionName + "' />";
			} else if (item.type == "multipleChoice") {
				temp += "<input type='checkbox' class='radioOrCheck' name='answer" + item.id + "' id='" + 
					item.type + "_answer_" + i + "_option_" + optionName + "' value='" + optionName + "' />";
			}
			temp += "<label for='" + item.type + "_answer_" + i + "_option_" + optionName + "'> " + optionName + ". ";
			temp += "<p class='ue' style='display: inline;'>" + optionValue + "</p>";
			temp += "</label>";
			temp += "</li>";
			return temp;
		}
		
		// 创建判断题字符串
		function buildJudgeString(i, item, optionName) {
			var optionValue = "";
			if (optionName == "A") {
				optionValue = "True";
			} else if (optionName == "B") {
				optionValue = "False";
			}
			var temp = "";
			temp += "<li class='option'>";
			temp += "<input type='radio' class='radioOrCheck' name='answer" + item.id + "' id='" + 
				item.type + "_answer_" + i + "_option_" + optionName + "' value='" + optionValue + "'/>";
			temp += "<label for='" + item.type + "_answer_" + i + "_option_" + optionName + "'> " + optionName + ". ";
			temp += "<p class='ue' style='display: inline;'>" + optionValue + "</p>";
			temp += "</label>";
			temp += "</li>";
			return temp;
		}
		
		// 创建填空简答编程字符串
		function buildAnswerString(i, item) {
			var temp = "";
			temp += "<textarea name='answer" + item.id + "' rows='6' cols='100' name='answer" + i + "'></textarea>";
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
		
		// 交卷
		function handInPaper() {
			var achievement = {};
			achievement.userId = $("#userId").val();
			achievement.subject = $("[name=subject]").attr("subject");
			achievement.totalScore = $("[name=subject]").attr("totalScore");
			achievement.totalTime = totalTime;
			achievement.spendTime = spendTime;
			var answers = [];
			$.each($("[name=question]"), function(i, item) {
				var answer = {};
				var questionId = $(this).attr("id");
				var questionType = $(this).attr("type");
				var userAnswer = '';
				if (questionType == 'singleChoice' || questionType == 'judge') {
					userAnswer = $("[name='answer" + questionId + "']:checked").val() == undefined ? "" : 
						$("[name='answer" + questionId + "']:checked").val();
				} else if (questionType == 'multipleChoice') {
					var checkboxValues = [];
					$.each($("[name='answer" + questionId + "']"), function(){
						if(this.checked){
							checkboxValues.push($(this).val());
						}
					});
					userAnswer = checkboxValues.join();
				} else {
					userAnswer = $("[name='answer" + questionId + "']").val()
				}
				answer.questionId = questionId;
				answer.userAnswer = userAnswer;
				answers.push(answer);
			});
			achievement.answers = answers;
			console.log(achievement);
			
			$("body").mLoading("show");
			$.ajax({
				url : "/api/achievement",
				type : "post",
				contentType: "application/json",
				data : JSON.stringify(achievement),
				success : function (rs) {
					$("body").mLoading("hide");
					if (rs.status == 200) {
						console.log(rs.data);
						
						$("#achievementSubject").html(rs.data.subject);
						$("#achievementUserName").html($("#userName").val());
						$("#achievementSpendTime").html(rs.data.spendTime + "/" + rs.data.totalTime + " 分钟");
						$("#achievementTotalScore").html(rs.data.totalScore + " 分");
						$("#achievementReferenceScore").html(rs.data.referenceScore + " 分");
						if (rs.data.score == 0) {
							$("#achievementScore").html("有客观题需要人工改卷，总分待定！");
						} else {
							$("#achievementScore").html(rs.data.score + " 分");
						}
						
						// 展示模态框并设定关闭属性
						$('#achievementResult').modal({
							// 点击背景空白处不被关闭
							backdrop: 'static', 
							// 触发键盘esc事件时不关闭
							keyboard: false
						});
					} else {
						layer.msg(rs.message, {icon: 0});
					}
				},
				error : function (data) {
					$("body").mLoading("hide");
					layer.msg(data.responseText, {icon: 0});
				}
			});
		}
	</script>
</body>
</html>
