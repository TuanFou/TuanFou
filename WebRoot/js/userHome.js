$(document).ready(function(){
	// $("#detail-info").attr("src","./personInfo.html");
	var currentMenuId = "#my-groupFilm";
	$("#menu-bottom li").bind('click',function(event) {
		/* Act on the event */
		var id = $(this).attr("id");
		$(currentMenuId).attr("class","");
		currentMenuId = "#"+id;
		$(currentMenuId).attr("class","current-select");
		switch(id){
			case "my-groupFilm":
				$("#detail-info").attr("src","./userHomePage/personInfo.html");
				break;
			case "my-heartfilm":
				$("#detail-info").attr("src","./userHomePage/myHeartFilm.html");
				break;
			case "my-order":
				$("#detail-info").attr("src","./userHomePage/myOrder.html");
				break;
			case "my-comment":
				$("#detail-info").attr("src","./userHomePage/myComment.html");
				break;	
			case "my-message":
				$("#detail-info").attr("src","./userHomePage/myMessage.html");
				break;	
			case "my-complaint":
				$("#detail-info").attr("src","./userHomePage/myComplaint.html");
				break;	
		}
	});
});