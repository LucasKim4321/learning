<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)request.getParameter("user_id");
String pw = (String)request.getParameter("user_pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포워딩 페이지입니다.</h1>
	<h3>환영합니다~ </h3>
	<h1><%=id%>님 어서오세요!</h1>
	<h1>당신의 비밀번호는 <%=pw%>입니다!</h1>
</body>
</html>