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
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <form action="signin.do" method="post" enctype="multipart/form-data">
    <ul class="forminfo">
  
    <li><label>用户名</label><input name="name" type="text" class="dfinput" /><i>不能超过30个字符</i></li>
   <li><label>密码</label><input name="pwd" type="text" class="dfinput" /><i>不能超过30个字符</i></li>
  	 
  	 <li><label>上传头像</label><input type="file" name="file"/></li>
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认注册"/></li>
    </ul>
    </form>
    
    </div>


</body>

</html>
