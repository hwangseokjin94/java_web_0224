<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	if(session.getAttribute("NAME") != null ){
    		session.removeAttribute("NAME");
    	}
    	if(session.getAttribute("NAME") != null ){
    		session.removeAttribute("NAME");
    	}
    	if(session.getAttribute("NAME") != null ){
    		session.removeAttribute("NAME");
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>좋아하는 연예인이 누구인가요</h1>
	<form action="Q01_2.jsp" method="post">
		<input type="text" name ="ent" ><br/>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>