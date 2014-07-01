<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/common.css">
<link rel="stylesheet" type="text/css" href="./css/payInfo.css">
</head>
<body>
    <div id="middle-background">
        <div id="header">
             <div id="banner">
                <span id="logo">团否网</span>
                <span id="username">KDF5000</span>
                <span id="exit">退出登录</span>
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
        	<div class="content">
        	    <span class="cotent-title"><font size="5" color="#BD6037">付款</font></span>
        		<div class="order-item">
        		  <table>
                    <tr>
                        <td class="bg-color"> 订单号</td>
                        <td> ${requestScope.orderId} </td>
                    </tr>
                     <tr>
                        <td class="bg-color"> 团购</td>
                        <td> 
                            <span class="line-block"> ${requestScope.filmName }</span>
                            <span class="line-block">${requestScope.cinemaAddress }</span>
                        </td>
                    </tr>
                     <tr>
                        <td class="bg-color"> 单价(元)</td>
                        <td> ${requestScope.currentPrice }</td>
                    </tr>

                     <tr>
                        <td class="bg-color"> 数量</td>
                        <td>${requestScope.amount }</td>
                    </tr>
                     <tr>
                        <td class="bg-color"> 总价(元)</td>
                        <td>${requestScope.totalPrice }</td>
                    </tr>
                  </table>
                </div>
                <form name="payForm" action="OrderAction!payOrder" method="post">
                	<input type="hidden" name="orderId" value="${requestScope.orderId }"/>
	                <div class="account-info">
	                    <span class="line-block">账户余额:${requestScope.balance }元</span>
	                    </span class="line-block">您需为订单支付：￥${requestScope.totalPrice }</span>
	                    <span><button class="line-block float-right" onclick="javascript:payForm.submit()">付款</button></span>
	                </div>
                </form>
        	<div>
        </div>
        <div class="clear"></div>
<!--         <div class="site-info">
            
        </div> -->
    </div>
</body>
</html>
