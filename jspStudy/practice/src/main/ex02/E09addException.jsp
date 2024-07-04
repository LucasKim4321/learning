<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception: 예외 처리 학습</title>
</head>
<body>
	<div>
		<h3>Exception: 예외 처리 학습</h3>
		<hr>
		<form action="/webjsp/ex02/E10addExceptionError.jsp" name="myform">
			자연수를 입력하세요<br>
			1부터
			<input type="text" name="num"/>
			<input type="submit" value="계산"/>
		</form>
	</div>
	
</body>
</html>

<%-- 
	1. 예외 처리 담당 JSP생성 
	<%@page isErrorPage='true'>
	2. 예외 발생 시 예외 처리 담담 JSP파일 지정
	<%@page errorPage='addException.jsp'>
	
	add.jsp -> 예외 발생 -> addException.jsp -> exception내장 객체를 사용해 예외 처리
 --%>