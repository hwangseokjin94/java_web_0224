<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	String id = request.getParameter("id");
 	String pw = request.getParameter("pw");
 	Cookie cookie = null;
   
 	cookie = new Cookie("savedID",id);
 	cookie = new Cookie("savedPW",pw);
	cookie.setMaxAge(60 * 60 *24); //유효시간 :1일
    response.addCookie(cookie);
 
 %>   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연락처를 입력하십시요</h1>
	<form action="/07_COOKIE/Q07_3.jsp">
	주소 : <input type="text" name= "address"><br/><br/>
	전화번호 : <input type="text" name= "phone"><br/><br/>
	이메일 <input type="text" name= "email"><br/><br/>
	<input type="submit" value="확인"><br/><br/><br/>
	
	
	
	</form>



</body>
</html>