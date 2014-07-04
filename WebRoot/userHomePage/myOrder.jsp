<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <style>
.float-left{
  float: left;
}
  .line-block{
    display: block;
    padding: 5px;
  }

  #info-area{
    margin: 20px auto;
  }
  .title_1, .title_2,.title_3,.title_4,.title_5 ,.title_6{
    padding: 5px;
    float: left;
    background: #EEEEEE;
  }
  .title_1{
    width: 200px;
  }
  .title_2{
    width: 50px;
  }
  .title_3{
    width: 50px;
  }
  .title_4{
    width: 100px;
  }
  .title_5{
    width: 80px;
  }
  .title_6{
    width: 80px;
  }

  /*订单项*/
.order-item{
  width: 620px;
  border: 1px solid #EEEEEE;
  margin-top: 20px;
  height: 100px;
}
.clear{
  clear: both;
}
.heart-film-info{
  width: 150px;
  margin-left: 10px;
  margin-top: 5px;
}
.price{
  margin-top:20px;
  width: 60px;
  text-align: center;
}
.amount{
  margin-top: 20px;
  width: 60px;
  text-align: center;
}
.totalPrice{
   width: 110px;
   margin-top: 20px;
   text-align: center;
}
.status{
  width: 90px;
  margin-top: 20px;
  text-align: center;
}
.operation{
  margin-top: 5px;
  width: 90px;
}
.operation button{
  width:80px;
  border: none;
}
.operation button:hover{
  background: #0080FF;
}
.order-item-title{
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
      <span><font size="5" color="blue">我的订单</font></span>
      <div id="info-area">
         <div class="title">
            <div class="title_1">团购</div>
            <div class="title_2">单价</div>
            <div class="title_3">数量</div>
            <div class="title_4">订单结算(元)</div>
            <div class="title_5">支付状态</div>
            <div class="title_6">操作</div>
         </div>
         <div class="clear"></div>
         <div class="order-item">
            <span class="order-item-title">订单号: U20111111&nbsp;&nbsp;&nbsp;&nbsp;武汉市洪山区&nbsp;&nbsp;&nbsp;2014-01-01</span>
            <div class="item-info">
                <span ><img class="float-left" width="40px" height="60px" src="../imgs/1.png"></span>
                <div class="float-left heart-film-info" >
                    <span class="line-block">沉睡魔咒</span>
                    <span class="line-block">洪山天河国际影城</span>
                </div>
                <span class="float-left price" >19.99</span>
                <span class="float-left amount">2</span>
                <span class="float-left totalPrice">39.98</span>
                <span class="float-left status">已付款</span>
                <span class="float-left operation">
                     <span><button>评价</button></span>
                     <span><button>申请投诉</button></span>
                </span>
            </div>
            <div class="clear"></div>
            <div class="order-item">
            <span class="order-item-title">订单号: U20111111&nbsp;&nbsp;&nbsp;&nbsp;武汉市洪山区&nbsp;&nbsp;&nbsp;2014-01-01</span>
            <div class="item-info">
                <span ><img class="float-left" width="40px" height="60px" src="../imgs/1.png"></span>
                <div class="float-left heart-film-info" >
                    <span class="line-block">沉睡魔咒</span>
                    <span class="line-block">洪山天河国际影城</span>
                </div>
                <span class="float-left price" >19.99</span>
                <span class="float-left amount">2</span>
                <span class="float-left totalPrice">39.98</span>
                <span class="float-left status">已付款</span>
                <span class="float-left operation">
                     <span><button>评价</button></span>
                     <span><button>申请投诉</button></span>
                </span>
            </div>
            <span>
         </div>
      </div>
  </div>
</body>
</html>
