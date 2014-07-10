
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
<title>订单信息</title>
<script src="./js/jquery.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/common.css">
<link rel="stylesheet" type="text/css" href="./css/orderInfo.css">
</head>
<%
	String groupFlimId = request.getParameter("groupFilmId");
	String filmName= request.getParameter("filmName");
	String cinemaAddress = request.getParameter("cinemaAddress");
	String currentPrice = request.getParameter("currentPrice");
	String amountStr = request.getParameter("amount");
	int amount = Integer.parseInt(amountStr);
	
	float price = Float.parseFloat(currentPrice);
	float totalPrice = amount * price;
 %>
 <script type="text/javascript">
function submitForm (){
    orderForm.submit();
}
function changeAmount(value){
	  document.orderForm.amount.value = value;
	  var price =  $('#s_price').text();
	  $('#t_price').text(value*price);
	  $('#need_pay').text(value*price);
	  document.orderForm.totalPrice.value = value*price;
}
</script>
<body>
    <div id="middle-background">
        <div id="header">
             <div id="banner">
                <span id="logo">团否网</span>
                <span id="username">${sessionScope.userName}</span>
                <span id="exit">退出登录</span>
            </div>
            <img id="logo-img" src="./imgs/logo_tuanfou.png"/>
            <div id="catagory">
                <span id="recommend">推荐</span>
                <span id="shopping">团购首页</span>
                <span id="myTF">我的团否</span>
                <span id="aboutUs">关于团否</span>
            </div>
            <div class="clear"></div>
            <div id="breakline"></div>
        </div>
        <div id="bg">
        	<div class="content">
        	    <span class="cotent-title"><font size="5" color="#BD6037">订单详情</font></span>
	        		<div class="order-item">
	        			<div class="item-title">
		        			<span class="item">团购</span>
		        			<span class="price">单价</span>
		        			<span class="amount">数量</span>
		        			<span class="total-price">总价(元)</span>
		        		</div>
		        		<div class="clear"></div>
						<div class="item-info">
							<span class="item">
								<span class="line-block "><%=filmName  %></span>
								<span class="line-block"><%=cinemaAddress  %></span>
							</span>
		        			<span class="price top-margin" id="s_price"><%=price  %></span>
		        			<span class="amount top-margin"><input type="text" value="<%=amount%>" onkeyup="changeAmount(this.value)"></input></span>
		        			<span id="t_price"class="total-price top-margin"><%=totalPrice %></span>
						</div>
			 
						<div class="clear"></div>
	        		</div>
	        		<div class="cal-price">
	        			   <span class="float-right">您需要支付：￥<span id="need_pay"><%=totalPrice %></span></span>
	        		</div>
					<div class="submit-bt">
						<form name="orderForm" action="OrderAction!addOrder" method="post">
						    <input type="hidden" name="groupFlimId" value="<%=groupFlimId%>"/>
						    <input type="hidden" name="filmName" value="<%=filmName%>"/>
						    <input type="hidden" name="cinemaAddress" value="<%=cinemaAddress%>"/>
						    <input type="hidden" name="currentPrice" value="<%=currentPrice%>"/>
						    <input type="hidden" name="amount" value="<%=amount%>"/>
						    <input type="hidden" name="totalPrice" value="<%=totalPrice%>"/>
							<button  id="submit-order" onclick="javascript:orderForm.submit();">提交订单</button>
						</form>
					</div>
        	<div>
        </div>
        <div class="clear"></div>
    </div>
    </div>
    <div class="site-info">
        
    </div>
   </div>
</body>

</html>



      
        
        