<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	// 쿠키값에 공백, 콤마, 괄호 등이 포함되면
	// 반드시 인코딩(암호화)을 해서 저장한다.

	Cookie cookie = new Cookie("userName", URLEncoder.encode("제임스 본드", "utf-8"));
	cookie.setMaxAge(60 * 60 * 24);
	response.addCookie(cookie);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	쿠키이름: <%=cookie.getName() %><br/>
	
	<!-- 인코딩 된 쿠키값은 디코딩(복호화)해서 가져온다. -->
	쿠키값: <%=URLDecoder.decode(cookie.getValue(), "utf-8") %><br/>
	쿠키유효시간: <%=cookie.getMaxAge() %><br/>
	
</body>
</html>