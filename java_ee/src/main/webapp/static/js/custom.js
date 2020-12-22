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
		url : "/api/dict/questionType",
		type : "get",
		success : function (data) {
			var type = $("[name=type]");
			type.empty();
			$.each(data, function(i, item) {
				type.append("<option score='" + item.score + "' value='" + item.name + "'>" 
						+ item.localName + "</option>");
			});
		},
		error : function (data) {
			layer.msg(data.responseText, {icon: 0});
		}
	});
}
function initQuestionFlag() {
	$.ajax({
		url : "/api/dict/questionFlag",
		type : "get",
		success : function (data) {
			var flag = $("[name=flag]");
			flag.empty();
			$.each(data, function(i, item) {
				flag.append("<option value='" + item.flag + "'>" + item.flag + "</option>");
			});
			$(".titlePrefix").html(data[0].flag + "_");
		},
		error : function (data) {
			layer.msg(data.responseText, {icon: 0});
		}
	});
}