<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% request.setCharacterEncoding("utf-8"); %>

<%
	String title1 = "New York!";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 포매팅</title>
</head>
<body>
	<h3>JSTL 포매팅 태그 라이브러리</h3>
	<hr>
	<c:set var="price" value="1000000"></c:set>
	<c:out value="${price}"/>
	<div>
		통화 표시: 
		<fmt:formatNumber value="${price}"
						type="currency"
						currencySymbol="$"
						groupingUsed="true"></fmt:formatNumber>
	</div>
	<div>
		<c:set var="price2" value="0.12"/>
		퍼센트 표시(.없애고 표시): 
		<fmt:formatNumber value="${price2}"
						type="percent"
						groupingUsed="false"></fmt:formatNumber>
	</div>
	<hr>
	<h2>formatDate</h2>
	<hr>
	<c:set var="now" value="<%=new Date()%>"/> <br>
	1. <c:out value="${now}"/> <br>  <!-- 기본형식으로 날짜가 나옴 -->
	2. <fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>  <!-- 날짜 -->
	3. <fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
	4. <fmt:formatDate value="${now}" type="time"/><br>  <!-- 시간 -->
	5. <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>  <!-- 날짜,시간 둘 다 나옴 -->
	6. <fmt:formatDate value="${now}" type="both" pattern="YYYY-MM-dd :hh:mm:ss"/><br>
	<hr>
	한국 현재 시간: <br>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
	뉴욕 현재 시간: <br>
	<fmt:timeZone value="America/New York">
		<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
	</fmt:timeZone>
	<hr>
	<h2>문자열 처리</h2>
	<hr>
	<c:set var="title1" value="<%=title1%>"></c:set>
	<c:set var="title2" value="쇼핑몰 중심 도시"></c:set>
	<c:set var="str1" value="중심"/> <br>
	title1 <c:out value="${title1}"/> <br>
	<c:out value="${title2}"/> <br>
	<div>
		1. ${fn:length(title1)} <br>	  <!-- 길이 -->
		2. ${fn:toUpperCase(title1)} <br>  <!-- 대문자로 -->
		3. ${fn:toLowerCase(title1)} <br>  <!-- 소문자로 -->
		4. ${fn:substring(title1, 3, 6)} <br>  <!-- 3번째부터 6번째까지 자름 -->
		5. ${fn:trim(title1)} <br> <!-- 양옆 공백 자름 -->
		6. ${fn:replace(title1," ", "공백!")} <br> <!-- ""안에 있는걸 다른걸로 대체 -->
		7. ${fn:contains(title1,"e")} <br>  <!-- 포함여부 -->
		8. ${fn:contains(title2, str1)} <br>  <!-- 문자열도 됨 -->
		9. ${fn:indexOf(title1,"Y")} <br>  <!-- 인덱스 표시 -->
	</div>
</body>
</html>