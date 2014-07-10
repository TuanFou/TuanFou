<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		
	<title>电影详情</title>
	<link rel="stylesheet" type="text/css" href="./css/common.css">
	<link rel="stylesheet" type="text/css" href="./css/groupFilmInfo.css">
	<link rel="stylesheet" type="text/css" href="./css/header.css">
	<link rel="stylesheet" type="text/css" href="./css/reg_log.css">
	<link rel="stylesheet" type="text/css" href="./css/star.css">
	<script src="./js/jquery.js" type="text/javascript"></script>
	<script type="text/javascript" src="./js/tinybox.js"></script>
	<script type="text/javascript" src="./js/groupFilmInfo.js"></script>
	<script src="./js/reg_login.js" type="text/javascript"></script>
	<script src="./js/star.js" type="text/javascript"></script>
</head>
<style type="text/css">

#tinybox{position:absolute; display:none; /*padding:10px*/; background:#ffffff url(image/preload.gif) no-repeat 50% 50%; border:10px solid #e3e3e3; z-index:2000;}
#tinymask{position:absolute; display:none; top:0; left:0; height:100%; width:100%; background:#000000; z-index:1500;}
#tinycontent{background:#ffffff; font-size:1.1em;}
#joinGroup:hover {
	cursor: pointer;
}
</style>
<script type="text/javascript">
function registClick(){
	$('#reg_link').click();
}
function loginSubmit(obj){
 	var userName = loginForm.userName.value;
 	var password = loginForm.password.value;
 	if(userName=='' || password ==''){
 		alert('用户名和密码不能为空');
 		return;
 	}

	$.ajax({
		//alert(userName);
	 	url: 'UserAction!login',
	 	//data:{"userName":userName, "password":password},
	 	type: 'get',
	 	datatype:'json',
	 	data:{'userName':userName,'password':password},
	 	success:function(data){
	 		if(data=="success"){//登录成功
	 			window.location.reload();
	 		}else{
	 			alert('请检查用户名和密码是否正确');
	 		}
	 	},
	 	error:function(error) {
	 		/* Act on the event */
	 		alert(error);
	 	}
	}); 
 }
function regSubmit(obj){
	var userName = regForm.userName.value;
	var password = regForm.password.value;
	var confirm_password = regForm.confirm_password.value;
	var cityId = regForm.citySelector.value;
	var email = regForm.email.value;
	var description = regForm.description.value;
	if(password != confirm_password)
	{
		alert('两次密码不一致');
		return ;
	}
	$.ajax({
		url: 'UserAction!regist',
		type: 'get',
		data: {'userName': userName,'password':password,'cityId':cityId,'email':email,'description':description},
		success:function(data){
			window.location.reload();
		},
		error:function(error){
			for(var index in error){
				alert(error[index]);
			}
		}
	});
 }
 function addComment(){
 		if($("#username").length==0){
			$('#login_link').click();
			return ;
		}
 }
</script>
<body>
	<div id="middle-background">
        <div id="header">
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
		<!--购票窗口*/ -->
		<!--购票窗口*/ -->
		<div id="hidden">
			<div class="buying-info">
				<form name="groupFilmForm" method="post" action="orderInfo.jsp">
					<input name="groupFilmId" type="hidden" value="${groupFilmDetailInfo.groupFilmId}" /> 
					<input name="filmName" type="hidden" value="${groupFilmDetailInfo.filmName}" /> 
					<input name="cinemaAddress" type="hidden" value="${groupFilmDetailInfo.cinemaAddress}" /> 
					<input name="currentPrice" type="hidden" value="${groupFilmDetailInfo.currentPrice}" /> 
					<span class="line-block">商家：${groupFilmDetailInfo.cinemaAddress} | 查看电话/地址</span>
					<span class="line-block"> 有限期：截止到 ${groupFilmDetailInfo.endDate} 周末法定假日有效</span>
					<span class="line-block" >使用时间: 10:00-24:00</span>
					<hr>
					<span class="line-block font-20" >
						<span>已售${groupFilmDetailInfo.orderNum} </span>
						<span class="comment-star"><img class="star-img" src="./imgs/star/${groupFilmDetailInfo.groupfilmStar}.png"/>${groupFilmDetailInfo.groupfilmStar}</span>
						<span class="float-right">${groupFilmDetailInfo.commentNum}人评价</span>
					</span>
					<span class="line-block font-20 ">
						<span class="float-right"><input type="submit" value="购买"></input></span>
						<span class="float-right"><input type="text" name="amount" ></input></span>
						<span class="float-right">数量</input>
					</span>
				</form>
			</div> 
		</div>
		
		<div id="main-left">
			<div class="groupfilm-info">
				<div class="film-img float-left ">
					<img src="${groupFilmDetailInfo.photpUrl}"/>
					<c:choose>
                		<c:when test="${empty sessionScope.userId}">
                			<button id="login_bt">购买</button>
                		</c:when>
                		<c:otherwise>
                			<button id="buying_bt">购买</button>
                		</c:otherwise>
               		 </c:choose>  
				</div>
				<div class="top-info">
					<span class="float-left price-area"><font size="1" family="微软雅黑" color="#613b3a">￥</font><span class="light-text-51">${groupFilmDetailInfo.currentPrice}</span><font size="1" family="微软雅黑" color="#613b3a">元</font></span>
					<span class="float-left join-group" id="joinGroup">入伙(${groupFilmDetailInfo.partnerNum})</span>
					<div class="">
						<span class="float-left bg-blue" >3D/IMAX3D/中国巨幕</span>
						<span class="float-left bg-blue line-block">${groupFilmDetailInfo.cinemaName}</span>
					</div>
				</div>
				<div class="detial-info float-left" id="${groupFilmDetailInfo.groupFilmId}">
					<span class="line-block line-block-infoName"><font size="5"> ${groupFilmDetailInfo.filmName}</font></span>
					<span class="line-block line-block-infoTime"><font size="3">${groupFilmDetailInfo.period}分钟&nbsp&nbsp&nbsp;${groupFilmDetailInfo.realeaseDate}中国上映</font></span>
					<span class="line-block line-block-crew" >导演：${groupFilmDetailInfo.director}</span>
					<span class="line-block line-block-crew" >主演：罗伯特·斯托姆伯格</span>
					<span class="line-block line-block-crew" >标签：${groupFilmDetailInfo.tags}</span>
				</div>
			</div>	
			<div class="clear"></div>
			<div class="film-info">
				<div class="float-left film-star-info ">
					<span class="line-block">电影评分：</span>
					<span class="line-block">&nbsp&nbsp&nbsp<img class="star-img" src="./imgs/star/${groupFilmDetailInfo.groupfilmStar}.png"/>${groupFilmDetailInfo.filmStar}</span>
					<span class="line-block">我要评分：</span>
					<span class="line-block">&nbsp&nbsp&nbsp<img class="star-img" src="./imgs/star/2.png"/></span>
				</div>
				<div class="float-left film-introduce">
					<span class="line-block blue-font">剧情介绍</span>
					<span id="film-content">${groupFilmDetailInfo.description}</span>
				</div>
			</div>
			<div class="clear"></div>
			<div id="nav-menu-area">
				<ul class="menu-style nav-menu">
					<li id="wait-join-menu"class="selected-menu">等你入伙</li>
					<li id="mechant-info-menu" >商家信息</li>
					<li id="buying-info-menu">购买须知</li>
					<li id="comment-info-menu">评价详情</li>
				</ul>
			</div>
			<div class="ads-area  clear"><img class="ads-area" src="./imgs/ad_small.png"></div>
			<span parter-title class="line-block parter-title"><font size="4">等你入伙</font></span>
			<div id="parter-info">	
				<div class="float-left waiting-parter-film">
					<span><img class=" float-left relative-film-img" src="./imgs/1.png"></img></span>
					<div class="float-left parter-film-info">
						<span class="line-block parter-film-name">${groupFilmDetailInfo.filmName}</span>
						<span class="line-block parter-film-cinema">${groupFilmDetailInfo.cinemaName}&nbsp&nbsp</span>
						<span class="line-block parter-film-wn">
							 <font size="+3" family="Eras Demi ITC" color="#ffff00" >${groupFilmDetailInfo.partnerNum}</font><font family="黑体" size="-1" color="#ddbf49">人</font><font size="-1" color="#ddbf49">正在等待...</font>
						</span>
						<span class="line-block parter-film-addr"><font size="0">地址：${groupFilmDetailInfo.cinemaAddress}</font></span>
					</div>
				</div>
				<div class="float-left invite-area">
					<span><font family="微软雅黑" size="3" color="#bd6037">已入伙(${groupFilmDetailInfo.partnerNum})</font></span>
					<ul class="parter-list">
					 <c:forEach items="${invitedMembers}" var="info">
						<li id="user_${info.userId}">${info.userName} <a class="float-right" href="#">发送邀请</a></li>
					 </c:forEach> 
					</ul>
					<span class="float-right" id="change-parters"><font size="1" ><a href="#">换一批</a></font></span>
				</div>
			</div>
			<div class="clear"></div>
			<div id="merchant-info">
				<span class="merchant-info-title line-block parter-title"><font size="4" >商家信息</font></span>
				<div id="merchant-detial-info">
					<div id="map" class="float-left">
						<img src="./imgs/map.jpg"/>
					</div>
					<div id="merchant-info-area" class="float-left">
						<span class="line-block line-block-cinemaName">${groupFilmDetailInfo.cinemaName}</span>
						<span class="line-block line-block-content">商家累计评分</span>
						<span class="line-block line-block-content">地址：${groupFilmDetailInfo.cinemaAddress}</span>
						<span class="line-block line-block-content">查看地图公交/驾车到这里去</span>
						<span class="line-block line-block-content">地铁：距街道口站约140米</span>
						<span class="line-block line-block-content">电话：${groupFilmDetailInfo.phoneNum}</span>
					</div>
				</div>
			</div>
			<div id="buying-notice">
				<span class="notice-info-title line-block parter-title"><font size="4">购买须知</font></span>
				<div class="notice-detail">
					<table id="notice-info-table">
						<tr>
							<td class="left-title">有效期</td>
							<td>${groupFilmDetailInfo.startDate}  至 ${groupFilmDetailInfo.endDate}（周末、法定节假日通用）</td>
						</tr>
						<tr>
							<td class="left-title">使用时间</td>
							<td>10:00-24:00</td>
						</tr>
						<tr>
							<td class="left-title">提醒预约</td>
							<td>无需预约，消费高峰可能需要等位</td>
						</tr>
						<tr>
							<td class="left-title">其他优惠</td>
							<td>凭团否券到店消费不可同时享受店内其他优惠</td>
						</tr>
						<tr>
							<td class="left-title">使用规则</td>
							<td>
								<ul>
									<li>每人每天限兑换当天电影票8张</li>
									<li>团购用户到店后，需兑换成团购券再进行购票</li>
									<li>每张美团券限1人观影1场</li>
									<li>每张美团券仅限兑换观影当日场次电影票</li>
									<li>配备3D眼镜，3D眼镜无需押金，影片结束退还即可，如有损坏，需按价赔偿</li>
									<li>1.3米（含）以下儿童在成人陪同下可免费观看2D电影，无座位，且每位成人限带1名免费儿童。1.3米（不含）以上儿童无优惠，3D和4D影片所有儿童均需购票入场</li>
									<li>现场选座，见面会/VIP厅观影/情侣座/首映式不可用</li>
									<li>所有影片上映时间以影院为准</li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="comment-info">
				<span class="comment-info-title line-block parter-title">
					<font size="4" >商家信息</font>
					<span class="float-right" ><a href="#myComment"><font size="2" color="#bd6037">我要评价</font></a></span>
				</span>
				<div class="float-left comment-left">
					<span class="line-block"> <font size="18" color="#bd6037">${groupFilmDetailInfo.groupfilmStar}</font>&nbsp分</span>
					<span class="line-block"><img class="star-img" src="./imgs/star/${groupFilmDetailInfo.groupfilmStar}.png"/></span>
					<span class="line-block link-block-comment">半年内共<font color="#bd6037" size="5">${groupFilmDetailInfo.commentNum}</font>人评价</span>
				</div>
				<div class="float-left comment-mid">
					<span class="line-block link-block-comment">试听效果&nbsp<span><img class="star-img" src="./imgs/star/2.png"/> 5.0</span></span>
					<span class="line-block link-block-comment">&nbsp&nbsp&nbsp&nbsp服务&nbsp;&nbsp;<span><img class="star-img" src="./imgs/star/2.png"/> 5.0</span></span>
					<span class="line-block link-block-comment">&nbsp&nbsp&nbsp&nbsp环境&nbsp&nbsp;<span><img class="star-img" src="./imgs/star/2.png"/>5.0</span></span></span>
					<span class="line-block link-block-comment">位置交通&nbsp<span><img class="star-img" src="./imgs/star/2.png"/>  5.0</span></span>
				</div>
				<div class="float-left comment-right">					
					 <span class="line-block link-block-Pcomment">5分<span class="five-grade"><img src="./imgs/fiveStar.png"></img></span><span class="float-right">100人</span> </span>
					 <span class="line-block link-block-Pcomment">5分<span class="four-grade"><img src="./imgs/fiveStar.png"></img></span><span class="float-right">100人</span> </span>
					 <span class="line-block link-block-Pcomment">5分<span class="three-grade"><img src="./imgs/fiveStar.png"></img></span><span class="float-right">100人</span> </span>
					 <span class="line-block link-block-Pcomment">5分<span class="two-grade"><img src="./imgs/fiveStar.png"></img></span><span class="float-right">100人</span> </span>
					 <span class="line-block link-block-Pcomment">5分<span class="one-grade"><img src="./imgs/fiveStar.png"></img></span><span class="float-right">100人</span> </span>
				</div>
				<div class="clear"></div>
				<div class="comment-type">
					<div class="type-title">大家都在说</div>
					<ul class="type">
						<li>全部</li>
						<li>环境不错(20)</li>
						<li>视觉效果不错(20)</li>
						<li>交通方便(20)</li>
						<li>位置好找(20)</li>
						<li>性价比高(20)</li>
						<li>音响效果不错(20)</li>
						<li>额外收费(20)</li>
					</ul>
				</div>
				<div class="clear"></div>
				<div id="all-comments">
					<span class="line-block comments-title">
						<font color="#9C9C9C" size="1">全部评价</font>
						<span class="float-right"><a href="#">默认</a> | <a href="#">按时间</a></span>
					</span>
					<div class="comments-centent">
					   <c:forEach items="${commentList}" var="info">
						  <div class="comment">
							<span class=" mark-red">${info.userName}</span>
							<span class=" mark-red">${info.date}</span>
							<span class="float-right mark-red"><img class="star-img" src="./imgs/star/${info.star}.png"/>${info.star}分</span>
							<span class="line-block content">
								 ${info.content}
							</span>
					 	  </div> 
					   </c:forEach>
						<div id="myComment" class="add-comment">
						    <span>我要评价
								 <span class="star-holder">
								 	<a class="i-rate"></a>
								 	<a class="i-rate"></a>
								 	<a class="i-rate"></a>
								 	<a class="i-rate"></a>
								 	<a class="i-rate"></a>
								 </span>
						    </span> 
							<form name="commentForm" method="post" action="#">
								<input name="star" class="star-value" vlaue="" type="hidden"/>
							    <input name="userId" type="hidden" value="${sessionScope.userId}"/>
							    <input name="groupFilmId" type="hidden" value="${groupFilmDetailInfo.groupFilmId}"/>
								<textarea rows="5" cols="75" name="myComment">
									
								</textarea>
							</form>
								<button id="addComment">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="main-right">
            <img src="./imgs/recommend.png">
			<div id="group-range">
                <!-- <div class="range-item range-item-last">
					<span class="range-num float-left">8</span>
					<div class="float-left range-item-info">
						<span class="line-block line-block-film">沉睡的魔谷</span>
						<span class="line-block line-block-cinema">洪山天河国际影城</span>
						<span class="line-block line-block-join">已入伙&nbsp<font size="2" color="#BD5F37">200</font></span>
					</div>
				</div> -->
		</div>
	</div>
	<div class="clear"></div>
	<div class="site-info">
		
	</div>
</body>
<script type="text/javascript">
		var hiddenText = $('#hidden').html();
        var content2 = "<div class='buying-info'>"+
                    "<span class='line-block'>商家：天河剧院天河剧院天河剧院天河剧院天河剧院| 查看电话/地址</span>"+
                    "<span class='line-block'> 有限期：截止到  周末法定假日有效</span>"+
                    "<span class='line-block'>使用时间: 10:00-24:00</span>"+
                    "<hr>"+
                    "<span class='line-block font-20' >"+
                        "<span>已售1000 </span>"+
                        "<span class='comment-star'>*****5</span>"+
                        "<span class='float-right'>200人评价</span>"+
                    "</span>"+
                    "<span class='line-block font-20'>"+
                        "<span class='float-right'><button>购买</button></span>"+
                        "<span class='float-right'><input type='text'  ></input></span>"+
                        "<span class='float-right'>数量</input>"+
                   " </span></div>  ";//弹出图片
        T$('buying_bt').onclick = function(){TINY.box.show(hiddenText,0,0,0,1)};
        /*购买商品，下订单*/
    </script>
<script>
 /*星星*/
 function count() {
    var num = $('.star-holder>.i-rate-hover-click').length;
    $('.star-value').attr("value", num);
}


	for (i = 0; i < 5; i++) {
		before();
		change(i);
		after(i);
	}
    function change(i) {
        $('.star-holder>.i-rate:eq(' + i + ')').mouseover(function () {
            $('.star-holder>a:lt(' + (i + 1) + ').i-rate').attr("class", "i-rate-hover");
        });
    }

    function after(i) {
        $('.star-holder>a:eq(' + i + ')').click(function () {
            $('.star-holder>a:lt(' + (i + 1) + ')').attr("class", "i-rate-hover-click");
            $('.star-holder>a:gt(' + i + ')').attr("class", "i-rate");
            count();
            return false;
        });
    }

    function before() {
        $('.star-holder').mouseout(function () {
            $('.star-holder >.i-rate-hover').attr("class", "i-rate");
        });
    }
</script>
</html>
