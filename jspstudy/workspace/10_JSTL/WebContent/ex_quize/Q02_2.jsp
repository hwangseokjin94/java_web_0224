<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>성적처리결과</h3>
<ul>
	<c:set var="avg" value="${(param.kor+param.eng+param.mat)/3}"/>
	<li>국어${param.kor}점</li>
	<li>영어${param.eng}점</li>
	<li>수학${param.mat}점</li>
	<li>평균${avg}</li>
	<li>
	<c:choose>
		<c:when test="${avg ge 90 }">A학점</c:when>
		<c:when test="${avg ge 80 }">B학점</c:when>
		<c:when test="${avg ge 70 }">C학점</c:when>
		<c:when test="${avg ge 60 }">D학점</c:when>
		<c:otherwise>F학점</c:otherwise>
	</c:choose>
	</li>
	<li>
	<c:if test ="${avg ge 60 }">
		<c:set var = "pass" value="합격"/>		
	</c:if>
	<c:if test ="${avg lt 60 }">
		<c:set var = "pass" value="불합격"/>		
	</c:if>
	합격유무 :${pass }
	</li>

</ul>



</body>
</html>