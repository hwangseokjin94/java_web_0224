<%@page import="bean.User"%>
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
		User user = (User) session.getAttribute("LOGIN_USER");
	%>
	<% if(user == null ){ %>
		<form action="Ex02_session2.jsp" method="post">
			아이디 <input type="text" name ="id"/> <br/><br/><br/>
			비밀번호<input type="password" name="pw"><br/><br/><br/>
			<input type="submit" value="로그인"/>	
		</form>
	<%}else{ %>
		<%=user.getId() %> 님 반갑습니다.
		<br/><br/>
		<input type="button" value="로그아웃" onclick="location.href='Ex02_session3.jsp'"/>
		<%} %>	
	
</body>
</html>