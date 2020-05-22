<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page errorPage="Q04_error.jsp" %>

<%
	request.setCharacterEncoding("utf-8");

	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));
	int result = Integer.parseInt(request.getParameter("result"));
	String op = request.getParameter("op");
	
	int answer = 0;
	switch (op) {
	case "+" : answer = a + b;  break;
	case "-" : answer = a - b;  break;
	case "*" : answer = a * b;  break;
	case "/" : answer = a / b;  break;
	case "%" : answer = a % b;  break;
	}
	
	String message = "";
	if ( result == answer ) {
		message += a + op + b + "=" + result + "\n정답.";
	} else {
		message += a + op + b + "=" + result + "\n오답.";
	}	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=message %>
	<br/><br/>
	<a href="/02_JSP/ex3_quiz/Q04_1.jsp">다시풀기</a>

</body>
</html>
