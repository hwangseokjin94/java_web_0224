<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); 
	
	
	
/* 	request.setAttribute("NAME", name);
	request.setAttribute("NAME", name);
	request.setAttribute("NAME", name);
	request.setAttribute("NAME", name);
	request.setAttribute("NAME", name); */
%>

<h3>EL의 파라미터 처리방법</h3>
<ul>
	<li>이름 :${param.name }</li>
	<li>나이 :${param.age }</li>
	<li>성별 :${param.gender }</li>
	<li>취미 :${paramValues.hobbies[0] }
			 ${paramValues.hobbies[1] }
			 ${paramValues.hobbies[2] }
			 ${paramValues.hobbies[3] }
						</li>
	<li>주소 :${param.address }</li>
	<li>음식 :${paramValues.food[0] }
			${paramValues.food[1] }
			${paramValues.food[2] }
			${paramValues.food[3] }	
							</li>
</ul>



</body>
</html>