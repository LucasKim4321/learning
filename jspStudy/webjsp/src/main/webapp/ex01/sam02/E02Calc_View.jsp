<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class"login">
		<h3>덧셈 계산 요청</h3>
		<hr>
		<form action="/webjsp/calc" method="get">
			<div>
				<label>숫자1:</label>
				<input type="text" name="num1" class="form-control">
			</div>
			<div>
				<label>숫자2:</label>
				<input type="text" name="num2" class="form-control">
			</div>
			<div class="d-flex justify-content-center">
				<div><input type="submit" value="실행" class="btn btn-outline-success"/></div>
				<div class="ms-1"><input type="reset" value="다시입력" class="btn btn-outline-danger"/></div>
			</div>
		</form>
	</div>
</div>

</body>
</html>