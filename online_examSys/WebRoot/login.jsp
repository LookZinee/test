<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>Slick Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://www.modernizr.com/downloads/modernizr-latest.js"></script>
<script type="text/javascript" src="javascripts/placeholder.js"></script>
</head>
<body>
	<form id="slick-login" action="stulogin.action">
		<label for="username">username</label>
		<input type="text"
			name="student.name" class="placeholder" placeholder="me@tutsplus.com">
		<label for="password">password</label><input type="password"
			name="student.pwd" class="placeholder" placeholder="password">
			<br/>
			<select name="student.role" style="width: 200px">
				<option value="0">学生</option>
				<option value="1">老师</option>
			</select>
			 <input
			type="submit" value="Log In">
	</form>
</body>
</html>