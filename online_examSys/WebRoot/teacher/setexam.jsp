<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'setexam.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		td {
			height: 50px;
		}
	</style>
  </head>
  
  <body style="text-align: center">
  	<form action="tesetExam.action" method="post">
   		<table style="width: 80%">
   			<tr>
   				<td>设置考试题目数</td>
   				<td>
   					<select name="setExam.questionnum">
   							<option value="4">4道题</option>
   							<option value="5">5道题</option>
   							<option value="10">10道题</option>
   							<option value="20">20道题</option>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td>设置考试难易度</td>
   				<td>
   					<select name="setExam.degree">
   						<c:forEach begin="1" end="5" step="1" var="ea">
   							<option value="${ea }">${ea }</option>
   						</c:forEach>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td>设置考试时间</td>
   				<td>
   					<select name="setExam.examtime">
   						<c:forEach begin="1" end="300" step="1" var="ea">
   							<option value="${ea }">${ea }秒</option>
   						</c:forEach>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td colspan="2" style="text-align: center">
   					<input type="submit" value="提交" >
   				</td>
   			</tr>
   		</table>
   		</form>
  </body>
</html>
