<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/include/bs_header.jsp" %>
</head>
<body>
	<div class="container">
		<h1>회원 등록</h1>
		<hr>
		<div>
			<form>
				<div class="mb-3 row">
					<label for="id" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="id" name="id"">
					</div>
					<div class="col">
						<button type="button" class="btn btn-outline-primary" id="idCheck">ID Check</button>
					</div>
					<div class="form-text">4자이상. 숫자, 영문자 혼용. 첫자는 영문</div>
				</div>
				<div class="mb-3 row">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="email" name="email">
					</div>
					<div class="form-text">이메일 입력</div>
				</div>
				
				<div class="mb-3 row">
					<label for="pwd" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
					    <input type="password" class="form-control" id="pwd" name="pwd">
					</div>
				</div>
				
				<div class="mb-3 form-check">
					<input class="form-check-input" type="checkbox" value="" id="remember" name="remember">
					<label class="form-check-label" for="remember">remember me</label>
				</div>
				
				<div>
					<button type="submit" class="btn btn-outline-success">submit</button>
				</div>
			</form>
		</div>
	</div>
	
	
	<jsp:include page="/include/bs_footer.jsp"/>
	<script type="text/javascript">
		$("#idCheck").click(function() {
			let id = $("#id").val();  //html태그의 #id의 value값을 let id에 저장
			console.log('id: ', id)
			// 서버에 전송 중복체크(등록여부 확인)
		})
		
	</script>
	
</body>
</html>