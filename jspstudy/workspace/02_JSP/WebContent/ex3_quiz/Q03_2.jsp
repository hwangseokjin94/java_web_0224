<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 

	request.setCharacterEncoding("utf-8");
	String name1 = request.getParameter("name1");
   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/02_JSP/ex3_quiz/Q03_3.jsp">
		<h3>좋아하는 운동선수 누구인가요</h3>
		<input type="text" name="name2"/><br/>
		<input type="hidden" name="name1" value="<%=name1%>"/>
		<input type="submit" value="전달"/>
	
	
	</form>
</body>
</html>