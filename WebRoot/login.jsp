<!DOCTYPE html>
<html>
<head>
<title>后台登陆系统</title>
<meta charset="UTF-8">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<link rel="stylesheet" type="text/css" href="./Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="./Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="./Css/style.css" />
<script type="text/javascript" src="./Js/jquery.js"></script>
<script type="text/javascript" src="./Js/jquery.sorted.js"></script>
<script type="text/javascript" src="./Js/bootstrap.js"></script>
<script type="text/javascript" src="./Js/ckform.js"></script>
<script type="text/javascript" src="./Js/common.js"></script>
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}


</style>
</head>
<%
	String msg="";
	if((String)request.getAttribute("msg")!=null){
		msg=(String)request.getAttribute("msg");
	}; 
	
%>

<body>
	<div class="container">
	

		<form class="form-signin" method="post" action="checkLogin">
			<h2 class="form-signin-heading">后台登录系统</h2>
			<input type="text" name="username" class="input-block-level" placeholder="用户名"> 
			<input type="password" name="password" class="input-block-level" placeholder="密码">
			<input type="text" name="verifyCode" value="${user.verifyCode }" width=100px placeholder="验证码"/>
       		<img id="vCode" src="VerifyCodeServlet" border="2"/>
       		<a href="javascript:;" onclick="document.getElementById('vCode').src = 'VerifyCodeServlet?'+(new Date()).getTime()">换一张</a>
        	<p>
			<button class="btn btn-large btn-primary" type="submit">登陆</button>
			<font color="red"><%=msg %></font>
			</p>
		</form>

	</div>
</body>
</html>