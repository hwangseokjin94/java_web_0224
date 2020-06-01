<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style type="text/css">
	div { 
		width: 500px;
		margin: auto;
	}
	table {
		width: 500px;
		border-collapse: collapse;
	}
	td {
		border: 1px solid black;
		padding: 10px;
	}
	td:nth-child(1) {
		width: 150px;
	}
	td:nth-child(2) {
		width: 350px;
	}
</style>
<script type="text/javascript">
	function join(f) {
		if (f.id.value == "") {
			alert("아이디는 필수입니다.");
			f.id.focus();
			return;
		}
		if (f.pw.value == "") {
			alert("비밀번호는 필수입니다.");
			f.pw.focus();
			return;
		} else if (f.pw.value != f.pw2.value) {
			alert("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
			f.pw.focus();
			return;
		}
		if (f.name.value == "") {
			alert("성명은 필수입니다.");
			f.name.focus();
			return;
		}
		f.action = "join.jsp";
		f.submit();
	}
	function idcheck(f) {
		if (f.id.value == "") {
			alert("아이디를 입력한 뒤 확인하세요.");
			f.id.focus();
			return;
		}
		f.action = "idcheck.jsp";
		f.submit();
	}
</script>
</head>
<body>
	<div>
		<%
			request.setCharacterEncoding("utf-8");
			String useId = request.getParameter("useId"); // 아이디 중복 체크 후 사용 가능한 아이디면 전달되는 파라미터
		%>
		<h1 style="text-align: center;">회원 가입 페이지</h1>
		<form method="post">
			<table>
				<tr>
					<td>아이디*</td>
					<td>
						<% if ( useId == null ) { %>
							<input type="text" name="id" autofocus />
						<% } else { %>
							<input type="text" name="id" value="<%=useId %>" autofocus />
						<% } %>
						<input type="button" value="중복확인" onclick="idcheck(this.form)"/>
					</td>
				</tr>
				<tr>
					<td>비밀번호*</td>
					<td><input type="password" name="pw" /></td>
				</tr>
				<tr>
					<td>비밀번호 확인*</td>
					<td><input type="password" name="pw2" /></td>
				</tr>
				<tr>
					<td>성명*</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age" /></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center">
						<input type="button" value="가입" onclick="join(this.form)" />&nbsp;&nbsp;
						<input type="reset" value="취소" />&nbsp;&nbsp;
						<input type="button" value="로그인 하러 가기" onclick="location.href='loginPage.jsp'" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>