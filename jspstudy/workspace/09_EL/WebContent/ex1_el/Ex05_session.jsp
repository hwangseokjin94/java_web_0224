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
		session.setAttribute("NAME", "제임스");
		session.setAttribute("AGE", 20);
		
	%>
	 세션이 설정되었습니다 <br/><br/>
	 NAME :  ${NAME}<br/>
	 AGE :  ${AGE }<br/>

	 NAME :  ${sessionScope.NAME}<br/>
	 AGE :  ${sessionScope.AGE }<br/>
</body>
</html>