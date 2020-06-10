<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/23_JSON/login.do">
		<h3>로그인</h3>
		<input type="text" name="id" placeholder="아이디" /><br/>
		<input type="password" name="pw" placeholder="비밀번호" /><br/><br/>
		아래 이미지를 보이는 대로 입력해주세요.<br/>
		<img src="${DIRECTORY }/${filename }"  style="width: 200px;"/>
		<input id="img_load" type="button" value="이미지 새로고침" onclick="location.href='/23_JSON/getImage.do'" /><br/>
		<input type="text" name="input_key" required />
		<br/><br/>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>