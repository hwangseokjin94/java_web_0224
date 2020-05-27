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
	%>
	
	<h1>결과 확인</h1>
	<h3><%=session.getAttribute("NAME") %>님의 선호도 조사</h3>
	<ul>
		<li>좋아하는 연예인 : <%=session.getAttribute("ENTERTAINER") %></li>
		<li>좋아하는 운동선수 : <%=session.getAttribute("PLAYER") %></li>
		<!--변수에넣지않고 바로보여주기식이여서 캐시팅안해도됨  -->
		
		<br/><br/><br/>
	</ul>
		<input type="button" value="처음부터 다시하기" onclick="location.href='Q01_1.jsp'">

</body>
</html>











