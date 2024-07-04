<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	request.setCharacterEncoding("utf-8");
 	String name = request.getParameter("name");
 	//String gender = request.getParameter("gender");
 	String gender = request.getParameter("gender").equals("male")?"남자":"여자";
 	String[] hobby = request.getParameterValues("hobby");
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>jsprequest_result</h3>
	<div>
		<hr>
		<h3>이름: <%=name %></h3>
		<%-- gender.equals("male")?"남자":"여자" --%>
		<h3>성별: <%=gender %></h3>
		<h3>
			취미 <hr>
			<% for(int i=0; i<hobby.length; i++) {%>
				<!-- html영역에 값을 출력 -->
				<div> <%=hobby[i] %></div>
			<% } %>
		</h3>
	</div>
</body>
</html>