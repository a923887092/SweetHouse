<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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


    </style>
</head>
<form action="productXlServlet?method=update" method="post">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td class="tableleft">分类编号</td>
        <td><input type="text" name="categoryId" value="${productXlItem.xl_id }" readonly="readonly"/></td>
    </tr>   
    <tr>
        <td class="tableleft">父分类编号</td>
        <td><input type="text" name="parentId" value="${productXlItem.dl_id }" readonly="readonly"/></td>
    </tr>   
    <tr>
        <td class="tableleft">分类名称</td>
        <td><input type="text" name="categoryName" value="${productXlItem.xl_name }"/></td>
    </tr>  
    <tr>
        <td class="tableleft">分类图片</td>
        <td><input type="file" name="productPic" id="file" value="${productXlItem.xl_pic }" class="custom-file-input"></td>
    </tr> 
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">提交</button>&nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href=document.referrer;
		 });

    });
</script>