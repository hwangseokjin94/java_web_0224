<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH)+1;
	int day= calendar.get(calendar.DATE);
	


%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>현재 날짜는 <%=year %>년<%=month %>월<%=day %>일 입니다.</h1>
	
	<%@ include file="footer.jsp" %>
	
	
</body>
</html>