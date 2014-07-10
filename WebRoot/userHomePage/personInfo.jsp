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
    
    <title>个人主页</title>
    
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
  .floet-left{
    float:left;
  }
  .line-block{
    display: block;
    padding: 2px;
  }
  #photo{
    height: 500px;
    width:100px;
  }
  #preson-info{
    margin-left: 100px;
  }
  #info-area{
    margin: 20px auto;
    margin-left: 100px;
  }
  textarea{

  }
  #update-submit{
    margin-left: 150px;
  }
  </style>
  <body>
  <div  class="bg">
      <span><font size="5">个人资料</font></span>
      <div id="info-area">
        <div id="photo" class="floet-left" ><img   src="${user.photoUrl}" alt="用户头像" /></div>
        <div id="preson-info" class="float-left">
          <form>
            <span class="line-block">用户名<input type="text" value="${user.userName}" ></input></span>
            <span class="line-block">旧密码<input type="text" ></input></span>
            <span class="line-block">新密码<input type="text" ></input></span>
            <span class="line-block">城&nbsp;&nbsp;市<input type="text" value="${user.city.cityName}"></input></span>
            <span class="line-block">邮&nbsp;&nbsp;箱<input type="text" value="${user.email }" ></input></span>
            <span class="line-block">简&nbsp;&nbsp;介<textarea >${user.description }</textarea></span>
            <span class="line-block"> <input id="update-submit" type="submit" value="修改"></input></span>
          </form>
        </div>
      </div>
  </div>
  </body>
</html>
