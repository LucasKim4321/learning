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
<title>Insert title here</title>
<%@ include file="/include/bootstrap_include.jsp" %>
</head>
<body>
	<jsp:useBean id="UserVO" class="practice01.UserVO" scope="page"></jsp:useBean>
	<jsp:setProperty property="id" name="UserVO" value="<%=id%>"/>
	<jsp:setProperty property="pw" name="UserVO" value="<%=pw%>"/>
	<jsp:setProperty property="name" name="UserVO" value="<%=name%>"/>
	<jsp:setProperty property="email" name="UserVO" value="<%=email%>"/>
	<div class="container border">
		<h1>useBean 테스트</h1>
		<hr>
		<div>
			<p>getProperty 사용</p>
			<jsp:getProperty property="id" name="UserVO"/>
			<jsp:getProperty property="pw" name="UserVO"/>
			<jsp:getProperty property="name" name="UserVO"/>
			<jsp:getProperty property="email" name="UserVO"/>
			<hr>
			<p>MemberBean getter 사용</p>
			<p>id: <%=UserVO.getId() %></p>
			<p>pw: <%=UserVO.getPw() %></p>
			<p>name: <%=UserVO.getName() %></p>
			<p>email: <%=UserVO.getEmail() %></p>
		</div>
	</div>
</body>
</html>