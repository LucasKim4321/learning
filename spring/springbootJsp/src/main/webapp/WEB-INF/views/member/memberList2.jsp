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
		<h1> 회원 목록 조회</h1>
		<div>
		<!-- 검색 기능 -->
		<form action="/member/list2" method="get" id="searchForm">
			<div class="row">
				<div class="col-10"><input type="text" class="w-100" id="search" name="search"></div>
				<div class="col"><button type="submit" class="btn btn-outline-success">Search</button></div>
				<div class="col"><button type="reset" class="btn btn-outline-warning">Clear</button></div>
				<div><input type="hidden" name="page" id="page" value="1"></div>
			</div>
		</form>
		
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
			    <tr>
			      <th>${member.recnum}</th> <!--  MemberVO랑 MemberDTO에 추가로 recnum 변수 선언-->
			      <td scope="row"><a class="link" href="/member/view?id=${member.id}">${member.id}</a></td>
			      <td>${member.id}</td>
			      <td>${member.name}</td>
			      <td>${member.email}</td>
			      <td><fmt:formatDate value="${member.joindate}" pattern="yyyy/MM/dd"/></td>
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
		location.href="/member/registerMember"
	}
	
</script>

<jsp:include page="/include/bs_footer.jsp"/>
<script type="text/javascript">

	$('.pagination a').click(function(e) {
		
		e.preventDefault();
		let page_num = $(this).attr('data-num');  // .attr(속성) 속성 값을 불러옴
		
		console.log("클릭한 페이지: "+page_num);
		
		if (${pageResponseDTO.page} != page_num) {
			// 매개변수로 전달시
			location.href="/member/list2?page="+page_num;
			
			// 객체로 전달시
			// const formObj = document.querySelector("#searchForm") // 여러개 있을때 id를 지정해서 불러옴
			// const formObj = document.querySelector("form") // 한개 있을때 이렇게 해도 상관없음
			
			
			// jQuery
			//const formObj = $('#searchForm');
			// formObj.html('<div><input type="hidden" name="page" id="page" value="'+page_num+'"></div>');
			//formObj.html() += '<div><input type="hidden" name="page" id="page" value="'+page_num+'"></div>';
			
			let page = $('#page');
			page.attr('value') = page_num;
			
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




	
</body>
</html>
