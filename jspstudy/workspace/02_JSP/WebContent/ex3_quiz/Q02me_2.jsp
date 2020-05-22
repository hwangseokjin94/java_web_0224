<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <%
    	request.setCharacterEncoding("utf-8");
    	String age =request.getParameter("age");
    	String message = "";
    	String yesno = "";
    	if(Integer.parseInt(age)>=20){
    		message+="당신의 나이는"+  age +"살 이므로 주류 구매가 가능 합니다.";
    		yesno +="성인";
    		    		
    	}else{
    		message+="당신의 나이는"+  age +"살 이므로 주류 구매가 불가능 합니다.";
    		yesno +="미성년자";
    	}
    	
  
    	// request.getRequestDispatcher("/02_JSP/ex3_quiz/Q02_1.jsp").forward(request, response);	
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=yesno %></h1>
	<div><%=message %></div>
	<a href="/02_JSP/ex3_quiz/Q02me_1.jsp"> 처음으로이동</a>
</body>
</html>