<%@page import="java.util.ArrayList"%>
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
		//ArrayList 에 좋아하는 음식3개를 저장하고,
		// Q01_2.jsp 로정보를 넘겨서 확인하세요.
		
		 ArrayList<String> list = new ArrayList<>();
		list.add("돈까스");
		list.add("피자");
		list.add("삼겹살");
			
		request.setAttribute("LIST", list);
	//	request.getRequestDispatcher("Q01_2.jsp").forward(request, response);
		
	%>
	
	<!-- 포워딩 태그 -->
	<jsp:forward page="Q01_2.jsp"/>

</body>
</html>