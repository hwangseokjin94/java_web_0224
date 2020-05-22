<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.wrap{
border: 1px solid black;
height: 300px;
width: 700px;
padding: 10px 10px;
}
</style>
</head>
<body>
<div class="wrap">
	<h3>이동하고자하느 사이트 명을 선택하고 확인 버튼을 누르세요</h3>
	<form  action="/02_JSP/ex3_quiz/Q01_2.jsp">
	<!-- '/'슬래시가없으면 현재볼더로 인식함 .. -->
	사이트명 :
	<select name ="site">
		<option value="https://www.google.com">구글</option>
		<option value="https://www.naver.com">네이버</option>
		<option value="https://www.daum.net">다음</option>
		<option value="https://www.nate.com">네이트</option>
	</select>
	<input type ="submit" value="확인"/>
	</form>
</div>
</body>
</html>