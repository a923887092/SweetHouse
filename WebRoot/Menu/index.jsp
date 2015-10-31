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
	<form class="form-inline definewidth m20" action="ProductServlet?method=getProduct"
		method="post">
		用户名称： <input type="text" name="productname" id="username"
			class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">添加商品</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>商品图片</th>
				<th>商品价格</th>
				<th>商品折扣</th>
				<th>商品数量</th>
				<th>已售数量</th>
				<th>商品描述</th>
				<th>编辑</th>
			</tr>
		</thead>
		<c:forEach items="${productPage.list }" var="product">
			<tr>
				<td>${product.product_id }</td>
				<td>${product.product_name }</td>
				<td>${product.product_photo }</td>
				<td>${product.product_price }</td>
				<td>${product.product_discount }</td>
				<td>${product.product_sum }</td>
				<td>${product.saled_num }</td>
				<td>${product.product_desc }</td>
				<td><a href="ProductServlet?method=getDlAndXlAndUpdate&id=${product.product_id }">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="ProductServlet?method=delete&id=${product.product_id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<div id="total">
		共${productPage.totalPageNum }页 &nbsp;&nbsp;
		当前第${productPage.pageNo }页 &nbsp;&nbsp;

		<c:if test="${productPage.hasPrev }">
			<a href="./ProductServlet?method=getProduct&pageNo=1">首页</a>
			&nbsp;&nbsp;
			<a
				href="./ProductServlet?method=getProduct&pageNo=${productPage.prevPage }">上一页</a>
		</c:if>
		&nbsp;&nbsp;

		<c:if test="${productPage.hasNext }">
			<a
				href="./ProductServlet?method=getProduct&pageNo=${productPage.nextPage }">下一页</a>
			&nbsp;&nbsp;
			<a
				href="./ProductServlet?method=getProduct&pageNo=${productPage.totalPageNum }">末页</a>
		</c:if>
	</div>
</body>
</html>
<script>
	$(function() {

		$('#addnew').click(function() {

			window.location.href = "ProductServlet?method=getDlAndXlAndAdd";
		});

	});

	function del(id) {

		if (confirm("确定要删除吗？")) {

			var url = "index.html";

			window.location.href = url;

		}

	}
</script>