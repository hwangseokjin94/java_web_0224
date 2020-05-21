<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//request 는 인코딩 먼저한다.
	request.setCharacterEncoding("utf-8");


	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String info = request.getParameter("info");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(info == null ){%>
		
		이름:<%=name %><br/>
		나이 :<%=age %><br/>
	<%} else{ %>
	  자기소개 :<%=info %><br/>
	<%} %>
	
</body>
</html>