<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<h1>EL(Expression Language)언어 테스트</h1>
	<table>
		<tbody>
			<tr><td>${100}</td></tr>
			<tr><td>${100*20+3}</td></tr>
			<tr><td>${"10"+5000}</td></tr>
		</tbody>
	</table>
	<hr>
	${100} <br>
	${100*20+3} <br>
	${"10"+5000} <br>  <!-- 문자 숫자 조합에서 알아서 변환해서 계산함 -->

	<%--${"홍길동","동순이"}, ${"홍길동"+"동순이"} 에러남 --%> 
	<%-- ${"홍길동"}  --%> <!-- 이건 나옴 -->
	<hr>
	${10+10}, ${10-2}, ${10*2}   <br>
	${9/2 }, ${10 div 3}  <br>
	${10%3}, ${10 mod 9 } <br>
	<hr>
	<h3>비교연산</h3>
	${10==10 },${10 eq 10 },${"10"==10 } <br>
	${10!=20 }, ${not(10!=20)}<br>
	${20 > 10 },${100 gt 10 } <br>
	${20 < 10 },${100 le 10 } <br>
	<hr>
	<h3>객체 연산자</h3>
	<!-- useBean 객체 생성 -->
	<jsp:useBean id="member" class="ex03.vo.MemberBean" scope="page"></jsp:useBean>
	<jsp:setProperty property="name" name="member" value="홍길동"/>
	
	<jsp:useBean id="array_member" class="java.util.ArrayList" scope="page"/>
	
	empty: ${empty member} <br>  <!-- 값이 비어있는지 확인 boolean값 반환 -->
	not empty: ${not empty member} <br>  <!-- 값이 있는지 확인 boolean값 반환 -->
	
	empty: ${empty array_member} <br>  <!-- 값이 비어있는지 확인 boolean값 반환 -->
	not empty: ${not empty array_member} <br>  <!-- 값이 있는지 확인 boolean값 반환 -->
	
	
</body>
</html>
<!-- 
pageScope, requestScope, sessionScope, applicationScope
param, paramValues
header, headerValues
cookies, pageContext
매개변수 초기값: initParam
 -->

