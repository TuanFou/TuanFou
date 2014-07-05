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
		var text  = $('#group-range').html();
		var jsonData = eval('('+data+')');
		for(var index in jsonData){
			var recommendFilm = jsonData[index];
			text += "<div class='range-item' id='range_" + recommendFilm['groupFilmId'] +"'>"+
						"<span class='range-num float-left'>"+ recommendFilm['rank'] + "</span>"+
						"<span class='range-film-img'><img src='" + recommendFilm['picUrl'] + "'></img></span>"+
						"<div class='float-left range-item-info'>"+
							"<span class='line-block'><img ></img>伙影</span>"+
							"<span class='line-block'>" + recommendFilm['filmName'] + "</span>"+
							"<span class='line-block'>"+ recommendFilm['cinemaName'] + "</span>"+
							"<span class='line-block'><font size='3'>" + recommendFilm['userNum'] + "</font>人已经入伙</span>"+
							"<span class='line-block float-right'><a href='GroupFilmAction!showGroupFilmDetail?groupFilmId="+recommendFilm['groupFilmId']+"'>我要入伙</a></span>"+
						"</div>"+
					"</div>";	
		}
		text += "<div class='loadMore clear' id='loadMore'>加载更多</div>";
		$('#group-range').html(text);
	}
	 /*请求推荐电影列表*/
	$.ajax({
	 	url: 'GroupFilmAction!getRecommendGroupFilms?page=1&pageSize=5',
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
	
});
