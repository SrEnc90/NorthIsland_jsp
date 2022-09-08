var lista=[
	"www.facebook.com",
	"www.youtube.com"
];
function direccionar(n){
	document.getElementsByClassName("rs").href=lista(n);
}


$(document).ready(function(){
	
	var lista=[
	"www.facebook.com",
	"www.youtube.com"
];
function direccionar(n){
	document.getElementsByClassName("rs").href=lista(n);
}	
	$("#baner").cycle({
		'fx':'fade',
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

});// JavaScript Document// JavaScript Document