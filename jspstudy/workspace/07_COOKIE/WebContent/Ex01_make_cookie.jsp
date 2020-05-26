<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	//1.쿠키 만들기 (서버가만듬)
	//Cookie cookie = new Cookie("쿠키이름" , 쿠키값);
    //cookie.setMaxAge(초); 쿠키의 유효기간
	Cookie cookie = new Cookie("userId","admin");
	cookie.setMaxAge(60 * 60 *24); //유효시간 :1일
	
	//2.쿠키저장하기 (브라우저 클라이언트 response)
	response.addCookie(cookie);
	
    

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	쿠키이름 :<%=cookie.getName() %><br/>
	쿠키값 : <%=cookie.getValue() %> 
	쿠키유효시간:<%=cookie.getMaxAge() %>
	
</body>
</html>