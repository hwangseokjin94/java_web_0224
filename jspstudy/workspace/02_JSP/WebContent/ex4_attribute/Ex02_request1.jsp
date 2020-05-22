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
		// 1. request 에 속성 "a" 저장하기 : getAttribute("a")
		request.setAttribute("a", new Integer(200));
	
		request.getRequestDispatcher("Ex02_request2.jsp").forward(request, response);
	%>
	

	<form action="/02_JSP/ex4_attribute/Ex02_request2.jsp">
	
		<!-- 2. request 에 파라미터 "p" 저장하기 : getParameter("p") -->
		<input type="hidden" name="p" value="100" />
		<input type="submit" value="전송" />
		
	</form>


</body>
</html>