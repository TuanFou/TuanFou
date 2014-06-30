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
}
.left{
  width: 50%;
  padding: 10px;
}
.right{
  width: 50%;
}
td.right ul{
  list-style: none;
  padding-left: 15px;
  padding-right: 15px;
}
a{
  text-decoration: none;
}
.heart-film-info{
  width: 200px;
  margin-left: 10px;
  margin-top: 5px;
}
  </style>
  <body>
   <div  class="bg">
      <span><font size="5" color="blue">我的伙影</font></span>
      <div id="info-area">
         <table class="table">
            <tr>
              <th>2014-01-01 武汉 洪山区</th>
              <th>已邀请</th>
            </tr>
            <c:forEach items="${myHeartFilm}" var="info">
	            <tr>
	              <td class="left">
	                <span ><img class="float-left" width="50px" height="60px" src="./imgs/1.png"></span>
	                <div class="float-left heart-film-info" >
	                    <span class="line-block">${info.filmName }</span>
	                    <span class="line-block">${info.address }</span>
	                </div>
	              </td>
	              <td class="right">
	                <ul >
	                  <li>kdf5000 <a class="float-right" href="#">重新发送邀请</a></li>
	                  <li>kdf5000 <a class="float-right" href="#">重新发送邀请</a></li>
	                  <li>kdf5000 <a class="float-right" href="#">重新发送邀请</a></li>
	                </ul>
	              </td>
	            </tr>
            </c:forEach>
         </table>
      </div>
  </div>
  </body>
</html>
