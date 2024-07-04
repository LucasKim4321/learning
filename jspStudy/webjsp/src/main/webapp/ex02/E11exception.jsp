<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>예외 처리 페이지</h1>
	<hr>
	<%=exception.toString() %>
	<hr>
	<%=exception.getMessage() %>
	<hr>
	숫자만 입력하세요.
	<a href="/webjsp/ex02/E09addException.jsp">다시하기</a>
</body>
</html>