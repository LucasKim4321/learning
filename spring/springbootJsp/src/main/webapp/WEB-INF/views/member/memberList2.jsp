<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/bs_header.jsp" %>
<%@ include file="/include/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.link {  
	 	text-decoration: none; /* 링크의 밑줄 제거 */ 
	 	color: inherit; /* 링크의 색상 제거 */
 	}
</style>
</head>
<body>
<!-- 인크루드 -->
<%-- <%@ include file="/include/taglib.jsp" %> --%>
<%-- <jsp:include page="/include/taglib.jsp"/> --%>
	<div class="container border">
		<h1 class="text-center"> 회원 목록 조회</h1>
		<%-- <div>pageResponseDTO: ${pageResponseDTO}</div>
		<hr>
		<div>pageRequestDTO: ${pageRequestDTO}</div> --%>
		<%-- <div>pageRequestDTO.link: ${pageRequestDTO.link}</div> --%>
		<div>
			<!-- 검색 기능 : PageRequestDTO객체 속성과 동일한 이름으로 매개변수 설정-->
			<!-- PageRequestDTO와 search form 매개변수 1:1 자동맵핑 => types, keyword, from , to -->
			<form action="/member/list2" method="get" id="searchForm">
				<!-- 검색 조건값 유지 -->
				<input type="hidden" name="types" value="">
				<div class="w-75 mx-auto">
					<div class="d-flex mb-2">
						<div class="form-check">
						  <input class="form-check-input" type="checkbox" value="i" id="searchId" name="types">  <%-- ${pageRequestDTO.checkType("i") ? "checked" : ""} --%>
						  <label class="form-check-label" for="searchId">
						   	아이디
						  </label>
						</div>
						<div class="form-check ms-2">
						  <input class="form-check-input" type="checkbox" value="n" id="searchName" name="types">  <%-- ${pageRequestDTO.checkType("n") ? "checked" : ""} --%>
						  <label class="form-check-label" for="searchName">
						    이름
						  </label>
						</div>
					</div>
					<div class="d-flex mb-3">
						<div class="w-50 me-2"><input class="form-control me-2" type="date" name="from"/></div>  <%-- value="${pageRequestDTO.from}" --%>
						<div class="w-50"><input class="form-control me-2" type="date" name="to"/></div>  <%-- value="${pageRequestDTO.to}" --%>
					</div>
					<div class="d-flex justify-content-center w-100">
						<div class="w-100"><input type="text" class="form-control w-100" id="search" name="keyword"></div>  <%-- value="${pageRequestDTO.keyword}" --%>
						<div><button type="submit" class="btn btn-outline-success ms-2">Search</button></div>
						<div><button type="reset" id="btnReset" class="btn btn-outline-warning ms-2">Clear</button></div>
						<div id="pageBox"><!-- <input type="hidden" name="page" value="1"> --></div>
					</div>
				</div>
			</form>
			
			<form id="link"><div id="pageBox2"><!-- <input type="hidden" name="page" value="1"> --></div></form>
		
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">No</th>
			      <th scope="col">ID</th>
			      <th scope="col">이름</th>
			      <th scope="col">이메일</th>
			      <th scope="col">등록일자</th>
			    </tr>
			  </thead>
			  <tbody>
			  <%-- start --%>
			  <c:forEach var="member" items="${pageResponseDTO.memberList}">
			  	${member.toLocaleDate()} <!-- sql.Date to LocalDate convert -->
			    <tr>
			      <th>${member.recnum}</th> <!--  MemberVO랑 MemberDTO에 추가로 recnum 변수 선언-->
			      <td scope="row">
			      	<!-- 현재 페이지 정보 유지: get방식 pageRequestDTO.link값을 적용 -->
			      	<a class="link" href="/member/view2?id=${member.id}&${pageRequestDTO.link}">${member.id}</a></td>
			      <td>${member.name}</td>
			      <td>${member.email}</td>
			      <td><fmt:formatDate value="${member.joindate}" pattern="yyyy/MM/dd"/>
			      	 => ${member.joinLocalDate} => ${member.joindate.toLocalDate()}
			      </td>
			    </tr>
		      </c:forEach>
			  </tbody>
			</table>
		</div>
		<div class="d-flex">
			<div>
				<button type="button" class="btn btn-outline-primary" onClick="register()">회원가입</button>
			</div>
			<div class="ms-auto">
				<nav aria-label="...">
				  <ul class="pagination">
				  
				  	<!-- 불러올 이전 페이지가 있으면 활성화 -->
				  	<c:if test="${pageResponseDTO.prev}">
					    <li class="page-item">
					      <a class="page-link" href="#" data-num="${pageResponseDTO.start-1}">Previous</a>
					    </li>
				    </c:if>
				    
				    <!-- 해당 블럭의 시작 페이지 번호와 마지막 번호   시작번호 1 끝번호 10-->
				    <c:forEach begin="${pageResponseDTO.start}" end="${pageResponseDTO.end}" var="i">
				   		<li class="page-item ${pageResponseDTO.page==i?'active':''}">
				    		<a class="page-link" href="#" data-num="${i}">${i}</a>
				    	</li>
				    </c:forEach>
				    
				    <!-- 불러올 다음 페이지가 있으면 활성화 -->
				    <c:if test="${pageResponseDTO.next}">
					    </li><li class="page-item">
					      <a class="page-link" href="#" data-num="${pageResponseDTO.end+1}">Next</a>
					    </li>
				    </c:if>
				    
				  </ul>
				</nav>
			</div>
		</div>
		
		<div id="a" class="border p-3">a
			<br><br><br>
			<div id="b" class="alert alert-success">b</div>
		</div>
		
	</div>
	
	
 	<div class="container">
		<%-- ${members} --%> <!-- model로 넘어온 값 읽음 -->
		<div>현재 페이지에 표시된 회원 정보: ${pageResponseDTO.memberList}</div>	
		<div>현재 페이지에 표시된 회원 정보 수: ${pageResponseDTO.memberList.size()}</div>
		<div>전체 회원 수: ${pageResponseDTO.total}</div>
	</div>
	
<script type="text/javascript">

	function register() {
		location.href="/member/registerMember2"
	}
	
	
</script>

<!-- 2. javascript 응용 -->
<script>

	
	document.querySelector(".pagination").addEventListener('click', (e)=> {
		e.preventDefault();  // 기본 이벤트 제거
		e.stopPropagation();  // 버블링 방지: 연쇄적인 이벤트 반응 방지
		console.log(e.target);
		
		const target = e.target; // 실제 이벤트가 발생 태그 요소의 객체 주소를 넘겨받음
		if (target.tagName !== 'A') return;
		
		const page_num = target.getAttribute('data-num');
		console.log(page_num);
		//console.log(`${page_num}`);  // 원래 javascript에서 쓰던 문법. jsp에서 안되는 듯. jsp문법으로 인식.
		
		// 기존 폼 사용
		/* const formObj = document.querySelector("#searchForm");
		const pageBox = document.querySelector("#pageBox");
		pageBox.innerHTML = '<input type="hidden" name="page" value="'+page_num+'">';
		formObj.submit(); */
		
		// 안보이는 폼 사용
		const link = document.querySelector("#link");
		const pageBox2 = document.querySelector("#pageBox2");
		link.action = "/member/list2";
		link.method = "get";
		pageBox2.innerHTML += '<input type="hidden" name="types" value="i" ${pageRequestDTO.checkType("i") ? "checked" : ""}>';
		pageBox2.innerHTML += '<input type="hidden" name="types" value="n" ${pageRequestDTO.checkType("n") ? "checked" : ""}>';
		pageBox2.innerHTML += '<input type="hidden" name="from" value="${pageRequestDTO.from}"/>';
		pageBox2.innerHTML += '<input type="hidden" name="to" value="${pageRequestDTO.to}" />';
		pageBox2.innerHTML += '<input type="hidden" name="keyword" value="${pageRequestDTO.keyword}">';
		pageBox2.innerHTML += '<input type="hidden" name="page" value="'+page_num+'">';
		link.submit();
		
	})

	
	/*
	// clear button : 검색 값 초기화
	const btnReset = document.querySelector('#btnReset').addEventListener('click', (e)=> {
		e.preventDefault();  // 기본 이벤트 제거
		e.stopPropagation();  // 버블링 방지: 연쇄적인 이벤트 반응 방지
		
		self.location = "/member/list2";  // list2페이지 재요청으로 초기화
		
	})
	*/
	
</script>

<!-- 1. jQuery 응용 -->
<%-- 
<jsp:include page="/include/bs_footer.jsp"/>
<script type="text/javascript">

	$('.pagination a').click(function(e) {
		
		e.preventDefault();
		let page_num = $(this).attr('data-num');  // .attr(속성) 속성 값을 불러옴
		
		console.log("클릭한 페이지: "+page_num);
		
		if (${pageResponseDTO.page} != page_num) {
			// 매개변수로 전달시
			// location.href="/member/list2?page="+page_num;
			
			// 객체로 전달시
			// const formObj = document.querySelector("#searchForm") // 여러개 있을때 id를 지정해서 불러옴
			// const formObj = document.querySelector("form") // 한개 있을때 이렇게 해도 상관없음
			
			
			// jQuery
			const formObj = $('#searchForm');
			const pageBox = $('#pageBox');
			pageBox.html('<input type="hidden" name="page" value="'+page_num+'">');
			
			formObj.submit();
			
		} else {
			console.log("현재 페이지랑 동일한 페이지 클릭")
		}
		
	})
	
	// a영역 안에 b영역이 있을때 stopPropagation이걸 해주지 않으면 
	// b영역 클릭시 a영역 클릭 동작도 일어남
	$('#a').click(function() {
		alert('a')
	})
	$('#b').click(function(e) {
		e.stopPropagation();
		alert('b')
	})
	
</script>
 --%>



	
</body>
</html>
