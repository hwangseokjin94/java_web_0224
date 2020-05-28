<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
 <form action = "Ex04_parameter2.jsp">
 	  
 	  작성자 <input type = "text" name="writer"/><br/> 	
 	  
 	  취미를  선택하세요<br/><br/>
 	 <input type = "checkbox" name="hobbies" value="fitness"/>운동 	
 	 <input type = "checkbox" name="hobbies" value="fishing"/>낚시 	
 	 <input type = "checkbox" name="hobbies" value="shower"/>목욕 	
 	 <input type = "checkbox" name="hobbies" value="game"/>게임 	
 	 <input type = "checkbox" name="hobbies" value="music"/>음악<br/>
 	 
 	 <input type="submit" value="전송"/> 	
 </form>
 
 
</body>
</html>