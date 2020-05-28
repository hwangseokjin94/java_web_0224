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
		int a =100 ;
	//현재 페이지에서 자바 변수를사용하렬면
	// pageContext영역에 올려서 사용한다.
	//pageContext에 저장된 속성은 EL 사용이 가능하다
	
	pageContext.setAttribute("a", a);

	
	%>
	
	표현식 :  <%=a %><br/>
	속성가져오기 :  <%=pageContext.getAttribute("a") %>
	표현 언어  :${a }<br/>
</body>
</html>