var recieverId = '';
$(function(){
	$(".invite-parter").bind('click',function(){
		$('#invite-info').toggle(1000);
		recieverId = $(this).parent('li').attr("id").substr(5);
	});
	$("#cancel-bt").bind('click',function(){
		$('#invite-info').toggle(1000);
	})
	$('#send-mes').bind('click',function(){
		if($('#username').length<1){
			alert('请登录');
		}
		else{
			var senderId = $('#username').attr('class');
			var content = $('#invitemes').val();
			var type=2;
			alert(senderId+"-->"+recieverId+"-"+type+":"+content);
		}
	})
});