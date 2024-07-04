<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/include/bootstrap_include.jsp" %>
</head>
<body>
	<div class="container border">
		<h1 class="text-center" style="color:lightsalmon;">테스트1</h1>
		<div>
			<form action="/practice/practice02/login_result2.jsp" method="get">
				아이디: <input type="text" name="user_id" class="form-control"><br>
				비밀번호: <input type="password" name="user_pw" class="form-control"><br>
				이름: <input type="text" name="user_name" class="form-control"><br>
				이메일: <input type="text" name="user_email" class="form-control"><br>
				<div>
					<input type="reset" value="재입력" class="btn btn-outline-danger"/>
					<input type="submit" value="로그인" class="btn btn-outline-success"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>