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
                <form action="stusignup.action" method="post">
                	${meg }
                    <label>用户名</label>
                    <input type="text" name="student.name" class="span12">
                    <label>密码</label>
                    <input type="text" name="student.pwd" id="pwdid" class="span12">
                   <label>重复密码</label>
                    <input type="text" onblur="checkPwd(this);" class="span12"><span id="pwdspan"></span>
                  	<label>年龄</label>
                  	<input type="text" name="student.age" onblur="checkAge(this);" class="span12"><span id="agespan"></span>
                    <label>性别</label>
                     <input type="radio" checked="checked" name="student.sex" value="男">男 &nbsp;&nbsp;&nbsp;
                  <input type="radio" name="student.sex" value="女" >女
                    <label>所在班级</label>
                    	<select name="student.clazz.id">
                    		<c:forEach items="${calzzList }" var="each">
                    			<option value="${each.id }">${each.name }
                    		</c:forEach>
                    	</select>
                    <label class="remember-me"><input id="agreeid" onclick="checkAgree();" checked="checked" type="checkbox"> 我同意本公司的相关规定</label>
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


    

    

    

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="lib/bootstrap/js/bootstrap.js"></script>
    
    
    
    
    
    
    
    
    
    
    
    

  </body>
</html>


