<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
	.table .mytbody :nth-child(3) :nth-child(2) {
		margin-right: 10px;
	}
</style>
</head>
<body>
	<div class="container">
		<h1>JSP request 요청하기</h1>
		<hr>
		<div>
			<form action="/webjsp/ex02/jsprequest_result.jsp" method="post">
			<table border="1" class="table table-striped table-warning">
				<tbody class="mytbody">
					<tr>
						<td>이름: </td>
						<td><input type="text" class="form-control" name="name" id="name" /></td>
					</tr>
					<tr>
						<td>성별: </td>
						<td>
							<input type="radio" class="form-check-input" name="gender" value="male" checked="checked" />남
							<input type="radio" class="form-check-input" name="gender" value="female" />여
						</td>
					</tr>
					<tr class="hobby">
						<td class="t">취미: </td>
						<td class="o">
							<input type="checkbox" class="form-check-input" name="hobby" value="독서"/>독서
							<input type="checkbox" class="form-check-input" name="hobby" value="게임"/>게임
							<input type="checkbox" class="form-check-input" name="hobby" value="TV"/>TV시청
							<input type="checkbox" class="form-check-input" name="hobby" value="축구"/>축구
							<input type="checkbox" class="form-check-input" name="hobby" value="기타"/>기타
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" class="btn btn-outline-warning opacity-50" value="전송" />
						</td>
					</tr>
				</tbody>
			</table>
			</form>
		</div>
	</div>

</body>
</html>