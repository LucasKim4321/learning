<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 반복되는 영역을 include -->
	<%@ include file="/include/bootstrap_include.jsp" %>
</head>
<body>
	<div class="container border">
		<h1>로그인</h1>
		<hr>
		<div class="mylogin">
			<form action="/webjsp/ex03/E0202login_result.jsp" method="get">
			아이디: <input type="text" name="user_id" class="form-control"><br>
			비밀번호: <input type="password" name="user_pw" class="form-control"><br>
			<div>
				<input type="submit" value="로그인" class="btn btn-success"/>
				<input type="reset" value="재입력" class="btn btn-danger" />
			</div>
			</form>
		</div>
	</div>
	
</body>
</html>

<%--
JSP 액션 태그 : 자코드 대신 사용

인크루드 액션 태그	: <jsp:include>		: 이미 있는 JSP를 현재 JSP에 포함하는 태그
포워드 액션 태그	: <jsp:forword>		: 서블릿 RequestDispatcher 클래스의 포워딩 기능
유즈빈 액션 태그	: <jsp:useBean>		: 객체를 생성하기 위한 new 연산자 기능
셋프로퍼티 액션 태그	: <jsp:setProperty>	: setter를 대신하는 기능
겟프로퍼티 액션 태그	: <jsp:getProperty> : getter를 대신하는 기능
--%>