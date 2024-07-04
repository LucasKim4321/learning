<!-- java 클래스 import -->
<%@page import="java.util.Calendar"%>
<%@page import="java.lang.Integer"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! // 자바 영역
// 선언문 : 멤버변수, 메서드 등 선언
	private String str = "JSP 스터디";
	public String getName() {
		return "홍길동";
	}
%>

<%
// 자바소스 : 스크립트릿
// 매개 변수
String name = request.getParameter("age");
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.valueOf(request.getParameter("num2"));

// 날짜
Calendar c = Calendar.getInstance();
int hour = c.get(Calendar.HOUR_OF_DAY);
int minute = c.get(Calendar.MINUTE);
int second = c.get(Calendar.SECOND);
%>
<!-- HTML 영역 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 페이지</title>
</head>
<body>
						<!-- http://localhost:8080/webjsp/ex02/Hello.jsp?age=20&num=10&num=20 -->
			
	<h1>JSP페이지</h1>
	<hr>
	<h3>안녕하세요! <%=getName()%>님!!</h3>
	<h4><%=str%>입니다!</h4>
	<h4>당신의 나이는? <%=name%></h4>
	<%-- 
	<h3>num1: <%=num1%></h3>
	<h3>num2: <%=num2%></h3>
	<h3>덧셈: <%=(num1+num2)%></h3>
	 --%>
	<h4>현재시간 <%=hour%>시 <%=minute%>분 <%=second%>초</h4>
</body>
</html>


<!-- 태그 주석 jsp문장 주석 안됨 -->
<%-- jsp 주석 
	JSP -> View 페이지 작성
	웹컨테이너(톰캣) : JSP -> Sevlet변화(.java) -> 컴파일 -> 바인트코드(.class)   결과 적으로 자바 클래스로 만들어져서 실행됨
	
	선언문: 변수, 메서드 함수 선언
	스크립트릿: 자바 소스 코드
	표현식: 출력 -> 웹페이지 표현 -> HTML에 결과값을 출력 -> HTML안에 결과값을 표현: HTML + 표현식  <%= %>
	
	int num = 20
	System.out.println("홍길동"+num+"안녕")
	
	
	jsp구조
	
	자바(서블릿) 소스 영역 => <%! %> <% %>
	HTML 영역 : 값 출력 <%= %>


	// JSP페이지 내장 객체
	request			-> HttpServletRequest request
	response		-> HttpServletRequest response
	session			-> HttpSession session
	pageContext		-> PageContext pageContext
	out				-> JspWriter out
	application		-> ServletContext application
	config			-> ServletConfig config
	page			-> Object (this)
	exception		-> Exception exception

 --%>