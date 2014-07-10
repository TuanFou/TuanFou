
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myComment.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <style>
.clear{
  clear: both;
}
.float-left{
  float:left;
}
.line-block{
  display:block;
}
#info-area{
  margin: 20px auto;
}
.title_1,.title_2,.title_3,.title_4{
  padding: 5px;
  float: left;
  background: #EEEEEE;
  text-align: center;
}
.title_1{
  width:200px;
}
.title_2{
  width:230px;
}
.title_3{
  width:80px;
}
.title_4{
  width:80px;
}
.comment-film-info{
  width:152px;
  margin-left: 8px;
}
.comment-content{
  width: 240px;
}
.comment-time{
  width:90px;
  text-align: center;
}
.comment-operation{
    width:90px;
    text-align: center;
}
.comment-film{
  margin-top: 15px;
}
.comment-operation button{
  width:60px;
  border: none;
}
.comment-operation button:hover{
  background: #0080FF;
}
</style>
  </head>
  
<body>
<div  class="bg">
      <span><font size="5" color="blue">我的评论</font></span>
      <div id="info-area">
         <div class="title">
            <div class="title_1">团购</div>
            <div class="title_2">评论内容</div>
            <div class="title_3">时间</div>
            <div class="title_4">操作</div>
         </div>
         <c:forEach items="${comments}" var="commentInfo">	
	         <div class="clear"></div>
	         <div class="comment-item">
	           <div class="comment-film">
	              <span ><img class="float-left" width="50px" height="60px" src="${commentInfo.picUrl}"></span>
	              <div class="float-left comment-film-info" >
	                  <span class="line-block">${commentInfo.filmName}</span>
	                  <span class="line-block">${commentInfo.cinemaName}</span>
	              </div>
	           </div>
	            <span class="line-block  float-left comment-content">${commentInfo.content}</span>
	           <span class="float-left comment-time">${commentInfo.time}</span>
	           <span class="float-left comment-operation">
	              <span><button>修改</button></span>
	              <span><button>删除</button></span>
	           </span>
	         </div>
         </c:forEach>
      </div>
  </div>
</body>
</html>
