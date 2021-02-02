jQuery(function($) {
	$('.nav-list li').each(function(){  
		$(this).removeClass('active');  
		$(this).removeClass('open');  
	});
	$('.nav-list li a').each(function(){  
		if($($(this))[0].href==String(window.location)) {
			$(this).parent().parent().parent().addClass('open active');
			$(this).parent().addClass("active");
		}
	});
});

var DEFAULT_PAGE_SIZE = 5;

function initRoles(rolesDiv, checkboxName) {
	$("#" + rolesDiv + "").empty();
	$.ajax({
		url : "/api/roles",
		type : "get",
		contentType: "application/json",
		success : function (rs) {
			var checkboxs = "";
			$.each(rs, function(i, value) {
				checkboxs += "<input name='"+ checkboxName + "' value='" + 
						value.id +"' type='checkbox'>" + value.roleName + "&nbsp;&nbsp;";
			});
			$("#" + rolesDiv + "").append(checkboxs);
		},
		error : function (data) {
			layer.alert(data.responseText, {icon: 0});
		}
	});
}