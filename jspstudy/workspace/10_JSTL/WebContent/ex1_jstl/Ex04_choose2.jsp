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

	<c:choose>
		<c:when test="${param.age le 7 }"> 유치원생</c:when>
		<c:when test="${param.age le 13 }"> 초등학생</c:when>
		<c:when test="${param.age le 16 }"> 중학생</c:when>
		<c:when test="${param.age le 19 }"> 고등학생</c:when>
		<c:otherwise>성인</c:otherwise>
	</c:choose>
${test }
</body>
</html>