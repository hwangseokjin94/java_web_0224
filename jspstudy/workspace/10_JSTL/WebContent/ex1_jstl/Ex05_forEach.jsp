<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>일반 for문 으로 사용</h3>
	<c:forEach var="n" begin="1" end ="10" step="1">
		${n}<br/>
	</c:forEach>
	
	<h3>향상된 for문으로 사용</h3>
</body>
</html>