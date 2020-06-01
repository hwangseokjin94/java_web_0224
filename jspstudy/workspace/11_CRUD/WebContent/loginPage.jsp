<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style type="text/css">
	div { margin: 0 auto; width: 70%; text-align: center; }
	table { margin: 0 auto; border-collapse: collapse; width: 400px; height: 150px; }
	table, td { border: 1px solid black;  padding: 10px; }
	td:nth-child(1) { width: 100px; }
	td:nth-child(2) { width: 300px; }
</style>
<script type="text/javascript">
	function login(f) {
		if (f.id.value == "") {
			alert("아이디를 입력하세요.");
			f.id.focus();
			return;
		}
		if (f.pw.value == "") {
			alert("비밀번호를 입력하세요.");
			f.pw.focus();
			return;
		}
		f.action = "login.jsp";
		f.submit();
	}
	function joinPage() {
		location.href = "joinPage.jsp";
	}
</script>
</head>
<body>
	<div>
		<h1>로그인</h1>
		<form method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" autofocus /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="로그인" onclick="login(this.form)" />
						<input type="button" value="회원가입" onclick="joinPage()" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>