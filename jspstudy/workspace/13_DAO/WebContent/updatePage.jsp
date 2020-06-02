<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_update(f) {
		f.action = 'update.jsp';
		f.submit();
	}
</script>
</head>
<body>
		<%request.setCharacterEncoding("utf-8");%>   
	<form>
		<table>
			<thead>
				<tr>
					<td colspan="2">${param.id }님 정보수정</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>성명</td>
					<td><input type="text" name="name" value="${param.name }"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age" value="${param.age }"/></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" value= "${param.email }"/></td>
				</tr>				
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
					
					<input type="hidden" name="id" value="${param.id }"/>
					<input type="button" value="회원정보수정" onclick="fn_update(this.form)"/>
					<input type="button" value="수정취소하기" onclick="history.go(-2)"/><!-- view로감 location.href를이용하면 아이디를 붙여아함 -->
					</td>					 
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>