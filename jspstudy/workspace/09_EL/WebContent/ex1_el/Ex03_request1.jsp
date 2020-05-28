<%@page import="org.apache.catalina.ha.backend.Sender"%>
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
		int a =  100;
	
		//request 영역에    "속성"   a를 저장한다.   
		//"파라미터"러 취급하면 안된다.
 		request.setAttribute("a", a);
	
		//request를 Ex03_request2.jsp 로 넘그는 코드를 작성해보자
		// request를 넘기는 이동은 foward이다.
		request.getRequestDispatcher("Ex03_request2.jsp").forward(request, response);
		
		
	%>






</body>
</html>