<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		
	<title>首页</title>
	<link rel="stylesheet" type="text/css" href="./css/common.css">
	<link rel="stylesheet" type="text/css" href="./css/groupFilmInfo.css">
	<script src="./js/jquery.js" type="text/javascript"></script>
  </head>
  
  <body>
   <div id="header"></div>
<div id="bg">
	<div id="main-left">
		<div class="groupfilm-info">
			<div class="groupfilm-img float-left "><img src="./imgs/1.png"/></div>
			<div class="top-info">
				<span class="float-left price-area">￥<span class="light-text-51">${groupFilmDetailInfo.currentPrice}</span>元</span>
				<span class="float-left join-group">入伙(${groupFilmDetailInfo.partnerNum})</span>
				<div class="float-left ">
					<span class="bg-blue line-block" >3D/IMAX3D/中国巨幕</span>
					<span class="bg-blue line-block">${groupFilmDetailInfo.cinemaName}</span>
				</div>
			</div>
			<div class="detial-info float-left">
				<span class="line-block">商家：${groupFilmDetailInfo.cinemaAddress} | 查看电话/地址</span>
				<span class="line-block"> 有限期：截止到 ${groupFilmDetailInfo.endDate} 周末法定假日有效</span>
				<span class="line-block" >使用时间: 10:00-24:00</span>
				<hr>
				<span class="line-block font-20" >
					<span>已售${groupFilmDetailInfo.orderNum} </span>
					<span class="comment-star">*****${groupFilmDetailInfo.groupfilmStar}</span>
					<span class="float-right">${groupFilmDetailInfo.commentNum}人评价</span>
				</span>
				<span class="line-block font-20 ">
					<span class="float-right"><button>购买</button></span>
					<span class="float-right"><input type="text"  ></input></span>
					<span class="float-right">数量</input>
				</span>
			</div>
		</div>	
		<div class="clear"></div>
		<div class="film-info">
			<div class="float-left film-star-info ">
				<span class="line-block">电影评分：</span>
				<span class="line-block">&nbsp&nbsp&nbsp********${groupFilmDetailInfo.filmStar}</span>
				<span class="line-block">我要评分：</span>
				<span class="line-block">&nbsp&nbsp&nbsp********</span>
			</div>
			<div class="float-left film-introduce">
				<span class="line-block blue-font">剧情介绍</span>
				<span>${groupFilmDetailInfo.description}……<a href="#">详细</a></span>
			</div>
		</div>
		<div class="clear"></div>
		<div id="nav-menu-area">
			<ul class="menu-style nav-menu">
				<li class="selected-menu">等你入伙</li>
				<li>商家信息</li>
				<li>购买须知</li>
				<li>评价详情</li>
			</ul>
		</div>
		<div class="ads-area  clear"></div>
		<span  id="parter-title" class="line-block"><font size="4">等你入伙</font></span>
		<div id="parter-info">	
			<div class="float-left waiting-parter-film">
				<span><img class=" float-left relative-film-img" src="./imgs/1.png"></img></span>
				<div class="float-left parter-film-info">
					<span class="line-block parter-film-name">沉睡的魔谷</span>
					<span class="line-block parter-film-cinema">洪山国际影城</span>
					<span class="line-block parter-film-wn">
						 <font size="25">200</font>人  等待中
					</span>
					<span class="line-block parter-film-addr"><font size="0">地址：洪山区珞瑜路6号乐天购物中心6楼(群光广场旁)</font></span>
				</div>
			</div>
			<div class="float-left invite-area">
				<span><font color="blue" size="2">已入伙(200)</font></span>
				<ul class="parter-list">
					<li>kdf5000 <a class="float-right" href="#">发送邀请</a></li>
					<li>kdf5000 <a class="float-right" href="#">发送邀请</a></li>
					<li>kdf5000 <a class="float-right" href="#">发送邀请</a></li>
					<li>kdf5000 <a class="float-right" href="#">发送邀请</a></li>
					<li>kdf5000 <a class="float-right" href="#">发送邀请</a></li>
				</ul>
				<span class="float-right" id="change-parters"><font size="1"><a href="#">换一批</a></font></span>
			</div>
		</div>
		<div class="clear"></div>
		<div id="merchant-info">
			<span class="merchant-info-title line-block"><font size="4" color="blue">商家信息</font></span>
			<div id="merchant-detial-info">
				<div id="map" class="float-left">
					
				</div>
				<div id="merchant-info-area" class="float-left">
					<span class="line-block">洪山天河国际影院</span>
					<span class="line-block">商家累计评分</span>
					<span class="line-block">地址：洪山区珞瑜路6号乐天城购物中心6楼(群光广场旁)</span>
					<span class="line-block">查看地图公交/驾车到这里去</span>
					<span class="line-block">地铁：距街道口站约140米</span>
					<span class="line-block">电话：027-87882649-805</span>
				</div>
			</div>
		</div>
		<div id="buying-notice">
			<span class="notice-info-title line-block"><font size="4" color="blue">购买须知</font></span>
			<div class="notice-detail">
				<table id="notice-info-table">
					<tr>
						<td class="left-title">有效期</td>
						<td>2013.9.30 至 2014.7.31（周末、法定节假日通用）</td>
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
			<span class="comment-info-title line-block">
				<font size="4" color="blue">商家信息</font>
				<span class="float-right" ><a href="#"><font size="1">我要评价</font></a></span>
			</span>
			<div class="float-left comment-left">
				<span class="line-block"> <font size="20" color="blue">9.4</font>&nbsp分</span>
				<span class="line-block">*******</span>
				<span class="line-block">半年内共<font color="red" size="5">100</font>人评价</span>
			</div>
			<div class="float-left comment-mid">
				<span class="line-block">试听效果&nbsp<span>******  9.4</span></span>
				<span class="line-block">&nbsp&nbsp&nbsp&nbsp服务&nbsp<span>******  9.4</span></span>
				<span class="line-block">&nbsp&nbsp&nbsp&nbsp环境&nbsp<span>******  9.4</span></span></span>
				<span class="line-block">位置交通&nbsp<span>******  9.4</span></span>
			</div>
			<div class="float-left comment-right">					
				 <span class="line-block">5分<span class="five-grade"><img src="./imgs/fiveStar.png"></img></span><span class="float-right">100人</span> </span>
				 <span class="line-block">5分<span class="four-grade"><img src="./imgs/fiveStar.png"></img></span><span class="float-right">100人</span> </span>
				 <span class="line-block">5分<span class="three-grade"><img src="./imgs/fiveStar.png"></img></span><span class="float-right">100人</span> </span>
				 <span class="line-block">5分<span class="two-grade"><img src="./imgs/fiveStar.png"></img></span><span class="float-right">100人</span> </span>
				 <span class="line-block">5分<span class="one-grade"><img src="./imgs/fiveStar.png"></img></span><span class="float-right">100人</span> </span>
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
					<font color="#9C9C9C">全部评价</font>
					<span class="float-right"><a href="#">默认</a> | <a href="#">按时间</a></span>
				</span>
				<div class="comments-centent">
					<div class="comment">
						<span>kdf5000</span>
						<span>2014-6-30 18:00:00</span>
						<span class="float-right">*****4.5分</span>
						<span class="line-block content">
							之前就在乐天西园店看过好多次啦！今天看得下午1点半4号厅的变形金刚～喜欢银兴乐天西园店的环境和影厅～人不多，厅也大～效果也很好～推荐大家去哟～
						</span>
					</div>
					<div class="comment">
						<span>kdf5000</span>
						<span>2014-6-30 18:00:00</span>
						<span class="float-right">*****4.5分</span>
						<span class="line-block content">
							之前就在乐天西园店看过好多次啦！今天看得下午1点半4号厅的变形金刚～喜欢银兴乐天西园店的环境和影厅～人不多，厅也大～效果也很好～推荐大家去哟～
						</span>
					</div>
					<div class="comment">
						<span>kdf5000</span>
						<span>2014-6-30 18:00:00</span>
						<span class="float-right">*****4.5分</span>
						<span class="line-block content">
							之前就在乐天西园店看过好多次啦！今天看得下午1点半4号厅的变形金刚～喜欢银兴乐天西园店的环境和影厅～人不多，厅也大～效果也很好～推荐大家去哟～
						</span>
					</div>
					<div class="comment">
						<span>kdf5000</span>
						<span>2014-6-30 18:00:00</span>
						<span class="float-right">*****4.5分</span>
						<span class="line-block content">
							之前就在乐天西园店看过好多次啦！今天看得下午1点半4号厅的变形金刚～喜欢银兴乐天西园店的环境和影厅～人不多，厅也大～效果也很好～推荐大家去哟～
						</span>
					</div>
					<div class="loadMore">加载更多</div>
				</div>
			</div>
		</div>
	</div>
	<div id="main-right">
		<div id="main-right-title"></div>
		<div id="group-range">
			<div class="range-item">
				<span class="range-num float-left">1</span>
				<span class="range-film-img"><img src="./imgs/1.png"></img></span>
				<div class="float-left range-item-info">
					<span class="line-block"><img ></img>伙影</span>
					<span class="line-block">沉睡的魔谷</span>
					<span class="line-block">洪山天河国际影城</span>
					<span class="line-block"><font size="3">200</font>人已经入伙</span>
					<span class="line-block float-right"><a href="#">我要入伙</a></span>
				</div>
			</div>
			<div class="range-item">
				<span class="range-num float-left">2</span>
				<span class="range-film-img"><img src="./imgs/1.png"></img></span>
				<div class="float-left range-item-info">
					<span class="line-block"><img ></img>伙影</span>
					<span class="line-block">沉睡的魔谷</span>
					<span class="line-block">洪山天河国际影城</span>
					<span class="line-block"><font size="3">200</font>人已经入伙</span>
					<span class="line-block float-right"><a href="#">我要入伙</a></span>
				</div>
			</div>
			<div class="range-item">
				<span class="range-num float-left">3</span>
				<span class="range-film-img"><img src="./imgs/1.png"></img></span>
				<div class="float-left range-item-info">
					<span class="line-block"><img ></img>伙影</span>
					<span class="line-block">沉睡的魔谷</span>
					<span class="line-block">洪山天河国际影城</span>
					<span class="line-block"><font size="3">200</font>人已经入伙</span>
					<span class="line-block float-right"><a href="#">我要入伙</a></span>
				</div>
			</div>
			<div class="range-item">
				<span class="range-num float-left">4</span>
				<span class="range-film-img"><img src="./imgs/1.png"></img></span>
				<div class="float-left range-item-info">
					<span class="line-block"><img ></img>伙影</span>
					<span class="line-block">沉睡的魔谷</span>
					<span class="line-block">洪山天河国际影城</span>
					<span class="line-block"><font size="3">200</font>人已经入伙</span>
					<span class="line-block float-right"><a href="#">我要入伙</a></span>
				</div>
			</div>
			<div class="range-item">
				<span class="range-num float-left">5</span>
				<span class="range-film-img"><img src="./imgs/1.png"></img></span>
				<div class="float-left range-item-info">
					<span class="line-block"><img ></img>伙影</span>
					<span class="line-block">沉睡的魔谷</span>
					<span class="line-block">洪山天河国际影城</span>
					<span class="line-block"><font size="3">200</font>人已经入伙</span>
					<span class="line-block float-right"><a href="#">我要入伙</a></span>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="clear"></div>
<div class="site-info">
	
</div>
  </body>
</html>
