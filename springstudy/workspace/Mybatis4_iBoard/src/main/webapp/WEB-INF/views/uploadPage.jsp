<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 function fn_singleUpload(f) {
	f.action='singleUpload';
	f.submit();
}
 function fn_multiUpload(f) {
	f.action='multiUpload';
	f.submit();
}

</script>
</head>
<body>
<!--파일 업로드를 하려면  -->

<form method="post" enctype="multipart/form-data">
	작성자<input type="text" name ="iWriter"/><br/>
	제목<input type="text" name ="iTitle"/><br/>
	<textarea name ="iContent" rows="5" cols="50"></textarea><br/>
	
	첨부파일<input type="file" name ="files" multiple="multiple"/><br/>
	
<!-- 	첨부파일#1<input type="file" name ="files" multiple="multiple"/><br/>
	첨부파일#2<input type="file" name ="files"/><br/>
 -->	<br/>
	<input type="button" value="업로드" onclick="fn_singleUpload(this.form)"/><br/>
	<input type="button" value="다중업로드" onclick="fn_multiUpload(this.form)"/><br/>
	
</form>

</body>
</html>