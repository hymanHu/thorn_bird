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