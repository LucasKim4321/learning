<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload Form</title>
<%@ include file="/include/bootstrap_include.jsp" %>
</head>
<body>
	<div class="container">
		<h1>File Download Form</h1>
		<form action="/webjsp/ex06/E01result.jsp" method="post">
		
			<div><input type="hidden" name="param1" value="frog(1).jpg"/></div>
			<div><input type="hidden" name="param2" value="frog (2).jpg"/></div>
			<div><input type="submit" value="이미지 다운로드"/></div>
			
		</form>
	</div>
</body>
</html>