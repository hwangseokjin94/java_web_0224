<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link style="text/css" rel ="stylesheet" href="assets/style/common.css">
<script type="text/javascript">

	function fn_insert(f) {
		 if(f.id.value == ''){
			 alert("아이디는 필수이다.");
			 f.id.focus();
			 return;
		 }
		 if(f.pw.value == ''){
			 alert("비밀번호는 필수이다.");
			 f.pw.focus();
			 return;
		 }
		 if(f.name.value == ''){
			 alert("이름은 필수이다.");
			 f.name.focus();
			 return;
		 }
		 f.action ='/03_CRUD/insert.jsp';
		 f.submit()
	}
</script>
</head>
<body>

	<!-- 중요. DB테이블의 칼럼명 == input 태그의 name명 -->

	<div class="wrap">
		<form method ="post">
			<table>
				<thead>
					<tr>
						<th colspan="2">RED 회원 가입하기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id" autofocus /></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pw" /></td>
					</tr>
					<tr>
						<td>성명</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input type="text" name="age" /></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" name="address" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="가입하기" onclick="fn_insert(this.form)" />
							<input type="reset" value="다시작성하기"  />
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>