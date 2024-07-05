<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제이쿼리 Ajax(비동기 처리)</title>
<%@ include file="/include/bootstrap_include.jsp" %>
</head>
<body>
	<div class="container border">
		<h1>제이쿼리 Ajax(비동기 처리)</h1>
		
		<div>
			<input type="button" class="btn btn-outline-danger" value="전송하기" onClick="fn_process()">
		</div>
		
		<div id="message" class="alert alert-primary m-3"> 응답 결과</div>
		
		<div>
			<input type="button" class="btn btn-outline-danger" value="json data 요청" onClick="fn_json_process2()">
		</div>
		
		<div id="message2" class="alert alert-primary m-3"> 응답 결과</div>
		
		
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>  <!-- 제이쿼리 최신버전 -->
		<script src=""></script>
		<script type="text/javascript">
		
			function fn_process() {
				// 제이쿼리 ajex
				
				$.ajax({
					type: "get",
					url: "/webjsp/ajaxTest",
					async: false, // false: 동기식, true: 비동기식(기본값으로 설정)
					data: { param: "Hello jQuery!!!" }, // 서버로 매개 변수와 값을 설정
					success: function(data, status) {  // 전송과 응답을 성공했을 경우 처리하는 함수
						console.log("서버로 부터 받은 응답 결과: ", data);
					$('#message').append("<div>"+data+"</div>")
					},
					error: function() {  // 실패할 경우 처리하는 함수
						console.log("에러가 발생!!!");
					},
					complete: function() {  // 작업 완료시 수행하는 작업
						console.log("작업 완료!!");
					}
					
				})
			}

			function fn_json_process2() {
				var data = {name:["홍길동", "동순이", "김길순"]}  // json
				console.log("json => "+data);
				// json data 보내기
				var jsonStr = '{"name":["홍길동", "동순이", "김길순"]}';
				var jsonInfo = JSON.parse(jsonStr);
				
				
				$.ajax({
					type: "post",
					url: "/webjsp/json",
					async: false, 	// false: 동기식, true: 비동기식(기본값으로 설정)
					data: { jsonInfo: jsonStr }, 	// 서버로 매개 변수와 값을 설정
					success: function(data, status) {  // 전송과 응답을 성공했을 경우 처리하는 함수
						console.log("서버로 부터 받은 응답 결과: ", data);
					$('#message2').append("<div>"+data+"</div>")
					},
					error: function() {  // 실패할 경우 처리하는 함수
						console.log("에러가 발생!!!");
					},
					complete: function() {  // 작업 완료시 수행하는 작업
						console.log("작업 완료!!");
					}
					
				})
			}
		</script>
	</div>
</body>
</html>

<!-- 
Ajax: 비동기 통신, 클라이언트와 서버 사이에 XML, JSON등 데이터를 주고 받는 기술
- 페이지를 이동하지 않고 데이터 처리가 가능, 서버의 처리를 기다리지 않음
 -->