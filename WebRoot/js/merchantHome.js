$(document).ready(function(){
	// $("#detail-info").attr("src","./personInfo.html");
	var currentMenuId = "#my-personalInfo";
	$("#menu-bottom li").bind('click',function(event) {
		/* Act on the event */
		var id = $(this).attr("id");
		$(currentMenuId).attr("class","");
		currentMenuId = "#"+id;
		$(currentMenuId).attr("class","current-select");
		switch(id){
			case "my-personalInfo":
 				$("#detail-info").attr("src","./merchantHomePage/personalInfo.html");
				//$("#detail-info").attr("src","UserAction!showUserInfo");
				break;
			case "apply":
				//$("#detail-info").attr("src","UserAction!showMyHeartFilmInfo");
				$("#detail-info").attr("src","MerchantAction!initApplyInfo");
				break;
			case "my-order":
				$("#detail-info").attr("src","./merchantHomePage/BusinessOrder.html");
				break;
			case "my-message":
				$("#detail-info").attr("src","./merchantHomePage/BusinessMessage.html");
				break;	
		}
	});
	/*
	菜单选择
	*/
	$('#myTF').bind('click', function(event) {
		/* Act on the event */
		window.location.reload();
	});
	$('#login_TF').bind('click',function(event) {
		/* Act on the event */
		$('#login_link').click();
	});
	$('#login_bt').bind('click',function(event) {
		/* Act on the event */
		$('#login_link').click();
	});
	$('#shopping').bind('click',function(event) {
		/* Act on the event */
		window.location.href = "FilterAction!getFilterTags";
	});
});