<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="now" value = "<%= new Date() %>"/>
	
	date: <fmt:formatDate value="${now}" type= "date"/><br/>
	time: <fmt:formatDate value="${now}" type= "time"/><br/>
	both: <fmt:formatDate value="${now}" type= "both"/><br/>
	
	<!--SimpleDateFormat  -->
	패턴:1 <fmt:formatDate value ="${now}" pattern = "yyyy년MM월dd일E요일"/><br/>
	패턴:2 <fmt:formatDate value ="${now}" pattern = "a hh:mm:ss"/><br/>
	패턴:3 <fmt:formatDate value ="${now}" pattern = "HH:mm:ss"/><br/>
</body>
</html>