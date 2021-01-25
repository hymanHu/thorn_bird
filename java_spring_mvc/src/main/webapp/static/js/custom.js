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