<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
td{
	border: 1px solid black;
}
</style>
<title>Insert title here</title>

</head>
<body>
<h1>로그인</h1>
<form action=login.jsp>
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pw"></td>
	</tr>
	<tr >
		<td colspan="2" >
		<input type="submit"value="로그인" />
		<input type="button"value="회원가입" onclick="location.href='joinPage.jsp'" />
		</td>		
	</tr>
</table>
</form>
</body>
</html>