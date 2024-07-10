<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	String name = "홍길동";
%>

<c:set var="name" value="<%=name%>"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP View Page 인식하기 테스트</title>
<%@ include file="/include/bs_header.jsp" %>
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
	<hr>
	${jdbcMembers}
	<hr>
	<table class="table table-striped table-danger">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>email</th>
				<th>joindate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${jdbcMembers}">
			<tr>
				<td>${member.id}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.joindate}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>