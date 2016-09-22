<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
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
	<script type="text/javascript">
		function timeout(time){
			var timespan = document.getElementById("timeid");
			var formm = document.getElementById("formid");
			setInterval(function(){
				time--;
				timespan.innerHTML="<font size='7' color=='red'>距离考试结束还有"+time+"秒</font>";
				if(time == 0){
					alert("提交");
					formm.submit();
				}
			}, 1000)
		}
	</script>
  </head>
  
  <body style="text-align: center" onload="timeout(${setExam.examtime });">
  	<font size="7">${subject.name }试题</font>
  <span id="timeid"></span>
  		<form action="sturesult.action" method="post" id="formid">
   		<table>
   		<input type="hidden" name="subject.id"  value="${subject.id }">
	<input type="hidden" name="tihao" value="${tihao }">
   			<c:forEach items="${questions }" var="each" varStatus="num">
   				<tr>
   					<td colspan="4">${num.count }、${each.title }</td>
   				 </tr>
   				 <tr>
   					<td colspan="4">
   					<input type="radio" name="question${each.id }" value="A">
   					<font color="red">A、 ${each.optiona }</font></td>
   				</tr>
   				 <tr>
   					<td colspan="4">
   					<input type="radio" name="question${each.id }" value="B">
   					<font color="green">B、 ${each.optionb }</font></td>
   				</tr>
   				 <tr>
   					<td colspan="4">
   					<input type="radio" name="question${each.id }" value="C">
   					<font color="orange">C、 ${each.optionc }</font></td>
   				</tr>
   				 <tr>
   					<td colspan="4">
   					<input type="radio" name="question${each.id }" value="D">
   					<font color="purple">D、 ${each.optiond }</font></td>
   				</tr>
   					
   			</c:forEach>
   				<tr>
   					<td rowspan="4">
   						<input type="submit"  value="提交试卷">
   					</td>
   				</tr>
   		</table>
   		</form>
  </body>
</html>
