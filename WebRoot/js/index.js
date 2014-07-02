/*
<div class="group-item">
    <span class="film-img"><img src="./imgs/1.png"></img></span>
	<span class="item-price">￥19.99</span>
	<span class="item-name">
		<span>沉睡的魔咒</span>
		<span>7.4</span>
	</span>
	<span class="item-tag">标签：动作 冒险 奇幻 爱情</span>   
	<span class="film-cinema">
		<span><img class="position-img"></img>
		洪山天河国际影城</span>
	</span>	
	<span class="join-info">
		<span><img class="join-img"></img>
		入伙(200)</span>
	</span>			
</div>
*/

$(document).ready(function(){
	function showInfo(data){
		$('#film-content').html('');
		var text ='';
		var jsonData = eval('('+data+')');
		for(var index in jsonData){
			var groupFilm = jsonData[index];
			text += "<a href='GroupFilmAction!showGroupFilmDetail?groupFilmId="+ groupFilm['GroupFilmId'] +
			"'><div class='group-item' id='"+groupFilm['GroupFilmId'] +"'>"+
				    "<span class='film-img'><img src='" + groupFilm['filmPhotoUrl'] + "'></img></span>"+
					"<span class='item-price'>￥"+ groupFilm['currentPrice'] +"</span>"+
					"<span class='item-name'>"+
						"<span>"+  groupFilm['filmName'] +"</span>"+
						"<span>&nbsp"+ groupFilm['star'] +"</span><br>"+
					"</span>"+
					"<span class='item-tag'>标签：" + groupFilm['tags'] +"</span>"+   
					"<span class='film-cinema'>"+
						"<span><img class='position-img'></img>"+ groupFilm['cinemaName'] +"</span>"+
					"</span>"+	
					"<span class='join-info'>"+
						"<span><img class='join-img'></img>"+
						"入伙("+ groupFilm['heartNum'] +")</span>"+
					"</span>"+			
				"</div></a>";	
		}
		text += "<div class='loadMore clear'>加载更多</div>";
		$('#film-content').html(text);
	}
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
		$('#group-range').html('');
		var text ='';
		var jsonData = eval('('+data+')');
		for(var index in jsonData){
			var recommendFilm = jsonData[index];
			text += "<div class='range-item' id='range_" + recommendFilm['groupFilmId'] +"'>"+
						"<span class='range-num float-left'>"+ index + "</span>"+
						"<span class='range-film-img'><img src='" + "./imgs/1.png" + "'></img></span>"+
						"<div class='float-left range-item-info'>"+
							"<span class='line-block'><img ></img>伙影</span>"+
							"<span class='line-block'>" + recommendFilm['filmName'] + "</span>"+
							"<span class='line-block'>"+ recommendFilm['cinemaName'] + "</span>"+
							"<span class='line-block'><font size='3'>" + recommendFilm['userNum'] + "</font>人已经入伙</span>"+
							"<span class='line-block float-right'><a href='GroupFilmAction!showGroupFilmDetail?groupFilmId="+recommendFilm['groupFilmId']+"'>我要入伙</a></span>"+
						"</div>"+
					"</div>";	
		}
		// text += "<div class='loadMore clear'>加载更多</div>";
		$('#group-range').html(text);
	}
	 $.ajax({
	 	url: 'GroupFilmAction!loadMore?page=1&pageSize=10',
	 	type: 'get',
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
	 	url: 'GroupFilmAction!getRecommendGroupFilms?page=1&pageSize=10',
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
