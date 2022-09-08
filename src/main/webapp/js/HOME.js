
$(document).ready(function(){
	
	$("#baner").cycle({
		'fx':'scrollDown',
		'timeout':1000,
		'delay':500
	});
	
	$(".reseña").hover(
	function(){
	$(this).find("img").fadeOut(500);
	$(this).find("p").fadeIn(500);	
	},
		
	function(){
	$(this).find("img").fadeIn(500);
	$(this).find("p").fadeOut(500);
	}	
	);
	

});