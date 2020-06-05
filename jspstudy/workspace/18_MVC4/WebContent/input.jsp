<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/18_MVC4/HomeController">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"/></td>
			</tr>		
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" size="20"/></td>
			</tr>		
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" size="20"/></td>
			</tr>		
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" size="20"/></td>
			</tr>		
			<tr>
				<td>성별</td>
				<td>
				<label><input type="radio" name="gender" value="남"/>남</label>
				<label><input type="radio" name="gender" value="여"/>여</label>
				</td>
			</tr>		
			<tr>
				<td>자기소개</td>
				<td>
				<textarea rows="3" cols="50" name ="memo"></textarea>
				</td>
			</tr>		
			<tr>
				<td colspan="2">
					<input type="submit" value="전송"/>
				</td>
			</tr>
		</table>
	</form>
	<!--컨트롤러는 신호등하는 역활  -->
</body>
</html>