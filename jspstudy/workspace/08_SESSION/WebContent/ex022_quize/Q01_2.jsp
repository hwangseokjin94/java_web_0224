<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    	request.setCharacterEncoding("utf-8");
    	String ent =request.getParameter("ent");
    
    	session.setAttribute("ENT", ent);
    
    %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>좋아하는 운동선수 누구인가요</h1>
	<form action="Q01_3.jsp">
		<input type="text" name ="player" ><br/>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>