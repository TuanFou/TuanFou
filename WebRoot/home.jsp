<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	session.setAttribute("userId", 304010333);
	
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
 <script>
 function loginSubmit(obj){
 	var userName = loginForm.userName.value;
 	var password = loginForm.password;
 	if(userName=='' || password ==''){
 		alert('用户名和密码不能为空');
 		return;
 	}
 	$.ajax({
 		url: 'UserAction!login',
 		type: 'post',
 		dataType: 'json',
 		data: {"userName": userName,"password":password},
 		success:function(data){
 			alert('success');
 		},
 		error:function(error){
 			alert('failed');
 		}
 	});
 }
 function regSubmit(obj){
 	alert('reg');
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
                <span id="myTF">我的团否</span>
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
				<div id="main-right-title"></div>
				<div id="group-range">					
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="site-info">
			
		</div>
	</div>

	<!-- 登录注册页面-->
	<div class="hidden" >
		<div id="login">
			<div class="login_content">
				<span class="form-title line-block"><font size="5" color="#466474">团否.MOVIE - 登录</font></span>
				<form name="login_form"  class="login-form" >
					<span class="line-block">用户名:<input type="text" name="userName"/></span>
					<span class="line-block">密&nbsp;&nbsp;码:<input type="password" name="password" /></span>
					<span class="line-block">
						<span><font size="1" color="#DEAF9B">如果还没有注册？点击<a href="#">直接注册</a></font></span>
						<span><button class="login-bt">登录</button></span>
					</span>
				</form>
			</div>
		</div>
		<div id="regist">
			<div class="regist-content">
				<span class="form-title line-block"><font size="5" color="#466474">团否.MOVIE - 注册</font></span>
				<div class="reg-info">
					<div class="img-area float-left">
						<span ><img width="120px" height="120px" src="./imgs/girl2.jpg"/></span>
						<span class="line-block"><input type="file" value="上传"></input></span>
					</div>
					<div class="detail-info float-left">
						<span class="reg-line-block">&nbsp;&nbsp;用户名<input type="text"></input></span>
						<span class="reg-line-block">&nbsp;&nbsp;&nbsp;&nbsp;密码<input type="text"></input></span>
						<span class="reg-line-block">密码确认<input type="text"></input></span>
						<span class="reg-line-block">&nbsp;&nbsp;&nbsp;&nbsp;性别<input type="text"></input></span>
						<span class="reg-line-block">&nbsp;&nbsp;&nbsp;&nbsp;城市<input type="text"></input></span>
						<span class="reg-line-block">&nbsp;&nbsp;&nbsp;&nbsp;邮箱<input type="text"></input></span>
						<span class="reg-line-block">&nbsp;&nbsp;&nbsp;&nbsp;描述<input type="text"></input></span>
						<span class="reg-line-block" id="regist-submit"><button class="reg-bt"  onclick="regSubmit()">注册</button></span>
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
