<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--1. request 영역에 변수 선언하기  -->
	<!-- request.setAttribute()의 ㅐㄷ체 방식 -->
	<c:set var = "name" value = "앨리스" scope="request"/>
	<c:set var = "age" value = "20" scope="request"/>
	<c:set var ="phone" value = "010-1111-1234" scope="request"/>
	
	<!--2. request를 전달하는 포어드  -->
	<!--  -->
	<jsp:forward page="Ex02_jstl2.jsp"/>
	
</body>
</html>