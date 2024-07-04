<%@page import="ex03.vo.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
	String name = request.getParameter("user_name");
	String email = request.getParameter("user_email");
/* 
	String id = request.getParameter("id");
	MemberBean bean = new MemberBean();
	bean.setId(id);
	 */
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBean 학습하기</title>
<%@ include file="/include/bootstrap_include.jsp" %>
</head>
<body>
	<jsp:useBean id="member" class="ex03.vo.MemberBean" scope="page"></jsp:useBean>
	<jsp:setProperty property="id" name="member" value="<%=id%>"/>
	<jsp:setProperty property="pw" name="member" value="<%=pw%>"/>
	<jsp:setProperty property="name" name="member" value="<%=name%>"/>
	<jsp:setProperty property="email" name="member" value="<%=email%>"/>
	<div class="container border">
		<h1>useBean 테스트</h1>
		<hr>
		<div>
			<p>getProperty 사용</p>
			<jsp:getProperty property="id" name="member"/>
			<jsp:getProperty property="pw" name="member"/>
			<jsp:getProperty property="name" name="member"/>
			<jsp:getProperty property="email" name="member"/>
			<hr>
			<p>MemberBean getter 사용</p>
			<p>id: <%=member.getId() %></p>
			<p>pw: <%=member.getPw() %></p>
			<p>name: <%=member.getName() %></p>
			<p>email: <%=member.getEmail() %></p>
			<p>joinDate: <%=member.getJoinDate() %></p>
		</div>
	</div>
</body>
</html>