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
		String name = request.getParameter("name");
		String entertainer = request.getParameter("entertainer");
		
		session.setAttribute("NAME", name);
		session.setAttribute("ENTERTAINER", entertainer);
	%>
	
	<form action="Q01_3.jsp">
		<h4>2. 좋아하는 운동선수는 누구인가요?</h4>
		<input type="text" name="player" /><br/><br/>
		<input type="submit" value="제출" />
	</form>

</body>
</html>