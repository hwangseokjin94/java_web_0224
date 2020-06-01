<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	label {
		display: inline-block;
		width: 100px;
	}
</style>
</head>
<body>
	<form method="POST" enctype="multipart/form-data" action="upload.jsp">
		<label for="lbl-uploader">업로더</label>
		<input type="text" name="uploader" id="lbl-uploader" /><br/>
		<label for="lbl-fileName">파일첨부</label>
		<input type="file" name="fileName" id="lbl-fileName" /><br/><br/>
		<input type="submit" value="업로드" />
	</form>
</body>
</html>


