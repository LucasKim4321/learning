<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String imgName = request.getParameter("imgName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>이름은 <%=name %></h1>
		<h1>이미지 파일이름은 <%=imgName %></h1>
	</div>
</body>
</html>

<!-- 불러올때 모든 html 태그가 불려옴 -->
<!-- 넣을 부분만 입력해도 됨
	<div>
		<h1>이름은 <%=name %></h1>
		<h1>이미지 파일이름은 <%=imgName %></h1>
	</div>
 -->