<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function returns(){
		window.location.href=document.referrer;
	}
</script>
</head>
<body>
	<%= request.getAttribute("errorCode") == null ? "":request.getAttribute("errorCode") %>
	<a onclick="returns();">Return...</a>
</body>
</html>