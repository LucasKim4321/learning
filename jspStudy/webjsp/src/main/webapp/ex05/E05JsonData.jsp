<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON DATA</title>
<%@ include file="/include/bootstrap_include.jsp" %>
</head>
<body>
	<div class="container">
		<h1>JSON DATA TEST</h1>
		<div>
			<a href ="#" id="checkJson" class="link-underline-warning">JSON Data 보내기</a>
		</div>
		<div id="output" class="alert alert-danger m-3">
		</div>
		<div>
			<a href ="#" id="checkJson2" class="link-underline-warning">JSON Data 보내기2</a>
		</div>
		<div id="output2" class="alert alert-danger m-3">
		</div>
		<div>
			<a href ="#" id="checkJson3" class="link-underline-warning">JSON Data 보내기3</a>
		</div>
		<div id="output3" class="alert alert-danger m-3">
		</div>
		<div>
			<a href ="#" id="checkJson4" class="link-underline-warning">Ajax 서버와 JSON Data 주고받기</a>
		</div>
		<div id="output4" class="alert alert-danger m-3">
		</div>
	</div>
	
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		$(function(){  // jquery 로딩이 끝난 후 function문 실행
			
			$('#checkJson').click(function(){
				console.log("hi")
				
				var jsonStr= '{"name":["홍길동","이순신","동길이"]}'
				
				/* 
				JSON DATA 구조 {"name":["홍길동","이순신","동길이"]}
				console.log(jsonStr)
				console.log(jsonStr.name)
				console.log(jsonStr.name[0]) */
				
				console.log(jsonStr)
				let jsonInfo = JSON.parse(jsonStr);  // JSON구조의 문자형 -> JSON자료형
				console.log(jsonInfo)
				
				output = "======<br>"  // 변수 종류 var let 이런거 안해도 자동으로 인식 하는듯
				for(let idx in jsonInfo.name) {
					output += jsonInfo.name[idx]+"<br>"
				}
				console.log(output);  // 문자열
				$('#output').html(output)  // HTML 구조형식인 문자열 => HTML객체로 전환
				
				
			})
			
		})
		
		$(function() {
			
			$('#checkJson2').click(function() {
				console.log('say hi~')
				
				var jsonStr = '{"name":"홍길동", "age":10, "gender":"남자", "nickname":"돌이"}'
				console.log("jsonStr: "+jsonStr)
				
				// 문자열 -> JSON객체 전환
				var jsonObj = JSON.parse(jsonStr);
				console.log("jsonObj: "+jsonObj)  // 배열 상태(JSON객체)
				
				// JSON객체 -> 문자열
				var jsonStr2 = JSON.stringify(jsonObj)
				console.log("jsonStr2: "+jsonStr2)  // 문자열 상태
				
				var output = "----------<br>"
				output += "이름: "+jsonObj.name +"<br>";
				output += "나이: "+jsonObj.age +"<br>";
				output += "성별: "+jsonObj.gender +"<br>";
				output += "별명: "+jsonObj.nickname +"<br>";
				console.log("output: "+output)
				
				$('#output2').html(output)
			})
			
			$('#checkJson3').click(function() {
				var jsonInfoArray = {
					member: [
						{name:"홍길동", age:10, gender:"남자", nickname:"돌이"},
						{name:"동순이", age:11, gender:"여자", nickname:"순동이"},
						{name:"길순이", age:12, gender:"여자", nickname:"길순"}
					]
				}
				console.log("jsonInfoArray: "+jsonInfoArray)  // JSON객체
				console.log(jsonInfoArray.member[0].name,jsonInfoArray.member[0].age,jsonInfoArray.member[0].gender,jsonInfoArray.member[0].nickname)
				console.log(jsonInfoArray.member[1].age)
				
				var jsonArrayStr = JSON.stringify(jsonInfoArray)
				console.log("jsonArrayStr: "+jsonArrayStr)
				
				var jsonObjArray = JSON.parse(jsonArrayStr);  // 문자열 -> JSON객체
				console.log("jsonObjArray: "+jsonObjArray)
				
				$('#output3').html(jsonArrayStr)
				
			})
			
			$('#checkJson4').click(function() {

				var _jsonInfoArray = {
					member: [
						{name:"홍길동", age:10, gender:"남자", nickname:"돌이"},
						{name:"동순이", age:11, gender:"여자", nickname:"순동이"},
						{name:"길순이", age:12, gender:"여자", nickname:"길순"}
					]
				}
				
				$.ajax({
					type:"post",
					url: "/webjsp/json2",
					async: false,  // false 동기 true: 비동기(기본)
					data: {
						jsonInfoArray: JSON.stringify(_jsonInfoArray)
					},
					dataType : "text",  // 전송받을 데이터 형식: json, xml, text, ....
					success: function(data, textStatus) {
						console.log("success(정상처리)! :b")
						
						console.log("서버로 부터 받은 JSON객체 문자열")
						console.log(data);

						let jsonMembers = JSON.parse(data);
						console.log("jsonMembers.members: "+jsonMembers.members);

						let htmlout = `
							<table class="table">
								<thead>
									<tr>
										<th scope="col">이름</th>
										<th scope="col">나이</th>
										<th scope="col">성별</th>
										<th scope="col">별명</th>
									</tr>
								</thead>
								<tbody>
						`
						
						for (let i=0; i<jsonMembers.members.length;i++ ){
							
							htmlout+="<tr>";
							htmlout+="<td scope='row'>"+jsonMembers.members[i].name+"</td>"
							htmlout+="<td>"+jsonMembers.members[i].age+"</td>"
							htmlout+="<td>"+jsonMembers.members[i].gender+"</td>"
							htmlout+="<td>"+jsonMembers.members[i].nickname+"</td>"
							htmlout+="</tr>"
							
						}// outer for
						
						htmlout += `
								</tbody>
							</table>
						`
						console.log(htmlout);
						$('#output4').html(htmlout);
						
					},				
					error: function() {
						alert("에러 발생!  에러 발생!  에러 발생!")
					},
					complete: function(){ console.log("==============\n작업 완료!")}
				})
				
			})
			
		})
		
	</script>
	
	
</body>
</html>