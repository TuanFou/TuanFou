<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

    <!--<link rel="stylesheet" type="text/css" href="./imgs/styles.css">-->
	<script src="./js/jquery.js" type="text/javascript"></script>
	<script src="./js/index.js" type="text/javascript"></script>
  </head>
  
  <body>
     <div id="header"></div>
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
							<li id="${tag.tagId}">${tag.tagName}(${tag.filmNum})</li>
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
						<li>全部(20)</li>
						<li>正在上映(20)</li>
						<li>即将上映(20)</li>
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
	   			<div class='loadMore clear'>加载更多</div>
		   </div>
		</div>
		<div id="main-right">
			<div id="main-right-title"></div>
			<div id="group-range">
				<div class="range-item">
					<span class="range-num float-left">1</span>
					<span class="range-film-img"><img src="./imgs/1.png"></img></span>
					<div class="float-left range-item-info">
						<span class="line-block"><img ></img>伙影</span>
						<span class="line-block">沉睡的魔谷</span>
						<span class="line-block">洪山天河国际影城</span>
						<span class="line-block"><font size="3">200</font>人已经入伙</span>
						<span class="line-block float-right"><a href="#">我要入伙</a></span>
					</div>
				</div>
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
				<div class="range-item">
					<span class="range-num float-left">3</span>
					<span class="range-film-img"><img src="./imgs/1.png"></img></span>
					<div class="float-left range-item-info">
						<span class="line-block"><img ></img>伙影</span>
						<span class="line-block">沉睡的魔谷</span>
						<span class="line-block">洪山天河国际影城</span>
						<span class="line-block"><font size="3">200</font>人已经入伙</span>
						<span class="line-block float-right"><a href="#">我要入伙</a></span>
					</div>
				</div>
				<div class="range-item">
					<span class="range-num float-left">4</span>
					<span class="range-film-img"><img src="./imgs/1.png"></img></span>
					<div class="float-left range-item-info">
						<span class="line-block"><img ></img>伙影</span>
						<span class="line-block">沉睡的魔谷</span>
						<span class="line-block">洪山天河国际影城</span>
						<span class="line-block"><font size="3">200</font>人已经入伙</span>
						<span class="line-block float-right"><a href="#">我要入伙</a></span>
					</div>
				</div>
				<div class="range-item">
					<span class="range-num float-left">5</span>
					<span class="range-film-img"><img src="./imgs/1.png"></img></span>
					<div class="float-left range-item-info">
						<span class="line-block"><img ></img>伙影</span>
						<span class="line-block">沉睡的魔谷</span>
						<span class="line-block">洪山天河国际影城</span>
						<span class="line-block"><font size="3">200</font>人已经入伙</span>
						<span class="line-block float-right"><a href="#">我要入伙</a></span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<div class="site-info">
		
	</div>
  </body>
</html>
