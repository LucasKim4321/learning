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
<title>session 데이터 바인딩: Invalidate()(삭제)</title>
</head>
<body>
	<h1>내장 객체 session 데이터 바인딩삭제: Invalidate()</h1>
	<hr>
	<div>
	세션 값 읽기 : 생성된 세션 ID: <%=session.getId()%>
	</div>	</div>
	<hr>
	이름: <%=name %> <br>
	나이: <%=age %> <br>
	아이디: <%=id %> <br>
	<h3>application(ServletContext): <%=address%></h3>
	<div>
	<div>
		<%session.invalidate();%>
		session 객체 강제로 삭제 되었습니다.
		<div>
			세션 값 읽기 : 생성된 세션 ID: <%=session.getId()%>
			</div>
			<hr>
			이름: <%=name %> <br>
			아이디: <%=id %> <br>
		</div>
	</div>

</body>
</html>