<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>추가정보를 입력하세요</h1>
	<form action="/07_COOKIE/Q07_4.jsp">
	생년월일 : <input type="text" name = "year"> 년
			<input type="text" name = "month"> 월
			<input type="text" name = "day"> 일<br/><br/>
	결혼여부 : <input type="radio" name="marry" value = "미혼">미혼
			<input type="radio" name="marry" value = "기혼">기혼	<br/><br/>	
	직업 :  <select name="job">
                        <option value="salaryman">회사원</option>
                        <option value="developer">개발자</option>
                        <option value="doctor">의사</option>
                        <option value="etc">기타</option>
           </select><br/><br/>
	<input type="submit" value="확인"><br/><br/><br/>
	
	
	
	</form>



</body>
</html>