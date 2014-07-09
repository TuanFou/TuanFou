$(document).ready(function(){
	/*
	<div class="range-item">
		<span class="range-num float-left">2</span>
		<span class="range-film-img"><img src="./imgs/1.png"></img></span>
		<div class="float-left range-item-info">
			<span class="line-block"><img ></img>伙影</span>
			<span class="line-block">沉睡的魔谷</span>
			<span class="line-block">洪山天河国际影城</span>
			<span class="line-block"><font size="3">200</font>人已经入伙</span>
			<span class="line-block float-right"><a href="#">我要入伙</a></span>
		</div>
	</div>
	*/
	function  showRangeInfo(data){
		var text = $('#group-range').html();
		var jsonData = eval('('+data+')');
		for(var index in jsonData){
			var recommendFilm = jsonData[index];
			text += "<a href='GroupFilmAction!showGroupFilmDetail?groupFilmId="+ recommendFilm['groupFilmId'] +
			        "'><div class='range-item top_"+index+"' id='range_" + recommendFilm['groupFilmId'] +"'>"+
						"<span class='range-num float-left'>"+ recommendFilm['rank'] + "</span>"+
						"<div class='float-left range-item-info'>"+
							"<span class='line-block line-block-film'>" + recommendFilm['filmName'] + "</span>"+
							"<span class='line-block line-block-cinema'>"+ recommendFilm['cinemaName'] + "</span>"+
							"<span class='line-block line-block-join'>已入伙&nbsp<font size='2' color='#FFFF00'>" + recommendFilm['userNum'] + "</font></span>"+
						"</div>"+
					"</div></a><div class='clear'></div>";	
		}
		// text += "<div class='loadMore clear' id='loadMore'>加载更多</div>";
		$('#group-range').html(text);
	}
	 /*请求推荐电影列表*/
	$.ajax({
	 	url: 'GroupFilmAction!getRecommendGroupFilms?page=1&pageSize=8',
	 	type: 'get',
	 	datatype:"json",
	 	success:function(data){
	 		// alert(data);
		      showRangeInfo(data);
	 	},
	 	error:function(error) {
	 		/* Act on the event */
	 		alert("fail");
	 	}
	}); 
		/*
	菜单选择
	*/
	$('#myTF').bind('click', function(event) {
		/* Act on the event */
		window.location.href = "UserAction!ShowProfilePage";
	});
	$('#login_TF').bind('click',function(event) {
		/* Act on the event */
		$('#login_link').click();
	});
	$('#login_bt').bind('click',function(event) {
		/* Act on the event */
		$('#login_link').click();
	});

	//点击入伙
	$('#joinGroup').bind('click', function(event) {
		/* Act on the event */
		if($("#username").length==0){
			$('#login_link').click();
			return ;
		}
		//用户id
		//alert($("#username").attr('class'));
		var userId = $("#username").attr('class');
		var groupFilmId =document.groupFilmForm.groupFilmId.value;
		$.ajax({
		 	url: 'GroupFilmAction!addHeartUser?groupFilmId='+groupFilmId+"&userId="+userId,
		 	type: 'get',
		 	datatype:"json",
		 	success:function(data){
		 		// alert(data);
			     if(data=="success"){
			     	window.location.reload();
			     }else{
			     	alert('入伙失败');
			     }
		 	},
		 	error:function(error) {
		 		/* Act on the event */
		 		alert("入伙失败!");
		 	}
		}); 
		//groupFilmId
		//alert(document.groupFilmForm.groupFilmId.value);
	});
	/*
	  添加评论
	*/
	$('#addComment').bind('click', function(event) {
		//用户没有登录不能评论
		if($("#username").length==0){
			$('#login_link').click();
			return ;
		}
		var groupFilmId = document.commentForm.groupFilmId.value;
		var userId = document.commentForm.userId.value;
		var data = document.commentForm.myComment.value;
		alert(groupFilmId);
		alert(userId);
		alert(data);
		$.ajax({
		 	url: 'UserAction!addComment?groupFilmId='+groupFilmId+"&userId="+userId,
		 	type: 'post',
		 	data:{'content':data,"star":"4"},
		 	datatype:"json",
		 	success:function(data){
		 		// alert(data);
			     if(data=="success"){
			     	window.location.reload();
			     }else{
			     	alert('评论失败');
			     }
		 	},
		 	error:function(error) {
		 		/* Act on the event */
		 		alert("评论失败!");
		 	}
		}); 
	});
});
