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
<!-- http://localhost:8080/webjsp/ex01/sam02/E04gugudan.jsp -->
	<div class=container>
		<div class=mybox>
			<form name="formLogin" action="/webjsp/gugudan" method="get" class="d-flex">
				<div>
					<label for="dan">구구단</label>
					<input type="text" name="dan" placeholder="단수 입력 :b" id="dan" class="">
				</div>
				<div class="d-flex">
					<div class="ms-1"><input type="button" onClick="fn_validate()" value="실행" class="btn btn-outline-success"></div>
					<div class="ms-1"><input type="reset" value="다시입력" class="btn btn-outline-danger"></div>
				</div>
			</form>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	<script type="text/javascript">

	function fn_validate(){
		var formLogin = document.formLogin;
		var dan = formLogin.dan.value;
		if( (dan.length==0 || dan=="")||(dan.length==0 || dan=="")) {
			alert("단수를 입력해주세요~")
		} else {
			formLogin.submit();
		}
	}
	</script>
</body>
</html>