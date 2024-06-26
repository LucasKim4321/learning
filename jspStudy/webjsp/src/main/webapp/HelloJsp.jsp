<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
String str1 = "JSP";
String name = "홍길동";
%>
<% // jsp안에서 java 사용가능 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h1><%=name%>이 처음 만들어보는 <%= str1 %>~~~</h1>
	<div>
		<%
			out.println(str1+","+name);
		%>
	</div>
	<h1>안녕</h1>
	<h2>뭐하냐</h2>
</body>
</html>