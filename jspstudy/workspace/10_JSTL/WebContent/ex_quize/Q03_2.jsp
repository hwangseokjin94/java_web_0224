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
<h3>일반 forEach연습</h3>
<c:forEach var="n" begin="${param.start}" end= "${param.end}" step="1">
<font size="${n}">폰트사이즈${n }<br/></font>
</c:forEach>

<hr/>
<h3>향상 forEach연습</h3>
<ul>

<c:forEach var="food" varStatus="f" items="${paramValues.food }">
	<li>${f.count}번째 음식 :${food }</li>
</c:forEach>

</ul>

</body>
</html>