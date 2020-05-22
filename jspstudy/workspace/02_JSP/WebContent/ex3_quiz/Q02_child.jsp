<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// Q02_1.jsp -> Q02_2.jsp (forward) -> Q02_adult.jsp
	// forward 를 통한 이동은 서버 내부의 이동이므로, 사용자는 보이지 않는다.
	String age = request.getParameter("age");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>미성년자</h1>
	<div>당신의 나이는<%=age %>살이므로 주류 구매가 불가능합니다</div>
	<br/><br/>
	<a href ="/02_JSP/ex3_quiz/Q02_1.jsp">처음으로이동</a>
</body>
</html>