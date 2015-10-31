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
    <script type="text/javascript">	
    	var xmlHttpRes;  
           
        function createXMLHttpRequest() {
            if(window.XMLHttpRequest) {  
                xmlHttpRes = new XMLHttpRequest();  
            } else if(window.ActiveXObject) {  
                xmlHttpRes = new ActiveXobject("Microsoft.XMLHTTP");  
            }
        }  
           
        function selectchange() {
            createXMLHttpRequest();  
            var productDl = document.getElementById("productDl").value;
            var url = "selectChangeServlet?productDl=" + productDl;
            xmlHttpRes.open("post", url, true);  
            xmlHttpRes.onreadystatechange = callback;  
            xmlHttpRes.send(null);  
        }  
        function callback() { 
            if(xmlHttpRes.readyState == 4) {  
                if(xmlHttpRes.status == 200) {
                    eval(xmlHttpRes.responseText);  
                }  
            }  
        }
	</script>
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
<form action="ProductServlet?method=addProduct" method="post">
<table class="table table-bordered table-hover definewidth m10">
	 <tr>
        <td width="10%" class="tableleft">所属分类</td>
        <td>
        <select name="productDl" id="productDl" onchange="selectchange();">
        	<c:forEach items="${listDls }" var="product_dl">
        		<option value="${product_dl.dl_id }">${product_dl.dl_name }</option>
        	</c:forEach>         
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;
        
        <select name="productXl" id="productXl">
        	<c:forEach items="${listXls }" var="product_xl">
        		<option value="${product_xl.xl_id }">${product_xl.xl_name }</option>
        	</c:forEach>         
        </select>
        </td>
    </tr>
    <tr>
        <td class="tableleft">商品名称</td>
        <td><input type="text" name="productName"/></td>
    </tr>   
    <tr>
        <td class="tableleft">商品价格</td>
        <td><input type="text" name="productPrice"/></td>
    </tr>   
    <tr>
        <td class="tableleft">评价数量</td>
        <td><input type="text" name="commountCount"/></td>
    </tr>   
    <tr>
        <td class="tableleft">折扣</td>
        <td><input type="text" name="productDis"/></td>
    </tr>   
    <tr>
        <td class="tableleft">商品图片</td>
        <td><input type="file" name="productPic" id="file" class="custom-file-input"></td>
    </tr>   
    <tr>
        <td class="tableleft">商品数量</td>
        <td><input type="text" name="productSum"/></td>
    </tr>   
    <tr>
        <td class="tableleft">商品数量</td>
        <td><input type="text" name="saledNum"/></td>
    </tr>   
    <tr>
        <td class="tableleft">商品描述</td>
        <td><input type="text" name="productDesc"/></td>
    </tr>   
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">添加</button>&nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
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