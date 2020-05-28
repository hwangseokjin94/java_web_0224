<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--1.uri JSTL의 core라이브러리를 사용하기 위한 taglib지시어작성  -->
<!--2.prefix :core 라이브러리의 태그는 c로시작한다.-->

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--1. 변수의 선언  -->
	<% int a = 7 ; %>
	<c:set var="a" value="7"/><!-- int a = 7; -->
	<c:set var="b" value="2"/><!-- int b = 2; -->
	<c:set var="result" value="${a+b }"/>
	
	<!--a b 페이지 선택 스코프..? 다른페이지로넘길떄 변경?  -->
	+ :  ${result }<br/>
	- :  ${a-b }<br/>
	* :  ${a*b }<br/>
	d iv: ${a div b }<br/>
	mod: ${a mod b }<br/>
	
	<!--2.변수의 출력  -->
	<c:out value="${a }"/>
	+	
	<c:out value="${b }"/>
	=
	<c:out value="${result }"/>
	
	
</body>
</html>