<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'kaoshi.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		td{
			height: 30px;
		}
	</style>
  </head>
  
  <body style="text-align: center">
  	<font size="7">试题</font> 
  		<form action="sturesult.action" method="post">
   		<table>
   			<c:forEach items="${result.xiangqings }" var="each" varStatus="num">
   				<tr>
   					<td colspan="4">${num.count }、${each.question.title }</td>
   				 </tr>
   				 <tr>
   					<td>
   					<input type="radio" name="question${each.id }" value="A">
   					<font color="red">A、 ${each.question.optiona }</font></td>
   					<td><input type="radio" name="question${each.id }" value="B">
   					<font color="green">B、 ${each.question.optionb  }</font></td>
   					<td><input type="radio" name="question${each.id }" value="C">
   					<font color="orange">C、${each.question.optionc  }</font> </td>
   					<td><input type="radio" name="question${each.id }" value="D">
   					<font color="purple">D、${each.question.optiond  }</font> </td>
   				</tr>
   			
   				<tr>
   					<td>您选择的答案是：${each.choseanswer  }</td>
   					<td colspan="3">正确答案是：${each.question.answer  }</td>
   				</tr>
   			</c:forEach>
   				
   		</table>
   		</form>
  </body>
</html>
