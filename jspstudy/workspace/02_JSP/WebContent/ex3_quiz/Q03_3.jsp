<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <%
    
    
    	request.setCharacterEncoding("utf-8");
     	String name1 = request.getParameter("name1");
     	String name2 = request.getParameter("name2");
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>좋아하는 연예인 : <%=name1 %></li>
		<li>좋아하는 운동선수 : <%=name2 %></li>
	</ul>
</body>
</html>