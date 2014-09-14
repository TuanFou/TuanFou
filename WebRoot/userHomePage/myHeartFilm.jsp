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
    
    <title>My JSP 'myHeartFilm.jsp' starting page</title>
    
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
  float:left;
}
.float-right{
  float: right;
}
.line-block{
  display: block;
  padding: 2px;
}
#info-area{
  margin-top:20px;
  width:490px;
}
.info-title{
  background-color: #EEEEEE;
}
.table{
    border-collapse: collapse;
    border:1px solid #ccc;;
    width:640px;
}
td,th{
   border:1px solid #ccc;
   text-align: center;
}
img{
  margin-left: 20px;
}
.film-name{
  margin-left: 10px;
  margin-top: 20px;
  display: block;
  float: left;
}
.film-cinema{
  display: blcok;
}
.left{
  width:320px;
}

  </style>
  <body>
   <div  class="bg">
      <span><font size="5" color="#bd8037">我的伙影</font></span>
      <div id="info-area">
         <table class="table">
            <tr>
              <th>电影名</th>
              <th>电影院</th>
            </tr>
            <c:forEach items="${myHeartFilm}" var="info">
	           <tr>
              <td>  
                <span >
                  <img class="float-left" width="50px" height="60px" src="${info.filmPhoto}">
                </span>  
                <span class="film-name">${info.filmName}</span>
              </td>
              <td >
                <span class="film-cinema">${info.cinameName}</span>
              </td>
            </tr>
            </c:forEach>
         </table>
      </div>
  </div>
  </body>
</html>
