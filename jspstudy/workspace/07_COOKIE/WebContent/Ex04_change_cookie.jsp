<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Cookie[] ckList = request.getCookies();
	Cookie cookie = null;
	
	if ( ckList != null && ckList.length > 0 ) {
		for ( Cookie ck : ckList ) {
			if ( ck.getName().equals("userName") ) {
				cookie = new Cookie("userName", URLEncoder.encode("사만다 사이프리드", "utf-8"));
				cookie.setMaxAge(60 * 60 * 24 * 7);  // 일주일
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
	쿠키값: <%=URLDecoder.decode(cookie.getValue(), "utf-8") %><br/>
	쿠키유효시간: <%=cookie.getMaxAge() %>

</body>
</html>









