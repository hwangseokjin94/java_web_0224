<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int a = (int)(Math.random() * 10) + 1;
	int b = (int)(Math.random() * 10) + 1;
	int i = (int)(Math.random() * 5);
	String[] op = {"+", "-", "*", "/", "%"};
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>랜덤 계산기</h3>
	<form action="/02_JSP/ex3_quiz/Q04_2.jsp">
		<%=a %> <%=op[i] %> <%=b %> = <input type="text" name="result" size="3" />
		<input type="submit" value="제출" />
		
		<input type="hidden" name="a" value="<%=a %>" />
		<input type="hidden" name="b" value="<%=b %>" />
		<input type="hidden" name="op" value="<%=op[i] %>" />
	</form>
</body>
</html>