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
<%--
	RequestDispatcher dispatcher = request.getRequestDispatcher("forward_login.jsp");
	dispatcher.forward(request, response);
 --%>
	<div>
	<!-- E0203forward_login.jsp 페이지를 포워딩으로 불러옴. 해당 페이지가 대신 나옴 -->
		<jsp:forward page="E0203forward_login.jsp"/>
		<h3><%=id%>님 어서오세요!</h3>
	</div>

</body>
</html>