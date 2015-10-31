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
    
    	$(function(){
    	//alert("${productDlItem.dl_id }");
    	 	$("#productDl option[value='${productDlItem.dl_id }'] ").attr("selected",true);
    	 	$("#productXl option[value='${productXlItem.xl_id }'] ").attr("selected",true);
    		/* $("#productDl").val = "${productDlItem.dl_name }";
    		$("#productXl").val = "${productXlItem.xl_name }"; */
    	});
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
<form action="recommendServlet?method=update" method="post">
<table class="table table-bordered table-hover definewidth m10">
	 <tr>
        <td width="10%" class="tableleft">选择商品</td>
        <td>
        <select name="product_id" id="product">
        	<c:forEach items="${products }" var="product">
        		<option value="${product.product_id }">${product.product_name }</option>
        	</c:forEach>         
        </select>
        </td>
    </tr>
    <input type="hidden" name="recId" value="${recommend.rec_id }"/>   
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">修改</button>&nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
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