// 初始字典下拉列表
function initQuestionType() {
	$.ajax({
		url: "/api/dictionary/questionType",
		type: "get",
		success: function (data) {
			var type = $("[name=type]");
			type.empty();
			$.each(data, function (i, item) {
				type.append(
					"<option score='" + item.score + "' value='" + item.name + "'>" + item.localName + "</option>"
				);
			});
		},
		error: function (data) {
			layer.msg(data.responseText, { icon: 0 });
		},
	});
}
function initQuestionFlag() {
	$.ajax({
		url: "/api/dictionary/questionFlag",
		type: "get",
		success: function (data) {
			var flag = $("[name=flag]");
			flag.empty();
			$.each(data, function (i, item) {
				flag.append("<option value='" + item.flag + "'>" + item.flag + "</option>");
			});
			$("[name=titlePrefix]").html(data[0].flag + "_");
		},
		error: function (data) {
			layer.msg(data.responseText, { icon: 0 });
		},
	});
}
