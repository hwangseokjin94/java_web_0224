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
	<h3>EL연산자를 이용해 큰값 찾기</h3>
	${param.a} 와${param.b}중에서 큰 값은 ${param.a - param.b gt 0 ?  param.a :param.b }이다
	
	<!--JSTL 의 if태그는 else 가없다.  -->
	<h3>JSTL을 이용해 큰값 찾기</h3>
 	<c:if test="${param.a - param.b gt 0 }">
 	${param.a} 와${param.b}중에서 큰 값은 ${  param.a} 이다<br/>
 	</c:if>
 	<c:if test="${param.a - param.b lt 0}">
 	${param.a} 와${param.b}중에서 큰 값은 ${  param.b} 이다<br/>
 	</c:if>
 	<c:if test="${param.a - param.b eq 0 }">
 	${param.a} 와${param.b}는같다 <br/>
 	</c:if>
 	
 	
</body>
</html>