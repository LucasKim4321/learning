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
		<h1>회원 정보</h1>
		<hr>
		${member}
	</div>
	<div class="container">
		<!-- <h1>회원 정보</h1> -->
		<hr>
		<div>
			<form id="viewForm">
				<div class="mb-3 row">
					<label for="id" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly>
					</div>
				</div>
				
				<div class="mb-3 row">
					<label for="pwd" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
					    <input type="password" class="form-control" id="pwd" name="pwd" value="${member.pwd}">
					</div>
					<div class="form-text">비밀번호 입력</div>
				</div>
				
				<div class="mb-3 row">
					<label for="pwd2" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
					    <input type="password" class="form-control" id="pwd2" name="pwd2">
					</div>
					<div class="form-text">비밀번호 채크</div>
				</div>
				
				<div class="mb-3 row">
					<label for="name" class="col-sm-2 col-form-label">name</label>
					<div class="col-sm-10">
					    <input type="text" class="form-control" id="name" name="name" value="${member.name}" readonly>
					</div>
					<div class="form-text"></div>
				</div>
				
				<div class="mb-3 row">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="email" name="email" value="${member.email}">
					</div>
					<div class="form-text"></div>
				</div>
				
				<div class="mb-3 form-check">
					<input class="form-check-input" type="checkbox" value="" id="remember" name="remember">
					<label class="form-check-label" for="remember">remember me</label>
				</div>
				
				<div>
					<button type="submit" id="modify" onClick="fnModify()" class="btn btn-outline-success">수정</button>
					<button type="button" id="delete" class="btn btn-outline-danger">삭제</button>
					<button type="button" id="list" onClick="fnList()" class="btn btn-outline-primary">목록</button>
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="/include/bs_footer.jsp"/>
	<script type="text/javascript">
		var viewForm = document.querySelector('#viewForm');
		
		// javascript Event 처리
		viewForm.addEventListener("submit", function(e) {
			e.preventDefault();  // 고유동작 없앰
			e.stopPropagation();  // 버블링 방지 이벤트가 연쇠적으로 일어나는 현상 방지
			
			console.log("submit!")
			// 유효성 검사
			
			viewForm.action = "/member/modify2"
			viewForm.method = "post"
			viewForm.submit();
			
		}) 
		
		
		function fnModify() {
			console.log("modify!");
		}
		
		// 회원 삭제
		$('#delete').click(function() {
			console.log("delete!");
			let isOK = confirm("${member.id}님 정보를 삭제하시겠습니다?")
			
			if (isOK){
				location.href="/member/remove2?id=${member.id}";
				
			} else {}
			
		})
		
		// 회원 목록
		function fnList() {
			console.log("list!");
			location.href="/member/list";
			
		}
	</script>
	
	
	
</body>
</html>