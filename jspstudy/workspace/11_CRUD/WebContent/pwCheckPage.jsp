<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	%>
	<div style="text-align: center;">
		<h1>회원정보 수정을 위해 비밀번호를 확인합니다.</h1>
		<form method="post">
			비밀번호 확인 <input type="password" name="pw" /> <br /><br />
			<input type="button" value="확인" onclick="pwCheck(this.form)" />
			<input type="button" value="수정 취소" onclick="location.href='view.jsp?id=<%=id %>'" />
			<input type="hidden" name="id" value="<%=id %>" />
		</form>
	</div>
	<script type="text/javascript">
		function pwCheck(f) {
			var pw = "<%=pw %>";
			if ( f.pw.value != pw ) {
				alert("비밀번호를 확인하세요.");
				f.pw.focus();
				return;
			}
			f.action = "updatePage.jsp";
			f.submit();
		}
	</script>
</body>
</html>