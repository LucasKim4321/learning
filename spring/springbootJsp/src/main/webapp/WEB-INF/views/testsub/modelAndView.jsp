<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>model and view</title>
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
		<h1>주소: ${address}</h1>
		<hr>
		<table class="table table-striped table-success">
			<c:forEach var="name" items="${names}">
				<tr><td>${name}</td></tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>