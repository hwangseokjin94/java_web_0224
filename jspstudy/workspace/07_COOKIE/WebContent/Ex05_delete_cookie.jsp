<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 쿠키 삭제 과정
	// 유효시간이 0인 동일한 쿠키로 덮어쓰기한다.
	
	Cookie[] cookieList = request.getCookies();
	Cookie cookie = null;
	
	if ( cookieList != null && cookieList.length > 0 ) {
		for ( int i = 0; i < cookieList.length; i++ ) {
			if ( cookieList[i].getName().equals("userID") ) {
				cookie = new Cookie("userID", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	쿠키이름: <%=cookie.getName() %><br/>
	
</body>
</html>