<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">发帖</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <form action="addPost.do" method="post">
    <ul class="forminfo">
    <li><label>标题</label><input name="title" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
    <li><label>内容  
  	<textarea rows="8" cols="60" name="content" style="border:solid 1px red;margin-left: 80px"></textarea>
    </li>
    <li> <br/><label>&nbsp;</label><input type="submit" class="btn" value="发表"/></li>
    
    </ul>
    </form>
    
    </div>


</body>

</html>
