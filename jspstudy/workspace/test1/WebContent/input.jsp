<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/test1/JSONHandler" method="post">
		
		성명<input type="text" name="name" placeholder="성명" /><br/>
		나이<input type="text" name="age" placeholder="나이" /><br/><br/>
		결혼여부 : <input type="radio" name="isMarried" value = "기혼">기혼
			<input type="radio" name="isMarried" value = "미혼">미혼	<br/><br/>
		
	
		<br/><br/>
		<input type="submit" value="전송" />
	</form>
</body>
</html>