jQuery(function($) {
	// 移除所有的active 和 menu-open 属性
	$('.nav-sidebar li').each(function(){  
		$(this).removeClass('menu-open');  
	});
	$('.nav-sidebar li a').each(function(){  
		$(this).removeClass('active');  
	});
	
	// 根据path加载 active 和 menu-open 属性
	$('.nav-sidebar li a').each(function(){  
		if($($(this))[0].href==String(window.location)) {
			$(this).addClass("active");
			$(this).parent().parent().parent().addClass("active menu-open");
		}
	});
});

// 初始字典下拉列表
function initQuestionType() {
	$.ajax({
		url : "/api/dic/questionType",
		type : "get",
		success : function (data) {
			var type = $("[name=type]");
			type.empty();
			$.each(data, function(i, item) {
				type.append("<option value='" + item.name + "'>" + item.localName + "</option>");
			});
		},
		error : function (data) {
			layer.msg(data.responseText, {icon: 0});
		}
	});
}
function initQuestionFlag() {
	$.ajax({
		url : "/api/dic/questionFlag",
		type : "get",
		success : function (data) {
			var type = $("[name=flag]");
			type.empty();
			$.each(data, function(i, item) {
				type.append("<option value='" + item.flag + "'>" + item.flag + "</option>");
			});
		},
		error : function (data) {
			layer.msg(data.responseText, {icon: 0});
		}
	});
}