<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pw = request.getParameter("user_pw");
	String address = (String)request.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MemberForm.jsp에서 매개 변수에 값 전달 후 결과 값</h1>
	아이디: <%=request.getParameter("user_id")%> <br>
	비밀번호: <%=pw %>
	<hr>
	아이디: ${param.user_id} <br>
	비밀번호: ${param.user_pw} <br>
	이름: ${param.user_name} <br>
	이메일: ${param.user_email} <br>
	<hr>
	
	<h3>EL 포워딩 : EL_forward.jsp에서 포워딩 후 정보 공유 결과</h3>
	주소: <%=address %> <br>
	주소: ${requestScope.address} <br>
	<hr>
	<h3>EL 포워딩 : EL_Collection_forword.jsp에서 포워딩 후 정보공유 결과</h3>
	<div>
		<div>
			${memberList[0]}  <br>
			${memberList[0].id}   <br>
			${memberList[0].name}   <br>
		</div>
		<div>
			${memberList[1]}  <br>
			${memberList[1].id}  <br>
			${memberList[1].name}  <br>
		</div>
	</div>
	<hr>
	<h3>스코프 우선 순위</h3>
	<h3>page > request > session > application</h3>
	<%-- <%pageContext.setAttribute("age", 40);%> --%>
	Scope값: ${age}
	<hr>
	requestScope: ${requestScope.age} <br>
	sessionScope: ${sessionScope.age } <br>
	applicationScope: ${applicationScope.age} <br>
</body>
</html>