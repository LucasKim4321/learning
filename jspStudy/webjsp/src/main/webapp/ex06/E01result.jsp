<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<c:set var="file1" value="${param.param1}"/>
<c:set var="file2" value="${param.param2}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload Form</title>
<%@ include file="/include/bootstrap_include.jsp" %>
</head>
<body>
	<div class="container">
		
		<div>매개변수1: <c:out value="${file1}"/> </div>
		<div>매개변수1: <c:out value="${file2}"/> </div>
		
		<c:if test="${not empty file1}">
			<!-- 서버에 이미지 다운로드 요청하여 이미지를 화면에 표시 -->
			<img src="${ctx}/download.do?fileName=${file1}" width=300 height=300/>
		</c:if>
		<c:if test="${not empty file2}">
			<img src="${ctx}/download.do?fileName=${file2}" width=300 height=300/>
		</c:if>
		
		<div>파일 내려받기</div>
		<a href="${ctx}/download.do?fileName=${file1}">이미지 다운로드1</a>
		<a href="${ctx}/download.do?fileName=${file2}">이미지 다운로드2</a>
		
	</div>
</body>
</html>