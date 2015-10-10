<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
     "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
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
<form class="form-inline definewidth m20" action="./productDlServlet?method=getProductDl" method="post">  
    大类名称：
    <input type="text" name="productdlname" id="rolename"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增分类</button>
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>分类编号</th>
        <th>分类名称</th>
        <th>管理操作</th>
    </tr>
    </thead>
	     <c:forEach items="${productDlPage.list }" var="productDl">
			<tr>
				<td>${productDl.dl_id }</td>
				<td>${productDl.dl_name }</td>
				<td>
					<a href="Node/edit.jsp?id=${productDl.dl_id }&name=${productDl.dl_name }">修改</a>
					<a href="./productDlServlet?method=delete&id=${productDl.dl_id }">删除</a>
				</td>
			</tr>
		</c:forEach>
</table>
<div id="total">
		共${productDlPage.totalPageNum }页 &nbsp;&nbsp;
		当前第${productDlPage.pageNo }页 &nbsp;&nbsp;

		<c:if test="${productDlPage.hasPrev }">
			<a href="./productDlServlet?method=getProductDl&pageNo=1">首页</a>
			&nbsp;&nbsp;
			<a
				href="./productDlServlet?method=getProductDl&pageNo=${productDlPage.prevPage }">上一页</a>
		</c:if>
		&nbsp;&nbsp;

		<c:if test="${productDlPage.hasNext }">
			<a
				href="./productDlServlet?method=getProductDl&pageNo=${productDlPage.nextPage }">下一页</a>
			&nbsp;&nbsp;
			<a
				href="./productDlServlet?method=getProductDl&pageNo=${productDlPage.totalPageNum }">末页</a>
		</c:if>
	</div>
</body>
</html>
<script>
    $(function () {
        
		$('#addnew').click(function(){

				window.location.href="Node/add.jsp";
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