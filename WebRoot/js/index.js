/*
<div class='group-item' id='1'>
	<span class='film-img'><img src='./imgs/1.png'></img></span>
	<span class='item-name'>
		<span>沉睡的魔咒</span>
	</span>  
	<span class='film-cinema'>
		<span class='cinema-name'><img class='position-img' src='./imgs/direction.png'></img>
		洪山天河国际影城</span>
	</span>	
	<span class='item-price'><span class='prime-price'>￥50.00</span><span class='current-price'>￥19.99</span></span>
	</span>			
</div>
*/

$(document).ready(function(){
	function showInfo(data){
		var text = $('#film-content').html();
		var jsonData = eval('('+data+')');
		if($.isEmptyObject(jsonData)){//如果数据为空
			$('#groupFilm_load').unbind();
			$('#groupFilm_load').css("background","#EEEEEE");
			$('#groupFilm_load').text("没有更多内容了！");
			return;
		}
		for(var index in jsonData){
			var groupFilm = jsonData[index];
			text += "<a  href='GroupFilmAction!showGroupFilmDetail?groupFilmId="+ groupFilm['GroupFilmId'] +
			"'><div class='group-item' id='"+groupFilm['GroupFilmId'] +"'>"+
				    "<span class='film-img'><img src='" + groupFilm['filmPhotoUrl'] + "'></img></span>"+
					"<span class='item-name'>"+
						"<span>"+  groupFilm['filmName'] +"</span>"+
					"</span>"+ 
					"<span class='film-cinema'>"+
						"<span><img class='position-img' src='./imgs/direction.png'></img><font size='1'>&nbsp;"+ groupFilm['cinemaName'] + "</font></span>"+
					"</span>"+	
					"<span class='item-price'><span class='prime-price'>￥"+groupFilm['originalPrice']+"</span><span class='current-price'>￥"+groupFilm['currentPrice']+"</span></span>"+
					"</span>"+			
				"</div></a>";	
		}
		// text += "<div class='loadMore clear' id='groupFilm_load'>加载更多</div>";
		$('#film-content').html(text);
	}
	/*
	<div class='range-item top_3'>
		<span class='range-num float-left'>1</span>
		<div class='float-left range-item-info'>
			<!--<span class='line-block'><img ></img>伙影</span>-->
			<span class='line-block line-block-film'>沉睡的魔谷</span>
			<span class='line-block line-block-cinema'>洪山天河国际影城</span>
			<span class='line-block line-block-join'>已入伙&nbsp<font size='2' color='#FFFF00'>200</font></span>
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
	var tags = [];
    var area = '全部';
    var status = '全部';
	tags.push('全部');
	 $.ajax({
	 	url: 'GroupFilmAction!loadMore?page=1&pageSize=8',
	 	type: 'get',
	 	data:{'area':area,'status':status,'tags':tags.toString()},
	 	datatype:"json",
	 	success:function(data){
		        showInfo(data);
	 	},
	 	error:function(error) {
	 		/* Act on the event */
	 		alert("fail");
	 	}
	 });
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
	var page = 2;
	$("#groupFilm_load").bind('click', function(){ 
		$.ajax({
		 	url: "GroupFilmAction!loadMore?page="+page+"&pageSize=8",
		 	type: 'get',
		 	data:{'area':area,'status':status,'tags':tags.toString()},
		 	datatype:"json",
		 	success:function(data){
			        showInfo(data);
			        page++;    
		 	},
		 	error:function(error) {
		 		/* Act on the event */
		 		alert("加载数据失败");
		 	}
	 	});
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
					window.location.reload();
				else
					alert("退出失败");
			},
			error:function(){
				alert('退出失败');
			}
		});
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
	/*过滤*/
	
});
