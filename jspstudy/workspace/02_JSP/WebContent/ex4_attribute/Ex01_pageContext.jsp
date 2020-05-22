<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int a= 100;

	//현재 페이지에서만 사용할수 있는 속성 a를 생성하고 값 100을 저장한다.
	pageContext.setAttribute("a", a);
%>    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>표현식으로 확인 : <%=a %></h3>
	<h3>pageContext의 속성으로 확인 : <%=pageContext.getAttribute("a") %></h3>
	
	<%
		//int n =pageContext.getAttribute("a");
		//getAttribute 결과는 Object이므로 캐스팅 해야 한다.
		Integer n = (Integer)pageContext.getAttribute("a");  
	%>
	
</body>
</html>