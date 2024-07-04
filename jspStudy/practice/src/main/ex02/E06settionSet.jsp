<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션 범위(브라우저)에서만 정보 공유
	session.setAttribute("name", "홍길동");
	session.setAttribute("id", "hong");

	String name = (String)session.getAttribute("name");  //object 타입을 String으로 변환 시켜야함
	String id = (String)session.getAttribute("id");
	
	// context범위내에서 정보 공유
	application.setAttribute("address", "부산");
	String address = (String)application.getAttribute("address");
	
	// 요청 관계에서만 정보 공유 (포워딩 방식에만 적용)
	request.setAttribute("age","10");
	String age = (String)request.getAttribute("age");
	
	// HttpSession mysession = request.getSession();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 데이터 바인딩: set</title>
</head>
<body>
	<div>
		<h1>내장 객체 session 데이터 바인딩: set</h1>
		<hr>
		<h3>생성된 세션 ID: <%= session.getId() %></h3>
		<hr>
	</div>
		<hr>
		이름: <%=name %> <br>
		나이: <%=age %> <br>
		아이디: <%=id %> <br>
		<h3>application(ServletContext): <%=address%></h3>
	<div>
		<h3>sendRedirect방식 (클라이언트가 접속하는 방식)</h3>
		<a href="/webjsp/ex02/E07sessionGet.jsp">세션값 읽기</a>
	</div>
	<div>
		<h3>RequestDispatcher방식 (포워딩:서버에 페이지 연결하는 방식))</h3>
		<%
			RequestDispatcher dispatch = request.getRequestDispatcher("/ex02/E07sessionGet.jsp");
			dispatch.forward(request, response);
		%>
	</div>
</body>
</html>