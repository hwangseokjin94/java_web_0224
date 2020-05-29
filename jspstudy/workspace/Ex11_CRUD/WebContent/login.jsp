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

String id =request.getParameter("id");
String pw =request.getParameter("pw");
session.setAttribute("ID", id);
session.setAttribute("PW", pw);
%>
<h3><%=id %>님 로그인성공.</h3>
<a href='manager.jsp?id="+<%=id %>+"'>관리자페이지로이동</a>
</body>
</html>