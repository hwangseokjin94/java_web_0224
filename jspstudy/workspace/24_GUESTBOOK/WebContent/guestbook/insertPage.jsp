<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel= "stylesheet" type="text/css" href="co.css">
<style type="text/css">
h1{

color: red;
}
</style>
</head>
<body>
<div class="wrap">
		<h1>방명록작성</h1>
		<form action="/24_GUESTBOOK/insert.guest" method="POST" enctype="multipart/form-data">			
			<table>
				<tbody>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title"/></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer"/></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="email"/></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pw"/></td>
					</tr>
					<tr>
						<td>파일</td>
						<td><input type="file" name="filename"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea  name="content" rows="10" cols="60" placeholder="내용"></textarea>
						</td>					
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="저장하기"/>
							<input type="reset" value="다시작성하기"/>
							<input type="button" value="목록으로 이동하기" onclick="location.href='/24_GUESTBOOK/listPage.guest'"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form>	
	</div>
</body>
</html>