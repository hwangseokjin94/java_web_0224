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
		//String a = request.getParameter("a"); //속성으로 넘어오기 떄문에 이건 안된다.
		int aa = (int)request.getAttribute("a");
		pageContext.setAttribute("aa", aa);
	%>
	
	EL : ${a} <br/><!--request에 올라갔기떄문에 쓸수있다  -->
	EL :${requestScope.a }<br/>
	
	EL :${aa }<br/>
	EL :${pageScope.aa }<br/>
	
</body>
</html>