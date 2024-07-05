<%@page import="ex01.sam03.vo.MemberVO"%>
<%@page import="ex01.sam03.dao.MemberDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!-- taglib 디렉티브 -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--  taglib디렉티브   -->
 
<%
	String address = "부산";
	String ctxPath = request.getContextPath();
	
	// 데이터 List
	List dataList = new ArrayList();
	dataList.add("Hello");
	dataList.add("World!");
	dataList.add("안녕하세요?");
	
	// DAO
	List<MemberVO> listMember = new ArrayList();
	MemberDAOImpl dao = new MemberDAOImpl();
	listMember= dao.listMembers();
	
	System.out.println(listMember);
%>

<!-- 변수 -->
<c:set var="id" value="hong" scope="page"/>
<c:set var="name" value="홍길동" scope="page"/>
<c:set var="address" value="<%=address%>" scope="page"/>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- c:choose -->
<%-- 숫자타입 값을 설정 : ${숫자}형식으로 설정 --%>
<c:set var="score" value="${10}" scope="page"/>
<c:set var="score2" value="10" scope="page"/>
<c:set var="score3" value="${param.score3}" scope="page"/>

<!-- dataList 변수 set -->
<c:set var="list" value="<%=dataList%>"/>

<!-- DAO 데이터 List -->

<c:set var="listMember" value="<%=listMember %>" scope="page"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 표준 태그 라이브러리</title>
<%@ include file="/include/bootstrap_include.jsp" %>
</head>
<body>
	<h1>JSTL 표준 태그 라이브러리</h1>
	<hr>
	<div>
		아이디: ${id}
		이름: ${name}
		<c:set var="email" value="hong@gmail.com" scope="page"/>
		이메일: ${email}
		<hr>
		주소: ${address}, <%=address%> <br>
		<hr> 객체 해재 후 
		<c:remove var="address"/>
		주소: ${address}, <%=address%>
		<hr>
		contextPath: ${contextPath} or <%=ctxPath%>
		<hr>
		<h4>c:if</h4>
		<c:if test="${(id=='hong') && (name=='홍길동')}">
			<h3>아이디는 ${id}이고, 이름은 ${name}</h3>
		</c:if>
		<c:if test="${score==10}">
			<h3>score는 ${score}</h3>
		</c:if>
		<c:if test="${score2==10}">
			<h3>score2는 ${score2}</h3>
		</c:if>
		
		<c:choose>
			<c:when test="${score>10}">${score}는 10보다 크다</c:when>
			<c:when test="${score<10}">${score}는 10보다 작다</c:when>
			<c:when test="${score==10}">${score}는 10과 같다</c:when>
			<c:otherwise>
				${score}는 뭔지 모르겠다!
				값이 없는거 같다!
			</c:otherwise>
		</c:choose>
		<hr>
		EL형식 문자형 숫자 -> 숫자형으로 자동 전환  <br>
		score3: ${score3}  <br>
		score3+100: ${param.score3+100}  <br>
		<hr>
		<c:choose>
			<c:when test="${param.score3>10}">${param.score3}는 10보다 크다</c:when>
			<c:when test="${param.score3<10}">${param.score3}는 10보다 작다</c:when>
			<c:when test="${param.score3==10}">${param.score3}는 10과 같다</c:when>
			<c:otherwise>
				${param.score3} 뭔지 모르겠다!
				값이 없는거 같다!
			</c:otherwise>
		</c:choose>
		
		<hr>
		<h2>태그 요소를 반복 처리</h2>
		<hr>
		<div>
			<c:forEach var="i" begin="1" end="10" step="2" varStatus="loop">
				<div>
					반복횟수${loop.count}: <a href="webjsp/${i}/test${i}">${i}</a>
				</div>
			</c:forEach>
		</div>
		<hr>
		<h3>dataList</h3>
		<div>dataList: ${list} </div>
		<div>dataList: <%=dataList%> </div>
		<hr>
		<c:forEach var="data" items="${list}">
			<h3>${data}</h3>
		</c:forEach>
		<hr>
		<c:set var="fruits" value="사과, 파인애플, 바나나"/>
		<c:forTokens var="data" items="${fruits}" delims=",">
			<h3>${data}</h3>
		</c:forTokens>
		<hr>
		<table class="table table-striped table-danger">
			<tbody>
				<c:forEach var="data" items="${listMember}">
					<tr>
						<td>${data.id}</td>
						<td>${data.pwd}</td>
						<td>${data.name}</td>
						<td>${data.email}</td>
						<td>${data.joinDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<h3>c:url 적용 : 포워딩 방식 연결</h3>
		<%-- /webjsp/ex07/jst_url_result.jsp?id=param.id값?name=param.name값 --%>
		
		<c:url var="urlTest" value="/ex05/E02jstl_url_result.jsp">
			<c:param name="id2" 		value="${param.id}"></c:param>
			<c:param name="name2" 	value="${param.name}"></c:param>
		</c:url>
		<h5>먼저 ?id=kong&name=콩를 parameter값으로 쓰세요!</h5>
		<h2><a href="${urlTest}">JSTL에서 url을 이용하여 값 전달하기  </a></h2>
		<hr>
		<%-- 
		<h1>c:redirect 적용 (페이지를 로드할때 링크된게 대신 나옴(값이 전달된 상태))</h1>
		<c:redirect url="/ex05/E02jstl_url_result.jsp">
			<c:param name="id2" 		value="${param.id}"></c:param>
			<c:param name="name2" 	value="${param.name}"></c:param>
		</c:redirect>
		--%>
		<hr>
		<h3>parameter값 불러오기 c:out 적용</h3>
		<div>
			${param.id} ${param.name} <br>
			<c:out value="${param.id}" />
			<c:out value="${param.name}" />
		</div>
		<hr>
		<c:out value="&lt" escapeXml="true"/> <br><!-- true해서 출력 -->
		<c:out value="&lt" escapeXml="false"/> <!-- flase해서 출력 안함 대신 < 이게 뜸 -->
	</div>
</body>
</html>

<!--
JSTL : 스크립틀릿을 사용하지 않고 제어문 반복문 등 사용 가능 
 -->