<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
	아이디<input type="text" name="mId"/> <br/>
	이름<input type="text" name="mName"/> <br/>
	<input type="submit" value="가입하기"/>
	<input type="button" value="전체목록보기" onclick="location.href='listPage'"/>
	</form>
	
</body>
</html>