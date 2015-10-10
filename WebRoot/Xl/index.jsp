<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="./Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="./Css/bootstrap-responsive.css" />
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

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
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
<form class="form-inline definewidth m20" action="./productXlServlet?method=getProductXl" method="post">  
    大类名称：
    <input type="text" name="productxlname" id="rolename"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增分类</button>
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>分类编号</th>
        <th>父分类编号</th>
        <th>分类名称</th>
        <th>管理操作</th>
    </tr>
    </thead>
	     <c:forEach items="${productXlPage.list }" var="productXl">
			<tr>
				<td>${productXl.xl_id }</td>
				<td>${productXl.dl_id }</td>
				<td>${productXl.xl_name }</td>
				<td>
					<a href="./productXlServlet?method=getProductXlItem&id=${productXl.xl_id }">修改</a>
					<a href="./productXlServlet?method=delete&id=${productXl.xl_id }">删除</a>
				</td>
			</tr>
		</c:forEach>
</table>
<div id="total">
		共${productXlPage.totalPageNum }页 &nbsp;&nbsp;
		当前第${productXlPage.pageNo }页 &nbsp;&nbsp;

		<c:if test="${productXlPage.hasPrev }">
			<a href="./productXlServlet?method=getProductXl&pageNo=1">首页</a>
			&nbsp;&nbsp;
			<a
				href="./productXlServlet?method=getProductXl&pageNo=${productXlPage.prevPage }">上一页</a>
		</c:if>
		&nbsp;&nbsp;

		<c:if test="${productXlPage.hasNext }">
			<a
				href="./productXlServlet?method=getProductXl&pageNo=${productXlPage.nextPage }">下一页</a>
			&nbsp;&nbsp;
			<a
				href="./productXlServlet?method=getProductXl&pageNo=${productXlPage.totalPageNum }">末页</a>
		</c:if>
	</div>
</body>
</html>
<script>
    $(function () {
        
		$('#addnew').click(function(){
				window.location.href="./productXlServlet?method=getAllDl";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "index.html";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>