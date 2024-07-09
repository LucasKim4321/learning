<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/include/bs_header.jsp" %>
<style>
	.container {
		padding: 50px;
		padding-left: 100px;
	}
</style>
</head>
<body>
	<div class="container alert alert-success">
		<h1>이름: ${name}</h1>
		<h1>나이: ${age}</h1>
		<h1>주소: ${address}</h1>
	</div>
</body>
</html>