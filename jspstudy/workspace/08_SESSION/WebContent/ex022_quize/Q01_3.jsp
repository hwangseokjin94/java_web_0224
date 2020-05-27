<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String player = request.getParameter("player");
	
	session.setAttribute("PLAYER", player);
	
	String ent = (String)session.getAttribute("ENT");
			player = (String)session.getAttribute("PLAYER");
%>
	좋아하는 연예인 : <%=ent %> <br/><br/>
	좋아하는 운동선수 : <%=player %><br/><br/>
	
<input type="button" value="처음으로" onclick="location.href='Q01_1.jsp'"/>


</body>
</html>