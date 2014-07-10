<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'apply.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style>
  .floet-left{
    float:left;
  }
  .line-block{
    display: block;
    padding: 2px;
  }
  #photo{
    height: 400px;
    width:200px;
    text-align: center;
    margin-right: 20px;
  }
  #photo img {
    width:130px;
    height:180px;
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
<script>
function FileUploadOnselect(){
    //alert(document.applyform.filmFile.value);
}
</script>
 
</head>
  <body>
    <div  class="bg">
      <span><font size="5">申请发布</font></span>
      <div id="info-area">
        <form name="applyform" method="post" action="GroupFilmAction!applyGroupFilm" enctype="multipart/form-data">
        <div id="photo" class="floet-left" >
          <img   id="uploadImg" src="/TuanFou/imgs/1.png" alt="上传图片" />
           <input type="file" name="filmFile" onchange="return FileUploadOnselect()"></input>
        </div>
        <div id="preson-info" class="float-left">
            <span class="line-block">电&nbsp;&nbsp;&nbsp;&nbsp;影&nbsp;&nbsp;&nbsp;
            	<select name="groupFilmForm.filmId">
            	 	<c:forEach items="${filmList}" var="info">
            			<option value="${info.id }">${info.filmName }</option>
            	  </c:forEach>
            	</select>
            </span>
            <span class="line-block">电&nbsp;&nbsp;影&nbsp;&nbsp;院&nbsp;
                <select name="groupFilmForm.cinemaId">
                  <c:forEach items="${cinemaList}" var="info">
                   <option value="${info.id}">${info.cinemaName }</option>
                  </c:forEach>
                </select>
            </span>
            <span class="line-block" >开始时间&nbsp;&nbsp;&nbsp;&nbsp;<input placeholder="2014-07-10" name="groupFilmForm.startDate" type="text" ></input></span>
            <span class="line-block" >结束日期&nbsp;&nbsp;&nbsp;&nbsp;<input placeholder="2014-07-15" name="groupFilmForm.endDate" type="text" ></input></span>
            <span class="line-block" >单价&nbsp;/原价&nbsp;&nbsp;<input name="groupFilmForm.currentPrice" type="text" ></input></span>
            <span class="line-block" >单价&nbsp;/现价&nbsp;&nbsp;<input name="groupFilmForm.originalPrice" type="text" ></input></span>
            <span class="line-block"  >电影类型&nbsp;&nbsp;&nbsp; 
              <select name="groupFilmForm.type">
                <option value="0">正在上映</option>
                <option value="1">即将上映</option>
              </select>
            </span>
            <span class="line-block">备注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <textarea type="text"  name="groupFilmForm.remark"></textarea></span>
            <span class="line-block"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="update-submit" type="submit" value="发布"></input></span>
          </form>
        </div>
      </div>
  </div>
  </body>
</html>
