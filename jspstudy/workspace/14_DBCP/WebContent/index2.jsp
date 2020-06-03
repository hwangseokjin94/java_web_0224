<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${USER ne null }">
		${USER.name }님 반갑습니다.
		<button onclick = "location.href='logout.jsp'">로그아웃</button>
	</c:if>
	
	<c:if test="${USER eq null }">
		
		<button onclick = "location.href='logout.jsp'">로그인</button>
	</c:if>
	
	<c:if test="${USER.id eq 'admin' }">
		관리자메뉴
		<button onclick = "location.href='list.jsp'">회원관리</button>
	</c:if>
 
</body>
</html>