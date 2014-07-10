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
    
    <title>My JSP 'myComplaint.jsp' starting page</title>
    
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
.float-left{
  float: left;
}
.float-right{
  float: right;
}
  .line-block{
    display: block;
    padding: 5px;
  }

  #info-area{
    margin: 20px auto;
  }
  .title{
    text-align: center;
  }
  .title_1, .title_2,.title_3,.title_4{
    padding: 5px;
    float: left;
    background: #EEEEEE;
  }
  .title_1{
    width: 200px;
  }
  .title_2{
    width: 200px;
  }
  .title_3{
    width: 80px;
  }
  .title_4{
    width: 80px;
  }

  /*订单项*/
.complaint-item{
  width: 600px;
  height:100px;
  border: 1px solid #EEEEEE;
  margin-top: 20px;
}
.clear{
  clear: both;
}
.heart-film-info span{
  width: 150px;
  margin-left: 5px;
  margin-top: 5px;
}
.compliant-content{
/*  margin-top:10px;*/
  width: 210px;
  overflow: auto;
  text-align: center;
}
.status{
  width: 90px;
  margin-top: 20px;
  text-align: center;
}
.operation{
  margin-top: 5px;
  width: 85px;
}
.operation button{
  width:80px;
  border: none;
  margin-top: 15px
}
.operation button:hover{
  background: #0080FF;
  text-align: center;
}
.complaint-item-title{
  display: block;
  background: #EEEEEE;
  height: 25px;
  line-height: 25px;
  padding-left: 10px;
}
.item-info{
  margin-top: 8px;
}
</style>
</head>
  
<body>
 <div  class="bg">
      <span><font size="5" >我的订单</font></span>
      <div id="info-area">
         <div class="title">
            <div class="title_1">团购</div>
            <div class="title_2">投诉理由</div>
            <div class="title_3">投诉状态</div>
            <div class="title_4">操作</div>
         </div>
         <div class="clear"></div>
         <c:forEach items="${complaints}" var="info">
	         <div class="complaint-item">
	            <span class="complaint-item-title">&nbsp;&nbsp;&nbsp;&nbsp;${info.areaName}&nbsp;&nbsp;&nbsp;2014-01-01</span>
	            <div class="item-info">
	                <span ><img class="float-left" width="40px" height="60px" src="${info.picUrl}"></span>
	                <div class="float-left heart-film-info" >
	                    <span class="line-block">${info.filmName}</span>
	                    <span class="line-block">${info.cinemaName}</span>
	                </div>
	                <span class="  float-left  compliant-content" >
	                    ${info.reason}
	                </span>
	                <span class="float-left status">已处理</span>
	                <span class="float-left operation">
	                     <span><button>撤销投诉</button></span>
	                </span>
	            </div>
	         </div>
	         <div class="clear"></div>
	     </c:forEach>
      </div>
  </div>
</body>
</html>
