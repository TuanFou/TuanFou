var currentMenuId = "#my-groupFilm";
$(document).ready(function(){
	// $("#detail-info").attr("src","./personInfo.html");

	$("#menu-bottom li").bind('click',function(event) {
		/* Act on the event */
		var id = $(this).attr("id");
		$(currentMenuId).attr("class","");
		currentMenuId = "#"+id;
		$(currentMenuId).attr("class","current-select");
		switch(id){
			case "my-groupFilm":
//				$("#detail-info").attr("src","./userHomePage/personInfo.html");
				$("#detail-info").attr("src","UserAction!showUserInfo");
				break;
			case "my-heartfilm":
				$("#detail-info").attr("src","UserAction!showMyHeartFilmInfo");
				break;
			case "my-order":
				$("#detail-info").attr("src","OrderAction!getUserOrders");
				break;
			case "my-comment":
				$("#detail-info").attr("src","UserAction!showMyComment");
				break;	
			case "my-complaint":
				$("#detail-info").attr("src","UserAction!showMyComplaint");
				break;	
			case "my-message":
				$("#detail-info").attr("src","UserAction!showMyMessage");
				break;	
		}
	});
	/*
	菜单选择
	*/
	var currentMenuId = 'shopping'; 
	// function changeMenu(id){
	// 	//var id = $(this).attr("id");
	// 	$(currentMenuId).attr("class","");
	// 	currentMenuId = "#"+id;
	// 	$(currentMenuId).attr("class","current-select");
	// }
	$('#myTF').bind('click', function(event) {
		/* Act on the event */
		window.location.href = "UserAction!ShowProfilePage";
	});
	$('#login_TF').bind('click',function(event) {
		/* Act on the event */
		$('#login_link').click();
	});
	$('#shopping').bind('click', function(event) {
		/* Act on the event */
		window.location.href = "FilterAction!getFilterTags";
	});
	/*
		退出登录
	*/
	$('#exit').bind('click', function(event) {
		/* Act on the event */
		$.ajax({
			url: 'UserAction!logout',
			type: 'get',
			success:function(data){
				if(data=="success")
					window.location.href = "FilterAction!getFilterTags";
				else
					alert("退出失败");
			},
			error:function(){
				alert('退出失败');
			}
		});
	});
});