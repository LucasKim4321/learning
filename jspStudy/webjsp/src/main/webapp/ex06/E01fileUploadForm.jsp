<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload Form</title>
<%@ include file="/include/bootstrap_include.jsp" %>
</head>
<body>
	<div class="container">
		<h1>File Upload Form</h1>
		<form action="/webjsp/upload.do" method="post" enctype="multipart/form-data">
		
			<div class="mb-3">
				<label for="formFile1" class="form-label">파일1</label>
				<input class="form-control" type="file" name="file1" id="formFile1">
			</div>
			<div class="mb-3">
				<label for="formFile2" class="form-label">파일2</label>
				<input class="form-control" type="file" name="file2" id="formFile2"></div>
				
			<div>매개변수1: <input class="form-control" type="text" name="param1"></div>
			<div>매개변수2: <input class="form-control" type="text" name="param2"></div>
			<div>매개변수3: <input class="form-control" type="text" name="param3"></div>
			<div>매개변수4: <input class="form-control" type="text" name="param4"></div>
			
			<div class="mt-4"><input class="form-control" type="submit">업로드</div>
		</form>
	</div>
</body>
</html>