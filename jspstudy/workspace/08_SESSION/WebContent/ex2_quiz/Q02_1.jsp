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
		width: 200px;
	}
</style>
</head>
<body>
	<h1>신규 회원 정보를 입력하세요</h1>
	<form method="POST" action="Q02_2.jsp">
		<label for="label-id">아이디</label>
		<input type="text" name="id" id="label-id" /><br/>
		<label for="label-pw">비밀번호</label>
		<input type="password" name="pw" id="label-pw" /><br/>
		<label for="label-name">이름</label>
		<input type="text" name="name" id="label-name" /><br/>
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>










