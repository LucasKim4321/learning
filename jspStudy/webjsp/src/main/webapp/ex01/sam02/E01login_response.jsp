<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<style>
	.login {
		width: 500px;
		padding: 20px;
	}
	.login div {
		margin-bottom: 10px;
	}
	.checkboxBox input {
		margin-left: 5px;
	}
</style>
</head>
<body>
	<!-- localhost:8080/webjsp/ex01/sam02/E01login_response.jsp -->
	
	<div class="container border">
		<div class="border login mx-auto">
			<h3>로그인 Response</h3>
			<hr>
			<form action="/webjsp/login2" method="post" enctype="utf-8">  <!-- enctype="utf-8"보낼때 utf-8방식으로 인코딩해서 보냄  method="post"  요청 방식 변경   생략시 기본값 get-->
				<div>
					<label for="u_id">아이디:</label>
					<input type="text" name="user_id" id="u_id" class="form-control">
				</div>
				<div>
					<label for="u_pw">비밀번호:</label>
					<input type="password" name="user_pw" id="u_pw" class="form-control">
				</div>
				<hr>
				<div class="checkboxBox">
				<!-- parameter로 넘어올 때 채크된 subject를 배열로 저장 -->
					<input type="checkbox" name="subject" value="Java" 		checked="checked">자바
					<input type="checkbox" name="subject" value="Python" 	checked="checked">파이썬
					<input type="checkbox" name="subject" value="JSP" 		checked="checked">JSP
					<input type="checkbox" name="subject" value="Android"	checked="checked">안드로이드
				</div>
				<br/>
				<input type="radio" name="address" value="1">서울
				<input type="radio" name="address" value="2">부산
				<input type="radio" name="address" value="3">경남
				<br/>
				<select name="size" class="sel_size" size="3" multiple="multiple">
					<option value="100">100cm</option>
					<option value="200">200cm</option>
					<option value="300">300cm</option>
					<option value="400">400cm</option>
					<option value="500">500cm</option>
				</select>
				<div class="d-flex justify-content-center">
					<div><input type="submit" value="로그인" class="btn btn-outline-success"/></div>
					<div class="ms-1"><input type="reset" value="다시입력" class="btn btn-outline-danger"/></div>
				</div>
			</form>
		</div>
	</div>
	
	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</body>
</html>