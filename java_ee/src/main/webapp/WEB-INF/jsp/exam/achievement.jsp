<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Achievement</title>
	
	<!-- css -->
	<!-- Exam -->
	<link href="/static/_exam/css/main.css" rel="stylesheet" />
	<link href="/static/_exam/css/test.css" rel="stylesheet" />
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" 
		rel="stylesheet" />
	<!-- Font Awesome -->
	<link href="/static/plugins/fontawesome-free/css/all.min.css" rel="stylesheet" />
	<!-- loading -->
	<link href="/static/plugins/jquery.mloading/src/jquery.mloading.css" rel="stylesheet" />
	<!-- admin -->
	<link href="/static/_exam/css/adminlte.css" type="text/css" rel="stylesheet" />
	
</head>
<body class="hold-transition layout-top-nav">
	<input type="hidden" id="achievementId" value="${achievementId }"/>
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
								<li class="breadcrumb-item active">考卷</li>
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
											<font><input type="button" name="checkBtn" value="判卷"></font>
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
	<!-- loading -->
	<script src="/static/plugins/jquery.mloading/src/jquery.mloading.js"  type="text/javascript"></script>
	<!-- layer -->
	<script src="https://cdn.bootcss.com/layer/2.1/layer.js" type="text/javascript"></script>
	<!-- admin -->
	<script src="/static/js/adminlte.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			initAchievement();
			
			$("[name=checkBtn]").click("click", function() {
				checkPaper();
			})
		})
		
		// 初始化考卷
		function initAchievement() {
			var achievementId = $("#achievementId").val();
			$.ajax({
				url : "/api/achievement/" + achievementId,
				type : "get",
				success : function (data) {
					$("[name='subject']").html(data.subject + "(" + data.totalScore + "分)");
					
					// 计算各类型题目集合以及分数
					var singleChoice = [], singleChoiceScore = 0, 
						multipleChoice = [], multipleChoiceScore = 0, 
						judge = [], judgeScore = 0, 
						fillBlank = [], fillBlankScore = 0, 
						shortAnswer = [], shortAnswerScore = 0, 
						programming = [], programmingScore = 0;
					$.each(data.answers, function(i, answer) {
						var item = answer.question;
						item.userAnswer = answer.userAnswer;
						item.answerId = answer.id;
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
						$("[name='questions']").append(buildQuestionString("单选题", 
								singleChoice, singleChoiceScore));
					}
					if (multipleChoice.length > 0) {
						$("[name='questions']").append(buildQuestionString("多选题", multipleChoice, multipleChoiceScore));
					}
					if (judge.length > 0) {
						$("[name='questions']").append(buildQuestionString("判断题", judge, multipleChoiceScore));
					}
					if (fillBlank.length > 0) {
						$("[name='questions']").append(buildQuestionString("填空题", fillBlank, fillBlankScore));
					}
					if (shortAnswer.length > 0) {
						$("[name='questions']").append(buildQuestionString("简答题", shortAnswer, shortAnswerScore));
					}
					if (programming.length > 0) {
						$("[name='questions']").append(buildQuestionString("编程题", programming, programmingScore));
					}
					
					// 绑定评分输入框变更事件
					$("[name=scoreInput]").blur(function() {
				        var num = $(this).val();
				        var max = $(this).attr("max");
				        num = Number(num);
				        if(isNaN(num))
				            num = 0;
				        if(num <= 0)
				            num = 0;
				        if(num > max)
				        	num = max;
				        $(this).val(num);
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
					temp += "<div name='question' id='" + item.id + "' type='" + item.type + 
						"' class='test_content_nr_tt'>";
					var score = item.referenceAnswer == item.userAnswer ? item.score : 0;
					var scoreInput = " ---- 得分 <input type='text' name='scoreInput' questionId='" + 
						item.id + "' answerId='" + item.answerId + 
						"' style='width:40px;height:25px;' value='" + score + "' disabled />";
					temp += "<i>" + (i + 1) + "</i><span>(" + item.score + "分)</span><font>" + 
						item.content + scoreInput + "</font>";
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
					temp += "<div name='question' id='" + item.id + "' type='" + item.type + 
						"' class='test_content_nr_tt'>";
					var score = item.referenceAnswer == item.userAnswer ? item.score : 0;
					var scoreInput = " ---- 得分 <input type='text' name='scoreInput' questionId='" + 
						item.id +  "' answerId='" + item.answerId + 
						"' style='width:40px;height:25px;' value='" + score + "' disabled />";
					temp += "<i>" + (i + 1) + "</i><span>(" + item.score + "分)</span><font>" + 
						item.content + scoreInput + "</font>";
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
					temp += "<div name='question' id='" + item.id + "' type='" + item.type + 
						"' class='test_content_nr_tt'>";
					var scoreInput = " ---- 得分 <input type='number' name='scoreInput' questionId='" + 
						item.id + "' answerId='" + item.answerId + 
						"' style='width:50px;height:25px;' min='0' max='" + item.score + "' step='0.1' />";
					temp += "<i>" + (i + 1) + "</i><span>(" + item.score + "分)</span><font>" + 
						item.content + scoreInput + "</font>";
					temp += "</div>";
					temp += "<div class='test_content_nr_main'>";
					temp += buildAnswerString(i, item);
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
			// 勾选用户答案
			var checked = "";
			if (item.userAnswer.search(optionName) != -1) {
				checked = " checked ";
			}
			// 设置参考答案样式
			var referenceAnswerStyle = "";
			if (item.referenceAnswer.search(optionName) != -1) {
				referenceAnswerStyle = " style='border:1px solid red'"
			}
			if (item.type == "singleChoice") {
				temp += "<input type='radio' class='radioOrCheck' name='answer" + item.id + "' id='" + 
					item.type + "_answer_" + i + "_option_" + optionName + "' value='" + 
					optionName + "' " + checked + "/>";
			} else if (item.type == "multipleChoice") {
				temp += "<input type='checkbox' class='radioOrCheck' name='answer" + item.id + "' id='" + 
					item.type + "_answer_" + i + "_option_" + optionName + "' value='" + 
					optionName + "' " + checked + "/>";
			}
			temp += "<label for='" + item.type + "_answer_" + i + "_option_" + optionName + "' " + 
				referenceAnswerStyle + "> " + optionName + ". ";
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
			// 勾选用户答案
			var checked = "";
			if (optionValue == item.userAnswer) {
				checked = " checked ";
			}
			// 设置参考答案样式
			var referenceAnswerStyle = "";
			if (optionValue == item.referenceAnswer) {
				referenceAnswerStyle = " style='border:1px solid red'"
			}
			temp += "<input type='radio' class='radioOrCheck' name='answer" + item.id + "' id='" + 
				item.type + "_answer_" + i + "_option_" + optionName + "' value='" + 
				optionValue + "' " + checked + "/>";
			temp += "<label for='" + item.type + "_answer_" + i + "_option_" + optionName + "' " + 
				referenceAnswerStyle + "> " + optionName + ". ";
			temp += "<p class='ue' style='display: inline;'>" + optionValue + "</p>";
			temp += "</label>";
			temp += "</li>";
			return temp;
		}
		
		// 创建填空简答编程字符串
		function buildAnswerString(i, item) {
			var temp = "";
			temp += "<textarea rows='6' cols='100' disabled >" + item.referenceAnswer + "</textarea>";
			temp += "<textarea rows='6' cols='100'>" + item.userAnswer + "</textarea>";
			return temp;
		}
		
		// 判卷
		function checkPaper() {
			var achievement = {};
			achievement.id = $("#achievementId").val();
			var score = 0;
			$.each($("[name=scoreInput]"), function(i, item) {
				score += Number($(this).val());
			});
			achievement.score = score;
			
			$("body").mLoading("show");
			$.ajax({
				url : "/api/achievement",
				type : "put",
				contentType: "application/json",
				data : JSON.stringify(achievement),
				success : function (rs) {
					$("body").mLoading("hide");
					if (rs.status == 200) {
						window.location.href = "/exam/achievements";
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
