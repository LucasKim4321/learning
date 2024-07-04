<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");  //object 타입을 String으로 변환 시켜야함
	String id = (String)session.getAttribute("id");
	
	String address = (String)application.getAttribute("address");
	
	String age = (String)request.getAttribute("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 데이터 바인딩: get</title>
</head>
<body>
	<h1>내장 객체 session 데이터 바인딩: get</h1>
	<hr>
	<div>
	삭제 전 세션 값 읽기
	</div>
	<hr>
	이름: <%=name %> <br>
	나이: <%=age %> <br>
	아이디: <%=id %> <br>
	<h3>application(ServletContext): <%=address%></h3>
	<h1><%out.println("나이: "+age);  // JspWriter out%></h1>
	<div>
		세션값 삭제 함.
		<%--<%session.invalidate();--%>
		<a href="/webjsp/ex02/E08sessionInvalidate.jsp">세션값 삭제 후</a>
	</div>

</body>
</html>