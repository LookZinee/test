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

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>
  
  <body>
     <div class="container-fluid">
        
        <div class="row-fluid">
            <div class="span3">
                <div class="sidebar-nav">
                  <c:choose>
                  	<c:when test="${currentStudent.role==1 }">
                  		<div class="nav-header" data-toggle="collapse" data-target="#dashboard-menu"><i class="icon-dashboard"></i>管理员</div>
                    	<ul id="dashboard-menu" class="nav nav-list collapse in">
                        <li><a href="tefindAllSubject.action" target="rightFrame">科目管理</a></li>
                        <li ><a href="tefindAllQue.action" target="rightFrame">题库管理</a></li>
                        <li ><a href="tefindAll.action" target="rightFrame">学生管理</a></li>
                        <li ><a href="teacher/setexam.jsp" target="rightFrame">考试权重设置</a></li>
                  		 </ul>
                  	</c:when>
                  	
                  	<c:otherwise>
                  		<div class="nav-header" data-toggle="collapse" data-target="#accounts-menu"><i class="icon-briefcase"></i>学生用户<span class="label label-info">+10</span></div>
	               		<ul id="accounts-menu" class="nav nav-list collapse in">
	                  	<li ><a href="stutokaoshi.action" target="rightFrame">考试</a></li>
	                  	<li ><a href="sign-up.html">Sign Up</a></li>
	                  	<li ><a href="stufindallexam.action" target="rightFrame">考试记录</a></li>
                </ul>
                  	</c:otherwise>
                  </c:choose>

            </div>
        </div>
        <div class="span9">
            <script type="text/javascript" src="lib/jqplot/jquery.jqplot.min.js"></script>
<script type="text/javascript" charset="utf-8" src="javascripts/graphDemo.js"></script>
  </body>
</html>
