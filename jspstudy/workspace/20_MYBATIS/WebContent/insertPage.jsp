<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/20_MYBATIS/insert.do">
		<label>제목</label>
		<input type="text" name = "title"/><br/><br/>
		<label>내용</label><br/>
		<textarea name = "content" rows="3" cols="50"></textarea><br/><br/>
		<input type="submit" value="작성"/>
	</form>
</body>
</html>