<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
   <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.8.1.min.js" type="text/javascript"></script>

    <!-- Demo page code -->
    
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
    <script type="text/javascript">
    	function addStu(){
    		window.location="tetoaddStu.action";
    	}
    	function deleteStu(stuid){
    		var flag = confirm("您确定要删除该学生的信息吗？");
    		if(flag){
    			window.location="tedeleteStu.action?student.id="+stuid;
    		}
    	}
    	function toupdate(stuid){
    		window.location="tetoupdate.action?student.id="+stuid;
    	}
    	                         
    </script>
  </head>
  
  <body>
       <h1 class="page-title">学生信息</h1>
<div class="btn-toolbar">
    <button class="btn btn-primary" onclick="addStu();"><i class="icon-plus"></i>添加学生信息</button>
  <div class="btn-group">
  </div>
</div>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>姓名</th>
          <th>科目</th>
           <th>分数</th>
          <th>考试时间</th>
          <th>考试详情</th>
          <th>操作</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${resultList }" var="each" varStatus="ea">
      	<tr>
      	<td>${ea.count }</td>
          <td>${each.student.name }</td>
          <td>${each.subject.name }</td>
          <td>${each.score}</td>
          <td>${each.testtime }</td>
          <td>
          	<a href="stufindxiangqing.action?result.id=${each.id }">查看考试详情</a>
          </td>
          <td>
              <a href="javaScript:toupdate(${each.id });"><i class="icon-pencil"></i></a>
              <a href="javaScript:deleteStu(${each.id });" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
        <li><a href="#">Prev</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">Next</a></li>
    </ul>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Delete Confirmation</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button class="btn btn-danger" data-dismiss="modal">Delete</button>
    </div>
</div>

        </div>
    </div>
    <footer>
        <hr>
        <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
        <p>&copy; 2012 <a href="http://www.portnine.com">Portnine</a></p>
    </footer>
    <script src="lib/bootstrap/js/bootstrap.js"></script>
  </body>
</html>
