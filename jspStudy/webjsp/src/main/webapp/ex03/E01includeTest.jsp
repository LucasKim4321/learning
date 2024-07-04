<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");  // 받는 쪽에서 한글을 보려면 인코딩 해줘야함
%>
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
		<h1>인크루드 테스트</h1>
		<hr>
	</div>
	<div>
	안녕하세요. 쇼핑몰 중심 JSP 시작 부분
	<!-- 페이지 안에 다른jsp페이지 붙여넣기 -->
		<jsp:include page="/include/include01.jsp" flush="true">
			<jsp:param name="name" value="동길이"/>
			<jsp:param name="imgName" value="사과"/>
		</jsp:include>
	</div>
	<hr>
	안녕하세요. 쇼핑몰 중심 JSP 끝 부분
	
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