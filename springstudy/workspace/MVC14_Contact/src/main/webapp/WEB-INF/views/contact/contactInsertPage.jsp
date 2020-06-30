<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="contactInsert" method="post">
		<table>
			<tbody>
				<tr>
					<td>이름</td>
					<td><input type="text" name="cName" /></td>
				</tr>
				<tr>
					<td>전화</td>
					<td><input type="text" name="cPhone" /></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="cAddress" /></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="cEmail" /></td>
				</tr>
				<tr>
					<td>비고</td>
					<td><input type="text" name="cNote" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" value="새 연락처 등록하기" />
						<input type="reset" value="다시 작성하기" />
						<input type="button" value="전체 연락처 보기" onclick="location.href='contactListPage'" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>