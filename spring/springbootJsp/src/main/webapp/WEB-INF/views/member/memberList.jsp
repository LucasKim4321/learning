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
 	<div class="container">
		<%-- ${members} --%> <!-- model로 넘어온 값 읽음 -->
	</div>
	<div class="container border">
		<h1> 회원 목록 조회</h1>
		<div>
		
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">이름</th>
			      <th scope="col">이메일</th>
			      <th scope="col">등록일자</th>
			    </tr>
			  </thead>
			  <tbody>
			  <%-- start --%>
			  <c:forEach var="member" items="${members}">
			    <tr>
			      <th scope="row"><a class="link" href="/member/view?id=${member.id}">${member.id}</a></th>
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
				    <li class="page-item">
				      <a class="page-link" href="#">Previous</a>
				    </li>
				    <c:forEach begin="1" end="10" var="i">
				   		<li class="page-item">
				    		<a class="page-link" href="#">${i}</a>
				    	</li>
				    </c:forEach>
				    
				    </li><li class="page-item">
				      <a class="page-link" href="#">Next</a>
				    </li>
				  </ul>
				</nav>
			</div>
		</div>
	</div>
	
<script type="text/javascript">
	function register() {
		location.href="/member/registerMember"
	}
</script>


	
</body>
</html>
