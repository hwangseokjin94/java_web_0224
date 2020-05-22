<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("utf-8");

	// 1. setAttribute 로 저장한 속성 값 가져오기
	Integer a = (Integer) request.getAttribute("a");
	
	// 2. submit 으로 전달된 파라미터 값 가져오기
	// int p = Integer.parseInt(request.getParameter("p"));

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	a : <%=a %> <br/>
</body>
</html>