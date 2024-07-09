<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%
	String name = "홍길동";
%>

<c:set var="name" value="<%=name%>"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP View Page 인식하기 테스트</title>
</head>
<body>
	<!-- context path = '/' -->
	<div>
	<%
		out.println("Hello SpringBoot JSP View!!!");
	%>
	</div>
	<div><%=name%></div>
	<c:out value="${name}"></c:out>님 안녕하세요! :b
	
	
</body>
</html>