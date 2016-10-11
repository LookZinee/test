<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
	function toadd(){
		window.location="post/add.jsp";
	}
	function check(postid){
		window.location="checkPost.do?id="+postid;
	}
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="list.do">首页</a></li>
    <li><a >基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
 
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>标题</th>
        <th>${post.title }</th>
        </tr>
        <tr>
        <th>内容</th>
         <th>${post.content }</th>
        </tr>
        <tr>
        <th>发帖人</th>
        <th>${post.user.name }</th>
        </tr>
        <tr>
        <th>发布时间</th>
        <th>${post.createtime }</th>
        </tr>

        </thead>
       
    </table>
  
    <table class="tablelist">
    	<c:forEach items="${replys }" var="each" varStatus="vs">
        	<tr>
       	 	<td width="10%">${vs.count }楼</td>
        	<td width="200px">${each.user.name}</td>
        	</tr>
        	<tr>
        	<td></td>
        	<td>${each.content}</td>
        	</tr>
        	</c:forEach>
    </table>
    <br />
   <br />
    <hr />
    <form action="addReply.do" method="post">
    <ul class="forminfo">
    <input type="hidden" name="post.id" value="${post.id }" />
   
    <li><label>
  	<textarea rows="8" onclick="JavaScript:this.value=''" cols="60" name="content" style="border:solid 1px red;margin-left: 80px">发表评论
  	</textarea>
    </li>
    <li> <br/><label>&nbsp;</label><input type="submit" class="btn" value="发表"/></li>
    
    </ul>
    </form>
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
