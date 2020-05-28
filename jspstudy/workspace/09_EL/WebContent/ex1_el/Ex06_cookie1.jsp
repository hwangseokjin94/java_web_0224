<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// 10 분간 유효한 이름과 나이를 쿠키에 저장세요ㅕ
		Cookie ck1 = new Cookie("NAME","애밀리");
		ck1.setMaxAge(60*10);
		response.addCookie(ck1);
		
		Cookie ck2 = new Cookie("AGE","20");
		ck2.setMaxAge(60*10);
		response.addCookie(ck2);
		
		response.sendRedirect("Ex06_cookie2.jsp");
	%>

</body>
</html>