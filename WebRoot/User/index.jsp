<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta charset="UTF-8">
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
	padding-bottom: 40px;
}



.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}

#total{
	float:right;
	margin-right:50px;
}
</style>
</head>
<body>
	<form class="form-inline definewidth m20" action="index.html"
		method="get">
		用户名称： <input type="text" name="username" id="username"
			class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增用户</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>用户id</th>
				<th>用户昵称</th>
				<th>用户密码</th>
				<th>用户手机号</th>
				<th>用户头像</th>
				<th>用户状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${userPage.list }" var="user">
			<tr>
				<td>${user.user_id }</td>
				<td>${user.user_name }</td>
				<td>${user.user_password }</td>
				<td>${user.user_mobile }</td>
				<td>${user.user_image }</td>
				<td>${user.user_state }</td>
				<td><a href="edit.html">编辑</a></td>
			</tr>
		</c:forEach>
	</table>
	<div id="total">
		共${userPage.totalPageNum }页 &nbsp;&nbsp;
		当前第${userPage.pageNo }页 &nbsp;&nbsp;

		<c:if test="${userPage.hasPrev }">
			<a href="./userServlet?method=getUsers&pageNo=1">首页</a>
			&nbsp;&nbsp;
			<a
				href="./userServlet?method=getUsers&pageNo=${userPage.prevPage }">上一页</a>
		</c:if>
		&nbsp;&nbsp;

		<c:if test="${userPage.hasNext }">
			<a
				href="./userServlet?method=getUsers&pageNo=${userPage.nextPage }">下一页</a>
			&nbsp;&nbsp;
			<a
				href="./userServlet?method=getUsers&pageNo=${userPage.totalPageNum }">末页</a>
		</c:if>
	</div>
</body>
</html>
<script>
	$(function() {

		$('#addnew').click(function() {

			window.location.href = "add.html";
		});

	});

	function del(id) {

		if (confirm("确定要删除吗？")) {

			var url = "index.html";

			window.location.href = url;

		}

	}
</script>