<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<%@ include file="/include/bs_header.jsp" %>
</head>
<body>
	<div>
		<h1>jdbcMemberView 회원조회</h1>
		<hr>
		<!-- toString이 내장되어 있어서 나옴 -->
		${member}
	</div>
	
</body>
</html>