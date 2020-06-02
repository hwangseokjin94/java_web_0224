<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style type="text/css">
	.wrap{
		width: 600px;
		margin: auto;
	}
	table {
		width: 600px;
		border-collapse: collapse;
	}
	td {
		border: 1px solid black;
		padding: 5px 10px;
	}
	td:nth-child(1) {width: 150px;	}
	td:nth-child(2) {width: 350px;}
	input[type=text],input[type=password]{
		width: 350px;
	}
	.centered{
		text-align: center;
	}
</style>
<script type="text/javascript">
	//var chk = false ;
	
	
	function fn_insert(f) {
		//if( chk ){			
			f.action = 'insert.jsp';
			f.submit();
	//	}else{
		//	alert('반드시 아이디 중복 체크를 진행하세요');
		//	f.idCheckBtn.focus();
		//}
		
	}
	function fn_idCheck(f) {
//		chk =true;
		f.action = 'idCheck.jsp'
		f.submit();
	}
</script>
</head>
<body>
	<div class = "wrap">
		<h1 class="centered">BLUE회원 가입 페이지</h1>
		<form method="post">
			<table>
				<tr>
					<td>아이디*</td>
					<td>		
						<%if (request.getParameter("id") == null) {%>
							<input type="text" name="id" autofocus />	
						<%}else{ %>				
							<input type="text" name="id" value="<%=request.getParameter("id") %>" autofocus />
							<%} %>	
						<input type="button" name="idCheckBtn" value="중복확인"  onclick="fn_idCheck(this.form)"/>
					</td>
				</tr>
				<tr>
					<td>비밀번호*</td>
					<td><input type="password" name="pw"/></td>
				</tr>
				<tr>
					<td>비밀번호 확인*</td>
					<td><input type="password" name="pw2"/></td>
				</tr>
				<tr>
					<td>성명*</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age"/></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email"/></td>
				</tr>
				<tr class = "centered">
					<td colspan="2">
						<input type="button" value="가입" onclick="fn_insert(this.form)" />&nbsp;&nbsp;
						<input type="reset" value="다시작성" />&nbsp;&nbsp;				
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>