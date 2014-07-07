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
	<link rel="stylesheet" type="text/css" href="./css/profile.css">
    <script src="./js/jquery.js" type="text/javascript"></script>
    <script src="./js/userHome.js" type="text/javascript"></script>
  </head>
  
  <body>
    <div id="header"></div>
	<div id="bg">
		<div id="main-left">
     	    <div id="menu-up">
            	<div id="personalData">
                    <span ><img id="photo" src="${user.photoUrl}" alt="用户头像" /></span>
                    <div id="data" >
                    	<span class="line-block"><font size="5">${user.userName }</font></span>
                    </div>
                </div>
                <div class="float-left" id="account-info">
                    <span class="line-block" ><font size="4">余额 ${user.account.balance}</font></span>
                    <span class="line-block"  ><button id="add-balance">充值</button></span>
                </div>
            </div>
            <div id="menu-bottom">
                    <ul>
                        <li id="my-groupFilm" class="current-select" >我的团否</li>
                        <li id="my-heartfilm">我的伙影</li>
                        <li id="my-order">我的订单</li>
                        <li id="my-comment">我的评论</li>
                        <li id="my-message">我的消息</li>
                        <li id="my-complaint">我的投诉</li>
                    </ul>
            </div>
    	</div>
    	<div id="main-right">
    			<iframe id="detail-info" src=""  ></iframe>
    	</div>
    </div>
	<div class="clear"></div>
	<div class="site-info">

	</div>
  </body>
</html>
