<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
label{
display:inline-block;
width: 100px;
}
</style>
</head>
<body>
 <form method="POST" action="Q03_2.jsp">
 <label>성명</label><input type="text" name="name"/><br/>
 <label>나이</label><input type="text" name="age"/><br/>
 <label>성별</label><input type="radio" name="gender" value="남"/>남
 					<input type="radio" name="gender" value="여"/>여<br/><br/>
 <label>취미</label><input type="checkbox" name="hobbies" value="운동"/>운동
 				   <input type="checkbox" name="hobbies" value="여행"/>여행
 				   <input type="checkbox" name="hobbies" value="영화"/>영화
 				   <input type="checkbox" name="hobbies" value="휴식"/>휴식<br/><br/>
 <label>주소</label><select name="address">
 						<option value="경기">경기</option>
 						<option value="경기">인천</option>
 						<option value="경기">서울</option>
 					</select><br/><br/>
 <label>좋아하는음식</label><select name="food" multiple>
 						<option value="짜장">짜장</option>
 						<option value="짬뽕">짬뽕</option>
 						<option value="볶음밥">볶음밥</option>
 						<option value="탕수육">탕수육</option>
 					</select><br/><br/>
 					
	<input type="submit" value="전송"/>
	 				   
 					
 
 </form>
</body>
</html>