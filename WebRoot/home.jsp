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
	<style>
	#tinybox{position:absolute; display:none; /*padding:10px;*/ background:#ffffff url(image/preload.gif) no-repeat 50% 50%; border:10px solid #e3e3e3; z-index:2000;}
	#tinymask{position:absolute; display:none; top:0; left:0; height:100%; width:100%; background:#000000; z-index:1500;}
	#tinycontent{background:#ffffff; font-size:1.1em;}
	</style>
  </head>
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
            </div>
            <img id="logo-img" src="./imgs/logo_tuanfou.png"/>
            <div id="catagory">
                <span id="recommend">推荐</span>
                <span id="shopping">团购首页</span>
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
            <div id="breakline"></div>
        </div>
	 	<div id="bg">
			<div id="main-left">
			   <div  class="filter">
			  		 <div class="filter-section">
						<div class="filter-type">所在城市:</div>
						<ul class="inline-block-list">
							<li>武汉</li>
						</ul>
					</div>
					<div class="filter-section">
						<div class="filter-type">所在区域:</div>
						<ul class="inline-block-list">
							<c:forEach items="${areas}" var="area">
								<li id="${area.areaId}">${area.areaName}(${area.filmNumber})</li>
							</c:forEach>
						</ul>
					</div>
				  	<div class="filter-section">
						<div class="filter-type">影片类型:</div>
						<ul class="inline-block-list">
						    <c:forEach items="${filmTags}" var="tag">
								<li id="tag_${tag.tagId}">${tag.tagName}(${tag.filmNum})</li>
							</c:forEach>
						</ul>
					</div>
				    <div  class="filter-section">
						<div class="filter-type">国家/地区:</div>
						<ul class="inline-block-list">
							<li>全国(20)</li>
							<li>中国大陆(20)</li>
							<li>中国香港(20)</li>
							<li>中国台湾(20)</li>
							<li>欧美(20)</li>
							<li>日韩(20)</li>
							<li>其他(20)</li>
						</ul>
					</div>
					<div class="filter-section">
						<div class="filter-type">发布时间:</div>
						<ul class="inline-block-list">
							<c:forEach items="${filmStatusInfo}" var="info">
								<li >${info.status}(${info.filmNum})</li>
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
