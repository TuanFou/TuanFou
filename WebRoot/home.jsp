<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	session.setMaxInactiveInterval(1800);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/common.css">
    <link rel="stylesheet" type="text/css" href="./css/index.css">
	<link rel="stylesheet" type="text/css" href="./css/header.css">
	<link rel="stylesheet" type="text/css" href="./css/reg_log.css">
    <!--<link rel="stylesheet" type="text/css" href="./imgs/styles.css">-->
	<script src="./js/jquery.js" type="text/javascript"></script>
	<script type="text/javascript" src="./js/tinybox.js"></script>
	<script src="./js/index.js" type="text/javascript"></script>
	<script src="./js/reg_login.js" type="text/javascript"></script>
	<script src="./js/menuManage.js" type="text/javascript"></script>
	<style>
	#tinybox{position:absolute; display:none; /*padding:10px;*/ background:#ffffff url(image/preload.gif) no-repeat 50% 50%; border:10px solid #e3e3e3; z-index:2000;}
	#tinymask{position:absolute; display:none; top:0; left:0; height:100%; width:100%; background:#000000; z-index:1500;}
	#tinycontent{background:#ffffff; font-size:1.1em;}
	</style>
  </head>
<style>
.selected{
	background: #db8067;
	color: white;
	font-weight: bold;
	border-radius: 2px;
}

</style>
<script>
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
//显示团购电影信息
var page = 1;
var area = '';	
var tags = [];	
var status = ''; 
function showFirstPage(data){
		page = 2;
		$('#film-content').html('');
		$('#groupFilm_load').text("加载更多");
		$("#groupFilm_load").unbind();
		$("#groupFilm_load").bind('click', function(){ 
			// alert(area);
			// alert(status);
			// alert(tags); 
			$.ajax({
			 	url: "GroupFilmAction!loadMore?page="+page+"&pageSize=8&area="+area+"&status="+status,
			 	type: 'get',
			 	data:{'tags':tags.toString()},
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
		var text = '';
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
function checkSelect(){
	    //地区选项 id="area-filter" 
	    area = '';
	    status = '';
	    tags = [];
	    $.each($('#area-filter').children('li'), function(index, val) {
	    	 /* iterate through array or object */
	    	 if($('#'+val.id).attr('class')=='selected')
	    	 	  area = $('#'+val.id).text().split('(',1);
	    });
	    //alert(area);
	    //影片类型 id="type-filter" 
	    $.each($('#type-filter').children('li'), function(index, val) {
	    	 /* iterate through array or object */
	    		if($('#'+val.id).attr('class') == 'selected'){
	    			tags.push($('#'+val.id).text().split('(',1));
	    		}
	    });
	   // alert(tags);
	    //上映状态
	    $.each($('#status-filter').children('li'), function(index, val) {
	    	 /* iterate through array or object */
	    		 if($('#'+val.id).attr('class')=='selected')
	    	 	    status = $('#'+val.id).text().split('(',1);
	    });
    	//alert(status);
    	if(area==''){
    		area = '全部';
    	}
    	if(status == ''){
    		status = '全部';
    	}
    	if(tags.length==0){
    		tags.push('全部');
    	}
		// alert(tags);
		// alert(area); 
		// alert(status);

    	/*向后台请求数据*/
    	 $.ajax({
		 	url: 'GroupFilmAction!loadMore?page=1&pageSize=8&area='+area+"&status="+status,
		 	type: 'get',
		 	data:{'tags':tags.toString()},
		 	datatype:"json",
		 	success:function(data){
			    showFirstPage(data);
		 	},
		 	error:function(error) {
		 		/* Act on the event */
		 		for(var index in error){
		 			alert(error[index]);
		 		}
		 	}
		 });
}
function requestFilter(ele){
	if($('#'+ele.id).attr('class') == 'selected'){
		$('#'+ele.id).attr('class', '');
		checkSelect();
		return ;
	}
	if($('#'+ele.id).parent("ul").attr('id') != "type-filter" ){
		//设置其他节点为选择
		$('#'+ele.id).attr('class', 'selected');
  	$.each($('#'+ele.id).siblings('li'), function(index, val) {
  		 /* iterate through array or object */
  		 $('#'+val.id).attr('class', '');
  	});
	}
	$('#'+ele.id).attr('class', 'selected');
	checkSelect();
}
</script>
<script type="text/javascript">
function registClick(){
	$('#reg_link').click();
}
function loginSubmit(obj){
 	var userName = loginForm.userName.value;
 	var password = loginForm.password.value;
 	if(userName=='' || password ==''){
 		alert('用户名和密码不能为空');
 		return;
 	}

	$.ajax({
		//alert(userName);
	 	url: 'UserAction!login',
	 	//data:{"userName":userName, "password":password},
	 	type: 'get',
	 	datatype:'json',
	 	data:{'userName':userName,'password':password},
	 	success:function(data){
	 		if(data=="success"){//登录成功
	 			window.location.reload();
	 		}else{
	 			alert('账号和密码不匹配');
	 		}
	 	},
	 	error:function(error) {
	 		/* Act on the event */
	 		alert(error);
	 	}
	}); 
 }
function regSubmit(obj){
	var userName = regForm.userName.value;
	var password = regForm.password.value;
	var confirm_password = regForm.confirm_password.value;
	var cityId = regForm.citySelector.value;
	var email = regForm.email.value;
	var description = regForm.description.value;
	if(password != confirm_password)
	{
		alert('两次密码不一致');
		return ;
	}
	$.ajax({
		url: 'UserAction!regist',
		type: 'get',
		data: {'userName': userName,'password':password,'cityId':cityId,'email':email,'description':description},
		success:function(data){
			window.location.reload();
		},
		error:function(error){
			for(var index in error){
				alert(error[index]);
			}
		}
	});
 }
 </script>
<body>
    <div id="middle-background">
     	<div id="header">
             <div id="banner">
                <span id="logo">团否网</span>
                
                <c:choose>
                	<c:when test="${empty sessionScope.userName}">
                		<span class="header-login"><a id="login_link"  >登录</a></span>
           	   			<span  class="header-regist"><a  id="reg_link" >注册</a></span>
                	</c:when>
                	<c:otherwise>
                		<span id="username">${sessionScope.userName}</span>
                		<span id="exit">退出登录</span>
                	</c:otherwise>
                </c:choose>  
                <span id="merchantCenter"><a href="MerchantAction!login">商家中心</a></span>             
            </div>
            <img id="logo-img" src="./imgs/logo_tuanfou.png"/>
            <div id="catagory">
                <span id="recommend">推荐</span>
                <span id="shopping" class="menu-selected">团购首页</span>
                <!--<span id="myTF" >我的团否</span>-->
                 <c:choose>
                	<c:when test="${empty sessionScope.userId}">
                		<span id="login_TF" >我的团否</span>
                	</c:when>
                	<c:otherwise>
                		<span id="myTF" >我的团否</span>
                	</c:otherwise>
                </c:choose>   
                <span id="aboutUs">关于团否</span>
            </div>
            <div class="clear"></div>
            <div id="breakline"></div>
        </div>
	 	<div id="bg">
			<div id="main-left">
			   <img src="./imgs/ad.png" id="adImg">
			   <div  class="filter">
			  		 <div class="filter-section">
						<div class="filter-type">所在城市:</div>
						<ul class="inline-block-list">
							<li>武汉</li>
						</ul>
					</div>
					<div class="filter-section">
						<div class="filter-type">所在区域:</div>
						<ul id="area-filter" class="inline-block-list">
							<c:forEach items="${areas}" var="area" varStatus="idxStatus">
							    <c:choose>
				                	<c:when test="${idxStatus.index == 0}">
				                		<li class="selected" id="area_${area.areaId}" onclick="requestFilter(this)">${area.areaName}(${area.filmNumber})</li>
				                	</c:when>
				                	<c:otherwise>
				                		<li id="area_${area.areaId}" onclick="requestFilter(this)">${area.areaName}(${area.filmNumber})</li>
				                	</c:otherwise>
				                </c:choose> 
							</c:forEach>
						</ul>
					</div>
				  	<div class="filter-section">
						<div class="filter-type">影片类型:</div>
						<ul id="type-filter" class="inline-block-list">
						    <c:forEach items="${filmTags}" var="tag" varStatus="idxStatus">
							    <c:choose>
				                	<c:when test="${idxStatus.index == 0}">
				                		<li class="selected" id="tag_${tag.tagId}" onclick="requestFilter(this)">${tag.tagName}(${tag.filmNum})</li>
				                	</c:when>
				                	<c:otherwise>
				                		<li id="tag_${tag.tagId}" onclick="requestFilter(this)">${tag.tagName}(${tag.filmNum})</li>
				                	</c:otherwise>
				                </c:choose> 
								
							</c:forEach>
						</ul>
					</div>
<!-- 				    <div  class="filter-section">
						<div class="filter-type">国家/地区:</div>
						<ul id="city-filter"  class="inline-block-list">
							<li class="selected">全部(20)</li>
							<li>中国大陆(20)</li>
							<li>中国香港(20)</li>
							<li>中国台湾(20)</li>
							<li>欧美(20)</li>
							<li>日韩(20)</li>
							<li>其他(20)</li>
						</ul>
					</div> -->
					<div class="filter-section">
						<div class="filter-type">发布时间:</div>
						<ul id="status-filter"  class="inline-block-list">
							<c:forEach items="${filmStatusInfo}" var="info" varStatus="idx" >
								 <c:choose>
				                	<c:when test="${idx.index == 0}">
				                		<li class="selected" id="status_${idx.index}" onclick="requestFilter(this)">${info.status}(${info.filmNum})</li>
				                	</c:when>
				                	<c:otherwise>
				                		<li id="status_${idx.index}" onclick="requestFilter(this)">${info.status}(${info.filmNum})</li>
				                	</c:otherwise>
				                </c:choose> 
							</c:forEach>
						</ul>
					</div>
			    </div>
			   <div class="show-type"></div>
			   <div id="film-content">
		   		   <!--  <div class="group-item" id="1">
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
		   			</div> -->
		   			<!-- <div class='loadMore clear'>加载更多</div> -->
			   </div>
			   <div class="loadMore clear" id="groupFilm_load">加载更多</div>
			</div>
			<div id="main-right">
				<img src="./imgs/recommend.png">
				<div id="group-range">					
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="site-info">
			
		</div>
	</div>
  </body>
</html>
