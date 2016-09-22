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
    <script type="text/javascript">
    	function checkPwd(pwdtext){
    		var pwd2 = pwdtext.value;
    		var pwd1 = document.getElementById("pwdid").value;
    		var pwdspan = document.getElementById("pwdspan");
    		if(pwd1 != pwd2){
    			pwdspan.innerHTML="两次密码输入不一致";
    		}else{
    			pwdspan.innerHTML="";
    		}
    		
    	}
    	function checkAge(pwdtext){
    		var age = pwdtext.value;
    		var agespan = document.getElementById("agespan");
    		if(age<0 || age >128){
    			agespan.innerHTML="请输入正确的年龄";
    		}else{
    			agespan.innerHTML="";
    		}
    		
    	}
    	
    	function checkAgree(){
    		var flag = document.getElementById("agreeid").checked;
    		var sub = document.getElementById("subid");
    		sub.disabled = !flag;
    	}
    </script>
  </head>

  <body> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid">
                <ul class="nav pull-right">
                    
                </ul>
                <a class="brand" href="index.html"><span class="first">Your</span> <span class="second">Company</span></a>
            </div>
        </div>
    </div>
    


        <div class="row-fluid">
    <div class="span4 offset4 dialog">
        <div class="block">
            <div class="block-heading">Sign Up</div>
            <div class="block-body">
                <form action="teupdateQue.action" method="post">
                	${meg }
                	<input type="hidden" name="question.id" value="${question.id }">
                	 <label>科目</label>
                	<select name="question.subject.id">
                		<c:forEach items="${subList }" var="each">
                			<c:choose>
                				<c:when test="${each.id==question.subject.id }">
                					<option value="${each.id }" selected="selected">${each.name }</option>
                				</c:when>
                				<c:otherwise>
                					<option value="${each.id }">${each.name }</option>
                				</c:otherwise>
                			</c:choose>
                		</c:forEach>
                	</select>
                    <label>问题</label>
                    <input type="text" name="question.title" value="${question.title }" class="span12">
                    <label>A选项</label>
                    <input type="text" name="question.optiona" value="${question.optiona }" id="pwdid" class="span12">
                     <label>B选项</label>
                    <input type="text" name="question.optionb" value="${question.optionb }" id="pwdid" class="span12">
                     <label>C选项</label> 
                    <input type="text" name="question.optionc" value="${question.optionc }" id="pwdid" class="span12">
                     <label>D选项</label>
                    <input type="text" name="question.optiond" value="${question.optiond }" id="pwdid" class="span12">
                     <label>答案</label>
                    <input type="text" name="question.answer" value="${question.answer }" id="pwdid" class="span12">
                    
                   <label>难度指数</label>
                    <select name="question.degree">
                    	<c:forEach begin="1" step="1" end="5" var="e">
                    		<c:choose>
                    			<c:when test="${e==question.degree }">
                    				<option selected="selected" value="${e }">${e }</option>
                    			</c:when>
                    			<c:otherwise>
                    				<option value="${e }">${e }</option>
                    			</c:otherwise>
                    		</c:choose>
                    	</c:forEach>
                    </select>
                  	
                   
                    <label>
                   		 <input type="submit" id="subid" value="Sign Up!" class="btn btn-primary pull-right">
                   	</label>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <p><a href="privacy-policy.html">Privacy Policy</a></p>
    </div>
</div>

    <script src="lib/bootstrap/js/bootstrap.js"></script>
  </body>
</html>


