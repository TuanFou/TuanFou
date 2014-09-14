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
    
    <title>My JSP 'myMessage.jsp' starting page</title>
    
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
.title_1,.title_2,.title_3,.title_4,.title_5{
  padding: 5px;
  float: left;
  background: #EEEEEE;
  text-align: center;
}
.title_1{
  width:90px;
}
.title_2{
  width:90px;
}
.title_3{
  width:180px;
}
.title_4{
  width:80px;
}
.title_5{
  width:80px;
}

.receiver-name,.send-name{
  margin-top: 15px;
  margin-left: 20px;
  width:80px;
}
.message-content{
  width: 175px;
  margin-left: 5px;
}
.message-time{
  width:90px;
  text-align: center;
}
.message-operation{
    width:90px;
    text-align: center;
}
.message{
  margin-top: 15px;
}
.message-operation button{
  width:60px;
  border: none;
}
.message-operation button:hover{
  background: #0080FF;
}
.receive-img{
  width: 50px;
  height:50px;
  margin-left: 10px;
  border-radius: 50px;
}
</style>
  </head>
  
<body>
<div  class="bg">
      <span><font size="5" color="#bd8037">我的消息</font></span>
      <div id="info-area">
         <div class="title">
            <div class="title_1">发信人</div>
            <div class="title_2">收信人</div>
            <div class="title_3">内容</div>
            <div class="title_4">时间</div>
            <div class="title_5">操作</div>
         </div>
         <div class="clear"></div>
     	 <c:forEach items="${messages}" var="info">
         <div class="message-item ">
            <span class="line-block float-left send-name" >${info.senderName}</span>
            <span class="line-block float-left receiver-name" >${info.receiverName}</span>
            <span class="line-block  float-left message-content"> 
              ${info.content}
            </span>
           <span class="float-left message-time">${info.time}</span>
           <span class="float-left message-operation">
              <span><button>回复</button></span>
              <span><button>删除</button></span>
           </span>
         </div>
       </c:forEach>
       </div>
  </div>
</body>
</html>
