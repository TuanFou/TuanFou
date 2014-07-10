<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>支付失败</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="./js/jquery.js" type="text/javascript"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./css/header.css">
	<link rel="stylesheet" type="text/css" href="./css/common.css">
<style>
.success-info{
    width: 300px;
    margin: 0 auto;
    line-height: 1.5;
}
.return-link{
    margin-top: 30px;
    margin-left: 40px;
}
.success-img img{
    width:40px;
    height: 40px;
    padding: 10px;
    border-radius: 40px;
}
.content{
   min-height: 330px;
   
}
.clear{
    clear: both;
}
#bg{
    padding-bottom: 0px!important;
}
</style>
 </head>
 <script>
 $(function(){
 	/*
	菜单选择
	*/
	$('#myTF').bind('click', function(event) {
		/* Act on the event */
		window.location.href = "UserAction!ShowProfilePage";
	});
	$('#login_TF').bind('click',function(event) {
		/* Act on the event */
		$('#login_link').click();
	});
	$('#login_bt').bind('click',function(event) {
		/* Act on the event */
		$('#login_link').click();
	});
	$('#shopping').bind('click',function(event) {
		/* Act on the event */
		window.location.href = "FilterAction!getFilterTags";
	});
 });
 </script>
 <body>
  <div id="middle-background">
        <div id="header" >
             <div id="banner">
                <span id="logo">团否网</span>
                <c:choose>
                	<c:when test="${empty sessionScope.userName}">
                		<span class="header-login"><a id="login_link"  >登录</a></span>
           	   			<span  class="header-regist"><a  id="reg_link" >注册</a></span>
                	</c:when>
                	<c:otherwise>
                		<span id="username" class="${sessionScope.userId}">${sessionScope.userName}</span>
                		<span id="exit">退出登录</span>
                	</c:otherwise>
                </c:choose>     
                <span id="merchantCenter"><a href="MerchantAction!login">商家中心</a></span> 
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
            <div class="clear"></div>
            <div id="breakline"></div>
        </div>
        <div id="bg">
        	<div class="content">
        	    <div class="success-info">
                    <span class="float-left success-img"><img src="./imgs/finish_fail.png"></img></span>
                    <span class="line-block"><font size="5">订单支付成功</font></span>
                    <span class="line-block">可在"我的订单"中查看订单</span>
                    <div class="return-link">
                        <span><a href="UserAction!ShowProfilePage">我的订单</a></span> |
                        <span><a href="FilterAction!getFilterTags">团购首页</a></span>
                    </div>
                </div>
                <div class="clear"></div>
        	</div>
            
            <div class="site-info">
            
            </div>
        </div>
        
    </div>
 </body>
</html>
