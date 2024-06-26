<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

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

	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</body>
</html>