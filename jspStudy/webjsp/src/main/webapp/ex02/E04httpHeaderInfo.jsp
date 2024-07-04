<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Enumeration enu = request.getHeaderNames();

	while(enu.hasMoreElements()) {  // 값이 있는 동안
		String headerName = (String)enu.nextElement();
		System.out.println(headerName);  // 콘솔에 뜸
		System.out.println(request.getHeader(headerName));
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTTP 헤더 정보</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1></h1>
		<div>
			<table class="table table-danger table-striped">
				<tr>
					<th>HeaderName</th>
					<th>Values</th>
				</tr>
			<%
			Enumeration enu2 = request.getHeaderNames();  // 위에 값이 비워져있어서 다시 불러와야함
			while(enu2.hasMoreElements()) {  // 값이 있는 동안
				String headerName = (String)enu2.nextElement();%>
				<tr>
					<td><%=headerName%></td>
					<td><%=request.getHeader(headerName)%></td>
				</tr>
			<% } %>
			</table>
		</div>
	</div>
</body>
</html>