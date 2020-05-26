<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 쿠키 변경 과정
	// 1. 서버가 클라이언트의 쿠키를 모두 읽어 들인다. (request.getCookies())
	// 2. 변경하려는 쿠키를 찾는다. (for, equals)
	// 3. 같은 이름의 쿠키를 새로 만들어서 덮어쓰기한다. (response.addCookie())
	
	Cookie[] cookieList = request.getCookies();
		Cookie cookie = new Cookie("userID", "user1");
	
	if ( cookieList != null && cookieList.length > 0 ) {
		for ( int i = 0; i < cookieList.length; i++ ) {
			if ( cookieList[i].getName().equals("userID") ) {
				cookie.setMaxAge(60 * 60 * 24);
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
	쿠키값: <%=cookie.getValue() %><br/>
	쿠키유효시간: <%=cookie.getMaxAge() %><br/>

</body>
</html>






