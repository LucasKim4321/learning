<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	session.setMaxInactiveInterval(5);  // 세션 유효시간 설정
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>session 테스트</h1>
	<div>
		isNew() : <%= session.isNew() %> <br>
		생성시간: <%= session.getCreationTime() %> <br>
		최종 접속 시간: <%= session.getLastAccessedTime() %> <br>
		세션 ID: <%= session.getId() %> <br>
	</div>
</body>
</html>