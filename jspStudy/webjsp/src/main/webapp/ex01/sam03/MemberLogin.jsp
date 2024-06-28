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
<!-- localhost:8080/webjsp/ex01/sam03/MemberLogin.jsp -->
	
	<div class="container border">
		<div class="border login mx-auto">
			<h3>회원 가입</h3>
			<hr>
			<form action="/webjsp/registerMember" name="frmMember" method="get">  <!-- method="post"  요청 방식 변경   생략시 기본값 get-->
				<div>
					<label for="u_id">아이디:</label>
					<input type="text" name="user_id" id="u_id" class="form-control">
				</div>
				<div>
					<label for="u_pwd">비밀번호:</label>
					<input type="password" name="user_pwd" id="u_pwd" class="form-control">
				</div>
				<div>
					<label for="u_name">이름:</label>
					<input type="password" name="user_name" id="u_name" class="form-control">
				</div>
				<div>
					<label for="u_email">이메일:</label>
					<input type="password" name="user_email" id="u_email" class="form-control">
				</div>
				<hr>
				
				<!-- controller에서 작업(url)구분 역할 -->
				<input type="hidden" name="command" value="addMember">
				
				<div class="d-flex justify-content-center">
					<div><input type="button" value="회원등록" onClick="fn_sendMember()" class="btn btn-outline-success"/></div>
					<div class="ms-1"><input type="reset" value="다시입력" class="btn btn-outline-danger"/></div>
					<div class="ms-1"><input type="button" value="목록" onClick="fn_listMember()" class="btn btn-outline-primary"></div>
				</div>
			</form>
			<!-- 
			<form action="/webjsp/member">
				<input type="submit" value="회원목록 조회" class="btn btn-outline-secondary">
			</form>
			 -->
		</div>
	</div>
	
	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	
	<!--  <script type="text/javascript">  // type 생략가능  -->
	<script>  // type 생략가능
	
	<!-- localhost:8080/webjsp/ex01/sam03/MemberLogin.jsp -->
	
		function fn_sendMember() {
			var frmMember = document.frmMember;
			
			// 각항목을 체크 한 후
			
			// 정상이면 처리
			frmMember.method = "get";
			frmMember.action = "/webjsp/member/addMember.do";
			frmMember.submit();
		}
		
		function fn_listMember(){
			location.href = "/webjsp/member?command=listMember.do";
		}
	</script>


</body>
</html>