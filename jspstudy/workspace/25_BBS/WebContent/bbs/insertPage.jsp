<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	.wrap {
		width: 760px;
		margin: auto;
	}
	.wrap table {
		width: 500px;
		margin: auto;
		border-collapse: collapse;
	}
	th, td {
		border: 1px solid black;
		padding: 3px 5px;
	}
	input[type=text], input[type=password] {
		width: 100%;
		padding: 5px;
		border: 1px solid gray;
	}
	input[type=submit], input[type=reset], input[type=button] {
		padding: 5px;
	}
	textarea {
		width: 100%;
		padding: 5px;
	}
	.centered {
		text-align: center;
	}
	.title {
		margin: 10px 0;
	}
</style>
</head>
<body>
	<div class="wrap">
		<h1 class="centered title">BBS 작성</h1>
		<form action="/25_BBS/insert.bbs" method="POST" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<td>제목</td>
						<td><input type="text" name="bTitle" /></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="bWriter" /></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="bPw" /></td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td><input type="file" name="bFilename" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea name="bContent" rows="10" cols="60" placeholder="내용"></textarea>
						</td>
					</tr>
					<tr class="centered">
						<td colspan="2">
							<input type="submit" value="저장하기" />
							<input type="reset" value="다시작성하기" />
							<input type="button" value="목록으로이동하기" onclick="location.href='/25_BBS/listPage.bbs'" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>