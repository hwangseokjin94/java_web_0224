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
<c:set var="animals" value="사자,호랑이,사슴,곰"/>
<c:forTokens var="animal" items="${animals }" delims=",">
	${animal }<br/>
</c:forTokens>
</body>
</html>